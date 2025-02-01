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
import DataAccessComponent.DTO.CatalogoPersonaTipoDTO;

public class CatalogoPersonaTipoDAO extends SQLiteDataHelper implements IDAO<CatalogoPersonaTipoDTO> {

    @Override
    public CatalogoPersonaTipoDTO readBy(Integer id) throws Exception {
        CatalogoPersonaTipoDTO oCPT = null;
        String query = "SELEC idCatalogoPersonaTipo" +
                       ",nombre " +
                       ",estado " +
                       ",fechaCreacion" +
                       ",fechaModificacion" +
                       "FROM CatalogoPersonaTipo " +
                       "WHERE p.estado ='A'\r\n " +
                       "AND idPersona = " + id.toString();
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                oCPT = new CatalogoPersonaTipoDTO(
                 rs.getInt(1),
                 rs.getString(2), 
                 rs.getString(3),
                 rs.getString(4),
                 rs.getString(5)
                );
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return oCPT;
    }

    @Override
    public List<CatalogoPersonaTipoDTO> readAll() throws Exception {
        List<CatalogoPersonaTipoDTO> tipos = new ArrayList<>();
        String query = "SELECT idCatalogoPersonaTipo" +
                       ",nombre " +
                       ",estado " +
                       ",fechaCreacion" +
                       ",fechaModificacion " +
                       "FROM CatalogoPersonaTipo " +
                       "WHERE estado = 'A'";
        
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CatalogoPersonaTipoDTO lst = new CatalogoPersonaTipoDTO(
                 rs.getInt(1),
                 rs.getString(2), 
                 rs.getString(3),
                 rs.getString(4),
                 rs.getString(5));
                
                tipos.add(lst);
            }
        } catch (SQLException e) {
            throw e;
        }
        return tipos;
    }

    @Override
    public boolean create(CatalogoPersonaTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "INSERT INTO CatalogoPersonaTipo (nombre, estado, fechaCreacion, fechaModificacion) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, dtf.format(now));
            pstmt.setString(4, dtf.format(now));

            return true;
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public boolean update(CatalogoPersonaTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CatalogoPersonaTipo SET nombre = ?, estado = ?, fechaModificaion = ? WHERE idCatalogoPersonaTipo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getIdCatalogoPersonaTipo());

            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        
        String query = "UPDATE CatalogoPersonaTipo SET estado = ? WHERE idCatalogoPersonaTipo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "X");
            pstmt.setInt(2, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = "SELECT COUNT(*) AS TotalReg FROM CatalogoPersonaTipo WHERE estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                return rs.getInt(1);

            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
    
}
