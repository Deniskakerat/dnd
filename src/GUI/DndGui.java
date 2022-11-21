package GUI;
import CharacterCreator.Dice;
import CharacterCreator.Character;
import CharacterCreator.Stats;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileWriter;
import java.io.IOException;

import static GUI.Controller.printCharecter;
import static GUI.Controller.saveCharecter;

public class DndGui {
    public JPanel panel1;
    private JButton save;
    private JLabel name_label;
    private JTextField textField1;
    private JLabel calss_label;
    private JComboBox comboBox1;
    private JButton generate;
    private JButton savePointsButton;
    private JTextField str;
    private JTextField dex;
    private JTextField con;
    private JTextField ints;
    private JTextField wis;
    private JTextField cha;
    private JButton createCharecterButton;
    private JButton Close_button;
    private JTextArea textArea1;
    private JButton button1;
    private static String DndName;
    private static String DndClass;
    private static String Character;
    private static FileWriter fw;

    public static void setFw(FileWriter input_fw) {
        fw = input_fw;
    }

    public static FileWriter getFw() {
        return fw;
    }

    public static void setCharecter(String input_string) {
        Character = input_string;
    }

    public static String getCharecter() {
        return Character;
    }

    public static String getDndClass() {
        return DndClass;
    }


    public static void setClass(String inputclass) {
        DndClass = inputclass;
    }

    public static String getDndName() {
        return DndName;
    }

    public void setDndName(String inputname) {
        this.DndName = inputname;
    }

    /*public DndGui(JPanel panel1, JButton button1) {
        this.panel1 = panel1;
        this.button1 = button1;
        this.Jlabel = new JLabel();
    }*/

    public DndGui() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Save");
                name_label.setText(textField1.getText());
                setDndName(textField1.getText());
                saveCharecter();
            }
        });
        name_label.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calss_label.setText(comboBox1.getSelectedItem().toString());
                setClass(comboBox1.getSelectedItem().toString());
            }
        });
        calss_label.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

            }
        });
        createCharecterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCharecter("Name " + getDndName() + " \nClass " + getDndClass() +
                        "\nStats:\nStr: " + str.getText() +
                        "\nDex: " + dex.getText() +
                        "\nCon: " + con.getText() +
                        "\nInt: " + ints.getText() +
                        "\nWis: " + wis.getText() +
                        "\nCha: " + cha.getText()
                );
                textArea1.setText(Character);
                try {
                    printCharecter(fw, new Stats(Integer.parseInt(str.getText()), Integer.parseInt(dex.getText()),
                            Integer.parseInt(con.getText()), Integer.parseInt(ints.getText())
                            , Integer.parseInt(wis.getText()), Integer.parseInt(cha.getText())));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        savePointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice dice = new Dice();
                str.setText(Integer.toString(dice.rollstat()));
                dex.setText(Integer.toString(dice.rollstat()));
                con.setText(Integer.toString(dice.rollstat()));
                ints.setText(Integer.toString(dice.rollstat()));
                wis.setText(Integer.toString(dice.rollstat()));
                cha.setText(Integer.toString(dice.rollstat()));
            }
        });
    }

}
