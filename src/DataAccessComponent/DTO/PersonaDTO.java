package DataAccessComponent.DTO;

public class PersonaDTO {
    private Integer idPersona;
    private String  nombre;
    private String  apellido;
    private String  cedula;
    private String  sexo;
    private String  estadoCivil;
    private String  rol;
    private String  especialidad;
    private Integer edad;
    private String  direccion;
    private String  estado;
    private String  fechaCreacion;
    private String  fechaModificacion;

    public PersonaDTO(){};

    public PersonaDTO(Integer idP, String nombre, String apellido, String cedula,
                      String sexo, String estadoCivil, String rol, 
                      String especialidad, Integer edad, String direccion,
                      String estado, String fechaCreacion,String fechaModificacion){
        setIdPersona(idP);
        setNombre(nombre);
        setApellido(apellido);
        setCedula(cedula);
        setSexo(sexo);
        setEstadoCivil(estadoCivil);
        setRol(rol);
        setEspecialidad(especialidad);
        setEdad(edad);
        setDireccion(direccion);
        setEstado(estado);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }

    public PersonaDTO(String nombre, String apellido, String cedula,
                      String sexo, String estadoCivil, String rol, 
                      String especialidad, Integer edad, String direccion){
        setNombre(nombre);
        setApellido(apellido);
        setCedula(cedula);
        setSexo(sexo);
        setEstadoCivil(estadoCivil);
        setRol(rol);
        setEspecialidad(especialidad);
        setEdad(edad);
        setDireccion(direccion);
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        + "\n idPersona        : "+ getIdPersona        ()
        + "\n Nombre           : "+ getNombre           ()
        + "\n Apellido         : "+ getApellido         ()
        + "\n Cedula           : "+ getCedula           ()
        + "\n Sexo           : "+ getSexo             ()
        + "\n EstadoCivil    : "+ getEstadoCivil      ()
        + "\n Rol            : "+ getRol              ()
        + "\n Especialidad   : "+ getEspecialidad     ()
        + "\n Edad             : "+ getEdad             ()
        + "\n Direccion        : "+ getDireccion        ()
        + "\n Estado           : "+ getEstado           ()
        + "\n FechaCreacion    : "+ getFechaCreacion    ()
        + "\n FechaModificacion: "+ getFechaModificacion();
    }
}
