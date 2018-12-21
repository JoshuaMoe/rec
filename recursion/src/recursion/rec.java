package recursion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class rec extends JFrame{
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame();
	public static JPanel contentPane;
	
	int stufe = 1;
	int x = 200;
	int y = 600;
	int zeit = 750;
	int zeitanfang = 750;
	int verzögerung = 0;
	double länge =  20;
	int limit;
	int nextX = 0, nextY = 0;
	int counter = 0;
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	
	
	
	//Um mit einem bestimmten zu beginnen den gewünschten auf wahr setzen 
	//Wenn der zufall ausgeschlossen werden soll einfach next auskommentieren
	boolean koch = false;
	boolean kochf = false;
	boolean levyc = false;
	boolean drachen = false;
	boolean hilbert = false;
	boolean pbaum = false;
	boolean peano = false;
	boolean pfeil = false;
	boolean sierpinski = false;
	boolean pp = false;
	boolean pause = false;
	boolean mouseclicked= false;
	
	JButton btnkoch;
	JButton btnkochf;
	JButton btndrachen;
	JButton btnlevyc;
	JButton btnhilbert;
	JButton btnpbaum;
	JButton btnpeano;
	JButton btnpfeil;
	JButton btnsierpinski;
	JButton btnpp;
	JButton btnpause;
	JButton btnnext;
	JButton btnback;
	
	JTextArea text = new JTextArea();
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rec frame = new rec();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public rec(){
		
		setBounds (0,0,width,height);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		
		text.setBounds(10,80,400,60);
		contentPane.add(text);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		text.setFont(font1);
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setVisible(false);
		text.setEditable(false);
		
		contentPane.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	mouseclicked = true;
		    	nextX =  e.getX();
		    	nextY =  e.getY();
		    	
		    	if(pause) {
		    		repaint();
		    	}
		    }
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		buttons();
		
		
	}
	
	public void buttons (){
		

		
		btnkoch = new JButton("Koch simulieren");
		btnkoch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				koch = true;
				btn_v();
				repaint();
			}
		});
		
		btnkochf = new JButton("Kochflocke simulieren");
		btnkochf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kochf = true;
				btn_v();
				repaint();
			}
		});
		
		btndrachen = new JButton("Drachen simulieren");
		btndrachen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drachen = true;
				btn_v();
				repaint();
			}
		});
		
		btnhilbert = new JButton("Hilbert simulieren");
		btnhilbert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hilbert = true;
				btn_v();
				repaint();
			}
		});
		
		btnlevyc = new JButton("Levy-C simulieren");
		btnlevyc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				levyc = true;
				btn_v();
				repaint();
			}
		});
		
		btnpbaum = new JButton("P-Baum simulieren");
		btnpbaum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pbaum = true;
				btn_v();
				repaint();
			}
		});
		
		btnpeano = new JButton("Peano simulieren");
		btnpeano.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				peano = true;
				btn_v();
				repaint();
			}
		});
		
		btnpfeil = new JButton("Pfeilspitze simulieren");
		btnpfeil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pfeil = true;
				btn_v();
				repaint();
			}
		});
		
		btnsierpinski = new JButton("Sierpinski simulieren");
		btnsierpinski.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sierpinski = true;
				btn_v();
				repaint();
			}
		});
		
		btnpp = new JButton("Penta Plexity simulieren WIP");
		btnpp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pp = true;
				btn_v();
				repaint();
			}
		});
		
		btnpause = new JButton("Pause");
		btnpause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause = !pause;
				if (pause) {
					btnpause.setBounds(10,10,200,30);
					btnback.setBounds(10,90,200,30);
					text.setBounds(10,120,400,60);
					btnpause.setText("Resume");
					btnnext.setVisible(true);
				}
				if (!pause) {
					btnpause.setBounds(10,10,200,30);
					btnback.setBounds(10,50,200,30);
					text.setBounds(10,80,400,60);
					btnpause.setText("Pause");
					btnnext.setVisible(false);
					repaint();
				}
			}
		});
		
		btnnext = new JButton("Nächster");
		btnnext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pause) {
					if (stufe +1 == limit) stufe = 0;
					stufe++;
					repaint();
				}
			}
		});
		
		btnback = new JButton("Zurück");
		btnback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stufe = 1;
				nextX = 0;
				nextY = 0;
				
				drachen = false;
				hilbert = false;
				koch = false;
				kochf = false;
				levyc = false;
				pbaum = false;
				peano = false;
				pfeil = false;
				sierpinski = false;
				pp = false;
				pause = false;
				
				btndrachen.setVisible(true);
				btnhilbert.setVisible(true);
				btnkoch.setVisible(true);
				btnkochf.setVisible(true);
				btnlevyc.setVisible(true);
				btnpbaum.setVisible(true);
				btnpeano.setVisible(true);
				btnpfeil.setVisible(true);
				btnsierpinski.setVisible(true);
				btnpp.setVisible(true);
				
				btnpause.setVisible(false);
				btnback.setVisible(false);
				btnnext.setVisible(false);
				text.setVisible(false);
				repaint();
			}
		});
		
		
		btnkoch.setBounds(10,10,200,30);
		contentPane.add(btnkoch);
		btndrachen.setBounds(10,50,200,30);
		contentPane.add(btndrachen);
		btnhilbert.setBounds(10,90,200,30);
		contentPane.add(btnhilbert);
		btnlevyc.setBounds(10,130,200,30);
		contentPane.add(btnlevyc);
		btnpbaum.setBounds(10,170,200,30);
		contentPane.add(btnpbaum);
		btnpeano.setBounds(10,210,200,30);
		contentPane.add(btnpeano);
		btnpfeil.setBounds(10,250,200,30);
		contentPane.add(btnpfeil);
		btnsierpinski.setBounds(10,290,200,30);
		contentPane.add(btnsierpinski);
		btnkochf.setBounds(10,330,200,30);
		contentPane.add(btnkochf);
		btnpp.setBounds(10,370,200,30);
		contentPane.add(btnpp);
		btnpause.setBounds(10,10,200,30);
		contentPane.add(btnpause);
		btnnext.setBounds(10,50,200,30);
		contentPane.add(btnnext);
		btnback.setBounds(10,50,200,30);
		contentPane.add(btnback);
		
		btnpause.setVisible(false);
		btnback.setVisible(false);
		btnnext.setVisible(false);
	}
	
	public void btn_v (){
		stufe = 1;
		btndrachen.setVisible(false);
		btnhilbert.setVisible(false);
		btnkoch.setVisible(false);
		btnkochf.setVisible(false);
		btnlevyc.setVisible(false);
		btnpbaum.setVisible(false);
		btnpeano.setVisible(false);
		btnpfeil.setVisible(false);
		btnsierpinski.setVisible(false);
		btnpp.setVisible(false);
		btnpause.setVisible(true);
		btnback.setVisible(true);
		text.setVisible(true);
		btnpause.setText("Pause");
		btnpause.setBounds(10,10,200,30);
		btnback.setBounds(10,50,200,30);
		text.setBounds(10,80,400,60);
	}
	
	public void paint (Graphics g){
		super.paintComponents(g);
		if(koch || kochf){
			koch_animation ((Graphics2D)g.create());
		}
		
		if(levyc){
			levyc_animation ((Graphics2D)g.create());
		}
		
		if(drachen){
			drachen_animation ((Graphics2D)g.create());
		}
		
		if (hilbert){
			hilbert_animation ((Graphics2D)g.create());
		}
		
		if(pbaum){
			pbaum_animation((Graphics2D)g.create());
		}
		
		if (peano){
			peano_animation ((Graphics2D)g.create());
		}
		
		if (pfeil){
			pfeil_animation((Graphics2D) g.create());
			
		}
		
		if (sierpinski){
			sier_animation((Graphics2D) g.create());
			
		}
		
		if (pp){
			pp(2,(Graphics2D) g.create(),(Graphics2D) g.create());
		}
		
	}
	
	public void pp (int tiefe, Graphics2D g,Graphics2D g3){
		g.setColor(Color.WHITE);
		if (tiefe == 0){
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(länge,0);
			g.rotate(Math.toRadians(-72), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(länge,0);
			g.rotate(Math.toRadians(-72), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(länge,0);
			g.rotate(Math.toRadians(-72), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(länge,0);
			g.rotate(Math.toRadians(-72), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(länge,0);
		}else{
			pp(tiefe-1,g,g3);
			g.rotate(Math.toRadians(-72), x, y);
			pp(tiefe-1,g,g3);
			g.rotate(Math.toRadians(-72), x, y);
			pp(tiefe-1,g,g3);
			g.rotate(Math.toRadians(-180), x, y);
			pp(tiefe-1,g,g3);
			g.rotate(Math.toRadians(36), x, y);
			pp(tiefe-1,g,g3);
			g.rotate(Math.toRadians(-72), x, y);
			pp(tiefe-1,g,g3);
			
		}
	}
	
	
	
	
	public void sier_animation (Graphics2D g){
		
		limit = 11;
		
		
		if (stufe==1){
			zeit = zeitanfang;
		}
		
		if(sierpinski){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/3; 
				y = height*2/3;
			}
			
			counter = 0;
			länge = 20;
			
			g.setColor(Color.WHITE);
			sierpinski(stufe,false,(Graphics2D) g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	public void pfeil_animation (Graphics2D g){
		
		limit = 10;
		
		if (stufe==1){
			zeit = zeitanfang;
		}
		
		if(pfeil){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x= width/3;
				y = height*2/3;
			}
			
			counter = 0;
			länge = (Math.pow(0.5, stufe))*500+1;
			
			g.setColor(Color.WHITE);
			pfeil (stufe,1,(Graphics2D)g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	
	
	public void peano_animation (Graphics2D g){
		
		limit = 6;
		
		if (stufe==1){
			//länge = (int) Math.pow(Math.E/1.4, (-stufe*1.1+7));
			länge = 20;
			zeit = zeitanfang;
		}
		
		if(peano){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/3;
				y = height*3/4;
			}
			
			counter = 0;
			
			g.setColor(Color.WHITE);
			peano (stufe,1,(Graphics2D)g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	länge = Math.pow(Math.E*0.5, ((-stufe*0.8)+12))-11;
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	
	public void pbaum_animation (Graphics2D g){
		
		limit = 10;		
		
		if (stufe==1){
			länge = 20;
			zeit = zeitanfang;
		}
		
		if(pbaum){
			
			
			länge = Math.pow(Math.E*0.01, ((-stufe*0.1)-0.5))+40;
			länge = (Math.pow(0.9, stufe))*300+1;
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = (int) ((width/2)+(länge/2));
				y = (int) ((height/2)+(länge/2));
			}
			
			counter = 0;
			g.setColor(Color.WHITE);
			pbaum(stufe,länge,45,(Graphics2D)g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	
	
	
	public void hilbert_animation (Graphics2D g){
		
		limit = 10;
		
		
		if (stufe==1){
			länge = 20;
			zeit = zeitanfang;
		}
		
		if(hilbert){
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/3;
				y = height*2/3;
			}
			
			counter = 0;
			länge = (Math.pow(0.5, stufe))*500+1;
			
			g.setColor(Color.WHITE);
			hilbert (stufe,-1,(Graphics2D)g.create());
			
			count();

			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();	
			
		}
	}
	
	public void drachen_animation (Graphics2D g){
		
		limit = 15;
		
		if (stufe==1){
			länge = 100;
			zeit = zeitanfang;
		}
		
		if(drachen){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/3;
				y = height/3;
			}
			
			
			counter = 0;
			
			länge = 100/(Math.sqrt(2)*stufe);
			länge = (Math.pow(0.70710678118, stufe))*500+1;
			
			g.setColor(Color.WHITE);
			drachen(stufe,1,(Graphics2D)g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();	
		}
	}
	
	public void koch_animation (Graphics2D g){
		
		limit = 8;
		
		if (kochf) limit = 5;
		
		if (stufe==1){
			zeit = zeitanfang;
		}
		
		if(koch || kochf){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/4;
				y = height*3/4;
			}
			
			counter = 0;
			länge = (Math.pow(0.33333333333, stufe))*2000+1;
			
			g.setColor(Color.WHITE);
			
			if (koch) koch(stufe,(Graphics2D)g.create());
			
			if(kochf) {
				if (nextX != 0||nextY != 0) {
					x = nextX;
					y = nextY;
				}else {
					x = width/2;
					y = height/2;
				}
				länge = (Math.pow(0.33333333333, stufe))*1000+1;
				int x2 = (int) ( ((Math.pow(1.33333333333, 1))*245+1)+(Math.pow(0.5*Math.E,stufe*1.5)*5));
				koch(stufe,(Graphics2D)g.create());
				g.translate(x2, 0);
				g.rotate(Math.toRadians(120), x, y);
				koch(stufe,(Graphics2D)g.create());
				g.translate(x2, 0);
				g.rotate(Math.toRadians(120), x, y);
				koch(stufe,(Graphics2D)g.create());
			}
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	
	public void levyc_animation (Graphics2D g){
		
		limit = 19;
		
		if (stufe==1){
			länge = 100;
			zeit = zeitanfang;
		}
		
		if (levyc){
			
			if (nextX != 0||nextY != 0) {
				x = nextX;
				y = nextY;
			}else {
				x = width/3;
				y = height/2;
			}
			
			länge = (Math.pow(0.68965517241, stufe))*500+1;
			
			counter = 0;
			g.setColor(Color.WHITE);
			levyc(stufe,(Graphics2D) g.create());
			
			count();
			
			Timer timer = new Timer(zeit, new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent ae) {
			    	timer();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
		
	}
	
	public void sierpinski (int tiefe,boolean leer, Graphics2D g){
		g.setColor(Color.WHITE);
		
		if(leer){
			if (tiefe >=0){
				g.translate(länge, 0);
				sierpinski(tiefe-1,true,g);
			}
		}else if (tiefe == 0){
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(Math.round(länge), 0);
			g.rotate(Math.toRadians(-120), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(Math.round(länge), 0);
			g.rotate(Math.toRadians(-120), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			g.translate(Math.round(länge), 0);
			counter +=3;
		}else{
			sierpinski(tiefe-1,false,g);
			g.rotate(Math.toRadians(-120), x, y);
			sierpinski(tiefe-1,false,g);
			g.rotate(Math.toRadians(-120), x, y);
			sierpinski(tiefe-1,false,g);
			g.rotate(Math.toRadians(-120), x, y);
			sierpinski(tiefe-1,true,g);
			sierpinski(tiefe-1,true,g);
		}
	}
	
	public void hilbert (int tiefe, int vz, Graphics2D g){
		if (tiefe == 0){
			return;
		}else{
			g.rotate(Math.toRadians(90*vz), x, y);
			hilbert(tiefe-1,-1*vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
			
			g.rotate(Math.toRadians(-90*vz), x, y);
			hilbert(tiefe-1,vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
			
			hilbert(tiefe-1,vz,g);
			
			g.rotate(Math.toRadians(-90*vz), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
			hilbert(tiefe-1,-1*vz,g);
			
			g.rotate(Math.toRadians(90*vz), x, y);
			
			
		}
	}
	
	public void koch (int tiefe, Graphics2D g){
		if (tiefe <= 1){
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			counter++;
			if(kochf)g.translate(länge,0);
			if(koch)x+=länge;
		}else{
			koch(tiefe-1,g);
			g.rotate(Math.toRadians(-60), x, y);
			koch(tiefe-1,g);
			g.rotate(Math.toRadians(120), x, y);
			koch(tiefe-1,g);
			g.rotate(Math.toRadians(-60), x, y);
			koch(tiefe-1,g);
		}
	}

	public void drachen (int tiefe, int vz, Graphics2D g){
		if (tiefe == 0){
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
		}else{
			g.rotate(Math.toRadians(45*vz), x, y);
			drachen(tiefe-1,1,g);
			g.rotate(Math.toRadians(-90*vz), x, y);
			drachen(tiefe-1,-1,g);
			g.rotate(Math.toRadians(45*vz), x, y);
		}
	}
	
	public void levyc (int tiefe, Graphics2D g){
		if(tiefe==1){
			g.drawLine(x, y, (int) (x+länge), y);
			x+=länge;
			counter++;
		}else{
			g.rotate(Math.toRadians(45), x, y);
			levyc(tiefe-1,g);
			g.rotate(Math.toRadians(-90), x, y);
			levyc(tiefe-1,g);
			g.rotate(Math.toRadians(45), x, y);
		}
	}
	
	public void pbaum(int tiefe, double länge, int phi, Graphics2D g){
		
		if(tiefe == stufe){
			g.rotate(Math.toRadians(-90), x, y);
		}
		
		g.drawLine(x, y, (int) (x+Math.round(länge)), y);
		x+=länge;
		g.rotate(Math.toRadians(-90), x, y);
		
		g.drawLine(x, y, (int) (x+Math.round(länge)), y);
		x+=länge;
		g.rotate(Math.toRadians(-90), x, y);
		
		g.drawLine(x, y, (int) (x+Math.round(länge)), y);
		x+=länge;
		g.rotate(Math.toRadians(-90), x, y);
		
		g.drawLine(x, y, (int) (x+Math.round(länge)), y);
		x+=länge;
		g.rotate(Math.toRadians(-90), x, y);
		
		g.drawLine(x, y, (int) (x+Math.round(länge)), y);
		x+=länge;
		counter +=5;
		
		
		if(tiefe-1<=0){
			g.rotate(Math.toRadians(-90), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			g.rotate(Math.toRadians(-90), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter += 2;
		}else{
			g.rotate(Math.toRadians(phi), x, y);
			pbaum(tiefe-1, länge*Math.cos(Math.toRadians(phi)),phi,g);
			g.rotate(Math.toRadians(90), x, y);
			pbaum(tiefe-1,länge*Math.sin(Math.toRadians(phi)),phi,g);
			g.rotate(Math.toRadians(90-phi), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
		}
	}
	
	public void peano(int tiefe, int vz, Graphics2D g) {
		if(tiefe != 0){
			peano(tiefe-1,vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,-vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,vz,g);
			
			g.rotate(Math.toRadians(-90*vz), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			g.rotate(Math.toRadians(-90*vz), x, y);
			
			
			peano(tiefe-1,-vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,-vz,g);
			
			g.rotate(Math.toRadians(90*vz), x, y);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			g.rotate(Math.toRadians(90*vz), x, y);
			
			
			peano(tiefe-1,vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,-vz,g);
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			
			peano(tiefe-1,vz,g);
			counter +=8;
		}
		
	}
	

	public void pfeil (int tiefe, int vz, Graphics2D g){
		if (tiefe == 0){
			g.drawLine(x, y, (int) (x+Math.round(länge)), y);
			x+=länge;
			counter++;
		}else{
			g.rotate(Math.toRadians(-60*vz), x, y);
			pfeil(tiefe-1,-vz,g);
			g.rotate(Math.toRadians(60*vz), x, y);
			pfeil(tiefe-1,vz,g);
			g.rotate(Math.toRadians(60*vz), x, y);
			pfeil(tiefe-1,-vz,g);
			g.rotate(Math.toRadians(-60*vz), x, y);
		}
	}
	
	public void next (){
		
		stufe=1;
		
		koch = false;
		levyc = false;
		hilbert = false;
		drachen = false;
		pbaum = false;
		peano = false;
		pfeil = false;
		
		double rand = ThreadLocalRandom.current().nextDouble(0, 1);
		
		//double rand = Math.random();
		System.out.println(rand +"");
		
		if(rand<=0.15){
			koch = true;
		}else if (rand<=0.3){
			levyc = true;
		}else if (rand<=0.45){
			hilbert = true;
		}else if (rand<=0.6){
			drachen = true;
		}else if (rand<=0.75){
			pbaum = true;
		}else if (rand<=0.9){
			pfeil = true;
		}else if (rand<=1){
			peano = true;
		}
		repaint();
	}
	
	public void timer () {
		zeit = zeit+verzögerung;
		if (!pause) {
			if (stufe+1==limit){
				stufe = 0;
			}
			stufe++;
			repaint();
		}
	}
	
	
	public void count() {
		String s1 = "Stufe: "+stufe;
		String s2 = "\n\rAnzahl der Linien: " +counter;
		text.setText(s1+s2);
	}
	
}

class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public DrawPanel(){
	}
	public void paintComponent(Graphics g){
	}
}


		

