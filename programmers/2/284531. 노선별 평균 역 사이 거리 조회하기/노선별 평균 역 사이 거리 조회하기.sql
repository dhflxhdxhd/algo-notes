/*
SUBWAY_DISTANCE 서울지하철 2호선의 역 간 거리 정보
LINE, NO, ROUTE, STATION_NAME, D_BETWEEN_DIST, D_CUMULATIVE

[OUTPUT]
노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성

총 누계 거리 : 테이블 내 존재하는 역들의 역 사이 거리의 총 합
총 누계거리는 소수 둘째자리
평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)를 함께 출력

ORDER BY TOTAL_DISTANCE DESC
*/

SELECT 
    ROUTE,
    CONCAT(ROUND(SUM(D_BETWEEN_DIST),1),"km") AS TOTAL_DISTANCE, 
    CONCAT(ROUND(AVG(D_BETWEEN_DIST),2),"km") AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY ROUND(SUM(D_BETWEEN_DIST),1) DESC;



