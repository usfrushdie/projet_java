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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
=======
>>>>>>> aadbad5700602c7e63680bb105667f13d6f9680a
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class Windowbuilder extends JFrame {

    private JPanel contentPane;
    Rectangle t = new Rectangle(0,0,0,0);
	ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    private int shapeType = 1; // 0: Line, 1: Rectangle, 2: Circle

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
        
<<<<<<< HEAD
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                t.setX1(e.getX());
                t.setY1(e.getY());
            }

            public void mouseReleased(MouseEvent e) {
            	t.setX2(e.getX());
                t.setY2(e.getY());
                r.add(t);
                t.paint(getGraphics());
            }
        });
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        this.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		    	char ch = e.getKeyChar();
		        if (ch == 'q') {
		            System.exit(0);
		        }
		    }
		});
=======
        
>>>>>>> aadbad5700602c7e63680bb105667f13d6f9680a

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
        
        DrawingPanel panel = new DrawingPanel();;
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
