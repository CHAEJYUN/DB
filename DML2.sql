SELECT LENGTH(ename) FROM emp

SELECT LENGTH(ename) FROM emp WHERE JOB = 'manager'

SELECT ename, job FROM emp WHERE comm IS NULL

SELECT hiredate FROM emp WHERE comm IS NOT NULL

SELECT SUBSTR(ename, 2) FROM emp

SELECT SUBSTR(job, 1, 3) FROM emp

SELECT REPLACE(ename, 'k', 'p') FROM emp

SELECT empno || '번은 ' || ename '입니다' FROM emp

SELECT hiredate,
TO_CHAR(SYSDATE, 'mm') AS mm, TO_CHAR(SYSDATE, 'day') AS day  
FROM emp 

SELECT job,
CASE job
	WHEN 'manager' THEN 'level1'
	WHEN 'saleman' THEN 'level2'
	ELSE 'level3'
END AS level_result
FROM emp

---------------------------------------

SELECT count(*) FROM emp

SELECT count(sal)
FROM EMP
WHERE DEPTNO = 20 OR MGR <= 7700

SELECT min(sal)
FROM EMP
WHERE DEPTNO = 10 OR DEPTNO = 20

SELECT avg(sal)
FROM EMP
GROUP BY DEPTNO

SELECT sum(sal)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO

SELECT AVG(sal)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(sal) >= 2000
ORDER BY DEPTNO DESC

SELECT COUNT(*), avg(SAL)
FROM EMP
WHERE JOB = 'MANAGER'

SELECT count(*)
FROM EMP
WHERE ename LIKE '%S%'

SELECT count(*)
FROM EMP
WHERE sal >= 3000 AND comm IS NOT NULL

-------------------------------------------

SELECT *
FROM "MEMBER" m, BBS b
WHERE m.ID = b.WRITER

SELECT b."no", title, name
FROM "MEMBER" m, BBS b
WHERE m.ID = b.WRITER

---이너 조인
SELECT e.empno, e.ename, e.job, d.deptno, d.loc
FROM dept d, emp e
WHERE d.DEPTNO = e.DEPTNO

SELECT *
FROM "MEMBER" m
LEFT OUTER JOIN BBS b
ON (m.ID = b.WRITER)

SELECT *
FROM "MEMBER" m
RIGHT OUTER JOIN BBS b
ON (m.ID = b.WRITER)

--left/right 아우터 조인

SELECT *
FROM emp e
LEFT OUTER JOIN DEPT  D
on(e.DEPTNO = d.DEPTNO)

SELECT *
FROM emp e
RIGHT OUTER JOIN DEPT  D
on(e.DEPTNO = d.DEPTNO)

----------------------------------문제

SELECT *
FROM "MEMBER" m, BBS b
WHERE m.ID = b.WRITER

SELECT *
FROM "MEMBER" m
LEFT OUTER JOIN BBS b
ON (m.ID = b.WRITER)

SELECT *
FROM "MEMBER" m
RIGHT OUTER JOIN BBS b
ON (m.ID = b.WRITER)

CREATE TABLE company (
	id varchar2(100),
	name varchar2(200),
	addr varchar2(200),
	tel varchar2(200)
)

INSERT INTO company VALUES ('c100', 'good', 'seoul', '011')

INSERT INTO company VALUES ('c200', 'joa', 'busan', '012')

INSERT INTO company VALUES ('c300', 'maria', 'ulsan', '013')

INSERT INTO company VALUES ('c400', 'my', 'kwangju', '014')

CREATE TABLE product (
	id varchar2(100),
	name varchar2(100),
	content varchar2(100),
	price varchar2(100),
	company varchar2(100),
	img varchar2(100)
)

CREATE TABLE reply (
	id varchar2(100),
	oriid varchar2(100),
	content varchar2(100),
	writer varchar2(100)
)

SELECT *
FROM PRODUCT p, COMPANY c
WHERE p.COMPANY = c.ID

SELECT *
FROM PRODUCT p
LEFT OUTER JOIN COMPANY c
ON (p.COMPANY = c.ID)

SELECT *
FROM "MEMBER" m
RIGHT OUTER JOIN BBS b
ON (p.COMPANY = c.ID)

INSERT INTO PRODUCT VALUES ('100', 'food1', 'fun food1', '1000', 'c100', '1.png')

INSERT INTO company VALUES ('101', 'food2', 'fun food2', '2000', 'c200', '2.png')