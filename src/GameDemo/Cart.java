package GameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import GameDemo.Game.STATE;

public class Cart extends GameObject {
	Handler handler;
	private int sizeX = 80;
	private int sizeY = 80;
	private Random  rnd = new Random() ; 
	public static int countBeerCollision = 0 ; 

	public Cart(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;

		x = Game.clamp(x, 0, 320);
		collision();
	}

	private void collision() {
		// TODO Auto-generated method stub
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Beer) {

				if (getBound().intersects(tempObj.getBound())) {
					countBeerCollision ++ ; 
					HUD.PERCENT -= 25;
					HUD.score += 25;
					tempObj.setX(rnd.nextInt(370));
					tempObj.setY(-50);
				}
				else if (!getBound().intersects(tempObj.getBound()) && (tempObj.getY() + 40) >= Game.HEIGHT) {
					HUD.PERCENT = 200;
					HUD.score = 0;
					
					Game.gameState = STATE.End;
					handler.removeAllObj();
				}


			} 
			if (tempObj.getId() == ID.Bomb) {
				if (getBound().intersects(tempObj.getBound())) {
					HUD.PERCENT = 200;
					handler.object.remove(tempObj) ; 
				}
			}
		}

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(x, y, sizeX, sizeY);

	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(x, y, sizeX, sizeY);
	}

}
