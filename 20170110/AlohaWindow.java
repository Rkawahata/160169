import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlohaWindow {
	public static void main(String[] args) {
		AlohaWindowMan awm = new AlohaWindowMan();
	}
}



class AlohaWindowMan {
	// field
	JFrame frame;
	MyButton button1;
	MyButton button2;
	JPanel panel;				// ボタンとフィールドを載せる
	JTextField fileNameField;

	// method
	public AlohaWindowMan() {
		// フレームを作る
		frame = new JFrame("AlohaWindow");
		frame.setLocation(600,50);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ボタンとフィールドをパネルに載せる
		button1 = new MyButton("Click Me!");
		button2 = new MyButton("開く");
		fileNameField = new JTextField("ALOHA", 20);

		panel = new JPanel();
		panel.add(fileNameField);
		panel.add(button1);
		panel.add(button2);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(panel);

		// 表示する
		frame.setVisible(true);
	}

	class MyButton	extends JButton	implements ActionListener {
		// コンストラクタ
		public MyButton(String str){
			super(str);
			addActionListener(this);
		}

		// ↓クリックしたときの処理
		public void actionPerformed(ActionEvent ae) {
			fileNameField.setText("Hello");
		}
	}
}
