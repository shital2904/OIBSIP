import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExamApplication app = new ExamApplication();
            app.setVisible(true);
        });
    }
}
