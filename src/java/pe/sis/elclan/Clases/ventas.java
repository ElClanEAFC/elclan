
package pe.sis.elclan.Clases;

/**
 *
 * @author sistemas03
 */
public class ventas {
    
    /* GENERAL*/
    private String usuarioCreacion;   
    private String fechaCreacion;  
    private String estado;
    
    /* UNIDADES DE VENTAS */
    private String codUnidad;
    private String desUnidad;
        
   /*  EQUIPO DE VENTAS */
    private String codEquipo;
    private String desEquipo;

    
    /* METODOS GET Y SET*/
    
    public String getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getDesUnidad() {
        return desUnidad;
    }

    public void setDesUnidad(String desUnidad) {
        this.desUnidad = desUnidad;
    }

    public String getDesEquipo() {
        return desEquipo;
    }

    public void setDesEquipo(String desEquipo) {
        this.desEquipo = desEquipo;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    
}
