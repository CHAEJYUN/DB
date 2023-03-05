--테이블 생성
CREATE TABLE price (
	id varchar2(100),
	name varchar2(100),
	content varchar2(100),
	price number(38,0)
)

--제약조건 추가
CREATE TABLE depart (
	id varchar2(100) PRIMARY key,
	name varchar2(100),
	instructor varchar2(100)
)

CREATE TABLE student (
	id varchar2(100) PRIMARY key,
	name varchar2(100),
	content varchar2(100),
	depart_id varchar2(100),
	CONSTRAINT fk_depart FOREIGN KEY (depart_id) REFERENCES depart (id)
)

CREATE TABLE subject (
	id varchar2(100) PRIMARY key,
	title varchar2(100),
	depart_id varchar2(100),
	CONSTRAINT fk_depart2 FOREIGN KEY (depart_id) REFERENCES depart (id)
)

CREATE TABLE professor (
	id varchar2(100),
	name varchar2(100),
	tel varchar2(100),
	deptid number(38, 0),
	addr varchar2(100),
	roomno varchar2(100),
	CONSTRAINT pk_professor PRIMARY KEY (id),
	CONSTRAINT fk2_dept FOREIGN KEY (deptid) REFERENCES dept (deptno)
)

CREATE table student2 (
	id varchar2(100) PRIMARY key,
	name varchar2(100),
	tel varchar2(100),
	depno number(38, 0) REFERENCES dept (deptno),
	professorid varchar2(100)
)

CREATE TABLE member3 (
	id varchar2(100),
	pw varchar2(100),
	name varchar2(100),
	tel varchar2(100)
)

ALTER TABLE member3 ADD (
	post varchar2(100),
	home varchar2(100)
)

CREATE TABLE depart2 (
	id varchar2(100) PRIMARY KEY,
	name varchar2(100),
	instructor varchar2(100)
)

CREATE TABLE student2 (
	id varchar2(100),
	name varchar2(100),
	tel varchar2(100),
	depart_id varchar2(100)
)

ALTER TABLE STUDENT2
ADD CONSTRAINT pk_student2 PRIMARY KEY (id)

ALTER TABLE STUDENT2 
ADD CONSTRAINT fk_student2 FOREIGN KEY (depart_id) REFERENCES depart2 (id) 