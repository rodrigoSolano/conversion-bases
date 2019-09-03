import java.awt.BorderLayout;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraGUI {
	
	private int  number = 0;
	
	private JTextField arregloDeFields[] = {new JTextField(20),new JTextField(20),new JTextField(20),new JTextField(20)} ;
		
	private JFrame gui;
	private JPanel panel;
	
	private JButton buttonConvert ;

	private int selecction = 1;
	
	private EventoDeBoton eventButton;
	private EventoDeClick eventClick;
	private EventKeyDec eventKeyDec;
	private EventKeyOct eventKeyOct;
	private EventKeyBin eventKeyBin;
	private EventKeyHex eventKeyHex;
	
	public CalculadoraGUI() {
		initComponents();
		buttonConvert.addActionListener(eventButton);
		arregloDeFields[0].addKeyListener(eventKeyHex);
		arregloDeFields[1].addKeyListener(eventKeyDec);
		arregloDeFields[2].addKeyListener(eventKeyOct);
		arregloDeFields[3].addKeyListener(eventKeyBin);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 300);
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
	}
	
	private void  initComponents() {
		
		eventButton = new EventoDeBoton(this);
		eventClick = new EventoDeClick(arregloDeFields,this);
		eventKeyDec = new EventKeyDec();
		eventKeyOct = new EventKeyOct();
		eventKeyBin = new EventKeyBin();
		eventKeyHex = new EventKeyHex();
		buttonConvert = new JButton("Convertir");
		gui =  new JFrame("Caculadora de conversion");
		panel = new JPanel();
		//Dispocision en caja
		Box boxH =  Box.createHorizontalBox();
		Box boxTextos = Box.createVerticalBox();
		Box boxLabels = Box.createVerticalBox();
		//Inicalización de atributos necesarios para los campos de texto
		for (int i = 0; i < arregloDeFields.length; i++) {
			if(i == 1) {
				arregloDeFields[i].setName(Integer.toString(i));
				arregloDeFields[i].addMouseListener(eventClick);
				
				arregloDeFields[i].setEnabled(true);
				boxTextos.add(arregloDeFields[i]);
				boxTextos.add(Box.createVerticalStrut(10));
				continue;
			}
			arregloDeFields[i].addMouseListener(eventClick);
			
			arregloDeFields[i].setName(Integer.toString(i));
			arregloDeFields[i].setEnabled(false);
			boxTextos.add(arregloDeFields[i]);
			boxTextos.add(Box.createVerticalStrut(10));
		}
		//Labels
		
		boxLabels.add(new JLabel("HEX"));
		boxLabels.add(Box.createVerticalStrut(15));
		boxLabels.add(new JLabel("DEC"));
		boxLabels.add(Box.createVerticalStrut(15));
		boxLabels.add(new JLabel("OCT"));
		boxLabels.add(Box.createVerticalStrut(15));
		boxLabels.add(new JLabel("BIN"));
		//Componentes del panel
		boxH.add(boxLabels);
		boxH.add(Box.createHorizontalStrut(10));
		boxH.add(boxTextos);
		//Componentes agregados al panel
		panel.add(boxH,BorderLayout.CENTER);
		panel.add(buttonConvert,BorderLayout.CENTER);
		//Pabel a agregado al frame
		gui.add(panel);
	}
	
	public boolean getNumber() {
		try {
			number = Integer.parseInt(arregloDeFields[selecction].getText());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Entrada no valida!!");
			return false;
		}
	}
	
	public int getSelecction() {
		return this.selecction;
	}


	public void hexToAll() {
		   String digits = "0123456789ABCDEF";  
		   String numeroHex = arregloDeFields[0].getText();
		   numeroHex = numeroHex.toUpperCase();  
           int val = 0;  
           for (int i = 0; i < numeroHex.length(); i++)  
           {  
               char c = numeroHex.charAt(i);  
               int d = digits.indexOf(c);  
               val = 16*val + d;  
           }  
           System.out.println(val);
           this.number = val;
           arregloDeFields[1].setText(Integer.toString(val));
           decToAll();
	}
	
	//De decimal a todas las otras bases
	public void decToAll() {
		
		//numero escrito en decimal;
		String numeroEnHexadecimal = "";
		String numeroEnOctal = "";
		String numeroEnBinario = "";
		int aux;
		
		aux = number;
		
		while(aux > 0) {
			
			if(aux % 2 == 0) {
				numeroEnBinario = "0" + numeroEnBinario;
			}else {
				numeroEnBinario = "1" + numeroEnBinario;
			}
			
			aux = (int) aux / 2;
		}
		
        char digitosO[]={'0','1','2','3','4','5','6','7'};
        int resto;
        aux = number;
         
        while(aux > 0){
            resto = aux % 8;
            numeroEnOctal = digitosO[resto] + numeroEnOctal;
            aux /= 8; 
        }
        
        char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        aux = number;
         
        while(aux>0){
            resto = aux % 16;
            numeroEnHexadecimal = digitosH[resto] + numeroEnHexadecimal;
            aux /= 16; 
        }
		
		
        arregloDeFields[0].setText(numeroEnHexadecimal);
		arregloDeFields[2].setText(numeroEnOctal);
		arregloDeFields[3].setText(numeroEnBinario);
		
	}

	
	//De octal a todas las otras bases
	public void octToAll() {
		
		String numberString = Integer.toString(number);
		char[] digitos = numberString.toCharArray();
		
		double aux = 0;
		
		int  j = digitos.length-1;
		
		for (int i = 0; i < digitos.length; i++) {
			
			aux = aux + (Integer.parseInt(""+ digitos[j]) * ( Math.pow(8, (float)i)));
			j--;
		}
		
		this.number = (int)aux;
		
		decToAll();
		
		arregloDeFields[1].setText(Double.toString(aux));
		
	}
	
	//De binario a las otras bases
	public void binToAll() {
		String numberString = Integer.toString(number);
		char[] digitos = numberString.toCharArray();
		
		double aux = 0;
		
		int  j = digitos.length-1;
		
		for (int i = 0; i < digitos.length; i++) {
			
			aux = aux + (Integer.parseInt(""+ digitos[j]) * ( Math.pow(2, (float)i)));
			j--;
		}
		
		this.number = (int)aux;
		
		decToAll();
		
		arregloDeFields[1].setText(Double.toString(aux));
	}

	public void toConvert() {
		// TODO Auto-generated method stub
		switch (selecction) {
		case 1:
			decToAll();
			break;
		case 2:
			octToAll();
			break;
		case 3:
			binToAll();
			break;
		default:
			break;
		}
	}
	
	//Getters and setters
	public void setSeleccion(int selecction) {
		this.selecction = selecction;
	}
	
}
