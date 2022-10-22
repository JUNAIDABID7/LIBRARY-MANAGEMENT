import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc extends library {
    static Connection connect;

    public static Connection create() {

        try

        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver Loaded" );

            String user = "root";
            String password ="junaid123@";
            String url ="jdbc:mysql://localhost:3306/library";

            connect = DriverManager.getConnection(url, user, password);
            System.out.print("Connection Created" );
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return connect;
    }

}
