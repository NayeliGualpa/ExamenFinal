package GNUserInterface.GNForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GNFirstPanel extends JPanel {

    public GNFirstPanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(580, 75));

        String gncedula = "1750886234";
        String gnnombres = "Nayeli Anahi Gualpa Peña";

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombres:");

        JTextField tfCedula = new JTextField(gncedula);
        tfCedula.setEditable(false);
        tfCedula.setBackground(Color.GRAY);
        tfCedula.setBorder(BorderFactory.createEmptyBorder());

        JTextField tfNombre = new JTextField(gnnombres);
        tfNombre.setEditable(false);
        tfNombre.setBackground(Color.GRAY);
        tfNombre.setBorder(BorderFactory.createEmptyBorder());

        GridBagConstraints gbcGray = new GridBagConstraints();
        gbcGray.insets = new Insets(5, 5, 5, 5);
        gbcGray.anchor = GridBagConstraints.WEST;
        gbcGray.fill = GridBagConstraints.HORIZONTAL;

        gbcGray.gridx = 0;
        gbcGray.gridy = 0;
        add(lblCedula, gbcGray);

        gbcGray.gridx = 1;
        gbcGray.weightx = 1.0;
        add(tfCedula, gbcGray);

        gbcGray.gridy = 1;
        gbcGray.gridx = 0;
        add(lblNombre, gbcGray);

        gbcGray.gridx = 1;
        gbcGray.weightx = 1.0;
        add(tfNombre, gbcGray);
    }
}
