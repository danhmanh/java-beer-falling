package GameDemo;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bomb extends GameObject {
	private BufferedImage bf ; 
	private int sizeX =30 , sizeY = 30 ; 
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
		try {
			bf  =ImageIO.read(new File("sprite/bomb.png")) ;
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
