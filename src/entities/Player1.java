package entities;

import java.awt.Color;
import java.awt.Graphics;

import pingPong.AppPanel;
import pingPong.KeyControls;

public class Player1 extends Entities{
	
	AppPanel appPanel;
	KeyControls key;
	
	public Player1(AppPanel appPanel,KeyControls key){
		this.key = key;
		this.appPanel = appPanel;
		setDefaults();
	}

	private void setDefaults() {
		this.xAxis = 10;
		this.yAxis=10;
		this.width=appPanel.TILE_SIZE/4;
		this.height=appPanel.TILE_SIZE+50;
		this.speedY=10;
	}
	
	public void update() {
		if(key.W) {
			up();
		}
		if(key.S) {
			down();
		}
	}
	private void up() {
		if(yAxis>10) {
			this.yAxis-=this.speedY;
		}
	}
	
	private void down() {
		if(yAxis+height+10<appPanel.SCREEN_HEIGHT) {
			this.yAxis+=this.speedY;			
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(xAxis, yAxis, width, height);
	}
}
