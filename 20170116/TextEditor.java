import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextEditor {
	public static void main(String[] args) {
		TextEditorMan tem = new TextEditorMan();
	}
}



class TextEditorMan implements ActionListener {
	// field
	JFrame frame; 
	JTextField fileName;
	JPanel filePanel;
	JButton openBtn;
	JButton saveBtn;
	JTextArea textArea;
	JScrollPane scrollPane;

	// method
	public TextEditorMan() {
		// ウィンドウを作る
		frame = new JFrame("TextEditor");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// フィールド、パネルを作る
		fileName = new JTextField("ALOHA!", 15);

		openBtn = new JButton("開く");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");

		saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

		textArea = new JTextArea(10, 30);
		scrollPane = new JScrollPane(textArea);

		// のせる
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

		// ウィンドウを可視化する
		frame.setVisible(true);
	}



	public void actionPerformed(ActionEvent ae){
		// テキストエリアに書き込む
//		textArea.setText("Aloha!");

		// コマンドを、調べる
		String cmd = ae.getActionCommand();

		String textFileName = "Aloha";

		// 必要なデータを作る
		FileReader fr;
		BufferedReader br;

		// もし、、、なら、、、
		if(cmd.equals("open")) {
			// 上書きから付け足し
//			textArea.setText("OPEN...");
			textArea.append("OPEN..." + '\n');
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

				// 
				String data;
				while((data = br.readLine()) != null) {
					textArea.append(data + '\n');
				}
			} catch(IOException e) {
				System.out.println("IO error...");
			}
		} else if (cmd.equals("save")) {
			// 上書きから付け足し
//			textArea.setText("SAVE...");
			textArea.append("SAVE..." + '\n');
			
			// 必要なデータを作る
			FileWriter fw = null;
			PrintWriter pw = null;

			try{
				// ファイルを開く
				fw = new FileWriter(textFileName);
				pw = new PrintWriter(fw);

				// テキストエリアの内容を読み取る
				String data = textArea.getText();
				
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
		}
	}
}