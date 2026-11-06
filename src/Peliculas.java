
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

//lalo_p
public class Peliculas implements Serializable {
    
    private String clave, titulo;
    private ImageIcon cartel;
    //String todos = "SELECT * FROM peliculas";

    public Peliculas(String clave, String titulo, ImageIcon cartel) {
        this.clave = clave;
        this.titulo = titulo;
        this.cartel = cartel;
    }
    
    //INSETAR
    public int insertar(Conexion cnx){
        try {
            // No insertamos el ID porque es AUTO_INCREMENT
            String sql = "INSERT INTO peliculas VALUES(?, ?, ?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, clave);
            ps.setString(2, titulo);
            ps.setBinaryStream(3, cnx.ImagenBytes(cartel));
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return 0;
        }
    }
    
    
}
