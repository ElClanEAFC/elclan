
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
import pe.sis.elclan.Clases.mantenimiento;
import pe.sis.elclan.Services.mantenimientoServices;

/**
 *
 * @author bcondori
 */
public class mantenimientoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("Accion");
        System.out.println("SERVLET mantenimiento(Accion): "+param);
        if(("listarMenu").equals(param)){
            listarMenu(request, response);
        }else if(("listarPerfil").equals(param)){
            listarPerfil(request, response);
        }else if(("direcPagina").equals(param)){
            direcPagina(request, response);
        }else if(("cerrarsession").equals(param)){
            cerrarsession(request, response);
        }
    }
    
    private void direcPagina(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String codModu = request.getParameter("codModu");
        String linkPag = request.getParameter("link");
        String nemo    = request.getParameter("nemo");
        String cod1    = request.getParameter("cod1");
        String cod2    = request.getParameter("cod2");
        System.out.println("link: "+linkPag);
        
        HttpSession session_actual = request.getSession();
        session_actual.setAttribute("linMo", linkPag);
        session_actual.setAttribute("codMo", codModu);
        session_actual.setAttribute("cod1", cod1);
        session_actual.setAttribute("cod2", cod2 );
        System.out.println("===================== LOS CODIGOS AREA Y PERFIL " + cod1 +" " + cod2);
        out.print(linkPag);
    }

    protected void listarMenu(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("SERVLET mantenimiento(listarMenu): ");
        String codUsuario = request.getParameter("codUser");
        String usuario = request.getParameter("nomUser");
        String linkModulo;
        String classA;
        String url = "javaWeb/vistas/layout/";
        String urlpri = "";
        String variable = "";
        String funcion  = "";
        mantenimientoServices seguridadService = new mantenimientoServices();
        mantenimiento lista = seguridadService.listarMenu(codUsuario);
        
//      DATA TYPE JSON
        ObjectMapper mapper = new ObjectMapper();
        
        ArrayList<mantenimiento> listamodulo = lista.getListaModulos();
        
        ArrayList<mantenimiento> listaMenu= new ArrayList<>();
//        listaMenu = new ArrayList<>();
        for (mantenimiento mo : listamodulo) {
            ArrayList<mantenimiento> lisSub = seguridadService.listarSubMenu(codUsuario,mo.getCodModulo());
            if(!lisSub.isEmpty()){
                mo.setListaSubModulos(lisSub);                
            }
            listaMenu.add(mo);
        }
        
        String json = mapper.writeValueAsString(listaMenu);
        System.out.println("JSON =>>>> "+json );
        response.getWriter().write(json);
        
        
//        out.print("<p><hr></p>");
//        out.print("<ul id='sidebarnav' class='pt-4'>");
//        for(mantenimiento me : lista.getListaModulos()){
//            System.out.println("-------Modulo: "+me.getDesModulo()+" - "+me.getCanSubModulo()+"------");
//            if((me.getCanSubModulo()).equals("0"))
//            {
//                out.print("<input type='hidden' name='codModul' id='codModul' value="+me.getCodModulo()+">");
//                
//                linkModulo = me.getLinkModulo();
//                classA     = "sidebar-link waves-effect waves-dark sidebar-link";
//                variable   = me.getCodModulo()+",'"+me.getModNemo()+"','"+linkModulo;
//                
//                funcion    = "direcPagina(1,'"+me.getModNemo()+"','../"+linkModulo+"')";
//                //urlpri     = "../"+me.getLinkModulo();
//            }else{
//                linkModulo = "javascript:subMenu()";
//                classA     = "sidebar-link has-arrow waves-effect waves-dark";
//                variable   = "";
//                funcion    = "subMenu()";
//                /*if((me.getLinkModulo()).equals("#"))
//                {
//                    urlpri = "#";
//                }else{
//                    urlpri = "javascript:subMenu()";
//                }*/
//            }
            
//            System.out.println("link: "+urlpri);
//            out.print("<li class='sidebar-item'> "
//                +  "<a class='sidebar-link waves-effect waves-dark sidebar-link' href='#' onclick=\""+funcion+"\" aria-expanded='false'>"
//                +     "<i class='"+me.getIcoModulo()+"'>"
//                +     "</i><span class=\'hide-menu\'>"+me.getDesModulo()+"</span></a>");
//                    if((me.getCanSubModulo()).equals("0"))
//                    {
//                        System.out.println("no tiene sub modulo");
//                    }else{
//                        System.out.println("cod_usu: "+codUsuario+" codModu: "+me.getCodModulo());
//                        out.print("<ul aria-expanded=\"false\" class=\"collapse  first-level\">");
//                            ArrayList<mantenimiento> lisSub = seguridadService.listarSubMenu(codUsuario,me.getCodModulo());
//                            for(mantenimiento su: lisSub){
//                            System.out.println("sub modulo: "+su.getDesSubModulo()+" - "+su.getLinkSubModulo());
//                            //funcion    = "direcPagina(2,'"+me.getModNemo()+"','../"+su.getLinkSubModulo()+"')";
//                            funcion    = "ROUTER.load('/elclan/vistas/layout/sedes')";
//                            out.print("<input type='hidden' name='codSubModul' id='codSubModul' value="+su.getCodSubModulo()+">");
//                            out.print("<li class='sidebar-item'>"
//                                    + "     <a href='#' onclick=\""+funcion+"\" class='sidebar-link' >"
//                                    //+"	   <i class='mdi mdi-note-outline'></i>"
//                                    +"         <span class=\'hide-menu\'> "
//                                    +"		"+su.getDesSubModulo()+""
//                                    +"	   </span>"
//                                    +"	</a>"
//                                    +"</li>");
//                            }
//                        out.print("</ul>");
//                    }
//            out.print("</li>");
//        }
//        
//        out.print("</ul>");
        
        
    }

    private void listarPerfil(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        HttpSession session = request.getSession();
        session.invalidate();

    }

}
