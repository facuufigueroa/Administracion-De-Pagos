
package mataderobragado;

import Controlador.ControladorEmpleado;
import Controlador.ControladorImporte;
import Controlador.DriverReportIndividual;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Turnos;
import Vista.GenerarImporte;
import Vista.RegistrosEmpleados;


public class MataderoBragado {

    
    public static void main(String[] args) {
       Empleado empleado= new Empleado();
       Consultas consulta= new Consultas();
       RegistrosEmpleados registroE = new RegistrosEmpleados();
             
       ControladorEmpleado controlador = new ControladorEmpleado(empleado,consulta,registroE);
       controlador.iniciar();
       registroE.setVisible(true);
       
      
    }
    
}
