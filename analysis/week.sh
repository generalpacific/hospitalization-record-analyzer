for name in `ls ../gui/data`
	do
		echo $name
		e="wdd1.csv"
		in="$name$e"
		echo $in
		
		s="wdd1_week.csv"
		out="$name$s"
		echo $out 


		s2="wdd1_week2.csv"
		out2="$name$s2"
		echo $out2

		rm *.class
		javac Classify_week.java
		java  -Xmx2600m Classify_week ../gui/data/$name/$in ../gui/data/$name/$out  > ../gui/data/$name/$out2
		echo "finished"
		echo
	done
