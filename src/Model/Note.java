package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements Serializable {
    private LocalDateTime dateTime;
    private String note;

    @Override
    public String toString() {
        return dateTime.toString() + "->" + note;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Note(LocalDateTime dateTime, String note) {
        this.dateTime = dateTime;
        this.note = note;
    }
}
