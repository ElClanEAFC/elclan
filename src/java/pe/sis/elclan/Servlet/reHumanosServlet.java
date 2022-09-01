/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.Services.reHumanosServices;

/**
 *
 * @author bcondori
 */
public class reHumanosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("Accion");
        System.out.println("SERVLET ReHumanos(Accion): " + param);
        if (("Login").equals(param)) {
            Login(request, response);
        } else if (("listarAreas").equals(param)) {
            listarAreas(request, response);
        } else if (("guardarArea").equals(param)) {
            guardarArea(request, response);
        } else if (("actualizarArea").equals(param)) {
            actualizarArea(request, response);
        } else if (("borrarArea").equals(param)) {
            borrarArea(request, response);
        } else if (("listarPerfilesArea").equals(param)) {
            listarPerfilesArea(request, response);
        } else if (("returnNomArea").equals(param)) {
            returnNomArea(request, response);
        } else if (("guardarCargo").equals(param)) {
            guardarCargo(request, response);
        } else if (("confirBorrarPerfil").equals(param)) {
            confirBorrarPerfil(request, response);
        } else if (("actualizarPerfil").equals(param)) {
            actualizarPerfil(request, response);
        } else if(("listarModulos").equals(param)){
            listarModulos(request, response);
        } else if(("listarAllAreas").equals(param)){
            listarAllAreas(request, response);
        }else if(("listarPerfiles").equals(param)){
            listarPerfiles(request, response);
        }else if(("guardarRoles").equals(param)){
            guardarRoles(request, response);
        }else if(("listaSucursales").equals(param)){
            listaSucursales(request, response);
        }else if(("guardarSucursal").equals(param)){
            guardarSucursal(request, response);
        }else if(("listaDepartamentos").equals(param)){
            listaDepartamentos(request, response);
        }else if(("listaProvincias").equals(param)){
            listaProvincias(request, response);
        }else if(("listaDistritos").equals(param)){
            listaDistritos(request, response);
        }else if(("deleteSucursal").equals(param)){
            deleteSucursal(request, response);
        }else if(("actualizarSucursal").equals(param)){
            actualizarSucursal(request, response);
        }else if(("listaAreasSucursal").equals(param)){
            listaAreasSucursal(request, response);
        }else if(("agregarAreasSucursal").equals(param)){
            agregarAreasSucursal(request, response);
        }else if(("desactivarAreaSucursal").equals(param)){
            desactivarAreaSucursal(request, response);
        }else if(("listaTipoDocumento").equals(param)){
            listaTipoDocumento(request, response);
        }else if(("validarNumDoc").equals(param)){
            validarNumDoc(request, response);
        }else if(("guardarUsuarios").equals(param)){
            guardarUsuarios(request, response);
        }else if(("listaPaises").equals(param)){
            listaPaises(request, response);
        }else if(("actualizarUsuarios").equals(param)){
            actualizarUsuarios(request, response);
        }else if(("asignarCargoUsuario").equals(param)){
            asignarCargoUsuario(request, response);
        }else if(("listaUsuarios").equals(param)){
            listaUsuarios(request, response);
        }else if(("darBajaUsuario").equals(param)){
            darBajaUsuario(request, response);
        }else if(("cargaAsistencia").equals(param)){
            cargaAsistencia(request, response);
        } else if(("listarAsistenciaDiario").equals(param)){
            listarAsistenciaDiario(request, response);
        }else if(("generarReportAsistencia").equals(param)){
            generarReportAsistencia(request, response);
        }else if(("crearReportAsistenciaTXT").equals(param)){
            crearReportAsistenciaTXT(request, response);
        }else if(("justificarAsistencia").equals(param)){
            justificarAsistencia(request, response);
        }else if(("listaMotivoBaja").equals(param)){
            listaMotivoBaja(request, response);
        }else if(("listaCargosUsuario").equals(param)){
            listaCargosUsuario(request, response);
        }else if(("desactivarUsuario").equals(param)){
            desactivarUsuario(request, response);
        }else if(("listaCargosUsuarioDetalle").equals(param)){
            listaCargosUsuarioDetalle(request, response);
        }else if(("listaPuestoLab").equals(param)){
            listaPuestoLab(request, response);
        }else if(("listaEmpresaLab").equals(param)){
            listaEmpresaLab(request, response);
        }else if(("registroExperienciaLab").equals(param)){
            registroExperienciaLab(request, response);
        }else if(("listaExperienciasLab").equals(param)){
            listaExperienciasLab(request, response);
        }else if(("darBajaExperienciaLab").equals(param)){
            darBajaExperienciaLab(request, response);
        }else if(("registroSedeUsuario").equals(param)){
            registroSedeUsuario(request, response);
        }else if(("desactivarCargoUsuario").equals(param)){
            desactivarCargoUsuario(request, response);
        }else if(("listaUsuariosSucursal").equals(param)){
            listaUsuariosSucursal(request, response);
        }else if(("bajaUsuarioSucursal").equals(param)){
            bajaUsuarioSucursal(request, response);
        }else if(("listarAreasSede").equals(param)){
            listarAreasSede(request, response);
        }else if(("listaJustificacion").equals(param)){
            listaJustificacion(request, response);
        }
        
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 29-07-2022
     * @Descripcion : listar justificaciones
    ***************************************************************************/
    public void listaJustificacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET reHumanos(listaJustificacion): ");
        String codAsistDet = request.getParameter("codAsistDet");
        
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaJustificacion(codAsistDet);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista);
        response.getWriter().write(json);
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-08-2022
     * @Descripcion : listar areas para sedes
    **************************************************************************
     */
    
    public void listarAreasSede(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codSede = request.getParameter("codSede");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listarAreasSede): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        mantenimiento lista = reHumanosService.listarAreasSede(codSede);
        wp.print("<option></option>");
        for (mantenimiento ma : lista.getListaAreas()) {            
            wp.print("<option value=\""+ ma.getmCodigoArea()+ "\"> " +ma.getmDescArea() +  "</option>");
        }
    }
    
        /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : REGISTRAR EXPERIENCIAS LABORADAS
    ***************************************************************************/
    public void registroSedeUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUsuario = request.getParameter("codUser");
        String codSede = request.getParameter("codSede");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET reHumanos(registroExperienciaLab): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.registroSedeUsuario(codUsuario, codSede, usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : DAR BAJA EXPERIENCIA DE USUARIO.
    ***************************************************************************/
    public void darBajaExperienciaLab(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codExperiencia = request.getParameter("codExperiencia");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET reHumanos(darBajaExperienciaLab): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.darBajaExperienciaLab(codExperiencia);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : lISTA DE EXPERIENCIAS LABORALES DEL USUARIO
    ***************************************************************************/
    public void listaExperienciasLab(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET reHumanos(listaExperienciasLab): ");
        String codUsuario = request.getParameter("codUser");
        
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaExperienciasLab(codUsuario);   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaExperienciaLab());
        response.getWriter().write(json);
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : REGISTRAR EXPERIENCIAS LABORADAS
    ***************************************************************************/
    public void registroExperienciaLab(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUsuario = request.getParameter("codUser");
        String codPuesto = request.getParameter("codPuesto");
        String descripcion = request.getParameter("descripcion");
        String fecIni = request.getParameter("fecIni");
        String fecFin = request.getParameter("fecFin");
        String codPersona = request.getParameter("empresa");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET reHumanos(registroExperienciaLab): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.registroExperienciaLab(codUsuario, codPuesto, descripcion, fecIni, fecFin, codPersona, usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : lISTA DE EMPRESAS LABORADAS
    ***************************************************************************/
    public void listaEmpresaLab(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET reHumanos(listaPuestoLab): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaEmpresaLab();   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaEmpresaLab());
        response.getWriter().write(json);
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : lISTA DE PUESTOS LABORADOS
    ***************************************************************************/
    public void listaPuestoLab(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        System.out.println("SERVLET reHumanos(listaPuestoLab): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaPuestoLab();   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaPuestoLab());
        response.getWriter().write(json);
    }
    
//  ====================== REPORTES DE ASISTENCIAS ============================
    
    /*************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 25-07-2022
     * @Descripcion : REGISTRAR EXPERIENCIAS LABORADAS
    ***************************************************************************/
    public void justificarAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");

        String codVende = request.getParameter("cod_usu");
        String codAsistDet = request.getParameter("cod_asistdet");
        String fecha = request.getParameter("fechas");
        String obs = request.getParameter("obs");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET reHumanos(justificarAsistencia): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos seguridad = reHumanosService.justificarAsistencia(codVende, codAsistDet, fecha, usuario, obs);
        pw.print(seguridad.getCodMensaje() + "_" + seguridad.getMensaje());    
    }
    
    /** 
     *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu condori mamani
     * @fecha creacion: 01-08-2022
     * @Descripcion : Genera el reporte de asistencia en formato TXT
    ***************************************************************************/    
    public void crearReportAsistenciaTXT(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("llega crearReportAsistenciaTXT");
        FileWriter archivo = null;
        PrintWriter esc = null;

            try {
                archivo = new FileWriter("C:\\Systems\\TMP\\archivo.txt");
                esc = new PrintWriter(archivo);
                esc.println("C0NTENIDO DEL ARCHIVO");
                
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                archivo.close();
            }
    }
    
    private static final int BYTES_DOWNLOAD = 1024;
    
    /** 
     *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu condori mamani
     * @fecha creacion: 01-08-2022
     * @Descripcion : Genera el reporte de asistencia en formato TXT
    ***************************************************************************/    
    public void generarReportAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String fecha = request.getParameter("fecIni");
        String codBanco = "1";
        String modDeposito = "4";
        String codTplanilla = "1";
        String fecFin = "";
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(modalCargaAsistencia): ");
        reHumanosServices reHumanosService = new reHumanosServices(); 
        reHumanos guardar = reHumanosService.generarReportAsistencia(fecha,codBanco,modDeposito,codTplanilla, usuario);
        /**********GENERAR ARCHIVO TXT *********************/
            FileWriter archivo = null;
            PrintWriter esc = null;
           try {
                archivo = new FileWriter("C:\\apache-tomcat-8.5.81\\webapps\\elclan\\vistas\\Reportes\\banbif-"+fecha+".txt");
                esc = new PrintWriter(archivo);
                
                for (reHumanos re : guardar.getListReporte()) {
                    esc.println(re.getCampReporte());
                }   
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                archivo.close();
            }
       
       String url = "http://localhost:8080/elclan/vistas/Reportes/banbif-"+fecha+".txt";
        
         pw.print(guardar.getCodMensaje()+'_'+guardar.getMensaje()+'_'+url);
    }
    
    /** 
    *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu condori mamani
     * @fecha creacion: 26-07-2022
     * @Descripcion : Lista de asistencias diarios
    ***************************************************************************/
    public void listarAsistenciaDiario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listarAsistenciaDiario): ");
        String  fecha = request.getParameter("fechaAsis");
        String  datos = request.getParameter("nombreAsis");
        String  estado= request.getParameter("estados");
        System.out.println("SERVLET reHumanos(fecha): "+fecha+" datos: "+datos);
        String datoPer = "";
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listarAsistenciaDiario(fecha, datos, estado);        
        if(lista.getListaUsuarios().isEmpty()){
            wp.print("<td class=\"bg-light px-1 text-center\" colspan=\"7\">No se encontraron datos, realice la carga de asistencia diaria</td>");
        }else{
            //RESPUESTA TYPE-JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(lista.getListaUsuarios());
            response.getWriter().write(json);
        }
//        
//        for (reHumanos user : lista.getListaUsuarios()) {
//            datoPer = user.getNombreUsuario()+ ' '+ user.getApePaternoUsuario()+' '+user.getApeMaternoUsuario();
//            wp.print("<tr role=\"row\" class=\"odd\">"
//                    + "  <td>" + user.getNombreUsuario()+ ' '+ user.getApePaternoUsuario()+' '+user.getApeMaternoUsuario() + "</td>"
//                    + "  <td>" + user.getNumeroDOI()+ "</td>"      
//                    + "  <td>" + user.getFechaMarcacion()+ "</td>"
//                    + "  <td>" + user.getHoraMarcacion()+ "</td>"
//                    + "  <td>" + user.getDescPerfil()+ "</td>"
//                    + "  <td>" + user.getSitAsistencia()+ "</td>"
//                    + "  <td>"   
//                    + "       <a href='#' onclick='abrirModalJustificacion("+user.getCodigoUsuario()+","+user.getCodigoAsisDet()+",\""+datoPer+"\" );' title='JUSTIFICAR ASISTENCIA'>"
//                    + "           <i class='far fa-clock otras-opciones' ></i>"
//                    + "       </a>"
//                    + "  </td>"
//                    + "</tr>");
//            //contar = contar + 1;
//        }
    }

    public void cargaAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String fecha = request.getParameter("fecIni");
        String fecFin = "";
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(modalCargaAsistencia): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.cargaAsistencia( fecha, fecFin);
        Integer cant = lista.getListaAsistencia().size();
        System.out.println("cantidad de registros: "+ cant);
        if (cant >= 1) {
            for (reHumanos a : lista.getListaAsistencia()) {
                String guar = reHumanosService.guardarAsistenciaTmp(a.getNumeroDOI(), a.getFecHoraMarcacion());
            }
            reHumanos guardar = reHumanosService.confirmarCargaAsistencia(fecha, fecFin, usuario);
            pw.print(guardar.getCodMensaje()+'_'+guardar.getMensaje());
        }else{
            pw.print("0_MENSAJE: PRIMERO DEBE DESCARGAR DATOS DEL HUELLERO");
        }
    }       
