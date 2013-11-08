
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

class Syndrome
{
	String name;
	int added = 0;
	int count = 0;
	int d_count = 0;
	int mcount = 0;
	int fcount = 0;

	int w_rng = 11;

	int[] w_cnta;
	int[] w_cntd;
		
	void Syndrome()
	{
		name = new String("xxx");
		added = 0;
		count = 0;
		d_count = 0;
		mcount = 0;
		fcount = 0;

		w_rng = 11;

		int i = 0;
		w_cnta = new int[w_rng];
		for(i = 0; i < w_rng; i++)
		{
			w_cnta[i] = 0;
		}
		w_cntd = new int[w_rng];
		for(i = 0; i < w_rng; i++)
		{
			w_cntd[i] = 0;
		}

	}
	void add()
	{
		added = 1;
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
		deathdate = new String("xxx");
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
	void set_record(String s1, String s2, String s3, String s4, String s5, String s6, String s7,String s8)
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

class Syndrome_classify_date1
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

		       // System.out.println("i = "+i+"\tend : "+w[i].end.day+"-"+w[i].end.month+"\tstart : "+w[i].start.day+"-"+w[i].start.month);

			if(day + 1 > 30)
			{
				mon = mon + 1;
				day = 1;
			}
			else
				day++;

		}



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
			s[i].w_rng = 11;
			s[i].w_cnta = new int[w_rng];
			s[i].w_cntd = new int[w_rng];
			int j;
			for(j = 0; j < w_rng;j++)
			{
				s[i].w_cnta[j] = 0;
				s[i].w_cntd[j] = 0;
			}
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

		int flag1=0;

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

			String t[] = new String[8];

			for(i = 0; i < 8; i++)
			{
				t[i] = new String(stz.nextToken());
			}

			//System.out.println(t[6]);
                       	r[rec_count].set_record(t[0],t[1],t[2],t[3],t[4],t[5],t[6],t[7]);
			rec_count++;

			if(rec_count == range)
				break;


		}



		for(i = 0; i < rec_count; i++)
		{
                        
			int j = 0;
			int flag = 0;
			int count = 0;
 			int dead_count = 0;
			int male_count = 0;
			int fem_count = 0;
			int k = 0;

			for(j = 0; j < syn_count; j++)
			{
				if(r[i].synd.equals(s[j].name))
				{
                                         	String t = r[i].date;
						s[j].count++;

						stz1 = new StringTokenizer(t,"-");

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
								s[j].w_cnta[k]++;
						}

						if(r[i].stat.equals("\"Dead\""))
						{
                                                        s[j].d_count++;
							
							String t3 = r[i].deathdate;
							stz1 = new StringTokenizer(t3,"-");

							String t4 = stz1.nextToken();
							t4 = t4.substring(1,t4.length());

							String t5 = stz1.nextToken();

							int m1 = Integer.parseInt(t4);
							int d1 = Integer.parseInt(t5);

							Date dat1 = new Date();
							dat1.day = d1;
							dat1.month = m1;

							for(k = 0; k < w_rng; k++)
							{
								if(w[k].isin(dat1))
								{
//									System.out.println("IM HERE");
									s[j].w_cntd[k]++;
								}
							}


						}
				}
			}


					
			
		}
		if(flag1 == 1)
			break;
		}

		int j = 0;


		System.out.format("%2s%21s","#","SYNDROME");
	
		for(j = 0; j < w_rng; j++)
		{
			String t = w[j].start.month+"/"+w[j].start.day+"-"+w[j].end.month+"/"+w[j].end.day+"";
			System.out.format("%11s",t);
		}

		System.out.format(" TOTAL\n");

		for(j = 0; j < syn_count; j++)
		{
			st = new String(s[j].name + "\t" );

			int l = j+1;

			System.out.format("%2d%21s",l,s[j].name);

			int k = 0;
			for(k = 0; k < w_rng; k++)
			{
                                String sb = s[j].w_cnta[k]+"";

				System.out.format(" %8s ",sb);

				String sa=s[j].w_cnta[k]+"";
				st = st.concat(sa + "\t");
			}
			System.out.format(" %8d\n",s[j].count);
			st = st.concat(s[j].d_count + "\n");
			output.write(st);
			
			System.out.format("%2d%21s",l,s[j].name);

			k = 0;
			for(k = 0; k < w_rng; k++)
			{
                                String sb = s[j].w_cntd[k]+"";

				System.out.format(" %8s ",sb);

				String sa=s[j].w_cntd[k]+"";
				st = st.concat(sa + "\t");
			}
			System.out.format(" %8d\n",s[j].d_count);
			st = st.concat(s[j].d_count + "\n");
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

