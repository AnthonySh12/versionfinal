package DataAccessComponent.DAO;

import DataAccessComponent.DTO.CitaDTO;
import DataAccessComponent.IDAO;
import DataAccessComponent.SQLiteDataHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO extends SQLiteDataHelper implements IDAO<CitaDTO> {
    @Override
    public CitaDTO readBy(Integer id) throws Exception {
        CitaDTO cd = new CitaDTO();
                String query ="SELECT c.idCita                                                                      "
                            + " ,idD.nombre                                                                          "
                            + " ,idD.apellido                                                                        "
                            + " ,idP.nombre                                                                          "
                            + " ,idP.apellido                                                                        "
                            + " ,c.fechaCita                                                                         "
                            + " ,ho.hora                                                                             "
                            + " ,c.observacion                                                                       "
                            + " ,ec.descripcion                                                                          "
                            + " ,c.fechaCreacion                                                                     "
                            + " ,c.fechaModificacion                                                                 "
                            + " FROM Cita c                                                                          "
                            + " INNER JOIN Persona as idD ON c.idPersonaDoctor = idD.idPersona                       "
                            + " INNER JOIN Persona as idP ON c.idPersonaPaciente = idP.idPersona                     "
                            + " INNER JOIN HoraCita as ho ON c.idHoraCita = ho.idHoraCita                            "
                            + " INNER JOIN EstadoCita as ec ON c.idEstadoCita = ec.idEstadoCita                      "
                            + "AND c.idCita = " + id.toString() ;

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cd = new CitaDTO(rs.getInt(1)
                               , rs.getString(2)
                               , rs.getString(3)
                               , rs.getString(4)
                               , rs.getString(5)
                               , rs.getString(6)
                               , rs.getString(7)
                               , rs.getString(8)
                               , rs.getString(9)
                               , rs.getString(10)
                               , rs.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cd;
    }

    @Override
    public List<CitaDTO> readAll() throws Exception {
        List<CitaDTO> lst = new ArrayList<>();
        String query ="SELECT  c.idCita                                                     "
                    + " ,idD.nombre                                                         "
                    + " ,idD.apellido                                                       "
                    + " ,idP.nombre                                                         "
                    + " ,idP.apellido                                                       "
                    + " ,c.fechaCita                                                        "
                    + " ,ho.hora                                                            "
                    + " ,c.observacion                                                      "
                    + " ,ec.descripcion                                                     "
                    + " ,c.fechaCreacion                                                    "
                    + " ,c.fechaModificacion                                                "
                    + " FROM Cita c                                                         "
                    + " INNER JOIN Persona as idD ON c.idPersonaDoctor = idD.idPersona      "
                    + " INNER JOIN Persona as idP ON c.idPersonaPaciente = idP.idPersona    "
                    + " INNER JOIN HoraCita as ho ON c.idHoraCita = ho.idHoraCita           "
                    + " INNER JOIN EstadoCita as ec ON c.idEstadoCita = ec.idEstadoCita     ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CitaDTO c = new CitaDTO(rs.getInt(1)
                                      , rs.getString(2)
                                      , rs.getString(3)
                                      , rs.getString(4)
                                      , rs.getString(5)
                                      , rs.getString(6)
                                      , rs.getString(7)
                                      , rs.getString(8)
                                      , rs.getString(9)
                                      , rs.getString(10)
                                      , rs.getString(11));

                lst.add(c);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Cita (idPersonaPaciente, idPersonaDoctor, fechaCita, idHoraCita, observacion, idEstadoCita, fechaModificacion)VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaPaciente());
            pstmt.setInt(2, entity.getIdPersonaDoctor());
            pstmt.setString(3, entity.getFechaCita());
            pstmt.setInt(4, entity.getIdHoraCita());
            pstmt.setString(5, entity.getObservacion());
            pstmt.setInt(6, entity.getIdEstadoCita());
            pstmt.setString(7, now.format(dtf).toString());
    
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Cita SET idPersonaPaciente = ?, idPersonaDoctor = ?, fechaCita = ?, idHoraCita = ?,"
                + "Observacion = ?, idEstadoCita = ?, fechaModificacion = ? WHERE idCita = ?";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaPaciente());
            pstmt.setInt(2, entity.getIdPersonaDoctor());
            pstmt.setString(3, entity.getFechaCita());
            pstmt.setInt(4, entity.getIdHoraCita());
            pstmt.setString(5, entity.getObservacion());
            pstmt.setString(6, entity.getEstadoCita());
            pstmt.setString(7, now.format(dtf).toString());
            pstmt.setInt(8, entity.getIdCita());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; 
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Cita SET idEstadoCita = ? WHERE idCita = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM Cita "
                    + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } 
        catch (SQLException e) {
            throw e; 
        }
        return 0;
    }
}