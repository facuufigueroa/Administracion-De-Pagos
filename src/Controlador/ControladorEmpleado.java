package Controlador;


import static Controlador.ControladorImporte.sueldo;
import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Reporte.Reporte;
import Vista.BuscarModificar;
import Vista.GenerarImporte;
import Vista.ModificarPagos;
import Vista.PagosEmpleado;
import Vista.RegistrosEmpleados;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.Date;
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

public class ControladorEmpleado implements ActionListener, KeyListener {

    private Empleado empleado;
    private Consultas consulta;
    private RegistrosEmpleados registrarE;
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel dtm_datos = new DefaultTableModel();
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
        this.registrarE.btnNuevaSemana.addActionListener(this);
        this.registrarE.generarReporte.addActionListener(this);
        this.registrarE.txtBuscarF.addKeyListener(this);
        this.registrarE.btnVerPagos.addActionListener(this);
       
        
      
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
        borrar(e);
        actualizar(e);
        editar(e);
        modificar(e);
        //abrirGenerarPago(e);
       
       // abrirGenerarPagoPrueba(e);
        abrir_generarPago(e);
       
        try {
            nuevaSemana(e);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        reporte(e);
      
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        busquedaFiltrada(e);
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
                        
                        JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> EMPLEADO GUARDADO</p></html>");

                        limpiarCajas();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> ERROR AL GUARDAR EMPLEADO </p><html>");
                        limpiarCajas();
                    }
                    iniciarJTable();
                } else {
                    JOptionPane.showMessageDialog(null, "YA EXISTE DNI" + " " + "'" + registrarE.txtDni.getText() + "'" + " " + "REGISTRADO", "EMPLEADO YA REGISTRADO", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> POR FAVOR COMPLETE LOS CAMPOS </p><html>");
            }

        }
    }

    /*public void buscar(ActionEvent e) {
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
    }*/

    public void borrar(ActionEvent e) {

        if (e.getSource() == registrarE.botonBorrar) {

            String botones[] = {"Aceptar", "Cancelar"};
            int fila = registrarE.getTablaEmpleado().getSelectedRow();

            if (fila >= 0) {
                int eleccion = JOptionPane.showOptionDialog(registrarE, "¿Desea borrar empleado: " + registrarE.getTablaEmpleado().getValueAt(fila, 1).toString().toUpperCase() + " ?", "ELIMINAR EMPLEADO", 0, 0, null, botones, this);

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
                    JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\">PARA MODIFICAR EMPLEADO LOS CAMPOS NO DEBEN ESTAR VACIOS</p/</html>", "ERROR AL MODIFICAR", 0);
            }

        }
    }

    
   
    
    public void abrirGenerarPagoPrueba(ActionEvent e){
        if (e.getSource() == registrarE.btnGenerarPago) {
            String idempleado=null;
            int fila = registrarE.getTablaEmpleado().getSelectedRow();
            //consulta.traerid_turno();
            

            if (fila >= 0) {
                idempleado = consulta.traer_id(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                PagosEmpleado pagosEmp = new PagosEmpleado();
                
                
                Turnos turno = new Turnos();
                Turnos turnoLunes = new Turnos();
                Turnos turnoMartes= new Turnos();
                Turnos turnoMiercoles = new Turnos();
                Turnos turnoJueves = new Turnos();
                Turnos turnoViernes = new Turnos();
                Turnos turnoSabado = new Turnos ();
                Turnos turnoPremio = new Turnos ();
                        
                
                ControladorImporte controladorI = new ControladorImporte(consulta, pagosEmp , turnoLunes ,turnoMartes, turnoMiercoles,
                        turnoJueves,
                        turnoViernes,
                        turnoSabado,
                        turnoPremio,
                        idempleado);
                controladorI.iniciar();
                pagosEmp.setVisible(true);
                
            }
        }
    }
    
    
   /* public void abrirModificarPago(ActionEvent e) 
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
       
    }*/

   
    public void nuevaSemana(ActionEvent e) throws SQLException{
        String botones[] = {"Aceptar", "Cancelar"};
        if(e.getSource() == registrarE.btnNuevaSemana){
            int eleccion = JOptionPane.showOptionDialog(registrarE, "<html><p style = \"font:20px\">¿DESEA GENERAR NUEVA SENAMA ? SE ELIMINARAN TODOS LOS REGISTROS DE LA SEMANA ANTERIOR </p></html>", "NUEVA SEMANA", 0, 0, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION){
                if(consulta.eliminar_registros_turnos()){
                    consulta.eliminar_empleado_turno();
                    consulta.eliminar_registros_diaturno();
                    consulta.eliminar_registros_empleado_diaturno();
                    consulta.eliminar_sueldos();
                    consulta.setearMensualidad();
                    JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> SE HAN ELIMINADO LOS REGISTROS, SISTEMA LISTO PARA GENERAR NUEVOS PAGOS </p></html>");
            }
        }else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\">SE HA CANCELADO LA OPERACION</p></html>");   
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

    
    public void busquedaFiltrada(KeyEvent k){
         // TODO add your handling code here:
        Connection conn = conexion.getConnection();
        String[] Titulos= {"DNI","NOMBRE","TELEFONO"};
        int valor = 0;
        int cont = 0;
        ResultSet rs;
        String aux = "" + registrarE.txtBuscarF.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
            try {
                Statement st_cont = conn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                rs = st_cont.executeQuery("SELECT COUNT(*) FROM empleados WHERE nombre LIKE'" + registrarE.txtBuscarF.getText() + "%'");//solo que esta ves usamos like
                if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                    valor = rs.getInt(1); //una vez que obtenimos el numero de filas continuamos a sacar  el valor que buscamos
                }
                
                    String [][] M_datos = new String[valor][4];
                    rs = st_cont.executeQuery("SELECT * FROM empleados WHERE nombre LIKE'" + registrarE.txtBuscarF.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
                    while (rs.next()) {
                       // M_datos[cont][0] = rs.getString("id");
                        M_datos[cont][0] = rs.getString("dni");
                        M_datos[cont][1] = rs.getString("nombre");
                        M_datos[cont][2] = rs.getString("telefono");
                        cont = cont + 1;
                    }
                    dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                        public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
            }
                    };
                    registrarE.getTablaEmpleado().setModel(dtm_datos);
                    
              
            } catch (Exception e) {
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    public void abrir_generarPago(ActionEvent e){
        if (e.getSource() == registrarE.btnGenerarPago) {
            
            String idempleado=null;
         
            int fila = registrarE.getTablaEmpleado().getSelectedRow();
            //consulta.traerid_turno();
            

            if (fila >= 0) {
                idempleado = consulta.traer_id(registrarE.getTablaEmpleado().getValueAt(fila, 0).toString());
                PagosEmpleado pagosEmp = new PagosEmpleado();
                
               
                
                Turnos turno = new Turnos();
                Turnos turnoLunes = new Turnos();
                Turnos turnoMartes= new Turnos();
                Turnos turnoMiercoles = new Turnos();
                Turnos turnoJueves = new Turnos();
                Turnos turnoViernes = new Turnos();
                Turnos turnoSabado = new Turnos ();
                Turnos turnoPremio = new Turnos ();
                        
                
                
                ControladorImporte controladorI = new ControladorImporte(consulta, pagosEmp , turnoLunes ,turnoMartes, turnoMiercoles,
                        turnoJueves,
                        turnoViernes,
                        turnoSabado,
                        turnoPremio,
                        idempleado);
                controladorI.iniciar();
                
                turnoLunes=consulta.turnoModificado(idempleado, "Lunes");
                pagosEmp.txt1L.setText(turnoLunes.getTurnoUno());
                pagosEmp.txt2L.setText(turnoLunes.getTurnoDos());
                pagosEmp.txt3L.setText(turnoLunes.getTurnoTres());
                pagosEmp.txt4L.setText(turnoLunes.getTurnoCuatro());
                pagosEmp.txtLDes.setText(turnoLunes.getDescuento());
                
                turnoMartes=consulta.turnoModificado(idempleado, "Martes");
                pagosEmp.txt1Ma.setText(turnoMartes.getTurnoUno());
                pagosEmp.txt2Ma.setText(turnoMartes.getTurnoDos());
                pagosEmp.txt3Ma.setText(turnoMartes.getTurnoTres());
                pagosEmp.txt4Ma.setText(turnoMartes.getTurnoCuatro());
                pagosEmp.txtMaDes.setText(turnoMartes.getDescuento());
                
                turnoMiercoles=consulta.turnoModificado(idempleado, "Miercoles");
                pagosEmp.txt1Mi.setText(turnoMiercoles.getTurnoUno());
                pagosEmp.txt2Mi.setText(turnoMiercoles.getTurnoDos());
                pagosEmp.txt3Mi.setText(turnoMiercoles.getTurnoTres());
                pagosEmp.txt4Mi.setText(turnoMiercoles.getTurnoCuatro());
                pagosEmp.txtMiDes.setText(turnoMiercoles.getDescuento());
                
                turnoJueves=consulta.turnoModificado(idempleado, "Jueves");
                pagosEmp.txt1J.setText(turnoJueves.getTurnoUno());
                pagosEmp.txt2J.setText(turnoJueves.getTurnoDos());
                pagosEmp.txt3J.setText(turnoJueves.getTurnoTres());
                pagosEmp.txt4J.setText(turnoJueves.getTurnoCuatro());
                pagosEmp.txtJDes.setText(turnoJueves.getDescuento());
                
                turnoViernes=consulta.turnoModificado(idempleado, "Viernes");
                pagosEmp.txt1V.setText(turnoViernes.getTurnoUno());
                pagosEmp.txt2V.setText(turnoViernes.getTurnoDos());
                pagosEmp.txt3V.setText(turnoViernes.getTurnoTres());
                pagosEmp.txt4V.setText(turnoViernes.getTurnoCuatro());
                pagosEmp.txtVDes.setText(turnoViernes.getDescuento());
                
                turnoSabado=consulta.turnoModificado(idempleado, "Sabado");
                pagosEmp.txt1S.setText(turnoSabado.getTurnoUno());
                pagosEmp.txt2S.setText(turnoSabado.getTurnoDos());
                pagosEmp.txt3S.setText(turnoSabado.getTurnoTres());
                pagosEmp.txt4S.setText(turnoSabado.getTurnoCuatro());
                pagosEmp.txtSDes.setText(turnoSabado.getDescuento());
                
                turnoPremio=consulta.turnoModificado(idempleado, "Extra");
                pagosEmp.txt1P.setText(turnoPremio.getTurnoUno());
                pagosEmp.txt2P.setText(turnoPremio.getTurnoDos());
                pagosEmp.txt3P.setText(turnoPremio.getTurnoTres());
                pagosEmp.txt4P.setText(turnoPremio.getTurnoCuatro());
                pagosEmp.txtPDes.setText(turnoPremio.getDescuento());
                
                
                
                pagosEmp.setVisible(true);
                
            }
        }
    }
    
    /*public void modificarTodo(ActionEvent e){
        if(e.getSource() == buscarM.botonModificarTodo){

            turno.setTurnoUno(isCero(buscarM.txtt1.getText())?buscarM.txtt1.getText():"0");
            turno.setTurnoDos(isCero(buscarM.txtt2.getText())?buscarM.txtt2.getText():"0");
            turno.setTurnoTres(isCero(buscarM.txtt3.getText())?buscarM.txtt3.getText():"0");
            turno.setTurnoCuatro(isCero(buscarM.txtt4.getText())?buscarM.txtt4.getText():"0");
            turno.setDescuento(isCero(buscarM.cajaDescuento.getText())?buscarM.cajaDescuento.getText():"0");
            turno.setTotal(buscarM.txtTotal.getText());
            turno.setIdturno(id_turno());
            //if(!verificarEspaciosEnBlanco(buscarM)){
                
                if(consulta.editarTurno(turno)){
                String idemp=consulta.traerid_empleado(id_turno());
                int sueldoPrimario = parseInt(consulta.calcularSueldo(idemp)); //SUELDO DEL EMPLEADO QUE USO EN CONTROLADOR EMPLEADO
                sueldo=Integer.toString(sueldoPrimario);
                consulta.asignarSueldo(sueldo,idemp);
                JOptionPane.showMessageDialog(null, "TURNO MOFIDICADO CON EXITO", "EDITAR EMPLEADO", 3);
                buscarM.setVisible(false);

               // }   
            }
           // else{
               //JOptionPane.showMessageDialog(null, "PARA MODIFICAR EL TURNO, LOS CAMPOS NO DEBEN ESTAR VACIOS", "ERROR AL MODIFICAR", 0);

            //}
            
        }
    }*/ 
    
    
    public boolean traeCeroDesdeBD(String numero){
        boolean tof=false;
        try{
            if(parseInt(numero)!=0){
                tof=true;
            }else{
                tof=false;
            }
        }catch(Exception e){
               
            return tof;
        }
        return tof;
    }
    
    
    
    
    
    
    
    
    
    
    
    }
   
   
                            

