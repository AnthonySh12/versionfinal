package DataAccessComponent.DTO;

public class TelefonoDTO {
    private Integer idTelefono;
    private Integer idPersona;
    private String  numero;
    private String  persona;
    private String  estado;
    private String  fechaCreacion;
    private String  fechaModificacion;

    public TelefonoDTO(){}

    public TelefonoDTO(String numero, Integer idPersona){
        this.numero = numero;
        this.idPersona = idPersona;
    }

    public TelefonoDTO(String numero, String persona){
        this.numero = numero;
        this.persona = persona;
    }

    public TelefonoDTO(Integer idT, Integer idP, String numero, String persona, String estado, String fechaCreacion, String fechaModificacion){
        setIdTelefono(idT);
        setIdPersona(idP);
        setNumero(numero);
        setPersona(persona);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        + "\n idTelefono       : "+ getIdTelefono       ()
        + "\n Numero           : "+ getNumero           ()
        + "\n Persona          : "+ getPersona          ()
        + "\n Estado           : "+ getEstado           ()
        + "\n FechaCreacion    : "+ getFechaCreacion    ()
        + "\n FechaModificacion: "+ getFechaModificacion();
    }
}
