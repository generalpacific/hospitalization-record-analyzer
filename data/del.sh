for name in `ls`
	do
		d="-deaths.csv"
		wd="wdd1.csv"
		v="v1.csv"
		c=".csv"

		ds="$name$d"
		wds="$name$wd"
		vs="$name$v"
		cs="$name$c"

		rm $name/$cs $name/$ds $name/$wds $name/$vs
	done
