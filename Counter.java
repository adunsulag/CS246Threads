/**
 * @author Stephen Nielson
 * @author Keith Higbee
 * @author 
*/
public class Counter implements Runnable{
  
  private Thread counter;
  private boolean isOdd;
  private ThreadCounter threadCounter;
  
  public Counter(boolean isOdd, ThreadCounter threadCounter) {
    this.isOdd = isOdd;
    this.threadCounter = threadCounter;
    threadCounter.increment();
  }
  
  public void start() {
    counter = new Thread(this);
    counter.start();
  }

  public void stop() {
    counter = null;
  }

  private void sleepAndPrint(int i) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
        System.out.println(i);
  }
  public void run() {

    Thread currentThread = Thread.currentThread();
    if (this.isOdd) {
      for (int o = 1; counter == currentThread && o <= 100; o+= 2) {
        sleepAndPrint(o);
      }
    } else {
      for (int e = 2; counter == currentThread && e <= 100; e+= 2) {
        sleepAndPrint(e);
      }
    }

    threadCounter.decrementAndCheckCompletion();
  }
}
