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
import DataAccessComponent.DTO.CorreoElectronicoDTO;

public class CorreoElectronicoDAO extends SQLiteDataHelper implements IDAO<CorreoElectronicoDTO> {
    @Override
    public CorreoElectronicoDTO readBy(Integer id) throws Exception {
        CorreoElectronicoDTO oS = new CorreoElectronicoDTO();
        String query = "SELECT    c.idCorreo"
                       + "       ,p.idPersona" 
                       + "       ,c.correo" 
                       + "       ,p.nombre"
                       + "       ,p.apellido" 
                       + "       ,c.estado"    
                       + "       ,c.fechaCreacion"  
                       + "       ,c.fechaModificacion "
                       + "FROM CorreoElectronico as c "
                       + "INNER JOIN Persona as p ON c.idPersona = p.idPersona\r\n"
                       + "WHERE c.estado ='A'\r\n"
                       + "AND c.idCorreo = " + id.toString();    
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new CorreoElectronicoDTO(rs.getInt(1)     // IdSexo
                                    , rs.getInt(2)  // Nombre             
                                    , rs.getString(3)  // Apellido        
                                    , rs.getString(4) + " " + rs.getString(5)  //Persona    
                                    , rs.getString(6)  // Sexo
                                    , rs.getString(7)  // Estado Civil
                                    , rs.getString(8));  // Rol // FechaModificacion
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        return oS;
    }

    @Override
    public List<CorreoElectronicoDTO> readAll() throws Exception {
        List<CorreoElectronicoDTO> lst = new ArrayList<>();
        String query = "SELECT     c.idCorreo"
                        + "       ,p.idPersona" 
                        + "       ,c.Correo" 
                        + "       ,p.nombre"
                        + "       ,p.apellido" 
                        + "       ,c.estado"    
                        + "       ,c.fechaCreacion"  
                        + "       ,c.fechaModificacion "
                        + "FROM CorreoElectronico as c "
                        + "INNER JOIN Persona as p ON c.idPersona = p.idPersona\r\n"
                        + "WHERE c.estado ='A'";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CorreoElectronicoDTO s = new CorreoElectronicoDTO(rs.getInt(1)     // IdSexo
                                                , rs.getInt(2)  // Nombre             
                                                , rs.getString(3)  // Apellido        
                                                , rs.getString(4) + " " + rs.getString(5)  //Persona    
                                                , rs.getString(6)  // Sexo
                                                , rs.getString(7)  // Estado Civil
                                                , rs.getString(8));  // Rol // FechaModificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(CorreoElectronicoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO CorreoElectronico (correo, idPersona, fechaModificacion) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCorreo());
            pstmt.setInt(2, entity.getIdPersona());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CorreoElectronicoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CorreoElectronico SET correo = ?, idPersona = ?, fechaModificacion = ? WHERE idCorreo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCorreo());
            pstmt.setInt(2, entity.getIdPersona());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCorreo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE CorreoElectronico SET estado = ? WHERE idCorreo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM CorreoElectronico "
                     + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}


