package AulaThread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread extends JDialog {
	
	public TelaTimeThread() {
		
		setTitle("My first screen time with THread");
		setSize(new Dimension(250, 250) );
		setLocationRelativeTo(null);//centraliza a tela 
		setResizable(false);// não permite alterar dimensões da tela 
		//primeira parte concluida 
		
		
		
		
		setVisible(true);// sempre sera o ultimo comando a ser execultado / torna a tela visivel ao usuario 
	}



	}


