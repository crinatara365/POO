package com.company;

public class Observator {
    Subiect subiect;
    public Observator(Subiect subiect) {
        this.subiect = subiect;
        this.subiect.ataseazaObservator(this);
    }
    public void actualizeaza() {
        System.out.println("Current number of events is " + subiect.getCurrent_number_of_events());
    }
}

class Subiect {
    private int current_number_of_events;
    public Observator observator;
    public int getCurrent_number_of_events() {
        return current_number_of_events;
    }
    public void setCurrent_number_of_events(int number) {
        this.current_number_of_events = number;
        notificaObservator();
    }
    public void ataseazaObservator(Observator observator) {
        this.observator = observator;
    }
    public void notificaObservator() {
        observator.actualizeaza();
    }
}
