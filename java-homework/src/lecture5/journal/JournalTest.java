package lecture5.journal;

import java.util.Date;
import java.util.List;

public class JournalTest {

    public static void main(String[] args) {
        Journal journal = new Journal();
        
        journal.addItemSpecificDay(new Date(2018, 4, 1), new Task("Hm", "Homework"));
        journal.addItemSpecificDay(new Date(2018, 4, 1), new Note("Please do something"));
        journal.addItemSpecificDay(new Date(2018, 4, 2),
                new Event("Java course", 3, "ITMO","Learn JAVA!"));

        Date currentDate = new Date(2018, 4, 2);
        List<Item> items = journal.getItemOfSpecificDay(currentDate);
        System.out.println("List of items for " + currentDate.toString() + ":");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
}
