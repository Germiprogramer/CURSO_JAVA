package learning_the_java_language.language_basics.operators;

public class BitwiseBitshift {
        /*
        ~: puerta NOT a cada uno de los bits en una cadena de bits (bytes, 16bits, etc.) ~5 --> -6: no entiendo
        <<: Desplazamiento a la izquierda (rellenando con 0) 5 << 1 --> 10: 0 101 --> 0 1010 = 10 mola
        >>: Desplazamiento a la derecha (manteniendo el bit de signo) -8 >> 1 --> -4: 1 1000 --> 1 0100 = -4 mola
        >>>: Desplazamiento a la derecha (sin signo, rellenando con 0) -8 >>> 1 --> Número muy grande (2147483644): no entiendo
        &: Puerta AND bit a bit 5 & 3 --> 1: 101 & 011 --> 001 = 1 mola
        |: OR 5 | 3 --> 7: 101 | 011 --> 111 = 7 mola
        ^: XOR 5 ^ 3 --> 6: 101 ^ 011 --> 110 = 6 mola
    */ 

    // Función para comprobar los resultados xd
    // No entiendo la primera y tercera operacion la verdad, no todo iba a ser tan bonito en la vida
    void checkBitOperations() {
        System.out.println(~5);
        System.out.println(5 << 1);
        System.out.println(-8 >> 1);
        System.out.println(-8 >>> 1);
        System.out.println(5 & 3);
        System.out.println(5 | 3);
        System.out.println(5 ^ 3);
    }
}

