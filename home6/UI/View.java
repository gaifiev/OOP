package home6.UI;

import home6.model.Day;
import home6.model.Tab;
import home6.model.Note;
import home6.presenter.Presenter;

public interface View {
    Tab getTab();

    Presenter getPresenter();

    void start();

    void printTab(Tab tab);

    void printDay(int dayNum, Day day);

    void printNote(String findedRecord);

    Note getNote(boolean full);

    int getDay();

    void showMessage(String message);

}
