import java.awt.FlowLayout;
import javax.swing.*;

public class Main {
	public static void main(String[] args){
		// 0. 変数・データを作る
		JFrame frame = new JFrame("はじめてのGUI");
		JButton button1 = new JButton("押してね");
		JButton button2 = new JButton("押すな");
		JLabel label1 = new JLabel("Hollo World!!");
		JLabel label2 = new JLabel("おはよう");

		// 1. GUIを作る・配置する
		frame.getContentPane().setLayout( new FlowLayout() );
		frame.getContentPane().add(button1);
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(button2);

		// 2. close設定( 閉じたら終了する )
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. windowサイズを設定する
		frame.setSize(400, 100);

		// 4. window見えるようにする
		frame.setVisible(true);
	}
}