select department.DEPT_ID, department.DEPT_NAME_EN, ROUND(AVG(employees.SAL)) AVG_SAL
from HR_DEPARTMENT department
join HR_EMPLOYEES employees on department.DEPT_ID = employees.DEPT_ID
group by department.DEPT_ID
order by AVG_SAL DESC