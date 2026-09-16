/*
FISH_INFO 잡은 물고기들의 정보
ID, FISH_TYPE, LENGTH, TIME
잡은 물고기의 길이가 10cm 이하일 경우에는 LENGTH 가 NULL
LENGTH 에 NULL 만 있는 경우는 없음

[OUTPUT]
잡은 물고기의 평균 길이를 출력
평균 길이는 소수점 3째자리에서 반올림하며, 10cm 이하의 물고기들은 10cm 로 취급하여 평균 길이 구함
*/

SELECT ROUND(AVG(IFNULL(LENGTH, 10)), 2) AS AVERAGE_LENGTH
FROM FISH_INFO; 