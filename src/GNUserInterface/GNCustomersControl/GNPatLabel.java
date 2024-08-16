package GNUserInterface.GNCustomersControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import GNUserInterface.GNIAStyle;

public class GNPatLabel extends JLabel{
    public GNPatLabel(){
        customizeComponent();
    }
    public GNPatLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), GNIAStyle.FONT, GNIAStyle.COLOR_FONT_LIGHT, GNIAStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        //setIcon(new ImageIcon(iconPath));
    }
}