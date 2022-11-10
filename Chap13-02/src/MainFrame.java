import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TimerThread extends Thread { // Thread는 java.lang 패키지의 클래스이므로 별도의 import 필요없음
	JPanel panel;
	
	public TimerThread(JPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void run() { // run() 메소드의 코드 = 스레드 코드
		while(true) {
			try {
				sleep(500); // 0.5초 간격으로 실행
				panel.getParent().repaint(); // 부모 컴포넌트부터 다시 그림으로써 컴포넌트의 이전 위치의 잔상을 지윰 p.668
				
				// sleep()을 사용하는 경우 try-catch 블록이 없으면 오류 발생
				// sleep()에 의해 잠을 자는 경우 예외 발생에 대비하기 위한 구문이 필요
			}
			catch(InterruptedException e) {
				return; // InterruptedException이 발생하는 경우 run() 메소드가 종료 = 스레드 종료
			}
		}
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	class MyPanel extends JPanel { // 내부 클래스
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
				th.start(); // 마우스를 클릭하면 스레드 시작
			}
		});
		
		setContentPane(panel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
