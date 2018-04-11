package lecture9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectExp {
    public static void main(String[] args) throws IOException {
        File txt = new File("java-homework/src/lecture9/CollectionTxt.txt");
        //List lines = Files.readAllLines(txt.toPath());
        List<String> lines = Files.readAllLines(txt.toPath());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i< lines.size(); i++){
            list.add(lines.get(i).toLowerCase().trim().replace(" ", "").replace(".", ""));
        }

        for (String str : list){
            System.out.println(str);
        }

        Set<String> Wordlist = new HashSet<>();
        for (int i = 0; i< lines.size(); i++){
            Wordlist.addAll(Arrays.asList(lines.get(i).toLowerCase().trim().replace(".", "").split(" ")));
        }

        for (String str : Wordlist){
            System.out.println(str);
        }
    }
}
