
package pe.sis.elclan.OracleDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;
import pe.sis.elclan.Clases.ventas;
import pe.sis.elclan.DAO.ventasDAO;

/**
 *
 * @author sistemas03 Yasub Huaman
 */
public class ventasOracleDAO implements ventasDAO{

    @Override
    public String darBajaEquipo(String codUnidad, String codEquipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ventas listarEquipos(String codUnidad, String codEquipo) throws Exception {

        return null;
    }

    /**
     *autor: yasub huaman ramos fecha: 03/09/2022
     * description: ORACLE dar baja la unidad
     * @param codUnidad
     * @return
     * @throws Exception
     */
    @Override
    public String darBajaUnidad(String codUnidad) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(darBajaUnidad)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_Darbajas_UNIDADES(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf( codUnidad));
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(2);
            String mensaje = (String) cs.getObject(3);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(2) + " Mensaje: " +(String)cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    /**
     *autor: yasub huaman ramos fecha: 03/09/2022
     * description: ORACLE actualizar unidad
     * @param codUnidad
     * @param desUnidad
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String actualizarUnidad(String codUnidad, String desUnidad, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(actualizarUnidad)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_ACTUALIZAR_UNIDADES(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf( codUnidad));
            cs.setString(2, desUnidad);
            cs.setString(3, desUnidad);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(4) + " Mensaje: " +(String)cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    /**
     *autor: yasub huaman ramos fecha: 03/09/2022
     * description: ORACLE guardar unidad
     * @param desUnidad
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String guardarUnidad(String desUnidad, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(guardarUnidad)");  
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "el clan";
        CallableStatement cs;
        ResultSet rs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_GUARDAR_UNIDADES(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, desUnidad);
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }
    
    /**
     *autor: yasub huaman ramos fecha: 03/09/2022
     * description: ORACLE listarUnidades
     * @param codUnidad
     * @return
     * @throws Exception
     */
    @Override
    public ventas listarUnidades(String codUnidad) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarUnidades)");  
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "el clan";
        CallableStatement cs;
        ResultSet rs;
        
        try {
            String sql = "{call PKG_COMERCIAL.USP_UNIDADES(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {                
                ventas.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ventas.setV_desUnidad(rs.getString("DES_UNIDAD"));
            }
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }

}
