package IO;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleCompressorOutputStream extends OutputStream {
    OutputStream out;

    public SimpleCompressorOutputStream(OutputStream outputStream) {
        out = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
       //write a single byte
        out.write(b);
    }

    public void write(byte[] bytes) throws IOException
    {
        int curr = 0 ;
        int counter = 0 ;
        for (int i=0;i< bytes.length;i++)
        {
            byte b = bytes[i];
            if(i<24)
            {
                write(b);
                continue;
            }
            if(b==curr)
            {
                if(counter ==256)
                {
                    write(255);
                    write(0);
                    counter = 0;
                }
                counter++;
            }
            else
            {
                write(counter);
                counter=1;
                curr = b;
            }

        }
        if(counter!=0)
        {
            write(counter);
        }

    }
}