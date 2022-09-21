package pe.sis.elclan.OracleDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import pe.sis.elclan.Clases.ventas;
import pe.sis.elclan.DAO.ventasDAO;

/**
 *
 * @author sistemas03 Yasub Huaman
 */
public class ventasOracleDAO implements ventasDAO {
    
    @Override
    public String darbajaEstructuraUnidad(String codEstructura, String usuario ) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(darbajaEstructuraUnidad)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_BAJA_ESTRUCEQUIPO(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
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
        @Override
    public String actualizarEstructuraUnidad(String codEstructura, String codPerfil, String numOrden, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(actualizarEstructuraUnidad)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_ACTUA_ESTRUCUNIDAD(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
            cs.setInt(2, Integer.valueOf(codPerfil));
            cs.setInt(3, Integer.valueOf(numOrden));
            cs.setString(4, usuario);            
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }
    
    @Override
    public ventas listarEstructuraUnidadDatos(String codEstructura) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEstructuraUnidadDatos)");  
        ArrayList<ventas> listarEstructuraUnidadDatos;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIS_ESTRUCUNIDAD(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarEstructuraUnidadDatos = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codEstructura(rs.getString("COD_ESTRUCTURA"));
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_numOrden(rs.getString("NUM_ORDEN"));
                ven.setV_estado(rs.getString("FLAG_ESTADO"));
                ven.setV_usuarioCreacion(rs.getString("U_CREACION"));
                listarEstructuraUnidadDatos.add(ven);
            }
            ventas.setListEstrucutraUnidadDatos(listarEstructuraUnidadDatos);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }
    
