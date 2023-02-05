package home6.UI;

import home6.commands.*;
import home6.commands.Commands;
import home6.commands.Save;
import home6.model.Day;
import home6.model.Tab;
import home6.model.Note;
import home6.presenter.Presenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private final Tab tab;
    private final Presenter presenter;
    List<Commands> commandsList;

    Scanner iScanner;

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        presenter.setConsoleUI(this);
        tab = this.presenter.readTab();
        commandsList = new ArrayList<>();
        iScanner = new Scanner(System.in);
    }

    public Tab getTab() {
        return tab;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void start() {
        // заполняем список команд UI
        commandsList.add(new Save(this));
        commandsList.add(new GetCalendar(this));
        commandsList.add(new GetDayNotes(this));
        commandsList.add(new AddNote(this));
        commandsList.add(new FindEvent(this));

        while (true) {
            System.out.println("Выберите действие: ");
            for (int i = 0; i < commandsList.size(); i++) {
                System.out.println(i + " - " + commandsList.get(i).description());
            }
            String str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) && (choice < commandsList.size())) {
                    commandsList.get(Integer.parseInt(str)).execute();
                } else {
                    System.out.println("Неверная команда! Повторите еще раз!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Упс, повторите еще раз!");
            }
        }
    }

    public void printTab(Tab tab) {
        System.out.println(tab);
    }

    public void printDay(int dayNum, Day day) {
        if (day.getNotes().size() > 0) {
            System.out.printf("Записи %s дня:\n", dayNum);
            System.out.println(day);
        } else {
            System.out.printf("Записей %s дня не обнаружено.\n", dayNum);
        }
    }

    public void printNote(String findedRecord) {
        System.out.println(findedRecord);
    }

    public Note getNote(boolean full) {
        String event;
        int hour = 0;
        if (full) {
            while (true) {
                System.out.print("Введите время события: ");
                String str = iScanner.nextLine();
                try {
                    hour = Integer.parseInt(str);
                    if ((hour >= 0) && (hour < 24)) {
                        break;
                    } else {
                        System.out.println("Время должно быть в диапазоне от 0 до 23! Повторите еще раз!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Упс, повторите еще раз!");
                }
            }
        }
        System.out.print("Введите событие: ");
        event = iScanner.nextLine();
        return new Note(hour, event);
    }

    public int getDay() {
        int day;
        while (true) {
            System.out.print("Введите день месяца: ");
            String str = iScanner.nextLine();
            try {
                day = Integer.parseInt(str);
                if ((day >= 1) && (day <= 31)) {
                    break;
                } else {
                    System.out.println("День должен быть от 1 до 31! Повторите еще раз!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Упс, повторите еще раз!");
            }
        }
        return day;
    }

    // вывод сообщения пользователю
    public void showMessage(String message) {
        System.out.println(message);
    }
}