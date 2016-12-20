import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrameMan2 {
	public static void main(String[] args){
		FrameMan2 fm = new FrameMan2();
	}
}


// ↓"ActionListener" を実装(implements)する
class FrameMan2 implements ActionListener {
	// field
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	JLabel label;
	JButton button;
	JTextField textField;

	// method
	// コンストラクタ( 召喚時に一度だけ実行されるメソッド )
	public FrameMan2(){
		// windowを作る・設定する
		frame = new JFrame();
		frame.setBounds(650, 50, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout( new BorderLayout() );

		// パーツを作る
		panel1 = new JPanel();
		panel2 = new JPanel();
		label = new JLabel("こんにちわ！");
		button = new JButton("押してね！");
		textField = new JTextField(10);
		textField.setColumns(15);

		// ボタンに ActionListener をつける
		button.addActionListener(this);

		// パーツを乗せる
		panel1.add(textField);
		panel1.add(button);
		panel2.add(label);
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);

		// windowを表示する
		frame.setVisible(true);
	} // コンストラクタの終わり


	// クリックに反応するメソッド
	public void actionPerformed(ActionEvent e) {
		String data = textField.getText();
		label.setText(data);
	}
}





