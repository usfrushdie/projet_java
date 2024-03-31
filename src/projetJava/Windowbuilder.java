package projetJava;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class Windowbuilder extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Windowbuilder frame = new Windowbuilder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Windowbuilder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1110, 817);
        this.setLocation(200,100);;
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        

        // Boutons
        JButton btnCircle = new JButton("Circle");
        btnCircle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCircle.setBackground(new Color(0, 255, 0));
        btnCircle.setBounds(10, 84, 113, 47);
        contentPane.add(btnCircle);

        JButton btnRectangle = new JButton("Rectangle");
        btnRectangle.setBackground(new Color(0, 255, 0));
        btnRectangle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRectangle.setBounds(145, 84, 113, 47);
        contentPane.add(btnRectangle);

        JButton btnOther = new JButton("Other");
        btnOther.setBackground(new Color(0, 255, 0));
        btnOther.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        	
        
        });
        btnOther.setBounds(280, 84, 113, 47);
        contentPane.add(btnOther);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 142, 1074, 625);
        contentPane.add(panel);
        
                JLabel lblFormsEditor = new JLabel("PolyMorph : Design your dreams");
                lblFormsEditor.setBounds(191, 11, 748, 50);
                contentPane.add(lblFormsEditor);
                lblFormsEditor.setForeground(new Color(0, 0, 0));
                lblFormsEditor.setFont(new Font("Tahoma", Font.BOLD, 40));
                lblFormsEditor.setHorizontalAlignment(SwingConstants.CENTER);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(new Color(255, 255, 255));
                panel_1.setBounds(0, 0, 1094, 73);
                contentPane.add(panel_1);
                panel_1.setLayout(new CardLayout(0, 0));
                
                JLabel lblNewLabel = new JLabel("");
                panel_1.add(lblNewLabel, "name_612034044413900");
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bayah\\OneDrive\\Images\\iTop Screenshot\\chmch2.jpeg"));
    }
}
