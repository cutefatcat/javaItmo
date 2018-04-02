package lecture5.calc;

public class Minus extends Operation{
    @Override
    protected int execute(int a, int b){
        System.out.println("Minus execute");
        return a - b;
    }
}
