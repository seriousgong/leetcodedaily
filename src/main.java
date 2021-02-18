import java.sql.Timestamp;
import java.util.Date;

public class main {


    public static void main(String[] args) {
        System.out.println(1/3.0);
        System.out.println(7/3.0);
        System.out.println(5/3.0);
        System.out.println(4/3.0);
        System.out.println(2 /3.0);
        System.out.println(2/3.0f);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(1606838400000L);
        System.out.println(timestamp);
        date.setTime(1606838400000L);
        System.out.println(date);
        date.setTime(1606838410000L);
        System.out.println(date);
    }
}
