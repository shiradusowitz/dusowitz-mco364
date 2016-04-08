package dusowitz.mco34.paint;

public class CanvasRepaintManager {

	private final Canvas canvas;

	public CanvasRepaintManager(Canvas canvas) {
		this.canvas = canvas;
	}

	// repaint only a portion of the screen
	public void repaint(int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		canvas.repaint(x, y, width, height);
	}
}
