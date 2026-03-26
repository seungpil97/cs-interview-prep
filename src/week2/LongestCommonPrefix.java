package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 배열이 주어졌을 때 모든 문자열의 공통 접두사(prefix) 를 반환하세요.
 * 없으면 "" 반환.
 * 입력: String[] strs
 * 출력: String
 * 예시
 * ["flower", "flow", "flight"] → "fl"
 * ["dog", "racecar", "car"]   → ""
 * ["ab", "a"]                 → "a"
 * ["a"]                       → "a"
 */
public class LongestCommonPrefix {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] strs = br.readLine().split(" ");

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {

      while (!strs[i].startsWith(prefix)) {

        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) break;
      }
    }
    System.out.println(prefix);
  }
}
