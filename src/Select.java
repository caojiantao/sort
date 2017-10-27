import java.util.Arrays;

/**
 * 选择排序
 */
public class Select {

  public static void main(String[] args) {
    int[] data = {4, 1, 1, 3, 2, 5};
    System.out.println(Arrays.toString(sortBySelect(data)));
  }

  private static int[] sortBySelect(int[] data) {
    int min, minIndex;
    for (int i = 0; i < data.length; i++){
      min = data[i];
      minIndex = i;
      for (int j = i; j < data.length; j++){
        if (data[j] < min){
          min = data[j];
          minIndex = j;
        }
      }
      Util.exchange(data, i, minIndex);
    }
    return data;
  }
}
