/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.OracleDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.DAO.mantenimientoDAO;
//import pe.sis.javaWeb.DAO.usuarioDAO;
import pe.sis.elclan.OracleDAO.OracleDAOFactory;
import pe.sis.elclan.DAO.reHumanosDAO;


/**
 *
 * @author bentu condori
 */
public class mantenimientoOracleDAO implements mantenimientoDAO {

    @Resource(name = "jdbc/SQLServerDriver")
    private DataSource fuente;

    @Override
    public mantenimiento listarMenu(String codUser) throws Exception {
        String base = "elclan";
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        mantenimiento menu = null;
        mantenimiento menu1 = new mantenimiento();
        ArrayList<mantenimiento> lista = new ArrayList<mantenimiento>();
        System.out.println("LLEGO A  ORACLE DAO -> listar menu");
        System.out.println("codUsuario :" + codUser);
        try {
            String sql = "{call pkg_mantenimiento.USP_LISTAR_MODULO(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUser));
            cs.setInt(2, 0);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            System.out.println("(1) ERROR ORACLE-SQL :" + cs.getObject(4));
            System.out.println("(2) ERROR ORACLE-SQL :" + cs.getObject(5));
            rs = (ResultSet) cs.getObject(3);///.....................................APUNTA AL CURSOR
            while (rs.next()) {
                menu = new mantenimiento();
                menu.setCodModulo(rs.getString("cod_modulo"));
                menu.setLinkModulo(rs.getString("link"));
                menu.setDesModulo(rs.getString("des_modulo"));
                menu.setModNemo(rs.getString("mod_nemo"));
                menu.setIcoModulo(rs.getString("icono"));
                menu.setCanSubModulo(rs.getString("canSu"));
                lista.add(menu);
            }
            menu1.setListaModulos(lista);
            menu1.setCodMensaje(cs.getString(4));
            menu1.setMensaje(cs.getString(5));
            

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
        return menu1;
    }

    @Override
    public ArrayList<mantenimiento> listarSubMenu(String codUser, String codModulo) throws Exception {
        System.out.println("SQLDAO SEGURIDAD(listarSubMenu)");
        ArrayList<mantenimiento> listaMenu = new ArrayList<mantenimiento>();
        Connection cn = null;
        
        String base = "elclan";
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = "{call pkg_mantenimiento.USP_LISTARSUBMENU(?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
//            cn = fuente.getConnection();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codModulo));
            cs.setInt(2, Integer.valueOf(codUser));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            System.out.println("(1) ERROR ORACLE-SQL :" + cs.getObject(4));
            System.out.println("(2) ERROR ORACLE-SQL :" + cs.getObject(5));
            rs = (ResultSet) cs.getObject(3);
            while(rs.next()){
                mantenimiento seg = new mantenimiento();
                System.out.println("ora: des_sub: "+rs.getString("des_submodulo"));
                seg.setDesSubModulo(rs.getString("des_submodulo"));
                seg.setLinkSubModulo(rs.getString("SUB_LINK"));
                seg.setCodSubModulo(rs.getString("cod_submodulo"));
                seg.setIcoSubModulo(rs.getString("sub_icono"));
                listaMenu.add(seg);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            cn.close();
        }
        return listaMenu;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 17-03-2022
    descripcion: SQL: funcionn para listar menu interno segun usuario
    ******************************************************************************/
    

       
}
