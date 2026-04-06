package week4;

public class TargetNumber {
  int count = 0;

  public int solution(int[] numbers, int target) {
    dfs(numbers, target, 0, 0);
    return count;
  }

  void dfs(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
      if (sum == target) {
        count++;
      }
      return;
    }
    dfs(numbers, target, index + 1, sum + numbers[index]);
    dfs(numbers, target, index + 1, sum - numbers[index]);
  }

  public static void main(String[] args) {
    TargetNumber t = new TargetNumber();

    // 테스트 1: 정답 5
    int[] numbers1 = {1, 1, 1, 1, 1};
    System.out.println(t.solution(numbers1, 3)); // 5

    // 테스트 2: 정답 2
    TargetNumber t2 = new TargetNumber();
    int[] numbers2 = {4, 1, 2, 1};
    System.out.println(t2.solution(numbers2, 4)); // 2
  }
}