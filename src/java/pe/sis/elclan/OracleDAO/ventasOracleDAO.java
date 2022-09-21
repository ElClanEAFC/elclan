package pe.sis.elclan.OracleDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
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

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * listaVendedores
     *
     * @param codVendedor
     * @param codUnidad
     * @param codEquipo
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaVendedores(int codVendedor, int codUnidad, int codEquipo) throws Exception {
        System.out.println("*/*************************************** codVendedor"+codVendedor);
        System.out.println("ORACLEDAO SEGURIDAD(listarVendedores)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listarVende = new ventas();
        ArrayList<ventas> listarVendedores = new ArrayList<ventas>();
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTA_VENDEDORES(?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);

            cs = cn.prepareCall(sql);
            cs.setInt(1, codVendedor);
            cs.setInt(2, codUnidad);
            cs.setInt(3, codEquipo);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(4);

            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_cod_Vendedor(rs.getString("COD_VENDEDOR"));
                ventas.setV_nombres(rs.getString("USU_NOMBRE"));
                ventas.setV_apellidoPaterno(rs.getString("USU_APATERNO"));
                ventas.setV_apellidoMaterno(rs.getString("USU_AMATERNO"));
                ventas.setV_usuario(rs.getString("USUARIO"));
                ventas.setV_tipoDocumento(rs.getString("COD_TDOC"));
                ventas.setV_des_documento(rs.getString("DES_TDOC"));
                ventas.setV_numDocumento(rs.getString("USU_NUMDOC"));
                ventas.setV_estado(rs.getString("ESTADO"));
                ventas.setV_est_SMV(rs.getString("EST_SMV"));
                ventas.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ventas.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ventas.setV_cargo(rs.getString("CARGO"));

                System.out.println("*************************************NOMBRE ****"+rs.getString("USU_NOMBRE"));
                listarVendedores.add(ventas);
            }

            listarVende.setListaVendedores(listarVendedores);

            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(5) + " Mensaje: " + (String) cs.getObject(6));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listarVende;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * listaUnidad
     *
     * @param codUnidad
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaUnidad(int codUnidad) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarUnidad)");

        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listarUnidad = new ventas();
        ArrayList<ventas> ListaUnidades = new ArrayList<ventas>();

        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_UNIDADES(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, 1);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ventas.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ventas.setV_estado(rs.getString("ESTADO"));
                ventas.setV_usuario(rs.getString("U_CREACION"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));
                ListaUnidades.add(ventas);

            }
            listarUnidad.setListarUnidad(ListaUnidades);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listarUnidad;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * listaEquipos
     *
     * @param codEquipo
     * @param codUnidad
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaEquipos(int codEquipo, int codUnidad) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listaEquipos)");

        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listarEquipo = new ventas();
        ArrayList<ventas> listarEquipos = new ArrayList<ventas>();

        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_EQUIPOS(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, codEquipo);
            cs.setInt(2, codUnidad);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ventas.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ventas.setV_estado(rs.getString("ESTADO"));
                ventas.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ventas.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ventas.setV_usuario(rs.getString("U_CREACION"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));
                listarEquipos.add(ventas);
            }
            listarEquipo.setListarEquipos(listarEquipos);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listarEquipo;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * listarCategoria
     *
     * @param codCategoria
     * @return
     * @throws Exception
     */
    @Override
    public ventas listarCategoria(int codCategoria) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;

        ventas listarCategoria = new ventas();
        ArrayList<ventas> listarCategorias = new ArrayList<ventas>();

        try {
            String consulta = "{call PKG_COMERCIAL.USP_LISTAR_CATEGORIAS(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setInt(1, codCategoria);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codCategoria(rs.getString("COD_CATEGVEND"));
                ventas.setV_desCategoria(rs.getString("DES_CATEGVEND"));
                ventas.setV_estado(rs.getString("FLAG_ESTADO"));
                ventas.setV_usuario(rs.getString("U_CREACION"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));
                listarCategorias.add(ventas);
            }
            listarCategoria.setListarCategoria(listarCategorias);

        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listarCategoria;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * registroCategoria
     *
     * @param desCategoria
     * @param Usuario
     * @return
     * @throws Exception
     */
    @Override
    public String registroCategoria(String desCategoria, String Usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(registroCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
            String consulta = "call PKG_COMERCIAL.USP_GUARDAR_CATEGORIA(?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setString(1, desCategoria);
            cs.setString(2, Usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + '_' + mensaje;

            System.out.println("MySQL-> CodMensaje : " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));

        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return respuesta;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * ActualizarCategoria
     *
     * @param codCategoria
     * @param desCategoria
     * @param Usuario
     * @return
     * @throws Exception
     */
    @Override
    public String ActualizarCategoria(int codCategoria, String desCategoria, String Usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(ActualizarCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
            String consulta = "call PKG_COMERCIAL.USP_ACTUALIZA_CATEGORIA(?,?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setInt(1, codCategoria);
            cs.setString(2, desCategoria);
            cs.setString(3, Usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));

        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        }
        return respuesta;
    }

    /**
     * autor: Victor Rosales Arones fecha: 06/09/2022 description: ORACLE
     * darBajaCategoria
     *
     * @param codCategoria
     * @param desCategoria
     * @param Usuario
     * @return
     * @throws Exception
     */
    @Override
    public String darBajaCategoria(int codCategoria, String desCategoria, String Usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(darBajaCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
           
            
            String consulta = "call PKG_COMERCIAL.USP_DARBAJA_CATEGORIA(?,?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setInt(1, codCategoria);
            cs.setString(2, desCategoria);
            cs.setString(3, Usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));

        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        }
        return respuesta;
    }

    /**
     * autor: Victor Rosales Arones fecha: 07/09/2022 description: ORACLE
     * registroVariCategoria
     *
     * @param desVariableCat
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String registroVariCategoria(String desVariableCat, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(registroVariCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
            String consulta = "call PKG_COMERCIAL.USP_GUARDAR_VARIABLECAT(?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setString(1, desVariableCat);
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
        }
        return respuesta;
    }

    /**
     * autor: Victor Rosales Arones fecha: 07/09/2022 description: ORACLE
     * listaVariCategoria
     *
     * @param codVariableCat
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaVariCategoria(int codVariableCat) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listaVariCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listarVariCategoria = new ventas();
        ArrayList<ventas> listarVariCategorias = new ArrayList<ventas>();
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_VARIABLECAT(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);

            cs = cn.prepareCall(sql);
            cs.setInt(1, codVariableCat);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codVariableCat(rs.getString("COD_CATEGVARIA"));
                ventas.setV_desVariableCat(rs.getString("DES_CATEGVARIA"));
                ventas.setV_estado(rs.getString("FLAG_ESTADO"));
                ventas.setV_usuario(rs.getString("U_CREACION"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));

                listarVariCategorias.add(ventas);
            }

            listarVariCategoria.setV_listaVariableCat(listarVariCategorias);

            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listarVariCategoria;

    }

    /**
     * autor: Victor Rosales Arones fecha: 07/09/2022 description: ORACLE
     * listaVariablesCat
     *
     * @param codVariableCat
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaVariablesCat(int codVariableCat) throws Exception {

        System.out.println("ORACLEDAO SEGURIDAD(listaVariablesCat)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listarVariCategoria = new ventas();
        ArrayList<ventas> listarVariCategorias = new ArrayList<ventas>();
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_VARIABLECAT(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);

            cs = cn.prepareCall(sql);
            cs.setInt(1, codVariableCat);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codVariableCat(rs.getString("COD_CATEGVARIA"));
                ventas.setV_desVariableCat(rs.getString("DES_CATEGVARIA"));

                listarVariCategorias.add(ventas);
            }

            listarVariCategoria.setV_listaVariableCat(listarVariCategorias);

            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }

        return listarVariCategoria;
    }

    /**
     * autor: Victor Rosales Arones fecha: 07/09/2022 description: ORACLE
     * actualizarVariCategoria
     *
     * @param codVariableCat
     * @param desVariableCat
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String actualizarVariCategoria(int codVariableCat, String desVariableCat, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(actualizarVariCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
            String consulta = "call PKG_COMERCIAL.USP_ACTUALIZA_VARIABLECAT(?,?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setInt(1, codVariableCat);
            cs.setString(2, desVariableCat);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
        }
        return respuesta;
    }

    /**
     * autor: Victor Rosales Arones fecha: 07/09/2022 description: ORACLE
     * darBajaVariCategoria
     *
     * @param codVariableCat
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String darBajaVariCategoria(int codVariableCat, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(darBajaVariCategoria)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String seguridad = "";
        String respuesta = "";
        try {
            String consulta = "call PKG_COMERCIAL.USP_DARBAJA_VARIABLECAT(?,?,?,?)";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(consulta);
            cs.setInt(1, codVariableCat);
            cs.setString(2, usuario);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();

            //Respuesta al realizar la operación
            seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
        }
        return respuesta;
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
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.setInt(2, Integer.valueOf(codEquipo));
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(3);
            String mensaje = (String) cs.getObject(4);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
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
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.setInt(2, Integer.valueOf(codEquipo));
            cs.setString(3, desEquipo);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    @Override
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(guardarEquipo)");
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "el clan";
        CallableStatement cs;
        ResultSet rs;
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
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }

    @Override
    public ventas listarEquipos(String codUnidad, String codEquipo) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listarEquipos)");
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "el clan";
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
            while (rs.next()) {
                ventas.setV_codEquipo(rs.getString("COD_EQUIPO"));
                ventas.setV_desEquipo(rs.getString("DES_EQUIPO"));
                ventas.setV_estado(rs.getString("ESTADO"));
                ventas.setV_codUnidad(rs.getString("COD_UNIDAD"));
                ventas.setV_desUnidad(rs.getString("DES_UNIDAD"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));
            }
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return ventas;
    }

    /**
     * autor: Victor Rosales Arones fecha: 14/09/2022 description: ORACLE lista
     * Condicion de Variables
     *
     *
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaCondicionVar() throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listaCondicionVar)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listaCondicion = new ventas();
        ArrayList<ventas> listaCondiciones = new ArrayList<ventas>();

        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_CONDICIONALES(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codCondicion(rs.getString("COD_CONDICIO"));
                ventas.setV_desCondicion(rs.getString("DES_CONDICIO"));
                ventas.setV_simbolo(rs.getString("SIMBOLO"));
                ventas.setV_estado(rs.getString("FLAG_ESTADO"));
                ventas.setV_usuario(rs.getString("U_CREACION"));
                ventas.setV_fechaCreacion(rs.getString("F_CREACION"));
                listaCondiciones.add(ventas);

            }
            listaCondicion.setListaCondicionVar(listaCondiciones);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listaCondicion;
    }

    /**
     * autor: Victor Rosales Arones fecha: 15/09/2022 description: ORACLE
     * listaValoresVar
     *
     * @return
     * @throws Exception
     *
     */
    @Override
    public ventas listaValoresVar() throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listaValoresVar)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listaValore = new ventas();
        ArrayList<ventas> listaValores = new ArrayList<ventas>();
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_PARAMCATVENDE(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codMatriz(rs.getString("COD_MATRIZ"));
                ventas.setV_desMatriz(rs.getString("DES_MATRIZ"));
                listaValores.add(ventas);

            }
            listaValore.setListaRefValor(listaValores);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listaValore;
    }

    /**
     * autor: Victor Rosales Arones fecha: 15/09/2022 description: ORACLE
     * registrarConfig
     *
     * @param cod_categoria
     * @param cod_Variable
     * @param cod_Condicion
     * @param camValor
     * @param paramValor
     * @param usuario
     * @return
     * @throws Exception
     *
     */
    @Override
    public String registrarConfig(int cod_categoria, int cod_Variable,
            int cod_Condicion, int camValor, int paramValor, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(registrarConfig)");
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_GUARDAR_CATEGCONFIG(?,?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, cod_categoria);
            cs.setInt(2, cod_Variable);
            cs.setInt(3, cod_Condicion);
            cs.setInt(4, camValor);
            cs.setInt(5, paramValor);
            cs.setString(6, usuario);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
            cs.registerOutParameter(8, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(7);
            String mensaje = (String) cs.getObject(8);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(7) + " Mensaje: " + (String) cs.getObject(8));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;

    }

    /**
     * autor: Victor Rosales Arones fecha: 03/09/2022 description: ORACLE
     * prioridadVariable
     *
     * @param cod_categoria
     * @param codVariableCat
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String prioridadVariable(int codVariableCat, int cod_categoria, String usuario) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(prioridadVariable)");
        ventas ventas = new ventas();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_ACT_CATEGCONFIGPRI(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, codVariableCat);
            cs.setInt(2, cod_categoria);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("**************************************************" + cod_categoria + "************************" + codVariableCat + "************" + usuario);
            System.out.println("**************************************************" + cod_categoria + "************************" + codVariableCat + "************" + usuario);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;

    }

    /**
     * autor: Victor Rosales Arones fecha: 16/09/2022 description: ORACLE
     * listaConfVariables
     *
     * @param cod_categoria
     * @return
     * @throws Exception
     */
    @Override
    public ventas listaConfVariables(int cod_categoria) throws Exception {
        System.out.println("ORACLEDAO SEGURIDAD(listaConfVariables)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;
        ventas listaConfVariable = new ventas();
        ArrayList<ventas> listaConfVariables = new ArrayList<ventas>();
        try {
            String sql = "{call PKG_COMERCIAL.USP_LISTAR_CONFIGVARIA(?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, cod_categoria);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                ventas ventas = new ventas();
                ventas.setV_codCategoria(rs.getString("COD_CATEGVEND"));
                ventas.setV_desCategoria(rs.getString("DES_CATEGVEND"));
                ventas.setV_codVariableCat(rs.getString("COD_CATEGVARIA"));
                ventas.setV_desVariableCat(rs.getString("DES_CATEGVARIA"));
                ventas.setV_catConf(rs.getString("COD_CATEGCONFIG"));
                ventas.setV_codCondicion(rs.getString("COD_CONDICION"));
                ventas.setV_desCondicion(rs.getString("DES_CONDICIO"));
                ventas.setV_simbolo(rs.getString("SIMBOLO"));
                ventas.setV_valorParm(rs.getString("VALOR_PARAM"));
                ventas.setV_refValor(rs.getString("REF_VALOR"));
                ventas.setV_desMatriz(rs.getString("DES_MATRIZ"));
                ventas.setV_prioridad(rs.getString("FLAG_PRIORI"));

                listaConfVariables.add(ventas);

            }
            listaConfVariable.setListaConfVariables(listaConfVariables);
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return listaConfVariable;

    }

    /**
     * autor: Victor Rosales Arones fecha: 16/09/2022 description: ORACLE
     * darBajaConfVariables
     *
     * @param cod_categoria
     * @param codVariableCat
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public String darBajaConfVariables(int cod_categoria, int codVariableCat, String usuario) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(darBajaConfVariables)");
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        String respuesta = "";
        try {
            String sql = "{call PKG_COMERCIAL.USP_BAJA_CATEGCONFIG(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, cod_categoria);
            cs.setInt(2, codVariableCat);
            cs.setString(3, usuario);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    /**
     * autor: yasub huaman ramos fecha: 03/09/2022 description: ORACLE dar baja
     * la unidad
     *
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
            String sql = "{call PKG_COMERCIAL.USP_DARBAJA_UNIDADES(?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(2);
            String mensaje = (String) cs.getObject(3);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(2) + " Mensaje: " + (String) cs.getObject(3));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    /**
     * autor: yasub huaman ramos fecha: 03/09/2022 description: ORACLE
     * actualizar unidad
     *
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
            cs.setInt(1, Integer.valueOf(codUnidad));
            cs.setString(2, desUnidad);
            cs.setString(3, desUnidad);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            String seguridad = (String) cs.getObject(4);
            String mensaje = (String) cs.getObject(5);
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(4) + " Mensaje: " + (String) cs.getObject(5));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>> " + e);
        } finally {
        }
        return respuesta;
    }

    /**
     * autor: yasub huaman ramos fecha: 03/09/2022 description: ORACLE guardar
     * unidad
     *
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
            respuesta = seguridad + "_" + mensaje;
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
        } finally {
        }
        return respuesta;
    }

    /**
     * autor: yasub huaman ramos fecha: 03/09/2022 description: ORACLE
     * listarUnidades
     *
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
            System.out.println("ORACLE > CodMensaje: " + (String) cs.getObject(3) + " Mensaje: " + (String) cs.getObject(4));
        } catch (Exception e) {
            System.out.println("EXCEPTION =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }
        return ventas;
    }

}
