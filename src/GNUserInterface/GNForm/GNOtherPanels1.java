package GNUserInterface.GNForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import GNDataAccess.GNHormigaDAO;
import GNDataAccess.GNDTO.GNHormigaDTO;
import GNUserInterface.GNIAStyle;

public class GNOtherPanels1 extends JPanel {

    // Variables para el JTable
    private DefaultTableModel tableModel;
    private JTable table; // Agregado para acceder a la tabla en otros métodos
    private int currentID; // Variable para almacenar el ID secuencial

    // Variables para guardar la opción seleccionada
    private String selectedGenoAlimento = "<GenoAlimento>";
    private String selectedIngestaNativa = "<IngestaNativa>";

    public GNOtherPanels1() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Crear el segundo panel
        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(600, 50));
        secondPanel.setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        ImageIcon logoIcon = new ImageIcon(GNIAStyle.URL_LOGO);
        Image logoImage = logoIcon.getImage();
        Image resizedLogoImage = logoImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(resizedLogoImage);

        JLabel logoLabel = new JLabel(resizedLogoIcon);
        JLabel textLabel = new JLabel("Hormiguero virtual");
        textLabel.setForeground(Color.GREEN);

        leftPanel.add(logoLabel);
        leftPanel.add(textLabel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JButton createButton = new JButton("Crear Hormiga larva");
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(Color.BLACK);
        createButton.setPreferredSize(new Dimension(300, 50));
        createButton.setFocusPainted(false);

        rightPanel.add(createButton);

        secondPanel.add(leftPanel, BorderLayout.WEST);
        secondPanel.add(rightPanel, BorderLayout.EAST);

        gbc.gridy = 0;
        gbc.weighty = 0.1;
        add(secondPanel, gbc);

        // Crear el JTable y el modelo
        String[] columnNames = {"ID", "Sexo", "Provincia", "GenoAlimento", "IngestaNativa", "TipoHormiga", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel); // Inicializar el JTable
        table.setGridColor(Color.DARK_GRAY);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 150));

        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(scrollPane, gbc);

        // Crear el cuarto panel
        JPanel fourthPanel = new JPanel();
        fourthPanel.setPreferredSize(new Dimension(580, 150));
        fourthPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcFourth = new GridBagConstraints();
        gbcFourth.insets = new Insets(10, 5, 10, 5);

        JButton leftButton1 = new JButton(selectedGenoAlimento);
        leftButton1.setBackground(Color.GREEN);
        leftButton1.setForeground(Color.BLACK);
        leftButton1.setPreferredSize(new Dimension(150, 50));
        leftButton1.setFocusPainted(false);

        JButton leftButton2 = new JButton(selectedIngestaNativa);
        leftButton2.setBackground(Color.GREEN);
        leftButton2.setForeground(Color.BLACK);
        leftButton2.setPreferredSize(new Dimension(150, 50));
        leftButton2.setFocusPainted(false);

        JPopupMenu popupMenu1 = new JPopupMenu();
        // Actualizar opciones del menú emergente
        JMenuItem option1_1 = new JMenuItem("<GenoAlimento>");
        JMenuItem option1_2 = new JMenuItem("XY");
        JMenuItem option1_3 = new JMenuItem("XX"); 
        popupMenu1.add(option1_1);
        popupMenu1.add(option1_2);
        popupMenu1.add(option1_3);

        JPopupMenu popupMenu2 = new JPopupMenu();
        // Actualizar opciones del menú emergente
        JMenuItem option2_1 = new JMenuItem("<IngestaNativa>");
        JMenuItem option2_2 = new JMenuItem("Carnivoro");
        JMenuItem option2_3 = new JMenuItem("Herbivoro");
        JMenuItem option2_4 = new JMenuItem("Omnivoro");
        JMenuItem option2_5 = new JMenuItem("Insectivoros");
        popupMenu2.add(option2_1);
        popupMenu2.add(option2_2);
        popupMenu2.add(option2_3);
        popupMenu2.add(option2_4);
        popupMenu2.add(option2_5);

        // ActionListener para actualizar el texto del botón
        ActionListener updateSelectedOption = e -> {
            JMenuItem source = (JMenuItem) e.getSource();
            String selectedOption = source.getText();

            // Determine qué botón fue clicado y actualiza el texto del botón
            if (source.getParent() == popupMenu1) {
                selectedGenoAlimento = selectedOption;
                leftButton1.setText(selectedGenoAlimento);
            } else if (source.getParent() == popupMenu2) {
                selectedIngestaNativa = selectedOption;
                leftButton2.setText(selectedIngestaNativa);
            }
        };

        option1_1.addActionListener(updateSelectedOption);
        option1_2.addActionListener(updateSelectedOption);
        option1_3.addActionListener(updateSelectedOption);
        option2_1.addActionListener(updateSelectedOption);
        option2_2.addActionListener(updateSelectedOption);
        option2_3.addActionListener(updateSelectedOption);
        option2_4.addActionListener(updateSelectedOption);
        option2_5.addActionListener(updateSelectedOption);

        leftButton1.addActionListener(e -> popupMenu1.show(leftButton1, 0, leftButton1.getHeight()));
        leftButton2.addActionListener(e -> popupMenu2.show(leftButton2, 0, leftButton2.getHeight()));

        JButton createButton1 = new JButton("Alimentar Con GenoAlimento");
        createButton1.setBackground(Color.YELLOW);
        createButton1.setForeground(Color.BLACK);
        createButton1.setPreferredSize(new Dimension(300, 50));
        createButton1.setFocusPainted(false);

        JButton createButton2 = new JButton("Alimentar Con IngestaNativa");
        createButton2.setBackground(Color.YELLOW);
        createButton2.setForeground(Color.BLACK);
        createButton2.setPreferredSize(new Dimension(300, 50));
        createButton2.setFocusPainted(false);

        // ActionListener para los botones de alimentación
        createButton1.addActionListener(e -> {
            updateColumnWithText(3, selectedGenoAlimento);
            checkAndUpdateRow();
        });

        createButton2.addActionListener(e -> {
            updateColumnWithText(4, selectedIngestaNativa);
            checkAndUpdateRow();
        });

        gbcFourth.gridx = 0;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.WEST;
        fourthPanel.add(leftButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(leftButton2, gbcFourth);

        gbcFourth.gridx = 1;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.EAST;
        fourthPanel.add(createButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(createButton2, gbcFourth);

        gbc.gridy = 2;
        gbc.weighty = 0.3;
        add(fourthPanel, gbc);

        // Crear el quinto panel
        JPanel fifthPanel = new JPanel();
        fifthPanel.setBackground(Color.LIGHT_GRAY);
        fifthPanel.setPreferredSize(new Dimension(580, 75));
        fifthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        Color lightBlue = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(new Color(70, 130, 180), 2);

        JButton saveButton = new JButton("GUARDAR");
        saveButton.setBackground(lightBlue);
        saveButton.setForeground(Color.BLACK);
        saveButton.setPreferredSize(new Dimension(150, 50));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(border);

        JButton exitButton = new JButton("ELIMINAR");
        exitButton.setBackground(lightBlue);
        exitButton.setForeground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(border);

        // Agregar el ActionListener para el botón "GUARDAR"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Agregar el ActionListener para el botón "ELIMINAR"
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });

        fifthPanel.add(saveButton);
        fifthPanel.add(exitButton);

        gbc.gridy = 3;
        gbc.weighty = 0.1;
        add(fifthPanel, gbc);

        // Inicializar el ID secuencial
        currentID = 1; // O cualquier valor inicial que desees

        // ActionListener para el botón "Crear Hormiga larva"
        createButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de crear una hormiga larva?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                addNewHormiga();
            }
        });
    }

    // Método para agregar una nueva hormiga con datos predeterminados
    private void addNewHormiga() {
        // Incrementar el ID secuencial
        int newID = currentID++;

        // Datos predeterminados
        String sexo = "asexual";
        String provincia = getRandomProvincia();
        String genoAlimento = selectedGenoAlimento;
        String ingestaNativa = selectedIngestaNativa;
        String tipoHormiga = "larva";
        String estado = "viva";

        // Agregar la nueva fila al modelo de la tabla
        tableModel.addRow(new Object[] { newID, sexo, provincia, genoAlimento, ingestaNativa, tipoHormiga, estado });
    }

    // Método para obtener una provincia aleatoria
    private String getRandomProvincia() {
        String[] provincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe"};
        Random random = new Random();
        return provincias[random.nextInt(provincias.length)];
    }

    // Método para actualizar la columna con el texto seleccionado
    private void updateColumnWithText(int columnIndex, String text) {
        int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) { // Verificar si hay una fila seleccionada
            String estado = (String) tableModel.getValueAt(selectedRow, 6); // Obtener el estado de la hormiga
    
            // Verificar si el estado es "Muerta"
            if ("Muerta".equals(estado)) {
                JOptionPane.showMessageDialog(this, "No se puede modificar una hormiga cuyo estado es 'Muerta'.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                tableModel.setValueAt(text, selectedRow, columnIndex); // Actualizar la celda solo si el estado no es "Muerta"
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para verificar y actualizar la fila según las selecciones
    private void checkAndUpdateRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String genoAlimento = (String) tableModel.getValueAt(selectedRow, 3);
            String ingestaNativa = (String) tableModel.getValueAt(selectedRow, 4);
    
            // Verificar y actualizar el sexo y tipo de hormiga según genoAlimento
            if ("XX".equals(genoAlimento)) {
                tableModel.setValueAt("Hembra", selectedRow, 1); // Actualizar el sexo a "Macho"
                tableModel.setValueAt("Rastreadora", selectedRow, 5); // Actualizar el tipo de hormiga a "Zangano"
            }
    
            // Verificar y actualizar el estado según ingestaNativa
            if ("Carnivoro".equals(ingestaNativa) || "Herbivoro".equals(ingestaNativa) || "Omnivoro".equals(ingestaNativa)) {
                tableModel.setValueAt("Viva", selectedRow, 6); // Establecer estado en "Viva"
            } else if ("Insectivoros".equals(ingestaNativa)) {
                tableModel.setValueAt("Muerta", selectedRow, 6); // Establecer estado en "Muerta"
            } else {
                // Si ingestaNativa está vacía, mantener el estado en "Viva"
                if (ingestaNativa == null || ingestaNativa.trim().isEmpty()) {
                    tableModel.setValueAt("Viva", selectedRow, 6); // Mantener estado en "Viva"
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para guardar los datos en la base de datos
    private void saveData() {
        GNHormigaDAO dao = new GNHormigaDAO();
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaCrea = now.format(formatter);

            for (int row = 0; row < tableModel.getRowCount(); row++) {
                String idHormigaText = tableModel.getValueAt(row, 0).toString().trim();
                String idSexoText = tableModel.getValueAt(row, 1).toString().trim();
                String idProvinciaText = tableModel.getValueAt(row, 2).toString().trim();
                String idGenoAlimentoText = tableModel.getValueAt(row, 3).toString().trim();
                String idIngestaNativaText = tableModel.getValueAt(row, 4).toString().trim();
                String tipoHormiga = tableModel.getValueAt(row, 5).toString().trim();
                String estado = tableModel.getValueAt(row, 6).toString().trim();

                int idHormiga;
                int idSexo;
                int idProvincia;
                int idGenoAlimento;
                int idIngestaNativa;

                // Intentar convertir los textos a enteros
                try {
                    idHormiga = Integer.parseInt(idHormigaText);
                    idSexo = Integer.parseInt(idSexoText);
                    idProvincia = Integer.parseInt(idProvinciaText);
                    idGenoAlimento = Integer.parseInt(idGenoAlimentoText);
                    idIngestaNativa = Integer.parseInt(idIngestaNativaText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Uno o más campos numéricos tienen un formato inválido. Asegúrate de que los campos numéricos contengan solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear el objeto DTO con la fecha actual
                GNHormigaDTO dto = new GNHormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa, tipoHormiga, estado, fechaCrea);

                // Verificar que los campos numéricos no estén vacíos
                if (tipoHormiga.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dao.create(dto);
                    JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas eliminar esta fila?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Fila eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    class CustomTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            // No permitir edición si el estado es "Muerta"
            String estado = (String) getValueAt(row, 6);
            if ("Muerta".equals(estado)) {
                return false;
            }
            return super.isCellEditable(row, column);
        }
    }
}





