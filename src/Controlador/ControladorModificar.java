

package Controlador;

import static Controlador.ControladorImporte.sueldo;
import Modelo.ConexionBD;
import Modelo.Consultas;
import Modelo.Turnos;
import Vista.BuscarModificar;
import Vista.ModificarPagos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import javax.swing.JOptionPane;


public class ControladorModificar implements ActionListener {
    private Consultas consulta = new Consultas();
    public BuscarModificar buscarM = new BuscarModificar();
    private ConexionBD conexion = new ConexionBD();
    private Turnos turno;
    private String idempleado;
    private ModificarPagos mP = new ModificarPagos();
    
    
    public ControladorModificar(Consultas consulta,Turnos turno,BuscarModificar buscarM, String idempleado){
        this.consulta=consulta;
        this.turno=turno;
        this.buscarM = buscarM;
        this.idempleado=idempleado;
        
        
        buscarM.comboBoxDias.addActionListener(this);
        buscarM.btnBuscar.addActionListener(this);
        buscarM.botonModificarTodo.addActionListener(this);
        buscarM.btnCalcularTotal.addActionListener(this);
        buscarM.txtt1.addActionListener(this);
      
        
    }

    public ControladorModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modificar(e);
        calcularTotal(e);
        modificarTodo(e);
        
       
    }
    
    
    public void iniciar(){  
        buscarM.setTitle("MODIFICAR");
        buscarM.setLocationRelativeTo(null);
        txtEnCero();
  
        buscarM.txtTotal.setEditable(false);
        
        
    }
    
  
    
    public void modificar(ActionEvent e){
        
           if(e.getSource() == buscarM.btnBuscar){
               String idemp=consulta.traerid_empleado(id_turno());
               if(idemp!=null){
                buscarM.btnCalcularTotal.setEnabled(true);
                buscarM.txtt1.setEditable(true);
                buscarM.txtt2.setEditable(true);
                buscarM.txtt3.setEditable(true);
                buscarM.txtt4.setEditable(true);
                buscarM.txtt5.setEditable(true);
                buscarM.txtt6.setEditable(true);
                buscarM.cajaDescuento.setEditable(true);
                buscarM.botonModificarTodo.setVisible(false);
                
                turno=consulta.turnoModificado(buscarM.txtIdEmpleado.getText().toString(), buscarM.comboBoxDias.getSelectedItem().toString());
               
                String idempleado = buscarM.txtIdEmpleado.getText().toString();
                String fecha = consulta.traer_fecha_empleado(idempleado,id_turno());
              
                buscarM.txtt1.setText(traeCeroDesdeBD(turno.getTurnoUno())?turno.getTurnoUno():"");
                buscarM.txtt2.setText(traeCeroDesdeBD(turno.getTurnoDos())?turno.getTurnoDos():"");
            
                buscarM.txtt3.setText(traeCeroDesdeBD(turno.getTurnoTres())?turno.getTurnoTres():"");
                buscarM.txtt4.setText(traeCeroDesdeBD(turno.getTurnoCuatro())?turno.getTurnoCuatro():"");
                buscarM.cajaDescuento.setText(traeCeroDesdeBD(turno.getDescuento())?turno.getDescuento():"");
                buscarM.txtTotal.setText(traeCeroDesdeBD(turno.getTotal())?turno.getTotal():"");
                buscarM.txtfecha.setText(fecha);
               
               }else{
                   JOptionPane.showMessageDialog(null, "NO EXISTE UN TURNO ASOCIADO AL DIA "+buscarM.comboBoxDias.getSelectedItem().toString(), "ERROR", 0);
                    buscarM.setVisible(false);
               }
                }
                
    }
    
    
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
    
    //Traigo la id del turno
    public String id_turno(){
        String idturno = (consulta.idTurno_empleado(buscarM.txtIdEmpleado.getText().toString(), buscarM.comboBoxDias.getSelectedItem().toString()));
        return idturno;
    }
    
    
    //Metodo que realiza el update del turno dado
    public void modificarTodo(ActionEvent e){
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
    }
    public boolean isCero(String numero){
        if(numero.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    //Para verificar que no haya espacios en blanco en cada txt al momento de modificar el turno.
   /* public boolean verificarEspaciosEnBlanco(BuscarModificar buscarM) {
        if(buscarM.txtt1.getText().isEmpty() 
                && buscarM.txtt2.getText().isEmpty() 
                && buscarM.txtt3.getText().isEmpty()
                && buscarM.txtt4.getText().isEmpty()
                && buscarM.txtt5.getText().isEmpty()
                && buscarM.txtt6.getText().isEmpty()
                && buscarM.cajaDescuento.getText().isEmpty()
                && buscarM.txtTotal.getText().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    */
    
    
    public void habilitar(ActionEvent e){
       
    }
    
    //Metodo que setea el campo total de la interfaz con el total obtenido
    public void calcularTotal(ActionEvent e){
        if(e.getSource() == buscarM.btnCalcularTotal){
            obtenerTotal();
            buscarM.botonModificarTodo.setVisible(true);
            buscarM.txtt1.setEditable(false);
            buscarM.txtt2.setEditable(false);
            buscarM.txtt3.setEditable(false);
            buscarM.txtt4.setEditable(false);
            buscarM.txtt5.setEditable(false);
            buscarM.txtt6.setEditable(false);
            buscarM.cajaDescuento.setEditable(false);
            buscarM.btnCalcularTotal.setEnabled(false);
        
            
            
            /* if(!verificarEspaciosEnBlanco(buscarM)){
                obtenerTotal();
            }
            */
        }   
    }
    
    //Metodo que obtiene el total al presionar el boton calcular total
    public int obtenerTotal(){
        int total=0;
        int totalCajas=0;
        totalCajas+=(isCero(buscarM.txtt1.getText())?parseInt(buscarM.txtt1.getText()):0)+
                (isCero(buscarM.txtt2.getText())?parseInt(buscarM.txtt2.getText()):0)+
                (isCero(buscarM.txtt3.getText())?parseInt(buscarM.txtt3.getText()):0)+
                (isCero(buscarM.txtt4.getText())?parseInt(buscarM.txtt4.getText()):0)+
                (isCero(buscarM.txtt5.getText())?parseInt(buscarM.txtt5.getText()):0)+
                (isCero(buscarM.txtt6.getText())?parseInt(buscarM.txtt6.getText()):0);
        int descuento = isCero(buscarM.cajaDescuento.getText())?parseInt(buscarM.cajaDescuento.getText()):0;
        total=totalCajas-descuento;
        buscarM.txtTotal.setText(valueOf(total));
        
        return total;
       
    } 
    
    
    //Metodo que setea los texfield en cero
    public void txtEnCero(){
        buscarM.txtt1.setText("");
        buscarM.txtt2.setText("");
        buscarM.txtt3.setText("");
        buscarM.txtt4.setText("");
        buscarM.txtt5.setText("");
        buscarM.txtt6.setText("");
        buscarM.cajaDescuento.setText("");
        
    }
}
