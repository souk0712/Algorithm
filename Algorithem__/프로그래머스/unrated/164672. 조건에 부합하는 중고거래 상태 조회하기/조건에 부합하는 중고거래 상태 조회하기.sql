-- 코드를 입력하세요
select BOARD_ID, WRITER_ID, TITLE, PRICE, 
    case(STATUS)
        when 'DONE' then '거래완료'
        when 'SALE' then '판매중'
        when 'RESERVED' then '예약중'
        END STATUS
from USED_GOODS_BOARD
where DATE_FORMAT(CREATED_DATE,'%Y-%m-%d') = DATE_FORMAT('2022-10-05','%Y-%m-%d')
order by BOARD_ID DESC