package home6.commands;

import home6.UI.View;

public class GetCalendar implements Commands {

    View consoleUI;

    public GetCalendar(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        // печатаем календарь
        consoleUI.getPresenter().printTab(consoleUI.getTab());
    }

    @Override
    public String description() {
        return "показать весь календарь";
    }
}