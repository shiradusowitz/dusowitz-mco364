package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Graphics;

public interface Tool {

	void mousePressed(Graphics g, int x, int y, Color color);

	void mouseReleased(Graphics g, int x, int y, Color color);

	void mouseDragged(Graphics g, int x, int y, Color color);

	void drawPreview(Graphics g, Color color);
}