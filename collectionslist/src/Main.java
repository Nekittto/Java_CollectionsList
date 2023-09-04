import java.util.Scanner;
public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("ADD")) {
                System.out.println("Введите задачу: ");
                input = scanner.nextLine();
                todoList.add(input);
                System.out.println(todoList.getTodos().size() + " - кол-во задач");
            } else if (input.equals("DELETE")) {
                System.out.println("Введите интекс задачи: ");
                index = scanner.nextInt();
                todoList.delete(index - 1);
                System.out.println("Список задач:\n" + todoList.getTodos().size() + " - кол-во задач");
            } else if (input.equals("EDIT")) {
                System.out.println("Введите новую задачу: ");
                input = scanner.nextLine();
                System.out.println("Введите интекс задачи: ");
                index = scanner.nextInt();
                System.out.println("Задачи обновлены: ");
                todoList.edit(index - 1, input);
                System.out.println(todoList.getTodos().size() + " - кол-во задач");
            } else if (input.equals("LIST")) {
                System.out.println(todoList.getTodos().size() + " - кол-во задач");
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
