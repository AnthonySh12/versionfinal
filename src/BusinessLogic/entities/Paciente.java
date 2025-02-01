package BusinessLogic.entities;

public class Paciente extends Persona{

    public Paciente(Integer idPersona, String nombre, String apellido, String cedula, String sexo, String estadoCivil,
            String rol, String especialidad, Integer edad, String direccion) {
        super(idPersona, nombre, apellido, cedula, sexo, estadoCivil, rol, especialidad, edad, direccion);
    }

    @Override
    public String toString(){
        return getClass().getName() 
        + "\n idPersona        : "+ getIdPersona        ()
        + "\n Nombre           : "+ getNombre           ()
        + "\n Apellido         : "+ getApellido         ()
        + "\n Cedula           : "+ getCedula           ()
        + "\n Sexo           : "+ getSexo             ()
        + "\n EstadoCivil    : "+ getEstadoCivil      ()
        + "\n Rol            : "+ getRol              ()
        + "\n Edad             : "+ getEdad             ()
        + "\n Direccion        : "+ getDireccion        ();
    }


}