

rm *.class
javac Syndrome_classify_age1.java
java -Xmx2000m Syndrome_classify_age1 ../gui1.1/all/allwdd1.csv ../gui1.1/all/allwdd1_sym_age.csv ../gui1.1/all/all_sym.csv > ../gui1.1/all/allwdd1_sym_age2.csv

echo "syn age finished"

rm *.class
javac Syndrome_classify_date1.java
java -Xmx2000m Syndrome_classify_date1 ../gui1.1/all/allwdd1.csv ../gui1.1/all/allwdd1_sym_week.csv ../gui1.1/all/all_sym.csv > ../gui1.1/all/allwdd1_sym_week2.csv

echo "syn week finished"

rm *.class
javac Classify_week1.java
java -Xmx2000m Classify_week1 ../gui1.1/all/allwdd1.csv ../gui1.1/all/allwdd1_week.csv ../gui1.1/all/all_sym.csv > ../gui1.1/all/allwdd1_week2.csv

echo "week finished"

rm *.class
javac Classify_age1.java
java -Xmx2000m Classify_age1 ../gui1.1/all/allwdd1.csv ../gui1.1/all/allwdd1_age.csv ../gui1.1/all/all_sym.csv > ../gui1.1/all/allwdd1_age2.csv
