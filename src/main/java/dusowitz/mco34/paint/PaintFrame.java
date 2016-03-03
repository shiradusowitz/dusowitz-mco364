package dusowitz.mco34.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	private final JButton line, pencil;
	private final JButton rectangle;
	private final JButton oval;
	private final JButton bucket;
	private final JButton undo;
	private final JButton redo;
	private final Canvas canvas;
	private final JColorChooser colorChooser;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();
		canvas.setTool(new PencilTool());

		line = new JButton("LINE");
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new LineTool());
			}

		});
		pencil = new JButton("PENCIL");
		pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new PencilTool());
			}

		});

		rectangle = new JButton("RECTANGLE");
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new RectangleTool());
			}
		});

		oval = new JButton("OVAL");
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new OvalTool());
			}
		});

		bucket = new JButton("BUCKET");
		bucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new BucketTool(canvas.getBufferedImage()));
			}
		});

		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
				canvas.repaint();
			}
		});

		undo = new JButton("UNDO");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}
		});
		redo = new JButton("REDO");
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}
		});

		colorChooser = new JColorChooser(Color.MAGENTA);
		colorChooser.setPreviewPanel(new JPanel());
		colorChooser.getSelectionModel().addChangeListener(
				new ChangeListener() {

					public void stateChanged(ChangeEvent arg0) {
						Color newColor = colorChooser.getColor();
						canvas.setColor(newColor);
						setForeground(newColor);
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
		options.add(undo);
		options.add(redo);

		add(canvas, BorderLayout.CENTER);
		add(options, BorderLayout.NORTH);
		add(colorChooser, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}