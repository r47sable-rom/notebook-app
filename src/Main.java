import Model.FileRepository;
import Model.Irepository;
import Model.Note;
import Model.Notebook;
import Presenter.NotebookPresenter;
import View.ConsoleView;
import View.Iview;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Iview view = new ConsoleView();
        Irepository repo = new FileRepository("notes.dat", view);
        Notebook notebook = new Notebook(repo);
        NotebookPresenter presenter = new NotebookPresenter(view, notebook);
        presenter.run();
    }
}
