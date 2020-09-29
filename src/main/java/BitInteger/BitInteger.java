package BitInteger;

//Store java integers according to little endian or big endian notation
//Provides methods to convert from and back java integers
public class BitInteger {
    public static final String bigEndian = "bigEndian";
    public static final String littleEndian = "littleEndian";
    public String notation=littleEndian;

    boolean[] bitInteger;

    public BitInteger(){
        bitInteger = new boolean[32];
    }

    //set the ith bit
    //bitNum goes from 0 to 7 and byteNum goes from 0 to 3
    public void set(int byteNum, int bitNum){
        specifiedVal(byteNum, bitNum, true);
    }

    private void specifiedVal(int byteNum, int bitNum, boolean val) {
        if(notation.equals(bigEndian))
            bitInteger[31-(byteNum *8+ bitNum)] = val;
        else{
            bitInteger[(3-byteNum) *8+(7- bitNum)] = val;
        }
    }

    //get the ith bit
    public boolean get(int byteNum, int bitNum){
        if(notation.equals(bigEndian))
            return bitInteger[31-(byteNum*8+bitNum)];
        else{
            return bitInteger[byteNum*8+(7-bitNum)];
        }
    }

    public void clear(int byteNum, int bitNum){
        specifiedVal(byteNum, bitNum, false);
    }

    //convert internal bit representation to java int
    public int getValue() {
        int value = 0;
        for(int byteNum = 0;byteNum<4;byteNum++) {
            for (int bitNum = 0; bitNum < 8; bitNum++) {
                value += get(byteNum, bitNum) ? (1 << byteNum*8+bitNum) : 0;
            }
        }
        return value;
    }

    //converts integer to BitInteger
    public void valueToBitInteger(int value) {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<8;j++)
            {
                clear(i,j);
            }
        }
        int byteNum = 0;
        int bitNum = 0;
        while (value != 0) {
            if (value % 2 != 0) {
                set(byteNum, bitNum);
            }
            ++bitNum;
            if(bitNum==8){
                bitNum =0;
                byteNum++;
            }
            //unsigned right shift
            value = value >>> 1;
        }
    }

    //returns byte array, note because the internal representation takes care of the endian notation so it just
    //returns in the same order
    public byte[] toByteArray(){
        byte[] ba = new byte[4];
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++) {
                if (get(i,j))
                    ba[3-i] |= (byte)(1 << (j));
            }
        }
        return ba;
    }

    //reads 32 bits from startByte in src
    public void byteArrToBitInteger(byte[] src, int startByte) {
        for(int byteNum = 0;byteNum<4;byteNum++) {
            for(int offset = 0;offset<8;offset++) {
                //determine if this bit startIndex + offset is set or not
                byte q = src[3-byteNum+startByte];
                if ((q & ((byte) 1 << (offset))) != 0) {
                    set(byteNum, offset);
                }else{
                    clear(byteNum, offset);
                }
            }
        }
    }

    //returns a String representation of 0's and 1's
    public String toString(){
        StringBuffer sb = new StringBuffer();
        if(notation.equals(bigEndian)) {
            for (int byteNum = 3; byteNum >= 0; byteNum--) {
                for (int bitNum = 7; bitNum >= 0; bitNum--) {
                    if (get(byteNum, bitNum)) sb.append("1");
                    else sb.append("0");
                }
            }
        } else {
            if(notation.equals(littleEndian)) {
                for(int byteNum = 0;byteNum<4;byteNum++) {
                    for (int bitNum = 7; bitNum >= 0; bitNum--) {
                        if (get(byteNum, bitNum)) sb.append("1");
                        else sb.append("0");
                    }
                }
            }
        }
        return sb.toString();
    }
}
