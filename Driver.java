

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 *
 * 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Kerly Titus
 */
public class Driver {

    /**
     * main class
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            PrintStream output = new PrintStream(new File("Server1-2-3.txt"));
            System.setOut(output);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found");
            System.exit(0);
        } 

        Network objNetwork = new Network();            /* Activate the network */
        objNetwork.start();

        /*..............................................................................................................................................................*/

        Server server1 = new Server("thread1"); 
        Server server2 = new Server("thread2");          
        Server server3 = new Server("thread3");          

        server1.start();
        server2.start();
        server3.start();

        Client client1 = new Client("sending");          /* Start the sending client thread */
        client1.start();
        Client client2 = new Client("receiving");        /* Start the receiving client thread */
        client2.start();
    }

}

 //phase 1
 /*
  * We concluded that in a multi-threaded context, using synchronized blocks 
  is more efficient than employing synchronized methods. This efficiency stems 
  from the limitation that, when a synchronized method is executing, it prevents 
  other methods from being called. Through the application of synchronized blocks,
   we are able to achieve consistent outcomes and dependable management of accounts, 
   enhancing both output reliability and system performance.
  */
  
/* PHASE 2 
 * During busy-waiting, considerable time was wasted due to CPU cycles
 * being consumed in waiting. However, by implementing synchronization 
 * or using semaphores, we were able to optimize time usage, 
 * thereby reducing the amount of time lost to CPU inefficiency.
 */

/*
 * With multiple parallel threads in use, we distribute and execute the tasks 
 * across the several cores. This approach speeds up the system's overall performance, making it run faster.
 */