-- emaillist

-- insert
insert into emaillist values(null, '김', '효진', 'gywls1390@gmail.com');

-- findAll
select no, first_name, last_name, email from emaillist order by no desc;

-- delete
delete from emaillist where email = 'gywls1390@gmail.com';
