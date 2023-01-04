import javax.swing.*;

public class CheckLine {
	
	//fields
	JLabel text = new JLabel();
	JCheckBox checkbox = new JCheckBox();
	String font;
	String style;
	String color;
	
	//constructor
	public CheckLine(JLabel text, JCheckBox checkbox, String font, String style, String color) {
		super();
		this.text = text;
		this.checkbox = checkbox;
		this.font = font;
		this.style = style;
		this.color = color;
	}
	
	//getters and setters
	public JLabel getLabel() {
		return text;
	}

	public void setLabel(JLabel text) {
		this.text = text;
	}

	public JCheckBox getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(JCheckBox checkbox) {
		this.checkbox = checkbox;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
