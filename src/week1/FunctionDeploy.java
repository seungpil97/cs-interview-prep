package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 각 기능의 현재 진도와 하루 작업량이 주어질 때,
 * 각 배포마다 몇 개의 기능이 배포되는지 구하세요.
 * <p>
 * 앞의 기능이 완료되지 않으면 뒤의 기능도 배포 불가
 * <p>
 * 입력: int[] progresses, int[] speeds
 * 출력: int[]
 * <p>
 * 예시)
 * progresses = [93, 30, 55]
 * speeds     = [1,  30, 5]
 * 결과       = [2, 1]
 * <p>
 * 설명)
 * 93 → 7일 후 완료 (100-93 / 1 = 7)
 * 30 → 3일 후 완료 (100-30 / 30 = 3) → 7일차에 같이 배포
 * 55 → 9일 후 완료 (100-55 / 5 = 9) → 단독 배포
 * → 7일차에 2개, 9일차에 1개
 */
public class FunctionDeploy {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] progresses = br.readLine().split(" ");
    String[] speeds = br.readLine().split(" ");

    int[] days = new int[progresses.length];

    for (int i = 0; i < progresses.length; i++) {

      int progress = Integer.parseInt(progresses[i]);
      int speed = Integer.parseInt(speeds[i]);

      days[i] = (100 - progress + speed - 1) / speed;
    }

    int maxDay = days[0];  // 현재 배포 기준일
    int count = 0;

    List<Integer> results = new ArrayList<>();

    for (int day : days) {
      if (day <= maxDay) {
        count++;  // 같이 배포
      } else {
        // 새 배포 시작
        results.add(count);
        maxDay = day;
        count = 1;
      }
    }
    results.add(count);  // 마지막 배포

    for (int i = 0; i < results.size(); i++) {

      System.out.print(results.get(i));

      if (i < results.size() - 1) {
        System.out.println(", ");
      }
    }
  }
}
