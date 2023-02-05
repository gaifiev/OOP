package home6.presenter;

import home6.files.Service;
import home6.model.Day;
import home6.model.Tab;
import home6.model.Note;
import home6.UI.View;

public class Presenter {
    private Tab tab;
    private View consoleUI;

    private Service service;

    public Presenter(Service service) {
        this.service = service;
        this.service.setPresenter(this);
    }

    public View getConsoleUI() {
        return consoleUI;
    }

    public void setConsoleUI(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void printTab(Tab tab) {
        getConsoleUI().printTab(tab);
    }

    // добавляет запись
    public void addNote() {
        tab.addNoteToDay(consoleUI.getDay(), consoleUI.getNote(true));
    }

    // получает записи по дню
    public void getDayNotes() {
        int dayNum = consoleUI.getDay();
        Day day = tab.getDayNotes(dayNum);
        consoleUI.printDay(dayNum, day);
    }

    // поиск записи по событию
    public void findEvent() {
        Note note = consoleUI.getNote(false);
        String event = note.getEvent();
        String findedNote = tab.findNote(event);
        if (findedNote.length() == 0) {
            findedNote = "Событие " + event + " не найдено";
        } else {
            findedNote = "Поиск по событиям(планам): \n" + findedNote;
        }
        consoleUI.printNote(findedNote);
    }

    public void saveTab() {
        service.saveTab(tab);
    }

    public Tab readTab() {
        tab = service.readTab();
        return tab;
    }

    public void showMessage(String message) {
        consoleUI.showMessage(message);
    }

}