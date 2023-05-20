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
}