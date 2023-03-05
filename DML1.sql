CREATE TABLE HR.depart2 (
	id varchar2(100),
	name varchar2(100),
	instructor varchar2(100),
	constraints pk_dp2 PRIMARY KEY (id)
)

CREATE TABLE "HR"."MEMBER" 
   (	
   	"ID" VARCHAR2(10), 
	"PW" VARCHAR2(10), 
	"NAME" VARCHAR2(10), 
	"TEL" VARCHAR2(10)
   )
   
CREATE TABLE hr. member22
AS SELECT * from hr.MEMBER
   
INSERT INTO hr.member22
VALUES ('banana3', 'banana3', 'banana3', 'banana3', sysdate)
   
SELECT * FROM hr.member22 
   
INSERT INTO hr.MEMBER22 
VALUES ('banana4', 'banana4', 'banana4', 'banana4', sysdate, 'aaa')
   
CREATE SEQUENCE pd_id_seq
INCREMENT BY 1
START WITH 1

CREATE TABLE hr.product3 (
	id number(38, 0),
	name varchar2(100)
)

INSERT INTO product3 
VALUES (pd_id_seq.nextval, 'shoes')

SELECT * FROM product3

CREATE TABLE hr.orderlist3 (
	id number(38, 0),
	title varchar2(100),
	price number(38, 0)
)

CREATE SEQUENCE or_seq
INCREMENT BY 1
START WITH 1

INSERT INTO HR.ORDERLIST3 
VALUES (or_seq.nextval, 'bbb', 2)

SELECT* FROM HR.ORDERLIST3

CREATE TABLE hr.DEPT (
	DEPTNO NUMBER(2),
	DNAME VARCHAR2(14 BYTE),
	LOC VARCHAR2(13 BYTE)
)

CREATE TABLE hr.EMP (
	EMPNO NUMBER(4),
	ENAME VARCHAR2(10 BYTE),
	JOB VARCHAR2(9 BYTE),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2)
)

CREATE TABLE hr.SALGRADE (
	GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER
)

SELECT * FROM hr.emp

SELECT deptno FROM hr.emp

SELECT DISTINCT deptno FROM hr.emp

SELECT ename, sal * 12 AS yearsal FROM hr.emp

SELECT * FROM hr.emp ORDER BY sal DESC

-----------------------------------------

SELECT *FROM hr.product3

SELECT * FROM hr. product3 ORDER BY price DESC

SELECT name, content, price FROM hr.product3 ORDER BY company

SELECT DISTINCT company FROM hr.product3

SELECT price AS price5 FROM hr.product3

SELECT name, company FROM hr.product3 WHERE price BETWEEN 3000 AND 6000

SELECT company, name FROM hr.product3 WHERE company != 'c100'

SELECT name, price FROM hr.product3 WHERE company = 'c100' OR company = 'c200'

SELECT * FROM hr.product3 WHERE name LIKE '%4'

SELECT * FROM hr.product3 WHERE name LIKE '%food%'

UPDATE hr.product3 SET content = '품절' WHERE price = '5000'

UPDATE hr.product3 SET img = 'o.png', price = '1000' WHERE id = '100' OR id = '200'

