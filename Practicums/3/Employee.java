package P3;

public abstract class Employee {

    private String name;
    private int registryNumber;

    public Employee(String name, int registryNumber){
        this.name = name;
        this.registryNumber = registryNumber;
    }

    public String getName(){
        return name;
    }

    public int getRegistryNumber(){
        return registryNumber;
    }


    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee)obj;

        if(other.registryNumber == registryNumber)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(registryNumber);
    }

    @Override
    public String toString() {
        return String.format("%s - %05d",name,registryNumber);
    }

}
