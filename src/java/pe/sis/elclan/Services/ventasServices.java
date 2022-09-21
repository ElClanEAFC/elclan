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
    
    /*************** ORGANIGRAMA UNIDADES ****************/
    
         /****************************
     * autor: yasub huaman ramos
     * fecha: 20/09/2022
     * description: dar de baja cargo de Estructura Unidad
     * @param codEstructura
     * @param usuario
     * @return 
     ****************************/
     public String darbajaEstructuraUnidad(String codEstructura, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(darbajaEstructuraUnidad)");
        try {  
           registro = objVentasDAO.darbajaEstructuraUnidad( codEstructura,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darbajaEstructuraUnidad) : " + e.getMessage());
         }
        return registro;
    }
           
    /****************************
     * autor: yasub huaman ramos
     * fecha: 20/09/2022
     * description: actualizar Estructura Unidad
     * @param codEstructura
     * @param codPerfil
     * @param numOrden
     * @param usuario
     * @return 
     ****************************/
     public String actualizarEstructuraUnidad(String codEstructura, String codPerfil, String numOrden, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(actualizarEstructuraUnidad)");
        try {  
           registro = objVentasDAO.actualizarEstructuraUnidad( codEstructura, codPerfil, numOrden,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarEstructuraUnidad) : " + e.getMessage());
         }
        return registro;
    }
    
       /****************************
     * autor: yasub huaman ramos
     * fecha: 20/09/2022
     * description: listar datos de una estructura de Unidad
     * @param codEstructura
     * @return 
     ****************************/
    public ventas listarEstructuraUnidadDatos(String codEstructura){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEstructuraUnidadDatos)");
        try {
            lista = objVentasDAO.listarEstructuraUnidadDatos(codEstructura);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEstructuraUnidadDatos): "+e.getMessage());
        }
        return lista;
    }
    
       /****************************
     * autor: yasub huaman ramos
     * fecha: 20/09/2022
     * description: listar estructura de Unidad
     * @param codUnidad
     * @return 
     ****************************/
    public ventas listarEstructuraUnidades(String codUnidad){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEstructuraUnidades)");
        try {
            lista = objVentasDAO.listarEstructuraUnidades(codUnidad);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEstructuraUnidades): "+e.getMessage());
        }
        return lista;
    }
        /****************************
     * autor: yasub huaman ramos
     * fecha: 20/09/2022
     * description: registrar Estructura Unidad
     * @param codUnidad
     * @param codPerfil
     * @param numOrden
     * @param usuario
     * @return 
     ****************************/
     public String registrarEstructuraUnidad(String codUnidad, String codPerfil, String numOrden, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(registrarEstructuraUnidad)");
        try {  
           registro = objVentasDAO.registrarEstructuraUnidad( codUnidad, codPerfil, numOrden,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(registrarEstructuraUnidad) : " + e.getMessage());
         }
        return registro;
    } 
    
     
    /************************** ORGANIGRMA *****************************/
        /****************************
     * autor: yasub huaman ramos
     * fecha: 17/09/2022
     * description: listar Diagrama de Ventas
     * @return 
     ****************************/
    public ventas listarDiagramaVentas(){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarDiagramaVentas)");
        try {
            lista = objVentasDAO.listarDiagramaVentas();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarDiagramaVentas): "+e.getMessage());
        }
        return lista;
    }
    /********************************* FIN ORGANIGRAMA ******************************/
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 15/09/2022
     * description: Guardar Cargo Asignado al vendedor
     * @param codVendedor
     * @param codEstructura
     * @param fecInicio
     * @param usuario
     * @return 
     ****************************/
     public String guardarVendEstruc(String codVendedor, String codEstructura, String fecInicio, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(guardarVendEstruc)");
        try {  
           registro = objVentasDAO.guardarVendEstruc( codVendedor, codEstructura, fecInicio,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(guardarVendEstruc) : " + e.getMessage());
         }
        return registro;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 15/09/2022
     * description: listar vendedores sin cargo
     * @param codPerfil
     * @param codUnidad
     * @param codEquipo
     * @return 
     ****************************/
    public ventas listarVendSinCargo(String codPerfil, String codUnidad, String codEquipo){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarVendSinCargo)");
        try {
            lista = objVentasDAO.listarVendSinCargo(codPerfil, codUnidad,codEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarVendSinCargo): "+e.getMessage());
        }
        return lista;
    }
    
     /****************************
     * autor: yasub huaman ramos
     * fecha: 14/09/2022
     * description: dar de baja cargo de Estructura Equipo
     * @param codEstructura
     * @param usuario
     * @return 
     ****************************/
     public String darbajaEstructuraEquipo(String codEstructura, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(darbajaEstructuraEquipo)");
        try {  
           registro = objVentasDAO.darbajaEstructuraEquipo( codEstructura,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darbajaEstructuraEquipo) : " + e.getMessage());
         }
        return registro;
    }
    
        /****************************
     * autor: yasub huaman ramos
     * fecha: 14/09/2022
     * description: actualizar Estructura Equipo
     * @param codEstructura
     * @param codPerfil
     * @param numOrden
     * @param usuario
     * @return 
     ****************************/
     public String actualizarEstructuraEquipo(String codEstructura, String codPerfil, String numOrden, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(actualizarEstructuraEquipo)");
        try {  
           registro = objVentasDAO.actualizarEstructuraEquipo( codEstructura, codPerfil, numOrden,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarEstructuraEquipo) : " + e.getMessage());
         }
        return registro;
    }
     
                /****************************
     * autor: yasub huaman ramos
     * fecha: 14/09/2022
     * description: listar datos de una estructura de Equipo
     * @param codEstructura
     * @return 
     ****************************/
    public ventas listarEstructuraEquipoDatos(String codEstructura){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEstructuraEquipoDatos)");
        try {
            lista = objVentasDAO.listarEstructuraEquipoDatos(codEstructura);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEstructuraEquipoDatos): "+e.getMessage());
        }
        return lista;
    }
    
            /****************************
     * autor: yasub huaman ramos
     * fecha: 13/09/2022
     * description: listar estructura de Equipos
     * @param codEquipo
     * @return 
     ****************************/
    public ventas listarEstructuraEquipos(String codEquipo){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEstructuraEquipos)");
        try {
            lista = objVentasDAO.listarEstructuraEquipos(codEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEstructuraEquipos): "+e.getMessage());
        }
        return lista;
    }
    
    /****************************
     * autor: yasub huaman ramos
     * fecha: 05/09/2022
     * description: registrar Estructura Equipo
     * @param codEquipo
     * @param codPerfil
     * @param numOrden
     * @param usuario
     * @return 
     ****************************/
     public String registrarEstructuraEquipo(String codEquipo, String codPerfil, String numOrden, String usuario){
        String registro = null;
        System.out.println("SERVICE ventasService(registrarEstructuraEquipo)");
        try {  
           registro = objVentasDAO.registrarEstructuraEquipo( codEquipo, codPerfil, numOrden,  usuario);           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(registrarEstructuraEquipo) : " + e.getMessage());
         }
        return registro;
    }
        /****************************
     * autor: yasub huaman ramos
     * fecha: 13/09/2022
     * description: listar perfiles de  area comercial
     * @return 
     ****************************/
    public ventas listarPerfilesComer(){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarPerfilesComer)");
        try {
            lista = objVentasDAO.listarPerfilesComer();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarPerfilesComer): "+e.getMessage());
        }
        return lista;
    }
    
    
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
    public ventas listarEquipos(String codEquipo, String codUnidad){
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEquipos)");
        try {
            lista = objVentasDAO.listarEquipos(codEquipo, codUnidad);
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
