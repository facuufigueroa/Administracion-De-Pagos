/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Modelo.ConexionBD;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 *
 * @author Facundo
 */
public class Reporte {
   
    
    
    public void conexionReporte(){
        try {
            ConexionBD con = new ConexionBD();
            Connection conn = con.getConnection();
            
            JasperReport jasperMasterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reporte/emp.jasper"));
           // JasperReport jasperSubReport = JasperCompileManager.compileReport("C:\\Users\\facuu\\JaspersoftWorkspace\\MTBRAGADO\\turnos.jasper");
            
          
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jasperMasterReport,null, conn);
            JasperViewer reporteMaster = new JasperViewer(mostrarReporte,false);
            reporteMaster.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            reporteMaster.setVisible(true);
           
            
        } catch (JRException ex) {
          //  Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ">>" + ex);
        }
    }
        
  
    
}



