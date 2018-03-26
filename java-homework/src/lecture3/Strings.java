package lecture3;

import java.util.Scanner;

public class Strings {
    public static void main(Strings[] main){
        t1();
        //t2();
    }

    /**
     * 1) Найти в строке указанную подстроку и заменить ее на новую.
     * Строку, ее подстроку для замены и новую подстроку вводит пользователь.
     */

    public static void t1(){
        Scanner sc = new Scanner(System.in);
        String str;
        String replacementSubstr;
        String newSubstr;
        do {
            System.out.println("Введите строку");
            str = sc.nextLine();
        } while (str.isEmpty());

        do {
            System.out.println("Укажите подстроку для замены");
            replacementSubstr = sc.nextLine();
        } while (replacementSubstr.isEmpty());

        do {
            System.out.println("");
            newSubstr = sc.nextLine();
        } while (newSubstr.equals(replacementSubstr));

        str.replace(replacementSubstr,newSubstr);

    }

    /**
     * 2) Требуется удалить из нее повторяющиеся символы и все пробелы. Например,
     * если было введено "abc cde def", то должно быть выведено "abcdef".
     */

    public static void t2(){
 
    }

    /**
     * 3) Вводится строка, содержащая буквы, целые неотрицательные числа и
     * иные символы. Требуется все числа, которые встречаются в строке, поместить
     * в отдельный целочисленный массив. Например, если дана строка "дом 48, корпус 9,
     * парадная 7, этаж 4", то в массиве должны оказаться числа 48, 9, 7 и 4
     */

    public static void t3(){

    }
}
