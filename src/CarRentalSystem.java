import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CarRentalSystem {
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
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
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("====== Car \uD83D\uDE97 Rental System ======");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1){
                System.out.println("\n===== Rent a car =====\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable cars: ");
                if (cars.isEmpty()){
                    System.out.println("Not available any car.");
                }
                for (Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId()+" - "+car.getBrand()+" - "+car.getModel()+" - "+car.getBasePricePerDay()+"/day");
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carID = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); //consume line

                Customer newCustomer = new Customer("CUS"+(customers.size()+1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars){
                    if (Objects.equals(car.getCarId(), carID) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n==== Rental information ====\n");
                    System.out.println("Customer ID: "+newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+newCustomer.getName());
                    System.out.println("Car Details: "+selectedCar.getModel()+" "+selectedCar.getBrand());
                    System.out.println("Rental Days: "+rentalDays);
                    System.out.println("Total Price: ₹"+totalPrice);

                    System.out.print("\nConfirm Rental (Y/N) :");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")){
                        rentCar(newCustomer, selectedCar, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n===== Return a car ======\n");
                System.out.println("Enter the car id you want to return: ");
                String carIdForReturn = scanner.nextLine();

                Car carForReturn = null;
                for (Car car : cars){
                    if(car.getCarId().equalsIgnoreCase(carIdForReturn) && !car.isAvailable()){
                        carForReturn = car;
                        break;
                    }
                }

                if (carForReturn != null){
                    Customer customer = null;
                    for (Rental rental : rentals){
                        if(rental.getCar() == carForReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null){
                        returnCar(carForReturn);
                        System.out.println("Car returned successfully by "+customer.getName());
                    } else {
                        System.out.println("Car was not rented or missing rental information.");
                    }
                } else {
                    System.out.println("Invalid car id or car was not rented");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice please enter a valid choice.");
            }
        }
        System.out.println("\nThank you for using Car \uD83D\uDE97 Rental System!");
    }
}
