import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class change_avar_win extends JFrame implements ActionListener{
	//global var.
	//object of user
	user user_obj = new user();
	//images of avatars; sign that indicates current avatar
	ImageIcon avar0_img, avar1_img, avar2_img, avar3_img, avar4_img, avar5_img, current_avar_img;
	//JLabel for instruction; place to place sign that indicates current avatar
	JLabel instruction, current_avar_l;
	//JButton for confirm, avatars
	JButton confirm, avar0_b, avar1_b, avar2_b, avar3_b, avar4_b, avar5_b;
	//text font
	Font word_f = new Font("Comic Sans MS", Font.PLAIN, 12);
	//setup layers
	JLayeredPane layeredPane;
	//temp var. that store user name; avatar number; position of row and column
	String u_name = null;
	int u_num = 0;
	int row_pos = 10;
	int col_pos = 50;
	
	//constructor
	public change_avar_win(user current_user) {
		//keep track of current information about the user
		user_obj.copy(current_user);
		
		//setup layers
		layeredPane = new JLayeredPane();
		
		//1st layer (DEFAULT_LAYER): sign that shows the selected avatar --> to be implemented
		
		
		//2nd layer: instruction and avatars for choosing
			//setup the instruction
			instruction = new JLabel("Please select the avatar you prefer: ");
			instruction.setFont(word_f);
			instruction.setBounds(10, 10, 300, 30);
			layeredPane.add(instruction, JLayeredPane.PALETTE_LAYER);
		
			//setup the avatars
				//avatar_num = 0 --> [row, col] = [1,1]
				avar0_img = new ImageIcon("P_uavatar0_userwin.jpg");
				avar0_b = new JButton(avar0_img);
				avar0_b.setBounds(50, 50, avar0_img.getIconWidth(), avar0_img.getIconHeight());
				avar0_b.addActionListener(this);
				layeredPane.add(avar0_b, JLayeredPane.PALETTE_LAYER);
			
				//avatar_num = 1 --> [row, col] = [1,2]
				avar1_img = new ImageIcon("P_uavatar1_userwin.jpg");
				avar1_b = new JButton(avar1_img);
				avar1_b.setBounds(50 + 20 + avar0_img.getIconWidth(), 50, avar1_img.getIconWidth(), avar1_img.getIconHeight());
				avar1_b.addActionListener(this);
				layeredPane.add(avar1_b, JLayeredPane.PALETTE_LAYER);
			
				//avatar_num = 2 --> [row, col] = [1,3]
				avar2_img = new ImageIcon("P_uavatar2_userwin.jpg");
				avar2_b = new JButton(avar2_img);
				avar2_b.setBounds(50 + 20*2 + (avar0_img.getIconWidth())*2, 50, avar2_img.getIconWidth(), avar2_img.getIconHeight());
				avar2_b.addActionListener(this);
				layeredPane.add(avar2_b, JLayeredPane.PALETTE_LAYER);
			
				//avatar_num = 3 --> [row, col] = [2,1]
				avar3_img = new ImageIcon("P_uavatar3_userwin.jpg");
				avar3_b = new JButton(avar3_img);
				avar3_b.setBounds(50, 50 + 20 + avar0_img.getIconHeight(), avar3_img.getIconWidth(), avar3_img.getIconHeight());
				avar3_b.addActionListener(this);
				layeredPane.add(avar3_b, JLayeredPane.PALETTE_LAYER);
			
				//avatar_num = 4 --> [row, col] = [2,2]
				avar4_img = new ImageIcon("P_uavatar4_userwin.jpg");
				avar4_b = new JButton(avar4_img);
				avar4_b.setBounds(50 + 20 + avar0_img.getIconWidth(), 50 + 20 + avar0_img.getIconHeight(), avar4_img.getIconWidth(), avar4_img.getIconHeight());
				avar4_b.addActionListener(this);
				layeredPane.add(avar4_b, JLayeredPane.PALETTE_LAYER);
			
				//avatar_num = 5 --> [row, col] = [2,3]
				avar5_img = new ImageIcon("P_uavatar5_userwin.jpg");
				avar5_b = new JButton(avar5_img);
				avar5_b.setBounds(50 + 20*2 + (avar0_img.getIconWidth())*2, 50 + 20 + avar0_img.getIconHeight(), avar5_img.getIconWidth(), avar5_img.getIconHeight());
				avar5_b.addActionListener(this);
				layeredPane.add(avar5_b, JLayeredPane.PALETTE_LAYER);
		
		//3rd layer: confirm button
			//setup button
			confirm = new JButton("Confirm");
			confirm.setBounds(275, 230, 90, 30);
			confirm.addActionListener(this);
			layeredPane.add(confirm, JLayeredPane.MODAL_LAYER);
		
		//setup window
			//set close operation; set size and not resizable
			this.setTitle("Change avatar");
			this.setLayeredPane(layeredPane);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setSize(395, 310);
			this.setVisible(true);
	}
	
	//mouse interaction
		public void actionPerformed(ActionEvent e) {
			//user's action
			Object choice = e.getSource();

			//if user click on avatar (num 0-5)
			if(choice == avar0_b) {
				u_num = 0;
			}
			else if(choice == avar1_b) {
				u_num = 1;
			}
			else if(choice == avar2_b) {
				u_num = 2;
			}
			else if(choice == avar3_b) {
				u_num = 3;
			}
			else if(choice == avar4_b) {
				u_num = 4;
			}
			else if(choice == avar5_b) {
				u_num = 5;
			}

			//if user click on confirm button, update user avatar number. and close window
			if(choice == confirm) {
				//update user avatar number
				user_obj.setNum(u_num);
				this.setVisible(false);
				dispose();
			}
		}
	//getters --> for updating user information
		user getUser() {
			return user_obj;
		}
}
