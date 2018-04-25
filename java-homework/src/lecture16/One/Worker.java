package lecture16.One;

public abstract class Worker {
    private int id;
    private String name;
    private int rate;
    private double averageMonthlySalary;

    public Worker(int id, String name, int rate){
        this.id = id;
        this.name = name;
        this.rate = rate;
        setAverageMonthlySalary(rate);
    }

    public static Worker getInstance(String data) throws Exception {
        validateFileType(data);
        String[] workerData = data.split(";");
        int id = Integer.parseInt(workerData[0]);
        String name = workerData[1];
        int salary = Integer.parseInt(workerData[2]);

        if (data.endsWith("H")){
            return new WorkerWithHourlySalary(id, name, salary);
        }

        return new WorkerFixedSalary(id, name, salary);
    }

    private static void validateFileType(String data) throws Exception{
        if (data.isEmpty()){
            throw new IllegalArgumentException("Data is empty");
        } else if (!data.endsWith("H") && !data.endsWith("F")){
            throw new IllegalArgumentException("Invalid data");
        }
    }

    protected abstract double calculateAverageMonthlySalary(int rate);

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getRate() {
        return rate;
    }

    public double getAverageMonthlySalary(){
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(int rate){
        this.averageMonthlySalary = calculateAverageMonthlySalary(rate);
    }
}
