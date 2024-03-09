create table remedy(
id big int not null auto_increment,
name varchar(100) not null,
way varchar(100) not null,
laboratory varchar(100) not null,	
lot varchar(100) not null,
quantity double precision,
valid timestamp without timestamp,

primary key (id) 
)