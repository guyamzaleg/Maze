package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private  int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ExecutorService threadPool;
    public Configurations configurations;


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) throws IOException {
        this.configurations=Configurations.getInstance();
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPool = Executors.newFixedThreadPool(configurations.getThreadPoolSize());
    }

    public void start() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(listeningIntervalMS);
                while (!stop) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        threadPool.execute(() -> handleClient(clientSocket));
                    } catch (SocketTimeoutException e) {
                    }
                }
                serverSocket.close();
                threadPool.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        stop = true;
    }


}
