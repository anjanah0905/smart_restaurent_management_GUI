import ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Restaurant Management System...");
            new MainFrame();
            System.out.println("Application launched successfully!");
        } catch (Exception e) {
            System.err.println("ERROR: Failed to start application");
            e.printStackTrace();
        }
    }
}
