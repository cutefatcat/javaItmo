package lecture5.calc;

public class Divide extends Operation{
    protected int execute(int a, int b) {
        if (b != 0) {
            System.out.println("Divide execute");
            return a / b;
        } else {
            System.out.println("Can't be divided by zero");
            return a;
        }
    }
}
