import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoDeBoton implements ActionListener {

	private CalculadoraGUI calc;
	
	
	
	public EventoDeBoton(CalculadoraGUI calc) {
		super();
		this.calc = calc;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int selecction = calc.getSelecction();
		
		if(selecction == 0) {
			calc.hexToAll();
		}
		
		if(calc.getNumber()) {
			calc.toConvert();
		}else {
			return;
		}
		
	}

}
