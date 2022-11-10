import javax.swing.*;
import java.awt.event.*;

class Bubble implements Runnable { // Runnable 인터페이스
	JPanel panel;
	int x, y; // 마우스가 클릭된 위치
	
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
		
		while(y > 0) { // 버블이 ContentPane의 상단에 도착할 때 까지
			try {
				label.setLocation(x, y); // label의 위치를 x,y로 지정
				panel.getParent().repaint();
				
				Thread.sleep(20); // sleep()은 Thread 클래스의 static 메소드
				y -= 5; // 20ms마다 5px씩 위로 이동
			}
			catch(InterruptedException e) {
				return;
			}
		}
		
		panel.remove(label); // while문이 끝나면 label 제거
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
			public void mouseClicked(MouseEvent e) { // 마우스를 클릭할 때 마다 스레드 생성 후 실행
				Thread th = new Thread(new Bubble(panel, e.getX(), e.getY())); // Runnable 인터페이스를 구현한 Bubble 객체
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
