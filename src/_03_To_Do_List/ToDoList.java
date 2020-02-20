package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("add");
	JButton button2 = new JButton("view");
	JButton button3 = new JButton("remove");
	JButton button4 = new JButton("save");
	JButton button5 = new JButton("load");
	ArrayList<String> tasks = new ArrayList();

	void SetUp() {
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
	}

	public static void main(String[] args) {
		ToDoList bruh = new ToDoList();
		bruh.SetUp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			tasks.add(JOptionPane.showInputDialog("bruh"));
		}
		if (e.getSource() == button2) {
			JOptionPane.showMessageDialog(null, tasks);
		}
		if (e.getSource() == button3) {
			String s = JOptionPane.showInputDialog("which one to delete");
			int x = Integer.parseInt(s);
			tasks.remove(x);
		}
		if (e.getSource() == button4) {
			try {
				FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test.txt");
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				
				fw.write("\n" + tasks);
					
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
