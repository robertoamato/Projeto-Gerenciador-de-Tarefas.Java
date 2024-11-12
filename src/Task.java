import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    // Getters e Setters

    @Override
    public String toString() {
        return title + " - " + (isCompleted ? "Concluída" : "Pendente") + " - Vence em: " + dueDate;
    }
}
