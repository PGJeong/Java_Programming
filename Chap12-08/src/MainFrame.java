import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

@SuppressWarnings("serial")
class MyPanel extends JPanel {
	Vector<Circle> v = new Vector<Circle>();
	
	class Circle {
		private Point point; // 중심점
		private int radius; // 반지름
	}
	
	class MyMouseAdapter extends MouseAdapter {
		Circle c;
		
		@Override
		public void mousePressed(MouseEvent e) {
			c = new Circle();
			c.point = e.getPoint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			c.radius = (int) Math.sqrt((e.getX() - c.point.getX()) * (e.getX() - c.point.getX())
										+ (e.getY() - c.point.getY()) * (e.getY() - c.point.getY()));
			v.add(c);
			repaint();
		}
	}
	
	MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
	
	public MyPanel() {
		addMouseListener(myMouseAdapter);
		addMouseMotionListener(myMouseAdapter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // JPanel에 구현된 paintComponent() 호출
		
		g.setColor(Color.MAGENTA);
		for(int i = 0; i < v.size(); i++) {
			Circle c = v.elementAt(i);
			
			g.drawOval((int)c.point.getX(), (int)c.point.getY(), c.radius * 2, c.radius * 2);
		}
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap12-08");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
