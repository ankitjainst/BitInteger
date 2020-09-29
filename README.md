# BitInteger
BitInteger is a java class for storing integer with internal representation in little endian or big endian form.
It provides helper methods to convert to byte array and read from byte array

# Demo use
The following programs make use of the BitInteger class to write 3 integers from Java and read them from C.

# C Programs
read_integers.c is a C program to read 3 integer values from a binary file 
write_integers.c is a C program to write 3 integer values to a binary file 

# BitIntegerDemo
This class uses BitInteger to read/ write three integers from a binary file
The first argument is the path to the data file and second argument is read or write

#Endian ness support
C will make use of the endian ness specific to the machine and JVM by default is BigEndian. The BitInteger provides support for both little endian and big endian.

#Helpful scripts
write_java.sh : writes three integers to data_java.bin
read_java.sh : reads three integers from data_java.bin

write_c.sh : writes three integers to data_c.bin
read_c.sh : reads three integers from data_c.bin
