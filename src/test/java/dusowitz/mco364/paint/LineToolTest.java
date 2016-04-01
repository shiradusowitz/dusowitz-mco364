package dusowitz.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;
import org.mockito.Mockito;

import dusowitz.mco34.paint.LineTool;
import dusowitz.mco34.paint.PaintProperties;

public class LineToolTest {

	@Test
	public void testMouseReleased() {

		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);

		Graphics2D Graphics2D = Mockito.mock(Graphics2D.class);

		tool.mousePressed(Graphics2D, 5, 5);
		tool.mouseReleased(Graphics2D, 10, 10);

		Mockito.verify(Graphics2D).setColor(Color.RED);
		Mockito.verify(Graphics2D).drawLine(5, 5, 10, 10);
	}

	@Test
	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);

		Graphics2D Graphics2D = Mockito.mock(Graphics2D.class);

		tool.mousePressed(Graphics2D, 5, 5);
		tool.mouseDragged(Graphics2D, 6, 6);
		tool.drawPreview(Graphics2D);

		Mockito.verify(Graphics2D).drawLine(5, 5, 6, 6);
	}
}