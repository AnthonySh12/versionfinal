package BusinessLogic.entities;

public abstract class Persona {
    Integer idPersona;
    String nombre;
    String apellido;
    String cedula;
    String sexo;
    String estadoCivil;
    String rol;
    String especialidad;
    Integer edad;
    String direccion;

    public Persona(Integer idPersona, String nombre, String apellido, String cedula, String sexo, String estadoCivil,
            String rol, String especialidad, Integer edad, String direccion) {
                setIdPersona(idPersona);
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
        if(idPersona <= 0){
            this.idPersona = 999;
        } else {
            this.idPersona = idPersona;
        }
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty())
            this.nombre = "NombreComun";
        else
            this.nombre = nombre;

    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        if(apellido == null || apellido.isEmpty())
        this.apellido = "ApellidoComun";
            else
        this.apellido = apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        if(cedula == null || cedula.isEmpty())
            return;
        else
            this.cedula = cedula;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        if(sexo == null || sexo.isEmpty())
            this.sexo = "No Definido";
        else
            this.sexo = sexo;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        if(estadoCivil == null || estadoCivil.isEmpty())
            this.estadoCivil = "Soltero";
        else
            this.estadoCivil = estadoCivil;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        if(rol == null || rol.isEmpty())
            this.rol = "Paciente";
            else
            this.rol = rol;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        if(especialidad == null || especialidad.isEmpty())
            this.especialidad = "No especialidad";
        else
            this.especialidad = especialidad;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        if(edad <= 0){
            this.edad = 100;
        } else {
            this.edad = edad;
        }
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        if(this.direccion == null || this.direccion.isEmpty())
            this.direccion = "DireccionComun";
        else
            this.direccion = direccion;

    }


}