//     FINAL DE REPORTES DE ASISTENCIAS
    
    
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 18-07-2022
     * @Descripcion : Listar Cargos de Usuario Detalle
    ***************************************************************************/
    public void listaCargosUsuarioDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaUsuarios): ");
        String codUsuario = request.getParameter("codUser");
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaCargosUsuario(codUsuario);        
        int contar = 1;
        String colorEstado = "bg-success text-white p-1 rounded-3";
        for (reHumanos user : lista.getListaCargosUsuario()) {
            wp.print("<tr>"
                    + "  <td>" + contar + "</td>"
                    + "  <td>" + user.getDescArea()+ "</td>"
                    + "  <td>" + user.getDescPerfil()+ "</td>"
                    + "  <td>" + user.getFinicio()+ "</td>"
                    + "  <td>" + user.getFcese()+ "</td>"
                    + "  <td>" + user.getMotivoCese()+ "</td>");
            if (!user.getEstado().equalsIgnoreCase("activo")) {
                colorEstado = "bg-danger text-white p-1 rounded-3";
            }
            wp.print("  <td><span class=\" "+colorEstado+ "\">" + user.getEstado()+ "</span></td>"
                    + "</tr>");
            contar = contar + 1;
        }
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 21-07-2022
     * @Descripcion : Desactivar Usuario
    ***************************************************************************/
    public void desactivarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUsuario = request.getParameter("codUser");
        PrintWriter pw = response.getWriter();
        
        System.out.println("SERVLET reHumanos(desactivarUsuario): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.desactivarUsuario(codUsuario, usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 19-07-2022
     * @Descripcion : Lista Motivos de Baja
    ***************************************************************************/
    public void listaMotivoBaja(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaPaises): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaMotivoBaja();        
        wp.print("<option></option>");
        
        for (reHumanos motivo : lista.getListaMotivosBaja()) {            
            wp.print("<option value=\""+ motivo.getCodMotCese()+ "\"> " +motivo.getDesMotCese()+  "</option>");
        }
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 19-07-2022
     * @Descripcion : Cesar Usuario
    ***************************************************************************/
    public void darBajaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUsuario = request.getParameter("codUser");
        String codMotCese = request.getParameter("motCese");
        String fecCese = request.getParameter("fecCese");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(darBajaUsuario): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.darBajaUsuario(codUsuario,codMotCese,fecCese);
        pw.print(seguridad);    
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 15-07-2022
     * @Descripcion : Lista Paises
    ***************************************************************************/
    public void listaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaUsuarios): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaUsuarios();   
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaUsuarios());
        response.getWriter().write(json);
    
    /**
        for (reHumanos user : lista.getListaUsuarios()) {
            wp.print("<tr>"
                   // + "  <td>" + contar + "</td>"
                    + "  <td>" + user.getNombreUsuario()+ "</td>"
                    + "  <td>" + user.getApePaternoUsuario()+ "</td>"
                    + "  <td>" + user.getApeMaternoUsuario()+ "</td>"
                    + "  <td>" + user.getUsuario()+ "</td>"
                    + "  <td>" + user.getDescTipoDOI()+ "</td>"
                    + "  <td>" + user.getNumeroDOI()+ "</td>"
                    + "  <td>" + user.getDescPerfil()+ "</td>"
                    + "  <td>" + user.getEstado()+ "</td>"
                    + "  <td>"
                    + "       <a href='#' onclick=\"editarUsuario('"+user.getCodigoTipoDOI()+"','"
                    +user.getNumeroDOI()+"');\" title='Editar Usuario'><i class='fas fa-edit editar' ></i></a>"
                    + "       <a href='#' onclick=\"detalleUsuario('"+user.getCodigoUsuario()
                    +"','"+user.getCodigoTipoDOI()+"','"+user.getNumeroDOI()+"');\" title='Detalle Usuario'><i class=\"fas fa-eye\"></i></a>"
                    + "       <a href='#' onclick='asignarAreas("+user.getCodigoUsuario()+");' title='Asginar Cargo'><i class='far fa-address-card otras-opciones' ></i></a>"
                    + "       <a href='#' onclick='"
                            + "confirmarBajaUser("+user.getCodigoUsuario()+");'><i class='far fa-trash-alt borrar'  title='Cesar Usuario'></i></a>"
                    + "  </td>"
                    + "</tr>");
            //contar = contar + 1;
        }   ***/
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 19-07-2022
     * @Descripcion : Cesar Usuario
    ***************************************************************************/
    public void desactivarCargoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUserPerfil = request.getParameter("codUserPerfil");
        String codUser = request.getParameter("codUser");
        String codPerfil = request.getParameter("codPerfil");
        String observacion = request.getParameter("observacion");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(darBajaUsuario): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.desactivarCargoUsuario(codUserPerfil,codUser,codPerfil,observacion,usuario);
        pw.print(seguridad);    
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 18-07-2022
     * @Descripcion : Listar Cargos de Usuario
    ***************************************************************************/
    public void listaCargosUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaUsuarios): ");
        String codUsuario = request.getParameter("codUser");
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaCargosUsuario(codUsuario);  
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaCargosUsuario());
        response.getWriter().write(json); 
        
