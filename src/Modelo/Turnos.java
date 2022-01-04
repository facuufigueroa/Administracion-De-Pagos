package Modelo;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;

public class Turnos {
    private String turnoUno;
    private String turnoDos;
    private String turnoTres;
    private String turnoCuatro;
    private String descuento;
    private String total;
    private String idturno;
    private Date fecha;
    private String idempleado;

    public Turnos(String turnoUno, String turnoDos, String turnoTres, String turnoCuatro, String turnoCinco, String turnoSeis, String descuento, String total, String idturno, Date fecha, String idempleado) {
        this.turnoUno = turnoUno;
        this.turnoDos = turnoDos;
        this.turnoTres = turnoTres;
        this.turnoCuatro = turnoCuatro;
        this.descuento = descuento;
        this.total = total;
        this.idturno = idturno;
        this.fecha=fecha;
        this.idempleado=idempleado;
    }

    public Turnos(){
        
    }
    
    public String getTurnoUno() {
        return turnoUno;
    }

    public void setTurnoUno(String turnoUno) {
        this.turnoUno = turnoUno;
    }

    public String getTurnoDos() {
        return turnoDos;
    }

    public void setTurnoDos(String turnoDos) {
        this.turnoDos = turnoDos;
    }

    public String getTurnoTres() {
        return turnoTres;
    }

    public void setTurnoTres(String turnoTres) {
        this.turnoTres = turnoTres;
    }

    public String getTurnoCuatro() {
        return turnoCuatro;
    }

    public void setTurnoCuatro(String turnoCuatro) {
        this.turnoCuatro = turnoCuatro;
    }


    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

 
    public String getIdturno() {
        return idturno;
    }

    public void setIdturno(String idturno) {
        this.idturno = idturno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public void setFecha(JDateChooser fechaTurno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    
    
    
}
