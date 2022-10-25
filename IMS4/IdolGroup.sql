DROP TABLE  idolGroup PURGE; --perge는 영구삭제 구문

CREATE table idolGroup( --Child Table(참조하는 테이블)
	name VARCHAR2(18) PRIMARY KEY,--unique, not null
	gender CHAR(1) NOT NULL,
	generation NUMBER,
	year NUMBER,
	nation VARCHAR2(18),
	albumName VARCHAR2(20),
	songName VARCHAR2(20), 
	company VARCHAR2(18) 
)

DROP TABLE album PURGE;

--Parent Table (참조 당하는 테이블)
--1. Primary key를 songId에 지정
--2. albumNumber에는 UNIQUE 제약 사용
--3. 하나의 앨범에 여러개의 노래를 저장
CREATE TABLE album(
	albumNumber NUMBER,
	albumName VARCHAR2(20),
	songName VARCHAR2(30)
);

ALTER TABLE  idolGroup --변경
ADD CONSTRAINT idolGroup_albumNumber_FK FOREIGN KEY ()albumNumber)
REFERENCES album (albumNumber)

ALTER TABLE idolGroup
DROP CONSTRAINT idolGroup_albumNumber_FK;
