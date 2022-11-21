import GUI.DndGui;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new DndGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        FileWriter fw = new FileWriter("heroes.json");
        DndGui.setFw(fw);
    }
}