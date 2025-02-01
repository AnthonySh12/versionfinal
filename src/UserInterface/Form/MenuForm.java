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

        pnlMenu.btnHome.addActionListener(e -> setPanel(new MainPanel()));
        pnlMenu.btnCita.addActionListener(e -> {JOptionPane.showMessageDialog(null, "Boton de Agendar Precionado");
        setPanel(new AgendarCita());});
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain); // Remueve el panel anterior
        pnlMain = formularioPanel; // Reemplaza con el nuevo panel
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
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
