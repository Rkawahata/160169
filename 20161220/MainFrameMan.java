import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrameMan {
	public static void main(String[] args){
		FrameMan fm = new FrameMan();
	}
}


// ↓"ActionListener" を実装(implements)する
class FrameMan implements ActionListener {
	// field
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton button;

	// method
	// コンストラクタ( 召喚時に一度だけ実行されるメソッド )
	public FrameMan(){
		// windowを作る・設定する
		frame = new JFrame();
		frame.setBounds(650, 50, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout( new FlowLayout() );

		// パーツを作る
		panel = new JPanel();
		label = new JLabel("こんにちわ！");
		button = new JButton("押してね！");

		// ボタンに ActionListener をつける
		button.addActionListener(this);

		// パーツを乗せる
		// 	パーツを、パネル(JPanel)に載せる
		panel.add(label);
		panel.add(button);
		// 	パネルを、window(JFrame)に載せる
		frame.add(panel);

		// windowを表示する
		frame.setVisible(true);
	}

	// クリックに反応するメソッド
	public void actionPerformed(ActionEvent e) {
		label.setText("HALLO!");
	}
}