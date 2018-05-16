package lecture20.pizzeria;

public enum Status {
    NEW("Клиент выбрал, что закать"),
    WAITER_ASSIGNED("Официант взял заказ"),
    COOKER_IN_PROCCESS("Повар принял заказ"),
    COOKER_DONE("Повар приготовил заказ"),
    WAITER_DELIEVER("заказ передан официанту"),
    DONE("Заказ отправился к клиенту");

    String description;
    Status(String s) {
        description = s;
    }

    public String getDescription() {
        return description;
    }
}
