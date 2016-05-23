/**
 * Prints out to 100 and displays a running status.
 * @author Stephen Nielson
 * @author Keith Higbee
 * @author John Okleberry
*/
public class CS246Threading {
  /** 
   * Prints out to 100 and displays a running status.
   * @param args Console args.. shouldn't be any
   */
  public static void main(String[] args) {
    ThreadCounter threadCounter = new ThreadCounter();
    Counter counterOdd = new Counter(true, threadCounter);
    Counter counterEven = new Counter(false, threadCounter);
    counterOdd.start();
    counterEven.start();
    threadCounter.start();
  }
}
