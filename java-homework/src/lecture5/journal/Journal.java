package lecture5.journal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

 /**
  * 2. Мы будем делать ежедневник. Для начала также нужно выдельть основные классы и методы
  * и описать их.
  * Классы и медоты выделяйте и описывайте на свое усмотрение, потом обсудим! Не забывайте
  * про наследование и модификаторы доступа
  */


 class Journal{
     ArrayList<Day> days = new ArrayList();

     List<Item> getlistPlansOfCurrentDay(){
         return getItemOfSpecificDay(new Date());
     }

     List<Item> getItemOfSpecificDay(Date date){
         for (Day day : days){
            if (day.getDate().equals(date)){
                return day.getItems();
            }
         }
         return Collections.emptyList();
     }


     //выдать день соответствующий запланированному событию
     //getDayInAccordanceWithItem(){}

     void addItemSpecificDay(Date date, Item item){
         Day dayToAdd = null;
         for (Day day : days){
             if (day.getDate().equals(date)){
                 dayToAdd = day;

             }
         }

         if (dayToAdd == null){
             dayToAdd = new Day(date);
             days.add(dayToAdd);
         }
         dayToAdd.addItem(item);
     }
 }

 class Item{}

 class Event extends Item{
     private String title;
     private int duration;
     private String location;
     private String description;

     public Event(String title, int duration, String location, String description){
         this.title = title;
         this.duration = duration;
         this.location = location;
         this.description = description;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public String getTitle() {
         return title;
     }

     public void setDuration(int duration){
         if (duration < 24){
             this.duration = duration;
         }
     }

     public int getDuration(){
         return duration;
     }

     public void setDescription(String description){
         this.description = description;
     }

     public String getDescription(){
         return description;
     }

     @Override
     public String toString() {
         return "Event " + title + " for " + duration +" hours. Location " + location + ". " + description;
     }
 }
 class Task extends Item{
     String title;
     String description;

     public Task(String title, String description){
         this.title = title;
         this.description = description;
     }

     @Override
     public String toString() {
         return "Task " + title + " : " + description;
     }
 }
 class Note extends Item{
     String note;

     public Note(String note){
         this.note = note;
     }

     @Override
     public String toString() {
         return "Note: " + note;
     }
 }
 class Day{
     private Date date;
     private ArrayList<Item> dayItems = new ArrayList<>();

     public Day(Date date){
         this.date = date;
     }

     public Date getDate() {
         return date;
     }

     public void addItem(Item item){
         dayItems.add(item);
     }

     public ArrayList<Item> getItems(){
         return dayItems;
     }
 }

