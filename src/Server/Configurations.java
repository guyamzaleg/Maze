package Server;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BestFirstSearch;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Configurations
{
    private static int threadPoolSize;
    private  ASearchingAlgorithm mazeSearchingAlgorithm;
    private  AMazeGenerator mazeGeneratingAlgorithm;
    private static Configurations instance = null;

    private Configurations() throws IOException
    {
        Properties prop = new Properties();
        prop.load(getClass().getResourceAsStream("/config.properties"));

        int poolSize = Integer.parseInt(prop.getProperty("threadPoolSize"));
        String searchingAlg = prop.getProperty("mazeSearchingAlgorithm");
        String generAlg = prop.getProperty("mazeGeneratingAlgorithm");

        if (poolSize > 0)
            threadPoolSize = poolSize;
        else
            throw new InvalidPropertiesFormatException("Invalid thread pool size specified in config.properties");

        switch(searchingAlg)
        {
            case "BestFirstSearch":
                mazeSearchingAlgorithm = new BestFirstSearch();
                break;
            case "DepthFirstSearch":
                mazeSearchingAlgorithm = new DepthFirstSearch();
                break;
            case "BreadthFirstSearch":
                mazeSearchingAlgorithm = new BreadthFirstSearch();
                break;
            default:
                throw new InvalidPropertiesFormatException("Invalid maze searching algorithm specified in config.properties");
        }

        switch(generAlg)
        {
            case "MyMazeGenerator":
                mazeGeneratingAlgorithm = new MyMazeGenerator();
                break;
            case "EmptyMazeGenerator":
                mazeGeneratingAlgorithm = new EmptyMazeGenerator();
                break;
            case "SimpleMazeGenerator":
                mazeGeneratingAlgorithm = new SimpleMazeGenerator();
                break;
            default:
                throw new InvalidPropertiesFormatException("Invalid maze generating algorithm specified in config.properties");
        }


    }

    public static Configurations getInstance() throws IOException {
        if (instance == null)
            instance = new Configurations();
        return instance;
    }
    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public ASearchingAlgorithm getMazeSearchingAlgorithm() {
        return mazeSearchingAlgorithm;
    }

    public AMazeGenerator getMazeGeneratingAlgorithm() {
        return mazeGeneratingAlgorithm;
    }

}
