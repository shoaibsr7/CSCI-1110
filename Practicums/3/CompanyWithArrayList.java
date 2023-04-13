package P3;

import java.util.ArrayList;
public class CompanyWithArrayList {
    ArrayList<Employee> employees;

    public CompanyWithArrayList(){
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee emp){
        if(!employees.contains(emp)){
            employees.add(emp);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(int registryNumber){
        for (int i = 0; i < employees.size() ; i++) {
            if(employees.get(i).getRegistryNumber() == registryNumber){
                employees.remove(i);
                return true;
            }
        }
        return false;
        //We can use iterators to go over a collection and remove elements.
        //We will cover this on our ADT lectures
//        Iterator<Employee> i = employees.iterator();
//        while (i.hasNext()){
//            Employee e = i.next();
//            if(e.getRegistryNumber() == registryNumber){
//                i.remove();
//                return true;
//            }
//        }
//        return false;
    }
}
