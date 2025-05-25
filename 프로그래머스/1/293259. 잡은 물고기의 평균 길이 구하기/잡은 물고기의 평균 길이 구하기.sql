select round(sum(ifnull(length, 10)) / count(*), 2) as "AVERAGE_LENGTH"
from fish_info