    @Override
    public ventas listarEstructuraUnidades(String codUnidad) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEstructuraUnidades)");  
        ArrayList<ventas> listarEstructuraUnidades;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIS_ESTRUCUNIDADES(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarEstructuraUnidades = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codEstructura(rs.getString("COD_ESTRUCTURA"));
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_numOrden(rs.getString("NUM_ORDEN"));
                ven.setV_estado(rs.getString("FLAG_ESTADO"));
                ven.setV_usuarioCreacion(rs.getString("U_CREACION"));
                listarEstructuraUnidades.add(ven);
            }
            ventas.setListEstrucutraUnidades(listarEstructuraUnidades);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }    
    
    @Override
    public String registrarEstructuraUnidad(String codUnidad, String codPerfil, String numOrden, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(registrarEstructuraUnidad)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_REG_ESTRUCUNIDAD(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.setInt(2, Integer.valueOf(codPerfil));
            cs.setInt(3, Integer.valueOf(numOrden));
            cs.setString(4, usuario);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }
    /****************************FIN DIAGRAMA UNIDADES*********/
    @Override
    public ventas listarDiagramaVentas() throws Exception{
        System.out.println("ORACLEDAO SEGURIDAD(listarDiagramaVentas)");  
        ArrayList<ventas> listarDiagramaVentas;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIST_DIAGRAMAVENTAS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listarDiagramaVentas = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ven.setV_datos(rs.getString("DATOS"));
                ven.setV_codEstructura(rs.getString("COD_ESTRUCTURA"));
                ven.setV_numOrden(rs.getString("NUM_ORDEN"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_datosVen(rs.getString("DATOSVEN"));
                ven.setV_numero(rs.getString("NUMERO"));
                listarDiagramaVentas.add(ven);
            }
            ventas.setListDiagramaVentas(listarDiagramaVentas);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(2) + " Mensaje: " +(String)cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }
    
    @Override
    public String guardarVendEstruc(String codVendedor, String codEstructura, String fecInicio, String usuario) throws Exception{
      System.out.println("ORACLEDAO SEGURIDAD(guardarVendEstruc)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_GUARDAR_VENDESTRUC(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codVendedor));
            cs.setInt(2, Integer.valueOf(codEstructura));
            cs.setDate(3, Date.valueOf(fecInicio));
            cs.setString(4, usuario);            
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;  
    }
    
    @Override
    public ventas listarVendSinCargo(String codPerfil, String codUnidad, String codEquipo) throws Exception{
        System.out.println("ORACLEDAO SEGURIDAD(listarVendSinCargo)");  
        ArrayList<ventas> listarVendSinCargo;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        System.out.println("codPerfil: " +codPerfil +"// codUnidad: "+codUnidad+"// codEquipo: " +codEquipo);
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIST_VENDSINCARGO(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setInt(2, Integer.valueOf(codUnidad));
            cs.setInt(3, Integer.valueOf(codEquipo));
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(4);
            listarVendSinCargo = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_desArea(rs.getString("AREA"));
                ven.setV_usuario(rs.getString("USU_NOMBRE"));
                ven.setV_apellidoPaterno(rs.getString("USU_APATERNO"));
                ven.setV_apellidoMaterno(rs.getString("USU_AMATERNO"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("CARGO"));
                ven.setV_estado(rs.getString("ESTADO"));
                ven.setV_cod_Vendedor(rs.getString("COD_VENDEDOR"));
                listarVendSinCargo.add(ven);
            }
            ventas.setListVendedoresSinCargo(listarVendSinCargo);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }
    
    @Override
    public String darbajaEstructuraEquipo(String codEstructura, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(darbajaEstructuraEquipo)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_BAJA_ESTRUCEQUIPO(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
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

    @Override
    public String actualizarEstructuraEquipo(String codEstructura, String codPerfil, String numOrden, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(actualizarEstructuraEquipo)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_ACTUA_ESTRUCEQUIPO(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
            cs.setInt(2, Integer.valueOf(codPerfil));
            cs.setInt(3, Integer.valueOf(numOrden));
            cs.setString(4, usuario);            
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }

    @Override
    public ventas listarEstructuraEquipoDatos(String codEstructura) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEstructuraEquipoDatos)");  
        ArrayList<ventas> listarEstructuraEquipoDatos;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIS_ESTRUCEQUIPO(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEstructura));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarEstructuraEquipoDatos = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codEstructura(rs.getString("COD_ESTRUCTURA"));
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ven.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_numOrden(rs.getString("NUM_ORDEN"));
                ven.setV_estado(rs.getString("FLAG_ESTADO"));
                ven.setV_usuarioCreacion(rs.getString("U_CREACION"));
                listarEstructuraEquipoDatos.add(ven);
            }
            ventas.setListEstrucutraEquipoDatos(listarEstructuraEquipoDatos);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }

    @Override
    public ventas listarEstructuraEquipos(String codEquipo) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEstructuraEquipos)");  
        ArrayList<ventas> listarEstructuraEquipos;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LIS_ESTRUCEQUIPOS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEquipo));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarEstructuraEquipos = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codEstructura(rs.getString("COD_ESTRUCTURA"));
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ven.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_numOrden(rs.getString("NUM_ORDEN"));
                ven.setV_estado(rs.getString("FLAG_ESTADO"));
                ven.setV_usuarioCreacion(rs.getString("U_CREACION"));
                listarEstructuraEquipos.add(ven);
            }
            ventas.setListEstrucutraEquipos(listarEstructuraEquipos);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }

    @Override
    public String registrarEstructuraEquipo(String codEquipo, String codPerfil, String numOrden, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(regitrarEstructuraUnidad)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_REG_ESTRUCEQUIPO(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEquipo));
            cs.setInt(2, Integer.valueOf(codPerfil));
            cs.setInt(3, Integer.valueOf(numOrden));
            cs.setString(4, usuario);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(5) + " Mensaje: " +(String)cs.getObject(6));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }

    @Override
    public ventas listarPerfilesComer() throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarPerfilesComer)");  
        ArrayList<ventas> listarPerfilesComer;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs; 
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_PERFILCOMER(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listarPerfilesComer = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codPerfil(rs.getString("COD_PERFIL"));
                ven.setV_desPerfil(rs.getString("DES_PERFIL"));
                ven.setV_codArea(rs.getString("COD_AREA"));
                listarPerfilesComer.add(ven);
            }
            ventas.setListPerfilesComer(listarPerfilesComer);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(2) + " Mensaje: " +(String)cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }

    @Override
    public String darBajaEquipo(String codUnidad, String codEquipo) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(darBajaEquipo)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_DARBAJA_EQUIPO(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf( codUnidad));
            cs.setInt(2, Integer.valueOf( codEquipo));
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    @Override
    public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(actualizarEquipo)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_ACTUALIZA_EQUIPO(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf( codUnidad));
            cs.setInt(2, Integer.valueOf( codEquipo));
            cs.setString(3, desEquipo);
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

    @Override
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(guardarEquipo)");  
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_GUARDAR_EQUIPO(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, desEquipo);
            cs.setInt(2, Integer.valueOf(codUnidad));
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_"+mensaje;
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(4) + " Mensaje: " +(String)cs.getObject(5));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }

    @Override
    public ventas listarEquipos(String codEquipo, String codUnidad) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEquipos)");  
        ArrayList<ventas> listarEquipos;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;        
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_EQUIPOS(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codEquipo));
            cs.setInt(2, Integer.valueOf(codUnidad));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            listarEquipos = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ven.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ven.setV_estado(rs.getString("ESTADO"));
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_fechaCreacion(rs.getString("F_CREACION"));
                listarEquipos.add(ven);
            }
            ventas.setListEquipos(listarEquipos);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(4) + " Mensaje: " +(String)cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
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
            String sql = "{call PKG_COMERCIAL.USP_DARBAJA_UNIDAD(?,?,?)}";
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
            String sql = "{call PKG_COMERCIAL.USP_ACTUALIZAR_UNIDAD(?,?,?,?,?)}";
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
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_GUARDAR_UNIDAD(?,?,?,?)}";
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
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
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
        ArrayList<ventas>  listarUnidades;
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;        
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_UNIDADES(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarUnidades = new ArrayList<>();
            while (rs.next()) {          
                ventas ven = new ventas();
                ven.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ven.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ven.setV_estado(rs.getString("ESTADO"));
                ven.setV_usuarioCreacion(rs.getString("U_CREACION"));
                ven.setV_fechaCreacion(rs.getString("F_CREACION"));
                listarUnidades.add(ven);
            }
            ventas.setListUnidades(listarUnidades);
            System.out.println("ORACLE > CodMensaje: " +(String)cs.getObject(3) + " Mensaje: " +(String)cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> "+e);
        } finally {
            cn.close();
        }
        return ventas;
    }



}
