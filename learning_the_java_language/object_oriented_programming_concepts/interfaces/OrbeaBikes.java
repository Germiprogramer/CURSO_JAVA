package learning_the_java_language.object_oriented_programming_concepts.interfaces;

// An interface is a group of objects with empty bodies, as it follows:
interface Bicycle {

    void changeCadence(int newCadence);

    void changeGear(int newGear);

    void speedUp(int incrementSpeed);

    void applyBrakes(int decrementSpeed);
}

// So that we can create a new class with the same pattern defined in the interface
class BrandBike implements Bicycle {

    //States
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    // ALL methods defined in the interface must be defined in this class too, otherwise we will have an error

    // Method changeCadence
    public void changeCadence(int newCadence) {
        cadence = newCadence;
    }

    // Method changeGear
    public void changeGear(int newGear) {
        gear = newGear;
    }

    // Method speedUp
    public void speedUp(int incrementSpeed) {
        speed += incrementSpeed;
    }

    // Method applyBrakes
    public void applyBrakes(int decrementSpeed) {
        speed -= decrementSpeed;
    }

    // Additionally, we can define other methods we want that are not defined in the interface

    // Method printStates
    void printStates() {
        System.out.println(
            "cadence: " + cadence +
            "\nspeed: " + speed + 
            "\ngear: " + gear
        );
    }   
}


public class OrbeaBikes {
    public static void main(String[] args) {

        BrandBike orbeaBike = new BrandBike();
        orbeaBike.speedUp(30);
        
        orbeaBike.printStates(); 

    }
}
