import java.util.*;

public class baek7795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt(); // A 배열 크기
            int m = sc.nextInt(); // B 배열 크기

            int[] nArr = new int[n];
            int[] mArr = new int[m];

            // A 배열 입력
            for (int i = 0; i < n; i++) {
                nArr[i] = sc.nextInt();
            }

            // B 배열 입력
            for (int i = 0; i < m; i++) {
                mArr[i] = sc.nextInt();
            }

            // B 배열 정렬
            Arrays.sort(mArr);

            int ans = 0;

            // A 배열의 각 값에 대해 B 배열 탐색
            for (int a : nArr) {
                int left = 0, right = m - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (mArr[mid] < a) {
                        left = mid + 1; // a보다 작은 값이므로 오른쪽 탐색
                    } else {
                        right = mid - 1; // a 이상이므로 왼쪽 탐색
                    }
                }

                ans += left; // left는 a보다 작은 값의 개수
            }

            System.out.println(ans); // 결과 출력
        }
        sc.close();
    }
}
