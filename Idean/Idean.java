import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean {
	public static void main(String[] args) {
		IdeaMan im = new IdeaMan();
	}
}


class IdeaMan implements ActionListener {
	// field
	JFrame frame;
	JTextField fileName;
	JPanel filePanel;
	JButton openBtn;
	JButton saveBtn;
	JTextArea textArea;
	JScrollPane scrollPane;

	// method
	public IdeaMan() {
		// ウィンドウを作る
		frame = new JFrame("Idean");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// フィールド、パネルを作る
		fileName = new JTextField("Idean!", 15);

		openBtn = new JButton("開く");

		saveBtn = new JButton("保存");

		textArea = new JTextArea(10, 30);
		scrollPane = new JScrollPane(textArea);

		// パネルに、フィールドを載せる
		filePanel = new JPanel();
		filePanel.add(fileName);	
		filePanel.add(openBtn);
		filePanel.add(saveBtn);

		// ウィンドウに、パネルを載せる
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(filePanel);
		con.add(scrollPane);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		textArea.setText("ALOHA!");
	}
}
