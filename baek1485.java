import java.io.*;
import java.util.*;

public class baek1485 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            int[] distances = new int[6];
            distances[0] = distanceSquared(ax, ay, bx, by);
            distances[1] = distanceSquared(ax, ay, cx, cy);
            distances[2] = distanceSquared(ax, ay, dx, dy);
            distances[3] = distanceSquared(bx, by, cx, cy);
            distances[4] = distanceSquared(bx, by, dx, dy);
            distances[5] = distanceSquared(cx, cy, dx, dy);

            Arrays.sort(distances);

            if (distances[0] > 0 &&
                    distances[0] == distances[1] &&
                    distances[1] == distances[2] &&
                    distances[2] == distances[3] &&
                    distances[4] == distances[5] &&
                    2 * distances[0] == distances[4]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    private static int distanceSquared(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
}
