/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.PareoCodigo;
import static Ventanas.VentanaMain.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class PareoCodigoDAO {

    //////////////////////////////// Codigo1 ///////////////////////////////////
    public static boolean insertPareoCodigoCodigo1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("INSERT INTO dbo.pareoCodigo2 (codigoOriginal, proveedor, pk, codigo1, rtu1, operador1) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getCodigo1() + "', '"
                    + pareoCodigo.getRtu1() + "', '"
                    + pareoCodigo.getOperador1() + "')");
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo2 (codigoOriginal, proveedor, pk, codigo1, rtu1, operador1) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getCodigo1() + "', '"
                    + pareoCodigo.getRtu1() + "', '"
                    + pareoCodigo.getOperador1() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<PareoCodigo> selectCodigo1(String codigoOrigianl, String proveedor) throws SQLException {
        ArrayList<PareoCodigo> arrPareoCodigo = new ArrayList<>();
        System.out.println("SELECT codigoOriginal, codigo1, proveedor FROM dbo.pareoCodigo2 WHERE pk = '" + proveedor + codigoOrigianl + "'");
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT codigoOriginal, codigo1, proveedor, rtu1, operador1 FROM dbo.pareoCodigo2 WHERE pk = '" + proveedor + codigoOrigianl + "' "
                + "group by codigoOriginal, codigo1, proveedor, rtu1, operador1"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                PareoCodigo pareoCodigo = new PareoCodigo();
                pareoCodigo.setCodigoOriginal(res.getString("codigoOriginal"));
                pareoCodigo.setCodigo1(res.getString("codigo1"));
                pareoCodigo.setProveedor(res.getString("proveedor"));
                pareoCodigo.setRtu1(res.getString("rtu1"));
                pareoCodigo.setOperador1(res.getString("operador1"));
                arrPareoCodigo.add(pareoCodigo);
            }
        }
        return arrPareoCodigo;
    }

    public static String selectCodigo1RTUOperador(String codigoOrigianl, String proveedor, String codigo) throws SQLException {
        System.out.println("SELECT rtu1, operador1 FROM dbo.pareoCodigo2 WHERE pk = '" + proveedor + codigoOrigianl + "' AND codigo1 = '" + codigo + "'");
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT rtu1, operador1 FROM dbo.pareoCodigo2 WHERE pk = '" + proveedor + codigoOrigianl + "' AND codigo1 = '" + codigo + "'"); ResultSet res = estatuto.executeQuery()) {
            if (res.next()) {
                return res.getString("rtu1") + "@" + res.getString("operador1");
            } else {
                return "";
            }
        }
    }

    public static boolean updatePareoCodigoCodigo1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.pareoCodigo2 SET codigo1 ='" + pareoCodigo.getCodigo1() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo2 SET codigo1 ='" + pareoCodigo.getCodigo1() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    ///////////////////////////////// Codigo2 //////////////////////////////////
    public static boolean insertPareoCodigoCodigo2(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo (codigoOriginal, proveedor, pk, codigo2) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getCodigo2() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updatePareoCodigoCodigo2(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo SET codigo2 ='" + pareoCodigo.getCodigo2() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    ///////////////////////////////// RTU1 /////////////////////////////////////
    public static boolean insertPareoCodigoRTU1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo (codigoOriginal, proveedor, pk, rtu1) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getRtu1() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updatePareoCodigoRTU1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo SET rtu1 ='" + pareoCodigo.getRtu1() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    ///////////////////////////////// rtuFactor1 ///////////////////////////////
    public static boolean insertPareoCodigoRtuFactor1(PareoCodigo pareoCodigo) {

        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo (codigoOriginal, proveedor, pk, rtuFactor1) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getOperador1() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updatePareoCodigoFactor1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo SET rtuFactor1 ='" + pareoCodigo.getOperador1() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    ///////////////////////////////// RTU2 /////////////////////////////////////
    public static boolean insertPareoCodigoRTU2(PareoCodigo pareoCodigo) {

        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo (codigoOriginal, proveedor, pk, rtu2) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getRtu2() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updatePareoCodigoRTU2(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo SET rtu2 ='" + pareoCodigo.getRtu2() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    ///////////////////////////////// rtuFactor2 ///////////////////////////////
    public static boolean insertPareoCodigoRtuFactor2(PareoCodigo pareoCodigo) {

        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.pareoCodigo (codigoOrigina, proveedor, pk, rtuFactor2) VALUES ('"
                    + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getProveedor() + "', '"
                    + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "', '"
                    + pareoCodigo.getOperador2() + "')");
            estatuto.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updatePareoCodigoFactor2(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.pareoCodigo SET rtuFactor2 ='" + pareoCodigo.getOperador2() + "' WHERE pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteCodigo1(PareoCodigo pareoCodigo) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("DELETE from dbo.pareoCodigo2 WHERE codigo1 = '" + pareoCodigo.getCodigo1() + "' AND pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.execute("DELETE from dbo.pareoCodigo2 WHERE codigo1 = '" + pareoCodigo.getCodigo1() + "' AND pk = '" + pareoCodigo.getProveedor() + pareoCodigo.getCodigoOriginal() + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
