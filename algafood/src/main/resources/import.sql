-- KITCHEN

insert into kitchen (name) values ('thailand')
insert into kitchen (name) values ('indian')
insert into kitchen (name) values ('japanese')

-- RESTAURANT

insert into Restaurant(name, delivery_tax, kitchen_id) values('Thai Gourmet', 10, 1);
insert into Restaurant(name, delivery_tax, kitchen_id) values('Thai delivery', 9.50, 1);
insert into Restaurant(name, delivery_tax, kitchen_id) values('Tuk Tuk Indian Food', 15, 2);

-- PAYMENT METHOD

insert into Payment_Method (description) values('credit')
insert into Payment_Method (description) values('debit')
insert into Payment_Method (description) values('money')
insert into Payment_Method (description) values('pix')

-- PERMISSION

insert into Permission(name, description) values('felipe', 'admin permission')
insert into Permission(name, description) values('gustavo', 'user permission')
insert into Permission(name, description) values('mariana', 'read only permission')
insert into Permission(name, description) values('julia', 'read permission')

-- STATE

insert into State(name) values('Rio de Janeiro')
insert into State(name) values('Sao paulo')

-- CITY

insert into City(name, state_id) values('marica', 1)
insert into City(name, state_id) values('saquarema', 1)
insert into City(name, state_id) values('ubatuba', 2)