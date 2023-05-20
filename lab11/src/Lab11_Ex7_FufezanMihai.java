/*
 * 7. Implement a Java application that concatenates in a TextArea component
 * the content of the text files selected by the user, as the user chooses the
 * files. Each file’s content is preceded by the file’s name.
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lab11_Ex7_FufezanMihai {
    public Lab11_Ex7_FufezanMihai() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Choose the files to concatenate");
        label.setHorizontalAlignment(JLabel.CENTER);
        JFileChooser fileChooser = new JFileChooser();
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.weightx = 0.25;
        c.weighty = 0.25;
        panel.add(label, c);

        c.gridy = 1;
        panel.add(fileChooser, c);

        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        panel.add(scrollPane, c);

        fileChooser.addActionListener(e -> {
            File file = fileChooser.getSelectedFile();
            textArea.append(file.getName() + ":\n" + fileContents(file) + "\n");
        });

        JFrame frame = new JFrame("Lab11 Ex7 Fufezan Mihai");
        frame.add(panel);
        frame.setSize(480, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String fileContents(File file) {
        try {
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab11_Ex7_FufezanMihai::new);
    }
}
