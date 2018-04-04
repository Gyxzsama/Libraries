DROP database if exists library;
create database library;
use library;
create table manager(
	id int primary key auto_increment,
	mgrName varchar(30),
	mgrPwd  varchar(64),
	mgrContact varchar(64)
);

create table reader(
	id int primary key auto_increment,
	readerName varchar(30),
	readerPwd  varchar(64),
	borrowNum int,
	readerContact varchar(64)
);

create table book(
	id int primary key auto_increment,
	bookName varchar(30),
	author  varchar(64),
	publisher varchar(64),
	price double,
	stock int ,
	current int
);

create table borrow(
	id int primary key auto_increment,
	bookId int,
	readerId  int,
	borrowDate date,
	backDate   date
);
insert into manager (mgrName,mgrPwd,mgrContact)values('admin','admin','1234567890');

insert into reader (readerName,readerPwd,borrowNum,readerContact)values('张三','123456',0,'123456');
insert into reader (readerName,readerPwd,borrowNum,readerContact)values('李四','123456',0,'123456');
insert into reader (readerName,readerPwd,borrowNum,readerContact)values('王五','123456',0,'123456');
insert into reader (readerName,readerPwd,borrowNum,readerContact)values('陆六','123456',0,'123456');
insert into reader (readerName,readerPwd,borrowNum,readerContact)values('赵七','123456',0,'123456');
insert into reader (readerName,readerPwd,borrowNum,readerContact)values('钱八','123456',0,'123456');

insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX001','X001','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX002','X002','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX003','X003','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX004','X004','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX005','X005','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX006','X006','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX007','X007','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX008','X008','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX009','X009','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX010','X010','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX011','X011','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX012','X012','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX013','X013','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX014','X014','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX015','X015','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX016','X016','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX017','X017','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX018','X018','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX019','X019','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX020','X020','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX021','X021','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX022','X022','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX023','X023','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX024','X024','XXXXXX001',20,10,10);
insert into book (bookName,author,publisher,price,stock,current)values('XXXXXX025','X025','XXXXXX001',20,10,10);