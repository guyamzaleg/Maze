package IO;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class MyDecompressorInputStream extends InputStream
{
    InputStream in;
    public MyDecompressorInputStream(InputStream input) {
        this.in = input;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

//    public int read(byte[] bytes) throws IOException
//    {
//        if (bytes.length == 0)
//            return -1;
//
//        int i = 0;
//        // Read the first 24 bytes as is
//        // The first 24 bytes are the maze details
//        for (; i < 24; i++) {
//            bytes[i] = (byte) read();
//        }
//
//        // Decompress the maze cells
//        int next_1=read();
//        int count_for_256 = 0;
//        for(;i<bytes.length;i++)
//        {
//            //updating the count_for_256
//            //if the byte is 1, insert its index into the stream
//            count_for_256 = i/256;
//            bytes[i] = (byte) 1;
//
//            //if the current index is the next 1 index-calculated in a circles of 256
//            //update the next 1 index and set the byte to 1
//            if(i==next_1+count_for_256*256)
//            {
//                bytes[i] = (byte)(1);
//                next_1=read();
//            }
//            //the next byte is 0
//            else
//            {
//                bytes[i] = (byte)(0);
//            }
//        }
//    return 1;
//    }
public int read(byte[] bytes) throws IOException {
    if (bytes.length == 0)
        return -1;

    int i = 0;
    int count_for_8 = 0;
    // Read the first 24 bytes as is
    // The first 24 bytes are the maze details
    for (; i < 24; i++) {
        bytes[i] = (byte) read();
    }
    while(in.available() > 0)
    {
        int num = read();
        byte[] arr = num_to_byte_repr(num);
        for (byte b : arr) {
            if(i >= bytes.length)
                break;
            bytes[i] = b;
            i++;
        }
    }
    return 1;
    }

    private byte[] num_to_byte_repr(int num)
    {
        byte[] arr = new byte[8];
        for (int i = 7; i >= 0; i--)
        {
            arr[i] = (byte)(num%2);
            num /= 2;
        }
//        for (byte b : arr) {
//            System.out.print(b);
//        }
//        System.out.println();

        return arr;
    }
}
