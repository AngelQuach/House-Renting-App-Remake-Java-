import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class user_win extends JFrame implements ActionListener{
	//global var.
	//object of user
	user user_obj = new user();
	//user avatar
	String user_name;
	JTextField user_name_txt_f;
	JLabel user_avatar_l;
	ImageIcon user_avatar_img;
	//user's words
	JTextArea user_txt_a;
	//button to next pop-up win
	ImageIcon but_pic;
	JButton next_but;
	//txt font
	Font reminder_f = new Font("Comic Sans MS", Font.BOLD, 10);
	Font word_f = new Font("Comic Sans MS", Font.PLAIN, 12);
	//setup layers
	JLayeredPane layeredPane;
	//temp var. that stores context and indicator
	String user_context;
	int user_indicator;
	//JLabel for reminder
	JLabel reminder;
	
	//constructor
	public user_win (user user_obj, String context, int indicator) {
		//store user object
		this.user_obj.copy(user_obj);
		//store context and indicator
		user_context = context;
		user_indicator = indicator;
		
		//set up the shared parts
		//setup layers
		layeredPane = new JLayeredPane();
	
		//User's avatar
		//link pic + place it
		user_avatar_img = new ImageIcon("P_uavatar0_userwin.jpg");
		user_avatar_l = new JLabel(user_avatar_img);
		user_avatar_l.setBounds(10, 10, user_avatar_img.getIconWidth(), user_avatar_img.getIconHeight());
		
		//if it is regarding welcoming plot
			//1st time to get user name
			if(context == "welcome" && user_indicator == 0) {
				//User's words
				user_txt_a = new JTextArea("\n    Hi, Sarah! Thank you for the instruction! Nice"
						+ "\n to meet you, I am:");
				user_txt_a.setFont(word_f);
				reminder = new JLabel("Reminder: You can edit it later.");
				reminder.setFont(reminder_f);
				reminder.setBounds(30 + user_avatar_img.getIconWidth(), 70, 280, 20);
				
				//space for entering user name
				user_name_txt_f = new JTextField(30);
				user_name_txt_f.setBounds(130 + user_avatar_img.getIconWidth(), 47, 100, 20);
				
				//confirm button
				next_but = new JButton("Confirm");
				next_but.setFont(word_f);
				next_but.setBounds(285, 70, 80, 25);
				next_but.addActionListener(this);
			}
		
		//shared parts continue
			//User's words continue
			user_txt_a.setFont(word_f);
			user_txt_a.setBounds(20 + user_avatar_img.getIconWidth(), 10, 280, 90);
			user_txt_a.setEditable(false);
			
			//add comps to layers
			layeredPane = new JLayeredPane();
			layeredPane.add(user_avatar_l, JLayeredPane.MODAL_LAYER);
			layeredPane.add(user_txt_a, JLayeredPane.MODAL_LAYER);
			layeredPane.add(user_name_txt_f, JLayeredPane.POPUP_LAYER);
			layeredPane.add(reminder, JLayeredPane.POPUP_LAYER);
			layeredPane.add(next_but, JLayeredPane.POPUP_LAYER);
			
			//setup window
			//set close operation; set size and not resizable
			this.setTitle("Conversation Ongoing...");
			this.setLayeredPane(layeredPane);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setSize(400, 150);
			this.setVisible(true);
	}
	
	//mouse interaction
		public void actionPerformed(ActionEvent e) {
			//user's action
			Object choice = e.getSource();

			//close if user clicked on next button
			if(choice == next_but) {
				this.setVisible(false);
				//if this is the stage where user first enter their name in the welcoming plot
				if(user_context == "welcome" && user_indicator == 0){
					user_indicator++;
						
					//get user name from text field and change user information
					user_name = user_name_txt_f.getText();
					user_obj.setName(user_name);
					
					//call the last dialog before starting instruction
					sarah_win welcome_win3 = new sarah_win(this.user_obj, "welcome", 5);
				}
				dispose();
			}
		}
	//getter --> for updating user information
		user getUser() {
			return user_obj;
		}
}
