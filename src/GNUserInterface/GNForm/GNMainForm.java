package GNUserInterface.GNForm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GNMainForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MMEcuaFauna2K24A");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 800);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 30, 10, 30);

            // Crear y añadir los paneles
            JPanel GNfirstPanel = new GNFirstPanel();
            JPanel GNotherPanels = new GNOtherPanels();

            gbc.gridy = 0;
            gbc.weighty = 0.1;
            frame.add(GNfirstPanel, gbc);

            gbc.gridy = 1;
            gbc.weighty = 0.3;
            frame.add(GNotherPanels, gbc);

            // Configurar la ventana
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
