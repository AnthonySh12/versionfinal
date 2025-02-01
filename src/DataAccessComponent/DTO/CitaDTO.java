package DataAccessComponent.DTO;

public class CitaDTO {
    private Integer idCita;
    private String NombreDoctor;
    private String ApellidoDoctor;
    private Integer idPersonaDoctor;
    private Integer idPersonaPaciente;
    private Integer idHoraCita;
    private Integer idEstadoCita;
    private String NombrePaciente;
    private String ApellidoPaciente;
    private String fechaCita;
    private String horaCita;
    private String observacion;
    private String estadoCita;
    private String fechaCreacion;
    private String fechaModificacion;

    public CitaDTO(){}

    public CitaDTO(Integer idCita ,String NombreDoctor ,String ApellidoDoctor,String NombrePaciente, String ApellidoPaciente, String fechaCita, String horaCita, String observacion, String estadoCita, String fechaCreacion, String fechaModificacion) {
        setIdCita(idCita);
        setNombreDoctor(NombreDoctor);
        setApellidoDoctor(ApellidoDoctor);
        setNombrePaciente(NombrePaciente);
        setApellidoPaciente(ApellidoPaciente);
        setFechaCita(fechaCita);
        setHoraCita(horaCita);
        setObservacion(observacion);
        setEstadoCita(estadoCita);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public CitaDTO(Integer idPersonaPaciente ,Integer idPersonaDoctor, String fechaCita, Integer idHoraCita, String observacion, Integer idEstadoCita) {
        setIdPersonaPaciente(idPersonaPaciente);
        setIdPersonaDoctor(idPersonaDoctor);
        setFechaCita(fechaCita);
        setIdHoraCita(idHoraCita);
        setObservacion(observacion);
        setIdEstadoCita(idEstadoCita);
    }

    public CitaDTO(Integer idCita, Integer idPersonaPaciente ,Integer idPersonaDoctor, String fechaCita, Integer idHoraCita, String observacion, Integer idEstadoCita) {
        setIdCita(idCita);
        setIdPersonaPaciente(idPersonaPaciente);
        setIdPersonaDoctor(idPersonaDoctor);
        setFechaCita(fechaCita);
        setIdHoraCita(idHoraCita);
        setObservacion(observacion);
        setIdEstadoCita(idEstadoCita);
    }



    public Integer getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public Integer getIdHoraCita() {
        return idHoraCita;
    }

    public void setIdHoraCita(Integer idHoraCita) {
        this.idHoraCita = idHoraCita;
    }


    public Integer getIdPersonaPaciente() {
        return idPersonaPaciente;
    }

    public void setIdPersonaPaciente(Integer idPersonaPaciente) {
        this.idPersonaPaciente = idPersonaPaciente;
    }

    public Integer getIdPersonaDoctor() {
        return idPersonaDoctor;
    }

    public void setIdPersonaDoctor(Integer idPersonaDoctor) {
        this.idPersonaDoctor = idPersonaDoctor;
    }
    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getNombreDoctor() {
        return NombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        NombreDoctor = nombreDoctor;
    }

    public String getApellidoDoctor() {
        return ApellidoDoctor;
    }

    public void setApellidoDoctor(String apellidoDoctor) {
        ApellidoDoctor = apellidoDoctor;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        NombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return ApellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        ApellidoPaciente = apellidoPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
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
        + "\n idCita             : "+ getIdCita           ()
        + "\n Doctor             : "+ getNombreDoctor     () + " " + getApellidoDoctor()
        + "\n Paciente           : "+ getNombrePaciente   () + " " + getApellidoPaciente()
        + "\n Fecha de la cita   : "+ getFechaCita        ()
        + "\n Hora de la cita    : "+ getHoraCita         ()
        + "\n Observación        : "+ getObservacion      ()
        + "\n Estado de la cita  : "+ getEstadoCita       ()
        + "\n FechaCreacion      : "+ getFechaCreacion    ()
        + "\n FechaModificacion  : "+ getFechaModificacion();
    }
}
