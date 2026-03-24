package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 정수 배열에서 두 수를 더해 target이 되는
 * 두 수의 인덱스를 반환하세요.
 * <p>
 * 입력: int[] nums, int target
 * 출력: int[]
 * <p>
 * 예시)
 * nums = [2, 7, 11, 15], target = 9
 * 결과 = [0, 1]
 * <p>
 * 설명)
 * nums[0] + nums[1] = 2 + 7 = 9
 */
public class TwoSum {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int target = Integer.parseInt(br.readLine());
    int[] nums = new int[input.length];

    for (int i = 0; i < input.length; i++) {

      nums[i] = Integer.parseInt(input[i]);

    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {

      int result;

      for (int j = i + 1; j < nums.length; j++) {

        result = nums[i] + nums[j];

        if (result == target) {
          sb.append(i)
            .append(", ")
            .append(j);
          break;
        }
      }
    }

    System.out.println(sb);
  }
}