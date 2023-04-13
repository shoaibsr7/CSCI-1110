package P3;

public class SeniorEmployee extends Employee {
    public SeniorEmployee(String name, int registryNumber){
        super(name,registryNumber);
    }

    @Override
    public String toString() {
        return String.format("Senior Employee: %s", super.toString());
    }

}
