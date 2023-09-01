--
-- ddl
--
drop table member;
create table member (
	no int not null auto_increment,
    email varchar(200) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    department varchar(100),
    primary key(no)
);

desc member;

alter table member add column juminbunho char(13) not null;
desc member;

alter table member drop column juminbunho;
desc member;

alter table member add column juminbunho char(13) not null after email;
desc member;

alter table member change column department dept varchar(100) not null;
desc member;

alter table member add self_intro text;
desc member;

alter table member drop column juminbunho;
desc member;

--
-- dml
-- 

-- insert
insert 
  into member 
values (null, 'gywls1390@gmail.com', password('1234'), '김효진', '개발팀', null);
select * from member;

insert 
  into member(no, email, password, name, dept, self_intro)
values (null, 'gywls1390@gmail.com', password('1234'), '김효진2', '개발팀2', null);
select * from member;

insert 
  into member(email, password, name, dept)
values ('gywls1390@gmail.com', password('1234'), '김효진3', '개발팀3');
select * from member;

insert 
  into member(email, name, dept,  password)
values ('gywls1390@gmail.com', '김효진4', '개발팀4', password('1234'));
select * from member;

-- update
update member 
   set email='gywls@gmail.com', name='효진'
 where no = 4;
select * from member;

-- delete
delete 
  from member 
 where no = 4;
select * from member;
