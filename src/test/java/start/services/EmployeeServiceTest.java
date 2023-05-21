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
    void convertFromDouble(){
        double time = 187.27;
        String crop = String.valueOf(time);
        String result = crop.replaceAll("\\.", "h")+"'";
        System.out.println(result);
    }
}