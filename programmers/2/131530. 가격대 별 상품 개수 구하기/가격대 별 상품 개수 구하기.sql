
select Floor(price/10000)*10000 as PRICE_GROUP, count(product_id) as PRODUCTS
from product
group by Floor(price / 10000)
order by PRICE_GROUP









