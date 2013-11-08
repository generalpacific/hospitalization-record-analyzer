
// Usage : java Takelives_op <in> <out> <sym-file>


import java.io.*;
import java.util.*;



class Syndrome
{
	String name;
	int added = 0;
	int count = 0;
	int d_count = 0;
	int mcount = 0;
	int fcount = 0;

	int[] agegrpa;
	int[] agegrpd;


	
		
	void Syndrome()
	{
		name = new String("xxx");
		added = 0;
		count = 0;
		d_count = 0;
		mcount = 0;
		fcount = 0;

		agegrpa = new int[10];
		agegrpd = new int[10];
		int i = 0;
		for(i = 0; i < 10; i++)
		{
			agegrpa[i] = 0;
			agegrpd[i] = 0;
		}
        }
	void add()
	{
		added = 1;
	}

}

class Records
{
	String usr_warning,date,gender,age,synd,stat,pid;

	void Records()
	{
		usr_warning = new String("xxx");
		date = new String("xxx");
		gender = new String("xxx");
		age = new String("xxx");
		synd = new String("xxx");
		stat = new String("xxx");
		pid = new String("xxx");
	}

	void set_record(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
	{
		usr_warning = new String(s1);
		date = new String(s2);
		gender = new String(s3);
		pid = new String(s4);
		age = new String(s5);
		synd = new String(s6);
		stat = new String(s7);

	}

	String get_wrt_str(int pid)
	{
          	String wrt;

		wrt = new String(usr_warning);
		wrt = wrt.concat(","+date);
		wrt = wrt.concat(","+gender);
		wrt = wrt.concat(",\""+pid+"\"");

		wrt = wrt.concat(","+age);
		wrt = wrt.concat(","+synd);
		wrt = wrt.concat(","+stat);
		wrt = wrt.concat("\n");

		return wrt;
	}
}

class Syndrome_classify_age1
{
	public static void main(String args[])
	{
	
	try
	{
		Writer output=null;
		File file = new File(args[1]);

		output = new BufferedWriter(new FileWriter(file));
		

		String strLine,st,st1,st2;
		StringTokenizer stz,stz1;
                                                


  		int i;


		int range = 100000;
		int rec_count = 0;

		Records r[] = new Records[range];
		for(i = 0; i < range; i++)
		{
			r[i] = new Records();
		}

		int syn_range = 100;
		int syn_count = 0;
		Syndrome s[] = new Syndrome[syn_range];
		for(i = 0; i < syn_range; i++)
		{
			s[i] = new Syndrome();
		}
		
		FileInputStream fstream = new FileInputStream(args[2]);    // This is the input file
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		while((st = br.readLine()) != null)
		{
			stz = new StringTokenizer(st,"#");

			st1 = stz.nextToken();

			s[syn_count].name = st1;
			syn_count++;
		}

		FileInputStream fstream1 = new FileInputStream(args[0]);    // This is the input file
		DataInputStream in1 = new DataInputStream(fstream1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		br1.readLine();

		int flag1 = 0;
		for(int j = 0; j < syn_range; j++)
		{
			s[j].agegrpa = new int[10];
			s[j].agegrpd = new int[10];
			for(i = 0; i < 10; i++)
			{
				s[j].agegrpa[i] = 0;
				s[j].agegrpd[i] = 0;
                 	}
		}

		while(true)
		{
		rec_count = 0;
		while(true)
		{
                        strLine = br1.readLine();
			if(strLine == null)
			{
				flag1 = 1;
				break;
			}

			stz = new StringTokenizer(strLine,",");

			String t[] = new String[7];

			for(i = 0; i < 7; i++)
			{
				t[i] = new String(stz.nextToken());
			}

			//System.out.println(t[6]);
                       	r[rec_count].set_record(t[0],t[1],t[2],t[3],t[4],t[5],t[6]);
			rec_count++;

			if(rec_count == range)
				break;


		}

		//System.out.println("RECORDS ADDED");



		for(i = 0; i < rec_count; i++)
		{
                        
			int j = 0;
			int flag = 0;
			int count = 0;
 			int dead_count = 0;
			int male_count = 0;
			int fem_count = 0;
			int k = 0;
                	
			int age_count = 0;

                       	String ag = r[i].age;

			ag = ag.substring(1,ag.length()-1);

			int age = Integer.parseInt(ag);

			age = age/10;

			for(j = 0; j < syn_count; j++)
			{
				if(s[j].name.equals(r[i].synd))
				{
					s[j].agegrpa[age]++;
					s[j].count++;
					if(r[i].stat.equals("\"Dead\""))
					{
						s[j].d_count++;
						s[j].agegrpd[age]++;
					}
				}
			}

			

		
		}
		if(flag1 == 1)
			break;
		}

		
		int j;
		for(i = 0; i < syn_count; i++)
		{
			int l = i+1;

			System.out.format("%2d %20s ",l,s[i].name);

			st = new String(s[i].name+"\t");
		     	for(j = 0; j < 10; j++)
			{
				String t1 = new String(s[i].agegrpa[j]+""); 
				System.out.format(" %8s ",t1);
				String t = new String(s[i].agegrpa[j]+""); 
                                st = st.concat(t + "\t");
			}
			System.out.format(" %10d\n",s[i].count);
			st = st.concat(s[i].count+"\n");
			
			System.out.format("%2d %20s ",l,s[i].name);

			st = new String(s[i].name+"\t");
		     	for(j = 0; j < 10; j++)
			{
				String t1 = new String(s[i].agegrpd[j]+""); 
				System.out.format(" %8s ",t1);
				String t = new String(s[i].agegrpd[j]+""); 
                                st = st.concat(t + "\t");
			}
			System.out.format(" %10d\n",s[i].d_count);
			st = st.concat(s[i].d_count+"\n");

			output.write(st);
		}

		output.close();


	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}

