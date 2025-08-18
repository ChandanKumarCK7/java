package DesignPatterns;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update(String message);
}

interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void setWeather(String message);
}

class EmailObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Email - "+message);
    }
}

class SMSObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("SMS - "+message);
    }
}

class WeatherStation implements Subject{
    List<Observer> observers = new ArrayList<>();
    String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(weather);
        }
    }
    @Override
    public void setWeather(String weather) {
        this.weather = weather;
        notifyObservers();
    }
}
public class ObserverPattern{
    public static void main(String[] args){

        Observer emailObserver = new EmailObserver();
        Observer smsObserver = new SMSObserver();

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObserver(emailObserver);
        weatherStation.addObserver(smsObserver);

        weatherStation.setWeather("temperature 40degreesC");

    }
}