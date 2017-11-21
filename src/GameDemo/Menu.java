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
//		System.out.println(mx +" : " + my);
		if(mouseOver(mx, my, 140, 150, 300, 75) && Game.gameState == STATE.Menu) {
			game.gameState = STATE.Game  ; 
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
			
			hud.setScore(0); 
			hud.setLevel(1);
			
		}
		
		if(mouseOver(mx, my, 155, 370, 250, 50) && Game.gameState == STATE.End) {
			game.gameState = STATE.Menu ; 
		}
		
	}
	
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
//			g.setColor(Color.WHITE);
//			Font font = new Font("Calibri", 1, 50) ; 
//			g.setFont(font);
			
//			g.drawRect(140, 150, 300, 75);
//			g.drawString("Play", 240, 200);
			try {
				bf = ImageIO.read(new File("sprite/playbtn.jpg")) ;
				g.drawImage(bf, 140, 150, 300 , 75 , null) ; 
				bf = ImageIO.read(new File("sprite/helpbtn.jpg")) ;
				g.drawImage(bf, 140, 250, 300 , 75 , null) ; 
				bf = ImageIO.read(new File("sprite/exitbtn.jpg")) ;
				g.drawImage(bf, 140, 350, 300 , 75 , null) ; 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
//			g.drawRect(140, 250, 300, 75);
//			g.drawString("Help", 240, 300);
			
			
//			g.drawRect(140, 350, 300, 75);
//			g.drawString("Quit", 240, 400);
//		g.drawRect(140, 450, 300, 75);
			
		} else if(Game.gameState == STATE.Help) {
//			g.setColor(Color.WHITE);
//			g.drawRect(50, 50, 480, 480);
//			Font font = new Font("Calibri", 1, 50) ; 
//			g.setFont(font);
//			g.drawString("Dodge the bomb , get", 60, 100);
//			g.drawString( "the beers and unlock", 60, 170);
//			g.drawString("these kawaii girl :>", 60, 250);
//			g.drawString("EZAF", 230, 350);
//			
//			g.drawRect(400, 470, 120, 50);
			try {
				bf = ImageIO.read(new File("sprite/helppanel.jpg")) ;
				g.drawImage(bf , 50, 50, 480, 480 , null);
				bf = ImageIO.read(new File("sprite/backbtn.jpg")) ;
				g.drawImage(bf , 400, 470, 120, 50 , null);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
//			g.drawString("Back", 410, 510);
		} 
		else if(Game.gameState == STATE.End) {
			Font font = new Font("Calibri", 1, 50) ; 
			Font font2 = new Font("Calibri", 1, 30) ; 
			g.setColor(Color.PINK);
			g.drawRect(40, 50, 500, 400);
			g.fillRect(42, 52, 500, 400);
			
			g.setColor(Color.RED);
			g.setFont(font);
			g.drawString("Game Over", 160, 120);
			g.setFont(font2);
			g.drawString("Your score: " + hud.getScore() , 200, 200);
			
			try {
				bf = ImageIO.read(new File("sprite/trybtn.jpg")) ;
				g.drawImage(bf , 155, 300, 250, 50 , null);
				bf = ImageIO.read(new File("sprite/mainbtn.jpg")) ;
				g.drawImage(bf , 155, 370, 250, 50 , null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
//			g.setColor(Color.WHITE);
//			g.drawRect(155, 300, 250, 50);
//			g.drawString("Try Again", 220, 335);
//			g.drawRect(155, 370, 250, 50);
//			g.drawString("Main Menu", 210, 405);
			
		}
	}

	

}
