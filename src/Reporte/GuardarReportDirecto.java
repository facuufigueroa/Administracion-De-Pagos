/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Modelo.ConexionBD;
import Vista.NombreReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.Global.print;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;



/**
 *
 * @author Dell
 */
public class GuardarReportDirecto {
   
    private NombreReporte nombreR = new NombreReporte();

    public GuardarReportDirecto(NombreReporte nombreR) {
        
        this.nombreR=nombreR;
    }
    
    public GuardarReportDirecto() {
    }

        
        
   
    public void pdf(){
        ConexionBD con = new ConexionBD();
        Connection conn = con.getConnection();
        JasperPrint jasperPrint;          
        String reportPath = "/src/Reporte/emp.jasper";
        
        try
        {   
      
          //se carga el reporte
           URL  in=this.getClass().getResource( "/Reporte/emp.jasper" );
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(in);
          
           jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), conn );


           JasperExportManager.exportReportToPdfFile( jasperPrint, "C:/Users/Dell/Desktop/Reporte/"+nombreReporte()+".pdf");
           
           
         
        }
        catch (JRException ex)
        {
          JOptionPane.showMessageDialog(null,"<html><p style = \"font:20px\"> SE ELIMINO LA CARPETA DONDE SE ALMACENABAN LOS REPORTES" +
                  " CONTACTASE CON EL TECNICO </p></html>","ERROR DE SINTAXYS", 0);
          System.err.println( "Error iReport: " + ex.getMessage() );
        }
  }
        
        public String nombreReporte(){
            
            String nombre = null;
            nombre = nombreR.txtNombreRep.getText();
      
            return nombre;
        }
        
        
       
       
}
