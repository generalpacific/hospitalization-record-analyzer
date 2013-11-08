import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;
//import com.panayotis.*;

class RootWindow1 extends JFrame implements ActionListener 
{
	// Component Declaration

	private JLabel citylbl;
	private JComboBox citycmb;
	private JLabel syndlbl;
	private JComboBox syndcmb;

	private JButton showbtn;
	private JButton citywise;
	private JButton showbtnw;
	private JButton showbtna;

	private JLabel amalecntlbl;
	private JTextField amalecnttxt;
	private JLabel afemalecntlbl;
	private JTextField afemalecnttxt;
	private JLabel dmalecntlbl;
	private JTextField dmalecnttxt;
	private JLabel dfemalecntlbl;
	private JTextField dfemalecnttxt;
	private JLabel attlcntlbl;
	private JTextField attlcnttxt;
	private JLabel dttlcntlbl;
	private JTextField dttlcnttxt;

	private JLabel empty;

	private JLabel apeakagegrplbl;
	private JTextField apeakagegrptxt;
	private JLabel dpeakagegrplbl;
	private JTextField dpeakagegrptxt;
	private JLabel apeakweeklbl;
	private JTextField apeakweektxt;
	private JLabel dpeakweeklbl;
	private JTextField dpeakweektxt;

	//tab2

	private JLabel aattlcntlbl;
	private JTextField aattlcnttxt;
	private JLabel adttlcntlbl;
	private JTextField adttlcnttxt;
	private JLabel aapeakagegrplbl;
	private JTextField aapeakagegrptxt;
	private JLabel adpeakagegrplbl;
	private JTextField adpeakagegrptxt;
	private JLabel aapeakweeklbl;
	private JTextField aapeakweektxt;
	private JLabel adpeakweeklbl;
	private JTextField adpeakweektxt;

	private JLabel asyndlbl;
	private JComboBox asyndcmb;


	private JButton ashowbtn;
	private JButton ashowbtnw;
	private JButton ashowbtna;

