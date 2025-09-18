package Presenter;

import Model.Note;
import Model.Notebook;
import View.Iview;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotebookPresenter {

    private final Iview view;
    private final Notebook notebook;

    public NotebookPresenter(Iview view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
    }

    public void addNote() {
        String dateInput = view.getUserInput("Введите дату и время (например, 2025-09-17 19:00)");
        String text = view.getUserInput("Введите текст записи");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateInput, formatter);
            Note note = new Note(dateTime, text);
            notebook.addNote(note);
            view.showMessage("Запись успешно добавлена!");
        } catch (Exception e) {
            view.showMessage("Неверный формат даты. Используйте yyyy-MM-dd HH:mm");
        }
    }

    public void showAllNotes() {
        List<Note> notes = notebook.getNotes();
        if (notes.isEmpty()) {
            System.out.println("Записей пока нет");
        } else {
            for (Note note : notes) {
                view.showMessage(note.toString());
            }
        }
    }

    public void showSortedNotes() {
        List<Note> notes = notebook.getNotesSortedByDate();
        if (notes.isEmpty()) {
            System.out.println("Записей пока нет");
        } else {
            for (Note note : notes) {
                view.showMessage(note.toString());
            }
        }
    }

    public void searchNoteByDate() {

        String searchDate = view.getUserInput("Введите дату (в формате yyyy-MM-dd)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(searchDate, formatter);
            List<Note> notes = notebook.findNoteByDate(date);

            if (notes.isEmpty()) {
                view.showMessage("Записей на этот день нет!");
            } else {
                for (Note note : notes) {
                    view.showMessage(note.toString());
                }
            }
        } catch (Exception e) {
            view.showMessage("Неверный формат даты. Используйте yyyy-MM-dd.");
        }
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            String choice = view.getUserInput("Выберите пункт меню: ");

            switch (choice) {
                case "1":
                    addNote();
                    break;
                case "2":
                    showAllNotes();
                    break;
                case "3":
                    showSortedNotes();
                    break;
                case "4":
                    searchNoteByDate();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    view.showMessage("Неверный выбор!");


            }
        }
    }
}
