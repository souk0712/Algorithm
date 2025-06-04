# select *
# from HR_DEPARTMENT d
# join HR_EMPLOYEES e on d.DEPT_ID = e.DEPT_ID

select SUM(HG.SCORE) SCORE, HG.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_GRADE HG
join HR_EMPLOYEES HE on HG.EMP_NO = HE.EMP_NO
where HG.year = "2022"
group by HE.EMP_NO
order by SCORE desc
limit 1