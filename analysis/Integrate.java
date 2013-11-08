

//usage : java Classify_op <input file> <output file> <death file>

import java.io.*;
import java.util.StringTokenizer;
class Integrate
{
	public static void main(String args[])
	{
	
	try
	{
	FileInputStream fstream = new FileInputStream(args[0]);    // This is the input file
	
	DataInputStream in = new DataInputStream(fstream);
	
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	Writer output=null;
	File file = new File(args[1]);

	output = new BufferedWriter(new FileWriter(file));
	

	String strLine,st,st1,st2;
	StringTokenizer stz,stz1;


	//declare array
	int range = 10000000;
	int[] pid;
	pid = new int[range];

	String d_dates[] = new String[range];

	int i=0;

	for(i = 0; i < range; i++)
	{
		pid[i] = 0;
	}
	
	for(i = 0; i < range; i++)
	{
		d_dates[i] = new String("xxx");
	}

	FileInputStream fstream1 = new FileInputStream(args[2]);// This is the input file
	DataInputStream in1 = new DataInputStream(fstream1);
	BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
	
        br1.readLine();

	while((st1=br1.readLine())!=null)
	{
		stz1=new StringTokenizer(st1,",");
			
		stz1.nextToken();
		st2 = stz1.nextToken();
	
		st1=stz1.nextToken();
		
		int len=st1.length();

		st1 = st1.substring(1,len-1);

		//System.out.println("pid = "+st1);

                int cur_pid = Integer.parseInt(st1);
		//System.out.println("pid = "+cur_pid);

		pid[cur_pid] = 1;
		d_dates[cur_pid] = new String(st2);
	}

	br1.close();
	in1.close();
	fstream1.close();
	

        	strLine = br.readLine();
		strLine = strLine.concat(",STAT,DEATHDATE\n");
		output.write(strLine);
		while ((strLine = br.readLine()) != null)
		{
			int flag=0;
			//System.out.println (strLine);
			stz=new StringTokenizer(strLine,",");

			stz.nextToken();
			stz.nextToken();
			stz.nextToken();
			
			st=stz.nextToken();
			//System.out.println("Id is: "+st);

			int len = st.length();
			st = st.substring(1,len-1);

			int cur_pid = Integer.parseInt(st);
		
			if(pid[cur_pid] == 0)
			{
				String s = new String(",\""+"Alive"+"\""+",\"xxx\"\n");
				strLine=strLine.concat(s);
				output.write(strLine);
			}
			else
			{
				String s = new String(",\""+"Dead"+"\""+","+d_dates[cur_pid]+"\n");
				strLine=strLine.concat(s);
				output.write(strLine);
			}

		}
		output.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}
