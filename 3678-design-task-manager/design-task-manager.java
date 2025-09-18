import java.util.*;

class TaskManager {

    private static class Task {
        int priority;
        int taskId;
        int userId;
        Task(int priority, int taskId, int userId) {
            this.priority = priority;
            this.taskId = taskId;
            this.userId = userId;
        }
    }

    private PriorityQueue<Task> pq;
    private Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        taskMap = new HashMap<>();
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            Task task = new Task(priority, taskId, userId);
            taskMap.put(taskId, task);
            pq.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(priority, taskId, userId);
        taskMap.put(taskId, task);  // overwrite if taskId was previously removed
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        if (oldTask != null) {
            Task newTask = new Task(newPriority, taskId, oldTask.userId);
            taskMap.put(taskId, newTask);
            pq.offer(newTask);
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy deletion
    }

    public int execTop() {
    while (!pq.isEmpty()) {
        Task task = pq.poll();
        Task current = taskMap.get(task.taskId);
        // Validate both priority and userId
        if (current != null && current.priority == task.priority && current.userId == task.userId) {
            taskMap.remove(task.taskId);
            return task.userId;
        }
    }
    return -1; // no tasks available
    }
}