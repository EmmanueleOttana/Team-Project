import java.util.ArrayList;
import java.util.List;

public class EmployeesDB{
    static List<Employees> employees = new ArrayList<>();

    Employees user1 = new Employees("Harry","Potter","PTTHRR91D14F158I","Programmer","Full time","14/04/1991");


    public void addEmployeeDB(Employees employee){
        employees.add(employee);
    }

}