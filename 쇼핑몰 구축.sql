--테이블 생성
​
CREATE TABLE MEMBERSHIP
(	
	"ID" VARCHAR2(100) PRIMARY KEY,
	"NAME" VARCHAR2(100),
	"ADDRESS" VARCHAR2(100)
)
​
CREATE TABLE CART
(	
	"PRODUCT" VARCHAR2(100),
	"QUANTITY" NUMBER(38, 0),
	"ID" VARCHAR2(100)
)
​
CREATE TABLE PRODUCT2
(	
	"PRODUCT" VARCHAR2(100) PRIMARY KEY,
	"PRICE" NUMBER(38, 0),
	"CATEGORY" VARCHAR2(100)
)
​
CREATE TABLE EVENT
(	
	"CATEGORY" VARCHAR2(100) PRIMARY KEY,
	"EVENT_NAME" VARCHAR2(100)
)
​
--외래키 설정
​
ALTER TABLE HR.CART ADD CONSTRAINT FK1_MEMBERSHIP FOREIGN KEY (ID) REFERENCES HR.PRODUCT2(ID);
​
ALTER TABLE HR.CART ADD CONSTRAINT FK2_PRODUCT FOREIGN KEY (PRODUCT) REFERENCES HR.PRODUCT2(PRODUCT);
​
ALTER TABLE HR.EVENT ADD CONSTRAINT FK2_PRODUCT2 FOREIGN KEY (CATEGORY) REFERENCES HR.PRODUCT2(CATEGORY);
​
​
--데이터 추가
​
INSERT INTO MEMBERSHIP (ID, NAME, ADDRESS) VALUES ('chaeji', '채지윤', '경상남도 김해시')
​
INSERT INTO MEMBERSHIP VALUES ('jihun1102', '전지훈', '강원도 춘천시')
​
INSERT INTO MEMBERSHIP (ID, NAME, ADDRESS) VALUES ('yoonj', '임윤정', '경기도 안양시')
​
INSERT INTO MEMBERSHIP VALUES ('JJ2uu', '장유진', '대한민국 서울')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('반려견 사료', 13980, '반려/취미')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('츄잉스틱 플레인 요거트', 5480, '반려/취미')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('오리목뼈', 8580, '반려/취미')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('반려묘 사료', 24980, '반려/취미')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('삼겹살 바로구이', 12980, '정육')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('빅그릴프랑크', 5880, '정육')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('닭다리살 스테이크', 9580, '정육')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('한우국거리', 12980, '정육')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('마늘 오리불고기', 6980, '정육')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('초코베어' , 2980, '과자/빙과')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('구슬아이스크림' , 6980, '과자/빙과')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('졸음깨는껌' , 3280, '과자/빙과')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('스폴리아띠네' , 2580, '과자/빙과')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('고소한맛짱' , 2180, '과자/빙과')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('노브랜드 사골육수', 980, '한끼뚝딱')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('노브랜드 쇠고기 사골미역국', 1980, '한끼뚝딱')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('노브랜드 비빔쫄면', 3380, '한끼뚝딱')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('노브랜드 마라탕면', 2180, '한끼뚝딱')
​
INSERT INTO PRODUCT2 (PRODUCT, PRICE, CATEGORY) VALUES ('노브랜드 가벼운한끼 콘포테이토마차', 4980, '한끼뚝딱')
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('노브랜드 가벼운한끼 콘포테이토마차', 'yoonj', 1)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('고소한맛짱', 'yoonj', 1 )
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('졸음깨는껌', 'yoonj', 1 )
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('삼겹살 바로구이', 'yoonj', 1)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('삼겹살 바로구이', 'chaeji', 1)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('노브랜드 마라탕면', 'chaeji', 2)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('구슬아이스크림', 'chaeji', 3)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('초코베어', 'jihun1102', 1)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('노브랜드 쇠고기 사골미역국', 'jihun1102', 2)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('닭다리살 스테이크', 'jihun1102', 2)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('고소한맛짱', 'jihun1102', 1)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('삼겹살 바로구이', 'JJ2uu', 2)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('졸음깨는껌', 'JJ2uu', 3)
​
INSERT INTO CART (PRODUCT, ID, QUANTITY) VALUES ('노브랜드 마라탕면', 'JJ2uu', 5)
​
--JOIN 실습
​
SELECT C.ID, M.NAME, C.PRODUCT
FROM CART C, MEMBERSHIP M
WHERE C.ID = M.ID
​
--CRUD (SQL) 이상현상
​
DELETE FROM CART WHERE ID = 'yoonj' AND PRODUCT = '졸음깨는껌'
​
SELECT * FROM CART
​
SELECT * FROM MEMBERSHIP
​
SELECT * FROM PRODUCT2
​
SELECT * FROM EVENT