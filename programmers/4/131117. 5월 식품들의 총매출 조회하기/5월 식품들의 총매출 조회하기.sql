
/*
food_product 
food_order
*/

# select p.product_id, p.product_name, p.price, o.amount
# from food_product p join food_order o
#                       on p.product_id = o.product_id
# where year(o.produce_date) = 2022 and month(o.produce_date) = 5;


-- 식품 id, 식품 이름, 총 매출(amount * price)
select p.product_id, p.product_name, sum(p.price*o.amount) as total_sales
from food_product p join food_order o
                      on p.product_id = o.product_id
where year(o.produce_date) = 2022 and month(o.produce_date) = 5
group by product_id
order by total_sales desc, product_id asc;

