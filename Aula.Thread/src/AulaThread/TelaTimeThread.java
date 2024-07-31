
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
    
    private JLabel descricaoHora = new JLabel(" Name ");
    private JTextField showTime = new JTextField();
    
    private JLabel descricaoTemperatura = new JLabel(" E-mail ");
    private JTextField showTemperatura = new JTextField();
    
    private JButton jButton = new JButton("Add list");
    private JButton jButton2 = new JButton("Stop");
    
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
        gridBagConstraints.gridy++;
        jPanel.add(showTime, gridBagConstraints);
        
        descricaoTemperatura.setPreferredSize(new Dimension(250, 20));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoTemperatura, gridBagConstraints);
        
        showTemperatura.setPreferredSize(new Dimension(250, 20));
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
                
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				
                }
           
        });
        
    	jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
    	
    	
        add(jPanel, BorderLayout.WEST);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TelaTimeThread();
    }
}




