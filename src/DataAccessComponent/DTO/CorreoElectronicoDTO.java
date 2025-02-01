package DataAccessComponent.DTO;

public class CorreoElectronicoDTO{
    private Integer idCorreo;
    private Integer idPersona;
    private String  correo;
    private String  persona;
    private String  estado;
    private String  fechaCreacion;
    private String  fechaModificacion;

    public CorreoElectronicoDTO(){}

    public CorreoElectronicoDTO(String correo, Integer idPersona, String persona, String estado, String fechaCreacion, String fechaModificacion) {
        this.correo = correo;
        this.idPersona = idPersona;
    }

    public CorreoElectronicoDTO(String correo, String persona){
        this.correo = correo;
        this.persona = persona;
    }

    public CorreoElectronicoDTO(Integer idC, Integer idP, String correo, String persona, String estado, String fechaCreacion, String fechaModificacion){
        setIdCorreo(idC);
        setIdPersona(idP);
        setCorreo(correo);
        setPersona(persona);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreoElectronico) {
        this.idCorreo = idCorreoElectronico;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
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
        + "\n idCorreoElectronico: "+ getIdCorreo          ()      
        + "\n Correo             : "+ getCorreo             ()
        + "\n Persona            : "+ getPersona            ()
        + "\n Estado             : "+ getEstado             ()
        + "\n FechaCreacion      : "+ getFechaCreacion      ()
        + "\n FechaModificacion  : "+ getFechaModificacion  ();
    }
}
