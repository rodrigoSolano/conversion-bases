import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventKeyBin implements KeyListener{

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
		char c = e.getKeyChar();
		if(Character.isDigit(c)) {
			int num = Character.getNumericValue(c);
			if(num>1) {
				e.consume();
			}
		}else {
			e.consume();
		}
	}

}
