package home6.model;

import java.io.Serializable;

public class Note implements Serializable {

    private Integer hour;
    private String event;

    public Note(Integer hour, String event) {
        this.hour = hour;
        this.event = event;
    }

    public Integer getHour() {
        return hour;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return String.format(" Время: %s, событие - %s\n", hour.toString(), event);

    }
}