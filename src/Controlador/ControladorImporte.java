
package Controlador;

import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Vista.GenerarImporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.Date;
import javax.swing.JOptionPane;


public class ControladorImporte implements ActionListener{
    private Consultas consulta;
    private ConexionBD conexion = new ConexionBD();
    private GenerarImporte generarImp;
    private Turnos turno;
    private String idempleado;
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
    
    public void iniciar(){
        generarImp.setTitle("IMPORTES");
        generarImp.setLocationRelativeTo(null);
        generarImp.txtTotal.setEditable(false);
        generarImp.txt_nombre_emp.setText(consulta.traerNombre(idempleado));
        setearTxtEnCero();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      guardarPagos(e);
      btnTotalTurnos(e);
      
    }
    
   
    
    
    public void guardarPagos(ActionEvent e){
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
                turno.setTurnoCinco(isCero(generarImp.txtt5.getText())?generarImp.txtt5.getText():"0");
                turno.setTurnoSeis(isCero(generarImp.txtt6.getText())?generarImp.txtt6.getText():"0");
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
       
       
    }
    
    public boolean isCero(String numero){
        if(numero.isEmpty()){
            return false;
        }else{
            return true;
        }
        
        
    }
    
    
    
    
    public void btnTotalTurnos(ActionEvent e){
        
        if(e.getSource()==generarImp.btnCalcularTotal){
          calcularTotal();
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
    
    public boolean totalVacio(){
        if(generarImp.txtTotal  == null){
            return true;
        }
        return false;
    }
 
}
    

