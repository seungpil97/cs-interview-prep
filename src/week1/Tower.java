package week1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 수평 직선에 탑들이 세워져 있습니다.
 * 각 탑에서 레이저를 왼쪽으로 쏠 때,
 * 처음으로 레이저를 수신하는 탑의 인덱스를 구하세요.
 * (자신보다 높은 탑이 레이저를 수신)
 * 수신하는 탑이 없으면 0
 * <p>
 * 입력: int[] heights
 * 출력: int[]
 * <p>
 * 예시)
 * heights = [6, 9, 5, 7, 4]
 * 결과    = [0, 0, 2, 2, 4]
 * <p>
 * 설명)
 * heights[0]=6 → 왼쪽 탑 없음 → 0
 * heights[1]=9 → 왼쪽 탑 없음 (9가 제일 높음) → 0
 * heights[2]=5 → 왼쪽에서 처음으로 높은 탑 = index 2 (heights[1]=9) → 2
 * heights[3]=7 → 왼쪽에서 처음으로 높은 탑 = index 2 (heights[1]=9) → 2
 * heights[4]=4 → 왼쪽에서 처음으로 높은 탑 = index 4 (heights[3]=7) → 4
 */
public class Tower {

  public static int[] solution(int[] heights) {

    int[] result = new int[heights.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < heights.length; i++) {

      while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        result[i] = 0;
      } else {
        result[i] = stack.peek() + 1;
      }

      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {

    int[] heights = {6, 9, 5, 7, 4};
    int[] result = solution(heights);

    for (int r : result) {
      System.out.print(r + " ");
    }
  }
}
