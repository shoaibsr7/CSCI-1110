package P3;

public class CompanyWithArrays {
   Employee[] employees;

    public CompanyWithArrays(){
        employees = new Employee[10];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee emp){
        //Search the array first
        //Make sure it is not null too!
        for (int i =0; i < employees.length; i++){
            if(employees[i] != null && employees[i].equals(emp)){
                //If it is equals then we don't add again
                return false;
            }
        }
        //We searched the entire array and did not find the employee. Now we can add
        //Find the first empty position in the array (a.k.a. null)
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                //Add the employee (we are assuming that there will be space)
                employees[i] = emp;
            }
        }
        return true;
    }

    public boolean removeEmployee(int registryNumber){
        //Similar to add but with a single loop because once (if) we find the employee we can remove and leave
        for (int i = 0; i < employees.length; i++) {
            //Remember to check for null!
            if(employees[i] != null && employees[i].getRegistryNumber() == registryNumber){
                //Remove the employee
                employees[i] = null;
                return true;
            }
        }
        //Searched the entire company and did not found
        return false;
    }
}
