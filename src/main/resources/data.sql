-- Catalogue

insert into CATALOGUE (id, name) values (1, 'LECLERCQ');

-- Stocks of Article

insert into ARTICLE (id, name, price) values (1, 'pomme', 1);
insert into STOCK (id, quantity, catalogue_id, article_id) values (1, 130, 1, 1);

insert into ARTICLE (id, name, price) values (2, 'jambon', 4);
insert into STOCK (id, quantity, catalogue_id, article_id) values (2, 200, 1, 2);

insert into ARTICLE (id, name, price) values (3, 'paquet de riz', 3);
insert into STOCK (id, quantity, catalogue_id, article_id) values (3, 100, 1, 3);

insert into ARTICLE (id, name, price) values (4, 'mozarella', 3);
insert into STOCK (id, quantity, catalogue_id, article_id) values (4, 0, 1, 4);

insert into ARTICLE (id, name, price) values (5, 'téléphone', 400);
insert into STOCK (id, quantity, catalogue_id, article_id) values (5, 90, 1, 5);

insert into ARTICLE (id, name, price) values (6, 'machine à laver', 800);
insert into STOCK (id, quantity, catalogue_id, article_id) values (6, 18, 1, 6);

insert into ARTICLE (id, name, price) values (7, 'empty', 500);
insert into STOCK (id, quantity, catalogue_id, article_id) values (7, 0, 1, 7);

-- Reductions

insert into REDUCTION (id, percent, number_of_use) values (1, 80, 2);
insert into REDUCTION (id, percent, number_of_use) values (2, 50, 2);
insert into REDUCTION (id, percent, number_of_use) values (3, 20, 2);
insert into REDUCTION (id, percent, number_of_use) values (4, 10, 2);
insert into REDUCTION (id, percent, number_of_use) values (5, 0, 2);

-- Clients

insert into CLIENT (id, login, passwd, money, role, reduction_id) values (1, 'antoine', 'mortelier', 1000, 'admin', 1);
insert into CLIENT (id, login, passwd, money, role, reduction_id) values (2, 'alexandre', 'janaszek', 500, 'client', 2);
insert into CLIENT (id, login, passwd, money, role, reduction_id) values (3, 'cathy', 'houdart', 300, 'client', 3);
insert into CLIENT (id, login, passwd, money, role, reduction_id) values (4, 'logan', 'chenavier', 200, 'client', 4);
insert into CLIENT (id, login, passwd, money, role, reduction_id) values (5, 'pierre', 'mullier', 100, 'client', 5);