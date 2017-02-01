import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean3 {
	public static void main(String[] arsg) {
		IdeaMan3 im3 = new IdeaMan3();
	}
}



class IdeaMan3 {
	// fild
	JFrame frame;
	JTextArea tango1;
	JTextArea tango2;
	JTextArea textArea;
	JPanel panel;
	JScrollPane scrollPane;

	public IdeaMan3() {
		// ウィンドウを作る
		frame = new JFrame("Idean3");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// テキストエリア、スクロールを作る
		tango1 = new JTextArea(1, 10);
		tango2 = new JTextArea(1, 10);
		textArea = new JTextArea(10, 30);
		scrollPane = new JScrollPane(textArea);

		// パネルに載せる
		panel = new JPanel();
		panel.add(textArea);

		// ウィンドに、パネルを載せる
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(panel);
		con.add(scrollPane);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}
}
