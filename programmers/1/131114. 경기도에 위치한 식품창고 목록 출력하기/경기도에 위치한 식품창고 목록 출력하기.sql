select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') FREEZER_YN
from food_warehouse
where address LIKE "%경기도%"
order by warehouse_id asc;