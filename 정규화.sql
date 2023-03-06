CREATE TABLE subject (
	강좌이름 varchar2(100) PRIMARY key,
	강의실 varchar2(100)
)


CREATE TABLE department (
	학과  varchar2(100) PRIMARY key,
	학과사무실 varchar2(100)
)

CREATE TABLE "RECORD" (
	학생번호  number(38, 0) REFERENCES student_information (학생번호),
	강좌이름  varchar2(100) REFERENCES subject (강좌이름),
	성적  number(38, 0)
)

CREATE TABLE student_information (
	학생번호 number(38, 0) PRIMARY key,
	학생이름  varchar2(100),
	주소  varchar2(100),
	학과  varchar2(100) REFERENCES department (학과)
)

SELECT r.학생번호, s.강좌이름, s.강의실, r.성적  
FROM "SUBJECT" s, "RECORD" r
WHERE s.강좌이름 = r.강좌이름

SELECT r.학생번호, si.학생이름, si.주소, si.학과, r.강좌이름, r.성적  
FROM "RECORD" r, "STUDENT_INFORMATION" si
WHERE r.학생번호 = si.학생번호

SELECT r.학생번호, si.학생이름, si.주소, si.학과, s.강좌이름, s.강의실, r.성적
FROM "SUBJECT" s
INNER JOIN "RECORD" r
ON s.강좌이름 = r.강좌이름
INNER JOIN "STUDENT_INFORMATION" si
on r.학생번호 = si.학생번호

--서브쿼리
SELECT * FROM "STUDENT_INFORMATION" WHERE 학생번호 IN
(SELECT 학생번호 FROM "RECORD" WHERE 성적 = 4)

--노브랜드 장보기(9조)
INSERT INTO membership ('chaeji', '채지윤', '경상남도 김해시')

('삼겹살 바로구이', 12980, '정육')
('빅그릴프랑크', 5880, '정육')
('닭다리살 스테이크', 9580, '정육')
('한우국거리', 12980 '정육')
('마늘 오리불고기', 6980, '정육')

('삼겹살 바로구이', 'chaeji', 1)
('노브랜드 마라탕면', 'chaeji', 2)
('구슬아이스크림', 'chaeji', 3)

--
