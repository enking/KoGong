/*문제
정수로 이루어진 크기가 같은 배열 A, B, C, D가 있다.

A[a], B[b], C[c], D[d]의 합이 0인 (a, b, c, d) 쌍의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 배열의 크기 n (1 ≤ n ≤ 4000)이 주어진다. 다음 n개 줄에는 A, B, C, D에 포함되는 정수가 공백으로 구분되어져서 주어진다. 배열에 들어있는 정수의 절댓값은 최대 228이다.

출력
합이 0이 되는 쌍의 개수를 출력한다.

n^4 아니라 2개씩 묶어서 절댓값이 같으면 그 조합으로 밀고 간다 이거네
2의 28제곱 즉 범위는 int로 출력해도 됨*/

import java.io.*;
import java.util.*;

public class baek7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 두 배열씩 묶어서 합 계산
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        int idx = 0;

        // A + B 계산
        for (int a : A) {
            for (int b : B) {
                AB[idx++] = a + b;
            }
        }

        idx = 0; // 인덱스 초기화

        // C + D 계산
        for (int c : C) {
            for (int d : D) {
                CD[idx++] = c + d;
            }
        }

        // AB와 CD 정렬
        Arrays.sort(AB);
        Arrays.sort(CD);

        // 투 포인터를 이용하여 합이 0이 되는 경우 찾기
        int left = 0;
        int right = CD.length - 1;
        long count = 0;

        while (left < AB.length && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                long leftCount = 1;
                long rightCount = 1;

                // AB에서 동일한 값의 빈도 계산
                while (left + 1 < AB.length && AB[left] == AB[left + 1]) {
                    left++;
                    leftCount++;
                }

                // CD에서 동일한 값의 빈도 계산
                while (right - 1 >= 0 && CD[right] == CD[right - 1]) {
                    right--;
                    rightCount++;
                }

                // 조합의 개수 추가
                count += leftCount * rightCount;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
