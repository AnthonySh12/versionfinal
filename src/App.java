
import java.awt.SplashScreen;
import java.time.LocalDate;
import java.time.Month;

import BusinessLogic.entities.Cita;
import BusinessLogic.entities.GestorCita;
import DataAccessComponent.DAO.CitaDAO;
import DataAccessComponent.DTO.CitaDTO;
import UserInterface.Form.MainPanel;

public class App {
    public static void main(String[] args) throws Exception {

/*         try {
            PersonaDAO pDao = new PersonaDAO();
            // s.
            for (PersonaDTO p : pDao.readAll())
                System.out.println(p.toString());
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            CatalogoPersonaTipoDAO cDao = new CatalogoPersonaTipoDAO();
            for (CatalogoPersonaTipoDTO x : cDao.readAll())
                System.out.println(x.toString());
            System.out.println("-------------");

        } catch (Exception e) {
            throw e;
        }

        try {
            CatalogoPersonaDAO cvDao = new CatalogoPersonaDAO();
            for (CatalogoPersonaDTO c : cvDao.readAll())
                System.out.println(c.toString());
            System.out.println("-------------");

        } catch (Exception e) {
            throw e;
        }

        try {
            EstadoCitaDAO ecDao = new EstadoCitaDAO();
            // s.
            for (EstadoCitaDTO ec : ecDao.readAll())
                System.out.println(ec.toString());
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            CorreoElectronicoDAO aDao = new CorreoElectronicoDAO();
            // s.
            for (CorreoElectronicoDTO a : aDao.readAll())
                System.out.println(a.toString());
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            TelefonoDAO tDao = new TelefonoDAO();
            // s.
            for (TelefonoDTO t : tDao.readAll())
                System.out.println(t.toString());
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            HoraCitaDAO hDao = new HoraCitaDAO();
            // s.
            for (HoraCitaDTO h : hDao.readAll())
                System.out.println(h.toString());
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println(e.toString());
        } */

        //GestorCita gc = new GestorCita();
//
        //System.out.println(gc.doctores.get(2));
        //System.out.println(gc.pacientes.get(1));
//
        //Cita citaAux = new Cita(gc.pacientes.get(1), gc.doctores.get(2),LocalDate.of(2026, Month.MAY, 2), "8:00 TO 8:30", "", "Agendada");
//
        //gc.agendarCita(citaAux);
        //gc.eliminarCita(52);
//
        //Cita citaAux2 = new Cita(2,gc.pacientes.get(1), gc.doctores.get(2),LocalDate.of(2026, Month.MAY, 2), "8:00 TO 8:30", "", "Agendada");
        //gc.actualizarCita(citaAux2);

        //SplashScreen.show();
        new MainPanel();

    }
}
