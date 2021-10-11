/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.ModificarPagos;
import Vista.RegistrosEmpleados;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Facundo
 */
public class Consultas extends ConexionBD {

    private RegistrosEmpleados registrosE = new RegistrosEmpleados();
    private Turnos turnos = new Turnos();

    //CONSULTAS CRUD
    //----------------------------------------------------------------------------------------//
    public boolean agregar(Empleado emp) {
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO empleados (dni,nombre,telefono,sueldo) VALUES(?,?,?,?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre().toUpperCase());
            ps.setString(3, emp.getTelefono());
            ps.setString(4, emp.getSueldo());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public Empleado buscar(String nombre) {
        String[] dato = new String[3];
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        Empleado empleado = new Empleado();

        String sql = "SELECT * FROM empleados WHERE nombre = '" + nombre.toUpperCase() + "'";

        try {
            //consulta 
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {

                empleado.setDni(rs.getString("dni"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTelefono(rs.getString("telefono"));

            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return empleado;
    }

    public boolean borrar(Empleado emp) {
        PreparedStatement ps = null;
        Connection conn = getConnection();

        String sql = "DELETE FROM empleados WHERE dni = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public boolean editar(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE empleados SET dni = ?, nombre = ? , telefono = ? WHERE idempleado = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre().toUpperCase());
            ps.setString(3, emp.getTelefono());
            ps.setString(4, emp.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public String traer_id(String dni) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT  idempleado FROM empleados WHERE  dni = '" + dni + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    //METODO PARA VERIFICAR SI EL DNI YA ESTA EN LA BASE DE DATOS, TRUE SI ESTA, FALSE SI NO.
    public boolean existeCodigo(String dni) {
        Connection conn = getConnection();
        Statement st;
        String[] dato = new String[3];
        boolean b = true;
        try {
            String sql = "SELECT * FROM empleados WHERE dni = '" + dni + "'";

            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                b = true;

            } else {
                b = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return b;
    }

    //------------------------------------------------------------------------------------------//
    //CONSULTAS PAGOS
    public boolean guardarTurnos(Turnos turno) {
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO turno (t1,t2,t3,t4,t5,t6,descuento,total,fecha,idempleado) VALUES(?,?,?,?,?,?,?,?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, turno.getTurnoUno());
            ps.setString(2, turno.getTurnoDos());
            ps.setString(3, turno.getTurnoTres());
            ps.setString(4, turno.getTurnoCuatro());
            ps.setString(5, turno.getTurnoCinco());
            ps.setString(6, turno.getTurnoSeis());
            ps.setString(7, turno.getDescuento());
            ps.setString(8, turno.getTotal());
            ps.setString(9, turno.getFecha().toString());
            ps.setString(10,turno.getIdempleado());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public boolean traerEmpleado(String dni) {
        Connection conn = getConnection();
        Statement st;
        String[] dato = new String[3];
        boolean b = true;
        try {
            String sql = "SELECT * FROM empleados WHERE dni = '" + dni + "'";

            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                b = true;

            } else {
                b = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return b;
    }

    public String traerid_dia(String cajadia) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT  iddias FROM dias WHERE  nombre = '" + cajadia + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public String traerid_turno() {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT * FROM turno ORDER BY idturno desc";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public boolean agregar_diasturno(String iddia, String idturno) {
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO dia_turno (iddia,idturno) VALUES(?,?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, iddia);
            ps.setString(2, idturno);

            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public String traerid_diaturno() {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT * FROM dia_turno ORDER BY iddia_turno desc";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public boolean agregar_iddia_empleado(String idempleado) {
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO empleado_diaturno (idempleado,iddiaturno) VALUES(?,?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, idempleado);
            ps.setString(2, traerid_diaturno());

            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    //----------------------------------------------------------------------------------------//
    //CONSULTAS MODIFICAR
    public String traer_idDia(String idempleado) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT iddia FROM empleado_diaturno WHERE  idempleado = '" + idempleado + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public String traer_idturno(String idempleado) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT idturno FROM empleado_turno WHERE  idempleado = '" + idempleado + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    
    

    public String traerIdDiaDelTurno(String idturno) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT iddia FROM dia_turno WHERE idturno = '" + idturno + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public void agregar_empleado_turno(String idemp, String idturno, String iddia) {
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO empleado_turno (idempleado,idturno,iddia) VALUES(?,?,?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, idemp);
            ps.setString(2, idturno);
            ps.setString(3, iddia);
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    
    public String traerNombre(String idempleado) {
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT nombre FROM empleados WHERE  idempleado = '" + idempleado + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }

    public String traer_id_empleado(String id_empleado, String diaSeleccionado) {

        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            st = con.createStatement();

         
            String sql2 = "SELECT e.idempleado FROM empleados e WHERE '"+ id_empleado + "' IN "
                    + "(SELECT et.idempleado FROM empleado_turno et WHERE et.idturno IN "
                    + "(SELECT dt.idturno FROM dia_turno dt WHERE dt.iddia = (SELECT iddias FROM dias WHERE nombre='"
                    +diaSeleccionado+"')"+ ")"+ ")"+"AND e.idempleado ='"+ id_empleado + "'";
 
            ResultSet rs = st.executeQuery(sql2);

            if (rs.next()) {
                  s=rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;

    }
    
    
    //Traer fecha de pago
    public String traer_fecha_empleado(String id_empleado, String id_turno){
        String fecha = null;
        Connection con = getConnection();
        Statement st;
        
        try{
            st = con.createStatement();
            String sql = "SELECT fecha FROM turno WHERE  idempleado = '" + id_empleado + "'AND idturno= '" + id_turno + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                fecha=rs.getString(1).toString();
            }
        }
        catch(Exception e){
            
        }
        return fecha;
    }
    
    
    
    //CONSULTA PARA TRAER LA TABLA TURNO DEL RESPECTIVO EMPLEADO CON EL DIA SELECCIONADO
    public Turnos turnoModificado(String id_empleado, String diaSeleccionado){
        Turnos t = new Turnos();
   
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            st = con.createStatement();

        
            String sql = "select turno.* from empleado_turno et\n" +
                "inner join empleados e\n" +
                "on e.idempleado=et.idempleado\n" +
                "and et.idempleado= '"+ id_empleado +
                "' inner join dias d\n" +
                "on d.iddias=et.iddia\n" +
                "and d.nombre= '" + diaSeleccionado +
                "' inner join turno \n" +
                "on turno.idturno =et.idturno" ;
            
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                 
                 t.setTurnoUno(rs.getString("t1")); 
                 t.setTurnoDos(rs.getString("t2"));
                 t.setTurnoTres(rs.getString("t3"));
                 t.setTurnoCuatro(rs.getString("t4"));
                 t.setTurnoCinco(rs.getString("t5"));
                 t.setTurnoSeis(rs.getString("t6"));
                 t.setDescuento(rs.getString("descuento"));
                 t.setTotal(rs.getString("total"));
               
            }

        } catch (Exception e) {
            
            System.out.println(e);
        }

        return t;
    }
    
    
    public String idTurno_empleado(String id_empleado, String diaSeleccionado){
        Turnos t = new Turnos();
   
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            st = con.createStatement();

        
            String sql = "select turno.* from empleado_turno et\n" +
                "inner join empleados e\n" +
                "on e.idempleado=et.idempleado\n" +
                "and et.idempleado= '"+ id_empleado +
                "' inner join dias d\n" +
                "on d.iddias=et.iddia\n" +
                "and d.nombre= '" + diaSeleccionado +
                "' inner join turno \n" +
                "on turno.idturno =et.idturno" ;
            
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                 
                s=rs.getString("idturno");
            }

        } catch (Exception e) {
            
            System.out.println(e);
        }
           return s;
      
    }
    
    
    
    
    
    //recibe el turno pero no modifica
    public boolean editarTurno(Turnos turno) {
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE turno SET t1 = ?, t2 = ? , t3 = ? , t4 = ?, t5 = ?, t6 = ?, descuento = ?, total = ? WHERE idturno = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, turno.getTurnoUno());
            ps.setString(2, turno.getTurnoDos());
            ps.setString(3, turno.getTurnoTres());
            ps.setString(4, turno.getTurnoCuatro());
            ps.setString(5, turno.getTurnoCinco());
            ps.setString(6, turno.getTurnoSeis());
            ps.setString(7, turno.getDescuento());
            ps.setString(8, turno.getTotal());
            ps.setString(9, turno.getIdturno());
            

            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //consulta para que no genere el pago del mismo dia
    public boolean verificarDiaExistente(String idempleado,String iddia){
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        boolean b = true;
   
        
        try {
            String sql = "SELECT * FROM empleado_turno WHERE idempleado = '" + idempleado + "' AND iddia = '" + iddia + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                b = true;

            } else {
                b = false;
            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }
    
    //Consulta para eliminar todos los registros semanales
    public boolean eliminar_empleado_turno (){
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        String sql = "TRUNCATE table empleado_turno";
           
        try{
            
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }
                                               
    public boolean eliminar_registros_turnos() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        try{
            String sql = "SET FOREIGN_KEY_CHECKS = 0";
            stmt.executeUpdate(sql);
            
            sql = "TRUNCATE turno" ;
    // Ejecutar la eliminación
            stmt.executeUpdate (sql);
    // Use DELETE
            sql = "SET FOREIGN_KEY_CHECKS = 1";
            stmt.executeUpdate(sql);
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } 
    }
    
    public boolean eliminar_registros_diaturno() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        try{
            String sql = "SET FOREIGN_KEY_CHECKS = 0";
            stmt.executeUpdate(sql);
            
            sql = "TRUNCATE dia_turno" ;
    // Ejecutar la eliminación
            stmt.executeUpdate (sql);
    // Use DELETE
            sql = "SET FOREIGN_KEY_CHECKS = 1";
            stmt.executeUpdate(sql);
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } 
    }

    public boolean eliminar_registros_empleado_diaturno() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        try{
            String sql = "SET FOREIGN_KEY_CHECKS = 0";
            stmt.executeUpdate(sql);
            
            sql = "TRUNCATE empleado_diaturno" ;
    // Ejecutar la eliminación
            stmt.executeUpdate (sql);
    // Use DELETE
            sql = "SET FOREIGN_KEY_CHECKS = 1";
            stmt.executeUpdate(sql);
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } 
    }




     
    public String calcularSueldo (String idempleado){
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        String sueldo = null;
      
        try {
            
            String sql = "SELECT SUM(total) FROM turno WHERE idempleado = '"+ idempleado + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                sueldo = rs.getString(1).toString();

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return sueldo;
    }
    
    
    public void asignarSueldo(String sueldo, String idempleado){
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "UPDATE empleados SET sueldo = ? WHERE idempleado = ? ";
       // System.out.println(sueldo+" "+"id:"+idempleado);
        try {
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, sueldo);
            ps.setString(2, idempleado);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e);
           
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }
    
    public String traerid_empleado(String idturno){
        Connection con = getConnection();
        Statement st;
        String s = null;

        try {
            String sql = "SELECT idempleado FROM turno WHERE  idturno= '" + idturno + "'";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return s;
    }
    
    
    public boolean eliminar_sueldos() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        try{
            String sql = "SET SQL_SAFE_UPDATES=0";
            stmt.executeUpdate(sql);
            
            sql = "UPDATE empleados SET sueldo=0" ;
    // Ejecutar la eliminación
            stmt.executeUpdate (sql);
    // Use DELETE
            sql = "SET SQL_SAFE_UPDATES=1";
            stmt.executeUpdate(sql);
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } 
    }
    
    public String calcularMensualidad(){
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        String mensualidad = null;
        try {
            
            String sql = "SELECT SUM(sueldo) FROM empleados";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                mensualidad = rs.getString(1).toString();

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return mensualidad;
    }
    
    public boolean guardarMensualidad() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        String mensualidad=calcularMensualidad();
        int men = parseInt(mensualidad);
        
        try{
            if(men!=0){
            String sql = "SET SQL_SAFE_UPDATES=0";
            stmt.executeUpdate(sql);
           
            sql = "UPDATE mensualidad SET totalmensual = ?" ;
          //  stmt.executeUpdate (sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, mensualidad);
            ps.executeUpdate();
    // Ejecutar la eliminación
          
    // Use DELETE
            sql = "SET SQL_SAFE_UPDATES=1";
            stmt.executeUpdate(sql);
            return true;
            }
            else{
                String sql = "SET SQL_SAFE_UPDATES=0";
            stmt.executeUpdate(sql);
           
            sql = "UPDATE mensualidad SET totalmensual = ?" ;
          //  stmt.executeUpdate (sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, mensualidad);
            ps.executeUpdate();
    // Ejecutar la eliminación
          
    // Use DELETE
            sql = "SET SQL_SAFE_UPDATES=1";
            stmt.executeUpdate(sql);
            return true;
            }
        }
       
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }
    
    
    public boolean setearMensualidad() throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        Statement st;
        Statement stmt = con.createStatement();
        Statement s = con.createStatement();
        try{
            String sql = "SET SQL_SAFE_UPDATES=0";
            stmt.executeUpdate(sql);
            
            sql = "UPDATE mensualidad SET totalmensual=0" ;
    // Ejecutar la eliminación
            stmt.executeUpdate (sql);
    // Use DELETE
            sql = "SET SQL_SAFE_UPDATES=1";
            stmt.executeUpdate(sql);
            return true;
        }
         catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } 
    }
    
    
}
