create schema `debatecontest-schema`;
use `debatecontest-schema`;

create table `student`(
	student_id int primary key not null auto_increment,
    first_name varchar(50) default null,
    last_name varchar(50) default null,
    course varchar(50) default null,
    country varchar(50) default null
);

alter table `student` auto_increment = 001;

insert into `student` (first_name, last_name, course, country) values
('Shyam', 'Nair', 'CSE', 'India'),
('Shankar', 'Nair', 'IT', 'India');

select * from `student`;