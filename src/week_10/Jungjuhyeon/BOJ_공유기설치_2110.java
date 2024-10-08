package week_10.Jungjuhyeon;

import java.util.*;
import java.io.*;

public class BOJ_공유기설치_2110 {
    static int[] house;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int min = 1; // 최소 거리가 가질 수 있는 최솟값
        int max = house[N - 1] - house[0] ;	// 최소 거리가 가질 수 있는 최댓값

        while(min < max) {

            int mid = (min + max) / 2;

            /*
             * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
             * 거리를 좁혀야 하기 때문에 hi 를 줄인다.
             */
            if(canInstall(mid) < M) {
                max = mid;
            }
            else {
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
                 * 찾아낸다.
                 */
                min = mid + 1;
            }
        }

        System.out.println(max - 1);
    }
    // distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    public static int canInstall(int distance) {

        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = house[0];

        for(int i = 1; i < house.length; i++) {
            int locate = house[i];

            /*
             *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
             *  최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
             *  마지막 설치 위치를 갱신해준다.
             */
            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }

}


