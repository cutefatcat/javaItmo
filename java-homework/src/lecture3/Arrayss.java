package lecture3;

import java.util.*;

public class Arrayss {
    public static void main(String[] args) {
        //t1(20);
        t2(99);
        //createAndPrint();
        //t6();
    }

    /**
     * 1) Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива
     * на экран сначала в строку, отделяя один элемент от другого пробелом, а затем
     * в столбик (отделяя один элемент от другого началом новой строки). Перед
     * созданием массива подумайте, какого он будет размера. 2 4 6 … 18 20 2 4 6 … 20
     */

    public static void t1(int n){
        int sizeArr = n / 2;
        int[] even = new int[sizeArr];
        int ev = 2;
        for (int i = 0; i < sizeArr ; i++){
            even[i] = ev;
            ev += 2;
        }

        printThroughSpace(even);
        print(even);
    }

    public static void printThroughSpace(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i != arr.length-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        for (int elem: arr){
            System.out.println(elem);
        }
    }

    /**
     *  2) Создайте массив из всех нечётных чисел от 1 до 99, выведите его
     *  на экран в строку, а затем этот же массив выведите на экран тоже в строку,
     *  но в обратном порядке (99 97 95 93 … 7 5 3 1).
     */

    public static void t2(int n){
        int sizeArr = n / 2 + 1;
        int[] odd = new int[sizeArr];
        int od = 1;
        for (int i = 0; i < sizeArr ; i++){
            odd[i] = od;
            od += 2;
        }

        printThroughSpace(odd);
        printInverseThroughSpace(odd);
    }

    public static void printInverseThroughSpace(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i]);
            if (i != 0){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * 3) Создайте массив из 15 случайных целых чисел из отрезка [0;9].
     * Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов и
     * выведете это количество на экран на отдельной строке.
     */

    public static void createAndPrint(){
        int[] randomNumbers = new int[15];
        for (int i = 0; i < randomNumbers.length; i++){
           randomNumbers[i] = (int)(Math.random() * 9);
        }
        System.out.println(Arrays.toString(randomNumbers));
        countEvenAndPrint(randomNumbers);
    }

    public static void countEvenAndPrint(int[] arr){
        int count = 0;
        for (int elem : arr){
            if (elem % 2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }


    /**
     * 4) Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
     * выведите массивы на экран в двух отдельных строках. Посчитайте среднее
     * арифметическое элементов каждого массива и сообщите, для какого из массивов
     * это значение оказалось больше (либо сообщите, что их средние арифметические равны).
     */

    public static void t4(){

    }

    /**
     * 5) Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его
     * на экран в строку. Определить и вывести на экран сообщение о том, является ли
     * массив строго возрастающей последовательностью.
     */


    /**
     * 6) Пользователь должен указать с клавиатуры чётное положительное число,
     * а программа должна создать массив указанного размера из случайных целых чисел
     * из [-5;5] и вывести его на экран в строку. После этого программа должна определить
     * и сообщить пользователю о том, сумма модулей какой половины массива больше:
     * левой или правой, либо сообщить, что эти суммы модулей равны. Если пользователь
     * введёт неподходящее число, то программа должна требовать повторного ввода до
     * тех пор, пока не будет указано корректное значение.

     Понадобится класс Scanner, например:
     Scanner sc = new Scanner(System.in);
     System.out.println("Введите число | строку и тп");
     int i = sc.nextInt(); для числа
     String str = sc.nextLine(); для строки

     */

    public static void t6() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Введите чётное положительное число");
            n = sc.nextInt();
        } while (n <= 0 || n%2 != 0);

        int[] radomArr = new int[n];
        for (int i = 0; i < n; i++){
            radomArr[i] = getRandomArbitrary(-5,5);
        }
        System.out.println(Arrays.toString(radomArr));

        int countSumLeftPart = 0;
        int countSumRightPart = 0;
        for (int i = 0; i < n; i++){
            if (i < n / 2){
                countSumLeftPart += Math.abs(radomArr[i]);
            } else {
                countSumRightPart += Math.abs(radomArr[i]);
            }
        }

        String result;
        if (countSumLeftPart < countSumRightPart){
            result = "Сумма модулей правой половины массива больше";
        } else if (countSumLeftPart > countSumRightPart){
            result = "Сумма модулей левой половины массива больше";
        } else {
            result = "Суммы модулей обех половин массива равны";
        }
        System.out.println(result);
    }

    private static int getRandomArbitrary(int min, int max) {
        return (int)(Math.random() * (max - min)) + min;
    }
    // Многомерные массивы:
            //7) Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99]. Вывести массив на экран. После на отдельной строке вывести на экран значение максимального элемента этого массива (его индекс не имеет значения).


           // 8) Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил начинать каждый урок с того, чтобы задавать каждому ученику пример из таблицы умножения, но в классе 15 человек, а примеры среди них не должны повторяться. В помощь учителю напишите программу, которая будет выводить на экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что задания по умножению на 1 и на 10 — слишком просты). При этом среди 15 примеров не должно быть повторяющихся (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).
}
