package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.*;
import algorithms.search.Solution;

import java.io.*;
import java.util.HashMap;


public class ServerStrategyGenerateMaze implements IServerStrategy {

    Configurations configurations;
    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            configurations = Configurations.getInstance();

            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            int [] maze_date=(int []) fromClient.readObject();

            int rows = maze_date[0];
            int columns = maze_date[1];

            IMazeGenerator mazeGenerator = configurations.getMazeGeneratingAlgorithm();
            Maze maze = mazeGenerator.generate(rows, columns);

            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();

            MyCompressorOutputStream compressor = new MyCompressorOutputStream(byteOutStream);

            compressor.write(maze.toByteArray());
            compressor.flush();
            compressor.close();

            byte[] compressedMaze = byteOutStream.toByteArray();
            toClient.writeObject(compressedMaze);
            toClient.flush();
            fromClient.close();
            toClient.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
