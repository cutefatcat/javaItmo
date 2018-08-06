package lecture3;

//Многомерные массивы
public class MultidimensionalArrays {
    public static void main(String[] args) {
        checkMaxValueInArray();
        t8();
    }

    /**
     * 7) Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных
     * целых чисел из отрезка [-99;99]. Вывести массив на экран. После на отдельной строке
     * вывести на экран значение максимального элемента этого массива (его индекс не имеет значения).
     */
    public static void checkMaxValueInArray() {
        int[][] array = new int[5][8];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = (int) (Math.random() * (99 + 99 + 1) - 99);
            }
        }

        printArray(array);
        printMax(array);
    }

    private static void printArray(int[][] array) {
        for (int[] num : array) {
            for (int num2 : num) {
                System.out.print(num2 + " ");
            }
            System.out.println();
        }
    }

    private static void printMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8 - 1; j++) {
                max = compare(max, array[i][j]);
            }
        }
        System.out.println(max);
    }

    private static int compare(int a, int b) {
        return b > a ? b : a;
    }

    /**
     * 8) Для проверки остаточных знаний учеников после летних каникул, учитель
     * младших классов решил начинать каждый урок с того, чтобы задавать каждому
     * ученику пример из таблицы умножения, но в классе 15 человек, а примеры среди них
     * не должны повторяться. В помощь учителю напишите программу, которая будет выводить
     * на экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что задания
     * по умножению на 1 и на 10 — слишком просты). При этом среди 15 примеров не должно быть
     * повторяющихся (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).
     */
    public static void t8() {
        int ramdomNumb = 0;
        int ramdomNumb2 = 0;
        int[][] pairOfNumbers = new int[15][2];
        do {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 2; j++) {
                    ramdomNumb = (int) (Math.random() * (9 - 1));
                    ramdomNumb2 = (int) (Math.random() * (9 - 1));
                    pairOfNumbers
                    if (i != 0 && j !=0) {
                        compare(pairOfNumbers[i][j], pairOfNumbers[i][j]);
                    }
                }
            }
            ramdomNumb = (int) (Math.random() * (9 - 1));
            ramdomNumb2 = (int) (Math.random() * (9 - 1));
pairOfNumbers
        if (pairOfNumbers[0][0] != 0) {
            compare(pairOfNumbers[i][j], pairOfNumbers[i][j]);
        } while ()
    }
}