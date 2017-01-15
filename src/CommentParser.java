import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentParser {
	
	private CommentParserState currentState;

	//counters
	private int numCommentsCounter = 0;
	private int numCodeCounter = 0;
	private int numJavadocCounter = 0;
	
	//others
	private JFileChooser fileChooser;
	private File openedFile;
	private JTextArea textField;
	
	public CommentParser() {
		JFrame parent = new JFrame();
		parent.setSize(1000, 1000);
		textField = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textField);
		parent.add(scrollPane);
		parent.setVisible(true);
		
		fileChooser = new JFileChooser();
		int retVal = fileChooser.showOpenDialog(parent);
		
		if(retVal == JFileChooser.APPROVE_OPTION) {
			openedFile = fileChooser.getSelectedFile();
		}
		
		changeState(CodeState.getInstance());
		
		analyzeText();
		
		printInfo();
	}
	
	public void analyzeText() {
		try {
			FileReader reader = new FileReader(openedFile);
			StringBuffer buffer = new StringBuffer();
			
			int text = reader.read();
			
			while(text != -1) {
				char ch = (char) text;
				
				if(ch == '/') {
					buffer.append((char) text);
					currentState.slash(this);
				}
				else if(ch == '*') {
					buffer.append((char) text);
					currentState.star(this);
				}
				else if(ch == '\\') {
					buffer.append((char) text);
					currentState.backslash(this);
				}
				else if(ch == '\"') {
					buffer.append((char) text);
					currentState.quote(this);
				}
				else if(ch == '\n') {
					buffer.append((char) text);
					currentState.endline(this);
				}
				else {
					buffer.append((char) text);
					currentState.character(this);
				}
				
				text = reader.read();
			}
			
			reader.close();
			
			textField.setText(buffer.toString());
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void changeState(CommentParserState newState) {
		currentState = newState;
	}
	
	@SuppressWarnings("static-access")
	public void printInfo() {
		JOptionPane p = new JOptionPane();
		p.showMessageDialog(null, "Number of Code Characters: " + getCodeCounter() + "\n" + "Number of Comment Characters: " + getCommentCounter() + "\n" + "Number of Javadoc Characters: " + getJavadocCounter());
		//p.showMessageDialog(null, "Number of Comment Characters: " + getCommentCounter());
		//p.showMessageDialog(null, "Number of Javadoc Characters: " + getJavadocCounter());
		System.out.println("Number of Code: " + getCodeCounter());
		System.out.println("Number of Comment: " + getCommentCounter());
		System.out.println("Number of Javadoc: " + getJavadocCounter());
	}
	
	public int getCodeCounter() {
		return numCodeCounter;
	}

	public void setCodeCounter(int numCodeCounter) {
		this.numCodeCounter = numCodeCounter;
	}
	
	public int getCommentCounter() {
		return numCommentsCounter;
	}

	public void setCommentCounter(int numCommentsCounter) {
		this.numCommentsCounter = numCommentsCounter;
	}

	public int getJavadocCounter() {
		return numJavadocCounter;
	}

	public void setJavadocCounter(int numJavadocCounter) {
		this.numJavadocCounter = numJavadocCounter;
	}
}
