package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 🧩 오늘의 문제: 문자열 내 마음대로 정렬하기
 * 패키지명: week3
 * 클래스명: CustomSort
 * 문제
 * 문자열로 구성된 배열 strings와 정수 n이 주어질 때,
 * 각 문자열의 n번째 글자를 기준으로 오름차순 정렬하세요.
 * n번째 글자가 같은 경우 사전순으로 정렬합니다.
 * java// 입출력 예시
 * strings = ["sun", "bed", "car"], n = 1
 * → ["car", "bed", "sun"]   // a, e, u 순
 * <p>
 * strings = ["abce", "abcd", "cdx"], n = 2
 * → ["abcd", "abce", "cdx"]   // c=c이면 사전순 → abcd < abce
 * 제한 조건
 * <p>
 * strings 길이: 1 ~ 50
 * strings 원소 길이: 1 ~ 100
 * 0 ≤ n < 각 문자열 길이
 */
public class CustomSort {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");
    int n = Integer.parseInt(br.readLine());

    Arrays.sort(strings, (a, b) -> {
      if (a.charAt(n) == b.charAt(n)) {
        return a.compareTo(b);  // 사전순
      }
      return a.charAt(n) - b.charAt(n);  // n번째 글자 기준
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.length; i++) {
      if (i > 0) sb.append(" ");

      sb.append(strings[i]);
    }


    System.out.println(sb);
  }
}
