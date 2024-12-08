package pingPong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControls implements KeyListener{

	public boolean up = false,down=false,W=false,S=false,move=false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_R -> move = true;
		case KeyEvent.VK_UP -> up = true;
		case KeyEvent.VK_W -> W = true;
		case KeyEvent.VK_S -> S = true;
		case KeyEvent.VK_DOWN -> down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_R -> move = false;
		case KeyEvent.VK_UP -> up = false;
		case KeyEvent.VK_DOWN -> down = false;
		case KeyEvent.VK_W -> W = false;
		case KeyEvent.VK_S -> S = false;
		}
	}

}
