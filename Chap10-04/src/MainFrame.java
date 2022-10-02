import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-04");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Java Programming");
		label.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					String str = label.getText();
					label.setText(str.substring(1) + str.substring(0, 1));
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
