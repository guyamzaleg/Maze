
package IO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream in;


    public SimpleDecompressorInputStream(InputStream input) {
        this.in = input;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    public int read(byte[] bytes) throws IOException {
        if (bytes.length == 0)
            return -1;

        // Read the first 24 bytes as is
        // The first 24 bytes are the maze details
        for (int i = 0; i < 24; i++) {
            int input = read();
            bytes[i] = (byte) input;
        }

        int curr_val = 0;
        int how_many = read();
        int index = 24;
        // Decompress the maze cells
        while(index<bytes.length)
        {
            for(int i =0; i<how_many;i++){
                bytes[index++] = (byte)curr_val;
            }
            curr_val = 1-curr_val;
            how_many = read();
        }

        return 1;
    }


    public void close() throws IOException {
        in.close();
    }
}
