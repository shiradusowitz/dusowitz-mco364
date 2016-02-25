package dusowitz.mco34.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final Canvas canvas = new Canvas();

		JButton line = new JButton("LINE");
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new LineTool());
			}

		});
		JButton pencil = new JButton("PENCIL");
		pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new PencilTool());
			}

		});

		JButton rectangle = new JButton("RECTANGLE");
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new RectangleTool());
			}
		});

		JButton oval = new JButton("OVAL");
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new OvalTool());
			}
		});

		JButton bucket = new JButton("BUCKET");
		bucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new BucketTool());
			}
		});

		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
				canvas.repaint();
			}
		});

		JPanel options = new JPanel();
		options.setLayout(new FlowLayout());
		options.add(line);
		options.add(pencil);
		options.add(rectangle);
		options.add(oval);
		options.add(bucket);
		options.add(clear);

		container.add(canvas, BorderLayout.CENTER);
		container.add(options, BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}