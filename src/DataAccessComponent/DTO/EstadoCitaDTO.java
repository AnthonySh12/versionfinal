package DataAccessComponent.DTO;

public class EstadoCitaDTO {
    private Integer idEstadoCita;
    private String nombre;
    private String descripcion;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacion;

    public EstadoCitaDTO(){}

    public EstadoCitaDTO(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EstadoCitaDTO(Integer idEC, String nombre, String descripcion, 
                         String estado, String fechaCreacion, String fechaModificacion){
        setIdEstadoCita(idEC);
        setNombre(nombre);
        setDescripcion(descripcion);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public Integer getIdEstadoCita() {
        return idEstadoCita;
    }
    public void setIdEstadoCita(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        + "\n idEstadoCita         : "+ getIdEstadoCita     ()
        + "\n Nombre               : "+ getNombre           ()
        + "\n Descripcion          : "+ getDescripcion      ()
        + "\n Estado               : "+ getEstado           ()
        + "\n FechaCreacion        : "+ getFechaCreacion    ()
        + "\n FechaModificacion    : "+ getFechaModificacion();
    }

}

