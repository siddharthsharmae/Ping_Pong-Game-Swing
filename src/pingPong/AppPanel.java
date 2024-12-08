package pingPong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import entities.Ball;
import entities.Player1;
import entities.Player2;

import javax.swing.JPanel;

public class AppPanel extends JPanel implements ActionListener{
	
	public final int TILE_SIZE = 100;
	public final int ROWS = 7;
	public final int COLS=12;
	public final int SCREEN_HEIGHT = TILE_SIZE * ROWS;
	public final int SCREEN_WIDTH = TILE_SIZE * COLS;
	Timer timer;
	Player1 player1;
	Player2 player2;
	KeyControls key;
	Ball ball;
	public int player1score,player2score;
	
	AppPanel(){
		key = new KeyControls();
		this.addKeyListener(key);
		player1 = new Player1(this,key);
		player2 = new Player2(this,key);
		ball = new Ball(this,player1,player2,key);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.cyan);
		this.setFocusable(true);
		startGame();
	}

	private void startGame(){
		timer = new Timer(12,this);
		timer.start();
	}
	
	private void update() {
		player1.update();
		player2.update();
		ball.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStage(g);
		player1.draw(g);
		player2.draw(g);
		ball.draw(g);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		g.drawString(""+player1score, SCREEN_WIDTH/4, SCREEN_HEIGHT/4);
		g.drawString(""+player2score, SCREEN_WIDTH/2+SCREEN_WIDTH/4, SCREEN_HEIGHT/4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		update();
		repaint();
	}
	
	public void drawStage(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(10, 10, SCREEN_WIDTH-20, SCREEN_HEIGHT-20);
		g.setColor(Color.black);
		g.drawLine((SCREEN_WIDTH-20)/2, 0+10, (SCREEN_WIDTH-20)/2, SCREEN_HEIGHT-10);
	}

}
