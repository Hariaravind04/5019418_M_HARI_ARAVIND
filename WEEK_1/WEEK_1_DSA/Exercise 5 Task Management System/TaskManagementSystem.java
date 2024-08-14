public class TaskManagementSystem {

    static class Task {
        private int taskId;
        private String taskName;
        private String status;
        
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
        }
    }

    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskList {
        private Node head;

        public TaskList() {
            this.head = null;
        }

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public Task searchTask(int taskId) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.getTaskId() == taskId) {
                    return temp.task;
                }
                temp = temp.next;
            }
            return null;
        }

        public void traverseTasks() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.task);
                temp = temp.next;
            }
        }

        public void deleteTask(int taskId) {
            if (head == null) return;

            if (head.task.getTaskId() == taskId) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.task.getTaskId() != taskId) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        
        taskList.addTask(new Task(1, "Task A", "Incomplete"));
        taskList.addTask(new Task(2, "Task B", "Complete"));
        taskList.addTask(new Task(3, "Task C", "Incomplete"));
        
        System.out.println("Tasks:");
        taskList.traverseTasks();

        System.out.println("Searching for task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("Deleting task with ID 2:");
        taskList.deleteTask(2);
        
        System.out.println("Tasks after deletion:");
        taskList.traverseTasks();
    }
}
