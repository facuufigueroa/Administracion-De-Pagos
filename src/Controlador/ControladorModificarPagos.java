/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consultas;
import Modelo.Turnos;
import Vista.ModificarPagos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Facundo
 */
public class ControladorModificarPagos implements ActionListener{
    private Consultas consulta;
    private ModificarPagos modP = new ModificarPagos();
    private Turnos turno;

    public ControladorModificarPagos(Consultas consulta, Turnos turno) {
        this.consulta = consulta;
        this.turno =turno;
        
        modP.botonModificarTodo.addActionListener(this);
        modP.btnCalcularTotal.addActionListener(this);
        
    }
    
      public void iniciar(){  
        modP.setTitle("MODIFICAR TURNO COMPLETO");
        modP.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       modificarTodo(e);
    }
    
    public void modificarTodo(ActionEvent e){
        if(e.getSource() == modP.botonModificarTodo){
                
            modP.setVisible(true);
            modP.txtt1.setText(turno.getTurnoUno());
            modP.txtt2.setText(turno.getTurnoDos());
            modP.txtt3.setText(turno.getTurnoTres());
            modP.txtt4.setText(turno.getTurnoCuatro());
            modP.cajaDescuento.setText(turno.getDescuento());
            modP.txtTotal.setText(turno.getTotal());
            
        }
    }
    
  
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
}
