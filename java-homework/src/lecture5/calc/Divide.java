package lecture5.calc;

public class Divide extends Operation{
    protected int execute(int a, int b) {
        System.out.println("Divide execute");
        return a / b;
    }
}
