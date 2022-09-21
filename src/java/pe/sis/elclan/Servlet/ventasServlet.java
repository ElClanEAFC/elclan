/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.elclan.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.sis.elclan.Clases.ventas;
import pe.sis.elclan.Services.ventasServices;

/**
 *
 * @author sistemas03
 */
public class ventasServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("Accion");
        System.out.println("SERVLET Ventas(Accion): " + param);
        if ("listarUnidades".equals(param) ){
            listarUnidades(request, response);
        }else if( "guardarUnidad".equals(param) ){
            guardarUnidad(request, response);
        }else if( "actualizarUnidad".equals(param) ){
            actualizarUnidad(request, response);
        }else if( "darBajaUnidad".equals(param) ){
            darBajaUnidad(request, response);
        }else if( "listarEquipos".equals(param) ){
            listarEquipos(request, response);
        }else if( "guardarEquipo".equals(param) ){
            guardarEquipo(request, response);
        }else if( "actualizarEquipo".equals(param) ){
            actualizarEquipo(request, response);
        }else if( "darBajaEquipo".equals(param) ){
            darBajaEquipo(request, response);
        }else if( "listarPerfilesComer".equals(param) ){
            listarPerfilesComer(request, response);
        }else if( "registrarEstructuraEquipo".equals(param) ){
            registrarEstructuraEquipo(request, response);
        }else if( "listarEstructuraEquipos".equals(param) ){
            listarEstructuraEquipos(request, response);
        }else if( "listarEstructuraEquipoDatos".equals(param) ){
            listarEstructuraEquipoDatos(request, response);
        }else if( "actualizarEstructuraEquipo".equals(param) ){
            actualizarEstructuraEquipo(request, response);
        }else if( "darbajaEstructuraEquipo".equals(param) ){
            darbajaEstructuraEquipo(request, response);
        }else if( "listarVendSinCargo".equals(param) ){
            listarVendSinCargo(request, response);
        }else if( "guardarVendEstruc".equals(param) ){
            guardarVendEstruc(request, response);
        }else if( "listarDiagramaVentas".equals(param) ){
            listarDiagramaVentas(request, response);
        }else if( "registrarEstructuraUnidad".equals(param) ){
            registrarEstructuraUnidad(request, response);
        }else if( "listarEstructuraUnidades".equals(param) ){
            listarEstructuraUnidades(request, response);
        }else if( "listarEstructuraUnidadDatos".equals(param) ){
            listarEstructuraUnidadDatos(request, response);
        }else if( "actualizarEstructuraUnidad".equals(param) ){
            actualizarEstructuraUnidad(request, response);
        }else if( "darbajaEstructuraUnidad".equals(param) ){
            darbajaEstructuraUnidad(request, response);
        }else if ("listarUnidades".equals(param)) {
            listarUnidad(request, response);
        } else if ("listaVendedores".equals(param)) {
            listaVendedores(request, response);
        } else if ("listaEquipos".equals(param)) {
            listaEquipos(request, response);
        } else if ("listaBuscador".equals(param)) {
            listaBuscador(request, response);
        } else if ("BuscarVendedor".equals(param)) {
            BuscadorVendedor(request, response);
        } else if ("listaCategoria".equals(param)) {
            listaCategoria(request, response);
        } else if ("buscarCategoria".equals(param)) {
            listaBuscadorCategoria(request, response);
        } else if ("FiltrarCategoria".equals(param)) {
            Filtrarcategoria(request, response);
        } else if ("registrarCategoria".equals(param)) {
            registrarCategoria(request, response);
        } else if ("actualizarCategoria".equals(param)) {
            actualizarCategoria(request, response);
        } else if ("darBajaCategoria5".equals(param)) {
            darBajaCategoria(request, response);
        } else if ("registroVariCategoria".equals(param)) {
            registroVariCategoria(request, response);
        } else if ("listaVariCategorias".equals(param)) {
            listaVariCategorias(request, response);
        } else if ("actualizarVariable".equals(param)) {
            actualizarVariCategoria(request, response);
        } else if ("darBajaVariCategoria".equals(param)) {
            darBajaVariCategoria(request, response);
        } else if ("estructuraCatgoriaVariables".equals(param)) {
            estructuraCatgoriaVariables(request, response);
        } else if ("listaCondicionVar".equals(param)) {
            listaCondicionVar(request, response);
        } else if ("listaValoresVar".equals(param)) {
            listaValoresVar(request, response);
        } else if ("registrarConfig".equals(param)) {
            registrarConfig(request, response);
        } else if ("prioridadVariable".equals(param)) {
            prioridadVariable(request, response);
        }else if("darBajaConfVariables".equals(param)){
            darBajaConfVariables(request, response);
        }
        
    }
    
    /********************** DIAGRAMA DE UNIDADES ********************/
    
         /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 20-09-2022
     * @Descripcion : dar de baja cargo de Estructura Unidad
     * @param request
     * @param response
    ***************************************************************************/
    public void darbajaEstructuraUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codEstructura = request.getParameter("codEstructura");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(darbajaEstructuraUnidad): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.darbajaEstructuraUnidad(codEstructura, usuario);
        pw.print(seguridad);
    }
    
       /*****
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 20-09-2022
     * @Descripcion : actualizar Estructura Unidad
     * @param request
     * @param response
    ***************************************************************************/
    public void actualizarEstructuraUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codEstructura = request.getParameter("codEstructura");
        String codPerfil = request.getParameter("codPerfil");
        String numOrden = request.getParameter("numOrden");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(actualizarEstructuraUnidad): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.actualizarEstructuraUnidad(codEstructura, codPerfil, numOrden, usuario);
        pw.print(seguridad);
    }
    
            /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 20-09-2022
     * @Descripcion : listar datos de una estructura de una Unidad
     * @param request
     * @param response
    ***************************************************************************/
    public void listarEstructuraUnidadDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarEstructuraUnidadDatos): ");
        String codEstructura = request.getParameter("codEstructura");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarEstructuraUnidadDatos(codEstructura);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListEstrucutraUnidadDatos());
        response.getWriter().write(json);
    }
    
        /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 20-09-2022
     * @Descripcion : listar estructura de Unidad
     * @param request
     * @param response
    ***************************************************************************/
    public void listarEstructuraUnidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarEstructuraUnidades): ");
        String codUnidad = request.getParameter("codUnidad");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarEstructuraUnidades(codUnidad);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListEstrucutraUnidades());
        response.getWriter().write(json);
    }
    
         /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 20-09-2022
     * @Descripcion : registrar Estructura Unidad
     * @param request
     * @param response
    ***************************************************************************/
    public void registrarEstructuraUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUnidad = request.getParameter("codUnidad");
        String codPerfil = request.getParameter("codPerfil");
        String numOrden = request.getParameter("numOrden");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(registrarEstructuraUnidad): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.registrarEstructuraUnidad(codUnidad, codPerfil, numOrden, usuario);
        pw.print(seguridad);
    }
    /********************** FIN DIAGRAMA DE UNIDADES****************/
    
        /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 17-09-2022
     * @Descripcion : listar Diagrama de Ventas
     * @param request
     * @param response
    ***************************************************************************/
    public void listarDiagramaVentas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarDiagramaVentas): ");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarDiagramaVentas( );   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        // LISTA DE DIAGRAMA DE VENTAS EN JSON
        String json = mapper.writeValueAsString(lista.getListDiagramaVentas());
        response.getWriter().write(json);
    }
    
     /**************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 15-09-2022
     * @Descripcion : Guardar Cargo Asignado al vendedor
     * @param request
     * @param response
    ***************************************************************************/
    public void guardarVendEstruc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codVendedor = request.getParameter("codVendedor");
        String codEstructura = request.getParameter("codEstructura");
        String fecInicio = request.getParameter("fecInicio");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(guardarVendEstruc): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.guardarVendEstruc(codVendedor,codEstructura, fecInicio, usuario);
        pw.print(seguridad);
    }
    
            /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 15-09-2022
     * @Descripcion : listar vendedores sin cargo
     * @param request
     * @param response
    ***************************************************************************/
    public void listarVendSinCargo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarVendSinCargo): ");
        String codPerfil = request.getParameter("codPerfil");
        String codUnidad = request.getParameter("codUnidad");
        String codEquipo = request.getParameter("codEquipo");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarVendSinCargo(codPerfil, codUnidad, codEquipo );   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
    
            /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 14-09-2022
     * @Descripcion : dar de baja cargo de Estructura Equipo
     * @param request
     * @param response
    ***************************************************************************/
    public void darbajaEstructuraEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codEstructura = request.getParameter("codEstructura");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(darbajaEstructuraEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.darbajaEstructuraEquipo(codEstructura, usuario);
        pw.print(seguridad);
    }
    
           /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 14-09-2022
     * @Descripcion : actualizar Estructura Equipo
     * @param request
     * @param response
    ***************************************************************************/
    public void actualizarEstructuraEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codEstructura = request.getParameter("codEstructura");
        String codPerfil = request.getParameter("codPerfil");
        String numOrden = request.getParameter("numOrden");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(actualizarEstructuraEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.actualizarEstructuraEquipo(codEstructura, codPerfil, numOrden, usuario);
        pw.print(seguridad);
    }
    
        /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 14-09-2022
     * @Descripcion : listar datos de una estructura de Equipo
     * @param request
     * @param response
    ***************************************************************************/
    public void listarEstructuraEquipoDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarEstructuraEquipoDatos): ");
        String codEstructura = request.getParameter("codEstructura");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarEstructuraEquipoDatos(codEstructura);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
    
    /***************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 13-09-2022
     * @Descripcion : listar estructura de Equipos
     * @param request
     * @param response
    ***************************************************************************/
    public void listarEstructuraEquipos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarEstructuraEquipos): ");
        String codEquipo = request.getParameter("codEquipo");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarEstructuraEquipos(codEquipo);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
            /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 13-09-2022
     * @Descripcion : registrar Estructura Equipo
     * @param request
     * @param response
    ***************************************************************************/
    public void registrarEstructuraEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codEquipo = request.getParameter("codEquipo");
        String codPerfil = request.getParameter("codPerfil");
        String numOrden = request.getParameter("numOrden");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(registrarEstructuraEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.registrarEstructuraEquipo(codEquipo, codPerfil, numOrden, usuario);
        pw.print(seguridad);
    }
    
        /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 13-09-2022
     * @Descripcion : listar perfiles de  area comercial
     * @param request
     * @param response
    ***************************************************************************/
    public void listarPerfilesComer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarPerfilesComer): ");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarPerfilesComer();   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }

    /**
     * *************************************************************************
     *
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : Lista Vendedores
     * @param req
     * @param resp
     * **************************************************************************
     */
    public void listaVendedores(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("SERVLET ventas(listaVendedores): ");
        String codVendedor = req.getParameter("codVendedor");

        System.out.println("PARAM (codVendedor): " + codVendedor);
        ventasServices ventasServices = new ventasServices();

        ventas lista = ventasServices.listaVendedores(0, 0, 0);

        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaVendedores());
        resp.getWriter().write(json);
    }

    /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : DAR BAJA EQUIPO
     * @param request
     * @param response
    ***************************************************************************/
    public void darBajaEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codUnidad = request.getParameter("codUnidad");
        String codEquipo = request.getParameter("codEquipo");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(darBajaEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.darBajaEquipo(codUnidad, codEquipo);
        pw.print(seguridad);    
    }
    
        /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : ACTUALIZAR EQUIPO
     * @param request
     * @param response
    ***************************************************************************/
    public void actualizarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codUnidad = request.getParameter("codUnidad");
        String codEquipo = request.getParameter("codEquipo");
        String desEquipo = request.getParameter("desEquipo");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(actualizarEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.actualizarEquipo(codUnidad, codEquipo, desEquipo);
        pw.print(seguridad);
    }
    
         /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : GUARDAR EQUIPO
     * @param request
     * @param response
    ***************************************************************************/
    public void guardarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String desEquipo = request.getParameter("desEquipo");
        String codUnidad = request.getParameter("codUnidad");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(guardarEquipo): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.guardarEquipo(desEquipo, codUnidad, usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : listar unidades
     * @param request
     * @param response
    ***************************************************************************/
    public void listarEquipos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarEquipos): ");
        String codEquipo = request.getParameter("codEquipo");
        String codUnidad = request.getParameter("codUnidad");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarEquipos(codEquipo,codUnidad);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
    
    /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : DAR BAJA UNIDAD
     * @param request
     * @param response
    ***************************************************************************/
    public void darBajaUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String codUnidad = request.getParameter("codUnidad");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(darBajaUsuario): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.darBajaUnidad(codUnidad);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : ACTUALIZAR UNIDAD
    ***************************************************************************/
    public void actualizarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUnidad = request.getParameter("codUnidad");
        String desUnidad = request.getParameter("desUnidad");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(actualizarUnidad): ");
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.actualizarUnidad(codUnidad, desUnidad, usuario);
        pw.print(seguridad);
    }
    
     /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : GUARDAR UNIDAD
     * @param request
     * @param response
    ***************************************************************************/
    public void guardarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String desUnidad = request.getParameter("desUnidad");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET ventas(guardarUnidad): ");
        System.out.println("USUARIO =>>>>> "+ usuario);
        ventasServices ventasServices = new ventasServices();
        String seguridad = ventasServices.guardarUnidad(desUnidad, usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 05-09-2022
     * @Descripcion : listar unidades
     * @param request
     * @param response
    ***************************************************************************/
    public void listarUnidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET ventas(listarUnidades): ");
        String codUnidad = request.getParameter("codUnidad");
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listarUnidades(codUnidad);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
        
    
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : listar unidades
     * @param request
     * @param response
     * *************************************************************************
     */
    public void listarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("SERVLET ventas(listarUnidad): ");
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaUnidad(0);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        wp.print("<option value='0' >  SELECCIONE UNIDAD   </option>");
        for (ventas de : lista.getListarUnidad()) {
            wp.print("<option value=\"" + de.getV_codUnidad() + "\"> " + de.getV_desUnidad() + "</option>");
        }

    }

    /**
     * *************************************************************************
     *
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : Lista Equipos
     * @param request
     * @param response
     * **************************************************************************
     */
    public void listaEquipos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("SERVLET ventas(listaEquipos): ");
        int unidad =Integer.parseInt(request.getParameter("selectUnidad"));

        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaEquipos(0, unidad);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        wp.print("<option value='0' >  SELECCIONE EQUIPO   </option>");
        for (ventas de : lista.getListarEquipos()) {
            wp.print("<option value=\"" + de.getV_codEquipo() + "\"> " + de.getV_desEquipo() + "</option>");
        }

    }

    /**
     * *************************************************************************
     *
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : Lista Buscador
     * @param request
     * @param response
     * **************************************************************************
     */
    public void listaBuscador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        System.out.println("SERVLET ventas(listaBuscador): ");

        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaVendedores(0, 0, 0);

        PrintWriter wp = response.getWriter();
        wp.print("<option value='0' class='text-center'>  INGRESE DNI O NOMBRES  </option>");
        for (ventas de : lista.getListaVendedores()) {
            wp.print("<option  value=\"" + de.getV_cod_Vendedor() + "\"> " + de.getV_numDocumento() + " " + de.getV_apellidoPaterno() + " " + de.getV_apellidoMaterno() + " " + de.getV_nombres() + "</option>");
        }

    }

    /**
     * *************************************************************************
     *
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : Buscador Vendedor
     * @param req
     * @param resp
     * **************************************************************************
     */
    public void BuscadorVendedor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("SERVLET ventas(BuscadorVendedor): ");
        int codVendedor = Integer.parseInt(req.getParameter("BuscadorDNI-NOMBRE"));
        int codUnidad = Integer.parseInt(req.getParameter("codUnidad"));
        int codEquipo = Integer.parseInt(req.getParameter("codEquipo"));

        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaVendedores(codVendedor, codUnidad, codEquipo);

        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaVendedores());
        resp.getWriter().write(json);
    }

    /**
     * *************************************************************************
     *
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Victor Rosales Arones
     * @fecha creacion: 06-09-2022
     * @Descripcion : Lista Categoria
     * @param request
     * @param response
     * **************************************************************************
     */
    public void listaCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("SERVLET ventas(listaCategoria): ");
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaCategoria(0);

        //Respuesta type JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListarCategoria());
        response.getWriter().write(json);
    }

    public void listaBuscadorCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        System.out.println("SERVLET ventas(listaBuscadorCategoria): ");

        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaCategoria(0);

        PrintWriter wp = response.getWriter();
        wp.print("<option value='0'>--INGRESE NOMBRE DE CATEGORIA--</option>");
        for (ventas de : lista.getListarCategoria()) {
            wp.print("<option value=\"" + de.getV_codCategoria() + "\"> " + de.getV_desCategoria() + "</option>");
        }

    }

    public void Filtrarcategoria(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("SERVLET ventas(Filtrarcategoria): ");
        int codCategoria = Integer.parseInt(req.getParameter("BuscadorCategoria"));
        
        
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaCategoria(codCategoria);
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListarCategoria());
        resp.getWriter().write(json);
    }

    public void registrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session_actual = request.getSession(true);
        String usuario = (String) session_actual.getAttribute("usuario");
        
        String desCategoria = request.getParameter("desCategoria");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(registrarCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String registrar = ventasServices.registrarCategoria(desCategoria, usuario);
        pw.print(registrar);

    }

    public void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codCategoria = request.getParameter("codCategoria");
        String desCategoria = request.getParameter("desCategoria");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(actualizarCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String actualizar = ventasServices.actualizarCategoria(Integer.parseInt(codCategoria), desCategoria, usuario);
        pw.print(actualizar);

    }

    public void darBajaCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        
        String codCategoria = request.getParameter("codCategoria");
        String desCategoria = request.getParameter("desCategoria");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(darBajaCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String darBajaCategoria = ventasServices.darBajaCategoria(Integer.parseInt(codCategoria), desCategoria, usuario);
        pw.print(darBajaCategoria);

    }

    public void registroVariCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        String desVariablesCat = request.getParameter("desVariablesCat");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(registroVariCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.registroVariCategoria(desVariablesCat, usuario);
        pw.print(resultado);

    }

    public void listaVariCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("application/json");
        System.out.println("SERVLET ventas(listaVariCategoria): ");

        ventasServices ventasServices = new ventasServices();
        ventas listaaa = ventasServices.listaVariCategoria(0);
        response.setContentType("text/html;charset=UTF-8");

        // Respuesta tipo JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(listaaa.getV_listaVariableCat());
        response.getWriter().write(json);

    }

    public void actualizarVariCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        String codVariableCat = request.getParameter("codVariableCat");
        String desVariableCat = request.getParameter("desVariableCat");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(actualizarVariCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.actualizarVariCategoria(Integer.parseInt(codVariableCat), desVariableCat, usuario);
        pw.print(resultado);

    }

    public void darBajaVariCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        String codVariableCat = request.getParameter("codVariableCat");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(darBajaVariCategoria): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.darBajaVariCategoria(Integer.parseInt(codVariableCat), usuario);
        pw.print(resultado);

    }

    protected void estructuraCatgoriaVariables(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("SERVLET ventas(estructuraCatgoriaVariables): ");
        ventasServices ventasServices = new ventasServices();

        int codigo = Integer.parseInt(request.getParameter("BuscadorConfCategoria"));

//        ventas listaCategoria = ventasServices.listaCategoria(0);
        ventas listaCategoria = ventasServices.listaCategoria(codigo);
        ArrayList<ventas> listaCat = listaCategoria.getListarCategoria();

        PrintWriter wp = response.getWriter();
        for (int i = 0; i < listaCat.size(); i++) {
            String codCatgoria = listaCat.get(i).getV_codCategoria();
//            ventas listaVariables2 = ventasServices.listaVariCategoria(0);
            ventas listaVariables2 = ventasServices.listaConfVariables(Integer.parseInt(codCatgoria));

            wp.print("<tr>");

            String desCatgoria = listaCat.get(i).getV_desCategoria();

            wp.print("<td class=\"text-center categorias\"> " + listaCat.get(i).getV_desCategoria() + "</td>");
            wp.print("<td>");

            for (ventas vari : listaVariables2.getListaConfVariables()) {
//                ventas variaOne = new ventas();

                String simbolo = vari.getV_simbolo();
                String valorParam = vari.getV_valorParm();
                String desMatriz = vari.getV_desMatriz();

                String prioridad = vari.getV_prioridad();

                if (simbolo == null) {
                    simbolo = "-";
                }
                if (valorParam == null) {
                    valorParam = "-";
                }
                if (desMatriz == null) {
                    desMatriz = "";
                }
                String estilo = "";
                if (prioridad.equals("1")) {
                    estilo = "text-warning";
                } else {
                    estilo = "text-secondary";
                }
//                

                String codVariable = vari.getV_codVariableCat();
                String desVariable = String.valueOf(vari.getV_desVariableCat());
                wp.print("<table style='width: 100%;'>"
                        + " <tr> "
                        + "     <td style='width: 25%;'> " + desVariable + "</td> "
                        + "     <td style='width: 20%;'> " + simbolo + "</td> "
                        + "     <td style='width: 23%;'> " + valorParam + " " + desMatriz + "</td> "//V_refValor

                        + "     <td style='width: 20%;'> <a class='pe-1' href='#'   title='Prioridad' ><i onclick='prioridad(" + codCatgoria + "," + codVariable + ");' id='prioridad' value='0' class=\"fas fa-star " + estilo + "\"> </i> </a>" + "</td> " //light  warning secondary

                        + "     <td style='width: 20%;'> <a class='pe-1' href='#' title='Editar' onclick='abrirModalConfVariables(" + codCatgoria + ",\"" + desCatgoria + "\",\"" + desVariable + "\"," + codVariable + ");' ><i class=\"fas fa-edit editar\"> </i> </a>"
                        //"<a class='pe-1' href='#' title='otrasOpciones' ><i class=\"far fa-address-card otras-opciones\"> </i> </a>"
                        + "<a class='pe-1' href='#' title='borrar Configuracion' onclick='darBajaConfVariables(" + codCatgoria + "," + codVariable + ");' ><i class=\"fas fa-trash-alt borrar\"> </i> </a>"
                        + "</td> "
                        + " </tr> "
                        + "</table>");

            }

            wp.print("</td>");
            wp.print("</tr>");
        }

    }

    public void listaCondicionVar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SERVLET ventas(listaCondicionVar): ");
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaCondicionVar();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter wp = response.getWriter();

        wp.print("<option value='' ></option>");//SELECCIONE CONDICION

        for (ventas de : lista.getListaCondicionVar()) {
            wp.print("<option value=\"" + de.getV_codCondicion() + "\"> " + de.getV_desCondicion() + "</option>");
        }

    }

    public void listaValoresVar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SERVLET ventas(listaValoresVar): ");
        ventasServices ventasServices = new ventasServices();
        ventas lista = ventasServices.listaValoresVar();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter wp = response.getWriter();

