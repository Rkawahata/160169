import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Sentou {
	public static void main(String[] args) {
		SentouMan stm = new SentouMan();
	}
}



class SentouMan implements ActionListener {
	// field
	JFrame frame;
	JLabel label1;
	JLabel label2;
	JPanel panel;
	JPanel btnPanel;
	JButton saveBtn;
	JButton nextBtn1;
	JButton nextBtn2;
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
		textField1 = new JTextField("", 10);
		textField2 = new JTextField("", 10);

		// ラベルを作る
		label1 = new JLabel("1player");
		label2 = new JLabel("2player");

		// ボタンを作る
		saveBtn = new JButton("決定");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

		nextBtn1 = new JButton("攻撃1");
		nextBtn1.addActionListener(this);
		nextBtn1.setActionCommand("next1");

		nextBtn2 = new JButton("攻撃2");
		nextBtn2.addActionListener(this);
		nextBtn2.setActionCommand("next2");

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
		btnPanel.add(nextBtn1);
		btnPanel.add(nextBtn2);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(panel);
		con.add(btnPanel);
		con.add(scrollPane);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		// 必要なデータを作る
		String cmd = ae.getActionCommand();
		String data1;
		String data2;
		Random rnd = new Random();
		int hp1 = 100;
		int hp2 = 100;
		int game = 1;

		data1 = textField1.getText();
		data2 = textField2.getText();

		if (hp1 > 0 && hp2 > 0) {
			if(cmd.equals("save")) {
				log.setText(data1 + " VS " + data2 + '\n');
				log.append("HP" + data1 + ": " + hp1 + " | ");
				log.append(data2 + ": " + hp2 + '\n');
				log.append("Fight!" + '\n' + '\n');
			} else if (cmd.equals("next1")) {
				int dmg = rnd.nextInt(150);
				hp1 = hp1 - dmg;

				log.append(data1 + "の攻撃" + '\n');
				log.append(data2 + "の残りHP: " + hp1 + '\n');	
				if (hp1 <=0) {
						log.append('\n' + data1 + ": LOOSE");
				}
			} else if (cmd.equals("next2")) {
				int dmg = rnd.nextInt(150);
				hp2 = hp2 - dmg;

				log.append('\n' + data2 + "の攻撃" + '\n');
				log.append(data1 + "の残りHP: " + hp2 + '\n');
				if (hp2 <= 0) {
					log.append('\n' + data2 + ": LOOSE");
				}
			}
		}
	}
}