import javax.swing.*;

@SuppressWarnings("serial") // java.io.Serializable 인터페이스를 간접적으로 구현하여 발생한 오류메시지 무시
public class MainFrame extends JFrame{
	public MainFrame() {
		setTitle("Let's study Java");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}