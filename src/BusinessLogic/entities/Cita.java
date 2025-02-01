package BusinessLogic.entities;

import java.time.LocalDate;

public class Cita {
    Integer idCita;
    Doctor doctor;
    Paciente paciente;
    LocalDate fechaCita;
    String horaCita;
    String observacion;
    String estadoCita;


    // Contructor 1
    public Cita(Integer idCita, Paciente paciente, Doctor doctor, LocalDate fechaCita, String horaCita,
                String observacion, String estadoCita) {
        setIdCita(idCita);
        setDoctor(doctor);
        setPaciente(paciente);
        setFechaCita(fechaCita);
        setHoraCita(horaCita);
        setObservacion(observacion);
        setEstadoCita(estadoCita);
    }

    // Constructor 2

    public Cita(Paciente paciente, Doctor doctor, LocalDate fechaCita, String horaCita,
                String observacion, String estadoCita) {
        setDoctor(doctor);
        setPaciente(paciente);
        setFechaCita(fechaCita);
        setHoraCita(horaCita);
        setObservacion(observacion);
        setEstadoCita(estadoCita);
    }

    public void marcarCitaInvalida(){
        if(!getEstadoCita().equals("No Cumplida"))
            setEstadoCita("No Cumplida");
    }

    public void marcarCitaCumplida(){
        if(!getEstadoCita().equals("Cumplida"))
            setEstadoCita("Cumplida");
    }

    public Integer getIdCita() {
        return idCita;
    }
    public void setIdCita(Integer idCita) {
        if(idCita <= 0)
            this.idCita = 999;    
        else
            this.idCita = idCita;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        if(doctor != null)
            this.doctor = doctor;
        else
            return;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        if(paciente != null)
            this.paciente = paciente;
        else
            return;
    }
    public LocalDate getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(LocalDate fechaCita) {
        if(fechaCita == null)
            this.fechaCita = LocalDate.now();
        else
            this.fechaCita = fechaCita;
    }
    public String getHoraCita() {
        return horaCita;
    }
    public void setHoraCita(String hora) {
        if(hora == null || hora.isEmpty())
        this.horaCita = "00:00";
    else
        this.horaCita = hora;
    }

    public String getEstadoCita() {
        return estadoCita;
    }
    public void setEstadoCita(String estadoCita) {
        if((estadoCita != null) && (estadoCita.equals("Agendada") || estadoCita.equals("Cumplida")  || estadoCita.equals("No Cumplida")))
            this.estadoCita = estadoCita;
        else
            this.estadoCita = "Agendada";
    }
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        if(observacion != null)
        this.observacion = observacion;
    else
        this.observacion = "No hay observacion";
    }

    public String toString(){
        return getClass().getName() 
        + "\n idCita             : "+ getIdCita           ()
        + "\n Doctor             : "+ getDoctor().getNombre() + " " + getDoctor().getApellido()
        + "\n Paciente           : "+ getPaciente().getNombre() + " " + getPaciente().getApellido()
        + "\n Fecha de la cita   : "+ getFechaCita        ()
        + "\n Hora de la cita    : "+ getHoraCita         ()
        + "\n Observación        : "+ getObservacion      ()
        + "\n Estado de la cita  : "+ getEstadoCita       ();
    }
}
