package start.services;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void convertFromLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        String crop = String.valueOf(dateTime).substring(0,String.valueOf(dateTime).lastIndexOf(":"));
        String newFormat = crop.replaceAll(":", "h")+"'";
        String s = newFormat.replaceAll("T", " ");
        System.out.println(s);
    }
    @Test
    void convertFromLocalTime() {
        LocalTime localTime = LocalDateTime.now().toLocalTime();
        System.out.println(localTime);
        String crop = String.valueOf(localTime).substring(0,String.valueOf(localTime).lastIndexOf(":"));
        String newFormat = crop.replaceAll(":", "h")+"'";
        System.out.println(newFormat);
    }
    @Test
    void convertFromDouble(){
        double time = 187.27;
        String crop = String.valueOf(time);
        String result = crop.replaceAll("\\.", "h")+"'";
        System.out.println(result);
    }
    @Test
    void viewFromLocalTime() {
        LocalTime localTime = LocalDateTime.now().toLocalTime();
        System.out.println(localTime);
        String crop = String.valueOf(localTime).substring(0, String.valueOf(localTime).lastIndexOf(":"));
        System.out.println(crop);
    }

    @Test
    void convertFromDouble0(){
        double number = 0.0;
        String crop = String.valueOf(number);
        String cents = crop.substring(crop.indexOf('.')+2);
            if( cents.isEmpty()){System.out.println("funziona");
            }else System.out.println(" non funziona");
    }


}
