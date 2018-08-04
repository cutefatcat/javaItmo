package lecture5.calc;

public class Accumulator2 {
    private int value;

    public Accumulator2(int value) {
        this.value = value;
    }

    protected Accumulator2 accum(Operation operation, int someInt ){
        // для нескольких действий с числом
        this.value = operation.execute(this.value, someInt);
        return this;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        Accumulator2 acc = new Accumulator2(3);
        acc.accum(new Plus(), 5)
                .accum(new Minus(), 7)
                .accum(new Divide(), 2)
                .accum(new Multiply(), 6);

        System.out.println(acc.getValue());
    }
}