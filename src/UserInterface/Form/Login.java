//package UserInterface.Form;
//
//import java.awt.*;
//import javax.swing.*;
//
//import UserInterface.CustomerControl.PatLabel;
//import UserInterface.CustomerControl.PatLabelText;
//import UserInterface.CustomerControl.PatTextBox;
//
//public class Login extends JPanel {
//    private PatLabel         lblUsername
//                            ,lblPassword;
//    private PatTextBox       txtUsername;
//    private JPasswordField   txtPassword;
//    private JButton          btnLogin;
//    private PatLabelText     pltDireccion;
//    private Image            backgroundImage;
//
//    public Login(){
//        initializeComponents();
//        btnLogin.addActionListener(e -> btnLoginClick());
//        
//        backgroundImage = new ImageIcon("/UserInterface/Resource/Diseño sin título(2).png").getImage(); 
//    }
//    @Override
//    protected void painComponent(Graphics g){
//        super.paintComponent(g);
//        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//    }
//
//    private void btnLoginClick() {
//        String username = txtUsername.getText();
//        char[] password = txtPassword.getPassword();
//
//        JOptionPane.showMessageDialog(Login.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
//
//        txtUsername.setText("");
//        txtPassword.setText("");
//    }
//
//    private void initializeComponents() {
//        lblUsername = new PatLabel("Username:");
//        lblPassword = new PatLabel("Password:");
//        txtUsername = new PatTextBox();
//        txtPassword = new JPasswordField();
//        btnLogin    = new JButton("Login");
//        pltDireccion = new PatLabelText("Dirección:");
//
//        //txtUsername.setBorder(txtUsername.createBorderLine());
//        txtUsername.setBorderLine();
//
//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.EAST;
//        add(lblUsername, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        add(txtUsername, gbc);
//
//        // Etiqueta y campo de texto para la contraseña
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.EAST;
//        add(lblPassword, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.WEST;
//        add(txtPassword, gbc);
//
//        // Botón de login en la fila 2
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(btnLogin, gbc);
//
//
//        // Botón de login en la fila 2
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(pltDireccion, gbc);
//        
//    }
//
//
//
//}
//