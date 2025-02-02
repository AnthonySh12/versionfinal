package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import javax.swing.border.Border;

import UserInterface.GUI.PatCitas;

public class MenuForm extends JFrame {
    MenuPanel pnlMenu = new MenuPanel(this);
    JPanel pnlMain = new JPanel();

    public MenuForm(String titleApp) {
        customizeComponent(titleApp);

        pnlMenu.btnHome.addActionListener(e -> setPanel(new MainPanel())); // Usar el constructor por defecto
        pnlMenu.btnCita.addActionListener(e -> setPanel(new AgendarCitaPanel(this)));
        pnlMenu.btnCitas.addActionListener(e -> setPanel(new PatCitas(this)));
    }

    public void setPanel(JPanel nuevoPanel) {
        Container container = getContentPane();
        container.removeAll(); // Remueve todos los componentes
        container.add(nuevoPanel, BorderLayout.CENTER); // Agrega el nuevo panel al centro
        container.revalidate();
        container.repaint();
    }
    

    private void customizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(1020, 720);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el panel principal
        pnlMain.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        // Contenedor principal con BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);

        setVisible(true);
    }
}
