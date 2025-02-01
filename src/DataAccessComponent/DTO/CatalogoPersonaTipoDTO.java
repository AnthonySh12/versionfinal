package DataAccessComponent.DTO;

public class CatalogoPersonaTipoDTO {
    private Integer idCatalogoPersonaTipo;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacion;

    public CatalogoPersonaTipoDTO(){}

    public CatalogoPersonaTipoDTO(String nombre){
        this.nombre = nombre;
    }

    public CatalogoPersonaTipoDTO(Integer idCPT, String nombre, String estado, String fechaCreacion, String fechaModificacion){
        setIdCatalogoPersonaTipo(idCPT);
        setNombre(nombre);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public Integer getIdCatalogoPersonaTipo() {
        return idCatalogoPersonaTipo;
    }
    public void setIdCatalogoPersonaTipo(Integer idCatalogoPersonaTipo) {
        this.idCatalogoPersonaTipo = idCatalogoPersonaTipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String toString(){
        return getClass().getName() 
        + "\n idCatalogoPersonaTipo: "+ getIdCatalogoPersonaTipo()
        + "\n Nombre               : "+ getNombre               ()
        + "\n Estado               : "+ getEstado               ()
        + "\n FechaCreacion        : "+ getFechaCreacion        ()
        + "\n FechaModificacion    : "+ getFechaModificacion    ();
    }

}
