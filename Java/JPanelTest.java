// JFrameTest.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

						// ↓継承する・拡張する
public class JPanelTest extends JFrame {
	// コンストラクタ(特別メソッド; 初期化)
	public JPanelTest(){
		setSize(400, 300);
		setTitle("JPanelのテスト");

		// パネルを新規作成
//		MyJPanel myjp = new MyJPanel();

		// ラベルを新規作成
		JLabel label = new JLabel("Hollo World");

		Container c = getContentPane();

		// ラベルを張り付ける
		c.add(label);
	}

	// mainメソッド
	public static void main(String[] args){
		JFrame w = new JPanelTest();
		w.show();
	}
}


class MyJPanel extends JPanel {
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("ALOHA", 20, 40);
	}
}