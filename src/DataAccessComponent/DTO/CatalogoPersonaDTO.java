package DataAccessComponent.DTO;

public class CatalogoPersonaDTO {
    private Integer idCatalogoPersona;
    private String  nombre;
    private String  estado;
    private String  fechaCreacion;
    private String  fechaModificacion;
    private String  catalogoPersonaTipo;

    public CatalogoPersonaDTO(){};

    public CatalogoPersonaDTO(String nombre, String catalogoPersonaTipo) {
        this.nombre = nombre;
    }

    public CatalogoPersonaDTO(Integer idCP, String nombre, String estado, String fechaCreacion, String fechaModificacion, String idCPT){
        setIdCatalogoPersona(idCP);
        setNombre(nombre);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
        setCatalogoPersonaTipo(idCPT);
    }

    public Integer getIdCatalogoPersona() {
        return idCatalogoPersona;
    }

    public void setIdCatalogoPersona(Integer idCatalogoPersona) {
        this.idCatalogoPersona = idCatalogoPersona;
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
    public String getCatalogoPersonaTipo() {
        return catalogoPersonaTipo;
    }
    public void setCatalogoPersonaTipo(String CatalogoPersonaTipo) {
        this.catalogoPersonaTipo = CatalogoPersonaTipo;
    }

    public String toString(){
        return getClass().getName() 
        + "\n idCatalogoPersona    : "+ getIdCatalogoPersona    ()
        + "\n Nombre               : "+ getNombre               ()
        + "\n Estado               : "+ getEstado               ()
        + "\n FechaCreacion        : "+ getFechaCreacion        ()
        + "\n FechaModificacion    : "+ getFechaModificacion    ()
        + "\n CatalogoPersonaTipo  : "+ getCatalogoPersonaTipo();
    }

}
