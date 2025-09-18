package Model;

import java.util.List;

public interface Irepository {
    void save(List<Note> notes);
    List<Note> load();
}
