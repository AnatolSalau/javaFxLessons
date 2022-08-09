package by.salov.lesson_27_fxmlcalculator;

public class Model {
    public long calculation(long a, long b, String operation) {
        switch (operation) {
            case ("+")-> {return a + b;}
            case ("-")-> {return a - b;}
            case ("*")-> {return a * b;}
            case ("/")-> {
                if (b == 0) {
                    return 0;
                }
                return a / b;
            }
        }
        System.out.println("Unknown operator = " + operation);
        return 0;
    }
}
