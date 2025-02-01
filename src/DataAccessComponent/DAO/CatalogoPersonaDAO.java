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
import DataAccessComponent.DTO.CatalogoPersonaDTO;
;

public class CatalogoPersonaDAO extends SQLiteDataHelper implements IDAO<CatalogoPersonaDTO> {

    @Override
    public CatalogoPersonaDTO readBy(Integer id) throws Exception {
        CatalogoPersonaDTO oCtp = new CatalogoPersonaDTO();
        String query = "SELECT p.idCatalogoPersona" +
                        ",p.nombre " + 
                        ",p.estado " + 
                        ",p.fechaCreacion" + 
                        ",p.fechaModificacion " +
                        ",c.nombre " +
                        "FROM CatalogoPersona as p " +
                        "INNER JOIN CatalogoPersonaTipo as c ON p.idCatalogoPersonaTipo = c.idCatalogoPersonaTipo\r\n" +
                        "WHERE p.estado ='A'\r\n" +
                        "AND idPersona = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                oCtp = new CatalogoPersonaDTO(
                    rs.getInt(1)
                  , rs.getString(2)
                  , rs.getString(3)
                  ,rs.getString(4)
                  , rs.getString(5)
                  ,rs.getString(6));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return oCtp;
    }
    @Override
    public List<CatalogoPersonaDTO> readAll() throws Exception {
        List<CatalogoPersonaDTO> catalogos = new ArrayList<>();
        String query = "SELECT p.idCatalogoPersona" +
                        ",p.nombre " + 
                        ",p.estado " + 
                        ",p.fechaCreacion" + 
                        ",p.fechaModificacion " +
                        ",c.nombre " +
                        "FROM CatalogoPersona as p " +
                        "INNER JOIN CatalogoPersonaTipo as c ON p.idCatalogoPersonaTipo = c.idCatalogoPersonaTipo\r\n" +
                        "WHERE p.estado ='A'\r\n";
        
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                CatalogoPersonaDTO catalogo = new CatalogoPersonaDTO(
                    rs.getInt(1)
                  , rs.getString(2)
                  , rs.getString(3)
                  , rs.getString(4)
                  , rs.getString(5)
                  , rs.getString(6));;

                  catalogos.add(catalogo);
            }
        } catch (SQLException e) {
            throw e;
        }
        return catalogos;
    }

    @Override
    public boolean create(CatalogoPersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "INSERT INTO CatalogoPersona (nombre, idCatalogoPersonaTipo, fechaModificacion) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, traducirNombreAID(entity.getCatalogoPersonaTipo()));
            pstmt.setString(3, dtf.format(now));

            return true;
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public boolean update(CatalogoPersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CatalogoPersona SET nombre = ?, estado = ?, fechaModificaion = ?, idCatalogoPersonaTipo = ? WHERE idCatalogoPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(2, traducirNombreAID(entity.getCatalogoPersonaTipo()));
            pstmt.setInt(5, entity.getIdCatalogoPersona());

            return  pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE CatalogoPersona SET estado = ? WHERE idCatalogoPersona = ?";
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
        String query = "SELECT COUNT(*) AS TotalReg FROM CatalogoPersona WHERE estado = 'A'";
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

    private Integer traducirNombreAID(String nombre) {
        Integer ID;
        switch (nombre) {
            case "Sexo":
                ID = 1;
                break;
            case "Estado Civil":
                ID = 2;
                break;
            case "Rol":
                ID = 3;
                break;
            case "Especialidad":
                ID = 4;
                break;
            default:
                ID = 22;
                break;
        }
        return ID;
    }
    
}
