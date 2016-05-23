/**
 * Counter counts to 100 by odd or even numbers.
 * @author Stephen Nielson
 * @author Keith Higbee
 * @author John Okleberry
*/
public class Counter implements Runnable {
  
  private Thread counter;
  private boolean isOdd;
  private ThreadCounter threadCounter;
  
  /** Instantiate a counter that is odd or even. 
   * @param isOdd Whether the counter should count odd or even numbers
   * @param threadCounter tracks the number of current threads that are counting.
   */
  public Counter(boolean isOdd, ThreadCounter threadCounter) {
    this.isOdd = isOdd;
    this.threadCounter = threadCounter;
    threadCounter.increment();
  }
  
  /** Start the counter thread. **/
  public void start() {
    counter = new Thread(this);
    counter.start();
  }

  /** Stop the current thread. **/
  public void stop() {
    counter = null;
  }

  /**
   * Counts up to one hundred by odds or evens depending on if 
   * the counter is an odd or even counter.
   */
  public void run() {

    Thread currentThread = Thread.currentThread();
    if (this.isOdd) {
      for (int o = 1; counter == currentThread && o <= 100; o += 2) {
        sleepAndPrint(o);
      }
    } else {
      for (int e = 2; counter == currentThread && e <= 100; e += 2) {
        sleepAndPrint(e);
      }
    }

    threadCounter.decrementAndCheckCompletion();
  }

  /** Sleeps the current thread and prints out the passed in value. 
   * @param number The number to print out. 
  **/
  private void sleepAndPrint(int number) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println(number);
  }
}
