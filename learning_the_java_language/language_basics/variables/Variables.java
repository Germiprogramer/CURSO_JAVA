package learning_the_java_language.language_basics.variables;

class Variable {
    // cuando declaramos una variable como static, todos los objetos de la clase comparten el mismo valor
    static int counter = 0;

    // una constante, no puede ser cambiada
    final int MY_NUMBER = 4;
    //number = 5; <-- error

    //Aquí estamos incrementando la variable estática counter cada vez que la clase crea una nueva instancia
    Variable() {
        counter++;
    }
}

class DataTypes {

    // Estos dos primeros no se usan mucho, pueden servir para ahorrar memoria en un array grande pero poco mas
    byte myByte = 127; // Rango de -128 a 127 (byte xd)
    short myShort = 32767; // Igual que el byte pero con 16 bits (rango -32768 a 32767)

    int myInt = 1; // int clásico, 32 bits
    long myLong = 2; // como el int pero para 64 bits
    float myFloat = 3.57f; // float tiene una f al final (because yes) y tiene menos precision que el double
    double myDouble = 3.57;
    boolean myBool = false;
    char myChar = 'a';

    // No se considera un data type, pero bueno yo lo pongo que esta bien
    String myString = "moyismarica"; // Hay que ponerlo entre "" no vale ''
    // Y el valor de un String en Java es inmutable

}

public class Variables {
        public static void main(String[] args) {

        // Ejemplo para ver como funciona static en los estados de una clase
        Variable var3 = new Variable();
        System.out.println(var3.counter);
    }
}
