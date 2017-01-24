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
		fileName = new JTextField("", 15);

		openBtn = new JButton("開く");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");

		saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");

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

		// ウィンドウを可視化する
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
	//	textArea.setText("ALOHA!");

		String cmd = ae.getActionCommand();

		String textFileName = "IdeaDam.txt";

		// 必要なデータを作る
		FileReader fr;
		BufferedReader br;

		if (cmd.equals("open")) {
			textArea.append("OPEN..." + '\n' + '\n');

			JFileChooser fc = new JFileChooser();

			fc.setCurrentDirectory(new File("IdeaDam.txt"));

			int ret = fc.showOpenDialog(frame);

			if (ret ==  JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				textFileName = file.getAbsolutePath();

				fileName.setText(textFileName);
			}

			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);
		
				String data;

				while((data = br.readLine()) != null) {
				textArea.append(data + '\n');
				}
			} catch(IOException e) {
				System.out.println("IOerrer");
			}
		} else if (cmd.equals("save")) {
			textArea.append("SAVE..." + '\n' + '\n');
			FileWriter fw = null;
			PrintWriter pw = null;

			try{
				fw = new FileWriter(textFileName);
				pw = new PrintWriter(fw);

				String data = textArea.getText();

				pw.println(data);
			} catch(IOException e) {
				System.out.println("IOerrer");
			} finally {
				try{
					fw.close();
					pw.close();
				} catch(IOException e) {
					System.out.println("IOerrer");
				}
			}
		}
	}
}
