public class CS246Threading
{
  public static void main(String[] args) {
     CountObj obj = new CountObj();
     Counter counterOdd = new Counter(obj);
     Counter counterEven = new Counter(obj);
     counterEven.start();
     counterOdd.start();
  }
}
