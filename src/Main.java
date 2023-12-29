
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("101", "Mahindra", "xuv700", 900);
        Car car2 = new Car("102", "Enova", "fortuner", 1299);
        Car car3 = new Car("103", "TATA", "nexon", 675);
        Car car4 = new Car("104", "SUZUKI", "800", 499);
        Car car5 = new Car("105", "KWID", "Renaults", 699.99);
        Car car6 = new Car("106", "Ford", "Ecosport", 800.75);

        CarRentalSystem carRentalSystem = new CarRentalSystem();
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);
        carRentalSystem.addCar(car6);

        carRentalSystem.menu();
    }
}