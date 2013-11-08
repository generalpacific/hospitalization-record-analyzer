for name in `ls ../gui/data`
	do
		echo $name
		e="wdd1.csv"
		in="$name$e"
		echo $in
		
		s="wdd1_sym_age.csv"
		out="$name$s"
		echo $out 

		s1="_sym.csv"
		sym="$name$s1"
		echo $sym

		s2="wdd1_sym_age2.csv"
		out2="$name$s2"
		echo $out2

		rm *.class
		javac Syndrome_classify_age.java
		java -Xmx2600m  Syndrome_classify_age ../gui/data/$name/$in ../gui/data/$name/$out ../gui/data/$name/$sym > ../gui/data/$name/$out2
		echo "finished"
		echo
	done
