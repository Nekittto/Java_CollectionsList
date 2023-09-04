import java.util.ArrayList;

public class TodoList {
    ArrayList<String> Todo = new ArrayList();

    public void add(String todo) {
        Todo.add(todo);
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        if (index < Todo.size()) {
            Todo.add(index, todo);
        } else {
            Todo.add(todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(int index, String todo) {
        if (index < Todo.size()) {
            Todo.set(index, todo);
        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if (index < Todo.size()) {
            Todo.remove(index);
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список делa
        for (int i = 0; i < Todo.size(); i++) {
            System.out.println((i + 1) + ". " + Todo.get(i));
        }
        return Todo;
    }
}
