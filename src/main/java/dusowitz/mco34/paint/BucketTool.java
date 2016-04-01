package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {

	private final BufferedImage image;
	private final Queue<Point> points;
	private Color color;

	public BucketTool(PaintProperties properties) {
		super(properties);
		image = properties.getImage();
		points = new LinkedList<Point>();
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		color = properties.getColor();
		fill(x, y, color);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {

	}

	@Override
	public void drawPreview(Graphics2D g) {

	}

	private void fill(int x, int y, Color newColor) {
		Point point = new Point(x, y);
		int rgb = image.getRGB(x, y);
		int target = newColor.getRGB();
		if (rgb == target) {
			return;
		}
		points.add(point);

		while (!points.isEmpty()) {
			point = points.remove();
			x = point.getX();
			y = point.getY();

			if ((x < image.getWidth()) && (x >= 0) && (y < image.getHeight()) && (y >= 0)) {

				if (image.getRGB(x, y) == rgb) {
					image.setRGB(x, y, target);
					points.add(new Point(x, y + 1));
					points.add(new Point(x, y - 1));
					points.add(new Point(x + 1, y));
					points.add(new Point(x - 1, y));
				}
			}
		}
	}
}