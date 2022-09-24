import javax.swing.*; //Swing 패키지 import
import java.awt.*; // 배치관리자 및 Container 클래스, Color 클래스 사용
import java.awt.event.*; // 이벤트 리스너, 이벤트 객체 등 이벤트를 다루기 위해 import

@SuppressWarnings("serial") // java.io.Serializable 인터페이스를 간접적으로 구현하여 발생한 오류메시지 무시
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-02");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		c.addMouseListener(new MyMouseAdapter()); // MouseListener 등록
		c.addMouseMotionListener(new MyMouseAdapter()); // MouseMotionListener 등록
		
		setVisible(true);
	}
	
	// MouseAdapter 클래스는 MouseListener, MouseWheelListener, MouseMotionListener를 모두 구현
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) { // MouseMotionListener의 추상메소드
			Container c = (Container) e.getSource();
			c.setBackground(Color.YELLOW);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) { // MouseListener의 추상메소드
			Container c = (Container) e.getSource();
			c.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}