package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BucketTool implements Tool {

	private final BufferedImage image;

	public BucketTool(BufferedImage image) {
		this.image = image;
	}

	public void mousePressed(Graphics g, int x, int y, Color color) {
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {

	}

	public void drawPreview(Graphics g, Color color) {

	}
}