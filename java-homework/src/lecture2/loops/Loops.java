package lecture2.loops;


public class Loops {
    public static void main(String[] args) {
        // print4DigitSequence();
        //printElementsMultiplesOf5();
        //printElementsMultiplesOf2();

        checkPrimeNumber(89);
        countLuckyTicket();
        countSymmetricalCombinations();
    }

    /**
     * 1) Создайте программу, выводящую на экран все четырёхзначные числа
     * последовательности 1000 1003 1006 1009 1012 1015 …
     */

//    public static void print4DigitSequence(){
//        int num = 1000;
//        while (num < 10000){
//            System.out.println(num);
//            num+=3;
//        }
//    }

    /**
     * 2) Создайте программу, выводящую на экран все неотрицательные элементы
     * последовательности 90 85 80 75 70 65 60 …
     */

//    public static void printElementsMultiplesOf5(){
//        for (int num = 90; num > 0; num--){
//            if (num%5 == 0) {
//                System.out.println(num);
//            }
//        }
//    }

    /**
     * 3) Создайте программу, выводящую на экран первые 20 элементов
     * последовательности 2 4 8 16 32 64 128 …
     */

//    public static void printElementsMultiplesOf2() {
//        int count = 0;
//        int num = 2;
//        while (count < 20){
//            System.out.println(num);
//            count++;
//            num *= 2;
//        }
//    }

    /**
     * 4) Проверьте,  является ли  натуральное число — простым.
     */
        // не решена до конца
    public static void checkPrimeNumber(int num) {
        int k;
        String res = "Простое число";
        if (num % 2 != 0 && num != 2) {
            k = (int) Math.ceil(Math.sqrt(num));
            for (int i = 3; i < k; i++) {
                if (num % i == 0) {
                    System.out.println(res);
                } else {
                    System.out.println("Не является ростое число");
                }
            }
        } else {
            System.out.println(res);
        }
    }


    /**
     * 5) Выведите на экран первые 11 членов последовательности Фибоначчи.
     * Первый и второй члены последовательности равны единицам, а каждый
     * следующий — сумме двух предыдущих.
     */

    public static void k(){

    }

    /**
     * 6) В городе N проезд в трамвае осуществляется по бумажным отрывным билетам.
     * Каждую неделю трамвайное депо заказывает в местной типографии рулон билетов
     * с номерами от 000001 до 999999. «Счастливым» считается билетик у которого
     * сумма первых трёх цифр номера равна сумме последних трёх цифр, как, например,
     * в билетах с номерами 003102 или 567576. Трамвайное депо решило подарить сувенир
     * обладателю каждого счастливого билета и теперь раздумывает, как много сувениров
     * потребуется. С помощью программы подсчитайте сколько счастливых билетов в одном рулоне?
     */

    public static void countLuckyTicket() {
        int iSum;
        int jSum;
        int count = 0;
        for (int i =0; i < 1000; i++){
            for (int j = 1; j < 1000; j++){
               iSum = i%10 +(i/10)%10 + (i/10/10)%10;
               jSum = j%10 +(j/10)%10 + (j/10/10)%10;
               if (iSum == jSum){
                   count++;
               }
            }
        }
        System.out.println(count);
    }

    /**
     * 7) Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать
     * сколько раз за сутки случается так, что слева от двоеточия показывается симметричная
     * комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
     */

    public static void countSymmetricalCombinations(){
        int h;
        int m;
        String tmpH;
        String tmpM;
        int count = 0;

        for(h =0; h!=24; h++ ){
            for(m=0; m!=60; m++) {
                //0 - подстановка, 2 - разрядность, d - целое число
                tmpH = String.format("%02d", h);
                tmpM = String.format("%02d", m);
                if (tmpH.charAt(0) == tmpM.charAt(1) && tmpH.charAt(1) == tmpM.charAt(0)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}