//        wp.print("<option value='' >  SELECCIONE VALORES </option>");

        for (ventas de : lista.getListaRefValor()) {
            wp.print("<option value=\"" + de.getV_codMatriz() + "\"> " + de.getV_desMatriz() + "</option>");
        }

    }

    public void registrarConfig(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int cod_categoria = Integer.parseInt(request.getParameter("cod_categoria"));
        int cod_Variable = Integer.parseInt(request.getParameter("cod_Variable"));
        int cod_Condicion = Integer.parseInt(request.getParameter("cod_Condicion"));
        int camValor = Integer.parseInt(request.getParameter("camValor"));
        int paramValor = Integer.parseInt(request.getParameter("paramValor"));

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(registrarConfig): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.registrarConfig(cod_categoria, cod_Variable, cod_Condicion, camValor, paramValor, usuario);
        pw.print(resultado);

    }

    public void prioridadVariable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        int codVariable = Integer.parseInt(request.getParameter("codVariable"));

        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(prioridadVariable): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.prioridadVariable(codVariable, codCategoria, usuario);
        pw.print(resultado);

    }
        public void darBajaConfVariables(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        int codVariable = Integer.parseInt(request.getParameter("codVariable"));
        //Extrae el usuario de sesión
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET ventas(darBajaConfVariables): ");

        ventasServices ventasServices = new ventasServices();
        String resultado = ventasServices.darBajaConfVariables(codCategoria, codVariable, usuario);
        pw.print(resultado);

    }
}
