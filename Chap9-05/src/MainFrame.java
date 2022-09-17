import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("4x4 Color Frame");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,4));
		
		Color colors[] = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta, Color.gray,
				Color.pink, Color.lightGray, Color.white, Color.darkGray, Color.black, Color.yellow, Color.blue, Color.magenta};
		
		for(int i = 0; i < 16; i++) {
			JLabel label = new JLabel(Integer.toString(i));
			label.setOpaque(true); // JLabel�� ����Ʈ ����� �����̱� ������ Opaque ���� true�� �������־�� ������ ����ȴ� (Opaque = ��������)
			label.setBackground(colors[i]);
			c.add(label);
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}