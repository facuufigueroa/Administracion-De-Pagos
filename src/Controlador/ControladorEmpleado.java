package Controlador;

import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Reporte.Reporte;
import Vista.BuscarModificar;
import Vista.GenerarImporte;
import Vista.ModificarPagos;
import Vista.RegistrosEmpleados;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorEmpleado implements ActionListener {

    private Empleado empleado;
    private Consultas consulta;
    private RegistrosEmpleados registrarE;
    private DefaultTableModel modelo = new DefaultTableModel();
    private ConexionBD conexion = new ConexionBD();
    private ControladorImporte ci;

    public ControladorEmpleado(Empleado empleado, Consultas consulta, RegistrosEmpleados registrarE) {
        this.empleado = empleado;
        this.consulta = consulta;
        this.registrarE = registrarE;
        
        

        //BOTONES CRUD
        this.registrarE.btnAgregar.addActionListener(this);
        this.registrarE.btnBuscar.addActionListener(this);
        this.registrarE.botonBorrar.addActionListener(this);
        this.registrarE.botonActualizar.addActionListener(this);
        this.registrarE.btnEditar.addActionListener(this);
        this.registrarE.btnModificar.addActionListener(this);
        this.registrarE.btnGenerarPago.addActionListener(this);
        this.registrarE.btnModificarP.addActionListener(this);
        this.registrarE.btnNuevaSemana.addActionListener(this);
        this.registrarE.generarReporte.addActionListener(this);
        
      

        iniciarJTable();

    }

    public void iniciarJTable() {
        modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("TELEFONO");
        //modelo.addColumn("ID");
      
        registrarE.getTablaEmpleado().setRowHeight(30);
        registrarE.getTablaEmpleado().setModel(modelo);
        importarDatos(modelo);
    }

    public void iniciar() {
        registrarE.setTitle("EMPLEADO");
        registrarE.setLocationRelativeTo(null);
        

    }

    //LLAMADA A METODOS CRUD
    @Override
    public void actionPerformed(ActionEvent e) {
        registrar(e);
        buscar(e);
        borrar(e);
        actualizar(e);
        editar(e);
        modificar(e);
        abrirGenerarPago(e);
        abrirModificarPago(e);
        try {
            nuevaSemana(e);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        reporte(e);
      
    }
                                                


    public void limpiarCeldas() {

        modelo.setRowCount(0);
    }

    public boolean verificarEspaciosEnBlanco(RegistrosEmpleados registrarE) {
        return registrarE.txtNombre.getText().isEmpty() || registrarE.txtDni.getText().isEmpty() || registrarE.txtTelefono.getText().isEmpty();

    }

    public void limpiarCajas() {

        registrarE.txtDni.setText(null);
        registrarE.txtNombre.setText(null);
        registrarE.txtTelefono.setText(null);

    }

    public void importarDatos(DefaultTableModel model) {
        Connection conn = conexion.getConnection();
        Statement st;
        String[] dato = new String[4];

        try {
            String sql = "SELECT * FROM empleados ORDER BY nombre ";

            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                dato[0] = rs.getString(2);
                dato[1] = rs.getString(3);
                dato[2] = rs.getString(4);
                dato[3] = rs.getString(1);
                model.addRow(dato);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //METODOS CRUD
    public void registrar(ActionEvent e) {
        if (e.getSource() == registrarE.btnAgregar) {

            if (!verificarEspaciosEnBlanco(registrarE)) {

                empleado.setDni(registrarE.txtDni.getText());
                empleado.setNombre(registrarE.txtNombre.getText());
                empleado.setTelefono(registrarE.txtTelefono.getText());
                empleado.setSueldo(Integer.toString(0));
                
                if (!consulta.existeCodigo(empleado.getDni())) {

                    if (consulta.agregar(empleado)) {
                        
                        JOptionPane.showMessageDialog(null, "EMPLEADO GUARDADO");

                        limpiarCajas();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EMPLEADO");
                        limpiarCajas();
                    }
                    iniciarJTable();
                } else {
                    JOptionPane.showMessageDialog(null, "YA EXISTE DNI" + " " + "'" + registrarE.txtDni.getText() + "'" + " " + "REGISTRADO", "EMPLEADO YA REGISTRADO", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "POR FAVOR COMPLETE LOS CAMPOS");
            }

        }
    }

    public void buscar(ActionEvent e) {
        if (e.getSource() == registrarE.btnBuscar) {
            String[] dato = new String[3];
            String nombre = registrarE.txtBuscar.getText();

            if (consulta.buscar(nombre).nombre != null) {
                limpiarCeldas();
                Empleado empleado = consulta.buscar(nombre);

                dato[0] = empleado.getDni();
                dato[1] = empleado.getNombre();
                dato[2] = empleado.getTelefono();

                modelo.addRow(dato);
                registrarE.txtBuscar.setText(null);

            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO, VERIFIQUE QUE EL NOMBRE SEA IDENTICO AL QUE CONTIENE LA TABLA", "ERROR AL BUSCAR", 0);
            }
        }
    }

    public void borrar(ActionEvent e) {

        if (e.getSource() == registrarE.botonBorrar) {

            String botones[] = {"Aceptar", "Cancelar"};
            int fila = registrarE.getTablaEmpleado().getSelectedRow();

            if (fila >= 0) {
                int eleccion = JOptionPane.showOptionDialog(registrarE, "¿Desea borrar empleado: " + registrarE.getTablaEmpleado().getValueAt(fila, 1).toString().toUpperCase() + " ?", "ELIMINAR PRODUCTO", 0, 0, null, botones, this);

                if (eleccion == JOptionPane.YES_OPTION) {
                    empleado.setDni(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());

                    if (consulta.borrar(empleado)) {
                        JOptionPane.showMessageDialog(null, registrarE.getTablaEmpleado().getValueAt(fila, 1).toString() + " " + "ELIMINADO");
                        iniciarJTable();
                    }
                } else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA OPERACION");
                    limpiarCajas();
                }
            } else {
                JOptionPane.showMessageDialog(null, "POR FAVOR, SELECCIONE EL EMPLEADO A ELIMINAR");
            }

        }
    }

    public void actualizar(ActionEvent e) {
        if (e.getSource() == registrarE.botonActualizar) {
            iniciarJTable();
        }
    }

    public void editar(ActionEvent e) {
        if (e.getSource() == registrarE.btnEditar) {
            int fila = registrarE.getTablaEmpleado().getSelectedRow();

            if (fila >= 0) {

                empleado.setDni(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                empleado.setDni(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                empleado.setNombre(registrarE.getTablaEmpleado().getValueAt(fila, 1).toString());
                empleado.setId(consulta.traer_id(registrarE.txtDni.getText()));
                String aux = registrarE.getTablaEmpleado().getValueAt(fila, 2).toString();
                aux = aux.substring(0, aux.length() - 1);
                empleado.setTelefono(aux);

                registrarE.txtDni.setText(empleado.getDni());
                registrarE.txtNombre.setText(empleado.getNombre());
                registrarE.txtTelefono.setText(empleado.getTelefono());
                //registrarE.txtId.setText(empleado.getId());

            } else {
                JOptionPane.showMessageDialog(null, "FILA NO SELECCIONADA");

            }
        }

    }

    public void modificar(ActionEvent e) {

        if (e.getSource() == registrarE.btnModificar) {

            empleado.setDni(registrarE.txtDni.getText());
            empleado.setNombre(registrarE.txtNombre.getText());
            empleado.setTelefono(registrarE.txtTelefono.getText());
            empleado.setId(consulta.traer_id(registrarE.txtDni.getText()));

            if (!verificarEspaciosEnBlanco(registrarE)) {

                if (consulta.editar(empleado)) {
                    JOptionPane.showMessageDialog(null, "EMPLEADO MOFIDICADO CON EXITO", "EDITAR EMPLEADO", 3);
                    iniciarJTable();
                    limpiarCajas();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR EMPLEADO");

                }
            } else {
                    JOptionPane.showMessageDialog(null, "PARA MODIFICAR EMPLEADO LOS CAMPOS NO DEBEN ESTAR VACIOS", "ERROR AL MODIFICAR", 0);
            }

        }
    }

    
    
    
    public void abrirGenerarPago(ActionEvent e) 
   {
        if (e.getSource() == registrarE.btnGenerarPago) {
            String idempleado=null;
            int fila = registrarE.getTablaEmpleado().getSelectedRow();

            if (fila >= 0) {
                idempleado = consulta.traer_id(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                GenerarImporte generarImp = new GenerarImporte();
                Turnos turno = new Turnos();

                ControladorImporte controladorI = new ControladorImporte(consulta, generarImp, turno, idempleado);
                controladorI.iniciar();
                generarImp.setVisible(true);

            }
        }
       
    }
    
    
    public void abrirModificarPago(ActionEvent e) 
   {
        if (e.getSource() == registrarE.btnModificarP) {
            String idempleado=null;
            int fila = registrarE.getTablaEmpleado().getSelectedRow();
            
            
            if (fila >= 0) {
                
                ModificarPagos modP = new ModificarPagos();
                BuscarModificar buscarM = new BuscarModificar();
                Turnos turno = new Turnos();
                
                
                idempleado = consulta.traer_id(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                
                
                
                buscarM.txtIdEmpleado.setText(idempleado);
                buscarM.txtNombre.setText(consulta.traerNombre(idempleado));
            
                
               
                ControladorModificar controladorM = new ControladorModificar(consulta,turno,buscarM, idempleado);
                controladorM.iniciar();
                buscarM.setVisible(true);
                buscarM.botonModificarTodo.setVisible(false);
                buscarM.btnCalcularTotal.setEnabled(false);
                buscarM.txtt1.setEditable(false);
                buscarM.txtt2.setEditable(false);
                buscarM.txtt3.setEditable(false);
                buscarM.txtt4.setEditable(false);
                buscarM.txtt5.setEditable(false);
                buscarM.txtt6.setEditable(false);
                buscarM.cajaDescuento.setEditable(false);
                
                
            }
        }
       
    }

   
    public void nuevaSemana(ActionEvent e) throws SQLException{
        String botones[] = {"Aceptar", "Cancelar"};
        if(e.getSource() == registrarE.btnNuevaSemana){
            int eleccion = JOptionPane.showOptionDialog(registrarE, "¿DESEA GENERAR NUEVA SENAMA ? SE ELIMINARAN TODOS LOS REGISTROS DE LA SEMANA ANTERIOR ", "NUEVA SEMANA", 0, 0, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION){
                if(consulta.eliminar_registros_turnos()){
                    consulta.eliminar_empleado_turno();
                    consulta.eliminar_registros_diaturno();
                    consulta.eliminar_registros_empleado_diaturno();
                    consulta.eliminar_sueldos();
                    consulta.setearMensualidad();
                    JOptionPane.showMessageDialog(null, "SE HAN ELIMINADO LOS REGISTROS, LISTO PARA GENERAR NUEVOS PAGOS");
            }
        }else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA OPERACION");   
                } 
        }
            
    }
                                                  
    public void reporte(ActionEvent e) {
        if (e.getSource() == registrarE.generarReporte){
            try {
                consulta.guardarMensualidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            Reporte reporte = new Reporte();

            //reporte.conexionReporte();
           
        }
    }
   
   
            
}
