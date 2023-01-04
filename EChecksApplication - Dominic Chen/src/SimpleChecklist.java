import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleChecklist implements ActionListener{
	
	//fields
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	ArrayList<String> nameOfAllFiles = new ArrayList<String>();
	ArrayList<CheckLine> checkLines = new ArrayList<CheckLine>();
	
	JLabel simpleBackground;
	JButton newButton;
	JButton saveButton;
	JButton clearButton;
	JButton homeButton;
	JButton editTitle;
	JButton changeBackground;
	JLabel title;
	JLabel saveMessage;
	JLabel clearMessage;
	String titleText;
	String wholeTitle;
	
	//fields for new line frame
	JFrame newFrame;
	JLabel addLineScreen;
	JLabel errorMessage;
	
	String selectedFont;
	int selectedStyle;
	Color selectedColor;
	
	String tempStyle;
	String tempColor;
	
	JTextArea inputNewLine;
	
	String[] fontTypes = {"Sans Serif","Serif"};
	String[] styleTypes = {"Plain","Italic","Bold"};
	String[] colorTypes = {"Black","White","Red","Blue","Green","Yellow","Orange","Grey","Purple"};
	
	JComboBox<Object> fontDropDown;
	JComboBox<Object> styleDropDown;
	JComboBox<String> colorDropDown;
	
	JButton okayButton;
	
	//fields for exit without saving frame
	JFrame saveOrNoFrame;
	JPanel saveOrNoPanel;
	JLabel saveOrNoScreen;
	JButton yesButton;
	JButton noButton;
	
	int lineCount = 0;
	boolean changesMade = false;
	
	//constructor
	public SimpleChecklist(String titleText) {
		
		nameOfAllFiles = MainMenuScreen.getAllFileNames();
		
		this.titleText = titleText;
		wholeTitle = titleText + " - smp";
		
		frame.setSize(1920,1080);
		frame.setBounds(0,0,1920,1080);
		frame.setUndecorated(true);
		
		panel.setSize(1920,1080);
		panel.setBounds(0,0,1920,1080);
		panel.setLayout(null);
		frame.add(panel);
		
		simpleBackground = new JLabel(MainMenuScreen.allBackgrounds[MainMenuScreen.backgroundCount]);
		simpleBackground.setBounds(0,0,1920,1080);
		panel.add(simpleBackground);
		
		newButton = new JButton(new ImageIcon("image files/New+ Button.png"));
		newButton.setBounds(1325,175,150,50);
		newButton.setFocusable(false);
		newButton.addActionListener(this);
		simpleBackground.add(newButton);
		
		saveButton = new JButton(new ImageIcon("image files/Save Button.png"));
		saveButton.setBounds(1705,920,140,40);
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		simpleBackground.add(saveButton);
		
		clearButton = new JButton(new ImageIcon("Image files/Clear Button.png"));
		clearButton.setBounds(1706,61,115,40);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		simpleBackground.add(clearButton);
		
		homeButton = new JButton(new ImageIcon("Image files/Home Button.png"));
		homeButton.setBounds(99,61,115,40);
		homeButton.setFocusable(false);
		homeButton.addActionListener(this);
		simpleBackground.add(homeButton);
		
		changeBackground = new JButton(new ImageIcon("image files/Change Button.png"));
		changeBackground.setBounds(99,920,140,40);
		changeBackground.addActionListener(this);
		simpleBackground.add(changeBackground);
		
		title = new JLabel(titleText);
		title.setBounds(588,185,600,60);
		title.setFont(new Font("Sans Serif", Font.BOLD, 50));
		title.setForeground(Color.BLACK);
		simpleBackground.add(title);
		
		saveMessage = new JLabel();
		saveMessage.setFont(new Font("Sans Serif",Font.BOLD,15));
		saveMessage.setBounds(1705,880,300,30);
		simpleBackground.add(saveMessage);
		
		clearMessage = new JLabel();
		clearMessage.setFont(new Font("Sans Serif",Font.BOLD,15));
		clearMessage.setBounds(1706,106,150,20);
		simpleBackground.add(clearMessage);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//overloaded constructor for loading existing checklist
	public SimpleChecklist(String existTitle,String type) {
		
		nameOfAllFiles = MainMenuScreen.getAllFileNames();
		
		this.titleText = existTitle.substring(0,existTitle.length() - 6);
		wholeTitle = existTitle;
		
		frame.setSize(1920,1080);
		frame.setBounds(0,0,1920,1080);
		frame.setUndecorated(true);
		
		panel.setSize(1920,1080);
		panel.setBounds(0,0,1920,1080);
		panel.setLayout(null);
		frame.add(panel);
		
		simpleBackground = new JLabel(MainMenuScreen.allBackgrounds[MainMenuScreen.backgroundCount]);
		simpleBackground.setBounds(0,0,1920,1080);
		panel.add(simpleBackground);
		
		newButton = new JButton(new ImageIcon("image files/New+ Button.png"));
		newButton.setBounds(1325,175,150,50);
		newButton.setFocusable(false);
		newButton.addActionListener(this);
		simpleBackground.add(newButton);
		
		saveButton = new JButton(new ImageIcon("image files/Save Button.png"));
		saveButton.setBounds(1705,920,140,40);
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		simpleBackground.add(saveButton);
		
		clearButton = new JButton(new ImageIcon("Image files/Clear Button.png"));
		clearButton.setBounds(1706,61,115,40);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		simpleBackground.add(clearButton);
		
		homeButton = new JButton(new ImageIcon("Image files/Home Button.png"));
		homeButton.setBounds(99,61,115,40);
		homeButton.setFocusable(false);
		homeButton.addActionListener(this);
		simpleBackground.add(homeButton);
		
		changeBackground = new JButton(new ImageIcon("image files/Change Button.png"));
		changeBackground.setBounds(99,920,140,40);
		changeBackground.addActionListener(this);
		simpleBackground.add(changeBackground);
		
		title = new JLabel(titleText);
		title.setBounds(588,185,600,60);
		title.setFont(new Font("Sans Serif", Font.BOLD, 50));
		title.setForeground(Color.BLACK);
		simpleBackground.add(title);
		
		saveMessage = new JLabel();
		saveMessage.setFont(new Font("Sans Serif",Font.BOLD,15));
		saveMessage.setBounds(1705,880,300,30);
		simpleBackground.add(saveMessage);
		
		clearMessage = new JLabel();
		clearMessage.setFont(new Font("Sans Serif",Font.BOLD,15));
		clearMessage.setBounds(1706,106,150,20);
		simpleBackground.add(clearMessage);
		
		loadLines();
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//add new line window
	private void addNewLine() {
		
		newFrame = new JFrame();
		newFrame.setSize(900,500);
		newFrame.setBounds(510,290,900,500);
		newFrame.setResizable(false);
		
		JPanel addLine = new JPanel();
		addLine.setBounds(0,0,900,500);
		newFrame.add(addLine);
		
		addLineScreen = new JLabel(new ImageIcon("image files/New Line Template.png"));
		addLineScreen.setBounds(0,0,900,500);
		addLine.add(addLineScreen);
		
		inputNewLine = new JTextArea();
		inputNewLine.setBounds(25,150,850,100);
		inputNewLine.setFont(new Font("Sans Serif",Font.PLAIN,35));
		addLineScreen.add(inputNewLine);
		
		fontDropDown = new JComboBox<Object>(fontTypes);
		fontDropDown.setBounds(28,331,125,25);
		addLineScreen.add(fontDropDown);
		
		styleDropDown = new JComboBox<Object>(styleTypes);
		styleDropDown.setBounds(386,331,125,25);
		addLineScreen.add(styleDropDown);
		
		colorDropDown = new JComboBox<String>(colorTypes);
		colorDropDown.setBounds(745,331,125,25);
		addLineScreen.add(colorDropDown);
		
		okayButton = new JButton(new ImageIcon("image files/Okay Button.png"));
		okayButton.setBounds(380, 400, 140, 40);
		okayButton.setFocusable(false);
		okayButton.addActionListener(this);
		addLineScreen.add(okayButton);
		
		newFrame.setVisible(true);
	}
	
	//takes in user input and adds line onto screen
	private void addLine() {
		
		changesMade = true;
		
		String text = inputNewLine.getText();
		selectedFont = fontTypes[fontDropDown.getSelectedIndex()];
		tempStyle = styleTypes[styleDropDown.getSelectedIndex()];
		tempColor = colorTypes[colorDropDown.getSelectedIndex()];
		
		errorMessage = new JLabel();
		errorMessage.setFont(new Font("Sans Serif",Font.PLAIN,15));
		errorMessage.setForeground(Color.RED);
		addLineScreen.add(errorMessage);
		
		if(lineCount == 8) {
			errorMessage.setBounds(375,370,200,40);
			errorMessage.setText("Exceeded Max Amount");
			return;
		}
		else if(!text.isEmpty()) {
			
			lineCount += 1;
			
			if(tempStyle.equals("Plain")) {
				selectedStyle = 0;
			}
			else if(tempStyle.equals("Bold")) {
				selectedStyle = 1;
			}
			else if(tempStyle.equals("Italic")) {
				selectedStyle = 2;
			}
			
			if(tempColor.equals("Black")) {
				selectedColor = Color.BLACK;
			}
			else if(tempColor.equals("White")) {
				selectedColor = Color.WHITE;
			}
			else if(tempColor.equals("Red")) {
				selectedColor = Color.RED;
			}
			else if(tempColor.equals("Blue")) {
				selectedColor = Color.BLUE;
			}
			else if(tempColor.equals("Green")) {
				selectedColor = Color.GREEN;
			}
			else if(tempColor.equals("Yellow")) {
				selectedColor = Color.YELLOW;
			}
			else if(tempColor.equals("Orange")) {
				selectedColor = Color.ORANGE;
			}
			else if(tempColor.equals("Grey")) {
				selectedColor = Color.GRAY;
			}
			else if(tempColor.equals("Purple")) {
				selectedColor = Color.MAGENTA;
			}
			
			JLabel tempLabel = new JLabel();
			tempLabel.setText(text);
			tempLabel.setFont(new Font(selectedFont,selectedStyle,30));
			tempLabel.setForeground(selectedColor);
			tempLabel.setBounds(587,242+87 * lineCount,700,35);
			
			JCheckBox tempCheckbox = new JCheckBox();
			tempCheckbox.setBounds(1312,245+87*lineCount,15,15);
			
			simpleBackground.add(tempLabel);
			simpleBackground.add(tempCheckbox);
			
			CheckLine tempCheckLine = new CheckLine(tempLabel,tempCheckbox,selectedFont,tempStyle,tempColor);
			checkLines.add(tempCheckLine);
			
			SwingUtilities.updateComponentTreeUI(frame);
			
			newFrame.dispose();
			
		}
		//if text field is blank
		else {
			errorMessage.setBounds(395,370,200,40);
			errorMessage.setText("Textfield is blank.");
			SwingUtilities.updateComponentTreeUI(newFrame);
		}
	}
	
	private void loadLines() {
		
		String[] data = new String[5];
		
		//import lines
		try {
			File selectedChecklist = new File("text files/" + wholeTitle);
			Scanner myReader = new Scanner(selectedChecklist);
			while(myReader.hasNextLine()) {
				
				String lineData = myReader.nextLine();
				data = lineData.split("&.&");
				
				String textTemp = data[0];
				String checkTemp = data[1];
				String fontTemp = data[2];
				String styleTemp = data[3];
				String colorTemp = data[4];
				
				boolean checked = Boolean.parseBoolean(checkTemp);
				
				JLabel tempLabel = new JLabel(textTemp);
				JCheckBox tempCheck = new JCheckBox();
				tempCheck.setSelected(checked);
				
				CheckLine tempLine = new CheckLine(tempLabel,tempCheck,fontTemp,styleTemp,colorTemp);
				checkLines.add(tempLine);
			}
			myReader.close();
			
			addLines();
			
		}catch (FileNotFoundException err) {
			System.out.println("\"All File Titles\" File not found");
		}
		
	}
	
	//adds existing lines to checklist screen
	private void addLines() {
		
		lineCount = checkLines.size();
		int index = 0;
		
		for(CheckLine tempLine : checkLines) {
			index += 1;
			
			String text = tempLine.getLabel().getText();
			selectedFont = tempLine.getFont();
			tempStyle = tempLine.getStyle();
			tempColor = tempLine.getColor();
			
			if(tempStyle.equals("Plain")) {
				selectedStyle = 0;
			}
			else if(tempStyle.equals("Bold")) {
				selectedStyle = 1;
			}
			else if(tempStyle.equals("Italic")) {
				selectedStyle = 2;
			}
			
			if(tempColor.equals("Black")) {
				selectedColor = Color.BLACK;
			}
			else if(tempColor.equals("White")) {
				selectedColor = Color.WHITE;
			}
			else if(tempColor.equals("Red")) {
				selectedColor = Color.RED;
			}
			else if(tempColor.equals("Blue")) {
				selectedColor = Color.BLUE;
			}
			else if(tempColor.equals("Green")) {
				selectedColor = Color.GREEN;
			}
			else if(tempColor.equals("Yellow")) {
				selectedColor = Color.YELLOW;
			}
			else if(tempColor.equals("Orange")) {
				selectedColor = Color.ORANGE;
			}
			else if(tempColor.equals("Grey")) {
				selectedColor = Color.GRAY;
			}
			else if(tempColor.equals("Purple")) {
				selectedColor = Color.MAGENTA;
			}
			
			JLabel tempLabel = new JLabel();
			tempLabel.setText(text);
			tempLabel.setFont(new Font(selectedFont,selectedStyle,30));
			tempLabel.setForeground(selectedColor);
			tempLabel.setBounds(587,242+87 *index,700,35);
			
			JCheckBox tempCheckbox = tempLine.getCheckbox();
			tempCheckbox.setBounds(1312,245+87*index,15,15);
			
			simpleBackground.add(tempLabel);
			simpleBackground.add(tempCheckbox);
				
			SwingUtilities.updateComponentTreeUI(frame);
			
		}
		
	}
	
	//saves data on txt file
	private void saveData() {
		try {
			//create new file
			File newList = new File("text files/" + wholeTitle);
			if(newList.createNewFile()) {
				System.out.println("File Created");
				String fileName = wholeTitle + "\n";
				Files.write(Paths.get("text files/All File Titles.txt"), fileName.getBytes(), StandardOpenOption.APPEND);
				addData();
			}
			//file already exists
			else {
				PrintWriter writer = new PrintWriter(newList);
				writer.print("");
				writer.close();
				System.out.println("File exists, rewriting file");
				addData();
			}
		}catch (IOException e){;
			saveMessage.setText("An error occured");
			saveMessage.setForeground(Color.RED);
			System.out.println("An error occured while creating a file");
			e.printStackTrace();
		}
	}
	
	//add data onto text files
	private void addData() {
		
		try {
			
			for(CheckLine tempLine : checkLines) {
				String textData = tempLine.getLabel().getText() + "&.&" + tempLine.getCheckbox().isSelected() + "&.&" + tempLine.getFont() + "&.&" + tempLine.getStyle() + "&.&" + tempLine.getColor() +"\n";
				Files.write(Paths.get("text files/" + wholeTitle), textData.getBytes(), StandardOpenOption.APPEND);
			}
			
			saveMessage.setText("Saved Successfully!");
			saveMessage.setForeground(Color.GREEN);
			
			Timer timer = new Timer(2000, event -> saveMessage.setText(""));
			timer.setRepeats(false);
			timer.start();
			
		}catch (IOException err) {
			System.out.println("error");
		}
		
	}
	
	private void exitWithoutSave() {
		
		saveOrNoFrame = new JFrame();
		saveOrNoFrame.setBounds(693,440,500,200);
		saveOrNoFrame.setResizable(false);
		saveOrNoFrame.setUndecorated(true);
		
		saveOrNoPanel = new JPanel();
		saveOrNoPanel.setBounds(693,440,500,200);
		saveOrNoFrame.add(saveOrNoPanel);
		
		saveOrNoScreen = new JLabel(new ImageIcon("image files/Exit Without Save Template.png"));
		saveOrNoScreen.setBounds(0,0,500,200);
		saveOrNoPanel.add(saveOrNoScreen);
		
		yesButton = new JButton(new ImageIcon("image files/Yes Button.png"));
		yesButton.setBounds(63,113,100,40);
		yesButton.setFocusable(false);
		yesButton.addActionListener(this);
		saveOrNoScreen.add(yesButton);
		
		noButton = new JButton(new ImageIcon("image files/No Button.png"));
		noButton.setBounds(336,113,100,40);
		noButton.setFocusable(false);
		noButton.addActionListener(this);
		saveOrNoScreen.add(noButton);
		
		saveOrNoFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//runs new line window
		if(e.getSource()==newButton) {
			addNewLine();
		}
		
		//runs add line method
		if(e.getSource()==okayButton) {
			addLine();
		}
		
		//runs save method
		if(e.getSource()==saveButton) {
			changesMade = false;
			saveMessage.setText("");
			saveData();
		}
		
		//redirects to home screen
		if(e.getSource()==homeButton) {
			if(!changesMade) {
				new MainMenuScreen();
				frame.dispose();
			}
			else {
				exitWithoutSave();
				System.out.println("Changes were made");
			}
		}
		
		if(e.getSource()==yesButton) {
			new MainMenuScreen();
			saveOrNoFrame.dispose();
			frame.dispose();
		}
		
		if(e.getSource()==noButton) {
			saveOrNoFrame.dispose();
		}
		
		//clears all lines on screen, clears array list with lines, and resets line count to 0
		if(e.getSource()==clearButton) {
			
			changesMade = true;
			
			clearMessage.setText("");
			
			if(!checkLines.isEmpty()) {
				
				checkLines.clear();
				lineCount = 0;
				
				new SimpleChecklist(titleText);
				frame.dispose();
				
			}
			else {
				clearMessage.setForeground(Color.RED);
				clearMessage.setText("List is empty");
			}
			
			
		}
		
		//background change
		if(e.getSource()==changeBackground) {
			
			MainMenuScreen.backgroundCount += 1;
			
			if(MainMenuScreen.backgroundCount == 11) {
				MainMenuScreen.backgroundCount = 0;
			}
			
			simpleBackground.setIcon(MainMenuScreen.allBackgrounds[MainMenuScreen.backgroundCount]);
			
		}
	}
}
