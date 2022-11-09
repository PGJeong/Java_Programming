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
				p.setLocation(e.getPoint()); // 마우스가 드래그 될 때 마다 Point 지점 갱신
				repaint(); // 마우스가 드래그 될 때 마다 MyPanel 페인팅 실행
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // JPanel에 구현된 paintComponent() 호출
		
		ImageIcon imgicon = new ImageIcon("C:/Users/PGJeong/Desktop/bg.jpg"); // 파일로부터 이미지 로딩
		Image img = imgicon.getImage(); // 이미지 정보 추출
		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // 이미지 그리기
		
		g.setColor(Color.GREEN); // 초록색을 Graphics객체 g의 색으로 지정
		g.fillOval((int)p.getX(), (int)p.getY(), 40, 40); // Point 지점에 40x40크기의 원 그리기
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
