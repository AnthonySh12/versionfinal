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
import DataAccessComponent.DTO.TelefonoDTO;

public class TelefonoDAO extends SQLiteDataHelper implements IDAO<TelefonoDTO> {
    @Override
    public TelefonoDTO readBy(Integer id) throws Exception {
        TelefonoDTO oS = new TelefonoDTO();
        String query = "SELECT    t.idTelefono"
                       + "       ,p.idPersona" 
                       + "       ,t.numero" 
                       + "       ,p.nombre"
                       + "       ,p.apellido" 
                       + "       ,t.estado"    
                       + "       ,t.fechaCreacion"  
                       + "       ,t.fechaModificacion "
                       + "FROM Telefono as t "
                       + "INNER JOIN Persona as p ON t.idPersona = p.idPersona\r\n"
                       + "WHERE t.estado ='A'\r\n"
                       + "AND t.idTelefono = " + id.toString();    
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new TelefonoDTO(rs.getInt(1)     // IdSexo
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
    public List<TelefonoDTO> readAll() throws Exception {
        List<TelefonoDTO> lst = new ArrayList<>();
        String query = "SELECT    t.idTelefono"
                       + "       ,p.idPersona" 
                       + "       ,t.numero" 
                       + "       ,p.nombre"
                       + "       ,p.apellido" 
                       + "       ,t.estado"    
                       + "       ,t.fechaCreacion"  
                       + "       ,t.fechaModificacion "
                       + "FROM Telefono as t "
                       + "INNER JOIN Persona as p ON t.idPersona = p.idPersona\r\n"
                       + "WHERE t.estado ='A'";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                TelefonoDTO s = new TelefonoDTO(rs.getInt(1)     // IdSexo
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
    public boolean create(TelefonoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Telefono (numero, idPersona, fechaModificacion) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNumero());
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
    public boolean update(TelefonoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Telefono SET numero= ?, idPersona = ?, fechaModificacion = ? WHERE idTelefono = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNumero());
            pstmt.setInt(2, entity.getIdPersona());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdTelefono());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Telefono SET estado = ? WHERE idTelefono = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM Telefono "
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

