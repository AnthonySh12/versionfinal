package UserInterface.Form;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import UserInterface.SaludStyle;
import UserInterface.CustomerControl.PatButton;

public class MenuPanel extends JPanel {
    private BufferedImage backgroundImage;
    private MenuForm parentFrame;
    
    public PatButton btnHome = new PatButton("Home");
    public PatButton btnCita = new PatButton("Agendar Cita");

    public MenuPanel(MenuForm parentFrame) {
        this.parentFrame = parentFrame;

        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(SaludStyle.class.getResource("/UserInterface/Resource/EPNPG.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen de fondo.");
        }   

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1020, 720));
        setBorder(new LineBorder(Color.BLACK, 2));

        JPanel panelWest = new JPanel(new BorderLayout());
        panelWest.setOpaque(false);

        // Panel para agrupar botones y evitar que se pierdan en el fondo
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
        panelButtons.setOpaque(false);
        panelButtons.setBackground(Color.RED); 
        panelButtons.add(Box.createRigidArea(new Dimension(220, 300)));
        panelButtons.add(btnHome);
        panelButtons.add(btnCita);
        panelButtons.add(Box.createVerticalGlue());

        add(panelButtons, BorderLayout.WEST);

        // Acción de los botones
        btnHome.addActionListener(e -> parentFrame.setPanel(new MenuPanel(parentFrame)));
        btnCita.addActionListener(e -> parentFrame.setPanel(new AgendarCitaPanel(parentFrame)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
