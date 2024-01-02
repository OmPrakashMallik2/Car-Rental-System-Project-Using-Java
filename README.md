# Car Rental System

## Overview
This Java-based Car Rental System offers an interactive platform for renting and managing cars. It provides features for adding cars, customers, renting, returning, and displaying rental details.

## Key Classes
- **Main:** Initializes the system with example cars and starts the interactive menu.
- **Car:** Represents a car with details like ID, brand, model, base price per day, and availability status.
- **Customer:** Stores customer information including ID and name.
- **Rental:** Records rental transactions, associating a customer, a car, and the rental duration.
- **CarRentalSystem:** Manages the core functionalities, including adding cars, customers, renting, and returning.

## How to Run
1. Execute the `Main.java` file to launch the car rental system.
2. Follow the menu prompts to perform actions like renting a car or returning a car.

## Example Usage
```java
public class Main {
    public static void main(String[] args) {
        // Initialize example cars and start the car rental system
        Car car1 = new Car("101", "Mahindra", "XUV700", 900);
        Car car2 = new Car("102", "Enova", "Fortuner", 1299);
        // ... (add more cars if needed)

        CarRentalSystem carRentalSystem = new CarRentalSystem();
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        // ... (add more cars if needed)

        // Begin the car rental system
        carRentalSystem.menu();
    }
}
