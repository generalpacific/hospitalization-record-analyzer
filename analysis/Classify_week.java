
// Usage : java Takelives_op <in> <out> <sym-file>


import java.io.*;
import java.util.*;


class Date
{
	int day;
	int month;

	void Date()
	{
		day = 0;
		month = 0;
	}

	boolean compare(int d,int m)
	{
         	if(d == day && m == month)
		{			
			return true; 
		}
		return false;
	}

	boolean isin_seven(Date d)
	{
		int diff = 0;

		if(month == d.month)
		{
			diff = d.day - day;
			if(diff < 7 && diff >= 0)
			{
                          	return true;
			}
			else
				return false;
		}
		else if(month != d.month-1)
			return false;
		else if(month == d.month-1)
		{
			diff = 30 - day + d.day;

			if(diff < 7 && diff >= 0)
				return true;
			else
				return false;
		}
		return false;

	}
}

class Week
{
	Date start;
	Date end;

	void Week()
	{
		start = new Date();
		end = new Date();
	}

	boolean isin(Date d)
	{
		if(start.isin_seven(d))
		{
			return true;
		}
		return false;
	}
}


class Records
{
	String usr_warning,date,gender,age,synd,stat,pid,deathdate;

	void Records()
	{
		usr_warning = new String("xxx");
		date = new String("xxx");
		gender = new String("xxx");
		age = new String("xxx");
		synd = new String("xxx");
		stat = new String("xxx");
		pid = new String("xxx");
		deathdate = new String ("xxx");
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

	void set_record(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8)
	{
		usr_warning = new String(s1);
		date = new String(s2);
		gender = new String(s3);
		pid = new String(s4);
		age = new String(s5);
		synd = new String(s6);
		stat = new String(s7);
		deathdate = new String(s8);

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

class Classify_week
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
                                                


		int w_rng = 11;
		Week w[] = new Week[w_rng];
		int[] w_cnta;
		w_cnta = new int[w_rng];

		int[] w_cntd;
		w_cntd = new int[w_rng];

		int i = 0;
		int day = 16;
		int mon = 4;
		for(i = 0; i < w_rng; i++)
		{


			w[i] = new Week();
			Date d = new Date();
			d.day = day;
			d.month = mon;
			w[i].start = d;

			if(day + 6 > 30)
			{
				mon = mon + 1;
				day = 6 - (30 - day);
			}
			else
			{
				day = day + 6;
			}

			d=new Date();
			d.day = day;
			d.month = mon;

			w[i].end = d;

//			System.out.println("i = "+i+"\tend : "+w[i].end.day+"-"+w[i].end.month+"\tstart : "+w[i].start.day+"-"+w[i].start.month);

			if(day + 1 > 30)
			{
				mon = mon + 1;
				day = 1;
			}
			else
				day++;

		}


		for(i = 0; i < w_rng; i++)
		{
			w_cnta[i] = 0;
		}
		for(i = 0; i < w_rng; i++)
		{
			w_cntd[i] = 0;
		}

		int range = 10000000;
		int rec_count = 0;

		Records r[] = new Records[range];
		for(i = 0; i < range; i++)
		{
			r[i] = new Records();
		}

		

		FileInputStream fstream1 = new FileInputStream(args[0]);    // This is the input file
		DataInputStream in1 = new DataInputStream(fstream1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		br1.readLine();

		while((strLine = br1.readLine()) != null)
		{
			stz = new StringTokenizer(strLine,",");

			String t[] = new String[8];

			for(i = 0; i < 8; i++)
			{
				t[i] = new String(stz.nextToken());
			}

			//System.out.println(t[6]);
                       	r[rec_count].set_record(t[0],t[1],t[2],t[3],t[4],t[5],t[6],t[7]);
			rec_count++;


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


			count = 0;
			dead_count = 0;
			male_count = 0;
			fem_count = 0;

			st = r[i].date;
 //       		System.out.println("affected date = " + st);


			stz1 = new StringTokenizer(st,"-");

			String t1 = stz1.nextToken();
			t1 = t1.substring(1,t1.length());

			String t2 = stz1.nextToken();

			int m = Integer.parseInt(t1);
			int d = Integer.parseInt(t2);

			Date dat = new Date();
			dat.day = d;
			dat.month = m;

			for(k = 0; k < w_rng; k++)
			{
				if(w[k].isin(dat))
				{
					//System.out.println(k+1+"incremented at " + j);
					w_cnta[k]++;
				}
			}
			


			if(r[i].stat.equals("\"Dead\""))
			{
				dead_count++;

				String t = r[i].deathdate;

  //      			System.out.println("death date = " + t);
  
				stz1 = new StringTokenizer(t,"-");

				String tt1 = stz1.nextToken();
				tt1 = tt1.substring(1,tt1.length());

				String tt2 = stz1.nextToken();

				int mm = Integer.parseInt(tt1);
				int dd = Integer.parseInt(tt2);

				Date dat1 = new Date();
				dat1.day = dd;
				dat1.month = mm;

				for(k = 0; k < w_rng; k++)
				{
					if(w[k].isin(dat1))
						w_cntd[k]++;
				}

				
			}
				

					

			

			
		}

		System.out.format("%2s %5s %8s %8s\n","#","Week","DEAD","AFFECTED");

		int j = 0;
		for(j = 0; j < w_rng; j++)
		{
			int a = j+1;
			System.out.format("%2d %5s %d%s%d%s%d%s%d %8d %8d\n",a,"Week",w[j].start.month,"/",w[j].start.day,"-",w[j].end.month,"/",w[j].end.day,w_cntd[j],w_cnta[j]);
			st = ("Week "+a+"\t"+w_cntd[j]+"\t"+w_cnta[j]+"\n");
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

