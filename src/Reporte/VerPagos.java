/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reporte;

import Modelo.ConexionBD;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class VerPagos {
    public void conexionReporte(){
        try {
            ConexionBD con = new ConexionBD();
            Connection conn = con.getConnection();
            HashMap parameters =new HashMap();
            JasperReport jasperMasterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reporte/emp.jasper"));
           // JasperReport jasperSubReport = JasperCompileManager.compileReport("C:\\Users\\facuu\\JaspersoftWorkspace\\MTBRAGADO\\turnos.jasper");
            
            parameters.put(JRParameter.IS_IGNORE_PAGINATION, true); //Elimina paginacion
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jasperMasterReport,parameters, conn);
            JasperViewer reporteMaster = new JasperViewer(mostrarReporte,false);
            reporteMaster.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            reporteMaster.setVisible(true);
           
            
        } catch (JRException ex) {
          //  Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ">>" + ex);
        }
    }
}
