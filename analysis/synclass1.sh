for name in `ls ../gui1.2/data`
	do
		echo $name
		e="wdd1.csv"
		in="$name$e"
		echo $in
		
		s="wdd1_syms.csv"
		out="$name$s"
		echo $out 

		s1="_sym.csv"
		sym="$name$s1"
		echo $sym

		s2="wdd1_syms2.csv"
		out2="$name$s2"
		echo $out2

		java  -Xmx2600m Syndrome_classify2 ../gui1.2/data/$name/$in ../gui1.2/data/$name/$out ../gui1.2/data/$name/$sym > ../gui1.2/data/$name/$out2
		echo "finished"
		echo
	done
