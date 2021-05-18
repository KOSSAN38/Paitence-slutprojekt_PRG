import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class databas {

    public void dbStore(String name, int score) throws SQLException{
        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + databasCon.DBURL + ":" + databasCon.port + "/" + databasCon.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databasCon.user, databasCon.password);
        stmt = conn.createStatement();


        String save = "INSERT INTO score (name, score) VALUES ( '" + name + "','" + score + "')";
        stmt.executeUpdate(save);

    }

    public user[] dbShow() throws SQLException{
        user users[] = new user[10];

        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + databasCon.DBURL + ":" + databasCon.port + "/" + databasCon.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databasCon.user, databasCon.password);
        stmt = conn.createStatement();

        String get = "SELECT * FROM score ORDER BY score DESC LIMIT 10";

        ResultSet rset = stmt.executeQuery(get);

        for (int i = 0; rset.next(); i++){
            users[i] = new user(rset.getString("name"), rset.getInt("score"));
        }

        return users;
    }
}