import java.awt.Font;
import javax.swing.*;

class icon_Intro extends JFrame{
	//local var.
	JLayeredPane layeredPane;
	JLabel intro_title_l, intro_bg_l, intro_bgFlower_l, icon_img_l;
	JPanel intro_bg_p;
	JTextArea intro_txt_a;
	ImageIcon intro_bg_img, intro_bgFlower_img, icon_img;
	Font title_f = new Font("Comic Sans MS", Font.BOLD, 30);
	Font txt_f = new Font("Comic Sans MS", Font.BOLD, 15);
	
	//default constructor
	public icon_Intro() {
	//set up window & background(main)
		this.setTitle("House Renting Simulator");
		layeredPane = new JLayeredPane();
		//link pic
		intro_bg_img = new ImageIcon("P_bg_iconIntro.jpg");
		intro_bg_l = new JLabel(intro_bg_img);
		//put into panel
		intro_bg_p = new JPanel();
		intro_bg_p.setBounds(0, 0, intro_bg_img.getIconWidth(), intro_bg_img.getIconHeight());
		intro_bg_p.add(intro_bg_l);
		//add to layer
		layeredPane.add(intro_bg_p, JLayeredPane.DEFAULT_LAYER);
	
	//set up background(lower/flower)
		intro_bgFlower_img = new ImageIcon("P_bg_iconIntro2.jpg");
		intro_bgFlower_l = new JLabel(intro_bgFlower_img);
		intro_bgFlower_l.setBounds(350, 300, intro_bgFlower_img.getIconWidth(), intro_bgFlower_img.getIconHeight());
		
	//set up title
		intro_title_l = new JLabel("About The Author");
		intro_title_l.setFont(title_f);
		intro_title_l.setBounds(15, 0, 400, 100);
		
	//set up text
		intro_txt_a = new JTextArea("  This game is designed by Angel Quach, a fist-year\n"
										+ "engineering student at the University of Waterloo.\n"
										+ "\n  @2023 All the images involved belongs to the author.\n"
										+ "\n  If you have any suggestion, please contact:\n"
										+ "\n                 aquach@uwaterloo.ca");
		intro_txt_a.setFont(txt_f);
		intro_txt_a.setBounds(15, 200, 450, 200);
		intro_txt_a.setEditable(false);
		
	//set up icon
		icon_img = new ImageIcon("P_icon.jpg");
		icon_img_l = new JLabel(icon_img);
		icon_img_l.setBounds(375, 5, icon_img.getIconWidth(), icon_img.getIconHeight());
		
	//put them tgt
		layeredPane.add(intro_bgFlower_l, JLayeredPane.POPUP_LAYER);
		layeredPane.add(intro_title_l, JLayeredPane.MODAL_LAYER);
		layeredPane.add(intro_txt_a, JLayeredPane.MODAL_LAYER);
		layeredPane.add(icon_img_l, JLayeredPane.MODAL_LAYER);
		
		//set close operation; set size and not resizable
		this.setLayeredPane(layeredPane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}