select count(*) as FISH_COUNT, n.FISH_NAME
from FISH_INFO f
join FISH_NAME_INFO n on f.FISH_TYPE = n.FISH_TYPE
group by n.FISH_NAME
order by FISH_COUNT desc