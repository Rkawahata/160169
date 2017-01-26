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
	JLabel word1;
	JLabel word2;
	JPanel worldsPanel;
	JPanel btnPanel;
	JButton openBtn;
	JButton saveBtn;
	JButton nextBtn;
	JButton pasteBtn;
	JTextArea textArea;
	JTextArea tango1;
	JTextArea tango2;
	JScrollPane scrollPane;

	// method
	public IdeaMan() {
		// ウィンドウを作る
		frame = new JFrame("Idean");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// フィールド、パネルを作る
		fileName = new JTextField("", 15);

		// ボタンを作る
		openBtn = new JButton("開く");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");

		saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

		nextBtn = new JButton("次へ");
		nextBtn.addActionListener(this);
		nextBtn.setActionCommand("next");

		pasteBtn = new JButton("貼り付け");
		pasteBtn.addActionListener(this);
		pasteBtn.setActionCommand("paste");

		// テキストエリア、スクロールを作る
		textArea = new JTextArea(10, 30);
		tango1 = new JTextArea(1, 10);
		tango2 = new JTextArea(1, 10);
		scrollPane = new JScrollPane(textArea);

		word1 = new JLabel("WORD1");
		word2 = new JLabel("WORD2");

		// パネルに、フィールドを載せる
		worldsPanel = new JPanel();
		worldsPanel.add(tango1);
		worldsPanel.add(word1);
		worldsPanel.add(tango2);
		worldsPanel.add(word2);

		btnPanel = new JPanel();
		btnPanel.add(openBtn);
		btnPanel.add(saveBtn);
		btnPanel.add(nextBtn);
		btnPanel.add(pasteBtn);

		// ウィンドウに、パネルを載せる
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(worldsPanel);
		con.add(btnPanel);
		con.add(scrollPane);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		// 必要なデータを作る
		String cmd = ae.getActionCommand();
		String textFileName = "IdeaMan.txt";
		String data;
		String tangoDam = "IdeaDam.txt";

		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;

		if (cmd.equals("open")) {
/*			上書きから付け足し
			textArea.setText("OPEN...");
			textArea.append("OPEN..." + '\n');
*/
			// ｢ファイルを開く｣を開く
			JFileChooser fc = new JFileChooser();

			// 表示するdirをきめる
			fc.setCurrentDirectory(new File("."));

			// ダイアログを作る
			int ret = fc.showOpenDialog(frame);

			// 選ばれたファイルを、調べる
			if (ret == JFileChooser.APPROVE_OPTION) {
				// 選ばれたファイル
				File file = fc.getSelectedFile();

				// ファイル名、保存場所を調べる
				textFileName = file.getAbsolutePath();

				// テキストフィールドに表示
				fileName.setText(textFileName);
			}

			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);

				while((data = br.readLine()) != null) {
					textArea.append(data + '\n');
				}
			} catch(IOException e) {
				System.out.println("IO error...");
			}
		} else if (cmd.equals("save")) {
			try{
				// ファイルを開く
				fw = new FileWriter(textFileName);
				pw = new PrintWriter(fw);

				// テキストエリアの内容を読み取る
				data = textArea.getText();
				
				// ファイルに書き込み、保存する
				pw.println(data);

			} catch(IOException e) {
				System.out.println("IO error...");
			} finally {
				// ファイルを閉じる
				try{
					fw.close();
					pw.close();
				} catch(IOException e) {
					System.out.println("IO error...");				
				}
			}
		} else if (cmd.equals("next")) {
			try{
				fr = new FileReader(tangoDam);
				br = new BufferedReader(fr);

				while( (data = br.readLine()) != null ){
					String[] data2;
					int num1;
					int num2;

					data2 = data.split(",");
					num1 = (int)(Math.random()*9);
					num2 = (int)(Math.random()*9);

					tango1.setText(data2[num1]);
					tango2.setText(data2[num2]);
				}

			} catch(IOException e) {
				System.out.println("IOerrer");
			}
		} else if (cmd.equals("paste")) {
			String text1;
			String text2;

			text1 = tango1.getText();
			text2 = tango2.getText();

			textArea.append(text1 + "," + text2 + '\n');
		}
	}
}
