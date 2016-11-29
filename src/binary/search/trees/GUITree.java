package binary.search.trees;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Jack Finlay - 1399273
 * @author Warrick Wills - 13831575
 */
public class GUITree extends JPanel {
    
    BinarySearchTree bst;

    @Override
    public void paintComponent(Graphics g) {
        // Draw Tree Here
        g.drawOval(5, 5, 25, 25);
        //super.paintComponent(g);
        //g.setColor(Color.yellow);
        //bst.drawTree(g, 240, 80);
        
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                GUITree gui = new GUITree();
                gui.setUpGUI();
            }
        };
        SwingUtilities.invokeLater(r);
    }

    //helpMenu
    public void helpMenu() {
        System.out.println("Help message");
        Object help = ("Welcome to the Binary Tree Creator.");
        JOptionPane.showMessageDialog(null, help);
    }

    //exit
    public void exit() {
        System.out.println("Quit pressed");
        System.exit(0);
    }

    //sets up the frame and menu
    public void setUpGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Tree GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu file = new JMenu();
        file.setText("File");
        menubar.add(file);
        JMenuItem exit = new JMenuItem();
        exit.setText("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        file.add(exit);
        
        JMenuItem helpContents = new JMenuItem();
        helpContents.setText("Help");
        helpContents.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                helpMenu();
            }
        });
        file.add(helpContents);
        
        JMenu treeOptions = new JMenu();
        treeOptions.setText("Alter Tree");
        menubar.add(treeOptions);
        
        frame.add(new GUITree());
        frame.setVisible(true);
    }

}
