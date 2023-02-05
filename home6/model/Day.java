package home6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Day implements Serializable {

    private List<Note> notes;

    public Day() {
        this.notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        StringBuilder dayNotes = new StringBuilder();
        dayNotes.append(" Найдено записей - ").append(notes.size()).append(":\n");
        int count = 0;
        for (Note note : notes) {
            dayNotes.append("\t\tЗапись ").append(++count).append(".").append(note);
        }
        return dayNotes.toString();
    }
}