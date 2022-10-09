import javax.swing.*;
import java.awt.*;
import javax.swing.event.*; // ChangeEvent, ChangeListener는 javax.swing.event 패키지

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap11-05");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 150);
		slider.setMajorTickSpacing(20);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		JLabel label = new JLabel(Integer.toString(slider.getValue()));
		label.setOpaque(true);
		label.setBackground(new Color(155, 255, 155));
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText(Integer.toString(slider.getValue()));
			}
		});
		
		c.add(slider);
		c.add(label);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
