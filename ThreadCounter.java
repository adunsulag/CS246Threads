public class ThreadCounter {

  private int counters = 0;

  public void increment() {
    counters += 1;
  }

  public synchronized void decrementAndCheckCompletion() {
    counters -= 1;
    if (counters <= 0) {
      System.out.println("All Finished!");
    }
  }
}
