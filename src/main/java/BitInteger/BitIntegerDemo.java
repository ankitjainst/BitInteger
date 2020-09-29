package BitInteger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BitIntegerDemo {
    String dataFile;
    String notationUsed = BitInteger.littleEndian;
    public static void main(String[] args) {
    	BitIntegerDemo bitDemo = new BitIntegerDemo(args);
        if(args.length >1 && args[1].equals("write"))
            bitDemo.writeThreeIntsToFile();
        if(args.length >1 && args[1].equals("read"))
	        bitDemo.readBack();
    }
    public BitIntegerDemo(String[] args){
	if(args.length > 1) {
        System.out.println("Using file " + args[0]);
        dataFile = args[0];
    }else{
        System.out.println("Please specify data file");
        System.exit(1);
    }
	}
    public void readBack(){
	//now read back from file and display
        byte[] readBack = readFromFile(dataFile);
        System.out.println("Read "+readBack.length+" bytes from"+dataFile);
	    BitInteger bi = new BitInteger();
	    //bi.notation = notationUsed;
	
        bi.byteArrToBitInteger(readBack,0);
        System.out.println("First value in binary as encoded is "+bi.toString());
        System.out.println("--------------------------");
	System.out.println("Values read back from file");
        System.out.println("First value "+bi.getValue());
        bi.byteArrToBitInteger(readBack,4);
        System.out.println("Second value "+bi.getValue());
        bi.byteArrToBitInteger(readBack,8);
        System.out.println("Third value "+bi.getValue());
        System.out.println("--------------------------");
    }
    public byte[] readFromFile(String file){
        System.out.println("Reading from file "+file);
        try {
            byte[] read = Files.readAllBytes(Paths.get(file));
            return read;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeThreeIntsToFile(){
	int n1=13,n2=-220,n3=515;
        System.out.println("Attempting to write to "+dataFile);
	try {
		File file = new File(dataFile);
		OutputStream os = new FileOutputStream(file);
		System.out.println("Writing three values "+n1+", "+n2+", "+n3+" to file");
		BitInteger b = new BitInteger();
		//b.notation = notationUsed;
		b.valueToBitInteger(n1);
		os.write(b.toByteArray());
		b.valueToBitInteger(n2);
		os.write(b.toByteArray());
		b.valueToBitInteger(n3);
		os.write(b.toByteArray());

		os.close();
	}

        catch (Exception e) {
            System.out.println("Exception: " + e);
            System.out.println(e.getStackTrace());
        }
    }

}
