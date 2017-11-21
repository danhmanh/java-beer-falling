package GameDemo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Handler handler ; 
	
	public KeyInput(Handler handler) {
		this.handler = handler ; 
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode()  ; 
		for(int i = 0 ; i < handler.object.size() ; i++) {
			GameObject tempObj = handler.object.get(i) ; 
			
			if(tempObj.getId() == ID.Cart) {
				if(key == KeyEvent.VK_Q) tempObj.setVelX(-10);
				if(key == KeyEvent.VK_E) tempObj.setVelX(10) ;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode()  ; 
		for(int i = 0 ; i < handler.object.size() ; i++) {
			GameObject tempObj = handler.object.get(i) ; 
			
			if(tempObj.getId() == ID.Cart) {
				if(key == KeyEvent.VK_Q) tempObj.setVelX(0);
				if(key == KeyEvent.VK_E) tempObj.setVelX(0) ;
			}
		}
	}
}
