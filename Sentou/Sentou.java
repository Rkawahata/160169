import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

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
		String setHp;
		String setMp;
		int num1;
		int num2;
		int kz;

		File inFile = new File("HitPointSet.txt");
		File inFile2 = new File("ManaPointSet.txt");
		FileInputStream fis = null;
		InputStreamReader isr = null;
		FileReader fr = null;
		BufferedReader br = null;

		if(cmd.equals("save")) {
			try{
				fis = new FileInputStream(inFile);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);

				while( (setHp = br.readLine()) != null ) {
					String[] hp = null;
					kz = 4;

					hp = setHp.split(", ");
					num1 = (int)(Math.random()*kz);
					num2 = (int)(Math.random()*kz);

					data1 = textField1.getText();
					data2 = textField2.getText();

					log.setText(data1 + " VS " + data2 + '\n');
					log.append("HP" + data1 + ": " + hp[num1] + " | ");
					log.append(data2 + ": " + hp[num2] + '\n');
				}

				fis = new FileInputStream(inFile2);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);

				while( (setMp = br.readLine()) != null ) {
					String[] mp = null;
					kz = 3;

					num1 = (int)(Math.random()*kz);
					num2 = (int)(Math.random()*kz);

					mp = setMp.split(", ");
					data1 = textField1.getText();
					data2 = textField2.getText();

					log.append("MP" + data1 + ": " + mp[num1] + " | ");
					log.append(data2 + ": " + mp[num2] + '\n');
					log.append("Fight!" + '\n' + '\n');
				}
			} catch (IOException e) {
				System.out.println("IO Errer...");
			}
		} else if (cmd.equals("next")) {
			int game = 1;
			int hp = this;
			int mp = this;

		}
	}
}