import javax.swing.*; //Swing ��Ű�� import
import java.awt.*; // ��ġ������ �� Container Ŭ����, Color Ŭ���� ���
import java.awt.event.*; // �̺�Ʈ ������, �̺�Ʈ ��ü �� �̺�Ʈ�� �ٷ�� ���� import

@SuppressWarnings("serial") // java.io.Serializable �������̽��� ���������� �����Ͽ� �߻��� �����޽��� ����
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-02");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		c.addMouseListener(new MyMouseAdapter()); // MouseListener ���
		c.addMouseMotionListener(new MyMouseAdapter()); // MouseMotionListener ���
		
		setVisible(true);
	}
	
	// MouseAdapter Ŭ������ MouseListener, MouseWheelListener, MouseMotionListener�� ��� ����
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) { // MouseMotionListener�� �߻�޼ҵ�
			Container c = (Container) e.getSource();
			c.setBackground(Color.YELLOW);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) { // MouseListener�� �߻�޼ҵ�
			Container c = (Container) e.getSource();
			c.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}