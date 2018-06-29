package control2;

public class Transaction {
    private static long countId = 1000l;
    private long id;
    private int srcAccId;
    private int dstAccId;
    private int amount;

    public Transaction(int srcAccId, int dstAccId, int amount) {
        this.id = countId++;
        this.srcAccId = srcAccId;
        this.dstAccId = dstAccId;
        this.amount = amount;
    }

    public int getSrcAccId() {
        return srcAccId;
    }

    public int getDstAccId() {
        return dstAccId;
    }

    public int getAmount() {
        return amount;
    }

    public String sendMess(){
        return ("Перевод выполнен успешно!");
    }
}
