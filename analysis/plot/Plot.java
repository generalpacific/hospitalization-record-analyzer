

import java.io.*;
import java.util.*;


class Plot
{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String st,st1;
			StringTokenizer stz;
			double i = 1.5;
			int j = 1;
			int k = -100;
			int flag = 0;
			while((st = br.readLine()) != null)
			{
                                stz = new StringTokenizer(st,"#");

				st1 = stz.nextToken();

				System.out.println("set label "+j+" "+st1+" at "+i+","+k);
				j = j+1;
				i = i+1;
				if(k == 1400)
				{
					flag = 0;	
				}
				else if (k == -100)
				{
					flag = 1;
				}

				if(flag == 1)
					k = k + 100;
				if(flag == 0)
					k = k - 150;
			}

			System.out.println("plot \""+args[1]+"\" using 1:2 with steps");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
