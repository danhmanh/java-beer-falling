package GameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Beer extends GameObject {
	Random rnd = new Random() ; 

	public Beer(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velX = 0 ; 
		velY = 5 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX ; 
		y += velY ; 
		
		if(y >= Game.HEIGHT) {
			x = rnd.nextInt(370) ;  
			y = -50 ; 
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 20, 40);
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle(x , y ,20 , 40);
	}

}
