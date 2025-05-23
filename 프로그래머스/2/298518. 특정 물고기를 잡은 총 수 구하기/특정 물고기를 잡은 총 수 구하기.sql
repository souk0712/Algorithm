select count(*) as "FISH_COUNT"
from fish_info
join fish_name_info
on fish_name_info.FISH_TYPE = fish_info.FISH_TYPE
where fish_name_info.fish_name = "BASS" OR fish_name_info.fish_name = "SNAPPER"