//        int contar = 1;
//        String colorEstado = "bg-success text-white p-1 rounded-3";
//        for (reHumanos user : lista.getListaCargosUsuario()) {
//            wp.print("<tr>"
//                    + "  <td>" + contar + "</td>"
//                    + "  <td>" + user.getDescArea()+ "</td>"
//                    + "  <td>" + user.getDescPerfil()+ "</td>"
//                    + "  <td>" + user.getFinicio()+ "</td>"
//                    + "  <td>" + user.getFcese()+ "</td>"
//                    + "  <td>" + user.getMotivoCese()+ "</td>");
//            if (!user.getEstado().equalsIgnoreCase("activo")) {
//                colorEstado = "bg-danger text-white p-1 rounded-3";
//            }            
//            wp.print( "  <td><span class=\" "+colorEstado+ "\">" + user.getEstado()+ "</span></td>"
//                    + "  <td class=\"opcion\" >"
//                    + "  <a href='#' onclick='"+ "confirmarBajaUser("+user.getCodigoUsuario()+");'><i class='far fa-trash-alt borrar'  title='Desactivar Cargo'></i></a>"
//                    + "  </td>"
//                    + "</tr>");
//            contar = contar + 1;
//        }
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 18-07-2022
     * @Descripcion : Asignar Cargo Usuario
    ***************************************************************************/
    public void asignarCargoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codUsuario = request.getParameter("codUser");
        String codCargo = request.getParameter("codCargo");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(asignarCargoUsuario): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.asignarCargoUsuario(codUsuario,codCargo,usuario);
        pw.print(seguridad);
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 15-07-2022
     * @Descripcion : Actualizar Usuario
    ***************************************************************************/
    public void actualizarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String usuCod = request.getParameter("codUsuario");
        String usuNombre = request.getParameter("usuNombre");
        String usuPaterno = request.getParameter("usuApaterno");
        String usuMaterno = request.getParameter("usuAmaterno");
        String codTDoc = request.getParameter("codTDoc");
        String numDoc = request.getParameter("numDoc");
        String codPais = request.getParameter("codPais");
        String codDpto = request.getParameter("codDpto");
        String codProv = request.getParameter("codProv");
        String codDist = request.getParameter("codDist");
        String usuCelular = request.getParameter("usuCelular");
        String usuCorreo = request.getParameter("usuCorreo");
        String usuDirec = request.getParameter("usuDirec");
        String usuFNac = request.getParameter("usuFNac");
        String usuSucursal = request.getParameter(("usuSucursal"));
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(actualizarUsuarios): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.actualizarUsuarios(usuCod,usuNombre, usuPaterno, usuMaterno, codTDoc, numDoc, codPais, 
            codDpto, codProv, codDist, usuCelular, usuCorreo, usuDirec, usuSucursal,usuFNac, usuario);
        pw.print(seguridad);
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 15-07-2022
     * @Descripcion : Lista Paises
    ***************************************************************************/
    public void listaPaises(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaPaises): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaPaises();        
        wp.print("<option></option>");
        
        for (reHumanos pais : lista.getListaPaises()) {            
            wp.print("<option value=\""+ pais.getCodigoPais()+ "\"> " +pais.getDescPais()+  "</option>");
        }
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 11-07-2022
     * @Descripcion : Guardar Usuario
    ***************************************************************************/
    public void guardarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String usuNombre = request.getParameter("usuNombre");
        String usuPaterno = request.getParameter("usuApaterno");
        String usuMaterno = request.getParameter("usuAmaterno");
        String codTDoc = request.getParameter("codTDoc");
        String numDoc = request.getParameter("usuNumDoc");
        String codPais = request.getParameter("codPais");
        String codDpto = request.getParameter("codDpto");
        String codProv = request.getParameter("codProv");
        String codDist = request.getParameter("codDist");
        String usuCelular = request.getParameter("usuCelular");
        String usuCorreo = request.getParameter("usuCorreo");
        String usuDirec = request.getParameter("usuDireccion");
        String usuSucursal = request.getParameter(("usuSucursal"));
        String codArea = request.getParameter("codArea");
        String codPerfil = request.getParameter("codCargo");
        String usuFNac = request.getParameter("usuFNacimiento");
        String usuFIni = request.getParameter("usuFinicio");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(guardarUsuarios): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.guardarUsuarios(usuNombre, usuPaterno, usuMaterno, codTDoc, numDoc, codPais, 
            codDpto, codProv, codDist, usuCelular, usuCorreo, usuDirec, usuSucursal, codArea, codPerfil, 
            usuFNac, usuFIni, usuario);
        pw.print(seguridad);
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 11-07-2022
     * @Descripcion : eliminar sucursal
    ***************************************************************************/
    public void validarNumDoc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
        String codTDoc = request.getParameter("codTDoc");
        String numDoc = request.getParameter("numDoc");
        System.out.println("SERVLET reHumanos(validarNumDoc): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos datosUsuario = reHumanosService.validarNumDoc(codTDoc, numDoc);
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(datosUsuario);
        response.getWriter().write(json);
        
    }
    /**
     * *************************************************************************
     * @param request
     * @param response 
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 11-07-2022
     * @Descripcion : eliminar sucursal
    ***************************************************************************/
    public void listaTipoDocumento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codTipoDoc = request.getParameter("codTipoDoc");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaTipoDocumento): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaTipoDocumento(codTipoDoc);        
