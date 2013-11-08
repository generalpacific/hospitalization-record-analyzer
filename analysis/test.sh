rm *.class
javac Syndrome_classify_date.java
java -Xmx2600m Syndrome_classify_date ../gui/data/Aleppo/Aleppowdd1.csv ../gui/data/Aleppo/Aleppowdd1_sym_week.csv ../gui/data/Aleppo/Aleppo_sym.csv > ../gui/data/Aleppo/Aleppowdd1_sym_week2.csv
