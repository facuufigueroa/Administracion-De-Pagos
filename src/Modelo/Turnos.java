/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Facundo
 */
public class Turnos {
    private String turnoUno;
    private String turnoDos;
    private String turnoTres;
    private String turnoCuatro;
    private String turnoCinco;
    private String turnoSeis;
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
        this.turnoCinco = turnoCinco;
        this.turnoSeis = turnoSeis;
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

    public String getTurnoCinco() {
        return turnoCinco;
    }

    public void setTurnoCinco(String turnoCinco) {
        this.turnoCinco = turnoCinco;
    }

    public String getTurnoSeis() {
        return turnoSeis;
    }

    public void setTurnoSeis(String turnoSeis) {
        this.turnoSeis = turnoSeis;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    
    
    
}
