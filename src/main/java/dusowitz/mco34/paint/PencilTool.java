package dusowitz.mco34.paint;

import java.awt.Graphics2D;

public class PencilTool extends Tool {

	private int x;
	private int y;
	private CanvasRepaintManager repaintManager;

	public PencilTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
		repaintManager.repaint(x, y, x + 1, y + 1);
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {

	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x, y, this.x, this.y);
		repaintManager.repaint(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
	}
}