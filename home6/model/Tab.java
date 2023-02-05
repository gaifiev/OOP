package home6.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tab implements Serializable {

    private Map<Integer, Day> days;

    public Tab() {
        this.days = new HashMap<>();
    }

    public void addNoteToDay(int day, Note note) {
        if (days.containsKey(day)) {
            days.put(day, new Day());
        }
        days.get(day).addNote(note);
    }

    public Day getDayNotes(int findDay) {
        if (days.containsKey(findDay)) {
            return days.get(findDay);
        } else {
            return new Day();
        }
    }

    public String findNote(String event) {
        StringBuilder findResult = new StringBuilder();
        for (Integer dayNum : days.keySet()) {
            Day day = days.get(dayNum);
            for (Note note : day.getNotes()) {
                if (note.getEvent().equalsIgnoreCase(event)) {
                    findResult.append("День ").append(dayNum.toString()).append(", время: ")
                            .append(note.getHour().toString()).append(", событие: ").append(note.getEvent())
                            .append("\n");
                }
            }
        }
        return findResult.toString();
    }

    @Override
    public String toString() {
        StringBuilder daysNotes = new StringBuilder();
        daysNotes.append("Найдено ").append(this.days.size()).append(" день с записями" + " :\n");
        for (Integer day : days.keySet()) {
            daysNotes.append("\tДень ").append(day.toString()).append(".").append(days.get(day).toString());
        }
        return daysNotes.toString();
    }
}