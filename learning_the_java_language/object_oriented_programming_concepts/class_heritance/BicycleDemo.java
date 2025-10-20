package learning_the_java_language.object_oriented_programming_concepts.class_heritance;

class Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
}

class MountainBike extends Bicycle  {

     boolean fork = true;

     void changeFork(boolean newfork) {
          fork=newfork;
     }

     void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear + " fork:" + fork);
    }
}


// The name of the class contain the main void must be the only public class, and its name must match with the name of the file

public class BicycleDemo {
     public static void main(String[] args) {
          // Create two different Bicycle objects
          Bicycle bike = new Bicycle();
          MountainBike mtbBike = new MountainBike();

          // Invoke methods to change our Bicycle states
        bike.changeCadence(50);
        bike.speedUp(10);
        bike.changeGear(2);
        System.out.println("\nStandard Bike");
        bike.printStates();

        // NOw for the MountainBike, which is the child class of Bicycle
        mtbBike.changeCadence(50);
        mtbBike.speedUp(10);
        mtbBike.changeGear(2);
        mtbBike.changeCadence(40);
        mtbBike.speedUp(10);
        mtbBike.changeGear(3);
        mtbBike.changeFork(false);
        System.out.println("\nMountain Bike");
        mtbBike.printStates();
     }
}