use webfood;
insert into role(id, rolename)
values (1, "ROLE_ADMIN"),
	   (2, "ROLE_USER");

insert into user(id, address, birthday, fullname, password, username)
values 
	(1, "Hà Nội", '1990-1-1', "Nguyễn Văn A", "$2y$12$c0RC3w65EsDyBSAbrjzQ7uC5ZdvXSmf/..jEq1KCA5xBVJiYkcVVa", "admin"),
    (2, "Hà Nội", '1991-1-2', "Lê Thị B", "$2y$12$c0RC3w65EsDyBSAbrjzQ7uC5ZdvXSmf/..jEq1KCA5xBVJiYkcVVa", "user");
    
insert into user_role(user_id, role_id)
values
	(1, 1), (1, 2),
    (2, 2);