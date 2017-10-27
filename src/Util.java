public class Util {

  private Util() {
    throw new IllegalArgumentException();
  }

  /**
   * 数组元素交换，索引相同不采取操作
   */
  public static void exchange(int[] data, int pre, int aft) {
    if (pre == aft) {
      return;
    }
    int temp = data[pre];
    data[pre] = data[aft];
    data[aft] = temp;
  }

  /**
   * 获取数组元素最高位数
   */
  public static int getHigh(int[] data) {
    int high = 0;
    for (int d : data) {
      while (d / Math.pow(10, high) > 0) {
        high++;
      }
    }
    return high;
  }
}
