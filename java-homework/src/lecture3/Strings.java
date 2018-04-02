package lecture3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args){
        //t1();
        t2();
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
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.println("Введите строку");
            str = sc.nextLine();
        } while (str.isEmpty());

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(' ')){
                list.remove(i);
            }
            for (int j = list.size()-1; j !=i; j--) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }

        for (Character c : list) {
            System.out.print(c);
        }
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
