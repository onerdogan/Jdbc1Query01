import java.sql.*;

public class Jdbc1Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1)ilgili drivere yukle
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //2)baglanti olustur
       Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
        //en son connection con yazdik import ettik
        //3)SQL komutlari icin bir Statement nesnesi olustur (alan olusturduk, kumandada kanallari ayarlamak gibi

     Statement st=con.createStatement();
    //4)SQL ifaderi yazabilir ve calistirabiliriz--kumandad dugmeye basma gibi
        // personel tablosundaki personel id si 7369 olan persomelin maasini adini sorgula
        ResultSet isim= st.executeQuery("SELECT personel_isim, maas From personel WHERE personel_id=7369");
        //5)sonuclari aldik ve isledik

        while (isim.next()){
            System.out.println("personel ismi " +isim.getString("personel_isim")+" maas "+isim.getInt("maas"));
        }
    //olusturan nesleri kaldiralim
       // con.close();
        //st.close();
        //.close();


    }
}
