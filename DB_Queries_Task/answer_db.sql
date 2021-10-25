
--Task 1
select count(*) from news
                         FULL OUTER JOIN reviews
                                         ON news.n_id = NULL
WHERE news.n_id IS NULL OR reviews.r_id IS NULL

--Task 2
select nc_name, count(n_id) from news_categories
                                     left join news
                                               on nc_id = news.n_category
GROUP BY nc_name

--Task 3
select rc_name, count(r_id) from reviews_categories
                                     left join reviews
                                               on rc_id = reviews.r_category
GROUP BY rc_name

--Task 4
select (nc_name, rc_name) as category_name, (n_dt, r_dt) as last_date
from
    (select DISTINCT ON (nc_id) * from news_categories
                                           right join news
                                                      on nc_id = news.n_category
     GROUP BY nc_id, n_id
     ORDER BY nc_id, n_dt DESC) as t1
        full outer join
    (select DISTINCT ON (rc_id) * from reviews_categories
                                           right join reviews
                                                      on rc_id = reviews.r_category
     GROUP BY rc_id, r_id
     ORDER BY rc_id, r_dt DESC) as t2
    on t1.nc_id = NULL
WHERE t1.nc_id is NULL OR t2.rc_id is NULL

--Task 5
select p_name, t1.b_id, banners.b_url from
    (select * from m2m_banners_pages as m2m
                       inner join pages
                                  on m2m.p_id = pages.p_id
     where p_parent is NULL) as t1
        inner join banners
                   on t1.b_id = banners.b_id

--Task 6
select DISTINCT(p_name) from m2m_banners_pages as m2m
                                 left join pages
                                           on m2m.p_id = pages.p_id

--Task 7
select p_name from m2m_banners_pages as m2m
                       right join pages
                                  on m2m.p_id = pages.p_id
WHERE m2m.p_id is NULL

--Task 8
select p_name from m2m_banners_pages as m2m
                       right join pages
                                  on m2m.p_id = pages.p_id
WHERE m2m.p_id is NULL

--Task 9
select DISTINCT banners.b_id, b_url from banners
                                            left join m2m_banners_pages as m2m
                                                      on banners.b_id = m2m.b_id
WHERE m2m.b_id is NULL

--Task 10
select b_id, b_url, ((100*b_click)/ b_show) as rate  from banners
where b_show > 0
  and ((100*b_click)/ b_show) > 80

--Task 11
select DISTINCT p_name from m2m_banners_pages as m2m
                                left join banners
                                          on m2m.b_id = banners.b_id
                                left join pages
                                          on m2m.p_id = pages.p_id
where b_text is not NULL

--Task 12
select DISTINCT p_name from m2m_banners_pages as m2m
                                left join banners
                                          on m2m.b_id = banners.b_id
                                left join pages
                                          on m2m.p_id = pages.p_id
where b_pic is not NULL

--Task 13
select (n_header, r_header) as header, (n_dt, r_dt) as date
from news
         full join reviews
                   on n_id = NULL
where (n_id is NULL or r_id is NULL)
  and ((n_dt >= '2011-01-01' and n_dt<'2012-01-01')
    or (r_dt >= '2011-01-01' and r_dt<'2012-01-01'))

--Task 14
select (nc_name, rc_name) as category from news_categories as nc
                                               left join news
                                                         on nc.nc_id = news.n_category
                                               full join reviews_categories as rc
                                                         on nc.nc_id = NULL
                                               left join reviews
                                                         on rc.rc_id = reviews.r_category
where (news.n_id is NULL) and (reviews.r_id is NULL)

--Task 15
select n_header, n_dt from news
                               left join news_categories as nc
                                         on news.n_category = nc.nc_id
where nc_name = 'Логистика '
  and (n_dt >= '2012-01-01' and n_dt < '2013-01-01')

--Task 16
select date_part('year',n_dt) as year, count(n_dt) from news
GROUP BY year

--Task 17
select banners.b_url, b_id from banners
                                   left join (select b_url, count(b_url) as val from banners
                                              GROUP BY b_url
                                              ORDER BY b_url DESC ) as t1
                                             on t1.b_url = banners.b_url
WHERE val > 1

--Task 18
select p_name, banners.b_id, b_url from pages
                                           inner join m2m_banners_pages as m2m
                                                      on m2m.p_id = pages.p_id
                                           inner join banners
                                                      on m2m.b_id = banners.b_id
where p_parent =
      (select p_id from pages
       where p_name = 'Юридическим лицам ')

--Task 19
select b_id, b_url, ((100*b_click)/ b_show) as rate
from banners
where b_pic is not NULL
order by rate desc

--Task 20
select (n_header, r_header) as header, (n_dt, r_dt) as date
from news
         full join reviews
                   on news.n_id = NULL
order by date
limit 1

--Task 21
select banners.b_url, b_id from banners
                                   left join (select b_url, count(b_url) as co from banners
                                              group by b_url) as t1
                                             on banners.b_url = t1.b_url
where co = 1

--Task 22
select p_name, count(m2m.b_id) as co from m2m_banners_pages as m2m
                                              left join banners
                                                        on banners.b_id = m2m.b_id
                                              left join pages
                                                        on pages.p_id = m2m.p_id
group by p_name
order by co desc, p_name asc

--Task 23
select (r_header, n_header) as header, (n_dt, r_dt) as date
from (select * from news
      order by n_dt desc
      limit 1) as n
         full join (select * from reviews
                    order by r_dt desc
                    limit 1) as r
                   on n.n_id = NULL

--Task 24
select b_id, b_url, b_text from banners
where substring(upper(b_url),trim(b_text) ) is not null

--Task 25
select p_name  from m2m_banners_pages as m2m
                        inner join pages as p
                                   on p.p_id = m2m.p_id
                        inner join banners as b
                                   on b.b_id = m2m.p_id
order by ((100*b_click)/ b_show) desc
limit 1

--Task 26
select avg(((100*b_click)/ b_show))/100 from banners
where b_show > 0

--Task 27
select avg(((100*b_click)/ b_show))/100 from
    (select * from banners where b_pic is NULL) as t1
where b_show > 0

--Task 28
select count(*) from pages as p
                         inner join m2m_banners_pages as m2m
                                    on p.p_id = m2m.p_id
                         inner join banners as b
                                    on b.b_id = m2m.b_id
where p_parent is null

--Task 29
select banners.b_id, b_url, count(banners.b_id)
from banners
         inner join m2m_banners_pages as m2m
                    on banners.b_id = m2m.b_id
group by b_url,  banners.b_id
order by count(banners.b_id) desc
limit 1

--Task 30
select p_name, max(c1) from (
                                select p.p_id, p_name, count(*) as c1 from pages as p
                                                                               left join m2m_banners_pages as m2m
                                                                                         on p.p_id = m2m.p_id
                                group by p.p_id
                                order by count(*) desc) as t1
where c1 = (select max(c1) from (select p.p_id, p_name, count(*) as c1 from pages as p
                                                                                left join m2m_banners_pages as m2m
                                                                                          on p.p_id = m2m.p_id
                                 group by p.p_id
                                 order by count(*) desc) as t1)
group by p_name
