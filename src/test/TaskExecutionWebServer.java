package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.SortedMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ly
 * @date 2019/6/26 10:37
 */
public class TaskExecutionWebServer {
    private static final int count = 10;
    private static final ExecutorService exec1 = Executors.newFixedThreadPool(count);
    private static final ExecutorService exec2 = Executors.newCachedThreadPool();
    private static final ExecutorService exec3 = Executors.newSingleThreadExecutor();


    private static final ScheduledExecutorService exec4 = Executors.newScheduledThreadPool(count);
    private static final ScheduledExecutorService exec5 = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            final Socket con = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
//                    handleRequest(con);
                }
            };
            exec1.execute(task);
        }

    }


}
