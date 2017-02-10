import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;

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
		textField1 = new JTextField("", 10);
		textField2 = new JTextField("", 10);

		// ラベルを作る
		label1 = new JLabel("1player");
		label2 = new JLabel("2player");

		// ボタンを作る
		saveBtn = new JButton("決定");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

		nextBtn = new JButton("次へ");
		nextBtn.addActionListener(this);
		nextBtn.setActionCommand("next");

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

	public void actionPerformed(ActionEvent ae) {
		// 必要なデータを作る
		String cmd = ae.getActionCommand();
		String data1;
		String data2;
		int setHp;
		int setMp;
		Random rnd1 = new Random();
		Random rnd2 = new Random();
		int kz1;
		int kz2;
		int game = 1;

		if(cmd.equals("save")) {
			int[] hp = {100, 150, 200, 250, 300};
			kz1 = 4;

			int ran1 = rnd1.nextInt(kz1);
			int ran2 = rnd2.nextInt(kz1);

			data1 = textField1.getText();
			data2 = textField2.getText();

			log.setText(data1 + " VS " + data2 + '\n');
			log.append("HP" + data1 + ": " + hp[ran1] + " | ");
			log.append(data2 + ": " + hp[ran2] + '\n');

			int[] mp = {50, 100, 150, 200};
			kz2 = 3;

			int ran3 = rnd1.nextInt(kz2);
			int ran4 = rnd1.nextInt(kz2);

			data1 = textField1.getText();
			data2 = textField2.getText();

			log.append("MP" + data1 + ": " + mp[ran3] + " | ");
			log.append(data2 + ": " + mp[ran4] + '\n');
			log.append("Fight!" + '\n' + '\n');
		} else if (cmd.equals("next")) {
			if (this.hp >= 50) {
				kz1 = 50;
				int dmg = rnd1.nextInt(kz1);
				
			}
		}
	}
}