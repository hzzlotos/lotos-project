insert into authority values (1,'科目库管理');
insert into authority values (2,'用户管理');
insert into authority values (3,'试题基础管理');
insert into authority values (4,'知识体系管理');
insert into authority values (5,'试题添加');
insert into authority values (6,'试题审核');
insert into authority values (7,'试题管理');

insert into role values (1,'系统管理员',1);
insert into role values (2,'科目管理员',2);
insert into role values (3,'试题添加',3);
insert into role values (4,'尸体审核',3);

insert into role_auth values (1,1);
insert into role_auth values (1,2);
insert into role_auth values (1,3);
insert into role_auth values (1,4);
insert into role_auth values (1,5);
insert into role_auth values (1,6);
insert into role_auth values (1,7);
insert into role_auth values (2,3);
insert into role_auth values (2,4);
insert into role_auth values (2,5);
insert into role_auth values (2,6);
insert into role_auth values (2,7);
insert into role_auth values (3,5);
insert into role_auth values (4,6);

insert into user values (1,'admin','admin','admin@admin.com',null);
insert into user_role values (1,1,1,null);
/*
 * 乱码问题修改my.ini里面的字符集 2个地方 2个my.ini都要改
 */