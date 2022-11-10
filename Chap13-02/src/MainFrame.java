import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TimerThread extends Thread { // Thread�� java.lang ��Ű���� Ŭ�����̹Ƿ� ������ import �ʿ����
	JPanel panel;
	
	public TimerThread(JPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void run() { // run() �޼ҵ��� �ڵ� = ������ �ڵ�
		while(true) {
			try {
				sleep(500); // 0.5�� �������� ����
				panel.getParent().repaint(); // �θ� ������Ʈ���� �ٽ� �׸����ν� ������Ʈ�� ���� ��ġ�� �ܻ��� ���� p.668
				
				// sleep()�� ����ϴ� ��� try-catch ����� ������ ���� �߻�
				// sleep()�� ���� ���� �ڴ� ��� ���� �߻��� ����ϱ� ���� ������ �ʿ�
			}
			catch(InterruptedException e) {
				return; // InterruptedException�� �߻��ϴ� ��� run() �޼ҵ尡 ���� = ������ ����
			}
		}
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	class MyPanel extends JPanel { // ���� Ŭ����
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.MAGENTA);
			int x = (int)(Math.random() * this.getWidth());
			int y = (int)(Math.random() * this.getHeight());
			g.drawOval(x, y, 50, 50);
		}
	}
	
	public MainFrame() {
		setTitle("Chap13-02");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MyPanel panel = new MyPanel();
		TimerThread th = new TimerThread(panel);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				th.start(); // ���콺�� Ŭ���ϸ� ������ ����
			}
		});
		
		setContentPane(panel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
