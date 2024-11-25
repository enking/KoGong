/*
* 문제
N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다. 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

입력
첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.

출력
첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.*/

import java.io.*;
import java.util.*;

public class baek2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 수열의 길이
        int M = Integer.parseInt(input[1]); // 최소 차이

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 수열 정렬
        Arrays.sort(A);

        // 투 포인터 변수 초기화
        int start = 0;
        int end = 0;
        int minDiff = Integer.MAX_VALUE;

        // 투 포인터 탐색
        while (end < N) {
            int diff = A[end] - A[start];

            if (diff >= M) { // 조건을 만족하면 최소값 갱신
                minDiff = Math.min(minDiff, diff);
                start++; // start를 증가시켜 더 작은 차이를 탐색
            } else {
                end++; // 조건을 만족하지 않으면 end를 증가
            }
        }

        // 결과 출력
        System.out.println(minDiff);
    }
}