//        wp.print("<option>--seleccionar --</option>");
        
        for (reHumanos tdoc : lista.getListaTipoDocumento()) {
                wp.print("<option value=\""+ tdoc.getCodMensaje()+ "\"> " +tdoc.getMensaje()+ "</option>");
        }
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 09-08-2022
     * @Descripcion : DAR BAJA USUARIO DE Sucursal
    **************************************************************************
     */
    
    public void bajaUsuarioSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codSucursal = request.getParameter("codSucursal");
        String codUsuario = request.getParameter("codUsuario");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(bajaUsuarioSucursal): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.bajaUsuarioSucursal(codSucursal, codUsuario);
        pw.print(seguridad);        
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response 
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 09-08-2022
     * @Descripcion : Listar Usuarios de Sucursal
    ***************************************************************************/
    public void listaUsuariosSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codSucursal = request.getParameter("codSucursal");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaUsuariosSucursal): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaUsuariosSucursal(codSucursal);        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaUsuariosSucursal());
        response.getWriter().write(json);
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 07-07-2022
     * @Descripcion : eliminar sucursal
    **************************************************************************
     */
    public void desactivarAreaSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codSucursal = request.getParameter("codSucursal");
        String codArea = request.getParameter("codArea");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(desactivarAreaSucursal): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.desactivarAreaSucursal(codSucursal, codArea, usuario);
        pw.print(seguridad);        
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 07-07-2022
     * @Descripcion : eliminar sucursal
    **************************************************************************
     */
    public void agregarAreasSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codSucursal = request.getParameter("codSucursal");
        String codArea = request.getParameter("codArea");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(agregarAreasSucursal): ");
        
        reHumanosServices reHumanosService = new reHumanosServices();
        
        String seguridad = reHumanosService.agregarAreasSucursal(codSucursal,codArea,usuario);
        pw.print(seguridad);
        
    }    
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : listar de modulos y sub modulos
    ****************************************************************************
     */
    public void listaAreasSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        int contar = 1;
        String codSede = request.getParameter("codSede");
        System.out.println("SERVLET reHumanos(listaAreasSucursal): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaAreasSucursal(codSede);
        String colorEstado = "bg-success text-white p-1 rounded-3";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaAreasSucursal());
        response.getWriter().write(json);
        
