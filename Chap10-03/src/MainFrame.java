import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap10-03");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Java Programming");
		
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JLabel label = (JLabel) e.getSource();
				
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					StringBuffer sb = new StringBuffer(label.getText());
					sb.reverse();
					label.setText(sb.toString());
				}
			}
		});
		
		c.add(label);
		
		setVisible(true); // setVisible(true) �޼ҵ�� �������� ����� �� ���Ƿ� ��Ŀ���� ����
		
		label.setFocusable(true);
		label.requestFocus(); // setVisible(true) �޼ҵ� �ڿ� ��Ŀ�� ����
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
