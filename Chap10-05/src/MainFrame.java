import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-05");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Java Programming");
		label.setFont(new Font("Arial", Font.PLAIN, 10));
		label.addKeyListener(new KeyAdapter(){
			private static final int MAX_SIZE = 30;
			private static final int MIN_SIZE = 5;
			
			@Override
			public void keyReleased(KeyEvent e) {
				Font f = label.getFont();
				int size = f.getSize();
				
				if(e.getKeyChar() == '+') {
					if(size < MAX_SIZE)
						label.setFont(new Font("Arial", Font.PLAIN, size + 5));
				}
				
				if(e.getKeyChar() == '-') {
					if(size > MIN_SIZE)
						label.setFont(new Font("Arial", Font.PLAIN, size - 5));
				}
			}
		});
		
		c.add(label);
		
		setVisible(true);
		
		label.setFocusable(true);
		label.requestFocus();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
