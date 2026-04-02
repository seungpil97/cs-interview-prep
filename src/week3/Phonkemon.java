package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p>
 * 🟡 문제: 폰켓몬 (Phonket Monster)
 * 패키지: src/week3
 * 클래스명: Phonkemon
 * <p>
 * 문제 설명
 * 당신은 폰켓몬 N/2마리를 선택해야 합니다.
 * <p>
 * nums 배열에는 폰켓몬의 종류 번호가 담겨 있습니다
 * 배열 길이는 항상 짝수 (N)
 * N/2마리를 선택할 때, 최대한 다양한 종류를 선택하고 싶습니다
 * 선택할 수 있는 폰켓몬 종류의 최댓값을 반환하세요
 * <p>
 * 예시
 * nums결과
 * [3, 1, 2, 3] 2
 * [3, 3, 3, 2, 2, 4] 3
 * [3, 3, 3, 2, 2, 2] 2
 * <p>
 * 제약 조건
 * <p>
 * nums의 길이: 2 이상 10,000 이하
 * 폰켓몬 종류 번호: 1 이상 200,000 이하
 */
public class Phonkemon {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Set<Integer> set = new HashSet<>();
    int count = 0;

    while (st.hasMoreTokens()) {
      set.add(Integer.parseInt(st.nextToken()));
      count++;
    }

    System.out.println(Math.min(count / 2, set.size()));
  }
}
