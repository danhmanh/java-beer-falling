package GameDemo;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;

import GameDemo.Game.STATE;

public class Level {
	
	private Handler handler ; 
	private HUD hud ; 
//	private int scoreKeep = 0 ;  
	private Random rnd = new Random() ; 
	
	
	public Level(Handler handler , HUD hud) {
		this.handler = handler ; 
		this.hud = hud ; 
	}
	public void tick() {
		
		if(Cart.countBeerCollision == 4) {
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2) {				
				handler.addObj(new BouncingBeer(rnd.nextInt(380), 30, ID.BouncingBeer));
				handler.addObj(new DangerBomb(rnd.nextInt(100), -120, ID.DangerBomb));
//				System.out.println(rnd.nextInt(200));
				
			} else if(hud.getLevel() == 3) {
				handler.addObj(new DangerBomb(100 + rnd.nextInt(100), -120, ID.DangerBomb));
			}
			
			
			else if(hud.getLevel() == 4) {
				handler.addObj(new Bomb(rnd.nextInt(380) , 20 , ID.Bomb));
				handler.addObj(new DangerBomb(300 + rnd.nextInt(50), -120, ID.DangerBomb));
//				System.out.println(rnd.nextInt(200));
			} else if(hud.getLevel() == 6) {
				handler.addObj(new BouncingBeer(rnd.nextInt(380), 30, ID.BouncingBeer)) ; 
				handler.addObj(new DangerBomb(rnd.nextInt(370), -100, ID.DangerBomb));
			} else if(hud.getLevel() == 10) {
				handler.addObj(new DangerBomb(rnd.nextInt(370), -200, ID.DangerBomb));
			}
			Cart.countBeerCollision = 0 ; 
		}
		
		if(Game.gameState == STATE.End) {
			Cart.countBeerCollision = 0 ; 
			Cart.countBeer = 0 ; 
			hud.setLevel(1);

		}
		
		
		
		if(hud.PERCENT == 0) {
			hud.PERCENT = 200 ; 
		}
		
		
	}
	
	
//	public void render(Graphics g) {
//		
//	}
}
