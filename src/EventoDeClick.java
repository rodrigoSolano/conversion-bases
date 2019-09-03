import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class EventoDeClick implements MouseListener{
	
	private JTextField arregloDeFields[];
	private CalculadoraGUI calc;

	public EventoDeClick(JTextField arregloDeFields[],CalculadoraGUI calc) {
		this.arregloDeFields = arregloDeFields;
		this.calc = calc;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		Component c = e.getComponent();
		
		int click = Integer.parseInt(c.getName());
	
		
		for (int i = 0; i < arregloDeFields.length; i++) {
			if(click == i) {
				arregloDeFields[i].setEnabled(true);
				arregloDeFields[i].requestFocus();
				calc.setSeleccion(i);
				
			}else {
				arregloDeFields[i].setEnabled(false);
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
