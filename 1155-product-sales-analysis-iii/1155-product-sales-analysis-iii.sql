 with cte as(
    select product_id ,min(year) first_year ,quantity,price from sales group by product_id 
 )
 select sales.product_id  ,sales.year  first_year ,sales.quantity,sales.price from sales join cte on sales.year=cte.first_year and sales.product_id=cte.product_id;