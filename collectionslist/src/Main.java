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
        String todo = "";
        System.out.println("Command list:" +
                "\n LIST — lists the tasks with their task numbers." +
                "\n ADD — adds the task to the end of the list or the case to a specific position." +
                "\n EDIT — replaces the task with the specified number." +
                "\n DELETE — deletes the task." +
                "\n BREAK — close the app." +
                "\n In case you need to replace/delete a task, write in this format \"command\" \"task number");
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
                    System.out.println("Error: enter the task in Latin letters");
                } else {
                    todoList.add(todo);
                    System.out.println(todoList.getTodoSize() + " - number of tasks");
                }
            } else if (command.equals("DELETE")) {
                if (index == 0 | index > todoList.getTodoSize()){
                    System.out.println("Error: Index out of bounds");
                } else {
                    todoList.delete(index - 1);
                    System.out.println(todoList.getTodoSize() + " - number of tasks");
                }
            } else if (command.equals("EDIT")) {
                if (index == 0 | index > todoList.getTodoSize()){
                    System.out.println("Error: Index out of bounds");
                } else if (todo.isEmpty()){
                    System.out.println("Error: enter the task in Latin letters");
                } else {
                    todoList.edit(index - 1,todo);
                    System.out.println(todoList.getTodoSize() + " - number of tasks");
                }
            } else if (command.equals("LIST")) {
                todoList.getTodos();
            } else if (input.equals("HELP")) {
                System.out.println(" LIST — lists the tasks with their task numbers." +
                        "\n ADD — adds the task to the end of the list or the case to a specific position." +
                        "\n EDIT — replaces the task with the specified number." +
                        "\n DELETE — deletes the task." +
                        "\n BREAK — close the app.");
            } else if (input.equals("BREAK")) {
                break;
            } else {
                System.out.println("Input error: enter \"HELP\" for the list of commands");
            }

        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}