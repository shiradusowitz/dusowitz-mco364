package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	private final Canvas canvas;
	private final BufferedImage bufferedImage;

	public BucketTool(Canvas canvas) {
		this.canvas = canvas;
		this.bufferedImage = canvas.getBufferedImage();
	}

	public void mousePressed(Graphics g, int x, int y, Color color) {
		g.setColor(color);
		fill(new Point(x, y), bufferedImage.getRGB(x, y), color.getRGB());
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {

	}

	public void drawPreview(Graphics g, Color color) {

	}

	private void fill(Point point, int sourceColor, int selectedColor) {
		Queue<Point> points = new LinkedList<Point>();
		points.add(point);

		while (!points.isEmpty()) {
			point = points.remove();
			int currentX = point.getX();
			int currentY = point.getY();

			int left = currentX;
			int right = currentX;
			int leftColor = bufferedImage.getRGB(left, currentY);
			int rightColor = bufferedImage.getRGB(right, currentY);

			while (leftColor == sourceColor) {
				left--;
				if (left > 0) {
					leftColor = bufferedImage.getRGB(left, currentY);
				} else {
					break;
				}
			}

			while (rightColor == sourceColor) {
				right++;
				if (right < bufferedImage.getWidth()) {
					rightColor = bufferedImage.getRGB(right, currentY);
				} else {
					break;
				}
			}

			for (int i = left; i < right; i++) {
				bufferedImage.setRGB(i, currentY, selectedColor);
			}

			if ((currentY + 1) < bufferedImage.getHeight()) {
				if (bufferedImage.getRGB(currentX, currentY + 1) == sourceColor) {
					points.add(new Point(currentX, currentY + 1));
				}
			}

			if ((currentY - 1) > 0) {
				if (bufferedImage.getRGB(currentX, currentY - 1) == sourceColor) {
					points.add(new Point(currentX, currentY - 1));
				}
			}
			bufferedImage.setRGB(point.getX(), point.getY(), selectedColor);
		}
		canvas.setBufferedImage(bufferedImage);
	}
}