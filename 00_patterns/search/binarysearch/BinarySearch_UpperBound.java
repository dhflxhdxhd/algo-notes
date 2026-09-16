package basic.search.binarysearch;

import java.util.Arrays;

public class BinarySearch_UpperBound {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 4, 5}; // 정렬되지 않은 배열
        int target = 5;

        Arrays.sort(arr); // 배열 정렬

        System.out.println("정렬된 배열: " + Arrays.toString(arr));
        int result = useUpperBound(arr, target);

        if (result < arr.length) {
            System.out.println("Target보다 큰 첫 번째 위치는 " + result + ", 값: " + arr[result]);
        } else {
            System.out.println("Target보다 큰 값이 없습니다.");
        }
    }

    // 주어진 값보다 큰 첫 번째 인덱스
    public static int useUpperBound(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length; // right를 배열의 크기로 설정

        while(left < right){
            int mid = left + (right - left) / 2;

            if(sortedArr[mid] <= target){
                left = mid + 1; // target보다 큰 값을 찾기 위해 왼쪽 포인터 이동
            }else{
                right = mid;  // target보다 큰 값을 찾기 위해 오른쪽 포인터 이동
            }
        }

        return left; // target보다 큰 첫 번째 인덱스 반환
    }
}