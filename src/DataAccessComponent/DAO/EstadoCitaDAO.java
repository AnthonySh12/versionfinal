package DataAccessComponent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.IDAO;
import DataAccessComponent.SQLiteDataHelper;
import DataAccessComponent.DTO.EstadoCitaDTO;
// import static javax.swing.UIManager.getString;

public class EstadoCitaDAO extends SQLiteDataHelper implements IDAO<EstadoCitaDTO> {
    @Override
    public EstadoCitaDTO readBy(Integer id) throws Exception {
        EstadoCitaDTO eC = null;
        String query = " SELECT idEstadoCita                         "
                + " ,nombre                                     "
                + " ,descripcion                                "
                + " ,estado                                     "
                + " ,fechaCreacion                              "
                + " ,fechaModificacion                          "
                + " FROM EstadoCita                             "
                + " WHERE   Estado ='A'   AND IdEstadoCita =    " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                eC = new EstadoCitaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            throw e;
        }
        return eC;
    }

    @Override
    public List<EstadoCitaDTO> readAll() throws Exception {
        List<EstadoCitaDTO> lst = new ArrayList<>();
        String query = " SELECT idEstadoCita       "
                + " ,nombre                   "
                + " ,descripcion              "
                + " ,estado                   "
                + " ,fechaCreacion            "
                + " ,fechaModificacion        "
                + " FROM EstadoCita           "
                + " WHERE   Estado ='A'       ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                EstadoCitaDTO ec = new EstadoCitaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                lst.add(ec);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(EstadoCitaDTO entity) throws Exception {
        String query = " INSERT INTO EstadoCita (idEstadoCita, Nombre, Descripcion, Estado, FechaCreacion, FechaModificacion) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(EstadoCitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE HoraCita SET idHoraCita = ?, Hora = ?, Estado = ?, FechaCreacion = ?,"
                + "fechaModificacion = ?, WHERE idHoraCita = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdEstadoCita());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE EstadoCita SET Estado = ? WHERE IdEstadoCita = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM EstadoCita "
                + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

}
