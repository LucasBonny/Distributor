INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Lucas Bonifacio','lucasbonnyb8@gmail.com','123456', '01178715745','2001-05-13','61983333333');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Gabriel Souza','gabrielsouza@gmail.com','123456', '09909909900','1994-08-01','61940028922');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Nicoly Raissa','nicolyraissa@gmail.com','123456', '45655413312','2006-03-17','61999999999');

INSERT INTO tb_supplier (name, cnpj, address, cep, phone_number) VALUES ('Coca-Cola', '45997418001710','St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF','71640085', '61984481420');
INSERT INTO tb_supplier (name, cnpj, address, cep, phone_number) VALUES ('Ambev S.A.', '07526557000100','Área Especial de Indústria 2 Ambev - Gama, Brasília - DF','72444220', '61998493891');
INSERT INTO tb_supplier (name, cnpj, address, cep, phone_number) VALUES ('Paratudo Bebidas', '09248114000120','Av. José Andraus Gassani, 2795 - Distrito Industrial, Uberlândia - MG','38402324', '3432283800');

INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('2', '2', CURRENT_TIMESTAMP);

INSERT INTO tb_payments (payment_status, payment_method, sale_id, moment) VALUES ('1', '1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_payments (payment_status, payment_method, sale_id, moment) VALUES ('2' ,'2', '2', CURRENT_TIMESTAMP);

INSERT INTO tb_product (bar_code, name, price, img_url, stock) VALUES ('845116286','Energético Monster Energy 473ml', '11.00', 'https://raw.githubcontent.com/lucasbonny/Distributor/11465.png', '23');
INSERT INTO tb_product (bar_code, name, price, img_url, stock) VALUES ('823124633','Coca-Cola Original 350ml', '3.50', 'https://raw.githubcontent.com/lucasbonny/Distributor/11464.png', '54');

INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('151.00','6','823124633','1');
INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('842.00','4','845116286','2');

INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('200.00', '4', CURRENT_TIMESTAMP, '845116286', '1');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('320.00', '2', CURRENT_TIMESTAMP, '823124633', '2');

