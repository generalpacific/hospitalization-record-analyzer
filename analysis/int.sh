for name in `ls ../gui/data`
	do
		echo $name
		e="v1"
		in="$name$e"
		echo
		echo $in
		
		s="wdd1.csv"
		out="$name$s"
		echo
		echo $out 

		d="-deaths.csv"
		death="$name$d"
		echo
		echo $death

		java Integrate ../gui/data/$name/$in.csv ../gui/data/$name/$out ../gui/data/$name/$death
		echo "finished"
	done
