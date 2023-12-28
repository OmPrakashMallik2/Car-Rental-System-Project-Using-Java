public class Customer {
    private String name;
    private long aadhaarNumber;

    public Customer(String name, long aadhaarNumber) {
        this.name = name;
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getName() {
        return name;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }
}
