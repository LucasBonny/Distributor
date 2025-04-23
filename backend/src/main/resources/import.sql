INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_SELLER');

INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Lucas Bonifacio','lucasbonnyb8@gmail.com','$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '01178715745','2001-05-13','61983333333', 0);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Gabriel Souza','gabrielsouza@gmail.com','$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '09909909900','1994-08-01','61940028922', 2);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Nicoly Raissa','nicolyraissa@gmail.com','$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '45655413312','2006-03-17','61999999999', 1);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Mariana Silva', 'marianasilva@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '32165498700', '1990-12-22', '61985554433', 3);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('João Pedro', 'joaopedro@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '78965412322', '1985-07-10', '61991112233', 0);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Ana Paula', 'anapaula@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '65498732111', '1998-04-05', '61982223344', 0);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Roberto Lima', 'robertolima@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '99887766555', '1979-11-18', '61993334455', 0);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Camila Costa', 'camilacosta@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '22334455677', '1995-02-25', '61984445566', 2);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Fernando Oliveira', 'fernandooliveira@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '55667788990', '1987-09-30', '61985556677', 1);
INSERT INTO tb_employee (name, email, password, cpf, birth_date, phone_number, status) VALUES ('Bianca Rocha', 'biancarocha@gmail.com', '$2a$10$fIIy2bG74RvnvSlHQ3HTYea0HSglL6aT.foYjitRC/EGafZQr.gNy', '11223344556', '2003-06-08', '61986667788', 0);

INSERT INTO tb_employee_role (employee_id, role_id) VALUES (1, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (1, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (2, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (3, 3);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (4, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (5, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (5, 3);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (6, 3);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (7, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (7, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (8, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (9, 3);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (10, 3);


INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('550e8400-e29b-41d4-a716-446655440001', '71640085', '45997418001710', '61984481420', 'St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF', 'Coca-Cola');
INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('550e8400-e29b-41d4-a716-446655440002', '72444220', '7526557000100', '61998493891', 'Área Especial de Indústria 2 Ambev - Gama, Brasília - DF', 'Ambev S.A.');
INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('550e8400-e29b-41d4-a716-446655440003', '38402324', '9248114000120', '3432283800', 'Av. José Andraus Gassani, 2795 - Distrito Industrial, Uberlândia - MG', 'Paratudo Bebidas');
INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('550e8400-e29b-41d4-a716-446655440004', '13098300', '12345678000199', '21987654321', 'Av. Presidente Vargas, 2000 - Centro, Rio de Janeiro - RJ', 'Distribuidora Rio Bebidas');
INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('550e8400-e29b-41d4-a716-446655440005', '04042000', '98765432000188', '1132658741', 'Rua Domingos de Morais, 1125 - Vila Mariana, São Paulo - SP', 'São Paulo Bebidas Ltda.');
INSERT INTO tb_supplier (id, cep, cnpj, phone_number, address, name) VALUES ('d27129a2-5a23-4c09-8e34-9f3e8b1b9d79', '72000000', '33445566000177', '11987654321', 'Rua das Indústrias, 500 - Centro, Belo Horizonte - MG', 'Minas Bebidas Ltda.');

INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES ('2', '2', CURRENT_TIMESTAMP);

INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES ('1', '1', '1', CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES ('2' ,'2', '2', CURRENT_TIMESTAMP);

INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock) VALUES ('845116286','Energético Monster Energy 473ml', '11.00', 'https://drogariasp.vteximg.com.br/arquivos/ids/435164-1000-1000/641693---energetico-monster-energy-473ml-spal.jpg?v=637496168469870000', '23');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock) VALUES ('823124633','Coca-Cola Original 350ml', '3.50', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRafBq8vt45nEcDZK3WBXpWw_2GC6qn9XmvhQ&s', '54');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (5.0, 40, '982341245', 'https://d21wiczbqxib04.cloudfront.net/CfoBHP57dDBCEZ0kBhSp6lOPy1s=/fit-in/453x453/filters:fill(FFFFFF):background_color(white)/https://produtos-osuper.s3.sa-east-1.amazonaws.com/934f78e66b9c78d0e284128058dc1eed5e32fb05/360/151757b3e7060-0.webp', 'Sprite 600ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (4.5, 30, '812345678', 'https://imgs.search.brave.com/pQQmln4P8enRt2-_VK-AM8kZUVS69V7I1xFaT99nYXE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMudGNkbi5jb20u/YnIvaW1nL2ltZ19w/cm9kLzg1ODc2NC8x/ODBfcmVmcmlnZXJh/bnRlX2ZhbnRhX2xh/cmFuamFfbGF0YV8z/NTBtbF9jXzA2XzEz/MDFfMV83N2Y4NWIw/ZDlmZDIyODQxNjk0/YjY1Mzg2YmU0MDQ4/Yi5qcGc', 'Fanta Laranja 350ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (6.0, 45, '734567890', 'https://imgs.search.brave.com/vMYpPtx5Vo81Km21r4nCV52IJMONFXxE7o90PQBhchk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdXBl/cm1lcmNhZG9zaW1w/ZXJhdHJpei52dGV4/aW1nLmNvbS5ici9h/cnF1aXZvcy9pZHMv/MTk3ODgxLTI5Mi0y/OTIvNzg5MTk5MTAw/MjY4NC0tLVJlZnJp/Z2VyYW50ZS1BTlRB/UkNUSUNBLUd1YXJh/bmEtWmVyby1HYXJy/YWZhLTYwME1MLS0t/MS5qcGc_dj02Mzg0/MDA3Nzc3NzU2MDAw/MDA', 'Guaraná Antarctica 600ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (8.5, 20, '945678123', 'https://imgs.search.brave.com/-2OO98jAUXsBhQqbuY1X3T5SEnOGKRpCRXa-eYhhyko/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFsRXJYaXpsV0wu/anBn', 'Pepsi 2L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (12.0, 15, '874562314', 'https://imgs.search.brave.com/GOSjLVep3FN5fVnCnJAl2-xlmGPC2H0SoIAsvrCqFiI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/cHJvdGVpbmNvbXBh/bnkuZmkvaW1nL2Jp/bGRlci9hcnRpa2xh/ci96b29tL1BCLTg5/ODdfMS5qcGc_bT0x/NzM2NDIxNjM5', 'Red Bull Energy Drink 250ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (9.0, 25, '735612098', 'https://imgs.search.brave.com/MyLJ2F31bqfMsmfD_n8ZJuOQxSRnm-GuOLSsW-DV9mU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/aW1pZ3JhbnRlc2Jl/YmlkYXMuY29tLmJy/L2ltZy9iZWJpZGEv/aW1hZ2VzL3Byb2R1/Y3RzL2Z1bGwvMjM4/OS1zY2h3ZXBwZXMt/Y2l0cnVzLTI1MG1s/LmpwZz9zPTUzMTJl/YWQ0NzEzYWQ4NjVm/M2E0MzZlYmZkZTcy/NTIw', 'Schweppes Citrus 1L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (7.0, 32, '956341278', 'https://imgs.search.brave.com/KqPOKzDb8SYH3wsbM9Cs5R5GBH8MFFQeGOITZH0P5rs/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NTFzbnZCM3JnSkwu/anBn', 'Itubaína Retrô 1.5L');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (14.0, 18, '675123490', 'https://imgs.search.brave.com/HCbpjW0L-7xdwU3q6M5pIy3oBeKyfliDg4sk9a6nC5c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NTFZMjFPZ3pYM1Mu/anBn', 'Energético TNT 269ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (3.0, 60, '812678345', 'https://imgs.search.brave.com/rpSpSkoKtYV4j9C5pfmafNzQ93Pbjnyg2h7CuGqlaQE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/MzFKb0N1Skx3dkwu/anBn', 'Água Mineral com Gás 500ml');
INSERT INTO TB_PRODUCT (price, stock, bar_code, img_url, name) VALUES (10.0, 22, '945612347', 'https://imgs.search.brave.com/Ve04XVruGlxi4ID81jGSaHFCi74tArQrscEP-nrJMAs/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/aW1pZ3JhbnRlc2Jl/YmlkYXMuY29tLmJy/L2ltZy9iZWJpZGEv/aW1hZ2VzL3Byb2R1/Y3RzL2Z1bGwvMjIz/LWNlcnZlamEtaGVp/bmVrZW4tNjAwbWwt/bmFvLXJldG9ybmF2/ZWwuMjAyNTAzMjAx/MDU4NDcuanBnP3A9/cHJvZHVjdF9yZWd1/bGFyJnM9ODY0MTU2/ZWFjY2IwYjg2YTVj/ZmE0ZGFmOWFiMDA3/ZGI', 'Cerveja Heineken Long Neck 330ml');

INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('151.00','6','823124633','1');
INSERT INTO  tb_sale_item (price, quantity, product_id, sale_id) VALUES ('842.00','4','845116286','2');

INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('200.00', '23', CURRENT_TIMESTAMP, '845116286', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('320.00', '54', CURRENT_TIMESTAMP, '823124633', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('480.00', '18', CURRENT_TIMESTAMP, '675123490', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('120.00', '45', CURRENT_TIMESTAMP, '734567890', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('700.00', '25', CURRENT_TIMESTAMP, '735612098', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('70.00', '30', CURRENT_TIMESTAMP, '812345678', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('60.00', '60', CURRENT_TIMESTAMP, '812678345', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('90.00', '15', CURRENT_TIMESTAMP, '874562314', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('170.00', '22', CURRENT_TIMESTAMP, '945612347', '550e8400-e29b-41d4-a716-446655440005');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('80.00', '20', CURRENT_TIMESTAMP, '945678123', '550e8400-e29b-41d4-a716-446655440005');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('280.00', '32', CURRENT_TIMESTAMP, '956341278', '550e8400-e29b-41d4-a716-446655440005');
INSERT INTO tb_supplier_product (price, quantity, date_delivery, tb_product, tb_supplier) VALUES ('230.00', '40', CURRENT_TIMESTAMP, '982341245', '550e8400-e29b-41d4-a716-446655440005');
