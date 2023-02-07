/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sopor
 */
public class DBConnection {

    Connection connection = null;

    public DBConnection() throws IOException {
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("qweASDzxc123*");
            ds.setServerName("servidor-toso.ddns.net");
            ds.setPortNumber(1433);
            ds.setDatabaseName("ingresoAutomatico");
            this.connection = ds.getConnection();
            if (this.connection != null) {
                System.out.println("Conexia base de datos OK\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void desconectar() throws SQLException {
        this.connection.close();
    }
}
