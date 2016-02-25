package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class BucketTool implements Tool {

	private List<Point> points = new ArrayList<Point>();

	public void mousePressed(Graphics g, int x, int y) {
		points.add(new Point(x, y));
	}

	public void mouseReleased(Graphics g, int x, int y) {

		Graphics2D g2d = (Graphics2D) g.create();
		List<Point> temp = new ArrayList<Point>(points);
		Path2D.Double path = new Path2D.Double();
		Point p = temp.remove(0);
		path.moveTo(p.getX(), p.getY());
		while (temp.size() > 0) {
			p = temp.remove(0);
			path.lineTo(p.getX(), p.getY());
		}

		g2d.setColor(Color.RED);
		g2d.fill(path);
		g2d.setColor(Color.BLACK);
		g2d.draw(path);
	}

	public void mouseDragged(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

	}
}