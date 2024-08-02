package AulaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
    
    private JPanel jPanel = new JPanel(new GridBagLayout());
    
    private JLabel descricaoNome = new JLabel("Name");
    private JTextField showName = new JTextField();
    
    private JLabel descricaoEmail = new JLabel("E-mail");
    private JTextField showEmail = new JTextField();
    
    private JButton jButton = new JButton("Add to list");
    private JButton jButton2 = new JButton("Stop");
   
    
    private ImplementFileThread fila = new ImplementFileThread();
    
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
        
        descricaoNome.setPreferredSize(new Dimension(250, 20));
        jPanel.add(descricaoNome, gridBagConstraints);
        
        showName.setPreferredSize(new Dimension(250, 20));
        gridBagConstraints.gridy++;
        jPanel.add(showName, gridBagConstraints);
        
        descricaoEmail.setPreferredSize(new Dimension(250, 20));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoEmail, gridBagConstraints);
        
        showEmail.setPreferredSize(new Dimension(250, 20));
        gridBagConstraints.gridy++;
        jPanel.add(showEmail, gridBagConstraints);
        
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
                ObjectFileThread filaThread = new ObjectFileThread();
                filaThread.setName(showName.getText());
                filaThread.setEmail(showEmail.getText());
                fila.addFila(filaThread);
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fila.stopFila();
            }
        });
       
        
        add(jPanel, BorderLayout.WEST);
        setVisible(true);
        
        fila.start(); // Inicia a thread da fila
       
    }
   
     
    
    
    public static void main(String[] args) {
        new TelaTimeThread();
    }
}
