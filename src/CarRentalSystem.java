import java.util.ArrayList;

public class CarRentalSystem {
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem(ArrayList<Car> cars, ArrayList<Customer> customers, ArrayList<Rental> rentals) {
        this.cars = cars;
        this.customers = customers;
        this.rentals = rentals;
    }

    void addCar(Car car){
        cars.add(car);
    }

    void addCustomer(Customer customer){
        customers.add(customer);
    }

    void rentCar(Customer customer, Car car, int days){
        if(car.isAvailable()){
            car.rentCar();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    void returnCar(Car car){
        Rental rentalToRemove = null;
        for (Rental rental : rentals){
            if (rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully");
            car.returnCar();
        } else {
            System.out.println("Car was never rented");
        }
    }

    // method to display everything and to make a interactive interface
    void Menu(){}
}
