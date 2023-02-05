package home6.commands;

import home6.UI.View;

public class Save implements Commands {

    View consoleUI;

    public Save(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        // сейвит
        consoleUI.getPresenter().saveTab();
        // завершает
        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение календаря и сохранение в файл";
    }
}