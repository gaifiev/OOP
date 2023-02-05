package home6.commands;

import home6.UI.View;

public class GetDayNotes implements Commands {

    View consoleUI;

    public GetDayNotes(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().getDayNotes();
    }

    @Override
    public String description() {
        return "показать записи на определённый день";
    }
}