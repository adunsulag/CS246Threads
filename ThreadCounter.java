/**
 * Keeps track of and displays the status of all running counter threads.
 * @author Stephen Nielson
 * @author Keith Higbee
 * @author John Okleberry
*/
public class ThreadCounter implements Runnable {

  private Thread threadCounter;
  private int counters = 0;

  /** Start the counter thread. **/
  public void start() {
    threadCounter = new Thread(this);
    threadCounter.start();
  }

  /** Increment the number of thread counters there are. **/
  public void increment() {
    counters += 1;
  }

  /** Stop the current thread. **/
  public void stop() {
    threadCounter = null;
  }

  /** Display the current status of all the running threads. **/
  public void run() {
    Thread currentThread = Thread.currentThread();
    while (threadCounter == currentThread) {
      try {
        System.out.println("Running...");
        Thread.sleep(1000);
      } catch (InterruptedException ex) { 
        ex.printStackTrace();
      }
    }
  }

  /** Removes a counter thread count and displays all 
   *  finished if there are no more counters. **/
  public synchronized void decrementAndCheckCompletion() {
    counters -= 1;
    if (counters <= 0) {
      System.out.println("All Finished!");
      stop();
    }
  }
}
