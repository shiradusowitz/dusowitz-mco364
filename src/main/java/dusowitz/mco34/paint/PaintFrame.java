package dusowitz.mco34.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		setResizable(false);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();
		canvas.setTool(new PencilTool());

		line = new JButton();
		line.setIcon(new ImageIcon(new ImageIcon("./line.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new LineTool());
			}

		});
		pencil = new JButton();
		pencil.setIcon(new ImageIcon(new ImageIcon("./pencil.jpg").getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH)));
		pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new PencilTool());
			}

		});

		rectangle = new JButton();
		rectangle.setIcon(new ImageIcon(new ImageIcon("./rectangle.png").getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH)));
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new RectangleTool());
			}
		});

		oval = new JButton();
		oval.setIcon(new ImageIcon(new ImageIcon("./oval.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new OvalTool());
			}
		});

		bucket = new JButton();
		bucket.setIcon(new ImageIcon(new ImageIcon("./bucket.jpg").getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH)));
		bucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new BucketTool(canvas));
			}
		});

		JButton clear = new JButton();
		clear.setIcon(new ImageIcon(new ImageIcon("./clear.jpg").getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH)));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
				canvas.repaint();
			}
		});

		undo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon("./undo.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}
		});
		redo = new JButton();
		redo.setIcon(new ImageIcon(new ImageIcon("./redo.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}
		});

		colorChooser = new JColorChooser();
		colorChooser.setPreviewPanel(new JPanel());
		colorChooser.setPreferredSize(new Dimension(100, 140));
		colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {

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