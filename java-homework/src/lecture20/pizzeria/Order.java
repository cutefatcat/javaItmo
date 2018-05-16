package lecture20.pizzeria;

public class Order {
    private Status status;

    public Order(){}
    public Order(Status status){
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}