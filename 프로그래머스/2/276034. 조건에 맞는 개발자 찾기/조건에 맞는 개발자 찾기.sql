select distinct(id), email, first_name, last_name
from skillcodes
join developers on skillcodes.code & developers.skill_code
where name in ("Python", "C#")
order by id