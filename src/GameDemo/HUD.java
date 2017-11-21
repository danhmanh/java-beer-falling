package GameDemo;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static int PERCENT = 200 ; 
	public static int score = 0 ; 
	private int level = 1 ; 
	public void tick() {
//		PERCENT-- ;
		
		PERCENT = Game.clamp(PERCENT, 0, 200) ; 
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect(416, 150, 150, 400);
		g.setColor(Color.RED);
		g.fillRect(417, 151, 150, PERCENT * 2);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 450, 20);
		g.drawString("Level: "+ level ,450	 ,40 );
	}

	public void setLevel(int level) {
		this.level = level ; 
	}
	
	public int getLevel() {
		return level ; 
	}
	
}
