package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import UserInterface.SaludStyle;

public class MainPanel extends JPanel {
    private Image background;

    public MainPanel() {
        // Cargar la imagen de fondo desde SaludStyle (o la que corresponda)
        try {
            background = new ImageIcon(SaludStyle.URL_MAIN).getImage();
        } catch(Exception e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(background != null){
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // Opcional: método para obtener la imagen de fondo, si lo necesitas
    public Image getBackgroundImage() {
        return background;
    }
}
