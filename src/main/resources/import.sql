INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Lucas Bonifacio','lucasbonnyb8@gmail.com','123456', '01178715745','2001-05-13','61983333333');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Gabriel Souza','gabrielsouza@gmail.com','123456', '09909909900','1994-08-01','61940028922');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Nicoly Raissa','nicolyraissa@gmail.com','123456', '45655413312','2006-03-17','61999999999');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Mariana Silva', 'marianasilva@gmail.com', '123456', '32165498700', '1990-12-22', '61985554433');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('João Pedro', 'joaopedro@gmail.com', '123456', '78965412322', '1985-07-10', '61991112233');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Ana Paula', 'anapaula@gmail.com', '123456', '65498732111', '1998-04-05', '61982223344');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Roberto Lima', 'robertolima@gmail.com', '123456', '99887766555', '1979-11-18', '61993334455');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Camila Costa', 'camilacosta@gmail.com', '123456', '22334455677', '1995-02-25', '61984445566');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Fernando Oliveira', 'fernandooliveira@gmail.com', '123456', '55667788990', '1987-09-30', '61985556677');
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number) VALUES ('Bianca Rocha', 'biancarocha@gmail.com', '123456', '11223344556', '2003-06-08', '61986667788');

INSERT INTO tb_supplier (cep, cnpj, phone_number, address, name) VALUES ('71640085', '45997418001710', '61984481420', 'St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF', 'Coca-Cola');
INSERT INTO tb_supplier (cep, cnpj, phone_number, address, name) VALUES ('72444220', '7526557000100', '61998493891', 'Área Especial de Indústria 2 Ambev - Gama, Brasília - DF', 'Ambev S.A.');
INSERT INTO tb_supplier (cep, cnpj, phone_number, address, name) VALUES ('38402324', '9248114000120', '3432283800', 'Av. José Andraus Gassani, 2795 - Distrito Industrial, Uberlândia - MG', 'Paratudo Bebidas');
INSERT INTO tb_supplier (cep, cnpj, phone_number, address, name) VALUES ('13098300', '12345678000199', '21987654321', 'Av. Presidente Vargas, 2000 - Centro, Rio de Janeiro - RJ', 'Distribuidora Rio Bebidas');
INSERT INTO tb_supplier (cep, cnpj, phone_number, address, name) VALUES ('04042000', '98765432000188', '1132658741', 'Rua Domingos de Morais, 1125 - Vila Mariana, São Paulo - SP', 'São Paulo Bebidas Ltda.');

INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('2', '2', CURRENT_TIMESTAMP);

INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES ('1', '1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES ('2' ,'2', '2', CURRENT_TIMESTAMP);

INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock) VALUES ('845116286','Energético Monster Energy 473ml', '11.00', 'https://raw.githubusercontent.com/LucasBonny/Distributor/e404470b56559931b6d677bf0a8956adbfb758b6/src/main/11465.png?token=A5KWRKHP7CLGN5DME5VDRA3HGXDVG', '23');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock) VALUES ('823124633','Coca-Cola Original 350ml', '3.50', 'https://raw.githubusercontent.com/LucasBonny/Distributor/e404470b56559931b6d677bf0a8956adbfb758b6/src/main/11464.png?token=A5KWRKBSSXVSZNG2YUH6GP3HGXDVG', '54');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (5.0, 40, '982341245', 'https://example.com/image1.png', 'Sprite 600ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (4.5, 30, '812345678', 'https://example.com/image2.png', 'Fanta Laranja 350ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (6.0, 45, '734567890', 'https://example.com/image3.png', 'Guaraná Antarctica 600ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (8.5, 20, '945678123', 'https://example.com/image4.png', 'Pepsi 2L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (12.0, 15, '874562314', 'https://example.com/image5.png', 'Red Bull Energy Drink 250ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (9.0, 25, '735612098', 'https://example.com/image6.png', 'Schweppes Citrus 1L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (7.0, 32, '956341278', 'https://example.com/image7.png', 'Itubaína Retrô 1.5L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (14.0, 18, '675123490', 'https://example.com/image8.png', 'Energético TNT 269ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (3.0, 60, '812678345', 'https://example.com/image9.png', 'Água Mineral com Gás 500ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (10.0, 22, '945612347', 'https://example.com/image10.png', 'Cerveja Heineken Long Neck 330ml');


INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('151.00','6','823124633','1');
INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('842.00','4','845116286','2');

INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('200.00', '23', CURRENT_TIMESTAMP, '845116286', '45997418001710');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('320.00', '54', CURRENT_TIMESTAMP, '823124633', '45997418001710');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('480.00', '18', CURRENT_TIMESTAMP, '675123490', '7526557000100');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('120.00', '45', CURRENT_TIMESTAMP, '734567890', '7526557000100');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('700.00', '25', CURRENT_TIMESTAMP, '735612098', '7526557000100');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('70.00', '30', CURRENT_TIMESTAMP, '812345678', '9248114000120');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('60.00', '60', CURRENT_TIMESTAMP, '812678345', '12345678000199');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('90.00', '15', CURRENT_TIMESTAMP, '874562314', '12345678000199');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('170.00', '22', CURRENT_TIMESTAMP, '945612347', '98765432000188');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('80.00', '20', CURRENT_TIMESTAMP, '945678123', '98765432000188');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('280.00', '32', CURRENT_TIMESTAMP, '956341278', '98765432000188');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('230.00', '40', CURRENT_TIMESTAMP, '982341245', '98765432000188');

