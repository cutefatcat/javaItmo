package lecture19out.Alarm;

import java.util.ArrayList;
import java.util.List;

//Subject
public class Sensor {
    int lastTemperature = 0;

    List<Alarm> alarms = new ArrayList<>();

    //attach(Observer) подключить
    public void subscribe(Alarm observer){
        alarms.add(observer);
    }

    //detach(Observer) отключить
    public void unsubscribe(Alarm observer){
        alarms.remove(observer);
    }

    //notify() оповестить
    private void notifyObserver(int temperature){
        for (Alarm observer : alarms){
            observer.updateTempChanged(temperature);
        }
    }

    public void temperatureChange(){
        int temperature = lastTemperature + (int)(Math.random() * 1000);
        lastTemperature = temperature;
        System.out.println("Sensor temperature : " + temperature);

        notifyObserver(temperature);
    }
}
