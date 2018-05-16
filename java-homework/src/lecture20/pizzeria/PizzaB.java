package lecture20.pizzeria;

public class PizzaB {
    private Order order;

    public static void main(String[] args) throws InterruptedException {
        PizzaB pizza = new PizzaB();
        Main main = pizza.new Main();
        Waiter waiter = pizza.new Waiter();
        Cooker cooker = pizza.new Cooker();

        main.start();
        waiter.start();
        cooker.start();
    }

    private  void setOrderStatus(Status status) {
        synchronized (PizzaB.class) {
            order.setStatus(status);
            System.out.println(status.getDescription());
        }
    }

    private class Main extends Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (PizzaB.this){
                order = new Order();
                setOrderStatus(Status.NEW);
                //System.out.println(String.format("[%d] notify", Thread.currentThread().getId()));
                PizzaB.this.notify();
                while (!isInterrupted()) {
                    try {
                        PizzaB.this.wait();
                        if (order.getStatus().equals(Status.COOKER_DONE)) {
                            setOrderStatus(Status.DONE);
                            break;
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }

    private class Waiter extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (PizzaB.this){
                    try {
                        //System.out.println(String.format("[%d] wait", Thread.currentThread().getId()));
                        PizzaB.this.wait();
                        if (order.getStatus().equals(Status.NEW)){
                            setOrderStatus(Status.WAITER_ASSIGNED);
                            PizzaB.this.notify();
                            break;
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }

    private class Cooker extends Thread{
        @Override
        public void run() {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!isInterrupted()) {
                synchronized (PizzaB.this){
                    try {
                        //System.out.println(String.format("[%d] wait Cooker", Thread.currentThread().getId()));
                        PizzaB.this.wait();
                        if (order.getStatus().equals(Status.WAITER_ASSIGNED)){
                            setOrderStatus(Status.COOKER_IN_PROCCESS);
                            sleep(1000);
                            setOrderStatus(Status.COOKER_DONE);
                            PizzaB.this.notify();
                            break;
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }
}