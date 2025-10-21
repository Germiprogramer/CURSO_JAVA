package learning_the_java_language.language_basics.operators;

public class Condicionales {
    int val1 = 1;
    int val2 = 2;

    // AND &&, OR ||
    void applyConditional() {
        if ((val1 == 1) && (val2 == 2))
            System.out.println("val1 is 1 AND val2 is 2");
        if ((val1 == 1) || (val2 == 1))
            System.out.println("val1 is 1 OR val2 is 1");
    }

    // El Ternary Operator ?: sigue la siguiente estructura: if-then-else
    void applyTernaryOperator() {
        int result;
        boolean someCondition = false;
        result = someCondition ? val1 : val2;
        System.out.println(result);
    }
}

