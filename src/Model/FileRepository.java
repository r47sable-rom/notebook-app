package Model;

import View.Iview;

import java.io.*;
import java.util.List;

public class FileRepository implements Irepository {
    private final String fileName;

    public FileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(List<Note> notes) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(notes);
        } catch(IOException e){
            System.out.println("Ошибка при сохранении" + e.getMessage());
        }
    }

    @Override
    public List<Note> load() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<Note>) ois.readObject();
        } catch(FileNotFoundException e){
            System.out.println("Файл отсутствует, загружать нечего.");
            return new java.util.ArrayList<>();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Ошибка при загрузке" + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
}
