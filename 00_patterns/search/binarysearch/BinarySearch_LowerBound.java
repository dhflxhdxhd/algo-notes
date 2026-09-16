package basic.search.binarysearch;

import java.util.Arrays;

public class BinarySearch_LowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 4, 5}; // 정렬되지 않은 배열
        int target = 5;

        Arrays.sort(arr); // 배열 정렬

        System.out.println("정렬된 배열: " + Arrays.toString(arr));
        int result = uselowerBound(arr, target);

        if (result != -1) {
            System.out.println("target의 위치는 " + result);
        } else {
            System.out.println("target을 배열에서 찾을 수 없습니다.");
        }
    }

    // target 값보다 크거나 같은 첫 번째 인덱스
    public static int uselowerBound(int[]  sortedArr, int target){
        int left = 0; // 왼쪽 인덱스
        int right = sortedArr.length; // 오른쪽 인덱스

        while (left < right) {
            int mid = left + (right - left) / 2; // 중간값 구하기

            if(sortedArr[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left; // 값을 찾지 못했으면 -1 반환
    }
}
