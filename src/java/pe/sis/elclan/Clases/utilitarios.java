
package pe.sis.elclan.Clases;
/**
 *
 * @author bcondori
 */
import java.util.ArrayList;
import java.util.List;

public class utilitarios {
    /***tipo de documento*/
    String utCodTipoDoc;
    String utTipoDoc;
    String utTipoDocEstado;
    String utTipoDocFeCreacion;
    String utTipoDocUsCreacion;
    String utCodigoMensaje;
    String utMensaje;
    
    /*****variable comunes*/
    String utCodigo;
    String utDescripcion;

    public String getUtCodigo() {
        return utCodigo;
    }

    public void setUtCodigo(String utCodigo) {
        this.utCodigo = utCodigo;
    }

    public String getUtDescripcion() {
        return utDescripcion;
    }

    public void setUtDescripcion(String utDescripcion) {
        this.utDescripcion = utDescripcion;
    }
    
    private ArrayList<utilitarios> lista1;

    public String getUtCodTipoDoc() {
        return utCodTipoDoc;
    }

    public void setUtCodTipoDoc(String utCodTipoDoc) {
        this.utCodTipoDoc = utCodTipoDoc;
    }

    public String getUtTipoDoc() {
        return utTipoDoc;
    }

    public void setUtTipoDoc(String utTipoDoc) {
        this.utTipoDoc = utTipoDoc;
    }

    public String getUtTipoDocEstado() {
        return utTipoDocEstado;
    }

    public void setUtTipoDocEstado(String utTipoDocEstado) {
        this.utTipoDocEstado = utTipoDocEstado;
    }

    public String getUtTipoDocFeCreacion() {
        return utTipoDocFeCreacion;
    }

    public void setUtTipoDocFeCreacion(String utTipoDocFeCreacion) {
        this.utTipoDocFeCreacion = utTipoDocFeCreacion;
    }

    public String getUtTipoDocUsCreacion() {
        return utTipoDocUsCreacion;
    }

    public void setUtTipoDocUsCreacion(String utTipoDocUsCreacion) {
        this.utTipoDocUsCreacion = utTipoDocUsCreacion;
    }

    public ArrayList<utilitarios> getLista1() {
        return lista1;
    }

    public void setLista1(ArrayList<utilitarios> lista1) {
        this.lista1 = lista1;
    }

    public String getUtCodigoMensaje() {
        return utCodigoMensaje;
    }

    public void setUtCodigoMensaje(String utCodigoMensaje) {
        this.utCodigoMensaje = utCodigoMensaje;
    }

    public String getUtMensaje() {
        return utMensaje;
    }

    public void setUtMensaje(String utMensaje) {
        this.utMensaje = utMensaje;
    }
    
    
}
