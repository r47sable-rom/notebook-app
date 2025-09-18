package View;

import java.util.Scanner;

public class ConsoleView implements Iview {
private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("1 - добавить новую запись");
        System.out.println("2 - показать все записи");
        System.out.println("3 - отсортировать записи по дате");
        System.out.println("4 - поиск записей по дате");
        System.out.println("0 - выход");
    }

    @Override
    public void showMessage(String text) {
        System.out.println(text);
    }

    @Override
    public String getUserInput(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();

    }
}
