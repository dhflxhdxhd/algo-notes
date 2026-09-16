package basic.search.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 4, 5}; // 정렬되지 않은 배열
        int target = 5;

        Arrays.sort(arr); // 배열 정렬

        System.out.println("정렬된 배열: " + Arrays.toString(arr));
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("target의 위치는 " + result);
        } else {
            System.out.println("target을 배열에서 찾을 수 없습니다.");
        }
    }

    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0; // 왼쪽 인덱스
        int right = sortedArr.length - 1; // 오른쪽 인덱스
        int result = -1; // 초기값 -1 (찾지 못한 경우)
        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간값 구하기
            System.out.println("중간값 : "+mid );
            // target 값의 위치를 구했다면 반환
            if (sortedArr[mid] == target) {
//                return mid;
                result = mid;
                right = mid - 1;
            }else if (sortedArr[mid] > target) {
                // target 값이 중간값보다 작으면 왼쪽 절반 탐색
                right = mid - 1;
            } else {
                // target 값이 중간값보다 크면 오른쪽 절반 탐색
                left = mid + 1;
            }
        }
        return result; // 값을 찾지 못했으면 -1 반환
    }
}
