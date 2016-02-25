package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {

	private int x;
	private int y;

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.drawLine(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
	}
}