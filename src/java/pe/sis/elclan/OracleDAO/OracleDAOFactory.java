/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.OracleDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.DAO.DAOFactory;
import pe.sis.elclan.DAO.mantenimientoDAO;
import pe.sis.elclan.DAO.reHumanosDAO;
import pe.sis.elclan.DAO.ventasDAO;


/**
 *
 */
public class OracleDAOFactory extends DAOFactory {
    static DataSource dataSource = null;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //CONEXION ORACLE

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion(String base) {
        Connection conexion = null;

        if (base.equals("elclan")) {
            try {
                System.out.println("LLEGA A CONEXION ORACLE");
//                conexion = DriverManager.getConnection(
//                        "jdbc:oracle:thin:@192.168.1.2:1521:BDELCLAN",
//                        "ELCLAN",
//                        "CLAN#95123");
                conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@servidor05:1521:elclan",
                        "uelclan",
                        "pasUCLAN#147");

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else if (base.equals("access")) {
            System.out.println("ENTRA A CONEXION ACCESS: "+conexion);
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                //System.out.println("DRIVER: ");
                String path = "\\\\servidor01\\lectorhuellas$\\att2000.mdb"; //CONEXION APUNTA SERVIDOR
                //System.out.println("PATH: "+path);
                String url = "jdbc:ucanaccess://" + path;
                //System.out.println("URL: "+url);
                System.out.println("CONEXION ACCESS");
                conexion = DriverManager.getConnection(url);
                System.out.println("CONEXION ACCESS: "+conexion);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if (base.equals("advantage")) {
            //Connection conexion = null;
            String user = "ADSSYS";
            String password = "";
            System.out.println("CONEXION safc: ");
            try {
            Class.forName("com.extendedsystems.jdbc.advantage.ADSDriver");
            String url = "jdbc:extendedsystems:advantage://SERVIDOR05:6262;catalog =c:\\\\ARIS\\ARISDB.add";
//            String ur = "jdbc:extendedsystems:advantage://SERVIDOR05:6262;catalog = c:\\ARIS\ARISDB.add";
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION safc: "+conexion);
            } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
            "Error al Cargar Driver\n" + e.getMessage());
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error al Conectar\n" + e.getMessage());
                }
        } 
        System.out.println("CONECTAR: "+conexion);
        return conexion;
    }

    @Override
    public reHumanosDAO getReHumanosDAO() {
        return new reHumanosOracleDAO();
    }

    @Override
    public mantenimientoDAO getMantenimientoDAO() {
        return new mantenimientoOracleDAO();
    }

    @Override
    public ventasDAO getVentasDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

