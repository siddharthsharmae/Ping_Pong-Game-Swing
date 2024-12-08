package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import pingPong.AppPanel;
import pingPong.KeyControls;

public class Ball extends Entities{
	
	AppPanel appPanel;
	KeyControls key;
	Player1 player1;
	Player2 player2;
	float boost = 0.5f;
	boolean left=true,right=false,reset=true;
	Random random;
	public Ball(AppPanel appPanel,Player1 player1,Player2 player2,KeyControls key){
		random = new Random();
		this.key = key;
		this.appPanel = appPanel;
		this.player1 = player1;
		this.player2 = player2;
		setDefaults();
	}
	
	public void setDefaults() {
		this.height = appPanel.TILE_SIZE/2;
		this.width = appPanel.TILE_SIZE/2;
		this.xAxis = (appPanel.SCREEN_WIDTH-20)/2-height/2;
		this.yAxis = (appPanel.SCREEN_HEIGHT-20)/2-width/2;
		this.speedX=8;
		this.speedY=8;
	}
	
	public void update() {
		if(key.move) {
//			int choice = 1+random.nextInt(2);
//			if(choice==1) {
//				left=true;
//			}
//			else {
//				right=true;
//			}
			reset=false;
		}
		if(!reset) {
			if(xAxis<player1.xAxis+player1.width&&this.yAxis>player1.yAxis&&yAxis<player1.yAxis+player1.height) {
				right=true;
//				speedY=random.nextInt(-10, 10);
//				speedY*=-1;
				left=false;
			}
			if(xAxis+width>player2.xAxis&&this.yAxis>player2.yAxis&&yAxis<player2.yAxis+player2.height)
			{
				left=true;
//				speedY=random.nextInt(-10, 10);
//				speedY*=-1;
				right=false;
			}
			if(yAxis<10||yAxis+width>appPanel.SCREEN_HEIGHT-10) {
				speedY*=-1;
//				if(speedY>0) {
//					speedY++;
//				}else {
//					speedY--;
//				}
			}
			yAxis+=speedY;
			if(right) moveRight();
			if(left) moveLeft();
			speedX+=0.005f;
		}
		if(xAxis<0) {
			reset=true;
			setDefaults();
			appPanel.player2score++;
		}
		if(xAxis>appPanel.SCREEN_WIDTH) {
			reset=true;
			setDefaults();
			appPanel.player1score++;
		}
	}
	
	public void moveLeft() {
		this.xAxis-=this.speedX;
	}
	
	public void moveRight() {
		this.xAxis+=this.speedX;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(xAxis, yAxis, width, height);
	}
}
