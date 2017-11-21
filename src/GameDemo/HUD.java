package GameDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HUD {
	public static int PERCENT = 200 ; 
	private static int score = 0 ; 
	private BufferedImage bf , bf2; 
	private File file ; 
	private static int count = 0 ; 
	public int getScore() {
		return score;
	}
	
	public static int countPercent() {
		if(PERCENT ==  0 ) {
			count ++ ; 
		}
		return count  ; 
	}

	public void setScore(int score) {
		this.score = score;
	}

	private int level = 1 ; 
	public void tick() {		
		PERCENT = Game.clamp(PERCENT, 0, 200) ;
		score ++ ; 
//		System.out.println(countPercent());
	}
	
	public void render(Graphics g) {
//		score = 0 ; 
		if(countPercent() == 1) {
			file = new File("sprite/doki1.jpg")  ; 
		} else if(countPercent() == 2) {
			file  = new File("sprite/doki2.jpg") ; 
		} else if(countPercent() == 3) {
			file = new File("sprite/doki4.jpg") ; 
		}
		
		else {
			file = new File("sprite/doki3.jpg") ; 
		}
		
		g.setColor(Color.gray);
		g.drawRect(416, 150, 150, 400);
		try {
			bf = ImageIO.read(file) ;
			g.drawImage(bf, 416, 150, 150, 400, null) ; 
			bf = ImageIO.read(new File("sprite/board.PNG")) ;
			g.drawImage(bf, 415, 20, 150, 100, null) ; 
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(417, 151, 150, PERCENT * 2);
//		try {
//			bf = ImageIO.read(new File("sprite/censored.PNG")) ;
//			g.drawImage(bf, 417, 151, 149, PERCENT * 2, null) ; 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		g.setColor(Color.WHITE);
//		g.setColor(Color.WHITE);
//		g.drawRect(50, 50, 480, 480);
		Font font = new Font("Calibri", 1, 20) ; 
		g.setFont(font);
		g.drawString("Score: " + score, 420,  50);
		
		g.drawString("Level: "+ level , 420	 ,90 );
	}

	public void setLevel(int level) {
		this.level = level ; 
	}
	
	public int getLevel() {
		return level ; 
	}
	
}
