package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class MyCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }
    @Override
    public void write(int b) throws IOException {
        this.out.write(b);
    }

    //first solution
    // 24 bytes for the maze details
    //insert the 1's indexes into the stream
    //creating a stream of 1's indexes representing the maze
//    public void write(byte[] bytes) throws IOException
//    {
//        int count_for_256 = 0;
//        for (int i=0;i< bytes.length;i++)
//        {
//            count_for_256 = i/256;
//            byte b = bytes[i];
//            if(i<24)
//            {
//                write(b);
//                continue;
//            }
//            //if the byte is 1, insert its index into the stream
//            if(b==1)
//            {
//                write(i-count_for_256*256);
//            }
//
//        }
//
//    }

    //second solution
    // 24 bytes for the maze details
    //because the maze is binary we can compress every 8 cells to 1 byte
    // each bit inside the byte is 0/1-as it appears in the maze


public void write(byte[] bytes) throws IOException
    {
        int count_for_8_rounds = 0;
        byte[] arr = new byte[8];
        for (int i=0;i< bytes.length;i++)
        {
            byte b = bytes[i];
            if (i < 24) {
                write(b);
                continue;
            }
            if(count_for_8_rounds<7)
            {
                arr[count_for_8_rounds] = b;
            }
            if(count_for_8_rounds==7)
            {
                arr[count_for_8_rounds] = b;
                write(binary_byte_array_to_int_repr(arr));
                count_for_8_rounds = -1;
            }
            count_for_8_rounds++;
        }
        if(count_for_8_rounds!=0)
        {
            //the last eight elements are not full
            for (int i = count_for_8_rounds; i < 8; i++)
            {
                arr[i] = 0;
            }
            write(binary_byte_array_to_int_repr(arr));
        }


}

    private int binary_byte_array_to_int_repr(byte[] arr)
    {
        int result = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // Get the current digit
            int digit = arr[i];

            // Calculate the power of 2 for the current digit
            int power = arr.length - i - 1;

            // Calculate the decimal value of the current digit
            int decimalValue = digit * (int) Math.pow(2, power);

            // Add the decimal value to the total decimal number
            result += decimalValue;
        }
        return result;
    }
    }
