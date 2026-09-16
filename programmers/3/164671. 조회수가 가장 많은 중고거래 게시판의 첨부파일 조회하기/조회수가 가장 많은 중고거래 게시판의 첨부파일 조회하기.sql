/*
USED_GOODS_BOARD 중고거래 게시판 정보
BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS

USED_GOODS_FILE 중고거래 게시판 첨부파일 정보
FILE_ID, FILE_EXT, FILE_NAME, BOARD_ID

조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬

기본적인 파일경로는 /home/grep/src/ 이며, 게시글 ID를 기준으로 디렉토리가 구분
파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력

조회수가 가장 높은 게시물은 하나만 존재
*/

# SELECT UGF.BOARD_ID, UGF.FILE_ID, UGF.FILE_EXT, UGF.FILE_NAME
SELECT CONCAT("/home/grep/src/",UGF.BOARD_ID, "/",UGF.FILE_ID,UGF.FILE_NAME, UGF.FILE_EXT ) as FILE_PATH
FROM USED_GOODS_FILE AS UGF
JOIN (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    WHERE VIEWS = (
        SELECT MAX(VIEWS)
        FROM USED_GOODS_BOARD
    )
) AS UGB
ON UGF.BOARD_ID = UGB.BOARD_ID
ORDER BY FILE_ID DESC;


