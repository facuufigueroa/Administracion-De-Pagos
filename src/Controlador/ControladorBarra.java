/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.BarraProgreso;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ControladorBarra {
    
    BarraProgreso pgBar = new BarraProgreso();
    
    
    
    public void pgbar(){
        pgBar.setVisible(true);
        
                    Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        int c = 0;
                        while(c<100){
                            try {
                                pgBar.progresBar.setValue(c);
                       
                                 Thread.sleep(18);
                                 c++;
                       } catch (InterruptedException ex) {
                           Logger.getLogger(ControladorImporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                        }
                        JOptionPane.showMessageDialog(null, "<html><p style = \"font:20px\"> OPERACION FINALIZADA </p></html>", "FINALIZADO", 3);
                        pgBar.setVisible(false);
                         }
               
                    });
                 t.start();
    }
    
    
    
    
    
}
