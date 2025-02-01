package BusinessLogic.entities;

import BusinessLogic.BLFactory;
import DataAccessComponent.DAO.CitaDAO;
import DataAccessComponent.DAO.PersonaDAO;
import DataAccessComponent.DTO.CitaDTO;
import DataAccessComponent.DTO.PersonaDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorCita {
    public List<Doctor> doctores;
    public List<Paciente> pacientes;
    public List<Cita> citas; 

    private PersonaDAO doctorBL;
    private PersonaDAO pacienteBL;
    private BLFactory<CitaDTO> citaBL;

        
    public GestorCita() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        
        doctorBL = new PersonaDAO();
        pacienteBL = new PersonaDAO();
        citaBL = new BLFactory<>(CitaDAO::new);

        cargar();  
    }

    public void cargar(){
        this.doctores.clear();
        this.pacientes.clear();
        this.citas.clear();

        Doctor daux;
        Paciente paux;
        Cita caux;
        try{
            List<PersonaDTO> docAux = doctorBL.readAllDoctors();
            List<PersonaDTO> pacAux = pacienteBL.readAllPatients();
            List<CitaDTO> citaAux = citaBL.getAll();


            for(PersonaDTO d: docAux){
                daux = new Doctor(d.getIdPersona(),d.getNombre(),d.getApellido(),
                                  d.getCedula(),d.getSexo(),d.getEstadoCivil(),
                                  d.getRol(),d.getEspecialidad(),d.getEdad(),d.getDireccion());
                this.doctores.add(daux);
            }
            
            for(PersonaDTO p: pacAux){
                paux = new Paciente(p.getIdPersona(),p.getNombre(),p.getApellido(),
                                  p.getCedula(),p.getSexo(),p.getEstadoCivil(),
                                  p.getRol(),p.getEspecialidad(),p.getEdad(),p.getDireccion());
                this.pacientes.add(paux);
            }   
            
            for(CitaDTO p: citaAux){
                caux = new Cita(p.getIdCita(),getPaciente(p.getNombrePaciente(), p.getApellidoPaciente()),
                                 getDoctor(p.getNombreDoctor(), p.getApellidoDoctor()),
                                 LocalDate.parse(p.getFechaCita()), p.getHoraCita(), p.getObservacion(), 
                                 p.getEstadoCita());
                this.citas.add(caux);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //método para añadir cita
    // SE USA EL CONSTRUCTOR 2 DE CITAS
    public void agendarCita(Cita cita){
        if(cita == null)
            return;
        try {
            citaBL.add(new CitaDTO(cita.getPaciente().getIdPersona(), cita.getDoctor().getIdPersona(), 
                        cita.getFechaCita().toString(), transNombreAID(cita.getHoraCita()), 
                        cita.getObservacion(), transNombreAID(cita.getEstadoCita())));
            } catch (Exception e) {
            System.out.println(e);
        }
        cargar();
    }  

    // metodo para actualizar cita

    // SE USA EL CONSTRUCTOR 1 DE CITAS
    public void actualizarCita(Cita cita){
        if(cita == null)
            return;
        try {
            citaBL.upd(new CitaDTO(cita.getIdCita(),cita.getDoctor().getIdPersona(), cita.getPaciente().getIdPersona(), 
                                   cita.getFechaCita().toString(), transNombreAID(cita.getHoraCita()), 
                                   cita.getObservacion(), transNombreAID(cita.getEstadoCita())));
        } catch (Exception e) {
            System.out.println(e);
        }
        cargar();
    } 

    // SOLO SE PASA EL ID
    public void eliminarCita(Integer id){
        if(id <= 0 || id > citas.size())
            return;
        try {
            citaBL.del(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        cargar();
    }

    private Doctor getDoctor(String nombre, String apellido) {
        if (doctores == null) {
            return null;
        }
        for (Doctor d : doctores) {
            if (d.getNombre().equals(nombre) && d.getApellido().equals(apellido)) {
                return d;
            }
        }
        return null; // Return null if no doctor is found
    }

    private Paciente getPaciente(String nombre, String apellido) {
        if (pacientes == null) {
            return null;
        }
        for (Paciente p : pacientes) {
            if (p.getNombre().equals(nombre) && p.getApellido().equals(apellido)) {
                return p;
            }
        }
        return null;
    }

    private Integer transNombreAID(String nombre) {
        Integer intaux = 0;
        if (nombre != null && !nombre.isEmpty()) {
            switch (nombre) {
                case "Agendada":
                    intaux = 1;
                    break;
                case "Cumplida":
                    intaux = 2;
                    break;
                case "No Cumplida":
                    intaux = 3;
                    break;
                case "8:00 TO 8:30":
                    intaux = 1;
                    break;
                case "8:30 TO 9:00":
                    intaux = 2;
                    break;
                case "9:00 TO 9:30":
                    intaux = 3;
                    break;
                case "9:30 TO 10:00":
                    intaux = 4;
                    break;
                case "10:00 TO 10:30":
                    intaux = 5;
                    break;
                case "10:30 TO 11:00":
                    intaux = 6;
                    break;
                case "11:00 TO 11:30":
                    intaux = 7;
                    break;
                case "11:30 TO 12:00":
                    intaux = 8;
                    break;
                case "12:00 TO 12:30":
                    intaux = 9;
                    break;
                case "12:30 TO 13:00":
                    intaux = 10;
                    break;
                case "13:00 TO 13:30":
                    intaux = 11;
                    break;
                case "13:30 TO 14:00":
                    intaux = 12;
                    break;
                case "14:00 TO 14:30":
                    intaux = 13;
                    break;
                case "14:30 TO 15:00":
                    intaux = 14;
                    break;
                case "15:00 TO 15:30":
                    intaux = 15;
                    break;
                case "15:30 TO 16:00":
                    intaux = 16;
                    break;
                case "16:00 TO 16:30":
                    intaux = 17;
                    break;
                case "16:30 TO 17:00":
                    intaux = 18;
                    break;
                default:
                    intaux = 0; // Valor por defecto si no coincide
                    break;
            }
        }
        return intaux; 
    }
    
}