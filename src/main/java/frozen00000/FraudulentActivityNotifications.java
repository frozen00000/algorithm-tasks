package frozen00000;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
public class FraudulentActivityNotifications {

    private static long getMedianX2(int[] freq, int d) {
        int[] localFreq = new int[freq.length];
        localFreq[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            localFreq[i] = localFreq[i - 1] + freq[i];
        }
        if (d % 2 == 0) {
            int i1 = 0;
            int i2 = 0;
            int a = d / 2;
            int b = a + 1;
            int i = 0;
            for (; i < freq.length; i++) {
                if (a <= localFreq[i]) {
                    i1 = i;
                    break;
                }
            }
            for (; i < freq.length; i++) {
                if (b <= localFreq[i]) {
                    i2 = i;
                    break;
                }
            }
            return (i1 + i2);
        } else {
            int a = d / 2 + 1;
            for (int i = 0; i < freq.length; i++) {
                if (a <= localFreq[i]) {
                    return i * 2;
                }
            }
        }
        throw new RuntimeException();
    }

    // Complete the activityNotifications function below.
    private static int activityNotifications(int[] expenditure, int d) {
        int[] freq = new int[201];
        int noticeCounter = 0;
        for (int i = 0; i < d; i++) {
            freq[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            double m = getMedianX2(freq, d);
            if (expenditure[i] >= m) {
                noticeCounter++;
            }
            freq[expenditure[i]]++;
            freq[expenditure[i - d]]--;
        }
        return noticeCounter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int expenditure[] = new int[n];
        for (int i = 0; i < n; i++) {
            expenditure[i] = scanner.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        scanner.close();
    }
}
