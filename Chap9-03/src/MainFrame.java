import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Ten Color Buttons Frame");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));
		
		for(int i = 0; i < 10; i++) {
			c.add(new JButton(Integer.toString(i)));
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}