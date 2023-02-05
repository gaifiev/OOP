package home6.commands;

import home6.UI.View;

public class AddNote implements Commands {

    View consoleUI;

    public AddNote(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().addNote();
    }

    @Override
    public String description() {
        return "добавить запись";
    }
}