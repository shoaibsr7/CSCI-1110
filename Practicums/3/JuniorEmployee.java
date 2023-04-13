package P3;

public class JuniorEmployee extends Employee {
    public JuniorEmployee(String name, int registryNumber){
        super(name,registryNumber);
    }

    @Override
    public String toString() {
        return String.format("Junior Employee: %s", super.toString());
    }


}
