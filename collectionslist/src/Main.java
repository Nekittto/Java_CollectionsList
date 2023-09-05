import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        String regexCommand = "[A-Z]+";
        String regexIndex = "[0-9]+";
        String regexText = "[\\s,a-z]+";
        String command = "";
        String todo = null;
        while (true) {
            String input = scanner.nextLine();
            Pattern pCommand = Pattern.compile(regexCommand);
            Matcher mCommand = pCommand.matcher(input);
            Pattern pIndex = Pattern.compile(regexIndex);
            Matcher mIndex = pIndex.matcher(input);
            while (mCommand.find()) {
                int start = mCommand.start();
                int end = mCommand.end();
                command = input.substring(start, end);
            }
            while (mIndex.find()) {
                int start = mIndex.start();
                int end = mIndex.end();
                index = Integer.parseInt(input.substring(start, end));
            }
            Pattern pText = Pattern.compile(regexText);
            Matcher mText = pText.matcher(input);
            while (mText.find()) {
                int start = mText.start();
                int end = mText.end();
                todo = input.substring(start + 1, end);
            }
            if (command.equals("ADD")) {
                if (todo.isEmpty()){
                    System.out.println("Ошибка: введите задачу латинскими буквами");
                } else {
                    todoList.add(todo);
                    System.out.println(todoList.getTodos().size() + " - кол-во задач");
                }
            } else if (command.equals("DELETE")) {
                todoList.delete(index - 1);
                System.out.println(todoList.getTodos().size() + " - кол-во задач");
            } else if (command.equals("EDIT")) {
                if (todo.isEmpty()){
                    System.out.println("Ошибка: введите задачу латинскими буквами");
                } else {
                    todoList.edit(index - 1,todo);
                    System.out.println(todoList.getTodos().size() + " - кол-во задач");
                }
            } else if (command.equals("LIST")) {
                todoList.getTodos();
            } else if (input.equals("HELP")) {
                System.out.println(" LIST — выводит дела с их порядковыми номерами." +
                        "\n ADD — добавляет дело в конец списка или дело на определённое место." +
                        "\n EDIT — заменяет дело с указанным номером. " +
                        "\n DELETE — удаляет задачу." +
                        "\n BREAK — закрыть приложение.");
            } else if (input.equals("BREAK")) {
                break;
            } else {
                System.out.println("Ошибка ввода: введите \"HELP\" для списка команд");
            }

        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
