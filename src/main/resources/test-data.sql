INSERT INTO USER (USERNAME, PASSWORD, ENABLED) VALUES ('client','client',TRUE);
INSERT INTO USER (USERNAME, PASSWORD, ENABLED) VALUES ('admin','admin',TRUE);
INSERT INTO USER (USERNAME, PASSWORD, ENABLED) VALUES ('user','user',TRUE);
INSERT INTO USER (USERNAME, PASSWORD, ENABLED) VALUES ('supervisor','supervisor',TRUE);

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('client','ROLE_USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin','ROLE_ADMIN');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('user','ROLE_USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('supervisor','ROLE_USER');

INSERT INTO BLOG_POST (CONTENT, DRAFT, PUBLISHDATE, TITLE, USER_ID) VALUES ('Spring MVC tutorial',FALSE,NOW(),'Tutorial-1',1);
INSERT INTO BLOG_POST (CONTENT, DRAFT, PUBLISHDATE, TITLE, USER_ID) VALUES ('Java tutorial',TRUE,NOW(),'Tutorial-2',2);
INSERT INTO BLOG_POST (CONTENT, DRAFT, PUBLISHDATE, TITLE, USER_ID) VALUES ('Web tutorial',FALSE,NOW(),'Tutorial-3',3);