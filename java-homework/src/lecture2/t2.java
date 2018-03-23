package lecture2;

//
public class t2 {
    public static void main(String[] args) {
       minDistance(8.5, 11.45);
       processQuadraticEquation(1, 7, 9);
       maxDigit(774);
       sortAscending(3, 9, -1);
    }

    /**
     * 1) Создать программу, выводящую на экран ближайшее к 10 из двух чисел,
     * записанных в переменные m и n. Например, среди чисел 8.5 и 11.45
     * ближайшее к десяти 11.45.
     */

    public static void minDistance(double m, double n){
        double result;
        // Math.abs(n) — возвращает модуль числа n.
        if (Math.abs(10 - n) < Math.abs(10 - m)){
            result = n;
        } else {
            result = m;
        }
        System.out.println(result);
    }

    /**
     * 2) В три переменные a, b и c записаны три вещественных числа.
     * Создать программу, которая будет находить и выводить на экран вещественные
     * корни квадратного уравнения ax²+bx+c=0, либо сообщать, что корней нет.
     */

    public static void processQuadraticEquation(double a, double b, double c) {
        //дискриминант —  D = b*b − 4ac.
        double d = b * b - 4 * a * c;
        double x1, x2;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(String.format("%f, %f", x1, x2));
        } else if (d == 0){
            x1 = (-b + Math.sqrt(d)) / (2 *a);
            System.out.println(x1);
        } else {
            System.out.println("Корней нет");
        }
    }

    /**
     * 3) Создать программу, выводящую на экран наибольшую цифру любого
     * трехзначного натурального числа. Примеры работы программы:
     *
     * В числе 208 наибольшая цифра 8
     * В числе 774 наибольшая цифра 7
     * В числе 613 наибольшая цифра 6
     */

    public static void maxDigit(int number) {
//        String num = String.valueOf(number);
//        int maxDigit = Integer.parseInt(String.valueOf(num.charAt(0)));
//        for(int i = 1; i < num.length(); i++){
//            int currentDigit = Integer.parseInt(String.valueOf(num.charAt(i)));
//            if (maxDigit < currentDigit){
//                maxDigit = currentDigit;
//            }
//        }

        int maxDigit = 0;
        int currentNumber = number;
        do {
            int currentDigit = currentNumber % 10;
            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }
            currentNumber = currentNumber / 10;
        } while (currentNumber > 0);

        System.out.println("В числе " + number + " наибольшая цифра " + maxDigit);
    }

    /**
     * 4) В три переменные a, b и c явно записаны программистом три целых
     * попарно неравных между собой числа. Создать программу, которая переставит
     * числа в переменных таким образом, чтобы при выводе на экран последовательность
     * a, b и c оказалась строго возрастающей.
     *
     * Числа в переменных a, b и c: 3, 9, -1
     * Возрастающая последовательность: -1, 3, 9
     *
     * Числа в переменных a, b и c: 2, 4, 3
     * Возрастающая последовательность: 2, 3, 4
     *
     * Числа в переменных a, b и c: 7, 0, -5
     * Возрастающая последовательность: -5, 0, 7
     */

    public static void sortAscending(int a, int b, int c) {
        String pattern = "%d, %d, %d";
        String result;
        if (a < b && a < c){
            if(b < c){
                result = String.format(pattern, a, b, c);
            } else {
                result = String.format(pattern, a, c, b);
            }
        } else if (b < c && b < a) {
            if (c < a) {
                result = String.format(pattern, b, c, a);
            } else {
                result = String.format(pattern, b, a, c);
            }
        } else {
            if (a < b) {
                result = String.format(pattern, c, a, b);
            } else {
                result = String.format(pattern, c, b, a);
            }
        }
        System.out.println(result);
    }

}
