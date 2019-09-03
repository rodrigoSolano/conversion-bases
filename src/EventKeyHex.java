import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventKeyHex implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch = e.getKeyChar();
		if(Character.isDigit(ch)) {
			
		}else {
			switch (ch) {
			case 'a':e.setKeyChar('A');break;
			case 'b':e.setKeyChar('B');break;
			case 'c':e.setKeyChar('C');break;
			case 'd':e.setKeyChar('D');break;
			case 'e':e.setKeyChar('E');break;
			case 'f':e.setKeyChar('F');break;
			case 'A':e.setKeyChar('A');break;
			case 'B':e.setKeyChar('B');break;
			case 'C':e.setKeyChar('C');break;
			case 'D':e.setKeyChar('D');break;
			case 'E':e.setKeyChar('E');break;
			case 'F':e.setKeyChar('F');break;
			default:e.consume();break;
			}
		}
		
	}

}
