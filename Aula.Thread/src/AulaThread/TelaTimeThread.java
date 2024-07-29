
package AulaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
    
    private JPanel jPanel = new JPanel(new GridBagLayout());
    
    private JLabel descricaoHora = new JLabel(" Date and Time ");
    private JTextField showTime = new JTextField();
    
    private JLabel descricaoTemperatura = new JLabel(" Weather Like ");
    private JTextField showTemperatura = new JTextField();
    
    private JButton jButton = new JButton("Start");
    private JButton jButton2 = new JButton("Stop");
    
    private Runnable threadHora = new Runnable() {
        @Override
        public void run() {
            while (true) {
                showTime.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").
                        format(Calendar.getInstance().getTime()));
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    
    private Runnable threadTemperatura = new Runnable() {
        private Random random = new Random();
        
        @Override
        public void run() {
            while (true) {
                // Simulando uma leitura de temperatura
                double temperatura = 15 + (40 - 15) * random.nextDouble();
                showTemperatura.setText(String.format("%.2f °C", temperatura));
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    
    private Thread thread1;
    private Thread thread2;
    
    public TelaTimeThread() {
        
        setTitle("Screen Time");
        setSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        setResizable(false);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        
        descricaoHora.setPreferredSize(new Dimension(250, 20));
        jPanel.add(descricaoHora, gridBagConstraints);
        
        showTime.setPreferredSize(new Dimension(250, 20));
        showTime.setEditable(false);
        gridBagConstraints.gridy++;
        jPanel.add(showTime, gridBagConstraints);
        
        descricaoTemperatura.setPreferredSize(new Dimension(250, 20));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoTemperatura, gridBagConstraints);
        
        showTemperatura.setPreferredSize(new Dimension(250, 20));
        showTemperatura.setEditable(false);
        gridBagConstraints.gridy++;
        jPanel.add(showTemperatura, gridBagConstraints);
        
        gridBagConstraints.gridwidth = 1;
        
        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jPanel.add(jButton, gridBagConstraints);
        
        jButton2.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jPanel.add(jButton2, gridBagConstraints);
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thread1 = new Thread(threadHora);
                thread2 = new Thread(threadTemperatura);
                thread1.start();
                thread2.start();
                
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	thread1 = new Thread(thread1);
				thread1.start();
				
                }
           
        });
        
    	jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1.stop();
				thread2.stop();
				
			}
			
		});
    	
    	
        add(jPanel, BorderLayout.WEST);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TelaTimeThread();
    }
}




