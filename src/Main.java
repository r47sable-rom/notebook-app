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
        Irepository repo = new FileRepository("notes.dat");
        Notebook notebook = new Notebook(repo);
        Iview view = new ConsoleView();
        NotebookPresenter presenter = new NotebookPresenter(view, notebook);
        presenter.run();

    }
}
