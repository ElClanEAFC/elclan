/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.Services;

import java.util.ArrayList;
import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.DAO.DAOFactory;
import pe.sis.elclan.DAO.mantenimientoDAO;
import pe.sis.elclan.DAO.reHumanosDAO;

/**
 *
 * @author Bentu condori
 */
public class mantenimientoServices {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
    mantenimientoDAO objMantenimientoDAO = fabrica.getMantenimientoDAO();
    
    /****************************************************************************
    autor:  bentu condori
    fecha: 17-03-2022
    descripcion: service: Listar menu principal
    ******************************************************************************/
    public mantenimiento listarMenu(String usuario) {
        mantenimiento seguridad = null;
        System.out.println("SERVICE mantenimientoService(listarMenu)");
        try {  
           seguridad = objMantenimientoDAO.listarMenu(usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(mantenimientoService)>>>(listarMenu) : " + e.getMessage());
        }
        return seguridad;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 17-03-2022
    descripcion: service: listado de submenus
    ******************************************************************************/
    public ArrayList<mantenimiento> listarSubMenu(String codUser,String codModulo) {
        ArrayList<mantenimiento> lista = null;
        System.out.println("SERVICE mantenimientoService(listarSubMenu)");
        try {  
           lista = objMantenimientoDAO.listarSubMenu(codUser,codModulo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(mantenimientoService)>>>(listarSubMenu) : " + e.getMessage());
        }
        return lista;
    }
       
    

}
