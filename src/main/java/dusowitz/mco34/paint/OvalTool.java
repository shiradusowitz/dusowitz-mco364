package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.drawOval(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawOval(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
	}
}