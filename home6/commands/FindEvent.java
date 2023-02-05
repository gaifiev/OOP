package home6.commands;

import home6.UI.View;

public class FindEvent implements Commands {

    View consoleUI;

    public FindEvent(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().findEvent();
    }

    @Override
    public String description() {
        return "найти запись";
    }
}