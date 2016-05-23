public class CS246Threading
{
  public static void main(String[] args) {
     ThreadCounter threadCounter = new ThreadCounter();
     Counter counterOdd = new Counter(true, threadCounter);
     Counter counterEven = new Counter(false, threadCounter);
     counterOdd.start();
     counterEven.start();
  }
}
