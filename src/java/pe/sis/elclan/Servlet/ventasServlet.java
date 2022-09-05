/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.elclan.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        if ("listarUnidades".equals(request) ){
            listarUnidades(request, response);
        }
    }
    
    /**
     * *************************************************************************
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Autor : yasub huaman ramos
     * @fecha creacion: 29-07-2022
     * @Descripcion : listar unidades
     * @param request
     * @param response
    ***************************************************************************/
    public void listarUnidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/json");
//        System.out.println("SERVLET reHumanos(listaJustificacion): ");
//        String codAsistDet = request.getParameter("codAsistDet");
//        
//        reHumanosServices reHumanosService = new reHumanosServices();
//        reHumanos lista = reHumanosService.listaJustificacion(codAsistDet);   
//        //RESPUESTA TYPE-JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(lista);
//        response.getWriter().write(json);
    }
    
    
    
}
