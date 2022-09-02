package pe.sis.elclan.Services;

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
    
    
    /*  EXAMPLE OF SERVICE */
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 02-09-2022
    descripcion: service: listar justificaciones
     * @param codAsistDet
     * @return 
    ******************************************************************************/
   /* public reHumanos listaJustificacion(String codAsistDet){
        reHumanos lista = null;
        System.out.println("SERVICE reHumanosService(listaJustificacion)");
        try {  
           lista = objReHumanosDAO.listaJustificacion(codAsistDet);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaJustificacion) : " + e.getMessage());
         }
        return lista;
    }  */
        
}
