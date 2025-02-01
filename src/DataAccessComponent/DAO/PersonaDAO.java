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
import DataAccessComponent.DTO.PersonaDTO;

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO> {
    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO oS = new PersonaDTO();
        String query = "SELECT  p.idPersona" 
                      + "      ,p.nombre" 
                      + "      ,p.apellido" 
                      + "      ,p.cedula" 
                      + "      ,sex.nombre" 
                      + "      ,ec.nombre" 
                      + "      ,rol.nombre" 
                      + "      ,esp.nombre" 
                      + "      ,p.edad" 
                      + "      ,p.direccion" 
                      + "      ,p.estado" 
                      + "      ,p.fechaCreacion" 
                      + "      ,p.fechaModificacion " // Added space here
                      + "FROM Persona as p " // Added space here
                      + "INNER JOIN CatalogoPersona as sex ON p.idSexo = sex.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as ec ON p.idEstadoCivil = ec.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as rol ON p.idRol = rol.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as esp ON p.idEspecialidad = esp.idCatalogoPersona\r\n" 
                      + "WHERE p.estado ='A'";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new PersonaDTO(rs.getInt(1)     // IdSexo
                                    , rs.getString(2)  // Nombre             
                                    , rs.getString(3)  // Apellido        
                                    , rs.getString(4)  // Cedula      
                                    , rs.getString(5)  // Sexo
                                    , rs.getString(6)  // Estado Civil
                                    , rs.getString(7)  // Rol
                                    , rs.getString(8)  // Especialidad
                                    , rs.getInt(9)     // edad
                                    , rs.getString(10) // Direccion
                                    , rs.getString(11) // Estado
                                    , rs.getString(12) // Fecha Creacion
                                    , rs.getString(13)); // FechaModificacion
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        return oS;
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        List<PersonaDTO> lst = new ArrayList<>();
        String query = "SELECT  p.idPersona" 
                      + "      ,p.nombre" 
                      + "      ,p.apellido" 
                      + "      ,p.cedula" 
                      + "      ,sex.nombre" 
                      + "      ,ec.nombre" 
                      + "      ,rol.nombre" 
                      + "      ,esp.nombre" 
                      + "      ,p.edad" 
                      + "      ,p.direccion" 
                      + "      ,p.estado" 
                      + "      ,p.fechaCreacion" 
                      + "      ,p.fechaModificacion " // Added space here
                      + "FROM Persona as p " // Added space here
                      + "INNER JOIN CatalogoPersona as sex ON p.idSexo = sex.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as ec ON p.idEstadoCivil = ec.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as rol ON p.idRol = rol.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as esp ON p.idEspecialidad = esp.idCatalogoPersona\r\n" 
                      + "WHERE p.estado ='A';";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PersonaDTO s = new PersonaDTO(rs.getInt(1)     // IdSexo
                                    , rs.getString(2)  // Nombre             
                                    , rs.getString(3)  // Apellido        
                                    , rs.getString(4)  // Cedula      
                                    , rs.getString(5)  // Sexo
                                    , rs.getString(6)  // Estado Civil
                                    , rs.getString(7)  // Rol
                                    , rs.getString(8)  // Especialidad
                                    , rs.getInt(9)     // edad
                                    , rs.getString(10) // Direccion
                                    , rs.getString(11) // Estado
                                    , rs.getString(12) // Fecha Creacion
                                    , rs.getString(13)); // FechaModificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Persona (nombre, apellido, cedula, idSexo, idEstadoCivil, idRol, idEspecialidad, edad, direccion,"
                        + " fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; // Added space here
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getCedula());
            pstmt.setInt(4, traducirNombreAID(entity.getSexo()));
            pstmt.setInt(5, traducirNombreAID(entity.getEstadoCivil()));
            pstmt.setInt(6, traducirNombreAID(entity.getRol()));
            pstmt.setInt(7, traducirNombreAID(entity.getEspecialidad()));
            pstmt.setInt(8, entity.getEdad());
            pstmt.setString(9, entity.getDireccion());
            pstmt.setString(10, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Persona SET nombre = ?, apellido = ?, cedula = ?, idSexo = ?, idEstadoCivil = ?,"
                        + "idRol = ?, idEspecialidad = ?, edad = ?, direccion = ?, fechaModificacion = ? WHERE idPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getCedula());
            pstmt.setInt(4, traducirNombreAID(entity.getSexo()));
            pstmt.setInt(5, traducirNombreAID(entity.getEstadoCivil()));
            pstmt.setInt(6, traducirNombreAID(entity.getRol()));
            pstmt.setInt(7, traducirNombreAID(entity.getEspecialidad()));
            pstmt.setInt(8, entity.getEdad());
            pstmt.setString(9, entity.getDireccion());
            pstmt.setString(10, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Persona SET Estado = ? WHERE IdSexo = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM Persona "
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

    private Integer traducirNombreAID(String nombre) {
        Integer ID;
        switch (nombre) {
            case "Masculino":
                ID = 1;
                break;
            case "Femenino":
                ID = 2;
                break;
            case "No definido":
                ID = 3;
                break;
            case "Soltero":
                ID = 4;
                break;
            case "Casado":
                ID = 5;
                break;
            case "Viudo":
                ID = 6;
                break;
            case "Divorciado":
                ID = 7;
                break;
            case "Union Libre":
                ID = 8;
                break;
            case "Paciente":
                ID = 9;
                break;
            case "Doctor":
                ID = 10;
                break;
            case "Administrativo":
                ID = 11;
                break;
            case "Alergologia":
                ID = 12;
                break;
            case "Anestesiologia":
                ID = 13;
                break;
            case "Dermatologia":
                ID = 14;
                break;
            case "Medicina de Emergencias":
                ID = 15;
                break;
            case "Medicina General":
                ID = 16;
                break;
            case "Neurologia":
                ID = 17;
                break;
            case "Obestetricia y Ginecologia":
                ID = 18;
                break;
            case "Cirugia":
                ID = 10;
                break;
            case "Pediatria":
                ID = 20;
                break;
            case "Gastroenterologia":
                ID = 21;
                break;
            case "No Especialidad":
                ID = 22;
                break;
            default:
                ID = 22;
                break;
        }
        return ID;
    }

    public List<PersonaDTO> readAllDoctors() throws Exception {
        List<PersonaDTO> lst = new ArrayList<>();
        String query = "SELECT  p.idPersona" 
                      + "      ,p.nombre" 
                      + "      ,p.apellido" 
                      + "      ,p.cedula" 
                      + "      ,sex.nombre" 
                      + "      ,ec.nombre" 
                      + "      ,rol.nombre" 
                      + "      ,esp.nombre" 
                      + "      ,p.edad" 
                      + "      ,p.direccion" 
                      + "      ,p.estado" 
                      + "      ,p.fechaCreacion" 
                      + "      ,p.fechaModificacion " // Added space here
                      + "FROM Persona as p " // Added space here
                      + "INNER JOIN CatalogoPersona as sex ON p.idSexo = sex.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as ec ON p.idEstadoCivil = ec.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as rol ON p.idRol = rol.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as esp ON p.idEspecialidad = esp.idCatalogoPersona\r\n" 
                      + "WHERE p.estado ='A' AND p.idRol = 10";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PersonaDTO s = new PersonaDTO(rs.getInt(1)     // IdSexo
                                    , rs.getString(2)  // Nombre             
                                    , rs.getString(3)  // Apellido        
                                    , rs.getString(4)  // Cedula      
                                    , rs.getString(5)  // Sexo
                                    , rs.getString(6)  // Estado Civil
                                    , rs.getString(7)  // Rol
                                    , rs.getString(8)  // Especialidad
                                    , rs.getInt(9)     // edad
                                    , rs.getString(10) // Direccion
                                    , rs.getString(11) // Estado
                                    , rs.getString(12) // Fecha Creacion
                                    , rs.getString(13)); // FechaModificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

        public List<PersonaDTO> readAllPatients() throws Exception {
        List<PersonaDTO> lst = new ArrayList<>();
        String query = "SELECT  p.idPersona" 
                      + "      ,p.nombre" 
                      + "      ,p.apellido" 
                      + "      ,p.cedula" 
                      + "      ,sex.nombre" 
                      + "      ,ec.nombre" 
                      + "      ,rol.nombre" 
                      + "      ,esp.nombre" 
                      + "      ,p.edad" 
                      + "      ,p.direccion" 
                      + "      ,p.estado" 
                      + "      ,p.fechaCreacion" 
                      + "      ,p.fechaModificacion " // Added space here
                      + "FROM Persona as p " // Added space here
                      + "INNER JOIN CatalogoPersona as sex ON p.idSexo = sex.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as ec ON p.idEstadoCivil = ec.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as rol ON p.idRol = rol.idCatalogoPersona\r\n" 
                      + "INNER JOIN CatalogoPersona as esp ON p.idEspecialidad = esp.idCatalogoPersona\r\n" 
                      + "WHERE p.estado ='A' AND p.idRol = 9";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PersonaDTO s = new PersonaDTO(rs.getInt(1)     // IdSexo
                                    , rs.getString(2)  // Nombre             
                                    , rs.getString(3)  // Apellido        
                                    , rs.getString(4)  // Cedula      
                                    , rs.getString(5)  // Sexo
                                    , rs.getString(6)  // Estado Civil
                                    , rs.getString(7)  // Rol
                                    , rs.getString(8)  // Especialidad
                                    , rs.getInt(9)     // edad
                                    , rs.getString(10) // Direccion
                                    , rs.getString(11) // Estado
                                    , rs.getString(12) // Fecha Creacion
                                    , rs.getString(13)); // FechaModificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }
}