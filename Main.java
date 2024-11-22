import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) { // 입력은 여러 개의 테스트 케이스로 이루어져 있다. (개빡치네)
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            int[] nArr = new int[n]; // 상근이가 가진 CD 배열
            int[] mArr = new int[m]; // 선영이가 가진 CD 배열

            for(int i = 0; i < n; i++) {
                nArr[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i < m; i++) {
                mArr[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            int i = 0;
            int j = 0;

            while (i != n &&  j != m) {
                if(nArr[i] == mArr[j]) {
                    i++;
                    j++;
                    count++;
                } else if(nArr[i] > mArr[j]) {
                    j++;
                } else {
                    i++;
                }
            }
            System.out.println(count);
        }
    }
}