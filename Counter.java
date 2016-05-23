/**
 * @author Stephen Nielson
 * @author Keith Higbee
 * @author 
*/
public class Counter implements Runnable{
  
  private Thread counter;
  private CountObj countValue = null;
  
  public Counter(CountObj countValue) {
    this.countValue = countValue;
  }
  
  public void start() {
    counter = new Thread(this);
    counter.start();
  }

  public void stop() {
    counter = null;
  }

  public void run() {
    Thread currentThread = Thread.currentThread();
    while(counter == currentThread && countValue.getValue() <= 100) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
      }
      countValue.printAndIncrement();
    }
  }
}
