package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private final Stack<BufferedImage> undo;
	private final Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		setBackground(Color.WHITE);
		color = Color.BLACK;
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		undo.push(buffer);
		redo.push(buffer);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				buffer = deepCopy(undo.peek());
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY(), color);
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY(), color);
				undo.push(buffer);
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {

				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY(), color);

				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g, color);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void clear() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		undo.push(deepCopy(buffer));
		repaint();
	}

	public BufferedImage getBufferedImage() {
		return buffer;
	}

	public void setBufferedImage(BufferedImage image) {
		buffer = deepCopy(image);
		undo.push(buffer);
		repaint();
	}

	public void undo() {
		if (undo.size() > 1) {
			redo.push(buffer);
			buffer = undo.pop();
		}
		repaint();
	}

	public void redo() {
		if (redo.size() > 0) {
			undo.push(buffer);
			buffer = redo.pop();
		}
		repaint();
	}

	public BufferedImage deepCopy(BufferedImage image) {
		ColorModel cm = image.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = image.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

	public void setColor(Color newColor) {
		color = newColor;
	}
}