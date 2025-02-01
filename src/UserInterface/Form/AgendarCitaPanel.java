package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import BusinessLogic.entities.Cita;
import BusinessLogic.entities.Doctor;
import BusinessLogic.entities.GestorCita;
import BusinessLogic.entities.Paciente;
import UserInterface.SaludStyle;

public class AgendarCitaPanel extends JPanel implements ActionListener {

    private JComboBox<String> cbDoctor;
    private JComboBox<String> cbPaciente;
    private JTextField textFecha;
    private JComboBox<String> cbHora;
    private JTextField txtObservacion;
    private JButton btnAgendar;
    private JButton btnRegresar; // Botón para regresar
    private GestorCita gestionCita;
    private MenuForm parentFrame;
    private BufferedImage backgroundImage; // Referencia al JFrame principal

    public AgendarCitaPanel(MenuForm parentFrame) {
        this.parentFrame = parentFrame; // Guardar la referencia al JFrame principal

        try {
            backgroundImage = ImageIO.read(SaludStyle.class.getResource("/UserInterface/Resource/EPNPG.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen de fondo.");
        } 

        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        gestionCita = new GestorCita();
        initComponents();
        layoutComponents();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void initComponents() {
        cbDoctor = new JComboBox<>();
        cbPaciente = new JComboBox<>();
        textFecha = new JTextField(10);
        cbHora = new JComboBox<>();
        txtObservacion = new JTextField(20);
        btnAgendar = new JButton("Agendar Cita");
        btnRegresar = new JButton("Regresar"); // Inicializar botón de regreso

        btnAgendar.addActionListener(this);
        btnRegresar.addActionListener(this); // Agregar evento al botón de regreso

        // Llenar los combo boxes con datos de gestión
        for (Doctor d : gestionCita.doctores) {
            cbDoctor.addItem(d.getNombre() + " " + d.getApellido());
        }
        for (Paciente p : gestionCita.pacientes) {
            cbPaciente.addItem(p.getNombre() + " " + p.getApellido());
        }

        // Opciones de horario (estáticas)
        cbHora.addItem("8:00 TO 8:30");
        cbHora.addItem("8:30 TO 9:00");
        cbHora.addItem("9:00 TO 9:30");
        cbHora.addItem("9:30 TO 10:00");
        cbHora.addItem("10:00 TO 10:30");
        cbHora.addItem("10:30 TO 11:00");
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 0: Selección de Doctor
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Doctor:"), gbc);
        gbc.gridx = 1;
        add(cbDoctor, gbc);

        // Fila 1: Selección de Paciente
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Paciente:"), gbc);
        gbc.gridx = 1;
        add(cbPaciente, gbc);

        // Fila 2: Ingreso de Fecha
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Fecha (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        add(textFecha, gbc);

        // Fila 3: Selección de Hora
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Hora:"), gbc);
        gbc.gridx = 1;
        add(cbHora, gbc);

        // Fila 4: Observación
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Observación:"), gbc);
        gbc.gridx = 1;
        add(txtObservacion, gbc);

        // Fila 5: Botones
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgendar);
        buttonPanel.add(btnRegresar); // Agregar botón de regresar
        add(buttonPanel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgendar) {
            try {
                int indiceDoctor = cbDoctor.getSelectedIndex();
                int indicePaciente = cbPaciente.getSelectedIndex();

                Doctor doctor = gestionCita.doctores.get(indiceDoctor);
                Paciente paciente = gestionCita.pacientes.get(indicePaciente);

                String fechaTexto = textFecha.getText().trim();
                LocalDate fechaCita = LocalDate.parse(fechaTexto);
                String hora = (String) cbHora.getSelectedItem();
                String observacion = txtObservacion.getText().trim();

                Cita nuevaCita = new Cita(paciente, doctor, fechaCita, hora, observacion, "Agendada");
                gestionCita.agendarCita(nuevaCita);
                JOptionPane.showMessageDialog(this, "Cita agendada con éxito");
                textFecha.setText("");
                txtObservacion.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al agendar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnRegresar) {
            parentFrame.setPanel(new MenuPanel(parentFrame)); // Volver al menú principal
        }
    }
}
