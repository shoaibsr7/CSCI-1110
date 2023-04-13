package P3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompanyWithSetAndIterator {
    Set<Employee> employees;

    public CompanyWithSetAndIterator(){
        employees = new HashSet<>();
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee emp){
        return employees.add(emp);
    }

    public boolean removeEmployee(int registryNumber){
        Iterator<Employee> i = employees.iterator();
        while (i.hasNext()){
            Employee e = i.next();
            if(e.getRegistryNumber() == registryNumber){
                i.remove();
                return true;
            }
        }
        return false;
    }
}
