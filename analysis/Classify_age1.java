
// Usage : java Takelives_op <in> <out> <sym-file>


import java.io.*;
import java.util.*;



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

class Classify_age1
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

		int a_rng = 10;

		int[] agegrp;
		agegrp = new int[a_rng];
		for(i = 0; i < a_rng; i++)
		{
			agegrp[i] = 0;
		}
		int[] agegrpd;
		agegrpd = new int[a_rng];
		for(i = 0; i < a_rng; i++)
		{
			agegrpd[i] = 0;
		}

		

		FileInputStream fstream1 = new FileInputStream(args[0]);    // This is the input file
		DataInputStream in1 = new DataInputStream(fstream1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		br1.readLine();

		int flag1 = 0;

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

//		System.out.println("RECORDS ADDED");

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

			agegrp[age]++;

			if(r[i].stat.equals("\"Dead\""))
				agegrpd[age]++;


		
		}
		if(flag1 == 1)
			break;
		}
		
		System.out.format("%2s %12s %10s %10s\n","#","AGE GRP","DEAD","AFFECTED");

		
		for(i = 0; i < a_rng; i++)
		{
			int l = i*10;
			int h = l+9;

			System.out.format("%2d %s %d%s%d %8d %8d\n",i+1,"Age grp",l,"-",h,agegrpd[i],agegrp[i]);

			st = new String("Age grp "+l+"-"+h+"\t"+agegrpd[i]+"\t"+agegrp[i]+"\n");	

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

