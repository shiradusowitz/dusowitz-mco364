package dusowitz.mco34.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private final Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(iconName)).getImage().getScaledInstance(60, 60,
				Image.SCALE_SMOOTH)));
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(70, 70));
	}

	public Tool getTool() {
		return tool;
	}
}