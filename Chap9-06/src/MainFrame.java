import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Random Labels");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i = 0; i < 20; i++) {
			int x = (int)(Math.random() * 200) + 50;
			int y = (int)(Math.random() * 200) + 50;
			
			JLabel label = new JLabel();
			label.setSize(10, 10);
			label.setLocation(x, y);
			label.setOpaque(true);
			label.setBackground(Color.blue);
			
			c.add(label);
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}