//        for (reHumanos area : lista.getListaAreasSucursal()) {
//            wp.print("<tr>"
//                   // + "  <td>" + contar + "</td>"
//                    + "  <td>" + area.getDescArea()+ "</td>");
//            if (!area.getEstado().equalsIgnoreCase("ACTIVO")) {
//                colorEstado = "bg-danger text-white p-1 rounded-3";
//            }
//            wp.print( "  <td><span class=\" "+colorEstado+ "\">" + area.getEstado()+ "</span></td>"
//                    + "  <td>"
//                    + "       <a href='#' onclick='desactivarAreaSucursal("+area.getCodSucursal()+","+area.getCodigoArea()+");'>"
//                            + "<i class='far fa-trash-alt borrar'  title='Desactivar Área'></i></a>"
//                    + "  </td>"
//                    + "</tr>");
//            //contar = contar + 1;
//        }
    }    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 07-07-2022
     * @Descripcion : eliminar sucursal
    **************************************************************************
     */
    public void actualizarSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codSede = request.getParameter("codSede");
        String nomSede = request.getParameter("nomSede");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String dpto = request.getParameter("dpto");
        String prov = request.getParameter("prov");
        String dist = request.getParameter("dist");
        String direc = request.getParameter("direc");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(actualizarSucursal): ");
        
        reHumanosServices reHumanosService = new reHumanosServices();
        
        String seguridad = reHumanosService.actualizarSucursal(codSede,nomSede,telefono,email,dpto,prov,dist,direc, usuario);
        pw.print(seguridad);
        
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 07-07-2022
     * @Descripcion : eliminar sucursal
    **************************************************************************
     */
    public void deleteSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String usuario = (String) session.getAttribute("usuario");
        String codSucursal = request.getParameter("cod");
        PrintWriter pw = response.getWriter();
        System.out.println("SERVLET reHumanos(deleteSucursal): ");
        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.deleteSucursal(codSucursal,usuario);
        pw.print(seguridad);
        
    } 
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : lista de provincias
    **************************************************************************
     */
    public void listaDistritos (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codDpto = request.getParameter("codDpto");
        String codProv = request.getParameter("codProv");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaDistritos): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaDistritos(codDpto, codProv);        
        wp.print("<option></option>");
        
        for (reHumanos dis : lista.getListaDistritos()) {            
            wp.print("<option value=\""+ dis.getCodigoDistrito()+ "\"> " +dis.getDescDistrito().toUpperCase()+  "</option>");
        }
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : lista de provincias
    **************************************************************************
     */
    public void listaProvincias (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codDpto = request.getParameter("codDpto");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaProvincias): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaProvincias(codDpto);        
        wp.print("<option></option>");
        
        for (reHumanos pro : lista.getListaProvincias()) {            
            wp.print("<option value=\""+ pro.getCodigoProvincia()+ "\"> " +pro.getDescProvincia().toUpperCase()+  "</option>");
        }
    }
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : lista de departamentos
    **************************************************************************
     */
    public void listaDepartamentos (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codArea = request.getParameter("codArea");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listaDepartamentos): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaDepartamentos();
        wp.print("<option></option>");
        for (reHumanos de : lista.getListaDepartamentos()) {            
            wp.print("<option value=\""+ de.getCodigoDepartamento()+ "\"> " +de.getDescDepartamento()+  "</option>");
        }
    }
     /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : listar de modulos y sub modulos
    ****************************************************************************
     */
    public void guardarSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session_actual = request.getSession(true);
        String usuario = (String) session_actual.getAttribute("usuario");
        
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String dpto = request.getParameter("dpto");
        String prov = request.getParameter("prov");
        String dist = request.getParameter("dist");
        String direccion = request.getParameter("direccion");
        
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(guardarSucursal): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.guardarSucursal(nombre, telefono, email, dpto, prov, dist, direccion, usuario);
        
        wp.print(seguridad);
    }
     /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : listar de modulos y sub modulos
    ****************************************************************************
     */
    public void listaSucursales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        int contar = 1;

        System.out.println("SERVLET reHumanos(listaSucursales): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listaSucursales();
        //RESPUESTA TYPE-JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lista.getListaSucursales());
        response.getWriter().write(json);
        
//        String colorEstado = "bg-success text-white p-1 rounded-3";
//        for (reHumanos sucu : lista.getListaSucursales()) {
//            wp.print("<tr>"
//                   // + "  <td>" + contar + "</td>"
//                    + "  <td>" + sucu.getDesSucursal() + "</td>"
//                    + "  <td>" + sucu.getTelefono() + "</td>"
//                    + "  <td>" + sucu.getEmail() + "</span></td>"
//                    + "  <td>" + sucu.getDireccion() + "</td>"
//                    + "  <td>" + sucu.getCiudad() + "</td>");
//            if (!sucu.getEstado().equalsIgnoreCase("OPERATIVO")) {
//                colorEstado = "bg-danger text-white p-1 rounded-3";
//            }            
//            wp.print( "  <td><span class=\" "+colorEstado+ "\">" + sucu.getEstado() + "</span></td>"
//                    + "  <td>"
//                    + "       <a href='#' onclick=\"editSucursal('"+sucu.getCodSucursal()+"','"+sucu.getDesSucursal()+"','"+sucu.getTelefono()+
//                    "','"+sucu.getEmail()+"','"+sucu.getDireccion()+"','"+sucu.getCodigoDepartamento()+"','"+sucu.getCodigoProvincia()+
//                    "','"+sucu.getCodigoDistrito()+"');\" title='Editar Sucursal'><i class='fas fa-edit editar' ></i></a>"
//                    + "       <a href='#' onclick='asginarAreas("+sucu.getCodSucursal()+");' title='Configurar Sucursal'><i class='far fa-address-card otras-opciones' ></i></a>"
//                    + "       <a href='#' onclick='agregarUsuario("+sucu.getCodSucursal()+");'><i class='fas fa-user-plus' title='agregar Experiencia'></i></a>"
//                    + "       <a href='#' onclick='deleteSucursal("+sucu.getCodSucursal()+");'><i class='far fa-trash-alt borrar'  title='Desactivar Sucursal'></i></a>"
//                    + "  </td>"
//                    + "</tr>");
//            //contar = contar + 1;
//        }
    }
    
     /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : listar de modulos y sub modulos
    ****************************************************************************
     */
    public void guardarRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session_actual = request.getSession(true);
        String usuario = (String) session_actual.getAttribute("usuario");
        
        String codPerfil = request.getParameter("codPerfil");
        String codArea = request.getParameter("codArea");
        String codModulos = request.getParameter("codMod");
        String codSub = request.getParameter("codSub");
        String codPer = request.getParameter("codPer");
        
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(guardarRoles): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String seguridad = reHumanosService.guardarRoles(codPerfil, codArea, codModulos, codSub, codPer,usuario);
        
        wp.print(seguridad);
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 30-06-2022
     * @Descripcion : listar de modulos y sub modulos
    **************************************************************************
     */
    public void listarPerfiles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String codArea = request.getParameter("codArea");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listarPerfiles): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        reHumanos lista = reHumanosService.listarPerfiles(codArea);
        wp.print("<option></option>");
        for (reHumanos ma : lista.getListaPerfiles()) {            
            wp.print("<option value=\""+ ma.getCodigoPerfil()+ "\"> " +ma.getDescPerfil()+  "</option>");
        }
    }
    
    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 24-06-2022
     * @Descripcion : listar de modulos y sub modulos
    **************************************************************************
     */
    
    public void listarAllAreas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(listarAllAreas): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        mantenimiento lista = reHumanosService.listarAllAreas();
        wp.print("<option></option>");
        for (mantenimiento ma : lista.getListaAreas()) {            
            wp.print("<option value=\""+ ma.getmCodigoArea()+ "\"> " +ma.getmDescArea() +  "</option>");
        }
    }
    
    protected void listarModulos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("SERVLET mantenimiento(listarMenu): ");
        
        String codPerfil = request.getParameter("codPerfil");
        
        reHumanosServices reHumanosService = new reHumanosServices();
        mantenimiento lista = reHumanosService.listarModulos(codPerfil);
        String activo = "";
        String inactivo = "";
        if(lista.getListaModulos().isEmpty()){
            out.print("<p>No Tiene modulos asignados</p>");
        }else{
            for (mantenimiento ma : lista.getListaModulos()) {
                
                System.out.println("-------Modulo: " + ma.getDesModulo() + " - " + ma.getCanSubModulo() + "------");
                out.print("<div class=\"card-body bg-white pt-0 pb-2 px-0\">");
                out.print("<div class=\"d-flex gap-2 mb-0 bg-white\">"
                        + " <div class=\"col-md-4\">"
                        + "     <label for=\"exampleInputPassword1\">Denominación*</label>"
                        + "             <input disabled type=\"text\" value=\""+ ma.getDesModulo() + "\" class=\"form-control\" id=\"exampleText\">"
                                + "     </div>");
                out.print("<div class=\"col-md-3\">"
                + "<form id=\"exampleform\">"
                + "<label for=\"exampleInputPassword1\">Estado*</label>"
                + "<div>");
                if (ma.getSituCheck().equals("1")) {
                    activo = "checked";
                } else {
                    inactivo = "checked";
                }
                
                out.print("         <div class=\"form-check col-sm-5 form-check-inline\">"
                        + "             <input class=\"form-check-input\" type=\"radio\" "
                        + "                 id=\"check"+ma.getCodModulo()+"\"  "
                                + "                     onclick=\"addPermiso("+ma.getCodModulo()+")\""
                                        + "                     value=\""+ma.getCodModulo()+"\" name=\"checkModulos\" "
                                                + "             "+ activo +"> "
                                                        +               "<label class=\"form-check-label\" for=\"gridRadios1\">"
                                                        + "                 Activo"
                                                        + "             </label>"
                                                        + "         </div>");
                out.print("         <div class=\"form-check col-sm-5 form-check-inline\">"
                        + "             <input class=\"form-check-input\" type=\"radio\" name=\"checkModulos\" "
                        + "                 id=\"inCheck"+ma.getCodModulo()+"\" "
                                + "             value=\"\" onclick=\"removePermiso("+ma.getCodModulo()+")\""
                                        + "             "+ inactivo +">"
                                                + "             <label class=\"form-check-label\" for=\"gridRadios1\">"
                                                + "                 Inactivo"
                                                + "             </label>"
                                                + "         </div>"
                                                + "         </div>"
                                                + "      </form>"
                                                + "</div>            ");
                out.print("<div class=\"col-md-4 flex-grow-1\">"
                        + "<label for=\"exampleInputPassword1\">Permisos Asignados*</label> "
                        + "<div class=\" p-1 rounded\" style=\"background: #d9d9d9;\" onclick=\"desplegarSubModulos('submodulo" + ma.getCodModulo() + "');\">\n"
                                                  + "          <div class=\"bg-light text-secondary \">\n"
                                                  + "             <p class=\"m-0\" role=\"button\">Privilegios</p>\n"
                                                  + "          </div>\n"
                                                  + "     </div>\n"
                                                  + " </div>\n"
                                                  +"</div>       ");
                if (ma.getCanSubModulo().equals("0")) {
                    System.out.println("MODULO: " + ma.getDesModulo()+ " ; " + "CANTIDA SUBMODULOS: " + ma.getCanSubModulo());
                    out.print(
                            "   <div class=\"text-white p-2 hide gap-1 rounded\" style=\"background: #d9d9d9;\" id=\"submodulo"+ma.getCodModulo()+"\">"
                                    +           "no se encontraron submodulos"
                                    + " </div>\n"
                                    +"</div>");
                } else {
                    System.out.println("MODULO: " + ma.getDesModulo()+ " ; " + "CANTIDA SUBMODULOS: " + ma.getCanSubModulo());
                    ArrayList<mantenimiento> lisSub = reHumanosService.listarSubModulos(ma.getCodModulo(), codPerfil);
                    out.print("  <div class=\"hide p-2 rounded\" style=\"background: #d9d9d9;\" id=\"submodulo"+ ma.getCodModulo()+"\">");
                    for (mantenimiento su : lisSub) {
                        out.print("<div class=\"bg-white rounded text-white gap-1 form-check-inline\">"
                                + "     <div class=\"rounded d-flex flex-column w-auto bg-white p-1\">"
                                + "         <div class=\"d-flex gap-1\">");
                                String activoSub = "";
                                if (su.getSituCheck().equals("1")) {
                                    activoSub = "checked";
                                }
                                out.print("   <input class=\"form-check-input checkSubModul\" type=\"checkbox\" value=\"" + su.getCodSubModulo()+"\" "
                                        + "        name=\"checkSubModul["+ma.getCodModulo()+"]\" "+activoSub+" >"
                                        + "             <p class=\"fw-bold text-success m-0\">" + su.getDesSubModulo() + " </p>\n "
                                                + "         </div>"
                                                + "              <div class=\"d-flex gap-3 w-auto\">\n");
                        mantenimiento lisSubOpci = reHumanosService.ListarPermisos(codPerfil, su.getCodSubModulo());
                        for (mantenimiento opc : lisSubOpci.getListaSubModulosOpc()) {
                            String activoPerm = "";
                                if (opc.getSituCheck().equals("1")) {
                                    activoPerm = "checked";
                                }
                            out.print("           <div class=\"form-check d-flex gap-2\">"
                                    + "                    <input class=\"form-check-input checkPermiso\" type=\"checkbox\" value=\""+opc.getCodSubModuloOpc()+"\" "
                                    + "                         id=\"flexCheckDefault\" name=\"checkPermiso["+ma.getCodModulo()+"]\" "+activoPerm+">"
                                    + "                         <p class=\"text-info m-0\" >"
                                    + "                                "+opc.getDesSubModuloOpc()
                                    + "                         </p>"
                                    + "           </div>");
                            
                        }
                        out.print("              </div>"
                                + "     </div>");
                        out.print(" </div>");
                    }
                    out.print("  </div>");
                    out.print("</div>");
                }
                
            }
        }
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 23-06-2022
     * @Descripcion : actulizar los cargos segun el area
    **************************************************************************
     */
    protected void actualizarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(actualizarPerfil):  ");
        String codArea = request.getParameter("codArea");
        String codPerf = request.getParameter("codPerf");
        String nomPerf = request.getParameter("nomPerf");
        HttpSession session_actual = request.getSession(true);
        //String codUsuario = (String) session_actual.getAttribute("codigoUser");    
        String Usuario = (String) session_actual.getAttribute("usuario");

        System.out.println("SERVLET reHumanos(actualizarPerfil):  ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String resultado = reHumanosService.actualizarPerfil(codArea, nomPerf, codPerf, Usuario);
        
        wp.print(resultado);
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 22-06-2022
     * @Descripcion : Dar de baje el rol o cargo
    **************************************************************************
     */
    protected void confirBorrarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(confirBorrarPerfil):  ");
        String codPerfil = request.getParameter("codPerfil");
        HttpSession session_actual = request.getSession(true);
        String Usuario = (String) session_actual.getAttribute("usuario");

        reHumanosServices reHumanosService = new reHumanosServices();
        String resultado = reHumanosService.confirBorrarPerfil(codPerfil, Usuario);
        wp.print(resultado);
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 16-06-2022
     * @Descripcion : guarda los cargos segun el area
    **************************************************************************
     */
    protected void guardarCargo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        System.out.println("SERVLET reHumanos(guardarCargo):  ");
        String codArea = request.getParameter("codArea");
        String nomPerfil = request.getParameter("nomPerfil");
        HttpSession session_actual = request.getSession(true);
        //String codUsuario = (String) session_actual.getAttribute("codigoUser");    
        String Usuario = (String) session_actual.getAttribute("usuario");

        System.out.println("SERVLET reHumanos(guardarCargo):  ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String lista = reHumanosService.guardarCargo(codArea, nomPerfil, Usuario);
        wp.print(lista);
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 16-06-2022
     * @Descripcion : retorna el nombre del area segun el codigo
    **************************************************************************
     */
    protected void returnNomArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        String codArea = request.getParameter("codArea");
        int contar = 1;

        System.out.println("SERVLET reHumanos(returnNomArea): " + codArea);
        
        reHumanosServices reHumanosService = new reHumanosServices();
        String lista = reHumanosService.returnNomArea(codArea);
        wp.print("LISTA DE CARGOS - " + lista);
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 16-06-2022
     * @Descripcion : lista perfiles segun el area
    **************************************************************************
     */
    protected void listarPerfilesArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        String codArea = request.getParameter("codArea");
        int contar = 1;

        System.out.println("SERVLET reHumanos(listarPerfilesArea): " + codArea);

        reHumanosServices reHumanosService = new reHumanosServices();
        ArrayList<reHumanos> lista = reHumanosService.listarPerfilesArea(codArea);
        String colorEstado = "bg-success text-white p-1 rounded-3";
        for (reHumanos r : lista) {
            wp.print("<tr>"
                    + "  <td>" + contar + "</td>"
                    + "  <td>" + r.getDescArea() + "</td>"
                    + "  <td>" + r.getDescPerfil() + "</td>");
            if (!r.getDesEstado().equalsIgnoreCase("activo")) {
                colorEstado = "bg-danger text-white p-1 rounded-3";
            }
            wp.print( "  <td><span class=\" " + r.getDesEstado() +" "+ colorEstado + "\">" + r.getDesEstado() + "</span></td>"
                    + "  <td>" + r.getCodigoUsuario() + "</td>"
                    + "  <td>" + r.getFeCreacion() + "</td>"
                    + "  <td>"
                    + "       <a href='#' onclick=\"editPerfil(" + r.getCodigoPerfil() + ",'" + r.getDescPerfil() + "');\" title='Editar Perfil'><i class='fas fa-edit editar' ></i></a>"
                    + "       <a href='#' onclick=\"configurarRoles(" + r.getCodigoArea() + ",'" + r.getDescArea() + "'," + r.getCodigoPerfil() + ",'" + r.getDescPerfil() + "');\"  title='Configurar Permisos'><i class='far fa-address-card otras-opciones' ></i></a>"
                    + "       <a href='#' onclick='confirBorrarPerfil(" + r.getCodigoPerfil() + ");'><i class='far fa-trash-alt borrar'  title='Desactivar Perfil'></i>"
                    + "  </td>"
                    + "</tr>");
            contar = contar + 1;
        }
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 13-06-2022
     * @Descripcion : desactivar area
    **************************************************************************
     */
    protected void borrarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        HttpSession session_actual = request.getSession(true);
        String Usuario = (String) session_actual.getAttribute("usuario");
        String codArea = request.getParameter("codArea");

        System.out.println("SERVLET reHumanos(borrarArea):  ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String lista = reHumanosService.borrarArea(codArea, Usuario);
        wp.print(lista);
    }

    /**
     * *************************************************************************
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 13-06-2022
     * @Descripcion : actualizar datos del area
    **************************************************************************
     */
    protected void actualizarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        HttpSession session_actual = request.getSession(true);
        String Usuario = (String) session_actual.getAttribute("usuario");
        String codArea = request.getParameter("codArea");
        String nomArea = request.getParameter("nomArea");

        System.out.println("SERVLET reHumanos(actualizarArea):  ");

        reHumanosServices reHumanosService = new reHumanosServices();
        String lista = reHumanosService.actualizarArea(codArea, nomArea, Usuario);

        wp.print(lista);
    }

    /**
     * *************************************************************************
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 09-06-2022
     * @Descripcion : guarda las areas
    **************************************************************************
     */
    protected void guardarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        HttpSession session_actual = request.getSession(true);
        String Usuario = (String) session_actual.getAttribute("usuario");
        String nomArea = request.getParameter("nomArea");
        int contar = 1;

        reHumanosServices reHumanosService = new reHumanosServices();
        String lista = reHumanosService.guardarArea(nomArea, Usuario);
        wp.print(lista);
    }

    /**
     * *************************************************************************
     * @Autor : Bentu Condori Mamani
     * @fecha creacion: 2021-10-23
     * @Descripcion : lista las Áreas
    **************************************************************************
     */
    protected void listarAreas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wp = response.getWriter();
        //String codUsu = request.getParameter("codUsu");
        int contar = 1;

        System.out.println("SERVLET reHumanos(listarAreas): ");

        reHumanosServices reHumanosService = new reHumanosServices();
        ArrayList<reHumanos> lista = reHumanosService.listarAreas();
        for (reHumanos r : lista) {
            wp.print("<tr>"
                    + "  <td>" + contar + "</td>"
                    + "  <td>" + r.getDescArea() + "</td>"
                    + "  <td>" + r.getCodigoUsuario() + "</td>"
                    + "  <td>" + r.getFeCreacion() + "</td>"
                    + "  <td>"
                    + "       <a href='#' onclick=\"editArea(" + r.getCodigoArea() + ",'" + r.getDescArea() + "');\" title='Editar'><i class='fas fa-edit editar' ></i></a>"
                    //+ "       <a href=\"reHumanos/roles.jsp?codArea="+r.getCodigoArea()+"&nomArea="+r.getDescArea()+"\"  title='Agregar Perfiles o Cargos'><i class='far fa-address-card otras-opciones' ></i></a>"
                    + "       <a href='#' onclick='verRoles(" + r.getCodigoArea() + ")'  title='Agregar Perfiles o Cargos'><i class='far fa-address-card otras-opciones' ></i></a>"
                    + "       <a href='#' onclick='confirBorrarArea(" + r.getCodigoArea() + ");'><i class='far fa-trash-alt borrar'  title='Desactivar Area'></i>"
                    + "  </td>"
                    + "</tr>");
            contar = contar + 1;
        }
    }

    /**
     * ******************************************************************************
     * autor: bentu condori fecha: 26-05-2022 descripcion: funcion par el logins
     * del sistema
    ******************************************************************************
     */
    private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SERVLET USUARIO(Login)");
        String txtUsuario = request.getParameter("user");
        String txtContrasena = request.getParameter("clave");
        String res;

        reHumanosServices servicios = new reHumanosServices();

        System.out.println("SERVLET USUARIO(Login)" + txtUsuario);
        reHumanos seguridad = servicios.Login(txtUsuario, txtContrasena);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        System.out.println("RETORNO DE ORACLE");

        if ((seguridad.getCodMensaje()).equals("1")) {
            for (reHumanos u : seguridad.getListaUsuarios()) {
                HttpSession session_actual = request.getSession();
                session_actual.setAttribute("codigoUser", u.getCodigoUsuario());
                session_actual.setAttribute("usuario", u.getUsuario());
                /**
                 * ** redireccion de pagina de session ala pagina de inicio**
                 */
                session_actual.setAttribute("linMo", "../layout/home/inicio.jsp");
                session_actual.setAttribute("codMo", "1");

                System.out.println("Cod Usuario: " + u.getCodigoUsuario() + " Usuario: " + u.getUsuario());
            }

            res = seguridad.getCodMensaje();
        } else {
            res = seguridad.getCodMensaje();
        }

        System.out.println("seguridad: " + seguridad.getCodMensaje());
        pw.print("<input type='hidden' name='inicio' id='inicio' value='" + seguridad.getCodMensaje() + "'>");
    }

}
