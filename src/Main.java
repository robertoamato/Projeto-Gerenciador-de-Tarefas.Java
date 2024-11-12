import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Tarefa\n2. Visualizar Tarefas\n3. Marcar Tarefa como Concluída\n4. Remover Tarefa\n5. Salvar e Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (option == 1) {
                System.out.print("Digite o título da tarefa: ");
                String title = scanner.nextLine();
                System.out.print("Digite a descrição da tarefa: ");
                String description = scanner.nextLine();
                System.out.print("Digite a data de vencimento (AAAA-MM-DD): ");
                LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                taskManager.addTask(new Task(title, description, dueDate));

            } else if (option == 2) {
                System.out.println("\nTarefas:");
                for (int i = 0; i < taskManager.getTasks().size(); i++) {
                    System.out.println(i + ": " + taskManager.getTasks().get(i));
                }

            } else if (option == 3) {
                System.out.print("Digite o número da tarefa a marcar como concluída: ");
                int index = scanner.nextInt();
                taskManager.markTaskAsCompleted(index);

            } else if (option == 4) {
                System.out.print("Digite o número da tarefa a remover: ");
                int index = scanner.nextInt();
                taskManager.removeTask(index);

            } else if (option == 5) {
                FileHandler.saveTasks(taskManager.getTasks());
                System.out.println("Tarefas salvas com sucesso!");
                break;
            }
        }
    }
}
