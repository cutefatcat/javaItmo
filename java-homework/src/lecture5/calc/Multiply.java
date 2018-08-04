package lecture5.calc;

public class Multiply extends Operation {
    protected int execute(int a, int b) {
        System.out.println("Multiply execute");
        return a * b;
    }
}