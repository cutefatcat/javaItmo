package lecture5.calc;


public class Accumulator {
    private int value;
    private Operation operation;

    public Accumulator(Operation operation, int value){
        this.value = value;
        this.operation = operation;
    }

    protected void accum(int someInt){
        this.value = this.operation.execute(this.value, someInt);
    }

    public int getValue(){
        return this.value;
    }

    public static void main(String[] args){
        Accumulator acc = new Accumulator(new Plus(), 10);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());
        Accumulator acc2 =  new Accumulator(new Minus(), 10);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());
        Accumulator acc3 =  new Accumulator(new Multiply(), 10);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());
        Accumulator acc4 =  new Accumulator(new Divide(), 10);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());
    }
}
