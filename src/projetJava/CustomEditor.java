package projetJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomEditor extends JFrame {
    private JButton btnRectangle;
    private JButton btnLine;
    private JButton btnSelect;
    private JPanel drawPanel;

    public CustomEditor() {
        // Set up the frame
        setTitle("Improved CSG Editor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
        setLayout(new BorderLayout());
        add(drawPanel, BorderLayout.CENTER);
    }

    private void initializeComponents() {
        // Create buttons
        btnRectangle = new JButton("Rectangle");
        btnRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to draw a rectangle
            }
        });

        btnLine = new JButton("Line");
        btnLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to draw a line
            }
        });

        btnSelect = new JButton("Select");
        btnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to select an object
            }
        });

        // Set up the draw panel
        drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add the buttons to a toolbar and add to frame
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(btnSelect);
        toolBar.add(btnLine);
        toolBar.add(btnRectangle);
        add(toolBar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CustomEditor editor = new CustomEditor();
                editor.setVisible(true);
            }
        });
    }
}


