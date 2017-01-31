import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Sentou {
	public static void main(String[] args) {
		SentouMan stm = new SentouMan();
	}
}



class SentouMan {
	// field
	JFrame frame;
	JLabel label1;
	JLabel label2;
	JPanel panel;
	JPanel btnPanel;
	JButton saveBtn;
	JButton nextBtn;
	JTextField textField1;
	JTextField textField2;
	JTextArea log;
	JScrollPane scrollPane;

	// method
	public SentouMan() {
		// ウィンドウを作る
		frame = new JFrame("戦闘");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// テキストフィールドを作る
		textField1 = new JTextField("", 5);
		textField2 = new JTextField("", 5);

		// ラベルを作る
		label1 = new JLabel("1player");
		label2 = new JLabel("2player");

		// ボタンを作る
		saveBtn = new JButton("決定");

		nextBtn = new JButton("次へ");

		// テキストエリア、スクロールを作る
		log = new JTextArea(10, 30);
		scrollPane = new JScrollPane(log);

		// パネルを作る、載せる
		panel = new JPanel();
		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);

		btnPanel = new JPanel();
		btnPanel.add(saveBtn);
		btnPanel.add(nextBtn);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(panel);
		con.add(btnPanel);
		con.add(scrollPane);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}
}