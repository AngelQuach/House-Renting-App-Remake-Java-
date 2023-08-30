import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class sarah_win extends JFrame implements ActionListener{
	//global var.
	//object of user
	user user_obj = new user();
	//indicator for user window
	int user_indicator = 0;
	//Sarah avatar
	String s_name;
	JLabel s_name_l, s_avatar_l;
	ImageIcon s_avatar_img;
	//Sarah's words
	JTextArea s_txt_a;
	//button to next pop-up win
	ImageIcon but_pic;
	JButton next_but;
	//txt font (same as before)
	Font txt_f = new Font("Comic Sans MS", Font.BOLD, 15);
	Font word_f = new Font("Comic Sans MS", Font.PLAIN, 12);
	//setup layers
	JLayeredPane layeredPane;
	//temp var. that stores context and indicator
	String s_context;
	int s_indicator;

	
	//constructor
	public sarah_win (user user_obj, String context, int indicator) {
		//store the user object
		this.user_obj.copy(user_obj);
		//store context and indicator
		s_context = context;
		s_indicator = indicator;
		
		//set up the shared parts
			//setup window
			this.setTitle("Conversation Ongoing...");
			//setup layers
			layeredPane = new JLayeredPane();
		
			//Sarah's avatar
			//link pic + place it
			s_avatar_img = new ImageIcon("P_avatar_sarahwin.jpg");
			s_avatar_l = new JLabel(s_avatar_img);
			s_avatar_l.setBounds(10, 10, s_avatar_img.getIconWidth(), s_avatar_img.getIconHeight());

		//if it is regarding welcoming plot
			if(context == "welcome") {
				//1st sentence
				if(indicator == 0) {
					//Sarah's name
					s_name = "Lead";

					//Sarah's words
					s_txt_a = new JTextArea("\n    Hi, trainee! Welcome to Best Real Estate! I will "
							+ "\n be your lead for the upcoming 7 days.");
				}
				//2nd sentence
				else if(indicator == 1) {
					//Sarah's name
					s_name = "Lead";

					//Sarah's words
					s_txt_a = new JTextArea("\n    Wait what?! You don't know why you are here?"
							+ "\n Well... You're a trainee real estate agent who is "
							+ "\n on a 7-day training session.");
				}
				//3rd sentence
				else if(indicator == 2) {
					//Sarah's name
					s_name = "Lead";

					//Sarah's words
					s_txt_a = new JTextArea("\n    By the end of this week, you will be evaluated. "
							+ "\n If you pass, you will be one of us, agents working "
							+ "\n at 1st real estate company in the country.");
				}
				//4th sentence (add variety by changing the button)
				else if(indicator == 3) {
					//Sarah's name
					s_name = "Lead";

					//Sarah's words
					s_txt_a = new JTextArea("\n    Alternatively, if you fail...you will still get paid "
							+ "\n based on your performance.");
				}
				//5th sentence (when Sarah finally share name)
				else if(indicator == 4) {
					//Sarah's name
					s_name = "Sarah";

					//Sarah's words
					s_txt_a = new JTextArea("\n    Nice! I can see that you are more than ready to "
							+ "\n start your 1st day of work! I am Sarah, your lead.");
				}
				//after collecting user name --> last dialog before starting instruction
				else if(indicator == 5) {
					//Sarah's name
					s_name = "Sarah";

					//Sarah's words
					s_txt_a = new JTextArea("\n    Nice to see you, " + this.user_obj.getName() + "!"
							+ "\n    Now you can follow the instruction on the PC"
							+ "\n and start your first day of work!");
				}
			}
		
		//Sarah's name continue
		s_name_l = new JLabel(s_name);
		s_name_l.setFont(txt_f);
		s_name_l.setBounds(30, 10 + s_avatar_img.getIconHeight(), 50, 20);
		
		//Sarah's words continue
		s_txt_a.setFont(word_f);
		s_txt_a.setBounds(20 + s_avatar_img.getIconWidth(), 10, 280, 90);
		s_txt_a.setEditable(false);
		
		//next button (except for some special conversations)
		if(indicator == 3) {
			next_but = new JButton("I got it!");
			next_but.setFont(word_f);
			next_but.setBounds(285, 70, 80, 25);
			next_but.addActionListener(this);
		}
		else {
			but_pic = new ImageIcon("P_button_sarahwin.jpg");
			next_but = new JButton(but_pic);
			next_but.setBounds(350, 75, 20, 20);
			next_but.addActionListener(this);
		}
		
		//add comps to layers
		layeredPane = new JLayeredPane();
		layeredPane.add(s_avatar_l, JLayeredPane.MODAL_LAYER);
		layeredPane.add(s_name_l, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(s_txt_a, JLayeredPane.MODAL_LAYER);
		layeredPane.add(next_but, JLayeredPane.POPUP_LAYER);
		
		//set close operation; set size and not resizable
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
				
				//as long as the conversation is not finished, generate the next sentence said by sarah
				//once s_indicator == 4 --> time for users to name themselves
				if(s_context == "welcome" && s_indicator < 4) {
					s_indicator++;
					sarah_win welcome_win2 = new sarah_win(this.user_obj, "welcome", s_indicator);
				}
				//now it is time for user to name themselves
				else if(s_context == "welcome" && s_indicator == 4){
					user_win welcome_user1 = new user_win(this.user_obj, "welcome", user_indicator);
					
					//update user information once it is updated
					user_obj.copy(welcome_user1.getUser());
				}
				dispose();
			}
		}
	
	//getter
		user getUser() {
			return user_obj;
		}
}
