public class Aloha {
	public static void main(String[] args){
		// Alohamanを新規作成
		Alohaman am = new Alohaman();

		// Alohamanの、seyAloha()を実行させる
		// args[]の個数によって、つかいわける。
		int num = args.length;

		if (num == 0) {
			am.sayAloha();
		} else if (num == 1) {
		int data1 = Integer.parseInt(args[0]);
			am.sayAloha(data1);
		} else if (num == 2) {
		int data1 = Integer.parseInt(args[0]);
		int data2 = Integer.parseInt(args[1]);
			am.sayAloha(data1, data2);
		} else {
			System.out.println("error...");
			System.out.println("入力データが多すぎます");
		}
	}
}



class Alohaman {
	// field: データ
	private String msg1;
	private String msg2;

	// method: メソッド
	public Alohaman(){
		// コンストラクタ。インスタンスをつくるとき自動的に実行される。
		this.msg1 = "ALOHA!";
		this.msg2 = "あろは！";
	}

	public void sayAloha() {
		// メッセージを入力する
		System.out.println(this.msg1);
	}

	public void sayAloha(int n) {
		// "ALOHA!"と20回出力する
		for(int i = 0; i < n; i++) {
			System.out.println(this.msg1+i);
		}
	}

	public void sayAloha(int n, int x) {
		for (int i = 0; i < n; i++) {
			// x回に1回「あろは！」と出力する
			if (i%x == 0) {
				System.out.println(this.msg2+i);
			} else {
				System.out.println(this.msg1+i);
			}
		}
	}
}

