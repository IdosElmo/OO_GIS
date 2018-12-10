package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GIS.*;
import Geom.Point3D;
public class myFrame extends JFrame{
	
	BufferedImage img = null;
	ImageIcon pacman = new ImageIcon("pacman.png");
	private Game game;
	
	private ArrayList<Point3D> points;
	
	private MenuItem itemPackman;
	private static MenuBar menubar;
	private Menu menu;
	private JPanel panel = new JPanel();
	private JLabel pn = new JLabel(pacman);
//	private MenuItem itemFruit;
//	private MenuItem itemSave;
//	private MenuItem itemLoad;
//	private MenuItem itemQuit;
	
	
	public myFrame(){
		game = new Game();
		points = new ArrayList<Point3D>();
		//game.buildGame(pathname);
//		MenuBar menuBar = new MenuBar(); 
//		Menu menu = new Menu("Menu");
		
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		
		menubar = new MenuBar();
		menu = new Menu("menu");
		itemPackman = new MenuItem("Add Packman");
		
		menu.add(itemPackman);
		menubar.add(menu);
		

		setMenuBar(menubar);
		
		itemPackman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
				points.add(new Point3D(100,100,50));
				System.out.println(points.isEmpty());
				repaint();
			}
		});
		

		
//		itemFruit = new MenuItem("Add Fruit");
//		itemSave = new MenuItem("Save Game");		
//		itemLoad = new MenuItem("Load Game");	
//		itemQuit = new MenuItem("Quit");
//		
//		menu.add(itemPackman);
//		menu.add(itemFruit);
//		menu.add(itemSave);
//		menu.add(itemLoad);
//		menu.add(itemQuit);
//		
//		menuBar.add(menu);
//		setMenuBar(menuBar);
		
		try {
			img = ImageIO.read(new File("Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		pack();
	}
	
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		Graphics2D graphic = (Graphics2D) g;
		
		//paint points
		for (Point3D point : points) {
			graphic.drawRect((int)point.x(),(int)point.y(), 500, 500);
			graphic.fillOval(300, 300, 30, 30);
		}
	}
	
	public static void main(String[] a){
		myFrame window = new myFrame();
		
//		window.setJMenuBar(jmenubar);
//		window.pack();
		window.setVisible(true);
	}

}
