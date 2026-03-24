package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
public class TwoSumHashMap {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int target = Integer.parseInt(br.readLine());
    int[] nums = new int[input.length];

    for (int i = 0; i < input.length; i++) {

      nums[i] = Integer.parseInt(input[i]);

    }

    Map<Integer, Integer> hashMap = new HashMap<>();


    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (hashMap.containsKey(complement)) {
        // 짝꿍이 map에 있으면 → 정답
        System.out.println(hashMap.get(complement) + ", " + i);
        return;
      }

      hashMap.put(nums[i], i);  // 없으면 map에 저장

    }
  }
}