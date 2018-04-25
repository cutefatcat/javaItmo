package lecture16.Three;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3) Создайте простую игру основанную на угадывании букв.
 * Пользователь должен угадать загаданную букву A-Z введя ее в консоль. Если пользователь угадал
 * букву программа выведет «Right» и игра закончится, если нет, то пользователь продолжит вводить буквы.
 * (Опционально) Вывести «You’re too low»- если пользователь ввел букву меньше загаданной, «You’re too high»
 * - если пользователь ввел букву больше загаданной
 */

public class GuessLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scanLetter;
        String randomLetter = createRandomLetter();
        System.out.println(randomLetter);
        do {
            System.out.println("Enter a letter A-Z");
            scanLetter = sc.nextLine().toUpperCase();
        } while (scanLetter.isEmpty());

        while (!scanLetter.equals(randomLetter)){
            System.out.println("Try again");
            if (scanLetter.isEmpty()){
                System.out.println("Enter a latter");
            } else if (scanLetter.charAt(0)>randomLetter.charAt(0)){
                System.out.println("You’re too high");
            } else if(scanLetter.charAt(0)<randomLetter.charAt(0)){
                System.out.println("You’re too low");
            }
            scanLetter = sc.nextLine().toUpperCase();
        }

        if (scanLetter.equals(randomLetter)){
            System.out.println("Right");
        }
    }

    public static String createRandomLetter(){
        ArrayList<String> arrayLetters= new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++){
            arrayLetters.add(String.valueOf(c));
        }

        String randomLetter = arrayLetters.get((int)(Math.random()*arrayLetters.size()));
        return randomLetter;
    }
}
