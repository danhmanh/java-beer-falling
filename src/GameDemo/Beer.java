package GameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Beer extends GameObject {
	Random rnd = new Random() ; 
	private BufferedImage bf ; 
	private int sizeX = 20 ; 
	private int sizeY = 70 ; 

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
//		g.setColor(Color.WHITE);
//		g.fillRect(x, y, sizeX, sizeY);
		try {
			bf  =ImageIO.read(new File("sprite/beer.gif")) ;
			g.drawImage(bf, x, y, sizeX, sizeY, null ) ; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle(x , y , sizeX , sizeY);
	}

}
