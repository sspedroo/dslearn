INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '$2a$12$86oQHuRS6kdDkW5IncdCP.iHS2IuqnUWvngRl/d3DTrRlDXdkcg46');
INSERT INTO tb_user (name, email, password) VALUES ('Dora', 'dora@gmail.com', '$2a$12$86oQHuRS6kdDkW5IncdCP.iHS2IuqnUWvngRl/d3DTrRlDXdkcg46');
INSERT INTO tb_user (name, email, password) VALUES ('Pedro', 'pedro@gmail.com', '$2a$12$86oQHuRS6kdDkW5IncdCP.iHS2IuqnUWvngRl/d3DTrRlDXdkcg46');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,3);