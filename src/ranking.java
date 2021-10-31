import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ranking {
    private List<Player> players = new ArrayList<>();

    // DB Settings
    private static Connection con;
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="php";
    private static final String pass="Php_1c4J8";  //la que tengas de base de datos o si no tienes ninguna
    private static final String url="jdbc:mysql://localhost:3306/snake?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    // Get all players
    public List<Player> getPlayers() {
        return getUsers();
    }

    // Set players
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // Get users from database.
    public List<Player> getUsers() {

        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                ResultSet results = con.createStatement().executeQuery("SELECT username, points from records");

                while(results.next()){
                    Player user = new Player(results.getString("username"), results.getInt("points"));
                    players.add(user);
                }
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);
        }
        return players;
    }

    // Add Player
    public void addPlayer(String username, Integer pts) {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                ResultSet results = con.createStatement().executeQuery("INSERT INTO records (`username`, `points`) VALUES ('"+username+"', "+pts+");");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);
        }
    }

    public ranking() {
        List<Player> players = getPlayers();

        // Preparing pane
        JList playerRecords = new JList();
        DefaultListModel model = new DefaultListModel();

        // Populating pane with users from db
        for (Player user: players ) {
            model.addElement(user.toString());
        }

        playerRecords.setModel(model);


        JOptionPane.showMessageDialog(null, playerRecords, "Ranking", JOptionPane.PLAIN_MESSAGE);
    }
}
