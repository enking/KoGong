import java.io.*;
import java.util.*;

public class Baek20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] H = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(H);

        int minDiff = Integer.MAX_VALUE;

        // 두 눈덩이 조합 선택
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int firstSnowman = H[i] + H[j]; // 첫 번째 눈사람의 키

                // 두 번째 눈사람 만들기 (투 포인터)
                int left = 0;
                int right = N - 1;

                while (left < right) {
                    if (left == i || left == j) {
                        left++; // 이미 사용된 눈덩이는 건너뛰기
                        continue;
                    }
                    if (right == i || right == j) {
                        right--; // 이미 사용된 눈덩이는 건너뛰기
                        continue;
                    }

                    int secondSnowman = H[left] + H[right];
                    int diff = Math.abs(firstSnowman - secondSnowman);

                    minDiff = Math.min(minDiff, diff); // 최소 차이 갱신

                    // 투 포인터 이동
                    if (secondSnowman < firstSnowman) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(minDiff);
    }
}
