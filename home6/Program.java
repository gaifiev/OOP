package home6;

import home6.files.FileHandler;
import home6.files.Service;
import home6.presenter.Presenter;
import home6.UI.ConsoleUI;
import home6.UI.View;

public class Program {
    public static void main(String[] args) {
        String filename = "home6/files/calendar.txt";
        FileHandler fileHandler = new FileHandler(filename);
        Service service = new Service(fileHandler, filename);
        Presenter presenter = new Presenter(service);
        View consoleUI = new ConsoleUI(presenter);
        consoleUI.start();
    }
}