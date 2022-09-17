import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class NorthPanel extends JPanel {
	public NorthPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setOpaque(true);
		setBackground(Color.lightGray);
		
		add(new JButton("����"));
		add(new JButton("�ݱ�"));
		add(new JButton("����"));		
	}
}

@SuppressWarnings("serial")
class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		
		for(int i = 0; i < 10; i++) {
			int x = (int)(Math.random() * 200) + 50;
			int y = (int)(Math.random() * 100) + 50;
			
			JLabel label = new JLabel("*");
			label.setForeground(Color.red); // ���ڻ� ����
			label.setLocation(x, y);
			label.setSize(10, 10);
			add(label);
		}
	}
}

@SuppressWarnings("serial")
class SouthPanel extends JPanel {
	public SouthPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setOpaque(true);
		setBackground(Color.yellow);
		
		add(new JButton("Word Input"));
		add(new JTextField(15));
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("���� ���� �г��� ���� ������");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}