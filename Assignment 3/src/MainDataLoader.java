import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainDataLoader {

    public static void main (String args[]) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment3?useSSL=false", "lavin105", "Lavin105@m.c.edu");
            if(args.length==0){
                System.out.println("Please provide the file path as a command line argument");
            }else{
                String file = args[0];
                TableLoader loadData=new TableLoader(file, con);
                System.out.println("Inserting data to the database.....");
                System.out.println("");
                loadData.loadAll();
                System.out.println("Insertion Complete");

            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException f) {
            f.printStackTrace();
        }



    }

}

