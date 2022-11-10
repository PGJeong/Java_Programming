import javax.swing.*;
import java.awt.event.*;

class Bubble implements Runnable { // Runnable �������̽�
	JPanel panel;
	int x, y; // ���콺�� Ŭ���� ��ġ
	
	public Bubble(JPanel panel, int x, int y) {
		this.panel = panel;
		this.x = x; this.y = y;
	}
	
	@Override
	public void run() {
		ImageIcon img = new ImageIcon("C:\\Users\\PGJeong\\Desktop\\bubble.png");
		JLabel label = new JLabel(img);
		label.setSize(60, 60);
		label.setOpaque(false);
		panel.add(label);
		
		while(y > 0) { // ������ ContentPane�� ��ܿ� ������ �� ����
			try {
				label.setLocation(x, y); // label�� ��ġ�� x,y�� ����
				panel.getParent().repaint();
				
				Thread.sleep(20); // sleep()�� Thread Ŭ������ static �޼ҵ�
				y -= 5; // 20ms���� 5px�� ���� �̵�
			}
			catch(InterruptedException e) {
				return;
			}
		}
		
		panel.remove(label); // while���� ������ label ����
		panel.getParent().repaint();
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap13-06");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // ���콺�� Ŭ���� �� ���� ������ ���� �� ����
				Thread th = new Thread(new Bubble(panel, e.getX(), e.getY())); // Runnable �������̽��� ������ Bubble ��ü
				th.start();
			}
		});
		
		setContentPane(panel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
