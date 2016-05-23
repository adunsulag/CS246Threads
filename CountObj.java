public class CountObj
{
  private int value = 1;

  public CountObj() {
  }

  public synchronized void printAndIncrement() {
    System.out.println(value);
    value += 1;
  }

  public int getValue() {
    return value;
  }
}
