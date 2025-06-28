select child.ID, child.GENOTYPE, parent.GENOTYPE PARENT_GENOTYPE
from ECOLI_DATA child
join ECOLI_DATA parent on child.PARENT_ID = parent.ID
where (child.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE
order by child.ID