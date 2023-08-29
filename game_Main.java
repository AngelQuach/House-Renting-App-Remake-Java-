import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class game_Main extends JFrame implements ActionListener{
	//global var.
	//Info from user
	String name = "user name";
	//layers of page
	JLayeredPane layeredPane;
	//bot bg, init avatar,
	ImageIcon table, init_avar;
	//place to put bg, icon
	JLabel table_bg, init_avar_bg, user_name;
	//prep for bottons
	JPanel top_panel, bot_panel; 
	//font used
	Font txt_f = new Font("Comic Sans MS", Font.BOLD, 15);
	
	
	//set up main page - constructor
	public game_Main(starting_pg init_pg) {
		//layer set-up
		layeredPane = new JLayeredPane();
		
		//bg set-up (layer 1)
		table = new ImageIcon("P_bg_table.jpg");
		table_bg = new JLabel(table);
		layeredPane.add(table_bg, JLayeredPane.DEFAULT_LAYER);
	
		//panels set-up (layer 2)
		//top panel and bot panel
		top_panel = new JPanel();
		top_panel.setBounds(0, 0, 650, 100);
		top_panel.setBackground(Color.DARK_GRAY);
		layeredPane.add(top_panel, JLayeredPane.PALETTE_LAYER);
		
		bot_panel = new JPanel();
		bot_panel.setBounds(225, 550, 200, 100);
		bot_panel.setBackground(Color.DARK_GRAY);
		layeredPane.add(bot_panel, JLayeredPane.PALETTE_LAYER);

	   //contents set-up (layer 3)
	   //part 1: user info --> user name & avatar
	   //2023.5.30 - IDEA: user avatar personification (to be implemented)
	   //2023.8.28 - UPDATE: user will be able to choose between 6 avatars --> to be designed
		init_avar = new ImageIcon("P_init_icon.jpg");
		init_avar_bg = new JLabel(init_avar);
		init_avar_bg.setBounds(15, 15, 50, 50);
		layeredPane.add(init_avar_bg, JLayeredPane.MODAL_LAYER);
		
		user_name = new JLabel(name);
		user_name.setFont(txt_f);
		user_name.setBounds(75, 30, 75, 20);
		
		//set window
		this.setTitle("House Renting Simulator");
		this.setLayeredPane(layeredPane);
		this.setSize(650, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//regardless of the choice of the user, first show up pop-up windows to welcome them (indicator == 0 [init])
		sarah_win welcome_win1 = new sarah_win("welcome", 0); //1st sentence said by sarah
		//now it is time for users to name themselves (indicator == 5)
		name = JOptionPane.showInputDialog("Hi Sarah! Thank you for the instruction! Nice to meet you, I am: ");
	   //-------- user name collected --------
	
	   //system messages will demonstrate how to change avatar, followed by introductions of the panel --> to be implemented
	}
	
	//mouse interaction
	public void actionPerformed(ActionEvent e) {
		//user's action
		Object choice = e.getSource();
	}
}
