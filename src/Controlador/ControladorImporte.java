
package Controlador;

import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Vista.BarraProgreso;
import Vista.BarraProgresoGuardar;
import Vista.GenerarImporte;
import Vista.PagosEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class ControladorImporte implements ActionListener{
    private Consultas consulta;
    private ConexionBD conexion = new ConexionBD();
    private GenerarImporte generarImp;
    private PagosEmpleado pagosE;
    private Turnos turno;
    private BarraProgreso progresBar;
    private BarraProgresoGuardar progresBarG;
    private Timer time;
    
    
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
      
        
    }
            
    public void iniciar(){
       /* generarImp.setTitle("IMPORTES");
        generarImp.setLocationRelativeTo(null);
        generarImp.txtTotal.setEditable(false);
        generarImp.txt_nombre_emp.setText(consulta.traerNombre(idempleado));
        setearTxtEnCero();*/
        
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
    }
    
  
    
    
    /*public void guardarPagos(ActionEvent e){
       if(e.getSource()==generarImp.botonGuardarTodo){
           
           if (!fechaVacia() && !totalVacio()){
               
           
           String id_dia = consulta.traerid_dia(generarImp.ComboBoxDias.getSelectedItem().toString());
           try{
               
           
           if(!consulta.verificarDiaExistente(idempleado,id_dia)){
                java.util.Date date = generarImp.calendario.getDate();
                long d = date.getTime();
                java.sql.Date fecha= new java.sql.Date(d);
                
          
                turno.setTurnoUno(isCero(generarImp.txtt1.getText())?generarImp.txtt1.getText():"0");
                turno.setTurnoDos(isCero(generarImp.txtt2.getText())?generarImp.txtt2.getText():"0");
                turno.setTurnoTres(isCero(generarImp.txtt3.getText())?generarImp.txtt3.getText():"0");
                turno.setTurnoCuatro(isCero(generarImp.txtt4.getText())?generarImp.txtt4.getText():"0");
                turno.setDescuento(isCero(generarImp.cajaDescuento.getText())?generarImp.cajaDescuento.getText():"0");
                turno.setFecha(fecha);
                turno.setTotal(valueOf(calcularTotal()));
                turno.setIdempleado(idempleado);
                
                
                
                if(consulta.guardarTurnos(turno)){
                    if(consulta.agregar_diasturno(consulta.traerid_dia(generarImp.ComboBoxDias.getSelectedItem().toString()), consulta.traerid_turno())){
                        if(consulta.agregar_iddia_empleado(idempleado)){
                            setearTxtEnCero();
                            String idturnosDos = consulta.traerid_turno();
                            String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                       
                       
                            consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
                       
                       
                            JOptionPane.showMessageDialog(null,"TURNO REGISTRADO");
                          
                            int sueldoPrimario = parseInt(consulta.calcularSueldo(idempleado)); //SUELDO DEL EMPLEADO QUE USO EN CONTROLADOR EMPLEADO
                            sueldo=Integer.toString(sueldoPrimario);
                          
                            consulta.asignarSueldo(sueldo,idempleado);
                   }
               }
           }
        
            
        } 
           else{
               String dia = generarImp.ComboBoxDias.getSelectedItem().toString();
               JOptionPane.showMessageDialog(null, "YA SE GENERO EL DIA " + dia + " PARA EL EMPLEADO SOLICITADO ", "ERROR AL EFECTUAR PAGO", 0);
           }
           } 
           catch (Exception ex){
               System.out.println(ex);
            }      
        }
           
           else {
              JOptionPane.showMessageDialog(null,"NO INGRESO FECHA, INGERESE FECHA EN EL CALENDARIO","ERROR DE SINTAXYS", 0);
            }
       }
       
       
    }*/
    
    public void guardarPago(ActionEvent e){
       
        BarraProgreso pgBar = new BarraProgreso();
        
        if(e.getSource() == pagosE.btnGuardar){
            
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
                ControladorBarra cb = new ControladorBarra();
                cb.pgbar();
                                            
                                
                turnoLunes.setTurnoUno(isCero(pagosE.txt1L.getText())?pagosE.txt1L.getText():"0");
                turnoLunes.setTurnoDos(isCero(pagosE.txt2L.getText())?pagosE.txt2L.getText():"0");
                turnoLunes.setTurnoTres(isCero(pagosE.txt3L.getText())?pagosE.txt3L.getText():"0");
                turnoLunes.setTurnoCuatro(isCero(pagosE.txt4L.getText())?pagosE.txt4L.getText():"0");
                turnoLunes.setDescuento(isCero(pagosE.txtLDes.getText())?pagosE.txtLDes.getText():"0");
                turnoLunes.setTotal(valueOf(calcular_subtotal(pagosE.txt1L.getText(),pagosE.txt2L.getText(),pagosE.txt3L.getText(),pagosE.txt4L.getText(),pagosE.txtLDes.getText())));
                turnoLunes.setIdempleado(idempleado);
                turnoLunes.setFecha(fecha);
                
                                
                turnoMartes.setTurnoUno(isCero(pagosE.txt1Ma.getText())?pagosE.txt1Ma.getText():"0");
                turnoMartes.setTurnoDos(isCero(pagosE.txt2Ma.getText())?pagosE.txt2Ma.getText():"0");
                turnoMartes.setTurnoTres(isCero(pagosE.txt3Ma.getText())?pagosE.txt3Ma.getText():"0");
                turnoMartes.setTurnoCuatro(isCero(pagosE.txt4Ma.getText())?pagosE.txt4Ma.getText():"0");
                turnoMartes.setDescuento(isCero(pagosE.txtMaDes.getText())?pagosE.txtMaDes.getText():"0");
                turnoMartes.setTotal(valueOf(calcular_subtotal(pagosE.txt1Ma.getText(),pagosE.txt2Ma.getText(),pagosE.txt3Ma.getText(),pagosE.txt4Ma.getText(),pagosE.txtMaDes.getText())));
                turnoMartes.setIdempleado(idempleado);
                turnoMartes.setFecha(fecha);
                
                turnoMiercoles.setTurnoUno(isCero(pagosE.txt1Mi.getText())?pagosE.txt1Mi.getText():"0");
                turnoMiercoles.setTurnoDos(isCero(pagosE.txt2Mi.getText())?pagosE.txt2Mi.getText():"0");
                turnoMiercoles.setTurnoTres(isCero(pagosE.txt3Mi.getText())?pagosE.txt3Mi.getText():"0");
                turnoMiercoles.setTurnoCuatro(isCero(pagosE.txt4Mi.getText())?pagosE.txt4Mi.getText():"0");
                turnoMiercoles.setDescuento(isCero(pagosE.txtMiDes.getText())?pagosE.txtMiDes.getText():"0");
                turnoMiercoles.setTotal(valueOf(calcular_subtotal(pagosE.txt1Mi.getText(),pagosE.txt2Mi.getText(),pagosE.txt3Mi.getText(),pagosE.txt4Mi.getText(),pagosE.txtMiDes.getText())));
                turnoMiercoles.setIdempleado(idempleado);
                turnoMiercoles.setFecha(fecha);
                    
                turnoJueves.setTurnoUno(isCero(pagosE.txt1J.getText())?pagosE.txt1J.getText():"0");
                turnoJueves.setTurnoDos(isCero(pagosE.txt2J.getText())?pagosE.txt2J.getText():"0");
                turnoJueves.setTurnoTres(isCero(pagosE.txt3J.getText())?pagosE.txt3J.getText():"0");
                turnoJueves.setTurnoCuatro(isCero(pagosE.txt4J.getText())?pagosE.txt4J.getText():"0");
                turnoJueves.setDescuento(isCero(pagosE.txtJDes.getText())?pagosE.txtJDes.getText():"0");
                turnoJueves.setTotal(valueOf(calcular_subtotal(pagosE.txt1J.getText(),pagosE.txt2J.getText(),pagosE.txt3J.getText(),pagosE.txt4J.getText(),pagosE.txtJDes.getText())));
                turnoJueves.setIdempleado(idempleado);
                turnoJueves.setFecha(fecha);
                
                
                turnoViernes.setTurnoUno(isCero(pagosE.txt1V.getText())?pagosE.txt1V.getText():"0");
                turnoViernes.setTurnoDos(isCero(pagosE.txt2V.getText())?pagosE.txt2V.getText():"0");
                turnoViernes.setTurnoTres(isCero(pagosE.txt3V.getText())?pagosE.txt3V.getText():"0");
                turnoViernes.setTurnoCuatro(isCero(pagosE.txt4V.getText())?pagosE.txt4V.getText():"0");
                turnoViernes.setDescuento(isCero(pagosE.txtVDes.getText())?pagosE.txtVDes.getText():"0");
                turnoViernes.setTotal(valueOf(calcular_subtotal(pagosE.txt1V.getText(),pagosE.txt2V.getText(),pagosE.txt3V.getText(),pagosE.txt4V.getText(),pagosE.txtVDes.getText())));
                turnoViernes.setIdempleado(idempleado);
                turnoViernes.setFecha(fecha);

                
                turnoSabado.setTurnoUno(isCero(pagosE.txt1S.getText())?pagosE.txt1S.getText():"0");
                turnoSabado.setTurnoDos(isCero(pagosE.txt2S.getText())?pagosE.txt2S.getText():"0");
                turnoSabado.setTurnoTres(isCero(pagosE.txt3S.getText())?pagosE.txt3S.getText():"0");
                turnoSabado.setTurnoCuatro(isCero(pagosE.txt4S.getText())?pagosE.txt4S.getText():"0");
                turnoSabado.setDescuento(isCero(pagosE.txtSDes.getText())?pagosE.txtSDes.getText():"0");
                turnoSabado.setTotal(valueOf(calcular_subtotal(pagosE.txt1S.getText(),pagosE.txt2S.getText(),pagosE.txt3S.getText(),pagosE.txt4S.getText(),pagosE.txtSDes.getText())));
                turnoSabado.setIdempleado(idempleado);
                turnoSabado.setFecha(fecha);

                
                turnoPremio.setTurnoUno(isCero(pagosE.txt1P.getText())?pagosE.txt1P.getText():"0");
                turnoPremio.setTurnoDos(isCero(pagosE.txt2P.getText())?pagosE.txt2P.getText():"0");
                turnoPremio.setTurnoTres(isCero(pagosE.txt3P.getText())?pagosE.txt3P.getText():"0");
                turnoPremio.setTurnoCuatro(isCero(pagosE.txt4P.getText())?pagosE.txt4P.getText():"0");
                turnoPremio.setDescuento(isCero(pagosE.txtPDes.getText())?pagosE.txtPDes.getText():"0");
                turnoPremio.setTotal(valueOf(calcular_subtotal(pagosE.txt1P.getText(),pagosE.txt2P.getText(),pagosE.txt3P.getText(),pagosE.txt4P.getText(),pagosE.txtPDes.getText())));
                turnoPremio.setIdempleado(idempleado);
                turnoPremio.setFecha(fecha);
                
                               
                
                if(consulta.guardarTurnos(turnoLunes)){
                    consulta.agregar_diasturno("1", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
                    
                }
                if(consulta.guardarTurnos(turnoMartes)){
                    consulta.agregar_diasturno("2", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
                }
                if(consulta.guardarTurnos(turnoMiercoles)){
                    consulta.agregar_diasturno("3", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
                }
                if(consulta.guardarTurnos(turnoJueves)){
                    consulta.agregar_diasturno("4", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);
                }
                if(consulta.guardarTurnos(turnoViernes)){
                    consulta.agregar_diasturno("5", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);

                }
                if(consulta.guardarTurnos(turnoSabado)){
                    consulta.agregar_diasturno("6", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);

                 }
                if(consulta.guardarTurnos(turnoPremio)){
                    consulta.agregar_diasturno("8", consulta.traerid_turno());
                    consulta.agregar_iddia_empleado(idempleado);
                    String idturnosDos = consulta.traerid_turno();
                    String iddia = consulta.traerIdDiaDelTurno(idturnosDos);
                    consulta.agregar_empleado_turno(idempleado,consulta.traerid_turno(),iddia);

                }
                
                
                int sueldoPrimario = parseInt(consulta.calcularSueldo(idempleado)); //SUELDO DEL EMPLEADO QUE USO EN CONTROLADOR EMPLEADO
                sueldo=Integer.toString(sueldoPrimario);
                consulta.asignarSueldo(sueldo,idempleado);
                
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
          
    }
        
    
    
    
    
    public boolean isCero(String numero){
        if(numero.isEmpty()){
            return false;
        }else{
            return true;
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
    
    public int calcular_subtotal(String txt1, String txt2, String txt3, String txt4,String txtDes){
        int subtotal =0;
        int subtotal_cajas=0;
        subtotal_cajas+=(isCero(txt1)?parseInt(txt1):0)+
                (isCero(txt2)?parseInt(txt2):0)+
                (isCero(txt3)?parseInt(txt3):0)+
                (isCero(txt4)?parseInt(txt4):0);
        int descuento = (isCero(txtDes)?parseInt(txtDes):0);   
        subtotal=subtotal_cajas-descuento;
        return subtotal;        
                     
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
           BarraProgreso pgBar = new BarraProgreso();
           
        if(!verificarTodoBlancos(pagosE)){   
           if(!verificarBlancos(pagosE)){
           
            turnoLunes.setTurnoUno(isCero(pagosE.txt1L.getText())?pagosE.txt1L.getText():"0");
            turnoLunes.setTurnoDos(isCero(pagosE.txt2L.getText())?pagosE.txt2L.getText():"0");
            turnoLunes.setTurnoTres(isCero(pagosE.txt3L.getText())?pagosE.txt3L.getText():"0");
            turnoLunes.setTurnoCuatro(isCero(pagosE.txt4L.getText())?pagosE.txt4L.getText():"0");
            turnoLunes.setDescuento(isCero(pagosE.txtLDes.getText())?pagosE.txtLDes.getText():"0");
            turnoLunes.setTotal(valueOf(calcular_subtotal(pagosE.txt1L.getText(),pagosE.txt2L.getText(),pagosE.txt3L.getText(),pagosE.txt4L.getText(),pagosE.txtLDes.getText())));
            turnoLunes.setIdturno(id_turno("Lunes"));
          
            
          
            
            turnoMartes.setTurnoUno(isCero(pagosE.txt1Ma.getText())?pagosE.txt1Ma.getText():"0");
            turnoMartes.setTurnoDos(isCero(pagosE.txt2Ma.getText())?pagosE.txt2Ma.getText():"0");
            turnoMartes.setTurnoTres(isCero(pagosE.txt3Ma.getText())?pagosE.txt3Ma.getText():"0");
            turnoMartes.setTurnoCuatro(isCero(pagosE.txt4Ma.getText())?pagosE.txt4Ma.getText():"0");
            turnoMartes.setDescuento(isCero(pagosE.txtMaDes.getText())?pagosE.txtMaDes.getText():"0");
            turnoMartes.setTotal(valueOf(calcular_subtotal(pagosE.txt1Ma.getText(),pagosE.txt2Ma.getText(),pagosE.txt3Ma.getText(),pagosE.txt4Ma.getText(),pagosE.txtMaDes.getText())));
           
            turnoMartes.setIdturno(id_turno("Martes"));
        
                
            turnoMiercoles.setTurnoUno(isCero(pagosE.txt1Mi.getText())?pagosE.txt1Mi.getText():"0");
            turnoMiercoles.setTurnoDos(isCero(pagosE.txt2Mi.getText())?pagosE.txt2Mi.getText():"0");
            turnoMiercoles.setTurnoTres(isCero(pagosE.txt3Mi.getText())?pagosE.txt3Mi.getText():"0");
            turnoMiercoles.setTurnoCuatro(isCero(pagosE.txt4Mi.getText())?pagosE.txt4Mi.getText():"0");
            turnoMiercoles.setDescuento(isCero(pagosE.txtMiDes.getText())?pagosE.txtMiDes.getText():"0");
            turnoMiercoles.setTotal(valueOf(calcular_subtotal(pagosE.txt1Mi.getText(),pagosE.txt2Mi.getText(),pagosE.txt3Mi.getText(),pagosE.txt4Mi.getText(),pagosE.txtMiDes.getText())));
           
            turnoMiercoles.setIdturno(id_turno("Miercoles"));
           
                    
            turnoJueves.setTurnoUno(isCero(pagosE.txt1J.getText())?pagosE.txt1J.getText():"0");
            turnoJueves.setTurnoDos(isCero(pagosE.txt2J.getText())?pagosE.txt2J.getText():"0");
            turnoJueves.setTurnoTres(isCero(pagosE.txt3J.getText())?pagosE.txt3J.getText():"0");
            turnoJueves.setTurnoCuatro(isCero(pagosE.txt4J.getText())?pagosE.txt4J.getText():"0");
            turnoJueves.setDescuento(isCero(pagosE.txtJDes.getText())?pagosE.txtJDes.getText():"0");
            turnoJueves.setTotal(valueOf(calcular_subtotal(pagosE.txt1J.getText(),pagosE.txt2J.getText(),pagosE.txt3J.getText(),pagosE.txt4J.getText(),pagosE.txtJDes.getText())));
           
            turnoJueves.setIdturno(id_turno("Jueves"));
     
                
                
            turnoViernes.setTurnoUno(isCero(pagosE.txt1V.getText())?pagosE.txt1V.getText():"0");
            turnoViernes.setTurnoDos(isCero(pagosE.txt2V.getText())?pagosE.txt2V.getText():"0");
            turnoViernes.setTurnoTres(isCero(pagosE.txt3V.getText())?pagosE.txt3V.getText():"0");
            turnoViernes.setTurnoCuatro(isCero(pagosE.txt4V.getText())?pagosE.txt4V.getText():"0");
            turnoViernes.setDescuento(isCero(pagosE.txtVDes.getText())?pagosE.txtVDes.getText():"0");
            turnoViernes.setTotal(valueOf(calcular_subtotal(pagosE.txt1V.getText(),pagosE.txt2V.getText(),pagosE.txt3V.getText(),pagosE.txt4V.getText(),pagosE.txtVDes.getText())));
            
            turnoViernes.setIdturno(id_turno("Viernes"));

                
            turnoSabado.setTurnoUno(isCero(pagosE.txt1S.getText())?pagosE.txt1S.getText():"0");
            turnoSabado.setTurnoDos(isCero(pagosE.txt2S.getText())?pagosE.txt2S.getText():"0");
            turnoSabado.setTurnoTres(isCero(pagosE.txt3S.getText())?pagosE.txt3S.getText():"0");
            turnoSabado.setTurnoCuatro(isCero(pagosE.txt4S.getText())?pagosE.txt4S.getText():"0");
            turnoSabado.setDescuento(isCero(pagosE.txtSDes.getText())?pagosE.txtSDes.getText():"0");
            turnoSabado.setTotal(valueOf(calcular_subtotal(pagosE.txt1S.getText(),pagosE.txt2S.getText(),pagosE.txt3S.getText(),pagosE.txt4S.getText(),pagosE.txtSDes.getText())));
          
            turnoSabado.setIdturno(id_turno("Sabado"));
          
           

              
            turnoPremio.setTurnoUno(isCero(pagosE.txt1P.getText())?pagosE.txt1P.getText():"0");
            turnoPremio.setTurnoDos(isCero(pagosE.txt2P.getText())?pagosE.txt2P.getText():"0");
            turnoPremio.setTurnoTres(isCero(pagosE.txt3P.getText())?pagosE.txt3P.getText():"0");
            turnoPremio.setTurnoCuatro(isCero(pagosE.txt4P.getText())?pagosE.txt4P.getText():"0");
            turnoPremio.setDescuento(isCero(pagosE.txtPDes.getText())?pagosE.txtPDes.getText():"0");
            turnoPremio.setTotal(valueOf(calcular_subtotal(pagosE.txt1P.getText(),pagosE.txt2P.getText(),pagosE.txt3P.getText(),pagosE.txt4P.getText(),pagosE.txtPDes.getText())));
   
            turnoPremio.setIdturno(id_turno("Extra"));
            
            
         
            
            //if(!verificarEspaciosEnBlanco(buscarM)){
                
               if(consulta.editarTurno(turnoLunes)
                    && consulta.editarTurno(turnoMartes)
                    && consulta.editarTurno(turnoMiercoles)
                    && consulta.editarTurno(turnoJueves)
                    && consulta.editarTurno(turnoViernes)
                    && consulta.editarTurno(turnoSabado)
                    && consulta.editarTurno(turnoPremio)
                    ){
             
                int sueldoPrimario = parseInt(consulta.calcularSueldo(idempleado)); //SUELDO DEL EMPLEADO QUE USO EN CONTROLADOR EMPLEADO
                sueldo=Integer.toString(sueldoPrimario);
                consulta.asignarSueldo(sueldo,idempleado);
                //excepcion
                JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> TURNO MODIFICADO CON EXITO </p></html>");
               
        }
           }
           else{
               JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> RELLENE CAMPOS FALTANTES CON CERO </p></html>");
           }
        
        }
            else{
               JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> NO SE PUEDE MODIFICAR SIN HABER EFECTUADO ANTES EL PAGO, GENERE EL PAGO HACIENDO CLICK EN EL BOTON GUARDAR </p></html>");
           }
        }
        
     
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
            | pagosE.txt2L.getText().isEmpty()
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
    
    
    public void progresBar(){
        
            
    }
    
    
    
    
    
}

    
 

    

