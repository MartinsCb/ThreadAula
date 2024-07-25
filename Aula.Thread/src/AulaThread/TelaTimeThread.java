package AulaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
//new GridBagLayout painel de componentes
	
	private JLabel descricaoHora = new JLabel("Time Thread ");
	private JTextField showTime = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Time Thread 2 ");
	private JTextField showTime2 = new JTextField();
	
	public TelaTimeThread() {
		
		setTitle("My first screen time with THread");
		setSize(new Dimension(250, 250) );
		setLocationRelativeTo(null);//centraliza a tela 
		setResizable(false);// não permite alterar dimensões da tela 
		//primeira parte concluida 
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
//é um controlador de posicionamento da tela (GridBagConstraints)
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		
		descricaoHora.setPreferredSize(new Dimension(250,20));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		showTime.setPreferredSize(new Dimension(250,20));
		gridBagConstraints.gridy ++; // anda uma coluna para um não ficar sobreposto o outro 
		jPanel.add(showTime, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(250,20));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		showTime2.setPreferredSize(new Dimension(250, 20));
		gridBagConstraints.gridy ++;
		jPanel.add(showTime2,gridBagConstraints);
		
		add(jPanel,BorderLayout.WEST);
		setVisible(true);
// sempre sera o ultimo comando a ser execultado / torna a tela visivel ao usuario 
	}



	}


