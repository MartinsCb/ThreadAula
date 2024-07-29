package AulaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
//new GridBagLayout painel de componentes
	
	private JLabel descricaoHora = new JLabel(" Time Thread ");
	private JTextField showTime = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Time Thread 2 ");
	private JTextField showTime2 = new JTextField();
	private JButton jButton = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");
	private Runnable thread = new Runnable() {
		
		@Override
		public void run() {
			while (true) {
				showTime.setText(new SimpleDateFormat("dd//MM/yyyy hh:mm.ss ").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);//para não travar
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	};
	private Thread thread1;
	
	
	
	public TelaTimeThread() {
		
		setTitle(" Screen Time ");
		setSize(new Dimension(300, 300) );
		setLocationRelativeTo(null);//centraliza a tela 
		setResizable(false);// não permite alterar dimensões da tela 
		//primeira parte concluida 
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
//é um controlador de posicionamento da tela (GridBagConstraints)
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5 , 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		
		descricaoHora.setPreferredSize(new Dimension(250,20));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		showTime.setPreferredSize(new Dimension(250,20));
		showTime.setEditable(false);
		gridBagConstraints.gridy ++; // anda uma coluna para um não ficar sobreposto o outro 
		jPanel.add(showTime, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(250,20));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		showTime2.setPreferredSize(new Dimension(250, 20));
		showTime2.setEditable(false);
		gridBagConstraints.gridy ++;
		jPanel.add(showTime2,gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jButton.setPreferredSize(new Dimension (92,25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton,gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension (92,25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButton2,gridBagConstraints);
		
		
		
		
		add(jPanel,BorderLayout.WEST);
		setVisible(true);
// sempre sera o ultimo comando a ser execultado / torna a tela visivel ao usuario 
	}



	}


