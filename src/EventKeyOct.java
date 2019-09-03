
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventKeyOct implements KeyListener{


	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		arg0.setKeyChar('A');
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub		
		char c = arg0.getKeyChar();
		

			if(Character.isDigit(c)) {
				int num = Character.getNumericValue(c);
				System.out.println(num);
				if(num > 7) {
					arg0.consume();
				}
			}else {
				arg0.consume();
			}
	

		
	}

}
