import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXN = 100 + 10;
    public static int MAXV1 = 100 + 10;
    public static int MAXV2 = 100 + 10;
    public static int MAXK = 5 + 10;
    public static int[][][] dp = new int[MAXK][MAXV1][MAXV2];
    public static int[] a = new int[MAXN];
    public static int[] b = new int[MAXN];
    public static int[] val = new int[MAXN];
    public static int n, v1, v2, k;

    /**
     * 多维0/1背包问题
     */
    public static void main(String[] args) {

        while (cin.hasNext()) {
            n  = cin.nextInt();
            v1 = cin.nextInt();
            v2 = cin.nextInt();
            k = cin.nextInt();
            for (int i=0; i<n ;i++) {
                a[i] = cin.nextInt();
                b[i] = cin.nextInt();
                val[i] = cin.nextInt();
            }
            for (int x=0; x<MAXK; x++) {
                for (int y=0; y<MAXV1; y++) {
                    for (int z=0; z<MAXV2; z++) {
                        dp[x][y][z] = 0;
                    }
                }
            }
            for (int i=0; i<n; i++) {
                for (int x=k; x>=0; x--) {
                    for (int y=v1; y>=0; y--) {
                        for (int z=v2; z>=0; z--) {
                            int temp = 0;
                            if (x-1 >= 0) {
                                temp = Math.max(temp, dp[x-1][y][z]+val[i]);
                            }
                            if (y-a[i] >= 0) {
                                temp = Math.max(temp, dp[x][y-a[i]][z]+val[i]);
                            }
                            if (z-b[i] >= 0) {
                                temp = Math.max(temp, dp[x][y][z-b[i]]+val[i]);
                            }
                            dp[x][y][z] = Math.max(temp, dp[x][y][z]);
                        }
                    }
                }
            }
            out.println(dp[k][v1][v2]);
        }
        out.close();
    }
}

class FastScanner {

    public BufferedReader br;
    public StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScanner(String name) {
        try {
            br = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}