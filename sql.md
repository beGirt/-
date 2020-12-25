``` mysql


create table tbl_Question (
	ques_id varchar(255) not null,
    ques_stem varchar(255) not null,
    ques_A varchar(255) not null,
    ques_B varchar(255) not null,
    ques_C varchar(255) not null,
    ques_D varchar(255) not null,
    ques_Corrrect varchar(255) not null,
    Picture blob,
    primary key (ques_id)
)

create table tbl_stu (
	stu_id int not null,
    stu_account varchar(64) not null,
    stu_password varchar(64) not null,
    stu_name varchar(64) not null,
    gender char(4) not null,
    PhoneNumber char(11) not null,
    stu_score int not null,
    primary key (stu_id)
)

```

