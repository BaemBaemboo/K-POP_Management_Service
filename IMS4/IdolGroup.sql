DROP TABLE  idolGroup PURGE; --perge�� �������� ����

CREATE table idolGroup( --Child Table(�����ϴ� ���̺�)
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

--Parent Table (���� ���ϴ� ���̺�)
--1. Primary key�� songId�� ����
--2. albumNumber���� UNIQUE ���� ���
--3. �ϳ��� �ٹ��� �������� �뷡�� ����
CREATE TABLE album(
	albumNumber NUMBER,
	albumName VARCHAR2(20),
	songName VARCHAR2(30)
);

ALTER TABLE  idolGroup --����
ADD CONSTRAINT idolGroup_albumNumber_FK FOREIGN KEY ()albumNumber)
REFERENCES album (albumNumber)

ALTER TABLE idolGroup
DROP CONSTRAINT idolGroup_albumNumber_FK;
