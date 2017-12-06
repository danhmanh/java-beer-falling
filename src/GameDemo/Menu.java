package GameDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameDemo.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private BufferedImage bf ; 
	public Menu(Game game, Handler handler , HUD hud) {
		this.game = game ; 
		this.handler = handler ; 
		this.hud = hud ; 
	}
	
	public void tick() {
		
	}
	private boolean mouseOver(int mx , int my , int x , int y , int width , int height) {
		if(mx > x && mx < x + width && my > y && my < y + height) {
			return true ; 
		} else return false ; 
	}
	
	public void mousePressed(MouseEvent e) {
		hud  = new HUD()  ; 
		int my = e.getY() ; 
		int mx = e.getX() ; 

		if(mouseOver(mx, my, 140, 150, 300, 75) && Game.gameState == STATE.Menu) {
			game.gameState = STATE.Game  ; 
			hud.setLevel(1);
//			hud.setScore(0);
			handler.addObj(new Beer(20, 0, ID.Beer));
			handler.addObj(new Cart(20 ,500, ID.Cart , handler));
		}
		else if(mouseOver(mx, my, 140, 250, 300, 75) && Game.gameState == STATE.Menu) {
			game.gameState = STATE.Help ; 
		} else if(mouseOver(mx, my,140, 350, 300, 75) && Game.gameState == STATE.Menu) {
			System.exit(1);	
		}
		
		if(mouseOver(mx, my, 400, 470, 120, 50) && Game.gameState == STATE.Help) {
			game.gameState = STATE.Menu ; 
		}
		
		if(mouseOver(mx, my, 155, 300, 250, 50) && Game.gameState == STATE.End) {
			game.gameState = STATE.Game ; 
			handler.addObj(new Beer(20, 0, ID.Beer));
			handler.addObj(new Cart(20 ,500, ID.Cart , handler));		
			
//			hud.setScore(0); 
			hud.setLevel(1);
			Cart.countBeer = 0 ; 
			
		}
		
		if(mouseOver(mx, my, 155, 370, 250, 50) && Game.gameState == STATE.End) {
			game.gameState = STATE.Menu ; 
		}
		
	}
	
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {

			try {
				bf = ImageIO.read(new File("sprite/banner.png")) ;
				g.drawImage(bf, 100 , 50 ,395 ,49 , null) ; 
				
				bf = ImageIO.read(new File("sprite/playbtn.png")) ;
				g.drawImage(bf, 140, 150, 300 , 75 , null) ; 
				bf = ImageIO.read(new File("sprite/helpbtn.png")) ;
				g.drawImage(bf, 140, 250, 300 , 75 , null) ; 
				bf = ImageIO.read(new File("sprite/exitbtn.png")) ;
				g.drawImage(bf, 140, 350, 300 , 75 , null) ; 
			} catch (IOException e) {
				e.printStackTrace();
			} 

			
		} else if(Game.gameState == STATE.Help) {

			try {
				bf = ImageIO.read(new File("sprite/helppanel.png")) ;
				g.drawImage(bf , 50, 50, 480, 480 , null);
				bf = ImageIO.read(new File("sprite/backbtn.png")) ;
				g.drawImage(bf , 400, 470, 120, 50 , null);
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 
		else if(Game.gameState == STATE.End) {
			Font font2 = new Font("Consolas", 1, 30) ; 
			
			try {
				bf = ImageIO.read(new File("sprite/endpanel.png")) ;
				g.drawImage(bf , 40, 50, 500, 400 , null);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			g.setColor(Color.BLACK);
			g.setFont(font2);
			g.drawString("" + Cart.countBeer * 25 , 350, 215);
			
			try {
				bf = ImageIO.read(new File("sprite/trybtn.png")) ;
				g.drawImage(bf , 155, 300, 250, 50 , null);
				bf = ImageIO.read(new File("sprite/mainbtn.png")) ;
				g.drawImage(bf , 155, 370, 250, 50 , null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			
		}
	}

	

}
