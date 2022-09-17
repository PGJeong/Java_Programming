import javax.swing.*; // Swing ��Ű�� import
import java.awt.*; // ��ġ������ �� Container Ŭ����, Color Ŭ���� ���

@SuppressWarnings("serial") // java.io.Serializable �������̽��� ���������� �����Ͽ� �߻��� �����޽��� ����
public class MainFrame extends JFrame { // JFrame�� ��ӹ޾� ������ ����
	public MainFrame() { // Swing �������α׷������� �����ڿ� ������ �ڵ���� �Է��Ѵ�
		setTitle("Ten Color Buttons Frame"); // ������ Ÿ��Ʋ ����
		setSize(500, 200); // ������ ũ�� ����
		setLocationRelativeTo(null); // �����ӿ� ������� �߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� �� ���α׷��� ���� ����
		
		Container c = getContentPane(); // �����ӿ� ������ ����Ʈ���� ���� (����Ʈ���� Container Ÿ��)
		c.setLayout(new GridLayout(1, 10)); // GridLayout�� ����Ʈ���� ���ο� ��ġ�����ڷ� ����, 1x10 �׸���
		
		Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY}; // java.awt.Color Ŭ����
		
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i)); // JButton ������Ʈ ����
			btn.setBackground(colors[i]); // ��ư�� ���� colors[i] ������
			c.add(btn); // ����Ʈ�ҿ� ��ư �ޱ�
		}
		
		setVisible(true); // �������� ��µǵ��� ����. ������Ʈ���� �� ���̰� �� �������� ȣ���ؾ� �Ѵ�
	}
	
	public static void main(String[] args) { // Swing �������α׷����� main() �޼ҵ��� ����� �ּ�ȭ ����
		new MainFrame(); // Swing ������ ����. ���α׷��� ������
	}
}