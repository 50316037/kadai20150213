package kadai;

public class Kadai_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KadaiController controller = new KadaiController();
		Kadai_View frame = new Kadai_View(controller);
		frame.setBounds(5,5,655,455);
		frame.setVisible(true);

	}

}
