select count(*) as FISH_COUNT, month(time) as MONTH
from fish_info
group by month
order by month asc