package lecture16.One;

public class WorkerFixedSalary extends Worker{

    public WorkerFixedSalary(int id, String name, int rate) {
        super(id, name, rate);
    }

    @Override
    protected double calculateAverageMonthlySalary(int fixedSalary) {
        double averageMonthlySalary = fixedSalary;
        return averageMonthlySalary;
    }
}
