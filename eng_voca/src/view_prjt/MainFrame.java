package view_prjt;


import java.awt.Color;

import javax.swing.JFrame;

import view.MyUtil;

public class MainFrame extends JFrame{
	
	public static CustomPanel[] panels = new CustomPanel[3];

	public MainFrame(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		//panels 객체 할당
		panels[0] = new CustomPanel(this, Color.green, "panel0");
		panels[1] = new CustomPanel(this, Color.magenta, "panel1");
		panels[2] = new CustomPanel(this, Color.orange, "panel2");
		
		add(panels[0]); //시작페이지

		
	}

}