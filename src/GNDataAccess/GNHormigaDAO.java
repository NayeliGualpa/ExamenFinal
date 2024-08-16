package GNDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import GNDataAccess.GNDTO.GNHormigaDTO;
import GNFramework.GNLivException;

public class GNHormigaDAO  extends GNSqliteDataHelper implements GNIDAO<GNHormigaDTO>{
   
    @Override
    public boolean create(GNHormigaDTO entity) throws Exception {
        String query = "INSERT INTO HORMIGA (IdSexo , IdProvincia , IdAlimento , TipoHormiga , EstadoHormiga) VALUES(? , ? , ? , ? , ?)";
        try {
            Connection   conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdSexo());  // Si tiene mas variables se copia esta linea pero cambia las variables 
            pstmt.setInt(2, entity.getIdProvincia());  
            pstmt.setInt(3, entity.getIdAlimento());  
            pstmt.setString(4, entity.getTipoHormiga());  
            pstmt.setString(5, entity.getEstadoHormiga());  
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw  new GNLivException (e.getMessage(), getClass().getName() ,"create()");
        }
    }


    @Override
    public boolean update(GNHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE HORMIGA SET TipoHormiga = ? , EstadoHormiga = ? , FechaModificacion = ?   WHERE IdHormiga = ?";
        try {
            Connection   conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getTipoHormiga()); 
            pstmt.setString(2, entity.getEstadoHormiga()); 
            pstmt.setString(3, dtf.format(now).toString()); 
            pstmt.setInt(4, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GNLivException (e.getMessage(), getClass().getName() ,"update()");
        }
    }


    @Override
    public List<GNHormigaDTO> readAll() throws Exception {
        List<GNHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga  "
                     + ",IdSexo         "
                     + ",IdProvincia    "
                     + ",IdAlimento     "
                     + ",TipoHormiga    "
                     + ",EstadoHormiga  "
                     + ",Estado         "
                     + ",FechaCrea      "
                     + ",FechaModificacion  "
                     + "FROM HORMIGA    "
                     + "WHERE  Estado = 'A' ";       
           try {
            Connection conn = openConnection();                      //conectar a DB
            Statement stmt = conn.createStatement();                //CRUD : select * ....
            ResultSet rs = stmt.executeQuery(query);                 // ejecutar la
            while (rs.next()) {
                GNHormigaDTO h = new GNHormigaDTO( rs.getInt(1)      // IdHormiga
                    ,rs.getInt(2)            // IdSexo
                    ,rs.getInt(3)            // IdProvincia
                    , rs.getInt(4)           // IdAlimento
                    , rs.getString(5)        // TipoHormiga
                    ,rs.getString(6)         // EstadoHormiga
                    ,rs.getString(7)         // Estado
                    ,rs.getString(8)         // FechaCrea
                    ,rs.getString(9));       // FechaModificacion
                
                    lst.add(h);                       
            }
           } catch (SQLException e) {
               throw new GNLivException (e.getMessage(), getClass().getName() ,"readAll()");
           }          
           return lst;
    }


    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE HORMIGA SET Estado = ?   WHERE IdHormiga = ?";
        try {
            Connection   conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X"); 
            pstmt.setInt(2, id); 
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GNLivException (e.getMessage(), getClass().getName() ,"delete()");
        }
    }


    @Override
    public GNHormigaDTO readBy(Integer id) throws Exception {
        GNHormigaDTO oh = new GNHormigaDTO();
        String query = " SELECT IdHormiga  "
                     + ",IdSexo         "
                     + ",IdProvincia    "
                     + ",IdAlimento     "
                     + ",TipoHormiga    "
                     + ",EstadoHormiga  "
                     + ",Estado         "
                     + ",FechaCrea      "
                     + ",FechaModificacion  "
                     + "FROM HORMIGA    "
                     + "WHERE  Estado = 'A'  AND IdVotacion=  " + id.toString(); 
             
           try {
            Connection conn = openConnection();               //conectar a DB
            Statement stmt = conn.createStatement();          //CRUD : select * ....
            ResultSet rs = stmt.executeQuery(query);          // ejecutar la
            while (rs.next()) {
                GNHormigaDTO h = new GNHormigaDTO( rs.getInt(1)      // IdHormiga
                ,rs.getInt(2)            // IdSexo
                ,rs.getInt(3)            // IdProvincia
                , rs.getInt(4)           // IdAlimento
                , rs.getString(5)        // TipoHormiga
                ,rs.getString(6)         // EstadoHormiga
                ,rs.getString(7)         // Estado
                ,rs.getString(8)         // FechaCrea
                ,rs.getString(9));       // FechaModificacion
            }
           } catch (SQLException e) {
               throw  new GNLivException (e.getMessage(), getClass().getName() ,"readBy()");
           }          
           return oh;
    }
    }



         
