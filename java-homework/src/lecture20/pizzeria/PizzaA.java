package lecture20.pizzeria;

/**
 *
 */

public class PizzaA {
    private int indexStatus;

    // Флаг, сигнализиирующий, что можно выводить результат
    private boolean ready;
    private boolean ready2;

    public static void main(String[] args) throws InterruptedException {
        PizzaA sync = new PizzaA();
        // Создаем потоки
        Main main = sync.new Main();
        Waiter waiter = sync.new Waiter();
        Cooker cooker = sync.new Cooker();
        // Запускаем потоки
        main.start();
        waiter.start();
        cooker.start();
        // Ждем завершения выполнения и выводим результат
        cooker.join();
        System.out.println("Повар приготовил заказ и возвращает его клиенту");
    }

    private  void increment() {
        synchronized (PizzaA.class) {
            indexStatus++;
        }
    }

    private class Main extends Thread{
        @Override
        public void run() {
            System.out.println("Клиент выбрал, что заказать");
            // Изменяем общий участок памяти
            increment();
            synchronized (PizzaA.this){
                if(indexStatus == 1){
                    ready = true;
                    // Разбудим ожидающий поток
                    PizzaA.this.notify();
                }
            }
        }
    }

    private class Waiter extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (PizzaA.this){
                    try {
                        PizzaA.this.wait();
                        if (ready){
                            System.out.println("Официант взял заказ");
                            increment();

                            ready = false;
                            ready2 = true;
                            PizzaA.this.notify();
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
            while (!isInterrupted()) {
                synchronized (PizzaA.this){
                    try {
                        PizzaA.this.wait();
                        if (ready2){
                            System.out.println("Повар принял заказ и начиает готовить");
                            increment();
                            ready2 = false;
                            if ( indexStatus == 3){
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }
}