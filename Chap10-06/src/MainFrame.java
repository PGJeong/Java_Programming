import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-06");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel label = new JLabel("+");
		label.setSize(10, 10);
		label.setLocation(100, 100);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = (int)Math.round(Math.random() * 300 + 50); // Math.round() : 소수점 이하를 반올림
				int y = (int)Math.round(Math.random() * 300 + 50); // 범위 : 50 ~ 350
				label.setLocation(x, y);
			}
		});
		
		c.add(label);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}