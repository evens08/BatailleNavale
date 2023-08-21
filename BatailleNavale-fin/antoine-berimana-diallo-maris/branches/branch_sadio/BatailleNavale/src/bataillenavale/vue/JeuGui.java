package bataillenavale.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JeuGui extends JFrame  implements ActionListener{
    private JPanel leftPanel, rightPanel;

    public JeuGui() {
        setTitle("Bataille Navale");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer les deux panneaux pour les grilles
        leftPanel = new JPanel(new GridLayout(10, 10));
        rightPanel = new JPanel(new GridLayout(10, 10));

        // Ajouter les boutons pour chaque case de la grille
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton leftButton = new JButton();
                JButton rightButton = new JButton();
                leftPanel.add(leftButton);
                rightPanel.add(rightButton);
            }
        }

        // Ajouter les panneaux à la fenêtre principale
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        setVisible(true);
    }



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
