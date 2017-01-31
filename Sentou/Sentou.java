import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Sentou {
	public static void main(String[] args) {
		SentouMan stm = new SentouMan();
	}
}



class SentouMan {
	// field
	JFrame frame;

	// method
	public SentouMan() {
		// ウィンドウを作る
		frame = new JFrame("戦闘");
		frame.setLocation(600, 50);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ウィンドウを可視化する
		frame.setVisible(true);
	}
}