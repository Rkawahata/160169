import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class AlohaWindow {
	public static void main(String[] args) {
		AlohaWindowMan awm = new AlohaWindowMan();
	}
}



class AlohaWindowMan implements ActionListener {
	// field
	JFrame frame;
	JButton openBtn;
	JButton saveBtn;
	JTextField fileName;
	JPanel panel;
	JTextArea textArea;
	JScrollPane scrollPane;

	// method
	public AlohaWindowMan() {
		// コンストラクタ
		// ウィンドウ、ボタン、フィールド、パネル全部の準備
		frame = new JFrame("AlohaWindow!");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openBtn = new JButton("開く");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");

		saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

		fileName = new JTextField(20);

		textArea = new JTextArea(10, 30);
		scrollPane = new JScrollPane(textArea);

		panel = new JPanel();
		panel.add(fileName);
		panel.add(openBtn);
		panel.add(saveBtn);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(panel);
		con.add(scrollPane);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String cmd;
		String textFile;
		FileReader fr;
		BufferedReader br;

		try{
			cmd = ae.getActionCommand();
			textFile = fileName.getText();
			fr = new FileReader(textFile);
			br = new BufferedReader(fr);

			if (cmd.equals("open")) {
				fileName.getText();
				fileName.setText("open");
			} else if (cmd.equals("save")) {
				fileName.setText("save");
			}
			String data = br.readLine();	// １行読む
			textArea.setText(data);	// 書き込み・表示
		} catch(IOException e) {
			System.out.println("IO error...");
		}
	}
}
