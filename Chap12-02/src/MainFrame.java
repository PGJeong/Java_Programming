import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class MyPanel extends JPanel {
	private Point p = new Point(220, 220);
	
	public MyPanel() {
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				p.setLocation(e.getPoint()); // ���콺�� �巡�� �� �� ���� Point ���� ����
				repaint(); // ���콺�� �巡�� �� �� ���� MyPanel ������ ����
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // JPanel�� ������ paintComponent() ȣ��
		
		ImageIcon imgicon = new ImageIcon("C:/Users/PGJeong/Desktop/bg.jpg"); // ���Ϸκ��� �̹��� �ε�
		Image img = imgicon.getImage(); // �̹��� ���� ����
		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // �̹��� �׸���
		
		g.setColor(Color.GREEN); // �ʷϻ��� Graphics��ü g�� ������ ����
		g.fillOval((int)p.getX(), (int)p.getY(), 40, 40); // Point ������ 40x40ũ���� �� �׸���
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap12-02");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
