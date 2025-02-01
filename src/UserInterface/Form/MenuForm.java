package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*;

public class MenuForm extends JFrame {
    MenuPanel pnlMenu = new MenuPanel();
    JPanel pnlMain = new JPanel();

    public MenuForm(String titleApp) {
        customizeComponent(titleApp);

        pnlMenu.btnHome.addActionListener(e -> setPanel(new MainPanel())); // Usar el constructor por defecto
        pnlMenu.btnCita.addActionListener(e -> setPanel(new AgendarCitaPanel()));
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.removeAll(); // Remueve todos los componentes
        container.add(pnlMenu, BorderLayout.WEST); // Vuelve a agregar el menú
        container.add(formularioPanel, BorderLayout.CENTER); // Agrega el nuevo panel al centro
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
