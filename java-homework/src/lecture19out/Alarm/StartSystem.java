package lecture19out.Alarm;

public class StartSystem{
    public static void main(String[] args) {
        Sensor sensor = new Sensor();

        sensor.subscribe(new Alarm() {
            int lastTemperature;

            @Override
            public void updateTempChanged(int temperature) {
                if (temperature >= 100 && lastTemperature < 100){
                    System.out.println("Green Alarm : " + temperature);
                }

                lastTemperature = temperature;
            }
        });

        sensor.subscribe(new Alarm() {
            int lastTemperature;

            @Override
            public void updateTempChanged(int temperature) {
                if (temperature >= 300 && lastTemperature < 300) {
                    System.out.println("Yellow Alarm : " + temperature);
                }

                lastTemperature = temperature;
            }
        });

        sensor.subscribe(new Alarm() {
            int lastTemperature;

            @Override
            public void updateTempChanged(int temperature) {
                if (temperature >= 600 && lastTemperature < 600){
                    System.out.println("Red Alarm : " + temperature);
                }

                lastTemperature = temperature;
            }
        });


        for (int i = 0; i < 50; i++ ){
            sensor.temperatureChange();
        }
    }
}
