package control2;

public class Account {
    private static int countId = 100;
    private int id;
    private int userId;
    private int amount;

    public Account(User user, int amount){
        this.amount = amount;
        this.id = countId++;
        this.userId = user.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
