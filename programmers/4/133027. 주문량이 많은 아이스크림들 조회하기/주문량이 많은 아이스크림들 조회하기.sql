/*
FIRST_HALF 아이스크림 가게의 상반기 주문 정보
SHIPMENT_ID(FK), FLAVOR(PK), TOTAL_ORDER

JULY 7월의 아이스크림 주문 정보
SHIPMENT_ID(PK), FLAVOR(FK), TOTAL_ORDER

7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 
서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우 존재
-> 같은 맛의 아이스크림이어도 다른 출하 번호

7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회
*/

SELECT F.FLAVOR
FROM FIRST_HALF AS F
JOIN (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM JULY 
    GROUP BY FLAVOR
) AS J
ON F.FLAVOR = J.FLAVOR
ORDER BY (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3




