import javax.swing.*;

@SuppressWarnings("serial") // java.io.Serializable �������̽��� ���������� �����Ͽ� �߻��� �����޽��� ����
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