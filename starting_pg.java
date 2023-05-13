import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class starting_pg extends JFrame implements ActionListener{
	//global var.
	JLayeredPane layeredPane;
	JLabel fTitle, label_bg;
	JPanel panel_top, panel_bg, panel_bot;
	JButton icon, start, setting;
	ImageIcon icon_img, starting_page;
	Font title_f = new Font("Comic Sans MS", Font.BOLD, 30);
	Font txt_f = new Font("Comic Sans MS", Font.BOLD, 15);

	
	//set up starting window
	public starting_pg() {
	//layer/background set-up
		layeredPane = new JLayeredPane();
		starting_page = new ImageIcon("P_bg_startingPage.jpg");
		label_bg = new JLabel(starting_page);
		panel_bg = new JPanel();
		panel_bg.setBounds(15, 0, starting_page.getIconWidth(), starting_page.getIconHeight());
		panel_bg.add(label_bg);
		layeredPane.add(panel_bg, JLayeredPane.DEFAULT_LAYER);
		
	//set up top part
		this.setTitle("House Renting Simulator");
		fTitle = new JLabel("House Renting Simulator");
		fTitle.setFont(title_f);
		fTitle.setBounds(150, 200, 400, 100);
		
		//personal icon of the author
		//2023.5.11 - IDEA: clicked to show pop-up about the author
		icon = new JButton();
		icon_img = new ImageIcon("P_icon.jpg");
		icon.setIcon(icon_img);
		icon.addActionListener(this);
		icon.setBounds(535, 5, icon_img.getIconWidth(), icon_img.getIconHeight());
	
	//set up lower part
		start = new JButton("Start");
		start.addActionListener(this);
		start.setFont(txt_f);
		start.setBounds(100, 450, 175, 50);
		setting = new JButton("Settings");
		setting.addActionListener(this);
		setting.setFont(txt_f);
		setting.setBounds(375, 450, 175, 50);
				
	//put them tgt
		layeredPane.add(fTitle, JLayeredPane.MODAL_LAYER);
		layeredPane.add(icon, JLayeredPane.MODAL_LAYER);
		layeredPane.add(start, JLayeredPane.MODAL_LAYER);
		layeredPane.add(setting, JLayeredPane.MODAL_LAYER);
	
	//set window
		this.setLayeredPane(layeredPane);
		this.setSize(650, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//mouse interaction
	public void actionPerformed(ActionEvent e) {
		//user's action
		Object choice = e.getSource();
		
		//if icon is pressed
		//2023.5.12 - IDEA: -> only one button can be pressed at a time
		//					-> use subclass for new windows
		if(choice == icon) {
			//pop-up window for introducing icon
			icon_Intro icon_win = new icon_Intro();
		}
	}
	
	public static void main(String args[]) {
		new starting_pg();
	}
}