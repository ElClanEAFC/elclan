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
    ventasDAO objVentasDAO;

    /*  Constructor */
    public ventasServices() {
        this.objVentasDAO = fabrica.getVentasDAO();
    }

    /**
     * ********************************** STAR OF SERVICES
     * *********************************
     */
    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 02-09-2022 descripcion: service:
     * listar vendedores
     *
     * @param codVendedor
     * @param codUnidad
     * @param codEquipo
     * @return
     * ****************************************************************************
     */
    public ventas listaVendedores(int codVendedor, int codUnidad, int codEquipo) {
        ventas lista = null;
        System.out.println("SERVICE ventasServices(listaVendedores)");
        try {
            lista = objVentasDAO.listaVendedores(codVendedor, codUnidad, codEquipo);

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasServices)>>>(listaVendedores) : " + e.getMessage());
        }
        return lista;
    }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 02-09-2022 descripcion: service:
     * listaUnidad
     *
     * @param codUnidad
     * @return
     * ****************************************************************************
     */
    public ventas listaUnidad(int codUnidad) {
        ventas lista = null;
        System.out.println("SERVICE ventasServices(listaUnidad)");
        try {
            lista = objVentasDAO.listaUnidad(codUnidad);

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasServices)>>>(listaUnidad) : " + e.getMessage());
        }
        return lista;
    }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 02-09-2022 descripcion: service:
     * listaEquipos
     *
     * @param codEquipo
     * @param codUnidad
     * @return
     * ****************************************************************************
     */
    public ventas listaEquipos(int codEquipo, int codUnidad) {
        ventas lista = null;
        System.out.println("SERVICE ventasServices(listaEquipos)");
        try {
            lista = objVentasDAO.listaEquipos(codEquipo, codUnidad);

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasServices)>>>(listaEquipos) : " + e.getMessage());
        }
        return lista;
    }

    /**
     * ****************** CATEGORIA *****************
     */
    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 06-09-2022 descripcion: service:
     * listaCategoria
     *
     * @param codCategoria
     * @return
     * ****************************************************************************
     */
    public ventas listaCategoria(int codCategoria) {
        ventas lista = null;
        System.out.println("SERVICE ventasServices(listaCategoria)");
        try {
            lista = objVentasDAO.listarCategoria(codCategoria);

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasServices)>>>(listaCategoria) : " + e.getMessage());
        }

        return lista;
    }

    /* **************************************************************************
     * autor: victor Rosales Arones fecha: 06-09-2022 descripcion: service: Registrar Categoria
     *
     * @param desCategoria
     * @param Usuario
     * @return
     * ****************************************************************************
     */
    public String registrarCategoria(String desCategoria, String Usuario) {
        System.out.println("SERVICE ventasServices(registrarCategoria)");
        String reCategoria = "";

        try {
            reCategoria = objVentasDAO.registroCategoria(desCategoria, Usuario);

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(registrarCategoria) : " + e.getMessage());
        }
        return reCategoria;

    }

    /* **************************************************************************
     * autor: victor Rosales Arones fecha: 06-09-2022 descripcion: service: Actualizar Categoria
     *
     * @param codCategoria
     * @param desCategoria
     * @param Usuario
     * @return
     * ****************************************************************************
     */
    public String actualizarCategoria(int codCategoria, String desCategoria, String usuario) {
        String actCategoria = "";
        try {
            actCategoria = objVentasDAO.ActualizarCategoria(codCategoria, desCategoria, usuario);

            System.out.println("SERVICE ventasServices(actualizarCategoria)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(actualizarCategoria) : " + e.getMessage());
        }
        return actCategoria;
    }

    /* **************************************************************************
     * autor: victor Rosales Arones fecha: 06-09-2022 descripcion: service: darBajaCategoria
     *
     * @param codCategoria
     * @param desCategoria
     * @param Usuario
     * @return
     * ****************************************************************************
     */
    public String darBajaCategoria(int codCategoria, String desCategoria, String usuario) {
        String darBajaCategoria = "";
        try {
            darBajaCategoria = objVentasDAO.darBajaCategoria(codCategoria, desCategoria, usuario);
            System.out.println("SERVICE ventasServices(darBajaCategoria)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(darBajaCategoria) : " + e.getMessage());
        }
        return darBajaCategoria;
    }

    /**
     * ****************** CONFIGURACION DE VARIABLES DE CATEGORIA DEL VENDEDOR
     * *****************
     *
     */
    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * darBajaCategoria
     *
     * @param desVariableCat
     * @param usuario
     * @return
     * ****************************************************************************
     */
    public String registroVariCategoria(String desVariableCat, String usuario) {
        String regiVariCategoria = "";
        try {
            regiVariCategoria = objVentasDAO.registroVariCategoria(desVariableCat, usuario);
            System.out.println("SERVICE ventasServices(registroVariCategoria)");

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(registroVariCategoria) : " + e.getMessage());
        }

        return regiVariCategoria;
    }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * darBajaCategoria
     *
     * @param codVariableCat
     * @return
     * ****************************************************************************
     */
    public ventas listaVariCategoria(int codVariableCat) {
        ventas lista = null;
        try {
            lista = objVentasDAO.listaVariCategoria(codVariableCat);
            System.out.println("SERVICE ventasServices(listaVariCategoria)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(listaVariCategoria) : " + e.getMessage());
        }

        return lista;
    }
    
    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * listaVariablesCat
     *
     * @param codVariableCat
     * @return
     * ****************************************************************************
     */
     public ventas listaVariablesCat(int codVariableCat){
         ventas lista = null;
         try {
            lista = objVentasDAO.listaVariablesCat(codVariableCat);
            System.out.println("SERVICE ventasServices(listaVariablesCat)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(listaVariablesCat) : " + e.getMessage());
        }

        return lista;
     
     }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * actualizarVariCategoria
     *
     * @param codVariableCat
     * @param desVariableCat
     * @param usuario
     * @return
     * ****************************************************************************
     */
    public String actualizarVariCategoria(int codVariableCat, String desVariableCat, String usuario) {
        String actVariCategoria = "";
        try {
            actVariCategoria = objVentasDAO.actualizarVariCategoria(codVariableCat, desVariableCat, usuario);
            System.out.println("SERVICE ventasServices(actualizarVariCategoria)");

        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(actualizarVariCategoria) : " + e.getMessage());
        }

        return actVariCategoria;
    }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * darBajaCategoria
     *
     * @param codVariableCat
     * @param usuario
     * @return
     * ****************************************************************************
     */
    public String darBajaVariCategoria(int codVariableCat, String usuario) {
        String darBajaVariable = "";
        try {
            darBajaVariable = objVentasDAO.darBajaVariCategoria(codVariableCat, usuario);
            System.out.println("SERVICE ventasServices(darBajaVariCategoria)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(darBajaVariCategoria) : " + e.getMessage());
        }

        return darBajaVariable;
    }
    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service:
     * listaCondicionVar
     *
     * @return
     * ****************************************************************************
     */
    public ventas listaCondicionVar(){
         ventas lista = null;
         try {
            lista = objVentasDAO.listaCondicionVar();
             
            System.out.println("SERVICE ventasServices(listaCondicionVar)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(listaCondicionVar) : " + e.getMessage());
        }

        return lista;
     
     }
    
     /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 15-09-2022 descripcion: service: listaValoresVar
     *
     * @return
     * ****************************************************************************
     */
     public ventas listaValoresVar(){
         ventas lista = null;
         try {
            lista = objVentasDAO.listaValoresVar();
             
            System.out.println("SERVICE ventasServices(listaValoresVar)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(listaValoresVar) : " + e.getMessage());
        }

        return lista;
     
     }
      /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 07-09-2022 descripcion: service: registrarConfig
     *
     * @param cod_categoria
     * @param cod_Variable
     * @param cod_Condicion
     * @param camValor
     * @param paramValor
     * @param usuario
     * @return
     * ****************************************************************************
     */
    public String registrarConfig(int cod_categoria,int cod_Variable,int cod_Condicion,int camValor, int paramValor,String usuario) {
        String regisConf = "";
        try {
            regisConf = objVentasDAO.registrarConfig(cod_categoria, cod_Variable, cod_Condicion, camValor, paramValor, usuario);
            System.out.println("SERVICE ventasServices(registrarConfig)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(registrarConfig) : " + e.getMessage());
        }

        return regisConf;
    }
     /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 15-09-2022 descripcion: service:
     * prioridadVariable
     *
     * @param cod_categoria
     * @param codVariableCat
     * @param usuario
     * @return
     * ****************************************************************************
     */
    public String prioridadVariable(int codVariableCat,int cod_categoria, String usuario) {
        String resultado = "";
        try {
            resultado = objVentasDAO.prioridadVariable(codVariableCat,cod_categoria,  usuario);
            System.out.println("SERVICE ventasServices(prioridadVariable)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(prioridadVariable) : " + e.getMessage());
        }

        return resultado;
    }

    /**
     * **************************************************************************
     * autor: victor Rosales Arones fecha: 15-09-2022 descripcion: service: listaValoresVar
     *
     * @param cod_categoria
     * @return
     * ****************************************************************************
     */
     public ventas listaConfVariables(int cod_categoria){
         ventas lista = null;
         try {
            lista = objVentasDAO.listaConfVariables(cod_categoria);
             
            System.out.println("SERVICE ventasServices(listaConfVariables)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(listaConfVariables) : " + e.getMessage());
        }

        return lista;
     
     }
     /* **************************************************************************
     * autor: victor Rosales Arones fecha: 06-09-2022 descripcion: service: darBajaCategoria
     *
     * @param codCategoria
     * @param desCategoria
     * @param Usuario
     * @return
     * ****************************************************************************
     */
    public String darBajaConfVariables(int codCategoria, int codVariable, String usuario) {
        String darBajaConfVariables = "";
        try {
            darBajaConfVariables = objVentasDAO.darBajaConfVariables(codCategoria, codVariable, usuario);
            System.out.println("SERVICE ventasServices(darBajaConfVariables)");
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventas)>>>(darBajaConfVariables) : " + e.getMessage());
        }
        return darBajaConfVariables;
    }
    
    

    /**
     * ****************** EQUIPOS *****************
     */
    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: dar baja equipo
     *
     * @param codUnidad
     * @param codEquipo
     * @return **************************
     */
    public String darBajaEquipo(String codUnidad, String codEquipo) {
        String darBaja = null;
        System.out.println("SERVICE ventasService(darBajaEquipo)");
        try {
            darBaja = objVentasDAO.darBajaEquipo(codUnidad, codEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darBajaEquipo) : " + e.getMessage());
        }
        return darBaja;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: actualizar
     * equipo
     *
     * @param codUnidad
     * @param codEquipo
     * @param desEquipo
     * @return **************************
     */
    public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo) {
        String actualizar = null;
        System.out.println("SERVICE ventasService(actualizarEquipo)");
        try {
            actualizar = objVentasDAO.actualizarEquipo(codUnidad, codEquipo, desEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarEquipo) : " + e.getMessage());
        }
        return actualizar;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: guardar equipo
     *
     * @param desEquipo
     * @param codUnidad
     * @param usuario
     * @return **************************
     */
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) {
        String registro = null;
        System.out.println("SERVICE ventasService(guardarEquipo)");
        try {
            registro = objVentasDAO.guardarEquipo(desEquipo, codUnidad, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(guardarEquipo) : " + e.getMessage());
        }
        return registro;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: listar equipos
     *
     * @param codUnidad
     * @param codEquipo
     * @return **************************
     */
    public ventas listarEquipos(String codUnidad, String codEquipo) {
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarEquipos)");
        try {
            lista = objVentasDAO.listarEquipos(codUnidad, codEquipo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarEquipos): " + e.getMessage());
        }
        return lista;
    }

    /**
     * ****************** UNIDADES *****************
     */
    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: dar baja unidad
     *
     * @param codUnidad
     * @return **************************
     */
    public String darBajaUnidad(String codUnidad) {
        String darBaja = null;
        System.out.println("SERVICE ventasService(darBajaUnidad)");
        try {
            darBaja = objVentasDAO.darBajaUnidad(codUnidad);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(darBajaUnidad) : " + e.getMessage());
        }
        return darBaja;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: actualizar
     * unidad
     *
     * @param codUnidad
     * @param desUnidad
     * @param usuario
     * @return **************************
     */
    public String actualizarUnidad(String codUnidad, String desUnidad, String usuario) {
        String actualizar = null;
        System.out.println("SERVICE ventasService(actualizarUnidad)");
        try {
            actualizar = objVentasDAO.actualizarUnidad(codUnidad, desUnidad, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(actualizarUnidad) : " + e.getMessage());
        }
        return actualizar;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: guardar unidad
     *
     * @param desUnidad
     * @param usuario
     * @return **************************
     */
    public String guardarUnidad(String desUnidad, String usuario) {
        String registro = null;
        System.out.println("SERVICE ventasService(guardarUnidad)");
        try {
            registro = objVentasDAO.guardarUnidad(desUnidad, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(guardarUnidad) : " + e.getMessage());
        }
        return registro;
    }

    /**
     * **************************
     * autor: yasub huaman ramos fecha: 05/09/2022 description: listar unidades
     *
     * @param codUnidad
     * @return **************************
     */
    public ventas listarUnidades(String codUnidad) {
        ventas lista = null;
        System.out.println("SERVICE ventas Service(listarUnidades)");
        try {
            lista = objVentasDAO.listarUnidades(codUnidad);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(ventasService)>>>(listarUnidades): " + e.getMessage());
        }
        return lista;
    }
    


}
