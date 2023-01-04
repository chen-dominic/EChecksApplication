/** Author: Dominic Chen
 * 
 *  Date: January 17th, 2022
 *  
 * 	Code: ICS4U1-02
 * 
 *  Title: E-Checks
 *  
 * 	Description: A checklist application with customizable and unique features. The application offers two different types of checklist,
 * 	simple and procedure. Simple checklist is the most basic checklist, and a procedure checklist is a numbered checklist. There is
 * 	saving and loading implemented, so the user can go back to their checklist if left uncompleted. The user has a choice to customize
 * 	font and colour for each line of the checklist, and a choice for the background colour. Finally, there is a search feature, in which
 * 	the user can enter a keyword and all of the existing checklist files will be searched for the keyword. This is useful when there are
 * 	many checklist files and the user cannot remember a certain checklist title.
 * 
 * 	Features:
 *  - Checklist Types
 *  - Customizable Lines
 *  - Customizable Backgrounds
 *  - Saving and Load Checklist
 *  - Search Keyword in All Existing Checklist
 *  
 *  Major Skills:
 *  - Java GUI (javax.swing package)
 *  - Object Oriented Programming
 *  - Enhanced for loops
 *  - Working with text files (java.io.file package)
 *  	- Reading text files
 *  	- Writing into text files
 *  - Designing algorithms
 *  - Code Maintenance
 *  
 *  Areas of Concern:
 *  - Cannot delete singular lines or delete an existing checklist
 *  - Procedure was planned to only be completed in chronological order, but could not come up with algorithm that will work
 *  - Background colour does not save when loading an existing checklist
 *  - To delete a checklist, the title must be removed from "All File Titles.txt" and the text file with the title of the checklist
 *    is to be deleted as well
 */

public class EChecksApplication {
	
	public static void main(String[] args) {
		new MainMenuScreen();
	}

}
