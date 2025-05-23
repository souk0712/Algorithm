select count(*) as "COUNT"
from ecoli_data
where genotype & 2 = 0 AND (genotype & 1 > 0 OR genotype & 4 > 0)