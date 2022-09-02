/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.DAO;

import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.OracleDAO.OracleDAOFactory;

/**
 *
 * @author Bentu Condori
 */
public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    public static OracleDAOFactory getDAOFactory(int whichFactory){
       switch(whichFactory){
	      	case SQLSERVER:
	       	    return new OracleDAOFactory();
	       	/*case SQLSERVER:
	       	    return new SqlServerDAOFactory();
	       case ORACLE:
	       	    return new OracleDAOFactory();
	       	case DB2:
	       	    return new Db2DAOFactory();
	       	case SQLSERVER:
	       	    return new SqlServerDAOFactory();
	       	case XML:
	       	    return new XmlDAOFactory();*/
	       	default:
	       	    return null;
       }
    }
    //public abstract usuarioDAO getUsuarioDAO();
    public abstract ventasDAO getVentasDAO();
    public abstract reHumanosDAO getReHumanosDAO();
    public abstract mantenimientoDAO getMantenimientoDAO();

}
