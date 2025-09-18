package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook {
    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotesSortedByDate() {
        return notes.stream()
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    public List<Note> findNoteByDate(LocalDate date) {
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }


}
