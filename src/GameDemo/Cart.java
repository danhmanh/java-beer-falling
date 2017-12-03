package GameDemo;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import GameDemo.Game.STATE;

public class Cart extends GameObject {
	Handler handler;
	private int sizeX = 100;
	private int sizeY = 70;
	private Random  rnd = new Random() ; 
	public static int countBeerCollision = 0 ;
	public static int countBeer = 0 ; 
	private BufferedImage bf ; 
	private HUD hud = new HUD() ; 

	public Cart(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;

		x = Game.clamp(x, 0, 300);
//		System.out.println(hud.getScore());
		collision();
	}
	
	public int getScore() {
		return hud.getScore() ; 
	}

	private void collision() {
		// TODO Auto-generated method stub
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Beer || tempObj.getId() == ID.BouncingBeer) {

				if (getBound().intersects(tempObj.getBound())) {
					countBeer ++ ; 
					countBeerCollision ++ ; 
					HUD.PERCENT -= 10;
//					HUD.score += 25;
					hud.setScore(hud.getScore() + 25);
					tempObj.setX(rnd.nextInt(370));
					tempObj.setY(-50);
				}
				else if (!getBound().intersects(tempObj.getBound()) && (tempObj.getY() + 50) >= Game.HEIGHT) {
					HUD.PERCENT = 200;
//					HUD.score = 0;
//					hud.setScore(0);
//					hud.setLevel(0);
					
					Game.gameState = STATE.End;
					hud.setScore(0);
					hud.setLevel(1);
					handler.removeAllObj();
				}


			} 
			if (tempObj.getId() == ID.Bomb) {
				if (getBound().intersects(tempObj.getBound())) {
					HUD.PERCENT = 200;
					handler.object.remove(tempObj) ; 
				}
			}
			
			if(tempObj.getId() == ID.DangerBomb && getBound().intersects(tempObj.getBound())) {
				HUD.PERCENT = 200;
				
//				countBeer = 0 ; 
//				HUD.score = 0;
//				hud.setScore(0);
				
				Game.gameState = STATE.End;
				handler.removeAllObj();
//				hud.setLevel(0);
			}
		}

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(Color.GREEN);
//		g.drawRect(x + 10, y + 10, sizeX - 20, sizeY - 30);
		try {
			bf = ImageIO.read(new File("sprite/cartfinal.png")) ;
			g.drawImage(bf, x, y, sizeX, sizeY, null) ; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(x + 10, y + 10, sizeX - 20, sizeY - 30);
	}

}
