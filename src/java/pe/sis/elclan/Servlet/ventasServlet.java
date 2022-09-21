/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.elclan.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ventasServlet  extends HttpServlet{

    /**
     *
     * @param req
     * @param resp
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
        
    
}
