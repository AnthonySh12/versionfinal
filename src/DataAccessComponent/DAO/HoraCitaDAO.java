package DataAccessComponent.DAO;

import DataAccessComponent.SQLiteDataHelper;
import DataAccessComponent.DTO.HoraCitaDTO;
import DataAccessComponent.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class HoraCitaDAO  extends SQLiteDataHelper implements IDAO<HoraCitaDTO> {

    @Override
    public HoraCitaDTO readBy(Integer id) throws Exception {
        HoraCitaDTO cH = new HoraCitaDTO();
        String query =" SELECT idHoraCita                        "
                     +" ,hora                                    "
                     +" ,estado                                  "
                     +" ,fechaCreacion                           "
                     +" ,fechaModificacion                       "
                     +" FROM HoraCita                            "
                     +" WHERE   Estado ='A'  AND IdHoraCita =    " + id.toString() ;
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                cH = new HoraCitaDTO(rs.getInt(1)
                                ,rs.getString(2)
                                ,rs.getString(3)
                                ,rs.getString(4)
                                ,rs.getString(5));
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return cH;
    }

    @Override
    public List<HoraCitaDTO> readAll() throws Exception {
        List <HoraCitaDTO> lst = new ArrayList<>();
        String query =" SELECT idHoraCita       "
                     +" ,hora                   "
                     +" ,estado                 "
                     +" ,fechaCreacion          "
                     +" ,fechaModificacion      "
                     +" FROM HoraCita           "
                     +" WHERE   Estado ='A'     ";

    try {
        Connection conn = openConnection();
        Statement  stmt = conn.createStatement();
        ResultSet  rs   = stmt.executeQuery(query);
        while (rs.next()) {
            HoraCitaDTO hc = new HoraCitaDTO( rs.getInt(1)
                                    ,rs.getString(2)
                                    ,rs.getString(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5));
            lst.add(hc);
        }
    }
    catch (SQLException e) {
        throw e; 
    }
    return lst;
}

    @Override
    public boolean create(HoraCitaDTO entity) throws Exception {
        String query = " INSERT INTO HoraCita (idHoraCita, Hora, Estado, FechaCreacion, FechaModificacion) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getHora());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(HoraCitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE HoraCita SET idHoraCita = ?, Hora = ?, Estado = ?, FechaCreacion = ?,"
        + "fechaModificacion = ?, WHERE idHoraCita = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getHora());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdHoraCita());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE HoraCita SET Estado = ? WHERE IdHoraCita = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM HoraCita "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query);
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
