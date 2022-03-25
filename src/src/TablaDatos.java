package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import static src.MPersona.Arrpersona;

public class TablaDatos extends JPanel implements ActionListener {

    JTable tabla;
    JScrollPane scroll = new JScrollPane();
    JButton salir, btnEliminar, btnModificar;
    JTextField txtFila, txtColumna, txtnuevodato;

    MPersona mp = new MPersona();
    ArrayList<Persona> datosPer = new ArrayList<Persona>();

    public TablaDatos() {
        datosPer = mp.Datos();
        String titulos[] = {"Nombre", "Apellidos", "Telefono", "Correo Electronico", "Fecha de cumpleaños", "Tipo de Contacto"};
        String info[][] = obtenerDatos();
        setLayout(new GridLayout(3, 2));
        tabla = new JTable(info, titulos);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(tabla);
        add(scroll);
        JLabel lblTipo2 = new JLabel("", JLabel.CENTER);
        add(lblTipo2);
        JLabel lblFila = new JLabel("Nuevo dato: ", JLabel.CENTER);
        txtFila = new JTextField(15);
        add(lblFila);
        add(txtFila);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        add(btnEliminar);
        add(btnModificar);
    }

    private String[][] obtenerDatos() {
        int x = 0;
        String informacion[][] = new String[datosPer.size()][6];
        Iterator<Persona> itrPersona = datosPer.iterator();
        while (itrPersona.hasNext()) {
            Persona persona = itrPersona.next();
            informacion[x][0] = persona.getNombre();
            informacion[x][1] = persona.getApellidos();
            informacion[x][2] = persona.getTelefono();
            informacion[x][3] = persona.getCorreoe();
            informacion[x][4] = persona.getFechac();
            informacion[x][5] = persona.getTipo();
            x++;
            
            
        }
        return informacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEliminar) {
            
            int fila = tabla.getSelectedRow();
            
            if (fila >= 0) {
                
                int rpta = JOptionPane.showConfirmDialog(this, "Deseas eliminar la fila", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                if (rpta == JOptionPane.YES_OPTION) {
                    Arrpersona.remove(fila);
                    JOptionPane.showMessageDialog(this, "Actualice la ventana");

                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione fila");
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                int fila = tabla.getSelectedRow();
                int columna = tabla.getSelectedColumn();
                Persona persona = new Persona();
                persona = Arrpersona.get(fila);
                DefaultTableModel modelo = new DefaultTableModel();
                switch (columna) {
                    case 0:
                        String nuevoNombre = txtFila.getText();
                        persona.setNombre(nuevoNombre);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                    case 1:
                        String nuevoApellido = txtFila.getText();
                        persona.setApellidos(nuevoApellido);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                    case 2:
                        String nuevoTelefono = txtFila.getText();
                        persona.setNombre(nuevoTelefono);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                    case 3:
                        String nuevoCorreo = txtFila.getText();
                        persona.setCorreoe(nuevoCorreo);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                    case 4:
                        String nuevofechaC = txtFila.getText();
                        persona.setfechac(nuevofechaC);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                    case 5:
                        String nuevotipo = txtFila.getText();
                        persona.setTipo(nuevotipo);
                        JOptionPane.showMessageDialog(this, "Actualice la ventana");
                        break;
                }
                Arrpersona.set(fila, persona);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Seleccione la columna y la fila que desea modificar, y agregue el nuevo dato");
            }

        }

    }

}
