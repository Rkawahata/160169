import java.awt.*;
import javax.swing.*;

public class WindowTest {
	public static void main(String[] args) {
		// 変数を作る
		JFrame frame = new JFrame();
		JLabel label = new JLabel("こんにちわ！");
		JButton button = new JButton("押してね！");

		// windowの設定
		frame.setBounds(650, 50, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ×でプログラムを終了
		frame.setLayout( new FlowLayout() );

		// ラベルとボタンを張り付ける
		Container ctnr = frame.getContentPane();
		ctnr.add(label);
		ctnr.add(button);

		// windowを表示する
		frame.setVisible(true);
	}
}