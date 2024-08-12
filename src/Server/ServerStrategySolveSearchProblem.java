package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServerStrategySolveSearchProblem implements IServerStrategy {
    Configurations configurations;
    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {
            configurations = Configurations.getInstance();
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            Maze maze = (Maze) fromClient.readObject();
            String mazeHash = generateHash(maze.toByteArray());//  change the hash function to something else
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            Path solutionFilePath = Paths.get(tempDirectoryPath, mazeHash);
            System.out.println(solutionFilePath);
            Solution solution;
            System.out.println(mazeHash);
            if (Files.exists(solutionFilePath)) {
                System.out.println("Solution file already exists");
                try (ObjectInputStream solutionReader = new ObjectInputStream(new FileInputStream(solutionFilePath.toFile()))) {
                    solution = (Solution) solutionReader.readObject();
                }
            } else {
                SearchableMaze searchableMaze = new SearchableMaze(maze);
                ISearchingAlgorithm searcher = configurations.getMazeSearchingAlgorithm();
                solution = searcher.solve(searchableMaze);

                try (ObjectOutputStream solutionWriter = new ObjectOutputStream(new FileOutputStream(solutionFilePath.toFile()))) {
                    solutionWriter.writeObject(solution);
                }
            }

            toClient.writeObject(solution);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String generateHash(byte[] mazeBytes) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(mazeBytes);

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}