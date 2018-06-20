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

//комменты к многопоточности
//volatile int inc; - если один писатель, нсколько читателей.дешевлле чем symchronized,
// но убирается гарантия чтения актуального значения. если больше писателей - не подойдет будет гонка.

//public synchronize void setIcrement{this.cnt = inc;} - так лучше
//arm -отложит синхрон, а x86 кэширует сразу почти/java memory modul

//узнатьброблок thread dump. jstack <PID>
//kiel -3 <PID> - в консолькею
//jps
//gceasy.io

//wait - уступает захваченый уступает
//notify - сработает после года в синхронайзе
//хотспот - спецификация для написания jvm.
//лучше обект, а не коллекция(все станет колом например с мап
//чтобы не наделать ошибок по забывчивости(если где-тобез синхронизирования испльзуется объетк можно вс есломать)
//лучше final Object monitor = new Object(); или несколько мониторов
//поток блокированный можно убить только (интераптом), когда он проснется(notify когда ждет не выйдет)