/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.OracleDAO;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
/*import javax.annotation.Resource;*/
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.Clases.mantenimiento;
//import pe.sis.javaWeb.DAO.usuarioDAO;
import pe.sis.elclan.DAO.reHumanosDAO;

/**
 *
 * @author bentu condori
 */
public class reHumanosOracleDAO implements reHumanosDAO {

    @Resource(name = "jdbc/SQLServerDriver")
    private DataSource fuente;
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 29-08-2022 
     * descripcion: SQL: listar justificaciones
     * @param codAsistDet
     * @return 
     * @throws java.sql.SQLException 
    *****************************************************************************
     */
    @Override
    public reHumanos listaJustificacion(String codAsistDet) throws SQLException{
        System.out.println("SQLDAO SEGURIDAD(listaJustificacion)");
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_JUSTIFICACION(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codAsistDet));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                reHumanos.setCodigoAsisDet(rs.getString("COD_ASISTJUST"));
                reHumanos.setFeCreacion(rs.getString("FECHA"));
                reHumanos.setObservacion(rs.getString("OBSERVACION"));
                reHumanos.setUsuario(rs.getString("U_CREACION"));
            }
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 25-08-2022 
     * descripcion: SQL: listar areas para sedes
     * @param codSede
     * @return 
    *****************************************************************************
     */
    @Override
    public mantenimiento listarAreasSede(String codSede) throws SQLException {
        System.out.println("SQLDAO SEGURIDAD(listarAllAreas)");
        ArrayList<mantenimiento> listarAreasSede;
        mantenimiento mantenimiento = new mantenimiento();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTAR_AREASEDE(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSede));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listarAreasSede = new ArrayList<mantenimiento>();
            while (rs.next()) {
                mantenimiento man = new mantenimiento();
                man.setmCodigoArea(rs.getString("cod_area"));
                man.setmDescArea(rs.getString("des_area"));
                man.setmUCreacion(rs.getString("u_creacion"));
                man.setmFCreacion(rs.getString("f_creacion"));
                listarAreasSede.add(man);
            }
            mantenimiento.setListaAreas(listarAreasSede);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return mantenimiento;

    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-27
     * descripcion: SQL: REGISTRAR USUARIO A SEDE.
     * @param codUsuario
     * @param codSede
     * @param usuario
     * @return
     * @throws java.lang.Exception
    **
    */
    
    @Override
    public String registroSedeUsuario(String codUsuario, String codSede, String usuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(registroSedeUsuario)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_REGISTRO_SEDEUSU(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setInt(2, Integer.valueOf(codSede));
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-25
     * descripcion: SQL: DAR BAJA EXPERIENCIA DE USUARIO.
     * @param codExperiencia
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String darBajaExperienciaLab(String codExperiencia) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(darBajaExperienciaLab)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_DARBAJA_EXPELABO(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codExperiencia));
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(2);
            String mensaje = (String) cs.getObject(3);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
        
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-25
     * descripcion: SQL: lISTA DE EXPERIENCIAS LABORADAS.
     * @param codUsuario
     * @return
     * @throws java.lang.Exception
    **
    */    
    @Override
    public reHumanos listaExperienciasLab(String codUsuario) throws Exception{
       System.out.println("SQLDAO SEGURIDAD(listaExperienciasLab)");
        ArrayList<reHumanos> listaExperienciasLab;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_EXPERIENCIALAB(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaExperienciasLab = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodExperiencia(rs.getString("COD_EXP"));
                re.setDesEmpresa(rs.getString("PER_DATOS"));
                re.setDesPuesto(rs.getString("DES_PUESTO"));
                re.setFinicio(rs.getString("F_INICIO"));
                re.setFcese(rs.getString("F_FIN"));
                listaExperienciasLab.add(re);
            }
            reHumanos.setListaExperienciaLab(listaExperienciasLab);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos; 
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-25
     * descripcion: SQL: REGISTRAR EXPERIENCIAS LABORADAS.
     * @param codUsuario
     * @param usuario
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String registroExperienciaLab(String codUsuario, String codPuesto, String descripcion, String fecIni, String fecFin, String codPersona, String usuario ) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(registroExperienciaLab)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_REGISTRO_EXPERIENCIALAB(?,?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setString(2, codPuesto);
            cs.setString(3, descripcion);
            cs.setDate(4, Date.valueOf(fecIni));
            cs.setDate(5, Date.valueOf(fecFin));
            cs.setString(6, codPersona);
            cs.setString(7, usuario);
            cs.registerOutParameter(8, java.sql.Types.VARCHAR);
            cs.registerOutParameter(9, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(8);
            String mensaje = (String) cs.getObject(9);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(8) + " Mensaje: " + (String) cs.getObject(9));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-25
     * descripcion: SQL: lISTA DE EMPRESAS LABORADAS.
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos listaEmpresaLab() throws Exception{
       System.out.println("SQLDAO SEGURIDAD(listaEmpresaLab)");
        ArrayList<reHumanos> listaEmpresaLab;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_EMPRESALAB(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaEmpresaLab = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodEmpresa(rs.getString("COD_PERSONA"));
                re.setDesEmpresa(rs.getString("PER_DATOS"));
                listaEmpresaLab.add(re);
            }
            reHumanos.setListaEmpresaLab(listaEmpresaLab);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos; 
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-25
     * descripcion: SQL: lISTA DE PUESTOS LABORADOS.
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos listaPuestoLab() throws Exception{
       System.out.println("SQLDAO SEGURIDAD(listaPuestoLab)");
        ArrayList<reHumanos> listaPuestoLab;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_PUESTOSLAB(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaPuestoLab = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodPuesto(rs.getString("COD_PUESTO"));
                re.setDesPuesto(rs.getString("DES_PUESTO"));
                listaPuestoLab.add(re);
            }
            reHumanos.setListaPuestoLab(listaPuestoLab);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos; 
    }
    
//  =================== REPORTES DE ASISTENCISA ===================
    
        /****************************************************************************
     * autor: Bentu Condori Mamani
     * fecha: 05-08-2022 
     * descripcion: SQL: justificar asistencia.
     * @param fecha
     * @return
     * @throws java.lang.Exception
    **
    ****************************************************************************/
    @Override
    public reHumanos justificarAsistencia(String codVende, String codAsistDet, String fecha,  String usuario, String obs) throws Exception{
        System.out.println("FECHA"+fecha);        
        String[] datos = fecha.split("-"); 
        String annio = datos[0];
        String mes = datos[1];
        String dia = datos[2];
        String fec = dia+'/'+mes+'/'+annio;
        System.out.println("SQLDAO SEGURIDAD(justificarAsistencia)"+fec);
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        reHumanos respuesta = new reHumanos();
        try {
            String sql = "{call PKG_REHUMANOS.USP_JUSTI_ASISTENCIA(?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codVende));
            cs.setInt(2, Integer.valueOf(codAsistDet));
            cs.setString(3, fec);
            cs.setString(4,obs);
            cs.setString(5, usuario);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(6);
            String mensaje = (String) cs.getObject(7);
            respuesta.setCodMensaje(seguridad);
            respuesta.setMensaje(mensaje);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(6) + " Mensaje: " + (String) cs.getObject(7));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
     /****************************************************************************
     * autor: Bentu Condori Mamani
     * fecha: 2022-07-26 
     * descripcion: SQL: Confirmar la carga de asistencias.
     * @param fecha
     * @return
     * @throws java.lang.Exception
    **
    ****************************************************************************/
    @Override
    public reHumanos generarReportAsistencia(String fecha,String codBanco,String modDeposito, String codTplanilla, String usuario) throws Exception{
        System.out.println("FECHA"+fecha);        
        String[] datos = fecha.split("-"); 
        String annio = datos[0];
        String mes = datos[1];
        String dia = datos[2];
        String fec = dia+'/'+mes+'/'+annio;
        System.out.println("SQLDAO SEGURIDAD(generarReportAsistencia)"+fec);
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs = null;
        String seguridad = null;
        ArrayList<reHumanos> lista = new ArrayList<>();
        reHumanos respuesta = new reHumanos();
        try {
            String sql = "{call PKG_REHUMANOS.USP_GEN_REPTEADELANTO(?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, fec);
            cs.setInt(2, Integer.valueOf(codBanco));
            cs.setInt(3, Integer.valueOf(modDeposito));
            cs.setInt(4, Integer.valueOf(codTplanilla)); 
            cs.setString(5, usuario);
            cs.registerOutParameter(6, OracleTypes.CURSOR);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
            cs.registerOutParameter(8, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(7);
            String mensaje = (String) cs.getObject(8);
            rs = (ResultSet) cs.getObject(6);
            while(rs.next()){
                reHumanos rh = new reHumanos();
                rh.setCampReporte(rs.getString("CAMPO_REPORT"));
                // System.out.println("----------"+rs.getString("CAMPO_REPORT"));
                lista.add(rh);
            }
            respuesta.setCodMensaje(seguridad);
            respuesta.setMensaje(mensaje);
            respuesta.setListReporte(lista);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(7) + " Mensaje: " + (String) cs.getObject(8));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /****************************************************************************
     * autor: Bentu Condori Mamani
     * fecha: 2022-07-26 
     * descripcion: SQL: Lista de asistencias diarios.
     * @param fecha
     * @param datos
     * @param estado
     * @return
     * @throws java.lang.Exception
    **
    ****************************************************************************/
    @Override
    public reHumanos listarAsistenciaDiario(String fecha, String datos, String estado) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listarAsistenciaDiario)");
        ArrayList<reHumanos> listaUsuarios;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        String[] data = fecha.split("-"); 
        String annio = data[0];
        String mes = data[1];
        String dia = data[2];
        String fec = dia+'/'+mes+'/'+annio;
        System.out.println("fec " + fec);
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_ASISTDIARIO(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, fec);
            cs.setString(2, datos);
            cs.setString(3, estado);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(4);
            listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoAsisDet(rs.getString("COD_ASISTDET"));
                re.setCodigoUsuario(rs.getString("COD_USUARIO"));
                re.setNombreUsuario(rs.getString("USU_NOMBRE"));
                re.setApePaternoUsuario(rs.getString("USU_APATERNO"));
                re.setApeMaternoUsuario(rs.getString("USU_AMATERNO"));
                re.setUsuario(rs.getString("USUARIO"));
                re.setNumeroDOI(rs.getString("USU_NUMDOC"));
                re.setDescPerfil(rs.getString("CARGO"));
                re.setFechaMarcacion(rs.getString("FECHA"));
                re.setHoraMarcacion(rs.getString("HORA"));
                re.setSitAsistencia(rs.getString("ASISTENCIA_TIP"));
                re.setCodJustificacion(rs.getString("JUSTIFI"));
                listaUsuarios.add(re);
            }
            reHumanos.setListaUsuarios(listaUsuarios);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(5) + " Mensaje: " + (String) cs.getObject(6));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    
    /****************************************************************************
     * autor: Bentu Condori Mamani
     * fecha: 2022-07-26 
     * descripcion: SQL: Confirmar la carga de asistencias.
     * @param fecha
     * @return
     * @throws java.lang.Exception
    **
    ****************************************************************************/
    @Override
    public reHumanos confirmarCargaAsistencia(String fecha, String fecFin, String usuario) throws Exception{
        System.out.println("FECHA"+fecha);        
        String[] datos = fecha.split("-"); 
        String annio = datos[0];
        String mes = datos[1];
        String dia = datos[2];
        String fec = dia+'/'+mes+'/'+annio;
        System.out.println("SQLDAO SEGURIDAD(confirmarCargaAsistencia)"+fec);
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        reHumanos respuesta = new reHumanos();
        try {
            String sql = "{call PKG_REHUMANOS.USP_GUARDAR_ASISTENCIA(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, String.valueOf(fec));
            cs.setString(2, fecFin);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta.setCodMensaje(seguridad);
            respuesta.setMensaje(mensaje);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: Bentu Condori Mamani 
     * fecha: 2022-07-25 
     * descripcion: SQL: Dara de baja Usuario.
     * @param dni
     * @param fecha
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String guardarAsistenciaTmp(String dni,String fecha) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(guardarAsistencia)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_GUARDAR_ASISTENCIATMP(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, dni);
            cs.setString(2, fecha);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(3);
            respuesta = seguridad + '_' + mensaje;
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: bentu condori m. 
     * fecha: 2022-07-21 
     * descripcion: SQL: Dara de baja Usuario.
     * @param fecIni
     * @param fecFin
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos cargaAsistencia(String fecIni, String fecFin) throws Exception {
       Connection cn = null;
       ArrayList<reHumanos> listaAsistencia = new ArrayList<>();
       reHumanos reHumanos = new reHumanos();
       System.out.println("oracleDAO: cargaAsistencia");  
        String base = "access";
        PreparedStatement  cs = null;
        String seguridad = null;
        String respuesta = "";
        ResultSet rs;
        try {
            String sql = "SELECT CHECKINOUT.USERID, USERINFO.Badgenumber, CHECKINOUT.CHECKTIME, DateValue([CheckInOut].[CheckTime]) AS Expr1\n" +
                         "FROM CHECKINOUT INNER JOIN USERINFO ON CHECKINOUT.USERID = USERINFO.USERID\n" +
                         "WHERE DateValue([CheckInOut].[CheckTime]) Between '"+fecIni+"' AND '"+fecIni+"' ORDER BY CHECKINOUT.CHECKTIME DESC";
            cn = OracleDAOFactory.obtenerConexion(base);
            System.out.println("CN: "+cn);
            cs = cn.prepareStatement(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setNumeroDOI(rs.getString("Badgenumber"));
                re.setFecHoraMarcacion(rs.getString("CHECKTIME"));
                listaAsistencia.add(re); 
            }
            reHumanos.setListaAsistencia(listaAsistencia);
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;   
    }   
    
//  =================== FINAL DE REPORTES DE ASISTENCIAS  =================== 

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-21
     * descripcion: SQL: Desactivar Usuario.
     * @param codUsuario
     * @param usuario
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String desactivarUsuario(String codUsuario, String usuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(desactivasUsuario)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_DESACTIVAR_USU(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-19
     * descripcion: SQL: Lista Motivos de Baja.
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos listaMotivoBaja() throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaMotivoBaja)");
        ArrayList<reHumanos> listaMotivosBaja;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_MOTCESE(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaMotivosBaja = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodMotCese(rs.getString("COD_MOTCESE"));
                re.setDesMotCese(rs.getString("DES_MOTCESE"));
                listaMotivosBaja.add(re);
            }
            reHumanos.setListaMotivosBaja(listaMotivosBaja);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-18 
     * descripcion: SQL: Dara de baja Usuario.
     * @param codUsuario
     * @param codMotCese
     * @param fecCese
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String darBajaUsuario(String codUsuario,String codMotCese,String fecCese) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(darBajaUsuario)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_DARBAJA_USU(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setInt(2, Integer.valueOf(codMotCese));
            cs.setDate(3, Date.valueOf(fecCese));
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-15 
     * descripcion: SQL: Listar Usuarios.
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos listaUsuarios() throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaUsuarios)");
        ArrayList<reHumanos> listaUsuarios;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_USUACTIVOS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoUsuario(rs.getString("COD_USUARIO"));
                re.setNombreUsuario(rs.getString("USU_NOMBRE"));
                re.setApePaternoUsuario(rs.getString("USU_APATERNO"));
                re.setApeMaternoUsuario(rs.getString("USU_AMATERNO"));
                re.setUsuario(rs.getString("USUARIO"));
                re.setCodigoTipoDOI(rs.getString("COD_TDOC"));
                re.setDescTipoDOI(rs.getString("DES_TDOC"));
                re.setNumeroDOI(rs.getString("USU_NUMDOC"));
                re.setDescPerfil(rs.getString("CARGO"));
                re.setEstado(rs.getString("ESTADO"));
                listaUsuarios.add(re);
            }
            reHumanos.setListaUsuarios(listaUsuarios);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    
    @Override
    public String desactivarCargoUsuario(String codUserPerfil, String codUser, String codPerfil, String observacion, String usuario)throws Exception{
        System.out.println("SQLDAO SEGURIDAD(desactivarCargoUsuario)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_QUITAR_CARGOSUSU(?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUserPerfil));
            cs.setInt(2, Integer.valueOf(codUser));
            cs.setInt(3, Integer.valueOf(codPerfil));
            cs.setString(4, observacion);
            cs.setString(5, usuario);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(6);
            String mensaje = (String) cs.getObject(7);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(6) + " Mensaje: " + (String) cs.getObject(7));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-19 
     * descripcion: SQL: Listar Cargos de Usuario.
     * @param codUser
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public reHumanos listaCargosUsuario(String codUser) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaCargosUsuario)");
        ArrayList<reHumanos> listaCargosUsuario;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_CARGOSUSU(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUser));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaCargosUsuario = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoUsuario(rs.getString("COD_USUARIO"));
                re.setCodigoPerfil(rs.getString("COD_PERFIL"));
                re.setCodUsuPerfil(rs.getString("COD_USUPERFIL"));
                re.setDescArea(rs.getString("DES_AREA"));
                re.setDescPerfil(rs.getString("DES_PERFIL"));
                re.setFinicio(rs.getString("F_INICIO"));
                re.setFcese(rs.getString("F_CESE"));
                re.setMotivoCese(rs.getString("DES_MOTCESE"));
                re.setEstado(rs.getString("FLAG_ESTADO"));
                listaCargosUsuario.add(re);
            }
            reHumanos.setListaCargosUsuario(listaCargosUsuario);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    };
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-15 
     * descripcion: SQL: Asignar Cargo a Usuario.
     * @param codUsuario
     * @param codPerfil
     * @param usuario
     * @return
     * @throws java.lang.Exception
    **
    */
    @Override
    public String asignarCargoUsuario(String codUsuario, String codPerfil, String usuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(asignarCargoUsuario)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_ASIGNA_CARGOUSU(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setInt(2, Integer.valueOf(codPerfil));
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-15 
     * descripcion: SQL: Actualizar Usuarios.
     *
     * @param codUsuario
     * @param usuNombre
     * @param usuPaterno
     * @param usuMaterno
     * @param codTDoc
     * @param numDoc
     * @param codPais
     * @param usuFNac
     * @param codProv
     * @param codDist
     * @param usuCelular
     * @param usuCorreo
     * @param usuDirec
     * @param codDpto
     * @param usuFIni
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String actualizarUsuarios(String codUsuario, String usuNombre, String usuPaterno,String usuMaterno, String codTDoc,String numDoc, 
            String codPais,String codDpto, String codProv, String codDist, String usuCelular,String usuCorreo, String usuDirec,String usuSucursal, String usuFNac, String usuario)
            throws Exception{
        System.out.println("SQLDAO SEGURIDAD(actualizarUsuarios)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_ACTUALIZAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setString(2, usuNombre);
            cs.setString(3, usuPaterno);
            cs.setString(4, usuMaterno);
            cs.setInt(5, Integer.valueOf(codTDoc));
            cs.setString(6, numDoc);
            cs.setString(7, codPais);
            cs.setString(8, codDpto);
            cs.setString(9, codProv);
            cs.setString(10, codDist);
            cs.setString(11, usuCelular);
            cs.setString(12, usuCorreo);
            cs.setString(13, usuDirec);
            cs.setDate(14, Date.valueOf(usuFNac));
            //cs.setDate(15, Date.valueOf(usuFIni));
            cs.setString(15, usuario);
            cs.setInt(16, Integer.valueOf(usuSucursal));
            cs.registerOutParameter(17, java.sql.Types.VARCHAR);
            cs.registerOutParameter(18, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(17);
            String mensaje = (String) cs.getObject(18);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(17) + " Mensaje: " + (String) cs.getObject(18));
            
            
            
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-15 
     * descripcion: SQL: Guardar Usuarios.
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaPaises() throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaPaises)");
        ArrayList<reHumanos> listaPaises;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_MANTENIMIENTO.USP_LISTAR_UBIGEOPAIS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaPaises = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoPais(rs.getString("COD_PAIS"));
                re.setDescPais(rs.getString("DES_PAIS"));
                listaPaises.add(re);
            }
            reHumanos.setListaPaises(listaPaises);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-13 
     * descripcion: SQL: Guardar Usuarios.
     *
     * @param usuNombre
     * @param usuPaterno
     * @param usuMaterno
     * @param codTDoc
     * @param numDoc
     * @param codPais
     * @param usuFNac
     * @param codProv
     * @param codDist
     * @param usuCelular
     * @param usuCorreo
     * @param usuDirec
     * @param codArea
     * @param codDpto
     * @param usuFIni
     * @param codPerfil
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String guardarUsuarios(String usuNombre, String usuPaterno, String usuMaterno, String codTDoc, String numDoc, String codPais, 
            String codDpto, String codProv, String codDist, String usuCelular, String usuCorreo, String usuDirec,String usuSucursal, String codArea, String codPerfil, 
            String usuFNac, String usuFIni, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(guardarUsuarios)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        PreparedStatement ps;
        ResultSet rs;
        String seguridad = null;
        String base2 = "advantage";
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_REGISTRAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, usuNombre);
            cs.setString(2, usuPaterno);
            cs.setString(3, usuMaterno);
            cs.setInt(4, Integer.valueOf(codTDoc));
            cs.setString(5, numDoc);
            cs.setString(6, codPais);
            cs.setString(7, codDpto);
            cs.setString(8, codProv);
            cs.setString(9, codDist);
            cs.setString(10, usuCelular);
            cs.setString(11, usuCorreo);
            cs.setString(12, usuDirec);
            cs.setInt(13, Integer.valueOf(codArea));
            cs.setInt(14, Integer.valueOf(codPerfil));
            cs.setDate(15, Date.valueOf(usuFNac));
            cs.setDate(16, Date.valueOf(usuFIni));
            cs.setString(17, usuario);
            cs.setInt(18, Integer.valueOf(usuSucursal));
            cs.registerOutParameter(19, java.sql.Types.VARCHAR);
            cs.registerOutParameter(20, java.sql.Types.VARCHAR);
            cs.registerOutParameter(21, java.sql.Types.VARCHAR);
            cs.registerOutParameter(22, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(19);
            String mensaje = (String) cs.getObject(20);
            String codUsuario = (String) cs.getObject(21);
            String nombreUsuario = (String) cs.getObject(22);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(19) + " Mensaje: " + (String) cs.getObject(20));
            cs.close();
            if (seguridad.equals("1")) {
                String[] validar;
                try {
                    String sql2 = "EXECUTE PROCEDURE RegistroUsuario (?,?,?,?,?,?,?,?,?,?,?)";
                    cn = OracleDAOFactory.obtenerConexion(base2);
                    ps = cn.prepareStatement(sql2);
                    ps.setInt(1, 1); // CODIGO DE PROCEDIMIENTO
                    ps.setString(2, nombreUsuario ); // NOMBRE DE USUARIO DEL NUEVO REGISTRO
                    ps.setString(3, usuNombre ); // NOMBRE DE USUARIO 
                    ps.setString(4, usuPaterno ); //APPELDIDO PATERNO
                    ps.setString(5, usuMaterno ); // APPELDIDO MATERNO
                    ps.setInt(6, Integer.valueOf(codTDoc) ); // TIPO DE DOCUMENTO
                    ps.setString(7, numDoc ); //NUMERO DE DOCUMENTO
                    ps.setString(8, usuCelular ); // CELULAR
                    ps.setInt(9, Integer.valueOf(codPerfil)); // PERFIL DE USUARIO
                    ps.setString(10, usuario );// USUARIO REGISTRADOR
                    ps.setInt(11,0); // codigo de estado
                    rs = ps.executeQuery();
                    String mensaje2 = "";
                    while (rs.next()) {
                         mensaje2= rs.getString(1);
                    }
                    validar = mensaje2.split("-");                    
                    System.out.println("MySQL-> CodMensaje : " + validar[0]+ " Mensaje: " + validar[1]);
                    if(validar[0].equals("0")){
                        respuesta = validar[0] + '_' + validar[1];
                        cn.close();
                        String sql3 = "{call PKG_REHUMANOS.USP_BORRAR_USU(?,?,?)}";
                        cn = OracleDAOFactory.obtenerConexion(base);
                        cs = cn.prepareCall(sql3);
                        cs.setInt(1, Integer.valueOf(codUsuario));
                        cs.execute();
                        System.out.println("MySQL -> SE BORRO EL REGISTRO DE ORACLE");
                    }
                } catch (SQLException e) {
                    String sql3 = "{call PKG_REHUMANOS.USP_BORRAR_USU(?,?,?)}";
                    cn = OracleDAOFactory.obtenerConexion(base);
                    cs = cn.prepareCall(sql3);
                    cs.setInt(1, Integer.valueOf(codUsuario));
                    cs.registerOutParameter(2, java.sql.Types.VARCHAR);
                    cs.registerOutParameter(3, java.sql.Types.VARCHAR);
                    cs.execute();
                    respuesta = "0_ERROR DE REGISTRO SAFC";
                    System.out.println("MySQL -> SE BORRO EL REGISTRO DE ORACLE");
                    System.out.println("EXCEPTION ADVANTAGE GUARDAR REGISTRO =>>>>>>>>>> " + e);
                } finally {
                    cn.close();
                }                
            }
        } catch (SQLException e) {
            System.out.println("EXCEPTION ORACLE GUARDAR REGISTRO=>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-12 
     * descripcion: SQL: Validar Numero de Documento.
     *
     * @param codTDoc
     * @param numDoc
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos validarNumDoc(String codTDoc, String numDoc) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(validarNumDoc)");
        reHumanos re = null;
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_VALIDAR_NUMDOC(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codTDoc));
            cs.setString(2, String.valueOf(numDoc));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            re = new reHumanos();
            while (rs.next()) {
                re.setCodigoUsuario(rs.getString("COD_USUARIO"));
                re.setUsuario(rs.getString("USUARIO"));
                re.setNombreUsuario(rs.getString("USU_NOMBRE"));
                re.setApePaternoUsuario(rs.getString("USU_APATERNO"));
                re.setApeMaternoUsuario(rs.getString("USU_AMATERNO"));
                re.setDescTipoDOI(rs.getString("DES_TDOC"));
                re.setNumeroDOI(rs.getString("USU_NUMDOC"));
                re.setCodigoPais(rs.getString("COD_PAIS"));
                re.setDescPais(rs.getString("DES_PAIS"));
                re.setCodigoDepartamento(rs.getString("COD_DPTO"));
                re.setCodigoProvincia(rs.getString("COD_PROV"));
                re.setCodigoDistrito(rs.getString("COD_DIST"));
                re.setDescDepartamento(rs.getString("DES_DPTO"));
                re.setDescProvincia(rs.getString("DES_PROV"));
                re.setDescDistrito(rs.getString("DES_DIST"));
                re.setFechaNacimiento(rs.getString("USU_FNACIMIENTO"));
                re.setTelefono(rs.getString("USU_TELEFONO"));
                re.setEmail(rs.getString("USU_EMAIL"));
                re.setDireccion(rs.getString("USU_DIRECC"));
                re.setFinicio(rs.getString("F_INICIO"));
                re.setDescArea(rs.getString("AREA"));
                re.setDescPerfil(rs.getString("PERFIL"));
                re.setCodSucursal(rs.getString("COD_SUCURSAL"));
                re.setDesSucursal(rs.getString("DES_SUCURSAL"));
            }
            re.setCodMensaje((String)cs.getObject(4));
            re.setMensaje((String)cs.getObject(5));
            
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return re;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-11 
     * descripcion: SQL: Listar Tipos de documentos.
     *
     * @param codTipoDoc
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaTipoDocumento(String codTipoDoc) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaTipoDocumento)");
        ArrayList<reHumanos> listaTipoDocumento;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_PERSONAS.USP_LISTAR_TIPDOCUMENTO(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codTipoDoc));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaTipoDocumento = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodMensaje(rs.getString("COD_TDOC"));
                re.setMensaje(rs.getString("DES_TDOC"));
                listaTipoDocumento.add(re);
            }
            reHumanos.setListaTipoDocumento(listaTipoDocumento);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-08-09
     * descripcion: SQL: DAR BAJA USUARIO DE Sucursal.
     *
     * @param codSucursal
     * @param codUsuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String bajaUsuarioSucursal(String codSucursal, String codUsuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(bajaUsuarioSucursal)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_BAJA_USUASUCURSAL(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSucursal));
            cs.setInt(2, Integer.valueOf(codUsuario));
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-08-09 
     * descripcion: SQL: Listar Usuarios de Sucursal.
     * @param codSucursal
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaUsuariosSucursal(String codSucursal) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(listaUsuariosSucursal)");
        ArrayList<reHumanos> listaUsuariosSucursal;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_USUASUCURSAL(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSucursal));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaUsuariosSucursal = new ArrayList<>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoUsuario(rs.getString("COD_USUARIO"));
                re.setNombreUsuario(rs.getString("USU_NOMBRE"));
                re.setApePaternoUsuario(rs.getString("USU_APATERNO"));
                re.setApeMaternoUsuario(rs.getString("USU_AMATERNO"));
                re.setDescPerfil(rs.getString("CARGO"));
                listaUsuariosSucursal.add(re);
            }
            reHumanos.setListaUsuariosSucursal(listaUsuariosSucursal);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-08 
     * descripcion: SQL: Desactivar Area en Sucursal.
     *
     * @param codSucursal
     * @param codArea
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String desactivarAreaSucursal(String codSucursal, String codArea, String usuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(desactivarAreaSucursal)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = "";
        try {
            String sql = "{call PKG_REHUMANOS.USP_DESACT_AREASEDE(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSucursal));
            cs.setInt(2, Integer.valueOf(codArea));
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-08 
     * descripcion: SQL: Agregar Area a Sucursal.
     *
     * @param codSucursal
     * @param codArea
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override 
    public String agregarAreasSucursal(String codSucursal, String codArea, String usuario) throws Exception{
        System.out.println("SQLDAO SEGURIDAD(agregarAreasSucursal)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = null;
        try {
            String sql = "{call PKG_REHUMANOS.USP_AGREGAR_AREASEDE(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSucursal));
            cs.setInt(2, Integer.valueOf(codArea));
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }
    
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-08 
     * descripcion: SQL: Listar Areas Sucursal.
     *
     * @param codSucursal
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaAreasSucursal(String codSucursal)throws Exception{
      System.out.println("SQLDAO SEGURIDAD(listaAreasSucursal)");
        ArrayList<reHumanos> listaAreasSucursal;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_AREASSUCURSAL(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, codSucursal);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaAreasSucursal = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodSucursal(rs.getString("COD_SUCURSAL"));
                re.setCodigoArea(rs.getString("COD_AREA"));
                re.setDescArea(rs.getString("DES_AREA"));
                re.setDesSucursal(rs.getString("DES_SUCURSAL"));
                re.setEstado(rs.getString("ESTADO"));
                listaAreasSucursal.add(re);
            }
            reHumanos.setListaAreasSucursal(listaAreasSucursal);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }
    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-07 descripcion: SQL: Actualizar sucursal.
     *
     * @param codSede
     * @param nomSede
     * @param telefono
     * @param email
     * @param prov
     * @param usuario
     * @param direc
     * @param dpto
     * @param dist
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String actualizarSucursal(String codSede, String nomSede, String telefono, String email, String dpto, String prov, String dist, String direc, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(actualizarSucursal)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = null;
        try {
            String sql = "{call PKG_REHUMANOS.USP_ACTUALIZAR_SEDE(?,?,?,?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSede));
            cs.setString(2, nomSede);
            cs.setString(3, telefono);
            cs.setString(4, email);
            cs.setString(5, dpto);
            cs.setString(6, prov);
            cs.setString(7, dist);
            cs.setString(8, direc);
            cs.setString(9, usuario);
            cs.registerOutParameter(10, java.sql.Types.VARCHAR);
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(10);
            String mensaje = (String) cs.getObject(11);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(10) + " Mensaje: " + (String) cs.getObject(11));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-07 descripcion: SQL: eliminar
     * sucursal.
     *
     * @param codSucursal
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String deleteSucursal(String codSucursal, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(deleteSucursal)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = null;
        String respuesta = null;
        try {
            String sql = "{call PKG_REHUMANOS.USP_DARBAJA_SUCURSAL(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codSucursal));
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-05 descripcion: SQL: Traer lista
     * de distritos.
     *
     * @param codDpto
     * @param codProv
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaDistritos(String codDpto, String codProv) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listaDistritos)");
        ArrayList<reHumanos> listaDistritos;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_MANTENIMIENTO.USP_LISTAR_UBIGEODIST(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, codDpto);
            cs.setString(2, codProv);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            listaDistritos = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoDistrito(rs.getString("COD_DIST"));
                re.setDescDistrito(rs.getString("DES_DIST"));
                listaDistritos.add(re);
            }
            reHumanos.setListaDistritos(listaDistritos);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-05 descripcion: SQL: Traer lista
     * de provincias.
     *
     * @param codDpto
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaProvincias(String codDpto) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listaProvincias)");
        ArrayList<reHumanos> listaProvincias;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_MANTENIMIENTO.USP_LISTAR_UBIGEOPROV(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, codDpto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaProvincias = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoProvincia(rs.getString("COD_PROV"));
                re.setDescProvincia(rs.getString("DES_PROV"));
                listaProvincias.add(re);
            }
            reHumanos.setListaProvincias(listaProvincias);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-05 descripcion: SQL: Traer lista
     * de departamentos.
     *
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaDepartamentos() throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listaDepartamentos)");
        ArrayList<reHumanos> listaDepartamentos;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_MANTENIMIENTO.USP_LISTAR_UBIGEODPTO(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaDepartamentos = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoDepartamento(rs.getString("COD_DPTO"));
                re.setDescDepartamento(rs.getString("DES_DPTO"));
                listaDepartamentos.add(re);
            }
            reHumanos.setListaDepartamentos(listaDepartamentos);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-05 descripcion: SQL: Guardar
     * nueva sucursal.
     *
     * @param nombre
     * @param telefono
     * @param email
     * @param dpto
     * @param prov
     * @param dist
     * @param direccion
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String guardarSucursal(String nombre, String telefono, String email, String dpto, String prov, String dist, String direccion, String usuario) throws Exception {
        System.out.println("/////////////SQLDAO reHumanos(guardarSucursal)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs;
        String seguridad;
        String respuesta = null;

        try {
            String sql = "{call pkg_rehumanos.USP_GUARDAR_SEDE(?,?,?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, telefono);
            cs.setString(3, email);
            cs.setString(4, dpto);
            cs.setString(5, prov);
            cs.setString(6, dist);
            cs.setString(7, direccion);
            cs.setString(8, usuario);
            cs.registerOutParameter(9, java.sql.Types.VARCHAR);
            cs.registerOutParameter(10, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(9);
            String mensaje = (String) cs.getObject(10);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(9) + " Mensaje: " + (String) cs.getObject(10));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-07-05 descripcion: SQL: Traer lista
     * de sucursales.
     *
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public reHumanos listaSucursales() throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listaSucursales)");
        ArrayList<reHumanos> listaSucursales;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTA_SUCURSALES(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaSucursales = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodSucursal(rs.getString("COD_SUCURSAL"));
                re.setDesSucursal(rs.getString("DES_SUCURSAL"));
                re.setTelefono(rs.getString("TELEFONO"));
                re.setEmail(rs.getString("EMAIL"));
                re.setDireccion(rs.getString("DIRECCION"));
                re.setCiudad(rs.getString("CIUDAD"));
                re.setCodigoDepartamento(rs.getString("COD_DPTO"));
                re.setCodigoProvincia(rs.getString("COD_PROV"));
                re.setCodigoDistrito(rs.getString("COD_DIST"));
                re.setDescDepartamento(rs.getString("DES_DPTO"));
                re.setDescProvincia(rs.getString("DES_PROV"));
                re.setDescDistrito(rs.getString("DES_DIST"));
                re.setEstado(rs.getString("ESTADO"));
                re.setTipoSucursal(rs.getString("TIP_SUCURSAL"));
                listaSucursales.add(re);
            }
            reHumanos.setListaSucursales(listaSucursales);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    };
    
        /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 2022-07-01
    descripcion: SQL: Actualizar perfil.
     * @param codArea
     * @param codPerfil
     * @param codModulos
     * @param codSubModulos
     * @param codPermisos
     * @param usuario
     * @return 
     * @throws java.lang.Exception
    ******************************************************************************/
    @Override
    public String guardarRoles(String codPerfil, String codArea, String codModulos, String codSubModulos, String codPermisos, String usuario)
            throws Exception {
        System.out.println("/////////////SQLDAO reHumanos(guardarRoles)");

        String base = "elclan";
        Connection cn = null;
        CallableStatement cs;
        String seguridad = null;
        System.out.println("codArea: " + codPerfil);
        System.out.println("nomPerfil: " + codArea);
        System.out.println("codModulos: " + codModulos);
        System.out.println("codSubModulos: " + codSubModulos);
        codModulos += ",";
        System.out.println("codModulos: " + codModulos);
        System.out.println("codPermisos: " + codPermisos);
        System.out.println("usuario: " + usuario);
        String respuesta = null;

        try {
            String sql = "{call pkg_rehumanos.USP_CREAR_ROLPERFIL(?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setInt(2, Integer.valueOf(codArea));
            cs.setString(3, codModulos);
            cs.setString(4, codSubModulos + ",");
            cs.setString(5, codPermisos + ",");
            cs.setString(6, usuario);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
            cs.registerOutParameter(8, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(7);
            String mensaje = (String) cs.getObject(8);
            respuesta = seguridad + '_' + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(7) + " Mensaje: " + (String) cs.getObject(8));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    };    
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 27-06-2022
    descripcion: SQL: lista lor roles o cargos segun el area
     * @param codPerfil
     * @param codSubModulo
     * @return 
     * @throws java.sql.SQLException 
    ******************************************************************************/
    @Override
    public mantenimiento ListaPermisos(String codPerfil, String codSubModulo) throws SQLException {
        System.out.println("SQLDAO SEGURIDAD(ListaPermisos)");
        ArrayList<mantenimiento> listaAreas;
        mantenimiento mantenimiento = new mantenimiento();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_MANTENIMIENTO.USP_LISTPERMISUB(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setInt(2, Integer.valueOf(codSubModulo));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            listaAreas = new ArrayList<mantenimiento>();
            while (rs.next()) {
                mantenimiento man = new mantenimiento();
                man.setCodSubModuloOpc(rs.getString("COD_SUBMODOPCI"));
                man.setDesSubModuloOpc(rs.getString("DES_SUBMODOPCI"));
                man.setSituCheck(rs.getString("SITU_CHECK"));
                listaAreas.add(man);
            }
            mantenimiento.setListaSubModulosOpc(listaAreas);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return mantenimiento;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 27-06-2022 descripcion: SQL: lista lor
     * roles o cargos segun el area
     *
     * @param codArea
     * @return
     * @throws java.sql.SQLException 
    *****************************************************************************
     */
    @Override
    public reHumanos listarPerfiles(String codArea) throws SQLException {
        System.out.println("SQLDAO SEGURIDAD(listarPerfiles)");
        ArrayList<reHumanos> listaPerfiles;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTPERFIL_AREAS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            listaPerfiles = new ArrayList<reHumanos>();
            while (rs.next()) {
                reHumanos re = new reHumanos();
                re.setCodigoPerfil(rs.getString("cod_perfil"));
                re.setDescPerfil(rs.getString("des_perfil"));
                listaPerfiles.add(re);
            }
            reHumanos.setListaPerfiles(listaPerfiles);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return reHumanos;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 27-06-2022 descripcion: SQL: lista lor
     * roles o cargos segun el area
     *
     * @return 
    *****************************************************************************
     */
    @Override
    public mantenimiento listarAllAreas() throws SQLException {
        System.out.println("SQLDAO SEGURIDAD(listarAllAreas)");
        ArrayList<mantenimiento> listaAreas;
        mantenimiento mantenimiento = new mantenimiento();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        try {
            String sql = "{call PKG_REHUMANOS.USP_LISTAR_AREAS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            listaAreas = new ArrayList<mantenimiento>();
            while (rs.next()) {
                mantenimiento man = new mantenimiento();
                man.setmCodigoArea(rs.getString("cod_area"));
                man.setmDescArea(rs.getString("des_area"));
                man.setmUCreacion(rs.getString("u_creacion"));
                man.setmFCreacion(rs.getString("f_creacion"));
                listaAreas.add(man);
            }
            mantenimiento.setListaAreas(listaAreas);
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (SQLException e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return mantenimiento;

    }

    @Override
    public ArrayList<mantenimiento> listarSubModulos(String codModulo, String codPerfil) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listarSubModulos)");
        ArrayList<mantenimiento> listasubmodulo = new ArrayList<mantenimiento>();
        Connection cn = null;

        String base = "elclan";
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = "{call pkg_mantenimiento.USP_LISTARSUBMODULOS(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setInt(2, Integer.valueOf(codModulo));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            System.out.println("(1) SASTIFACTORIO ORACLE-SQL :" + cs.getObject(4));
            System.out.println("(2) SASTIFACTORIO ORACLE-SQL :" + cs.getObject(5));
            rs = (ResultSet) cs.getObject(3);
            while (rs.next()) {
                mantenimiento seg = new mantenimiento();
                System.out.println("ora: des_sub: " + rs.getString("des_submodulo"));

                seg.setCodSubModulo(rs.getString("cod_submodulo"));
                seg.setDesSubModulo(rs.getString("des_submodulo"));
                seg.setSituCheck(rs.getString("situ_check"));
                listasubmodulo.add(seg);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return listasubmodulo;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 25-06-2022 descripcion: SQL: lista lor
     * roles o cargos segun el area
     *
     * @param codPerfil
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public mantenimiento listarModulos(String codPerfil) throws Exception {
        System.out.println("SQLDAO reHumanos(listarModulos)");
        ArrayList<mantenimiento> listaModulos;
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        String respuesta;
        System.out.println("listarModulos:::::::::::::::::");
        mantenimiento mantenimiento = new mantenimiento();
        try {
            String sql = "{call pkg_mantenimiento.USP_LISTAR_MODULOS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            System.out.println("//////////////// ==>>=>>>>>=>=>=>>==>>=>=>");
            String seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = mensaje + '_' + seguridad;
            rs = (ResultSet) cs.getObject(2);
            listaModulos = new ArrayList<mantenimiento>();
            System.out.println("///////////////////////////////////////////////////////");
            //rs = (ResultSet) ;
            System.out.println("RESULTADO" + rs);
            while (rs.next()) {
                mantenimiento man = new mantenimiento();

                man.setCodModulo(rs.getString("cod_modulo"));
                man.setDesModulo(rs.getString("des_modulo"));
                man.setCanSubModulo(rs.getString("cansu"));
                man.setSituCheck(rs.getString("SITU_CHECK"));

                listaModulos.add(man);

            }
            mantenimiento.setListaModulos(listaModulos);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!HAY MODULOS!!!!!!!!!!!!!!!!!!!!!!!!!");
            listaModulos.stream().forEach(list
                    -> System.out.println(list.getDesModulo())
            );
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));

        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return mantenimiento;
    }

    /**
     * **************************************************************************
     * autor: yasub huaman ramos fecha: 2022-06-23 descripcion: SQL: Actualizar
     * perfil.
     *
     * @param codArea
     * @param nomPerfil
     * @param codPerfil
     * @param usuario
     * @return
     * @throws java.lang.Exception
    *****************************************************************************
     */
    @Override
    public String actualizarPerfil(String codArea, String nomPerfil, String codPerfil, String usuario) throws Exception {
        System.out.println("/////////////SQLDAO reHumanos(actualizarPerfil)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs;
        String seguridad = null;
        System.out.println("codArea: " + codArea);
        System.out.println("nomPerfil: " + nomPerfil);
        System.out.println("codPerf: " + codPerfil);
        System.out.println("usuario: " + usuario);
        String respuesta = null;

        try {
            String sql = "{call pkg_rehumanos.USP_ACTUALIZAR_PERFIL(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setInt(2, Integer.valueOf(codArea));
            cs.setString(3, nomPerfil);
            cs.setString(4, usuario);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.registerOutParameter(6, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(5);
            String mensaje = (String) cs.getObject(6);
            respuesta = mensaje + '_' + seguridad;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(5) + " Mensaje: " + (String) cs.getObject(6));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    ;
    
    
    
    /****************************************************************************
    autor:  bentu condori
    fecha: 2022-06-22
    descripcion: SQL: Da de baja perfiles o cargo segun area
    ******************************************************************************/
    @Override
    public String confirBorrarPerfil(String codPerfil, String usuario) throws Exception {
        System.out.println("/////////////SQLDAO reHumanos(confirBorrarPerfil)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        String seguridad;
        System.out.println("codArea: " + codPerfil);
        System.out.println("usuario: " + usuario);
        String respuesta = null;
        String mensaje = null;

        try {
            String sql = "{call pkg_rehumanos.USP_BORRAR_PERFIL(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codPerfil));
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(3);
            mensaje = (String) cs.getObject(4);
            respuesta = mensaje + '_' + seguridad;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 2021-10-25 descripcion: SQL: registra
     * perfiles o cargo segun area
    *****************************************************************************
     */
    @Override
    public String guardarCargo(String codArea, String nomPerfil, String usuario) throws Exception {
        System.out.println("/////////////SQLDAO reHumanos(guardarCargo)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String seguridad = "";
        String respuesta = "";
        System.out.println("codArea: " + codArea);
        System.out.println("nomPerfil: " + nomPerfil);
        System.out.println("usuario: " + usuario);

        try {
            String sql = "{call pkg_rehumanos.USP_GUARDAR_CARGO(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.setString(2, nomPerfil);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return seguridad;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 16-06-2022 descripcion: SQL: retorna el
     * nombre del area segun el codigo
    *****************************************************************************
     */
    @Override
    public String returnNomArea(String codArea) throws Exception {
        System.out.println("SQLDAO reHumanos(returnNomArea)");
        String desArea = "";
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs = null;
        ResultSet rs = null;
        System.out.println("returnNomArea: " + codArea);
        try {
            String sql = "{call pkg_rehumanos.USP_LISTANOM_AREAS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();

            desArea = (String) cs.getObject(3);

        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return desArea;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 16-06-2022 descripcion: SQL: lista lor roles
     * o cargos segun el area
    *****************************************************************************
     */
    @Override
    public ArrayList<reHumanos> listarPerfilesArea(String codArea) throws Exception {
        System.out.println("SQLDAO reHumanos(listarPerfilesArea)");
        ArrayList<reHumanos> listaPerfil = new ArrayList<reHumanos>();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs = null;
        ResultSet rs = null;
        System.out.println("listarPerfilesArea:::::::::::::::::codArea : " + codArea);
        try {
            String sql = "{call pkg_rehumanos.USP_LISTPERFIL_AREAS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);

            //rs = (ResultSet) ;
            while (rs.next()) {
                reHumanos seg = new reHumanos();
                seg.setCodigoPerfil(rs.getString("cod_perfil"));
                seg.setCodigoArea(rs.getString("cod_area"));
                seg.setDescArea(rs.getString("des_area"));
                seg.setDescPerfil(rs.getString("des_perfil"));
                seg.setCodigoUsuario(rs.getString("u_creacion"));
                seg.setFeCreacion(rs.getString("f_creacion"));
                seg.setDesEstado(rs.getString("flag_estado"));
                listaPerfil.add(seg);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return listaPerfil;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 2021-10-25 descripcion: SQL: desactivar area
    *****************************************************************************
     */
    @Override
    public String borrarArea(String codArea, String usuario) throws Exception {
        System.out.println("SQLDAO reHumanos(borrarArea)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String seguridad = "";
        String respuesta = "";
        System.out.println("codArea: " + codArea);

        try {
            String sql = "{call pkg_rehumanos.USP_BORRAR_AREA(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);

            cs.execute();
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_"+ mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 13-06-2022 descripcion: SQL: actualiza datos
     * del area
    *****************************************************************************
     */
    @Override
    public String actualizarArea(String codArea, String nomArea, String usuario) throws Exception {
        System.out.println("SQLDAO reHumanos(actualizarArea)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String seguridad = "";
        String respuesta = "";

        try {
            String sql = "{call pkg_rehumanos.USP_ACTUALIZAR_AREA(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codArea));
            cs.setString(2, nomArea);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 2021-10-23 descripcion: SQL: registra el
     * area(registra las nuevas areas)
    *****************************************************************************
     */
    @Override
    public String guardarArea(String nomArea, String usuario) throws Exception {
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzORACLE reHumanos(guardarArea)");
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String seguridad = "";
        String respuesta = "";
        System.out.println("nomArea: " + nomArea + " USUARIO: " + usuario);
        
        try {
            String sql = "{call pkg_rehumanos.USP_GUARDAR_AREAS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, nomArea);
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);

            cs.execute();
            String codMensaje = (String) cs.getObject(3);
            seguridad = (String) cs.getObject(4);
            respuesta = codMensaje + "_" + seguridad;
            System.out.println("Oracle guardar AREA-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }

    @Override
    public ArrayList<reHumanos> listarAreas() throws Exception {
        System.out.println("ORACLE reHumanos(listarAreas)");
        ArrayList<reHumanos> listaArea = new ArrayList<reHumanos>();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = "{call pkg_rehumanos.USP_LISTAR_AREAS(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            //rs = (ResultSet) ;
            while (rs.next()) {
                reHumanos seg = new reHumanos();
                seg.setCodigoArea(rs.getString("cod_area"));
                seg.setDescArea(rs.getString("des_area"));
                seg.setCodigoUsuario(rs.getString("u_creacion"));
                seg.setFeCreacion(rs.getString("f_creacion"));
                listaArea.add(seg);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return listaArea;
    }

    /**
     * **************************************************************************
     * autor: bentu condori fecha: 17-03-2022 descripcion: SQL: funcionn para
     * listar menu interno segun usuario
    *****************************************************************************
     */
    @Override
    public reHumanos Login(String codUsuario, String pass) throws Exception {

        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        reHumanos usuarios = null;
        reHumanos usuarios1 = new reHumanos();
        ArrayList<reHumanos> lista = new ArrayList<reHumanos>();
        System.out.println("LLEGO A  ORACLE DAO");
        System.out.println("codUsuario :" + codUsuario);
        System.out.println("pass :" + pass);
        try {
            String sql = "{call pkg_rehumanos.USP_LOGIN(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setString(1, codUsuario);
            cs.setString(2, pass);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            System.out.println("(1) ERROR ORACLE-SQL :" + cs.getObject(4));
            System.out.println("(2) ERROR ORACLE-SQL :" + cs.getObject(5));
            rs = (ResultSet) cs.getObject(3);///.....................................APUNTA AL CURSOR
            while (rs.next()) {
                usuarios = new reHumanos();
                usuarios.setCodigoUsuario(rs.getString(1));
                usuarios.setUsuario(rs.getString(2));
                usuarios.setNombreUsuario(rs.getString(3));
                usuarios.setApePaternoUsuario(rs.getString(4));
                usuarios.setApeMaternoUsuario(rs.getString(5));

                lista.add(usuarios);
            }
            usuarios1.setListaUsuarios(lista);
            usuarios1.setCodMensaje(cs.getString(4));
            usuarios1.setMensaje(cs.getString(5));

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return usuarios1;
    }

    
}
