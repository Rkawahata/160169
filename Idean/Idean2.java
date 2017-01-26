import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean2 {
	public static void main(String[] args) {
		IdeaMan2 im2 = new IdeaMan2();
	}
}



class IdeaMan2 implements ActionListener {
	// fild
	JFrame frame;
	JButton btn;
	JPanel panel;
	JTextArea textArea;

	// method
	public IdeaMan2() {
		// ウィンドウを作る
		frame = new JFrame("Idean");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn = new JButton("new!");

		panel = new JPanel();
		panel.add(btn);

		Container con = new frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(panel);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

	}
}