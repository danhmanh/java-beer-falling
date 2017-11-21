package GameDemo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {
	public final static int WIDTH = 600;
	public final static int HEIGHT = 600;
	private Random rnd ; 
	
	private Thread thread;
	private boolean running = false;
	private Handler handler ;
	private HUD hud ;
	private Level level ;
	private Menu menu ; 
	
	
	public enum STATE {
		Menu , Game , Help , End , Quit ,
	}
	
	
	public static STATE gameState = STATE.Menu ; 
	



	public Game() {
		rnd = new Random() ; 
		handler = new Handler() ; 
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new Menu(this, handler, hud));
		
		new Window(WIDTH, HEIGHT, "Sample", this);
		
		hud = new HUD() ; 
		level = new Level(handler , hud) ;
		menu = new Menu(this, handler, hud) ; 

		if(gameState == STATE.Game) {
//			handler.addObj(new Bomb(40, 40, ID.Bomb));
//			handler.addObj(new Beer(20, 0, ID.Beer));
//			handler.addObj(new Beer(rnd.nextInt(370), -120, ID.Beer));
//			handler.addObj(new Beer(rnd.nextInt(370), -240, ID.Beer));
//			handler.addObj(new Beer(rnd.nextInt(370), -360, ID.Beer));
//			handler.addObj(new Beer(rnd.nextInt(370), -480, ID.Beer));
//			handler.addObj(new Cart(20 ,510, ID.Cart , handler));
//			handler.addObj(new Beer(rnd.nextInt(370), 60, ID.Beer));
		}
		

		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.requestFocus();
//		running = true ; 
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				 System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop() ; 
	}

	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = this.getBufferStrategy() ; 
		if(bs == null) {
			this.createBufferStrategy(3);
			return ; 
		}
		
		Graphics g = bs.getDrawGraphics() ; 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if(gameState == STATE.Game) {
			g.setColor(Color.WHITE);
			g.fillRect(400, 0, 2, HEIGHT);
			hud.render(g);
			
		} else if (gameState == STATE.Menu || gameState == STATE.Help ||gameState == STATE.End) {
			menu.render(g);
		} 
		
		
		
		g.dispose();
		bs.show();
		
	}

	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			hud.tick();
			level.tick();	
		}
		
		
	}
	
	public static int clamp(int var , int min , int max) {
		if(var >= max) {
			return var = max ; 
		} else if(var <= min) {
			return var = min ; 
		} else return var  ; 
	}
	public static void main(String[] args) {
		Game game = new Game();
	}
}
