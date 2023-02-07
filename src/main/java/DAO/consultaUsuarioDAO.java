package DAO;

import static Ventanas.VentanaMain.conex;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class consultaUsuarioDAO {

    public static boolean registraUsuario(String usuario, String pass) throws IOException, SQLException {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.usuarios (usuario, pass) VALUES ('"
                    + usuario + "', '"
                    + pass + "')"
            );
//                JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la Usuario\n" + e);
            return false;
        }
    }

    public static Boolean consultaUsuario(String nombre, String contraseña) throws IOException, SQLException {
        String string = "";
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            ResultSet executeQuery = estatuto.executeQuery("SELECT usuario from dbo.usuarios WHERE usuario = '" + nombre + "' AND pass = '" + contraseña + "'");
            if (executeQuery.next()) {
                string = executeQuery.getString("usuario");
            }
            return !string.equals("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
