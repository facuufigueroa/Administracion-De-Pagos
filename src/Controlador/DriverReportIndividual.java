
package Controlador;

import Reporte.ReportFilterEmploy;
import Vista.ReporteIndividual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

/**
 * Esta clase es para trabajar con el reporte individual
 * @author Facundo
 */
public class DriverReportIndividual implements ActionListener {
    ReporteIndividual reportI;

    public DriverReportIndividual(ReporteIndividual reporteI) {
        this.reportI=reporteI;
        
        reporteI.btnReporteIndividual.addActionListener(this);
    }
    
     public DriverReportIndividual(){
         
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       generarReporteIndividual(e);
    }
    
    public void generarReporteIndividual(ActionEvent e){
        if(e.getSource()==reportI.btnReporteIndividual){
            System.out.println("hola");
           // int idempleado= parseInt(reportI.txt_idempleado.getText());
           // ReportFilterEmploy reporte = new ReportFilterEmploy();
           // reporte.conexionReporte(idempleado);
            
           
        }
    }
    
   
}
