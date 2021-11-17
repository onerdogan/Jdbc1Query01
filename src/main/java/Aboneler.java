import java.sql.*;

public class Aboneler {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

        Statement st = con.createStatement();

        ResultSet r1 = st.executeQuery("SELECT * FROM bolumler");
        while (r1.next()) {
            System.out.println(r1.getInt(1)+" \t"+r1.getString(2)+" \t"+r1.getString(3));

            System.out.println("ASLINDA GELDI");

        }


        //example
        String q2="SELECT * FROM bolumler WHERE konum='ANKARA'";
        ResultSet r2=st.executeQuery(q2);


        while(r2.next()) {

            System.out.println(r2.getInt("bolum_id"));
        }
        con.close();
        st.close();
    }
}
