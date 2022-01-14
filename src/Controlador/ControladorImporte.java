
package Controlador;

import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Reporte.VerPagos;
import Vista.BarraProgreso;
import Vista.BarraProgresoGuardar;
import Vista.GenerarImporte;
import Vista.PagosEmpleado;
import Vista.RegistrosEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class ControladorImporte implements ActionListener{
    private Consultas consulta;
    private ConexionBD conexion = new ConexionBD();
    private GenerarImporte generarImp;
    private PagosEmpleado pagosE;
    private Turnos turno;
    private BarraProgreso progresBar;
    private BarraProgresoGuardar progresBarG;
    private Timer time;
    private DefaultTableModel modelo = new DefaultTableModel();
   
    
    private Turnos turnoLunes;
    
    private Turnos turnoMartes;
    private Turnos turnoMiercoles;
    private Turnos turnoJueves;
    private Turnos turnoViernes;
    private Turnos turnoSabado;
    private Turnos turnoPremio;
 
    
    
    private String idempleado; //LA TRAIGO EN LA CLASE ControladorEmpleado EN EL METODO QUE EJECUTA ESE JFRAME.
    static String sueldo=null;
    public Empleado emp;
    
    
    public ControladorImporte(Consultas consulta,GenerarImporte generarImp, Turnos turno, String idempleado){
        this.consulta=consulta;
        this.generarImp=generarImp;
        this.turno=turno;
        this.idempleado=idempleado;
      
        
        //botones Frame Generar Importe
        generarImp.botonGuardarTodo.addActionListener(this);
        generarImp.btnCalcularTotal.addActionListener(this);
        generarImp.ComboBoxDias.addActionListener(this);
    }
    
    
    
    
    
    
    
    
    public ControladorImporte(Consultas consulta,PagosEmpleado pagosE,Turnos turnoL,Turnos turnoMa, Turnos turnoMi, 
            Turnos turnoJ, Turnos turnoV, Turnos turnoS, Turnos turnoP, String idempleado){
        
        this.consulta=consulta;
        this.pagosE=pagosE;
        this.turnoLunes=turnoL;
        this.turnoMartes=turnoMa;
        this.turnoMiercoles=turnoMi;
        this.turnoJueves=turnoJ;
        this.turnoViernes=turnoV;
        this.turnoSabado=turnoS;
        this.turnoPremio=turnoP;
        this.idempleado=idempleado;
        
        
        pagosE.btnGuardar.addActionListener(this);
        pagosE.checkLunes.addActionListener(this);
        pagosE.checkMartes.addActionListener(this);
        pagosE.checkMiercoles.addActionListener(this);
        pagosE.checkJueves.addActionListener(this);
        pagosE.checkViernes.addActionListener(this);
        pagosE.checkSabado.addActionListener(this);
        pagosE.checkPremio.addActionListener(this);
        pagosE.btnModificar.addActionListener(this);
        pagosE.btnVerTotal.addActionListener(this);
        pagosE.btnSeleccionar.addActionListener(this);
        pagosE.btnVerPagos.addActionListener(this);
        iniciarTable();
    }
            
    public void iniciar(){
             
        pagosE.setTitle("IMPORTES");
        pagosE.setLocationRelativeTo(null);
        pagosE.txtEmpleado.setText(consulta.traerNombre(idempleado));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     // guardarPagos(e);
      btnTotalTurnos(e);
      guardarPago(e);
      modificarPago(e);
      traerPagos(e);
      verPagos(e);
    }
    
  
    
    public void iniciarTable() {
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int fila, int columna){
                if(columna == 1){
                    return true;
                }
                else{
                    return false;
                }
            }
        };
        modelo.addColumn("NOMBRE Y APELLIDO");
        pagosE.getTablePagarEmpleados().setRowHeight(30);
        pagosE.getTablePagarEmpleados().setModel(modelo);
        importarDatos(modelo);
    }
    
    
    
    public void importarDatos(DefaultTableModel model){
        Connection conn = conexion.getConnection();
        Statement st;
        String[] dato = new String[4];

        try {
            String sql = "SELECT * FROM empleados ORDER BY nombre ";

            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

             
                dato[0] = rs.getString(3);
               
              
                model.addRow(dato);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
  
    
    public void guardarPago(ActionEvent e){
       
        BarraProgreso pgBar = new BarraProgreso();
        
        if(e.getSource() == pagosE.btnGuardar){
            if(!seleccionoEmpleado()){
            
            if( !fechaSinSeleccionar() ){
                java.util.Date date = pagosE.fechaTurno.getDate();
                long d = date.getTime();
                java.sql.Date fecha= new java.sql.Date(d);
                
              
            try{
                if(!consulta.verificarDiaExistente(idempleado, "1")
                        || !consulta.verificarDiaExistente(idempleado, "2")
                        || !consulta.verificarDiaExistente(idempleado, "3")
                        || !consulta.verificarDiaExistente(idempleado, "4")
                        || !consulta.verificarDiaExistente(idempleado, "5")
                        || !consulta.verificarDiaExistente(idempleado, "6")
                        || !consulta.verificarDiaExistente(idempleado, "8")
                        
                        
                        ){
              
                                            
            
            turnos(turnoLunes,idempleado,fecha,pagosE.txt1L.getText(),pagosE.txt2L.getText(),pagosE.txt3L.getText(),pagosE.txt4L.getText(),pagosE.txtLDes.getText());
                
                        
              
            turnos(turnoMartes,idempleado,fecha,pagosE.txt1Ma.getText(),pagosE.txt2Ma.getText(),pagosE.txt3Ma.getText(),pagosE.txt4Ma.getText(),pagosE.txtMaDes.getText());
                
              
              
            turnos(turnoMiercoles,idempleado,fecha,pagosE.txt1Mi.getText(),pagosE.txt2Mi.getText(),pagosE.txt3Mi.getText(),pagosE.txt4Mi.getText(),pagosE.txtMiDes.getText());
                 
            turnos(turnoJueves,idempleado,fecha,pagosE.txt1J.getText(),pagosE.txt2J.getText(),pagosE.txt3J.getText(),pagosE.txt4J.getText(),pagosE.txtJDes.getText());

            
            turnos(turnoViernes,idempleado,fecha,pagosE.txt1V.getText(),pagosE.txt2V.getText(),pagosE.txt3V.getText(),pagosE.txt4V.getText(),pagosE.txtVDes.getText());

               
                
            turnos(turnoSabado,idempleado,fecha,pagosE.txt1S.getText(),pagosE.txt2S.getText(),pagosE.txt3S.getText(),pagosE.txt4S.getText(),pagosE.txtSDes.getText());

               
                
            turnos(turnoPremio,idempleado,fecha,pagosE.txt1P.getText(),pagosE.txt2P.getText(),pagosE.txt3P.getText(),pagosE.txt4P.getText(),pagosE.txtPDes.getText());

                        
                
                if(consulta.guardarTurnos(turnoLunes)){
                     consultaGuardarTurnos("1",idempleado);
                                     
                }
               
                if(consulta.guardarTurnos(turnoMartes)){
                     consultaGuardarTurnos("2",idempleado);
                    
                }
                if(consulta.guardarTurnos(turnoMiercoles)){
                     consultaGuardarTurnos("3",idempleado);
                     
                }
                if(consulta.guardarTurnos(turnoJueves)){
                    
                    consultaGuardarTurnos("4",idempleado);
                 
                }
                if(consulta.guardarTurnos(turnoViernes)){
                    
                    consultaGuardarTurnos("5",idempleado);
                
                }
                if(consulta.guardarTurnos(turnoSabado)){
                    
                    
                    consultaGuardarTurnos("6",idempleado);
                

                 }
                if(consulta.guardarTurnos(turnoPremio)){
                    
                    
                    consultaGuardarTurnos("8",idempleado);
                 

                }
                
                
   
                
                asignarDescuentoE(idempleado);
                asignarSubtotalE(idempleado);
                consulta.asignarSueldo(valueOf(calcularSueldoE()),idempleado);
                
                ControladorBarra cb = new ControladorBarra();
                cb.pgbar();  
                
                
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><p style = \"font:20px\"> EL PAGO DEL EMPLEADO YA SE EFECTUO, "
                    + "PARA MODIFICAR PAGO PRESIONAR EL BOTON MODIFICAR </p></html>","ERROR DE SINTAXYS", 0);

                }
                }
                
            catch (Exception ex){
               System.out.println(ex);
            } 
                    
            
            
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><p style = \"font:20px\"> NO INGRESO FECHA, INGERESE FECHA EN EL CALENDARIO</p></html>","ERROR DE SINTAXYS", 0);
            }
              
        }
            else{
                JOptionPane.showMessageDialog(null,"<html><p style = \"font:20px\"> NO SELECCIONO EMPLEADO, BUSQUE EMPELADO Y PRESIONE SELECCIONAR</p></html>","ERROR DE SINTAXYS", 0);

            } 
        }
          
    }
    
    public int calcularSueldoE(){
         int desT = parseInt(consulta.traerDescE(idempleado));
         int subT = parseInt(consulta.traerSubtotalesT(idempleado));
         int sueldo = subT-desT;
         return sueldo;
    }
    
    public void turnos(Turnos turno,String idempleado, Date fecha, String dia1,String dia2, String dia3,String dia4,String diaDesc ){
        
         turno.setTurnoUno(isCero(dia1)?dia1:"0");
                turno.setTurnoDos(isCero(dia2)?dia2:"0");
                turno.setTurnoTres(isCero(dia3)?dia3:"0");
                turno.setTurnoCuatro(isCero(dia4)?dia4:"0");
                turno.setDescuento(isCero(diaDesc)?diaDesc:"0");
                turno.setTotal(valueOf(calcular_subtotal(dia1,dia2,dia3,dia4)));
                turno.setIdempleado(idempleado);
                turno.setFecha(fecha);
        
        
    }
        
    
    public void consultaGuardarTurnos(String dia,String idempleado){
        consulta.agregar_diasturno(dia, consulta.traerid_turno());
        consulta.agregar_iddia_empleado(idempleado);
        String idturnosDos = consulta.traerid_turno();
        String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
        consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
        
    }
    
    
    public boolean isCero(String numero){
        if(numero.isEmpty()){
            return false;
        }else{
            return true;
        }
        
        
    }
    
    public boolean seleccionoEmpleado(){
        if(pagosE.txtEmpleado.getText().isEmpty()){
            return true;
        }
        else{
        return false;
        }
    }
    
    
    public void btnTotalTurnos(ActionEvent e){
        
        if(e.getSource()==pagosE.btnVerTotal){
          
          pagosE.txtTotal.setText(String.valueOf(calcular_total()));
        }
    }
    
    public int calcularTotal(){
        int total=0;
        int totalCajas=0;
        totalCajas+=(isCero(generarImp.txtt1.getText())?parseInt(generarImp.txtt1.getText()):0)+
                (isCero(generarImp.txtt2.getText())?parseInt(generarImp.txtt2.getText()):0)+
                (isCero(generarImp.txtt3.getText())?parseInt(generarImp.txtt3.getText()):0)+
                (isCero(generarImp.txtt4.getText())?parseInt(generarImp.txtt4.getText()):0)+
                (isCero(generarImp.txtt5.getText())?parseInt(generarImp.txtt5.getText()):0)+
                (isCero(generarImp.txtt6.getText())?parseInt(generarImp.txtt6.getText()):0);
        int descuento = isCero(generarImp.cajaDescuento.getText())?parseInt(generarImp.cajaDescuento.getText()):0;
        total=totalCajas-descuento;
        generarImp.txtTotal.setText(valueOf(total));
        return total;
       
    } 
    
    public int calcular_subtotal(String txt1, String txt2, String txt3, String txt4){
        int subtotal =0;
        int subtotal_cajas=0;
        subtotal_cajas+=(isCero(txt1)?parseInt(txt1):0)+
                (isCero(txt2)?parseInt(txt2):0)+
                (isCero(txt3)?parseInt(txt3):0)+
                (isCero(txt4)?parseInt(txt4):0);
   
    
        if(verficaFilaBlancos(txt1,txt2,txt3,txt4)){
            subtotal=subtotal_cajas;
        }
        else{
            subtotal=subtotal_cajas;
        }
        return subtotal;        
                     
    }
    
    
    /*metodo que asigna la suma de los descuentos del empleado y se lo asigna
    al campo descuentos_totales de la tabla empleados*/
    public void asignarDescuentoE(String idempleado){
        int descT = 0;
        descT = parseInt(consulta.calcularDescuentosTotales(idempleado));
        consulta.asignarDescuentoTotal(valueOf(descT),idempleado);
    }
    
    /*metodo que asigna la suma de los totales de la tabla turno a subtotales_totales
    de la tabla empleados*/
    public void asignarSubtotalE(String idempleado){
        int subT=0;
        subT=parseInt(consulta.calcularSubtotalesTotales(idempleado));
        consulta.asignarSubtotalTotal(valueOf(subT), idempleado);
    }
    
    
    public void setearTxtEnCero(){
        generarImp.txtt1.setText("");
        generarImp.txtt2.setText("");
        generarImp.txtt3.setText("");
        generarImp.txtt4.setText("");
        generarImp.txtt5.setText("");
        generarImp.txtt6.setText("");
        generarImp.cajaDescuento.setText("");
        generarImp.txtTotal.setText("");
        
    }
    
    public boolean fechaVacia(){
       if(generarImp.calendario.getDate() == null){
           return true;
       }
       return false;
   }
    
   public boolean fechaSinSeleccionar(){
       if(pagosE.fechaTurno.getDate() == null ){
           return true;
       }
       return false;
   }
    
    
    
    
    public boolean totalVacio(){
        if(generarImp.txtTotal  == null){
            return true;
        }
        return false;
    }
    
    public String id_turno(String dia){
        String idturno = (consulta.idTurno_empleado(idempleado,dia));
        return idturno;
    }
    
    
    public void modificarPago(ActionEvent e){
        if(e.getSource() == pagosE.btnModificar){
          if(!verificarNombreEnLabel()){
           if (consulta.verificarDiaExistente(idempleado, "1")) {
            //if(!verificarTodoBlancos(pagosE)){
                
                turnoLunes.setTurnoUno(isCero(pagosE.txt1L.getText())?pagosE.txt1L.getText():"0");
                turnoLunes.setTurnoDos(isCero(pagosE.txt2L.getText())?pagosE.txt2L.getText():"0");
                turnoLunes.setTurnoTres(isCero(pagosE.txt3L.getText())?pagosE.txt3L.getText():"0");
                turnoLunes.setTurnoCuatro(isCero(pagosE.txt4L.getText())?pagosE.txt4L.getText():"0");
                turnoLunes.setDescuento(isCero(pagosE.txtLDes.getText())?pagosE.txtLDes.getText():"0");
                turnoLunes.setTotal(valueOf(calcular_subtotal(pagosE.txt1L.getText(),pagosE.txt2L.getText(),pagosE.txt3L.getText(),pagosE.txt4L.getText())));
                turnoLunes.setIdturno(id_turno("Lunes"));
          
            
          
            
                turnoMartes.setTurnoUno(isCero(pagosE.txt1Ma.getText())?pagosE.txt1Ma.getText():"0");
                turnoMartes.setTurnoDos(isCero(pagosE.txt2Ma.getText())?pagosE.txt2Ma.getText():"0");
                turnoMartes.setTurnoTres(isCero(pagosE.txt3Ma.getText())?pagosE.txt3Ma.getText():"0");
                turnoMartes.setTurnoCuatro(isCero(pagosE.txt4Ma.getText())?pagosE.txt4Ma.getText():"0");
                turnoMartes.setDescuento(isCero(pagosE.txtMaDes.getText())?pagosE.txtMaDes.getText():"0");
                turnoMartes.setTotal(valueOf(calcular_subtotal(pagosE.txt1Ma.getText(),pagosE.txt2Ma.getText(),pagosE.txt3Ma.getText(),pagosE.txt4Ma.getText())));

                turnoMartes.setIdturno(id_turno("Martes"));


                turnoMiercoles.setTurnoUno(isCero(pagosE.txt1Mi.getText())?pagosE.txt1Mi.getText():"0");
                turnoMiercoles.setTurnoDos(isCero(pagosE.txt2Mi.getText())?pagosE.txt2Mi.getText():"0");
                turnoMiercoles.setTurnoTres(isCero(pagosE.txt3Mi.getText())?pagosE.txt3Mi.getText():"0");
                turnoMiercoles.setTurnoCuatro(isCero(pagosE.txt4Mi.getText())?pagosE.txt4Mi.getText():"0");
                turnoMiercoles.setDescuento(isCero(pagosE.txtMiDes.getText())?pagosE.txtMiDes.getText():"0");
                turnoMiercoles.setTotal(valueOf(calcular_subtotal(pagosE.txt1Mi.getText(),pagosE.txt2Mi.getText(),pagosE.txt3Mi.getText(),pagosE.txt4Mi.getText())));

                turnoMiercoles.setIdturno(id_turno("Miercoles"));


                turnoJueves.setTurnoUno(isCero(pagosE.txt1J.getText())?pagosE.txt1J.getText():"0");
                turnoJueves.setTurnoDos(isCero(pagosE.txt2J.getText())?pagosE.txt2J.getText():"0");
                turnoJueves.setTurnoTres(isCero(pagosE.txt3J.getText())?pagosE.txt3J.getText():"0");
                turnoJueves.setTurnoCuatro(isCero(pagosE.txt4J.getText())?pagosE.txt4J.getText():"0");
                turnoJueves.setDescuento(isCero(pagosE.txtJDes.getText())?pagosE.txtJDes.getText():"0");
                turnoJueves.setTotal(valueOf(calcular_subtotal(pagosE.txt1J.getText(),pagosE.txt2J.getText(),pagosE.txt3J.getText(),pagosE.txt4J.getText())));

                turnoJueves.setIdturno(id_turno("Jueves"));



                turnoViernes.setTurnoUno(isCero(pagosE.txt1V.getText())?pagosE.txt1V.getText():"0");
                turnoViernes.setTurnoDos(isCero(pagosE.txt2V.getText())?pagosE.txt2V.getText():"0");
                turnoViernes.setTurnoTres(isCero(pagosE.txt3V.getText())?pagosE.txt3V.getText():"0");
                turnoViernes.setTurnoCuatro(isCero(pagosE.txt4V.getText())?pagosE.txt4V.getText():"0");
                turnoViernes.setDescuento(isCero(pagosE.txtVDes.getText())?pagosE.txtVDes.getText():"0");
                turnoViernes.setTotal(valueOf(calcular_subtotal(pagosE.txt1V.getText(),pagosE.txt2V.getText(),pagosE.txt3V.getText(),pagosE.txt4V.getText())));

                turnoViernes.setIdturno(id_turno("Viernes"));


                turnoSabado.setTurnoUno(isCero(pagosE.txt1S.getText())?pagosE.txt1S.getText():"0");
                turnoSabado.setTurnoDos(isCero(pagosE.txt2S.getText())?pagosE.txt2S.getText():"0");
                turnoSabado.setTurnoTres(isCero(pagosE.txt3S.getText())?pagosE.txt3S.getText():"0");
                turnoSabado.setTurnoCuatro(isCero(pagosE.txt4S.getText())?pagosE.txt4S.getText():"0");
                turnoSabado.setDescuento(isCero(pagosE.txtSDes.getText())?pagosE.txtSDes.getText():"0");
                turnoSabado.setTotal(valueOf(calcular_subtotal(pagosE.txt1S.getText(),pagosE.txt2S.getText(),pagosE.txt3S.getText(),pagosE.txt4S.getText())));

                turnoSabado.setIdturno(id_turno("Sabado"));




                turnoPremio.setTurnoUno(isCero(pagosE.txt1P.getText())?pagosE.txt1P.getText():"0");
                turnoPremio.setTurnoDos(isCero(pagosE.txt2P.getText())?pagosE.txt2P.getText():"0");
                turnoPremio.setTurnoTres(isCero(pagosE.txt3P.getText())?pagosE.txt3P.getText():"0");
                turnoPremio.setTurnoCuatro(isCero(pagosE.txt4P.getText())?pagosE.txt4P.getText():"0");
                turnoPremio.setDescuento(isCero(pagosE.txtPDes.getText())?pagosE.txtPDes.getText():"0");
                turnoPremio.setTotal(valueOf(calcular_subtotal(pagosE.txt1P.getText(),pagosE.txt2P.getText(),pagosE.txt3P.getText(),pagosE.txt4P.getText())));

                turnoPremio.setIdturno(id_turno("Extra"));



                   if(consulta.editarTurno(turnoLunes)
                        && consulta.editarTurno(turnoMartes)
                        && consulta.editarTurno(turnoMiercoles)
                        && consulta.editarTurno(turnoJueves)
                        && consulta.editarTurno(turnoViernes)
                        && consulta.editarTurno(turnoSabado)
                        && consulta.editarTurno(turnoPremio)
                        ){

                    //int sueldoPrimario = parseInt(consulta.calcularSueldo(idempleado)); //SUELDO DEL EMPLEADO QUE USO EN CONTROLADOR EMPLEADO
                    
                    asignarDescuentoE(idempleado);
                    asignarSubtotalE(idempleado);
                    consulta.asignarSueldo(valueOf(calcularSueldoE()),idempleado);
                    //excepcion
                    JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> TURNO MODIFICADO CON EXITO </p></html>");

         
               }
               
              
                
            //}
                else{
                   JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> RELLENE CON CERO </p></html>");
               }
            }
            else{
                   JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> NO SE PUEDE MODIFICAR DEBIDO A QUE NO SE EFECTUO PAGO,<br>"
                           + " ASEGURESE DE GUARDAR EL PAGO HACIENDO CLICK EN EL BOTON GUARDAR </p></html>");
               }
        }
        else{
                   JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> NO SELECCIONO NINGUN EMPLEADO,<br>"
                           + " SELECCIONE UNO EN LA TABLA, LUEGO PRESIONAR EL BOTON SELECCIONAR </p></html>");
               }
        }
        }
    
    public void setearLunes(){
    }
    
    
    
    
    
    public int calcular_total(){
        int total=0;
        int totalCajas=0;
        totalCajas+= (isCero(pagosE.txt1L.getText())?parseInt(pagosE.txt1L.getText()):0)+
                (isCero(pagosE.txt2L.getText())?parseInt(pagosE.txt2L.getText()):0)+
                (isCero(pagosE.txt3L.getText())?parseInt(pagosE.txt3L.getText()):0)+
                (isCero(pagosE.txt4L.getText())?parseInt(pagosE.txt4L.getText()):0)+
                
                (isCero(pagosE.txt1Ma.getText())?parseInt(pagosE.txt1Ma.getText()):0)+
                (isCero(pagosE.txt2Ma.getText())?parseInt(pagosE.txt2Ma.getText()):0)+
                (isCero(pagosE.txt3Ma.getText())?parseInt(pagosE.txt3Ma.getText()):0)+
                (isCero(pagosE.txt4Ma.getText())?parseInt(pagosE.txt4Ma.getText()):0)+
                
                
                (isCero(pagosE.txt1Mi.getText())?parseInt(pagosE.txt1Mi.getText()):0)+
                (isCero(pagosE.txt2Mi.getText())?parseInt(pagosE.txt2Mi.getText()):0)+
                (isCero(pagosE.txt3Mi.getText())?parseInt(pagosE.txt3Mi.getText()):0)+
                (isCero(pagosE.txt4Mi.getText())?parseInt(pagosE.txt4Mi.getText()):0)+
              
                
                (isCero(pagosE.txt1J.getText())?parseInt(pagosE.txt1J.getText()):0)+
                (isCero(pagosE.txt2J.getText())?parseInt(pagosE.txt2J.getText()):0)+
                (isCero(pagosE.txt3J.getText())?parseInt(pagosE.txt3J.getText()):0)+
                (isCero(pagosE.txt4J.getText())?parseInt(pagosE.txt4J.getText()):0)+
                
                
                (isCero(pagosE.txt1V.getText())?parseInt(pagosE.txt1V.getText()):0)+
                (isCero(pagosE.txt2V.getText())?parseInt(pagosE.txt2V.getText()):0)+
                (isCero(pagosE.txt3V.getText())?parseInt(pagosE.txt3V.getText()):0)+
                (isCero(pagosE.txt4V.getText())?parseInt(pagosE.txt4V.getText()):0)+
               
                
                (isCero(pagosE.txt1S.getText())?parseInt(pagosE.txt1S.getText()):0)+
                (isCero(pagosE.txt2S.getText())?parseInt(pagosE.txt2S.getText()):0)+
                (isCero(pagosE.txt3S.getText())?parseInt(pagosE.txt3S.getText()):0)+
                (isCero(pagosE.txt4S.getText())?parseInt(pagosE.txt4S.getText()):0)+
            
                
                (isCero(pagosE.txt1P.getText())?parseInt(pagosE.txt1P.getText()):0)+
                (isCero(pagosE.txt2P.getText())?parseInt(pagosE.txt2P.getText()):0)+
                (isCero(pagosE.txt3P.getText())?parseInt(pagosE.txt3P.getText()):0)+
                (isCero(pagosE.txt4P.getText())?parseInt(pagosE.txt4P.getText()):0);
            
        
        int descuento =0;
       
        descuento +=(isCero(pagosE.txtLDes.getText())?parseInt(pagosE.txtLDes.getText()):0)+
                    (isCero(pagosE.txtMaDes.getText())?parseInt(pagosE.txtMaDes.getText()):0)+
                    (isCero(pagosE.txtMiDes.getText())?parseInt(pagosE.txtMiDes.getText()):0)+
                    (isCero(pagosE.txtJDes.getText())?parseInt(pagosE.txtJDes.getText()):0)+
                    (isCero(pagosE.txtVDes.getText())?parseInt(pagosE.txtVDes.getText()):0)+
                    (isCero(pagosE.txtSDes.getText())?parseInt(pagosE.txtSDes.getText()):0)+
                    (isCero(pagosE.txtPDes.getText())?parseInt(pagosE.txtPDes.getText()):0);
                
        total=totalCajas-descuento;
        
         return total;         
    }
    
    
    //metodo que verifica los txt que esten en blanco
    public boolean verificarBlancos(PagosEmpleado pagosE){
        
        return pagosE.txt1L.getText().isEmpty()
            || pagosE.txt2L.getText().isEmpty()
            || pagosE.txt3L.getText().isEmpty()
            || pagosE.txt4J.getText().isEmpty()
            || pagosE.txtLDes.getText().isEmpty()
                
            || pagosE.txt1Ma.getText().isEmpty()
            || pagosE.txt2Ma.getText().isEmpty()
            || pagosE.txt3Ma.getText().isEmpty()
            || pagosE.txt4Ma.getText().isEmpty()
            || pagosE.txtMaDes.getText().isEmpty()
            
            || pagosE.txt1Mi.getText().isEmpty()
            || pagosE.txt2Mi.getText().isEmpty()
            || pagosE.txt3Mi.getText().isEmpty()
            || pagosE.txt4Mi.getText().isEmpty()
            || pagosE.txtMiDes.getText().isEmpty()
            
            || pagosE.txt1J.getText().isEmpty()
            || pagosE.txt2J.getText().isEmpty()
            || pagosE.txt3J.getText().isEmpty()
            ||pagosE.txt4J.getText().isEmpty()
            || pagosE.txtJDes.getText().isEmpty()
            
            || pagosE.txt1V.getText().isEmpty()
            || pagosE.txt2J.getText().isEmpty()
            || pagosE.txt3J.getText().isEmpty()
            || pagosE.txt4J.getText().isEmpty()
            || pagosE.txtVDes.getText().isEmpty()
            
            || pagosE.txt1S.getText().isEmpty()
            || pagosE.txt2S.getText().isEmpty()
            || pagosE.txt3S.getText().isEmpty()
            || pagosE.txt4V.getText().isEmpty()
            || pagosE.txtSDes.getText().isEmpty()
            
            || pagosE.txt1P.getText().isEmpty()
            || pagosE.txt2P.getText().isEmpty()
            || pagosE.txt3P.getText().isEmpty()
            || pagosE.txt4P.getText().isEmpty()
            || pagosE.txtPDes.getText().isEmpty();
            
      
    }
    
    public boolean verificarTodoBlancos(PagosEmpleado pagosE){
        
        return pagosE.txt1L.getText().isEmpty()
            &&pagosE.txt2L.getText().isEmpty()
            && pagosE.txt3L.getText().isEmpty()
            && pagosE.txt4J.getText().isEmpty()
            && pagosE.txtLDes.getText().isEmpty()
                
            && pagosE.txt1Ma.getText().isEmpty()
            && pagosE.txt2Ma.getText().isEmpty()
            && pagosE.txt3Ma.getText().isEmpty()
            &&pagosE.txt4Ma.getText().isEmpty()
            && pagosE.txtMaDes.getText().isEmpty()
            
            && pagosE.txt1Mi.getText().isEmpty()
            && pagosE.txt2Mi.getText().isEmpty()
            && pagosE.txt3Mi.getText().isEmpty()
            && pagosE.txt4Mi.getText().isEmpty()
            && pagosE.txtMiDes.getText().isEmpty()
            
            && pagosE.txt1J.getText().isEmpty()
            && pagosE.txt2J.getText().isEmpty()
            && pagosE.txt3J.getText().isEmpty()
            &&pagosE.txt4J.getText().isEmpty()
            && pagosE.txtJDes.getText().isEmpty()
            
            && pagosE.txt1V.getText().isEmpty()
            && pagosE.txt2J.getText().isEmpty()
            && pagosE.txt3J.getText().isEmpty()
            && pagosE.txt4J.getText().isEmpty()
            && pagosE.txtVDes.getText().isEmpty()
            
            && pagosE.txt1S.getText().isEmpty()
            && pagosE.txt2S.getText().isEmpty()
            && pagosE.txt3S.getText().isEmpty()
            && pagosE.txt4V.getText().isEmpty()
            && pagosE.txtSDes.getText().isEmpty()
            
            && pagosE.txt1P.getText().isEmpty()
            && pagosE.txt2P.getText().isEmpty()
            && pagosE.txt3P.getText().isEmpty()
            && pagosE.txt4P.getText().isEmpty()
            && pagosE.txtPDes.getText().isEmpty();
            
      
    }
    
    //Metodo para resolver el negativo del subtotal
    public boolean verficaFilaBlancos(String t1, String t2, String t3, String t4){
        return t1.isEmpty() 
                && t2.isEmpty()
                && t3.isEmpty()
                && t4.isEmpty();
    }
    
    
    public boolean verificarNombreEnLabel(){
        boolean valor = true;
        if(pagosE.txtEmpleado.getText().isEmpty()){
            valor=true;
        }
        else{
            valor=false;
        }
        return valor;
    }
    
    public void traerPagos(ActionEvent e){
        if(e.getSource() == pagosE.btnSeleccionar){
           pagosE.txtTotal.setText("");
           int fila = pagosE.getTablePagarEmpleados().getSelectedRow();
        
           if (fila >= 0) {
                idempleado = consulta.traerId_porNombre(pagosE.getTablePagarEmpleados().getValueAt(fila, 0).toString());
                iniciar();
                
                turnoLunes=consulta.turnoModificado(idempleado, "Lunes");
                pagosE.txt1L.setText(turnoLunes.getTurnoUno());
                pagosE.txt2L.setText(turnoLunes.getTurnoDos());
                pagosE.txt3L.setText(turnoLunes.getTurnoTres());
                pagosE.txt4L.setText(turnoLunes.getTurnoCuatro());
                pagosE.txtLDes.setText(turnoLunes.getDescuento());
                
                turnoMartes=consulta.turnoModificado(idempleado, "Martes");
                pagosE.txt1Ma.setText(turnoMartes.getTurnoUno());
                pagosE.txt2Ma.setText(turnoMartes.getTurnoDos());
                pagosE.txt3Ma.setText(turnoMartes.getTurnoTres());
                pagosE.txt4Ma.setText(turnoMartes.getTurnoCuatro());
                pagosE.txtMaDes.setText(turnoMartes.getDescuento());
                
                turnoMiercoles=consulta.turnoModificado(idempleado, "Miercoles");
                pagosE.txt1Mi.setText(turnoMiercoles.getTurnoUno());
                pagosE.txt2Mi.setText(turnoMiercoles.getTurnoDos());
                pagosE.txt3Mi.setText(turnoMiercoles.getTurnoTres());
                pagosE.txt4Mi.setText(turnoMiercoles.getTurnoCuatro());
                pagosE.txtMiDes.setText(turnoMiercoles.getDescuento());
                
                turnoJueves=consulta.turnoModificado(idempleado, "Jueves");
                pagosE.txt1J.setText(turnoJueves.getTurnoUno());
                pagosE.txt2J.setText(turnoJueves.getTurnoDos());
                pagosE.txt3J.setText(turnoJueves.getTurnoTres());
                pagosE.txt4J.setText(turnoJueves.getTurnoCuatro());
                pagosE.txtJDes.setText(turnoJueves.getDescuento());
                
                turnoViernes=consulta.turnoModificado(idempleado, "Viernes");
                pagosE.txt1V.setText(turnoViernes.getTurnoUno());
                pagosE.txt2V.setText(turnoViernes.getTurnoDos());
                pagosE.txt3V.setText(turnoViernes.getTurnoTres());
                pagosE.txt4V.setText(turnoViernes.getTurnoCuatro());
                pagosE.txtVDes.setText(turnoViernes.getDescuento());
                
                turnoSabado=consulta.turnoModificado(idempleado, "Sabado");
                pagosE.txt1S.setText(turnoSabado.getTurnoUno());
                pagosE.txt2S.setText(turnoSabado.getTurnoDos());
                pagosE.txt3S.setText(turnoSabado.getTurnoTres());
                pagosE.txt4S.setText(turnoSabado.getTurnoCuatro());
                pagosE.txtSDes.setText(turnoSabado.getDescuento());
                
                turnoPremio=consulta.turnoModificado(idempleado, "Extra");
                pagosE.txt1P.setText(turnoPremio.getTurnoUno());
                pagosE.txt2P.setText(turnoPremio.getTurnoDos());
                pagosE.txt3P.setText(turnoPremio.getTurnoTres());
                pagosE.txt4P.setText(turnoPremio.getTurnoCuatro());
                pagosE.txtPDes.setText(turnoPremio.getDescuento());
        }
   
        }
    }
    
  
    public void verPagos(ActionEvent e){
        if (e.getSource() == pagosE.btnVerPagos){
            try {
                consulta.guardarMensualidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            VerPagos reporte = new VerPagos();

            reporte.conexionReporte();
           
        }
    }
    
    
    
    
    
    
    
}

    
 

    

