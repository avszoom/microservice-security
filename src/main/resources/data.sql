INSERT INTO USER(username,password,enabled) values ('user', 'pass', true);
INSERT INTO USER(username,password,enabled) values ('admin', 'pass', true);

INSERT INTO AUTHORIZATION(username,authority) values ('user','ROLE_USER');
INSERT INTO AUTHORIZATION(username,authority) values ('admin','ROLE_ADMIN');
