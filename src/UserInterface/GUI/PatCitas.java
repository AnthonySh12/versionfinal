package UserInterface.GUI;

import BusinessLogic.entities.Cita;
import BusinessLogic.entities.GestorCita;
import UserInterface.SaludStyle;
import UserInterface.Form.MenuForm;
import UserInterface.Form.MenuPanel;
import UserInterface.Form.MainPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatCitas extends JPanel implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnAnterior, btnSiguiente, btnRegresar, btnActualizar, btnEliminar;
    private JLabel lblPagina;

    private int paginaActual;
    private final int tamanioPagina = 10;

    private GestorCita gestorCita;
    private List<Cita> listaCitas;
    private BufferedImage backgroundImage;

    // Referencia al frame padre para poder regresar al panel principal
    private MenuForm parentFrame;

    public PatCitas(MenuForm parentFrame) {
        this.parentFrame = parentFrame;

        // Cargar la imagen de fondo EPNPG desde los recursos
        try {
            backgroundImage = ImageIO.read(SaludStyle.class.getResource("/UserInterface/Resource/EPNPG.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Inicializar el GestorCita y cargar los datos (citas, doctores, pacientes)
        gestorCita = new GestorCita();
        gestorCita.cargar();
        listaCitas = gestorCita.citas;
        paginaActual = 1;

        initComponents();
        refrescarTabla();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Configuración del modelo y tabla
        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Doctor", "Paciente", "Fecha", "Hora", "Observación", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setOpaque(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                // Deja la celda sin fondo (o podrías pintar otro color semitransparente)
                return label;
            }
        });

        // Crear el JScrollPane y hacerlo transparente, con tamaño preferido
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(600, 184));

        // Panel para centrar el scrollPane
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(scrollPane);

        // Panel para los botones (paginación y acciones)
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);

        btnAnterior = new JButton("Anterior");
        configurarBoton(btnAnterior);
        btnSiguiente = new JButton("Siguiente");
        configurarBoton(btnSiguiente);
        btnActualizar = new JButton("Actualizar");
        configurarBoton(btnActualizar);
        btnEliminar = new JButton("Eliminar");
        configurarBoton(btnEliminar);
        btnRegresar = new JButton("Regresar");
        configurarBoton(btnRegresar);

        lblPagina = new JLabel();

        // Agregar action listeners
        btnAnterior.addActionListener(this);
        btnSiguiente.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnRegresar.addActionListener(this);

        panelBotones.add(btnAnterior);
        panelBotones.add(lblPagina);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRegresar);

        // Creamos un panel contenedor para agrupar la tabla y el panel de botones verticalmente
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        // Agregar la tabla centrada
        contentPanel.add(centerPanel);
        // Agregar un espacio (por ejemplo, 10 píxeles) entre la tabla y los botones
        contentPanel.add(Box.createVerticalStrut(10));
        // Agregar el panel de botones
        contentPanel.add(panelBotones);

        // Agregamos el contentPanel en el centro del panel principal
        add(contentPanel, BorderLayout.CENTER);
    }

    // Método auxiliar para configurar un botón sin fondo, sin borde y sin foco
    private void configurarBoton(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder());
    }

    private void refrescarTabla() {
        tableModel.setRowCount(0);

        int total = listaCitas.size();
        int totalPaginas = (int) Math.ceil((double) total / tamanioPagina);
        if (paginaActual > totalPaginas && totalPaginas > 0) {
            paginaActual = totalPaginas;
        }
        int inicio = (paginaActual - 1) * tamanioPagina;
        int fin = Math.min(inicio + tamanioPagina, total);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = inicio; i < fin; i++) {
            Cita cita = listaCitas.get(i);
            String nombreDoctor = cita.getDoctor().getNombre() + " " + cita.getDoctor().getApellido();
            String nombrePaciente = cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido();
            tableModel.addRow(new Object[]{
                cita.getIdCita(),
                nombreDoctor,
                nombrePaciente,
                cita.getFechaCita().format(dtf),
                cita.getHoraCita(),
                cita.getObservacion(),
                cita.getEstadoCita()
            });
        }
        lblPagina.setText("Página " + paginaActual + " de " + totalPaginas);
        btnAnterior.setEnabled(paginaActual > 1);
        btnSiguiente.setEnabled(paginaActual < totalPaginas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAnterior) {
            if (paginaActual > 1) {
                paginaActual--;
                refrescarTabla();
            }
        } else if (e.getSource() == btnSiguiente) {
            int totalPaginas = (int) Math.ceil((double) listaCitas.size() / tamanioPagina);
            if (paginaActual < totalPaginas) {
                paginaActual++;
                refrescarTabla();
            }
        } else if (e.getSource() == btnActualizar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita para actualizar", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int idCita = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
            String nuevaObservacion = JOptionPane.showInputDialog(this, "Nueva Observación:", tableModel.getValueAt(selectedRow, 5));
            if (nuevaObservacion != null) {
                // Aquí deberías implementar la lógica para actualizar la cita.
                JOptionPane.showMessageDialog(this, "Actualizar la cita con ID " + idCita + " con la nueva observación: " + nuevaObservacion);
                gestorCita.cargar();
                listaCitas = gestorCita.citas;
                refrescarTabla();
            }
        } else if (e.getSource() == btnEliminar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita para eliminar", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int idCita = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la cita con ID: " + idCita + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                gestorCita.eliminarCita(idCita);
                gestorCita.cargar();
                listaCitas = gestorCita.citas;
                refrescarTabla();
            }
        } else if (e.getSource() == btnRegresar) {
            parentFrame.setPanel(new MenuPanel(parentFrame));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
