import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class MainMenuScreen implements ActionListener{
	
	//fields
	//Main screen
	JFrame frame;
	JPanel panel;
	JLabel screen;
	
	JButton newListButton;
	JButton loadListButton;
	JButton searchButton;
	JButton exitButton;
	
	//Choosing checklist type
	JFrame typeFrame;
	JPanel typePanel;
	JLabel typeScreen;
	JButton simpleButton;
	JButton procedureButton;
	String checklistType;
	
	//Title
	JFrame newTitleFrame;
	JPanel newTitlePanel;
	JLabel newTitleScreen;
	JTextField newTitle;
	JButton okayButton;
	String userNewTitle;
	JLabel message;
	
	//Load files
	JFrame loadFileFrame;
	JPanel loadFilePanel;
	JLabel loadFileScreen;
	JComboBox<Object> loadFileNames;
	JButton okayButton2;
	public static ArrayList<String> allFileNames;
	String selectedFile;
	JLabel loadFileMessage;
	
	//Search Files
	JFrame searchFrame;
	JPanel searchPanel;
	JLabel searchScreen;
	JButton searchButton2;
	JButton goButton;
	JTextField searchKeyword;
	JComboBox<Object> searchResultsBox;
	ArrayList<String> searchResults;
	String keyword;
	JLabel searchMessage;
	
	public static int backgroundCount = 0;
	public static ImageIcon[] allBackgrounds = new ImageIcon[11];
	
	@SuppressWarnings("static-access")
	public MainMenuScreen() {
		
		allBackgrounds[0] = new ImageIcon("image files/Simple Checklist Template.png");
		allBackgrounds[1] = new ImageIcon("image files/Procedure Checklist Template.png");
		allBackgrounds[2] = new ImageIcon("image files/Red Background.png");
		allBackgrounds[3] = new ImageIcon("image files/Orange Background.png");
		allBackgrounds[4] = new ImageIcon("image files/Yellow Background.png");
		allBackgrounds[5] = new ImageIcon("image files/Green Background.png");
		allBackgrounds[6] = new ImageIcon("image files/Blue Background.png");
		allBackgrounds[7] = new ImageIcon("image files/Purple Background.png");
		allBackgrounds[8] = new ImageIcon("image files/Black Background.png");
		allBackgrounds[9] = new ImageIcon("image files/White Background.png");
		allBackgrounds[10] = new ImageIcon("image files/Brown Background.png");
		
		allFileNames = new ArrayList<>();
		//import file names
		try {
			File fileNames = new File("text files/All File Titles.txt");
			Scanner myReader = new Scanner(fileNames);
			while(myReader.hasNextLine()) {
				String name = myReader.nextLine();
				allFileNames.add(name);
			}
			myReader.close();
		}catch (FileNotFoundException err) {
			System.out.println("\"All File Titles\" File not found");
		}
		
		frame = new JFrame();
		frame.setSize(1920,1080);
		frame.setBounds(0,0,1920,1080);
		frame.setUndecorated(true);
		
		panel = new JPanel();
		panel.setBounds(0,0,1920,1080);
		panel.setLayout(null);
		frame.add(panel);
		
		screen = new JLabel(new ImageIcon("image files/Main Screen Template.png"));
		screen.setBounds(0,0,1920,1080);
		panel.add(screen);
		
		newListButton = new JButton(new ImageIcon("image files/New Button.png"));
		newListButton.setBounds(698,317,522,198);
		newListButton.setFocusable(false);
		newListButton.addActionListener(this);
		screen.add(newListButton);
		
		loadListButton = new JButton(new ImageIcon("image files/Load Button.png"));
		loadListButton.setBounds(698,523,522,198);
		loadListButton.setFocusable(false);
		loadListButton.addActionListener(this);
		screen.add(loadListButton);
		
		searchButton = new JButton(new ImageIcon("image files/Search Button.png"));
		searchButton.setBounds(700,728,517,136);
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		screen.add(searchButton);
		
		exitButton = new JButton(new ImageIcon("image files/Exit Button.png"));
		exitButton.setBounds(841,900,237,90);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		screen.add(exitButton);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	public void newList() {
		
		typeFrame = new JFrame();
		typeFrame.setSize(900,625);
		typeFrame.setBounds(510,240,900,625);
		typeFrame.setResizable(false);
		
		typePanel = new JPanel();
		typePanel.setBounds(0,0,900,625);
		typeFrame.add(typePanel);
		
		typeScreen = new JLabel(new ImageIcon("image files/Choose Type Template.png"));
		typeScreen.setBounds(0,0,900,625);
		typePanel.add(typeScreen);
		
		simpleButton = new JButton(new ImageIcon("image files/Simple Button.png"));
		simpleButton.setBounds(101,115,317,317);
		simpleButton.setFocusable(false);
		simpleButton.addActionListener(this);
		typeScreen.add(simpleButton);
		
		procedureButton = new JButton(new ImageIcon("image files/Procedure Button.png"));
		procedureButton.setBounds(486,115,317,317);
		procedureButton.setFocusable(false);
		procedureButton.addActionListener(this);
		typeScreen.add(procedureButton);
		
		typeFrame.setVisible(true);
	}
	
	public void inputTitle() {
		
		newTitleFrame = new JFrame();
		newTitleFrame.setSize(900,300);
		newTitleFrame.setBounds(510,390,900,300);
		newTitleFrame.setResizable(false);
		
		newTitlePanel = new JPanel();
		newTitlePanel.setBounds(0,0,900,300);
		newTitleFrame.add(newTitlePanel);
		
		newTitleScreen = new JLabel(new ImageIcon("image files/Create New Template.png"));
		newTitleScreen.setBounds(0,0,900,300);
		newTitlePanel.add(newTitleScreen);
		
		newTitle = new JTextField();
		newTitle.setBounds(50,100,800,35);
		newTitle.setFont(new Font("Sans Serif",Font.BOLD,30));
		newTitleScreen.add(newTitle);
		
		okayButton = new JButton(new ImageIcon("image files/Okay Button.png"));
		okayButton.setBounds(380,200,140,40);
		okayButton.setFocusable(false);
		okayButton.addActionListener(this);
		newTitleScreen.add(okayButton);
		
		message = new JLabel("");
		message.setBounds(50,150,800,25);
		message.setForeground(Color.RED);
		message.setFont(new Font("Sans Serif",Font.PLAIN,20));
		newTitleScreen.add(message);
		
		newTitleFrame.setVisible(true);
	}
	
	public void loadFile() {
		
		loadFileFrame = new JFrame();
		loadFileFrame.setSize(900,300);
		loadFileFrame.setBounds(510,390,900,300);
		loadFileFrame.setResizable(false);
		
		loadFilePanel = new JPanel();
		loadFilePanel.setBounds(0,0,900,300);
		loadFileFrame.add(loadFilePanel);
		
		loadFileScreen = new JLabel(new ImageIcon("image files/Choose a file template.png"));
		loadFileScreen.setBounds(0,0,900,300);
		loadFilePanel.add(loadFileScreen);
		
		loadFileNames = new JComboBox<Object>(allFileNames.toArray());
		loadFileNames.setBounds(60,120,780,35);
		loadFileNames.setBackground(Color.WHITE);
		loadFileNames.setFont(new Font("Sans Serif",Font.PLAIN,25));
		loadFileScreen.add(loadFileNames);
		
		okayButton2 = new JButton(new ImageIcon("image files/Go Button.png"));
		okayButton2.setBounds(380,200,115,40);
		okayButton2.setFocusable(false);
		okayButton2.addActionListener(this);
		loadFileScreen.add(okayButton2);
		
		loadFileMessage = new JLabel();
		loadFileMessage.setFont(new Font("Sans Serif",Font.PLAIN,15));
		loadFileMessage.setForeground(Color.RED);
		loadFileMessage.setBounds(60,160,200,20);
		loadFileScreen.add(loadFileMessage);
		
		if(allFileNames.isEmpty()) {
			loadFileMessage.setText("There are no existing files.");
			okayButton2.setVisible(false);
		}
		else {
			okayButton2.setVisible(true);
		}
		
		loadFileFrame.setVisible(true);
	}
	
	public void searchFiles() {
		
		searchFrame = new JFrame();
		searchFrame.setSize(900,500);
		searchFrame.setBounds(510,290,900,500);
		searchFrame.setResizable(false);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(0,0,900,500);
		searchFrame.add(searchPanel);
		
		searchScreen = new JLabel(new ImageIcon("image files/Search Template.png"));
		searchScreen.setBounds(0,0,900,500);
		searchPanel.add(searchScreen);
		
		searchButton2 = new JButton(new ImageIcon("image files/Search Button2.png"));
		searchButton2.setBounds(380,180,140,40);
		searchButton2.setFocusable(false);
		searchButton2.addActionListener(this);
		searchScreen.add(searchButton2);
		
		goButton = new JButton(new ImageIcon("image files/Go Button.png"));
		goButton.setBounds(733,408,115,40);
		goButton.setFocusable(false);
		goButton.addActionListener(this);
		goButton.setVisible(false);
		searchScreen.add(goButton);
		
		searchKeyword = new JTextField();
		searchKeyword.setBounds(50,140,800,35);
		searchKeyword.setFont(new Font("Sans Serif",Font.PLAIN,30));
		searchScreen.add(searchKeyword);
		
		searchResultsBox = new JComboBox<Object>();
		searchResultsBox.setBounds(50,290,800,35);
		searchResultsBox.setFont(new Font("Sans Serif",Font.PLAIN,30));
		searchResultsBox.setVisible(false);
		searchScreen.add(searchResultsBox);
		
		searchMessage = new JLabel();
		searchMessage.setFont(new Font("Sans Serif",Font.PLAIN,15));
		searchMessage.setForeground(Color.RED);
		searchMessage.setVisible(false);
		searchScreen.add(searchMessage);
		
		searchFrame.setVisible(true);
	}
	
	public void beginSearch() {
		
		keyword = searchKeyword.getText();
		if(keyword.isEmpty()) {
			searchMessage.setVisible(true);
			searchMessage.setBounds(363,220,200,30);
			searchMessage.setText("Keyword cannot be empty.");
			return;
		}
		for(String nameTemp : allFileNames) {
			
			//change to lower case (non-case sensitive)
			String nameTempLower = nameTemp.toLowerCase();
			String keywordLower = keyword.toLowerCase();
			
			//if keyword is in title, add to JComboBox
			if(nameTempLower.contains(keywordLower)) {
				searchResultsBox.addItem(nameTemp);
			}
			//Otherwise, go through the lines
			else{
				try {
					File fileCur = new File("text files/" + nameTemp);
					Scanner myReader = new Scanner(fileCur);
					while(myReader.hasNextLine()) {
						
						String line = myReader.nextLine();
						String[] lineBreak = line.split("&.&"); //Isolates text only
						
						if(lineBreak[0].toLowerCase().contains(keywordLower)) {
							searchResultsBox.addItem(nameTemp);
							break;
						}
					}
					myReader.close();
					
				}catch (FileNotFoundException err) {
					System.out.println("File not found");
				}	
			}
		}
		
		if(searchResultsBox.getItemCount()==0) {
			searchMessage.setBounds(386,220,200,30);
			searchMessage.setVisible(true);
			searchMessage.setText("Keyword not found.");
		}
		else {
			searchResultsBox.setVisible(true);
			goButton.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==exitButton) {
			frame.dispose();
		}
		if(e.getSource()==newListButton) {
			newList();
		}
		if(e.getSource()==simpleButton) {
			typeFrame.dispose();
			checklistType = "smp";
			inputTitle();
		}
		if(e.getSource()==procedureButton) {
			typeFrame.dispose();
			checklistType = "pcd";
			inputTitle();
		}
		if(e.getSource()==okayButton) {
			
			message.setText("");
			
			userNewTitle = newTitle.getText();
			
			if(userNewTitle.isBlank()) {
				message.setText("Title cannot be empty.");
				return;
			}
			for(String nameTemp : allFileNames) {
				if(userNewTitle.equals(nameTemp.substring(0,nameTemp.length()-6))) {
					message.setText("This title already exists.");
					return;
				}
			}
			
			if(checklistType.equals("smp")) {
				backgroundCount = 0;
				new SimpleChecklist(userNewTitle);
			}
			if(checklistType.equals("pcd")) {
				backgroundCount = 1;
				new ProcedureChecklist(userNewTitle);
			}
			frame.dispose();
			typeFrame.dispose();
			newTitleFrame.dispose();
		}
		if(e.getSource()==loadListButton) {
			loadFile();
		}
		if(e.getSource()==okayButton2) {
			
			selectedFile = (String)loadFileNames.getSelectedItem();
			if(selectedFile.substring(selectedFile.length()-3).equals("smp")) {
				backgroundCount = 0;
				new SimpleChecklist(selectedFile,"smp");
			}
			else if(selectedFile.substring(selectedFile.length()-3).equals("pcd")) {
				backgroundCount = 1;
				new ProcedureChecklist(selectedFile,"pcd");
			}
			loadFileFrame.dispose();
			frame.dispose();
		}
		if(e.getSource()==searchButton) {
			searchFiles();
		}
		if(e.getSource()==searchButton2) {
			
			searchMessage.setText("");
			searchResultsBox.removeAllItems();
			searchResultsBox.setVisible(false);
			goButton.setVisible(false);
			
			beginSearch();
			
		}
		if(e.getSource()==goButton) {
			
			String selectedList = (String) searchResultsBox.getSelectedItem();
			String type = selectedList.substring(selectedList.length() - 3);
			
			if(type.equals("smp")) {
				backgroundCount = 0;
				new SimpleChecklist(selectedList,type);
				searchFrame.dispose();
				frame.dispose();
			}
			else if(type.equals("pcd")) {
				backgroundCount = 1;
				new ProcedureChecklist(selectedList,type);
				searchFrame.dispose();
				frame.dispose();
			}
			else {
				System.out.println("Error going to file");
			}
		}
		
	}
	
	public static ArrayList<String> getAllFileNames(){
		return allFileNames;
	}
}
