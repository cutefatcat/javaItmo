package lecture16.One;

public class WorkerWithHourlySalary extends Worker {

    public WorkerWithHourlySalary(int id, String name, int rate) {
        super(id, name, rate);
    }

    @Override
    protected double calculateAverageMonthlySalary(int hourlyRateOfSalary) {
        double averageMonthlySalary = 20.8*8*hourlyRateOfSalary;
        return averageMonthlySalary;
    }
}
