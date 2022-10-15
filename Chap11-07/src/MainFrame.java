import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap11-07");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		
		JLabel label = new JLabel("Java");
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
			}
		});
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
		
		c.add(label, BorderLayout.CENTER);
		c.add(slider, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
