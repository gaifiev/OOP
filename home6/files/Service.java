package home6.files;

import home6.model.Tab;
import home6.presenter.Presenter;

public class Service {

    private final Writable writable;
    private Presenter presenter;
    private final String filename;

    public Service(Writable writable, String filename) {
        this.writable = writable;
        this.filename = filename;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void saveTab(Tab tab) {
        try {
            writable.save(tab);
            presenter.showMessage(String.format("Сохранён в файл %s", filename));
        } catch (Exception ex) {
            presenter.showMessage("Ошибка " + ex.getMessage());
        }
    }

    public Tab readTab() {
        if (writable != null) {
            try {
                if (writable.read() == null) {
                    presenter.showMessage("Не читается! Создание файла для Tab.");
                    return new Tab();
                } else {
                    presenter.showMessage(String.format("Список загружен из файла %s", filename));
                    return (Tab) writable.read();
                }
            } catch (Exception ex) {
                presenter.showMessage("Ошибка " + ex.getMessage());
            }
        } else {
            presenter.showMessage("Файл не загружен!");
            return null;
        }
        return null;
    }

}