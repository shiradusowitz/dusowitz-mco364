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

	private final JButton clear, undo, redo;
	private final Canvas canvas;
	private final JColorChooser colorChooser;
	private final ActionListener listener;
	private final JPanel toolbar;
	private final ToolButton[] buttons;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.WHITE);

		canvas = new Canvas();
		canvas.setTool(new PencilTool(canvas.getProperties()));

		toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBackground(Color.WHITE);

		listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ToolButton button = (ToolButton) e.getSource();
				canvas.setTool(button.getTool());
			}

		};

		buttons = new ToolButton[] { new ToolButton(new LineTool(canvas.getProperties()), "/line.png"),
				new ToolButton(new PencilTool(canvas.getProperties()), "/pencil.jpg"),
				new ToolButton(new RectangleTool(canvas.getProperties()), "/rectangle.png"),
				new ToolButton(new OvalTool(canvas.getProperties()), "/oval.jpg"),
				new ToolButton(new BucketTool(canvas.getProperties()), "/bucket.jpg") };

		for (ToolButton button : buttons) {
			toolbar.add(button);
			button.addActionListener(listener);
		}

		clear = new JButton();
		clear.setBackground(Color.WHITE);
		clear.setPreferredSize(new Dimension(70, 70));
		clear.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/clear.jpg")).getImage().getScaledInstance(
				60, 60, Image.SCALE_SMOOTH)));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
				canvas.repaint();
			}
		});

		undo = new JButton();
		undo.setBackground(Color.WHITE);
		undo.setPreferredSize(new Dimension(70, 70));
		undo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/undo.jpg")).getImage().getScaledInstance(60,
				60, Image.SCALE_SMOOTH)));
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}
		});
		redo = new JButton();
		redo.setBackground(Color.WHITE);
		redo.setPreferredSize(new Dimension(70, 70));
		redo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/redo.jpg")).getImage().getScaledInstance(60,
				60, Image.SCALE_SMOOTH)));
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

		toolbar.add(clear);
		toolbar.add(undo);
		toolbar.add(redo);

		add(canvas, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(colorChooser, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}