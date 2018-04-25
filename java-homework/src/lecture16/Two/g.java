package lecture16.Two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2) Необходимо реализовать консольную программу, которая бы фильтровала поток
 * текстовой информации подаваемой на вход и на выходе показывала лишь те строчки,
 * которые содержат слово передаваемое программе на вход в качестве аргумента.
 *
 * Программа не должна учитывать регистр
 * В аргументах может быть передано не одно слово, а несколько
 * В качестве аргумента может быть задано не конкретное слово, а регулярное выражение
 */
public class g {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scanWords;
        ArrayList<String> arrWords = new ArrayList<>();
        do {
            System.out.println("Введите нужные данные. По окончанию ввода введите enter");
            scanWords = sc.nextLine().toLowerCase();
            arrWords.add(scanWords);
        } while (scanWords.equals("enter"));

        validate(arrWords);
    }

    public static void validate(ArrayList<String> arrWords){
        Scanner sc = new Scanner(System.in);
        String scanWords;
        String randomLetter = createRandomLetter();
        System.out.println(randomLetter);
    }
}
