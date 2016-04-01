package dusowitz.mco34.paint;

import java.awt.Graphics2D;

public class LineTool extends Tool {

	private final PaintProperties properties;

	public LineTool(PaintProperties properties) {
		super(properties);
		this.properties = properties;
	}

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y2);
	}
}