package lecture20.pizzeria;

/**
 * в) Повар будит официанта и передает ему блюдо, официант будит клиента и отдает заказ.
 */

public class PizzaC {
    private Order order;

    public static void main(String[] args) throws InterruptedException {
        PizzaC pizza = new PizzaC();
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
            synchronized (PizzaC.this){
                order = new Order();
                setOrderStatus(Status.NEW);
                //System.out.println(String.format("[%d] notify", Thread.currentThread().getId()));
                PizzaC.this.notify();
                while (!isInterrupted()) {
                    try {
                       //System.out.println(String.format("[%d] wait main", Thread.currentThread().getId()));
                        PizzaC.this.wait();
                        if (order.getStatus().equals(Status.WAITER_DELIEVER)) {
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
                synchronized (PizzaC.this){
                    try {
                        //System.out.println(String.format("[%d] wait", Thread.currentThread().getId()));
                        PizzaC.this.wait();
                        if (order.getStatus().equals(Status.NEW)){
                            setOrderStatus(Status.WAITER_ASSIGNED);
                            PizzaC.this.notify();
                        }
                        //System.out.println(String.format("[%d] wait2", Thread.currentThread().getId()));
                        PizzaC.this.wait();
                        if (order.getStatus().equals(Status.COOKER_DONE)) {
                            setOrderStatus(Status.WAITER_DELIEVER);
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
                synchronized (PizzaC.this){
                    try {
                        //System.out.println(String.format("[%d] wait Cooker", Thread.currentThread().getId()));
                        PizzaC.this.wait();
                        if (order.getStatus().equals(Status.WAITER_ASSIGNED)){
                            setOrderStatus(Status.COOKER_IN_PROCCESS);
                            sleep(1000);
                            setOrderStatus(Status.COOKER_DONE);
                            PizzaC.this.notifyAll();
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