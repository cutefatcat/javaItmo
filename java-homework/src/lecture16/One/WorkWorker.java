package lecture16.One;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WorkWorker {
    public static void main(String[] args) throws Exception {
        ArrayList<Worker> workerList = createWorkerList();
        sortedWorkerList(workerList);
        print(workerList);

        //printNfirstElement(workerList,5);
        printNlastElement(workerList,3);
    }

    public static ArrayList<Worker> createWorkerList() throws Exception {
        ArrayList<Worker> workerList = new ArrayList<>();
        String[] data = getData();
        for (int i = 0; i < data.length; i++){
            Worker worker = Worker.getInstance(data[i]);
            workerList.add(worker);
        }

        return workerList;
    }

    //Вывести идентификатор работника, имя и среднемесячную зарплату для всех елементов списка.
    private static String[] getData(){
        String[] arrayData = {"001;Name1;500;H", "002;Name2;650;F", "003;Name3;220;H", "004;Name4;2500;F", "005;Name5;650;F", "006;Name6;300;H"};
        return arrayData;
    }

    public static void sortedWorkerList(ArrayList<Worker> workerList){
        Collections.sort(workerList, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                int result = Double.compare(o1.getAverageMonthlySalary(), o2.getAverageMonthlySalary());
                if (result == 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
    }

    public static void print(ArrayList<Worker> workerList){
        for(Worker worker : workerList){
            System.out.println(+ worker.getId() + " " + worker.getName() + " " + worker.getAverageMonthlySalary());
        }
    }

    public static void printNfirstElement(ArrayList<Worker> workerList, int n){
        for(int i = 0; i < n; i++){
            System.out.println(workerList.get(i).getId() + " " + workerList.get(i).getName() + " " + workerList.get(i).getAverageMonthlySalary());
        }
    }

    public static void printNlastElement(ArrayList<Worker> workerList, int n){
        int size = workerList.size() - 1;
        for(int i = size; i > size - n; i--){
            System.out.println(workerList.get(i).getId() + " " + workerList.get(i).getName() + " " + workerList.get(i).getAverageMonthlySalary());
        }
    }

}
