package GameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bomb extends GameObject {
	private int sizeX =10 , sizeY = 10 ; 
	public Bomb(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velX = 1 ; 
		velY = 1 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX ; 
		y += velY ; 
		if(x <= 0 || x > 380) {
			velX = -velX ; 
		}
//		if(y <=0 || y >= Game.HEIGHT - 60) {
//			velY = -velY ; 
//		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, sizeX, sizeY);
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle(x , y , sizeX , sizeY);
	}

}