	public RootWindow1()
	{
		super("Hospitalisation : Analysis");											// Title of Window

		String[] cities = {"Aleppo","Colombia","Iran","Karachi","Lebanon","Nairobi","Saudi Arabia","Thailand","Turkey","Venezuela","Yemen"};							// All Cities Arrays

		String[] syndrome = {"DIARRHEA","HEADACHE","BACK PAIN","MENTAL PROBLEMS","DENTAL PROBLEMS","HAND PAIN","GI","COUGH","HEART PROBLEMS","NOSE PROBLEMS","VOMITING","URINARY PROBLEM","THROAT PAIN","RASH","KNEE PAIN","FEVER","EYE PROBLEMS","ELBOW PAIN","PENIS PROBLEMS","VOMITING DIARRHEA","SEIZURE","ABD PAIN BACK PAIN","ABD PAIN","KIDNEY PROBLEMS","FLU","CHEST PAIN","HIP PAIN","VOMITING ABD PAIN","NECK PROBLEMS","PREGNANCY RELATED","SHOULDER PAIN","BREATHING PROBLEMS","LEG PAIN","BODY PAIN","VOMITING HEADACHE","FACIAL LAC","THROAT PROBLEMS","SIDE PAIN","EAR PAIN","MED RELATED","BLEEDING","MIGRAINE","WRIST PAIN","SINUS PROBLEMS","DIABETIC PROBLEMS","ANIMAL BITE","FEM UG PROBLEMS","SPEECH PROBLEMS","WOUND","FINGER PAIN","ACCIDENT","LOC","EATING PROBLEMS","SICKLE CELL CRISIS","BOWEL PROBLEMS","ALLERGY","OTHER","ANKLE PAIN","THUMB PAIN","OVERDOSE","EDEMA","CYST","STD","CHICKEN POX","CODE","MOUTH PROBLEMS","APPENDIX PROBLEMS","SOB","PELVIC PAIN","STOOL PROBLEMS","STOMACH PROBLEMS","WRIST PAIN HAND PAIN","ASSAULT","FUSSY","VOMITING COUGH","SUTURE REMOVAL","ABSCESS"};
		// Tab 1 : Preprocessing
 
		citylbl = new JLabel("Select City");
		citycmb = new JComboBox(cities);										// Combo Box / Select Box for selecting city

		syndlbl = new JLabel("Select Syndrome");
		syndcmb = new JComboBox(syndrome);

		citywise = new JButton("CityWise Distribution");
		showbtn =new JButton("Show Analysis");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome

		showbtnw =new JButton("Show graph for temporal pattern");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome
		showbtna =new JButton("Show graph for spread across age");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome
		amalecntlbl = new JLabel("Infected Male Count ");
		amalecnttxt = new JTextField(30);
		amalecnttxt.setEditable(false);

		afemalecntlbl = new JLabel("Infected Female Count ");
		afemalecnttxt = new JTextField(30);
		afemalecnttxt.setEditable(false);

		attlcntlbl = new JLabel("Infected Total Count ");
		attlcnttxt = new JTextField(30);
		attlcnttxt.setEditable(false);
		
		dmalecntlbl = new JLabel("Dead Male Count");
		dmalecnttxt = new JTextField(30); 
		dmalecnttxt.setEditable(false);

		dfemalecntlbl = new JLabel("Dead Female Count");
		dfemalecnttxt = new JTextField(30);
		dfemalecnttxt.setEditable(false);

		dttlcntlbl = new JLabel("Dead Total Count");
		dttlcnttxt = new JTextField(30);
		dttlcnttxt.setEditable(false);

		apeakagegrplbl = new JLabel("Peak Infected Age Group");
		apeakagegrptxt = new JTextField(30);
		apeakagegrptxt.setEditable(false);

		dpeakagegrplbl = new JLabel("Peak Dead Age Group");
		dpeakagegrptxt = new JTextField(30);
		dpeakagegrptxt.setEditable(false);

		apeakweeklbl = new JLabel("Peak Week of Affection");
		apeakweektxt = new JTextField(30);
		apeakweektxt.setEditable(false);

		dpeakweeklbl = new JLabel("Peak Week of Death");
		dpeakweektxt = new JTextField(30);
		dpeakweektxt.setEditable(false);
		
		empty = new JLabel("");
	
        	JPanel p0 = new JPanel();
		p0.setLayout(new GridLayout(1,1,10,10));
		p0.add(citywise);
		citywise.addActionListener(this);

		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,10,10));
		p1.add(citylbl);
		p1.add(citycmb);

		showbtnw.addActionListener(this);
		p1.add(showbtnw);
		
		showbtna.addActionListener(this);
		p1.add(showbtna);
		
		showbtn.addActionListener(this);
		p1.add(syndlbl);
		p1.add(syndcmb);
		p1.add(empty);
		p1.add(showbtn);
		
		
		JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(10,2,10,10));
		p4.add(amalecntlbl);
		p4.add(amalecnttxt);
		p4.add(afemalecntlbl);
		p4.add(afemalecnttxt);
		p4.add(attlcntlbl);
		p4.add(attlcnttxt);
		p4.add(dmalecntlbl);
		p4.add(dmalecnttxt);
		p4.add(dfemalecntlbl);
		p4.add(dfemalecnttxt);
		p4.add(dttlcntlbl);
		p4.add(dttlcnttxt);

		p4.add(apeakagegrplbl);
		p4.add(apeakagegrptxt);
		p4.add(dpeakagegrplbl);
		p4.add(dpeakagegrptxt);
		p4.add(apeakweeklbl);
		p4.add(apeakweektxt);
		p4.add(dpeakweeklbl);
		p4.add(dpeakweektxt);

		JPanel pp1 = new JPanel();
		pp1.setLayout(new BorderLayout(20,20));
		pp1.add(p0,BorderLayout.NORTH);
		//pp1.add(p2,BorderLayout.NORTH);
		pp1.add(p1,BorderLayout.CENTER);
		pp1.add(p4,BorderLayout.SOUTH);

		// Tab  2

		asyndlbl = new JLabel("Select Syndrome");
		asyndcmb = new JComboBox(syndrome);

		ashowbtn =new JButton("Show Analysis");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome

		ashowbtnw =new JButton("Temporal Pattern");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome
		ashowbtna =new JButton("Spread Across Age");								// On Clicking this button, you will get detailed Analysis for Selected City & Syndrome
		aattlcntlbl = new JLabel("Infected Total Count ");
		aattlcnttxt = new JTextField(30);
		aattlcnttxt.setEditable(false);
		

		adttlcntlbl = new JLabel("Dead Total Count");
		adttlcnttxt = new JTextField(30);
		adttlcnttxt.setEditable(false);

		aapeakagegrplbl = new JLabel("Peak Infected Age Group");
		aapeakagegrptxt = new JTextField(30);
		aapeakagegrptxt.setEditable(false);

		adpeakagegrplbl = new JLabel("Peak Dead Age Group");
		adpeakagegrptxt = new JTextField(30);
		adpeakagegrptxt.setEditable(false);

		aapeakweeklbl = new JLabel("Peak Week of Affection");
		aapeakweektxt = new JTextField(30);
		aapeakweektxt.setEditable(false);

		adpeakweeklbl = new JLabel("Peak Week of Death");
		adpeakweektxt = new JTextField(30);
		adpeakweektxt.setEditable(false);
		
		JPanel pa1 = new JPanel();
		pa1.setLayout(new GridLayout(2,1,10,10));
		ashowbtnw.addActionListener(this);
		pa1.add(ashowbtnw);
		
		ashowbtna.addActionListener(this);
		pa1.add(ashowbtna);

		JPanel pa3=new JPanel();
		pa3.setLayout(new GridLayout(5,2,10,10));
		pa3.add(asyndlbl);
		pa3.add(asyndcmb);
		pa3.add(empty);
		ashowbtn.addActionListener(this);
		pa3.add(ashowbtn);
		pa3.add(empty);
		pa3.add(empty);
		pa3.add(empty);
		pa3.add(empty);
		pa3.add(empty);
		pa3.add(empty);
		
		
		JPanel pa4=new JPanel();
		pa4.setLayout(new GridLayout(6,2,10,10));
		pa4.add(aattlcntlbl);
		pa4.add(aattlcnttxt);
		pa4.add(adttlcntlbl);
		pa4.add(adttlcnttxt);

		pa4.add(aapeakagegrplbl);
		pa4.add(aapeakagegrptxt);
		pa4.add(adpeakagegrplbl);
		pa4.add(adpeakagegrptxt);
		pa4.add(aapeakweeklbl);
		pa4.add(aapeakweektxt);
		pa4.add(adpeakweeklbl);
		pa4.add(adpeakweektxt);
		
		JPanel ppa1 = new JPanel();
		ppa1.setLayout(new BorderLayout(20,20));
		ppa1.add(pa1,BorderLayout.NORTH);
		ppa1.add(pa3,BorderLayout.CENTER);
		ppa1.add(pa4,BorderLayout.SOUTH);
		
		setLayout(new FlowLayout());

		JTabbedPane tab = new JTabbedPane();
		tab.add("Citywise",pp1);					// Tab 1
		tab.add("Overall",ppa1);								// Tab 2

		getContentPane().add(tab);	
		
		setSize(700,600);									// Size of Main Window
		setVisible(true);											// Display the Fully Designed Window
	}

	public void actionPerformed(ActionEvent ae)
	{
		String sel = (String)citycmb.getSelectedItem();
		String selsyn = (String)syndcmb.getSelectedItem();
		
		if((JButton)ae.getSource()==citywise)
		{
			create_citygraph();
		}

		if((JButton)ae.getSource()==showbtn)					// whenever Button is Clicked, what to do
		{
			System.out.println("Button Clicked!");
			
			amalecnttxt.setText("");
			afemalecnttxt.setText("");
			attlcnttxt.setText("");
			dmalecnttxt.setText("");
			dfemalecnttxt.setText("");
			dttlcnttxt.setText("");
			apeakagegrptxt.setText("");
			dpeakagegrptxt.setText("");
			apeakweektxt.setText("");
			dpeakweektxt.setText("");

			setmale_female_cnt(sel,selsyn);

			set_peak_week(sel,selsyn);
			set_peak_age(sel,selsyn);

		}

		if((JButton)ae.getSource() == showbtnw)
		{
			System.out.println("week Button Clicked!");

			create_week_graph(sel);

		}
		
		if((JButton)ae.getSource() == showbtna)
		{
			System.out.println("age Button Clicked!");
			create_age_graph(sel);

		}
		if((JButton)ae.getSource()==ashowbtn)					// whenever Button is Clicked, what to do
		{
			System.out.println("Button Clicked!");
			
			aattlcnttxt.setText("");
			adttlcnttxt.setText("");
			aapeakagegrptxt.setText("");
			adpeakagegrptxt.setText("");
			aapeakweektxt.setText("");
			adpeakweektxt.setText("");

			setmale_female_cnt("all",selsyn);

			set_peak_week("all",selsyn);
			set_peak_age("all",selsyn);

		}

		if((JButton)ae.getSource() == ashowbtnw)
		{
			System.out.println("week Button Clicked!");

			create_week_graph("all");

		}
		
		if((JButton)ae.getSource() == ashowbtna)
		{
			System.out.println("age Button Clicked!");
			create_age_graph("all");

		}
	}
	
	void create_citygraph()
	{

		String filename = new String("data/cities");
		String wrtstr = new String("");
		try
		{
			Writer output=null;
			File file = new File("plot_command");
			output = new BufferedWriter(new FileWriter(file));

			FileInputStream fstream = new FileInputStream(filename);    // This is the input file
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String st,st1;
                        StringTokenizer stz;

			int i = 1;
			wrtstr = new String("set xtics ( ");
			while((st = br.readLine()) != null)
			{
                                stz = new StringTokenizer(st," ");

				stz.nextToken();

				st1 = stz.nextToken();

				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",0 front right rotate by 90 font \"tiny,8\"\n");
				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",-10000 front center \n");
				wrtstr = wrtstr.concat("\""+st1+"\" "+i+",");
				i=i+1;
			}
			wrtstr = wrtstr.substring(0,wrtstr.length()-1);
			wrtstr = wrtstr.concat(") rotate  by 90\n");
			output.write(wrtstr);
			
			

			wrtstr = new String("set title \"Cities Wise Dead-infected\"\n");
			output.write(wrtstr);
			wrtstr = new String("set xlabel \"Cities\"\n");
			output.write(wrtstr);
			wrtstr = new String("set xrange [0:12]\n");
			output.write(wrtstr);
			wrtstr = new String("set grid\n");
			output.write(wrtstr);
			wrtstr = new String("set style fill solid\n");
			output.write(wrtstr);
			//wrtstr = new String("set size 1,1\n");
			//output.write(wrtstr);
			//wrtstr = new String("set origin 0,0\n");
			//output.write(wrtstr);
			//wrtstr = new String("set multiplot layout 2,1\n");
			//output.write(wrtstr);
			//wrtstr = new String("set size 0,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("set origin 0,0\n");
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:3 title \"Infected\" with boxes lt rgb \"blue\"\n");
			//output.write(wrtstr);
			//wrtstr = new String("set size 0,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("set origin 0,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:4 title \"Dead\" with boxes lt rgb \"red\"\n");
			//output.write(wrtstr);
			//wrtstr = new String("unset multiplot\n");
 	     		wrtstr = new String("plot \""+filename+"\" using 1:3 title \"Infected\" with boxes lt rgb \"blue\",\""+filename+"\" using 1:4 title \"Dead\" with boxes lt rgb \"red\"\n");
			output.write(wrtstr);
			

			output.close();

			Runtime r = Runtime.getRuntime();
			r.exec("/usr/bin/gnuplot -persist < plot_command");

			//GNUPlot();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	void create_week_graph(String sel)
	{

		String filename = new String("data/"+sel+"/"+sel+"wdd1_week2.csv");
		String wrtstr = new String("");
		try
		{
			Writer output=null;
			File file = new File("plot_command");
			output = new BufferedWriter(new FileWriter(file));

			FileInputStream fstream = new FileInputStream(filename);    // This is the input file
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String st,st1;
                        StringTokenizer stz;

			br.readLine();
			int i = 1;
			wrtstr = new String("set xtics ( ");
			while((st = br.readLine()) != null)
			{
                                stz = new StringTokenizer(st," ");

				stz.nextToken();
				stz.nextToken();

				st1 = stz.nextToken();

				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",0 front right rotate by 90 font \"tiny,8\"\n");
				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",-10000 front center \n");
				wrtstr = wrtstr.concat("\""+st1+"\" "+i+",");
				i=i+1;
			}
			wrtstr = wrtstr.substring(0,wrtstr.length()-1);
			wrtstr = wrtstr.concat(") rotate  by 90\n");
			output.write(wrtstr);
			
			

			if(sel.equals("all"))
			{
				wrtstr = new String("set title \"Week Wise temporal pattern \"\n");
				output.write(wrtstr);
			}
			else
			{
				wrtstr = new String("set title \"Week Wise temporal pattern for "+sel+"\"\n");
				output.write(wrtstr);

			}
			wrtstr = new String("set xlabel \"Weeks\"\n");
			output.write(wrtstr);
			wrtstr = new String("set xrange [0:12]\n");
			output.write(wrtstr);
			wrtstr = new String("set grid\n");
			output.write(wrtstr);
			wrtstr = new String("set style fill solid\n");
			output.write(wrtstr);
			//wrtstr = new String("set multiplot\n");
			//output.write(wrtstr);
			wrtstr = new String("plot \""+filename+"\" using 1:5 title \"Infected\" with boxes lt rgb \"blue\", \""+filename+"\" using 1:4 title \"Dead\" with boxes lt rgb \"red\"");
			output.write(wrtstr);
			//wrtstr = new String("set size 1,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:7 title \"Infected\" with impulses"); 
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:8 title \"Dead\" with impulses");
			//output.write(wrtstr);
			

			output.close();

			Runtime r = Runtime.getRuntime();
			r.exec("/usr/bin/gnuplot -persist < plot_command");

			//GNUPlot();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	void create_age_graph(String sel)
	{

		String filename = new String("data/"+sel+"/"+sel+"wdd1_age2.csv");
		String wrtstr = new String("");
		try
		{
			Writer output=null;
			File file = new File("plot_command");
			output = new BufferedWriter(new FileWriter(file));

			FileInputStream fstream = new FileInputStream(filename);    // This is the input file
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String st,st1;
                        StringTokenizer stz;

			br.readLine();
			int i = 1;
			wrtstr = new String("set xtics ( ");
			while((st = br.readLine()) != null)
			{
                                stz = new StringTokenizer(st," ");

				stz.nextToken();
				stz.nextToken();
				stz.nextToken();

				st1 = stz.nextToken();

				wrtstr = wrtstr.concat("\""+st1+"\" "+i+",");
				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",0 front center font \"tiny,8\"\n");
				//wrtstr = new String("set label "+i+" \""+st1+"\" at "+i+",-10000 front center \n");
				//output.write(wrtstr);
				i=i+1;
			}
			wrtstr = wrtstr.substring(0,wrtstr.length()-1);
			wrtstr = wrtstr.concat(")\n");
			output.write(wrtstr);
			
			        
			if(sel.equals("all"))
			{
				wrtstr = new String("set title \"Age Wise distribution \"\n");
				output.write(wrtstr);
			}
			else
			{
				wrtstr = new String("set title \"Age Wise distribution for "+sel+"\"\n");
				output.write(wrtstr);

			}

			wrtstr = new String("set xlabel \"Age Groups\"\n");
			output.write(wrtstr);
			//wrtstr = new String("set xrange [ 0,12 ]\n");
			//output.write(wrtstr);

			wrtstr = new String("set grid\n");
			output.write(wrtstr);
			wrtstr = new String("set style fill solid\n");
			output.write(wrtstr);
			wrtstr = new String("plot \""+filename+"\" using 1:6 title \"Infected\" with boxes lt rgb \"blue\", \""+filename+"\" using 1:5 title \"Dead\" with boxes lt rgb \"red\"");
			output.write(wrtstr);
			//wrtstr = new String("set size 1,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:7 title \"Infected\" with impulses"); 
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:8 title \"Dead\" with impulses");
			//output.write(wrtstr);
			

			output.close();

			Runtime r = Runtime.getRuntime();
			r.exec("/usr/bin/gnuplot -persist < plot_command");

			//GNUPlot();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	void setmale_female_cnt(String sel,String selsyn)
	{

			selsyn = "\""+selsyn+"\"";
			String filename = new String("data/"+sel+"/"+sel+"wdd1_syms2.csv");
			//System.out.println("filenamr = "+filename);
			if(sel.equals("all"))
			{
				selsyn = "\""+asyndcmb.getSelectedItem()+"\"";
			}


			try
			{
				FileInputStream fstream = new FileInputStream(filename);    // This is the input file
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));

				String st,st1,st2,val,val1,val2;
				st2 = new String("");
				val = new String("");
				val1 = new String("");
				val2 = new String("");
				StringTokenizer stz;
				int flag = 0;

				br.readLine();

				while((st = br.readLine()) != null)
				{
					flag = 0;
					stz = new StringTokenizer(st," ");

					val = stz.nextToken();

					st1 = stz.nextToken();
                                        String t = new String(st1.substring(st1.length()-1,st1.length()));
					if(t.equals("\""))
					{
						st2 = stz.nextToken();
						flag = 1;
					}

					while(flag == 0)
					{
						st2 = stz.nextToken();
						String incomma = new String(st2.substring(st2.length()-1,st2.length()));
						if(incomma.equals("\""))
						{
                                                 	st1 = st1.concat(" "+st2);
							st2 = stz.nextToken();
							flag = 1;
						}
						else
						{
                                                 	st1 = st1.concat(" "+st2);
						}
					}
					//System.out.println("st1 = "+st1);
					if(st1.equals(selsyn))
					{                                  
						if(sel.equals("all"))
						{
							stz.nextToken();
							stz.nextToken();
							stz.nextToken();
							val1 = stz.nextToken();
							aattlcnttxt.setText(val1);
							val2 = stz.nextToken();
							adttlcnttxt.setText(val2);
							break;

						}
						afemalecnttxt.setText(st2);
						dfemalecnttxt.setText(stz.nextToken());
						amalecnttxt.setText(stz.nextToken());
						dmalecnttxt.setText(stz.nextToken());
						val1 = stz.nextToken();
						attlcnttxt.setText(val1);
						val2 = stz.nextToken();
						dttlcnttxt.setText(val2);
						break;
					}
				}

				create_dead_aff_graph(filename,selsyn,val,val1,val2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}


	void set_peak_week(String sel,String selsyn)
	{
			selsyn = "\""+selsyn+"\"";
			String filename = new String("data/"+sel+"/"+sel+"wdd1_sym_week2.csv");
			//System.out.println("filenamr = "+filename);


			try
			{
				FileInputStream fstream = new FileInputStream(filename);    // This is the input file
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));

				int i;
				int flag,flag1;
				int[] week_cnt;
				week_cnt = new int[11];
				for(i = 0; i < 11; i++)
				{
					week_cnt[i] = 0;
				}

				String week_name[] = new String[11];

				StringTokenizer stz;
				String st,st1,st2,val;
				st2 = new String("");
				st = br.readLine();
				stz = new StringTokenizer(st," ");

				stz.nextToken();
				stz.nextToken();

				for(i = 0; i < 11; i++)
				{
					week_name[i] = new String(stz.nextToken());
				}
				
				flag1 = 0;
				while((st = br.readLine()) != null)
				{
					flag = 0;
					stz = new StringTokenizer(st," ");

					val = stz.nextToken();

					st1 = stz.nextToken();
                                        String t = new String(st1.substring(st1.length()-1,st1.length()));
					if(t.equals("\""))
					{
						st2 = stz.nextToken();
						flag = 1;
					}

					while(flag == 0)
					{
						st2 = stz.nextToken();
						String incomma = new String(st2.substring(st2.length()-1,st2.length()));
						if(incomma.equals("\""))
						{
                                                 	st1 = st1.concat(" "+st2);
							st2 = stz.nextToken();
							flag = 1;
						}
						else
						{
                                                 	st1 = st1.concat(" "+st2);
						}
					}
					//System.out.println("st1 = "+st1);
					if(st1.equals(selsyn))
					{
						week_cnt[0] = Integer.parseInt(st2); 						
                                                for(i = 1; i < 11; i++)
						{
							week_cnt[i] = Integer.parseInt(stz.nextToken());
						}
                                                int max = -1;
						int maxindex = -1;
						for(i = 0; i < 11; i++)
						{
							if(week_cnt[i] > max)
							{
								max = week_cnt[i];
								maxindex = i;
							}
						}
						String pr = new String(week_name[maxindex]+"  no = "+max+"");
						if(flag1 == 0)
						{
                                                        if(sel.equals("all"))
							{
								aapeakweektxt.setText(pr);
								flag1 = 1;
								continue;
							}
							apeakweektxt.setText(pr);
						}
						if(flag1 == 1)
						{
                                                        if(sel.equals("all"))
							{
								adpeakweektxt.setText(pr);
								break;
							}
							dpeakweektxt.setText(pr);
							break;
						}
						flag1 = 1;

					}
				}



			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}


	void set_peak_age(String sel,String selsyn)
	{
			selsyn = "\""+selsyn+"\"";
			String filename = new String("data/"+sel+"/"+sel+"wdd1_sym_age2.csv");
			//System.out.println("filenamr = "+filename);


			try
			{
				FileInputStream fstream = new FileInputStream(filename);    // This is the input file
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));

				int i;
				int flag,flag1;
				int[] age_cnt;
				age_cnt = new int[10];
				for(i = 0; i < 10; i++)
				{
					age_cnt[i] = 0;
				}


				StringTokenizer stz;
				String st,st1,st2,val;
				st2 = new String("");
				
				flag1 = 0;
				while((st = br.readLine()) != null)
				{
					flag = 0;
					stz = new StringTokenizer(st," ");

					val = stz.nextToken();

					st1 = stz.nextToken();
                                        String t = new String(st1.substring(st1.length()-1,st1.length()));
					if(t.equals("\""))
					{
						st2 = stz.nextToken();
						flag = 1;
					}

					while(flag == 0)
					{
						st2 = stz.nextToken();
						String incomma = new String(st2.substring(st2.length()-1,st2.length()));
						if(incomma.equals("\""))
						{
                                                 	st1 = st1.concat(" "+st2);
							st2 = stz.nextToken();
							flag = 1;
						}
						else
						{
                                                 	st1 = st1.concat(" "+st2);
						}
					}
					//System.out.println("st1 = "+st1);
					if(st1.equals(selsyn))
					{
						age_cnt[0] = Integer.parseInt(st2); 						
                                                for(i = 1; i < 10; i++)
						{
							age_cnt[i] = Integer.parseInt(stz.nextToken());
						}
                                                int max = -1;
						int maxindex = -1;
						for(i = 0; i < 10; i++)
						{
							if(age_cnt[i] > max)
							{
								max = age_cnt[i];
								maxindex = i;
							}
						}
						int l = maxindex*10;
						int h = l+9;
						String pr = new String("Age group "+l+" to "+h+"  no = "+max+"");
						if(flag1 == 0)
						{
							if(sel.equals("all"))
							{
								aapeakagegrptxt.setText(pr);
								flag1 = 1;
								continue;
							}
							apeakagegrptxt.setText(pr);
						}
						if(flag1 == 1)
						{
							if(sel.equals("all"))
							{
								adpeakagegrptxt.setText(pr);
								break;
							}
							dpeakagegrptxt.setText(pr);
							break;
						}
						flag1 = 1;

					}
				}



			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	void create_dead_aff_graph(String filename,String syn,String val,String val1,String val2)
	{
		try
		{
			Writer output=null;
			File file = new File("plot_command");
			output = new BufferedWriter(new FileWriter(file));


			//System.out.println("file = "+filename);

			FileInputStream fstream = new FileInputStream(filename);    // This is the input file
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			br.readLine();
			String s1,s2,wrtstr;
			StringTokenizer stz;
			int i;
			int flag = 0;
			int x = 1000;
			for(i = 0; i < 3; i++)
			{
				flag = 0;
				s1 = br.readLine();
				stz = new StringTokenizer(s1," "); 

				String st1,st2,st3,xo;
				xo = stz.nextToken();
				
				st1 = stz.nextToken();
				String t = new String(st1.substring(st1.length()-1,st1.length()));
				if(t.equals("\""))
				{
					st2 = stz.nextToken();
					flag = 1;
				}

				while(flag == 0)
				{
					st2 = stz.nextToken();
					String incomma = new String(st2.substring(st2.length()-1,st2.length()));
					if(incomma.equals("\""))
					{
						st1 = st1.concat(" "+st2);
						st2 = stz.nextToken();
						flag = 1;
					}
					else
					{
						st1 = st1.concat(" "+st2);
					}
				}
				stz.nextToken();
				stz.nextToken();
				stz.nextToken();

				st3 = stz.nextToken();
				String syn2 = new String(st1.substring(1,st1.length()-1));
				wrtstr = new String("set label "+x+" \""+syn2+" Aff."+st3+"\" at "+xo+","+st3+" front font \"bold,7\"\n");
				output.write(wrtstr);
				x++;
			}
			
			//System.out.println("file = "+filename);
			FileInputStream fstream1 = new FileInputStream(filename);    // This is the input file
			DataInputStream in1 = new DataInputStream(fstream1);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
			
			br1.readLine();
			i = 1;
			wrtstr = new String("set xtics ( ");
			String st;
			while((st = br1.readLine()) != null)
			{
                                stz = new StringTokenizer(st,"\"");

				String st2 = stz.nextToken();

				String st1 = stz.nextToken();

				wrtstr = wrtstr.concat("\""+st1+"\" "+st2+",");
				i++;
			}
			wrtstr = wrtstr.substring(0,wrtstr.length()-1);
			wrtstr = wrtstr.concat(") rotate by 90 font \"tiny,6\"\n");
			output.write(wrtstr);
			

			if(filename.equals("data/all/allwdd1_syms2.csv"))
			{
				wrtstr = new String("set title \"Syndrome distribution \"\n");
				output.write(wrtstr);
			}
			else
			{
				wrtstr = new String("set title \"Syndrome distribution for "+(String)citycmb.getSelectedItem()+"\"\n");
				output.write(wrtstr);

			}

			String syn1 = new String(syn.substring(1,syn.length()-1));

			wrtstr = new String("set label "+val+" \""+syn1+" Aff."+val1+"\" at "+val+","+val1+" front font \"bold,7\"\n");
			output.write(wrtstr);
			int nextval = Integer.parseInt(val);
			int valprev = nextval - 3;
	       		wrtstr = new String("set arrow from "+valprev+","+val1+" to "+val+","+val1+" front lw 2 head filled\n");
			output.write(wrtstr);

			wrtstr = new String("set label 2 \""+syn1+" Dead."+val2+"\" at "+val+","+val2+" front font \"bold,7\"\n");
			output.write(wrtstr);
			nextval = Integer.parseInt(val);
			valprev = nextval - 3;
	       		wrtstr = new String("set arrow from "+valprev+","+val2+" to "+val+","+val2+" front lw 2 head filled\n");
			output.write(wrtstr);
			wrtstr = new String("set xrange [0:78]\n");
			output.write(wrtstr);
			wrtstr = new String("set xlabel \"Syndrome\"\n");
			output.write(wrtstr);
			wrtstr = new String("set grid lw 0\n");
			output.write(wrtstr);
			//wrtstr = new String("set multiplot\n");
			//output.write(wrtstr);
			wrtstr = new String("plot \""+filename+"\" using 1:7 title \"Infected\" with impulses lw 2 lt rgb \"blue\", \""+filename+"\" using 1:8 title \"Dead\" with impulses lw 3 lt rgb \"red\"");
			output.write(wrtstr);
			//wrtstr = new String("set size 1,0.5\n");
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:7 title \"Infected\" with impulses"); 
			//output.write(wrtstr);
			//wrtstr = new String("plot \""+filename+"\" using 1:8 title \"Dead\" with impulses");
			//output.write(wrtstr);
			

			output.close();

			Runtime r = Runtime.getRuntime();
			r.exec("/usr/bin/gnuplot -persist < plot_command");

			//GNUPlot();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		new RootWindow1();										// Disply Root Window
		System.out.println("Hello World!");
	}
}
