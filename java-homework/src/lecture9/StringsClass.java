package lecture9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class StringsClass {
    /**
     * 1. Сосчитать частоту встречаемости слов в книге War and peace.
     * 2. Собрать все слова в группы по количеству букв: например, в одну группу
     * попадут слова: [the, war, jar, get, met...], в другую [on, up, no, of...].
     * 3. Вывести топ 10 самых частых слов и фраз.
     * 4. Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).
     * 5. Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы.
     *
     */

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        File txt = new File("java-homework/src/lecture9/wp.txt");
        List<String> lines = Files.readAllLines(txt.toPath());

        list = splitIntoWords(lines, list);

        Map<String, Integer> wordsCount = task1(list);
        for (Map.Entry<String,Integer> entry : wordsCount.entrySet()){
            String word = entry.getKey();
            Integer count = entry.getValue();
            System.out.println(word + " : " + count);
        }

        Map<Integer, Set<String>> groupsByLength = task2(list);
        for (Map.Entry<Integer, Set<String>> entry : groupsByLength.entrySet()){
            Integer length = entry.getKey();
            System.out.println("Words with length " + length + " :");
            for (String word : entry.getValue()){
                System.out.println(word);
            }
        }

        Map<Character,Integer> letterCount = task5(list);
        for (Map.Entry<Character,Integer> entry : letterCount.entrySet()){
            Character word = entry.getKey();
            Integer count = entry.getValue();
            System.out.println(word + " : " + count);
        }
    }

    public static ArrayList<String> splitIntoWords(List<String> lines, ArrayList<String> list) {
        for(int i = 0; i < lines.size(); i++){
            list.addAll(Arrays.asList(lines.get(i).toLowerCase().trim()
                    .replace(",", "").replace(".", "")
                    .replace("?","").replace("!", "")
                    .replace("\"", "").replace("...","")
                    .replace(" \'"," ").replace("\' ", " ")
                    .replace("--"," ").replace(":", "")
                    .split(" ")));
        }
        return list;
    }

    public static Map<String, Integer> task1(ArrayList<String> list) {
        Map<String, Integer> wordsCount = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (wordsCount.containsKey(word)) {
                Integer count = wordsCount.get(word);
                count++;
                wordsCount.replace(word,count);
            } else {
                wordsCount.put(word, 1);
            }
        }
        return wordsCount;
    }

    public static Map<Integer, Set<String>> task2(ArrayList<String> list) {
        Map<Integer, Set<String>> groupsByLength = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            int length = list.get(i).length();

            if (groupsByLength.containsKey(length)){
                Set<String> set = groupsByLength.get(length);//.add(list.get(i));
                set.add(list.get(i));
            } else {
                Set<String> set = new HashSet<>();
                set.add(list.get(i));
                groupsByLength.put(length, set);
            }
        }
        return groupsByLength;
    }

    public static Map<Character, Integer> task5(ArrayList<String> list){
        Map<Character,Integer> letterCount = new HashMap<>();
        //Set<Character> letters = new HashSet<>();
        List<String> tmpList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            tmpList.add(list.get(i).replace("-", "").replace("\'", ""));
        }

        for (int i = 0; i < tmpList.size(); i++){
            for (int j = 0; j < tmpList.get(i).length(); j++){
                Character letter = tmpList.get(i).charAt(j);
                if (letterCount.containsKey(tmpList.get(i).charAt(j))){
                    Integer count = letterCount.get(letter);
                    count++;
                    letterCount.replace(letter, count);
                } else {
                    letterCount.put(letter, 1);
                }
            }
        }

        Integer countSum = 0;
        for (Map.Entry<Character,Integer> entry : letterCount.entrySet()){
            countSum = countSum + entry.getValue();
        }

        return letterCount;
    }

    //пустые строки убирать через isEmpty или через length()
}
