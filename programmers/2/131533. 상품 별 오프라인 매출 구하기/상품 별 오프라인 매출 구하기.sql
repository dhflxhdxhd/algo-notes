select pd.product_code, sum(off.sales_amount*pd.price) as sales
from product as pd
join offline_sale as off
on pd.product_id = off.product_id
group by pd.product_code
order by sum(off.sales_amount*pd.price) desc, pd.product_code asc;
