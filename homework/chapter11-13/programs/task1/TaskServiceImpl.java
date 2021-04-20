import java.util.ArrayList;

class Eat implements Task {
    public void execute() {
        System.out.println("Eating!......");
    }
}
class Sleep implements Task {
    public void execute() {
        System.out.println("Sleeping!......");
    }
}
class Play implements Task {
    public void execute() {
        System.out.println("Playing!......");
    }
}

public class TaskServiceImpl implements TaskService {
    ArrayList<Task> taskList = new ArrayList<Task>();
    public static void main(String[] args) {
        TaskServiceImpl tSImpl = new TaskServiceImpl();
        Task t1 = new Eat();
        Task t2 = new Sleep();
        Task t3 = new Play();
        tSImpl.addTask(t1);
        tSImpl.addTask(t2);
        tSImpl.addTask(new Play());
        tSImpl.executeTasks();
    }
    public void executeTasks() {
        for(Task t : taskList) {
            t.execute();
        }
    }
    public void addTask(Task t) {
        taskList.add(t);
    }
}
