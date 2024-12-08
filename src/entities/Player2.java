package entities;

import java.awt.Color;
import java.awt.Graphics;

import pingPong.AppPanel;
import pingPong.KeyControls;

public class Player2 extends Entities{
	
	AppPanel appPanel;
	KeyControls key;
	
	public Player2(AppPanel appPanel,KeyControls key){
		this.appPanel = appPanel;
		this.key = key;
		setDefaults();
	}

	private void setDefaults() {
		this.xAxis=appPanel.SCREEN_WIDTH-appPanel.TILE_SIZE/4-10;
		this.yAxis=10;
		this.width=appPanel.TILE_SIZE/4;
		this.height=appPanel.TILE_SIZE+50;
		this.speedY=10;
	}
	
	public void update() {
		if(key.up) {
			up();
		}
		if(key.down) {
			down();
		}
	}
	
	private void up() {
		if(yAxis>10) {
			this.yAxis-=speedY;
		}
	}
	private void down() {
		if(yAxis+height+10<appPanel.SCREEN_HEIGHT) {
			this.yAxis+=speedY;
			}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(xAxis, yAxis, width, height);
	}
}
