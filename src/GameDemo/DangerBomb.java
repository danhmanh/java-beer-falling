package GameDemo;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DangerBomb extends GameObject {
	private BufferedImage bf ; 
	private int sizeX = 50 , sizeY = 66  ; 
	public DangerBomb(int x, int y, ID id) {
		super(x, y, id);
		velY = 5 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y += velY ; 
		x = Game.clamp(x, 0, 370) ; 
		y = Game.clamp(y, -120, Game.HEIGHT) ; 
		if(y >= Game.HEIGHT - 10) {
			y = -120 ; 
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(Color.BLACK);
//		g.fillRect(x, y, sizeX, sizeY);
		try {
			bf  =ImageIO.read(new File("sprite/dangerbomb.png")) ;
			g.drawImage(bf, x, y, sizeX, sizeY, null ) ; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle(x , y ,sizeX , sizeY);
	}

}
