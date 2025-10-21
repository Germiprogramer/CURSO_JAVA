package learning_the_java_language.language_basics.variables;

public class ArrayDemo {
    // Declaramos un array de enteros con 10 elementos, y les damos valores a cada uno
    int[] anArray;

    // Array simple
    void initArray() {
        anArray = new int[10];
        anArray[0] = 100;
        anArray[1] = 200;
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        /* Tambien podemos crear e inicializar un array abreviadamente de la siguiente manera
        int[] anArray = {
            100, 200, 300,
            400, 500, 600,
            700, 800, 900, 1000
        };
        */

        System.out.println("Element on index 6: " + anArray[6]);
    }

    // Multi array (array de arrays)
    void initMultiArray() {
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        System.out.println(names[0][0] + names[1][0]);
        System.out.println(names[0][1] + names[1][1]);

        // con .length vemos la longitud del array
        System.out.println("anArray length: " + anArray.length);
    }

    // Copiar un array, hacemos uso de System.arraycopy
    void copyArray() {
        String[] copyFrom = {
            "Affogato", "Americano", "Capuccino", "Corretto", "Cortado",
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
            "Marocchino", "Ristretto"};
        
        String[] copyTo = new String[7];
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        // System.out.println("Copied array: " + copyTo); <-- Des esta manera no se imprime bien, sale [Ljava.lang.String;@6e0be858
        // Usamos un bucle for para mostrarlo
        for (String coffee : copyTo) {
            System.out.print(coffee + " "); // Usamos print en lugar de println para evitar saltos de linea
        }
        System.out.println();
    }

    // Manipular arrays. Hay muchos metodos para facilitar el trabajo del desarrollador.
    // Normalmente estos metodos los vamos a encontrar en la clase java.util.Arrays, aunque ya hemos visto que hay algunos en System
    void manipulateArray() {
        // Copiamos el mismo array. Lo podriamos poner como estado de ArrayDemo porque se repite pero lo ponemos aqui para que se entienda mejor
        String[] copyFrom = {
            "Affogato", "Americano", "Capuccino", "Corretto", "Cortado",
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
            "Marocchino", "Ristretto"};
        
        // Esto resulta en la misma copia que el metodo anterior, aunque requiere menos lineas de codigo
        String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9); // del indice 2 incluido, hasta el indice 9 excluido
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
        System.out.println();

        /* Otros metodos muy utiles de la clase java.util.Array son:
                binarySearch: Obtener el indice de un valor determinado en el array
                equals: Comparar dos arrays para ver si son iguales
                fill: Rellenar un array con un mismo valor
                sort, parallelSort: Ordenar un array
                stream: Metodo muy potente que permite aplicar otros metodos del tiron de manera declarativa
                toString: Convierte cada elemento del array en String, y los separa por comas, entre corchetes [pos1, pos2, ..., posX]
        */
    }
}