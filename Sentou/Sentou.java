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
	JTextField textField1;
	JTextField textField2;

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

		label1 = new JLabel("1player");
		label2 = new JLabel("2player");

		// パネルを作る、載せる
		panel = new JPanel();
		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(panel);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}
}