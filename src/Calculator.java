import java.util.Scanner;

public class Calculator {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Первое число");
        float firstNumb = enterNumber();
        do { // Результат = первое число
            System.out.println("Второе число");
            float secondNumb = enterNumber();
            char sign = getSign();
            if (sign == 'S'){ //Завершение работы калькулятора
                System.exit(0);
            }
            float res = getResult(firstNumb, secondNumb, sign);
            System.out.println("Итог:" + res);
            firstNumb = res;
            System.out.println("Первое число "+firstNumb);
        }
        while (firstNumb != '.');
    }

    public static float enterNumber (){
        float numb;
        if (!scan.hasNextFloat()) {
            System.out.println("Число не распознано, введите, пожалуйста, число в формате (х или х,х - если десятичное)");
            scan.next();
        }
        numb = scan.nextFloat();
        return numb;
    }

    public static char getSign(){
        System.out.println("Введите знак арифметическог одействия(+,-,*,/,S(Завершить работу)):");
        char sign;
        String value = scan.next();
        if(value.length()==1)
            sign = value.charAt(0);
        else {
            System.out.println("Введено более 2-х символов. Попробуйте еще раз.");
            sign = getSign();
        }
        return sign;
    }
    public static float getResult(float firstNumb, float secondNumb, char sign) {
        return switch (sign) {
            case '+' -> firstNumb + secondNumb;
            case '-' -> firstNumb - secondNumb;
            case '*' -> firstNumb * secondNumb;
            case '/' -> firstNumb / secondNumb;
            default -> {
                System.out.println("Давай по новой, знак не распознан");
                yield getResult(firstNumb, secondNumb, getSign());
            }
        };
    }
}
