package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class PanelDatos2022 extends JPanel implements ActionListener {

    private JButton btnGuardar, btnCancelar, btnEliminar, btnModificar, btnBuscar;
    private JTextField txtNombre, txtApellidos, txtTelefono, txtCorreoe, txtFechac;
    private JRadioButton tec, trabajo;
    MPersona mpa = new MPersona();
    TablaDatos dts = new TablaDatos();

    public PanelDatos2022() {
        setLayout(new GridLayout(10, 3));
        JLabel lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        txtNombre = new JTextField(30);
        add(lblNombre);
        add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellidos: ", JLabel.RIGHT);
        txtApellidos = new JTextField(30);
        add(lblApellidos);
        add(txtApellidos);

        JLabel lblTelefono = new JLabel("Numero de Celular: ", JLabel.RIGHT);
        txtTelefono = new JTextField(15);
        add(lblTelefono);
        add(txtTelefono);

        JLabel lblCorreoe = new JLabel("Correo electronico: ", JLabel.RIGHT);
        txtCorreoe = new JTextField(30);
        add(lblCorreoe);
        add(txtCorreoe);

        JLabel lblFechac = new JLabel("Fecha de cumpleaños: ", JLabel.RIGHT);
        txtFechac = new JTextField(30);
        add(lblFechac);
        add(txtFechac);
        
        
        JLabel lblTipo = new JLabel("ELIGE EL TIPO: ", JLabel.CENTER);
        JLabel lblTipo2 = new JLabel("", JLabel.CENTER);
        add(lblTipo);
        add(lblTipo2);

        ButtonGroup gpoBotones = new ButtonGroup();
        tec = new JRadioButton("TecNM/CdGuzman", true);
        trabajo = new JRadioButton("Trabajo");
        gpoBotones.add(tec);
        gpoBotones.add(trabajo);

        add(tec);
        add(trabajo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(this);
        btnCancelar = new JButton("Mostrar");
        btnCancelar.addActionListener(this);

       // btnBuscar = new JButton("Buscar");
    //    btnBuscar.addActionListener(this);
        add(btnGuardar);
        add(btnCancelar);
      //  add(btnBuscar);
    }

    public void actionPerformed(ActionEvent e) {
        String tipo = "TecNM";
        if (trabajo.isSelected()) {
            tipo = "Trabajo";
        }
        if (e.getSource() == btnGuardar) {
            if (txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes colocar al menos el nombre",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            } else if (txtTelefono.getText() == null || txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes capturar su telefono",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtTelefono.requestFocus();
            } else {
                mpa.agregar(txtNombre.getText(), txtApellidos.getText(), txtTelefono.getText(),
                        txtCorreoe.getText(),txtFechac.getText(), tipo);
                JOptionPane.showMessageDialog(null, "Se guardaran los datos",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.setText(null);
                txtApellidos.setText(null);
                txtTelefono.setText(null);
                txtCorreoe.setText(null);
                txtFechac.setText(null);
                txtNombre.requestFocus();
            }

        }
        if (e.getSource() == btnCancelar) {
            //System.exit(0);
            JFrameTablaDatos jft = new JFrameTablaDatos();
        }

        if (e.getSource() == btnBuscar) {
            if (txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes colocar el nombre a buscar",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            } else {

            }
        }

    }
}
