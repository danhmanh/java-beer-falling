package GameDemo;

import java.awt.Graphics;
import java.util.Random;

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
//				handler.addObj(new BouncingBeer(rnd.nextInt(380), 30, ID.BouncingBeer));
//				handler.addObj(new Bomb(rnd.nextInt(380) , 20 , ID.Bomb));
//				handler.addObj(new Bomb(rnd.nextInt(380) , -200 , ID.Bomb));
				
			} else if(hud.getLevel() == 3) {
//				handler.addObj(new Bomb(rnd.nextInt(380) , 20 , ID.Bomb));
			} else if(hud.getLevel() == 4) {
				
			}
			Cart.countBeerCollision = 0 ; 
		}
		
		
		
		if(hud.PERCENT == 0) {
			hud.PERCENT = 200 ; 
		}
		
		
	}
	
	
//	public void render(Graphics g) {
//		
//	}
}
