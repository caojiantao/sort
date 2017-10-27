import java.util.Arrays;

public class Merge {

  public static void main(String[] args) {
    int[] data = {4, 1, 10, 3, 2, 5, 7, 11};
    System.out.println(Arrays.toString(sortBySelect(data)));
  }

  private static int[] sortBySelect(int[] data) {
    for (int gap = 1; gap <= data.length; gap *= 2) {
      // 归并后多少组
      int count = data.length / gap;
      for (int loop = 0; loop < count; loop++) {
        // 临时归并数组
        int[] temp = new int[gap];
        int start = loop * gap;
        int i = start, j = i + gap / 2, k = 0;
        while (i < start + gap / 2 && j < start + gap) {
          if (data[i] < data[j]) {
            temp[k++] = data[i++];
          } else {
            temp[k++] = data[j++];
          }
        }
        // 左表未扫描完
        while (i < start + gap / 2) {
          temp[k++] = data[i++];
        }
        // 右表未扫描完
        while (j < start + gap) {
          temp[k++] = data[j++];
        }
        // 将归并后的数组回写到原始数组中
        System.arraycopy(temp, 0, data, loop * gap, temp.length);
      }
      System.out.println(Arrays.toString(data));
    }
    return data;
  }
}