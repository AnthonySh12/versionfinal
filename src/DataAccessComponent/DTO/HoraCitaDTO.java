package DataAccessComponent.DTO;

public class HoraCitaDTO {
    private Integer idHoraCita;
    private String  hora;
    private String  estado;
    private String  fechaCreacion;
    private String  fechaModificacion;

    public HoraCitaDTO(){}

    public HoraCitaDTO(String hora){
        this.hora = hora;
    }

    public HoraCitaDTO(Integer idHC, String hora, 
                         String estado, String fechaCreacion, 
                         String fechaModificacion){
        setIdHoraCita(idHC);
        setHora(hora);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public Integer getIdHoraCita() {
        return idHoraCita;
    }
    public void setIdHoraCita(Integer idHoraCita) {
        this.idHoraCita = idHoraCita;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
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
        + "\n idHoraCita        : "+ getIdHoraCita       ()
        + "\n Hora              : "+ getHora             ()
        + "\n Estado            : "+ getEstado           ()
        + "\n FechaCreacion     : "+ getFechaCreacion    ()
        + "\n FechaModificacion : "+ getFechaModificacion();
    }
}
