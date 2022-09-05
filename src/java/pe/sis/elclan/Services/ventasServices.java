package pe.sis.elclan.Services;

import pe.sis.elclan.Clases.ventas;
import pe.sis.elclan.DAO.DAOFactory;
import pe.sis.elclan.DAO.ventasDAO;

/**
 *
 * @author sistemas03 Yasub Huaman
 */
public class ventasServices {
    
    /* Atributes */
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
    ventasDAO  objVentasDAO;

    /*  Constructor */
    public ventasServices() {
        this.objVentasDAO = fabrica.getVentasDAO();
    }
    
    /************************************ STAR OF SERVICES **********************************/
    
     /******************** EQUIPOS ******************/
         /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: dar baja equipo
     * @param codUnidad
     * @param codEquipo
     * @return 
     ****************************/
     public String darBajaEquipo(String codUnidad, String codEquipo){
        String darBaja = null;
        System.out.println("SERVICE ventasService(darBajaEquipo)");
        try {  
           darBaja = objVentasDAO.darBajaEquipo( codUnidad, codEquipo);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darBajaEquipo) : " + e.getMessage());
         }
        return darBaja;
    }
    
     /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: actualizar equipo
     * @param codUnidad
     * @param codEquipo
     * @param desEquipo
     * @return 
     ****************************/
     public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo){
        String actualizar = null;
        System.out.println("SERVICE ventasService(actualizarEquipo)");
        try {  
           actualizar = objVentasDAO.actualizarEquipo( codUnidad,  codEquipo, desEquipo);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarEquipo) : " + e.getMessage());
         }
        return actualizar;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: guardar equipo
     * @param desEquipo
     * @param codUnidad
     * @param usuario
     * @return 
     ****************************/
     public String guardarEquipo(String desEquipo, String codUnidad, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(guardarEquipo)");
        try {  
           registro = objVentasDAO.guardarEquipo( desEquipo, codUnidad,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(guardarEquipo) : " + e.getMessage());
         }
        return registro;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: listar equipos
     * @param codUnidad
     * @param codEquipo
     * @return 
     ****************************/
    public ventas listarEquipos(String codUnidad, String codEquipo){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEquipos)");
        try {
            lista = objVentasDAO.listarEquipos(codUnidad, codEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEquipos): "+e.getMessage());
        }
        return lista;
    }
    
    /******************** UNIDADES ******************/
     /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: dar baja unidad
     * @param codUnidad
     * @return 
     ****************************/
     public String darBajaUnidad(String codUnidad){
        String darBaja = null;
        System.out.println("SERVICE ventasService(darBajaUnidad)");
        try {  
           darBaja = objVentasDAO.darBajaUnidad( codUnidad);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darBajaUnidad) : " + e.getMessage());
         }
        return darBaja;
    }
    
     /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: actualizar unidad
     * @param codUnidad
     * @param desUnidad
     * @param usuario
     * @return 
     ****************************/
     public String actualizarUnidad(String codUnidad, String desUnidad, String usuario){
        String actualizar = null;
        System.out.println("SERVICE ventasService(actualizarUnidad)");
        try {  
           actualizar = objVentasDAO.actualizarUnidad( codUnidad,  desUnidad, usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarUnidad) : " + e.getMessage());
         }
        return actualizar;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: guardar unidad
     * @param desUnidad
     * @param usuario
     * @return 
     ****************************/
     public String guardarUnidad(String desUnidad, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(guardarUnidad)");
        try {  
           registro = objVentasDAO.guardarUnidad( desUnidad,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(guardarUnidad) : " + e.getMessage());
         }
        return registro;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: listar unidades
     * @param codUnidad
     * @return 
     ****************************/
    public ventas listarUnidades(String codUnidad){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarUnidades)");
        try {
            lista = objVentasDAO.listarUnidades(codUnidad);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarUnidades): "+e.getMessage());
        }
        return lista;
    }    
        
}
