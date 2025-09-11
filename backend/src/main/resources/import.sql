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

INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('823124633','Coca-Cola Original 350ml', 3.50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRafBq8vt45nEcDZK3WBXpWw_2GC6qn9XmvhQ&s', 200, true, '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('982341245', 'Sprite 600ml', 5.00, 'https://d21wiczbqxib04.cloudfront.net/CfoBHP57dDBCEZ0kBhSp6lOPy1s=/fit-in/453x453/filters:fill(FFFFFF):background_color(white)/https://produtos-osuper.s3.sa-east-1.amazonaws.com/934f78e66b9c78d0e284128058dc1eed5e32fb05/360/151757b3e7060-0.webp', 150, true, '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('812345678', 'Fanta Laranja 350ml', 3.50, 'https://imgs.search.brave.com/pQQmln4P8enRt2-_VK-AM8kZUVS69V7I1xFaT99nYXE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMudGNkbi5jb20u/YnIvaW1nL2ltZ19w/cm9kLzg1ODc2NC8x/ODBfcmVmcmlnZXJh/bnRlX2ZhbnRhX2xh/cmFuamFfbGF0YV8z/NTBtbF9jXzA2XzEz/MDFfMV83N2Y4NWIw/ZDlmZDIyODQxNjk0/YjY1Mzg2YmU0MDQ4/Yi5qcGc', 180, true, '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('945612347', 'Cerveja Heineken Long Neck 330ml', 10.00, 'https://imgs.search.brave.com/Ve04XVruGlxi4ID81jGSaHFCi74tArQrscEP-nrJMAs/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/aW1pZ3JhbnRlc2Jl/YmlkYXMuY29tLmJy/L2ltZy9iZWJpZGEv/aW1hZ2VzL3Byb2R1/Y3RzL2Z1bGwvMjIz/LWNlcnZlamEtaGVp/bmVrZW4tNjAwbWwt/bmFvLXJldG9ybmF2/ZWwuMjAyNTAzMjAx/MDU4NDcuanBnP3A9/cHJvZHVjdF9yZWd1/bGFyJnM9ODY0MTU2/ZWFjY2IwYjg2YTVj/ZmE0ZGFmOWFiMDA3/ZGI', 300, true, '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('734567890', 'Guaraná Antarctica 600ml', 6.00, 'https://imgs.search.brave.com/vMYpPtx5Vo81Km21r4nCV52IJMONFXxE7o90PQBhchk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdXBl/cm1lcmNhZG9zaW1w/ZXJhdHJpei52dGV4/aW1nLmNvbS5ici9h/cnF1aXZvcy9pZHMv/MTk3ODgxLTI5Mi0y/OTIvNzg5MTk5MTAw/MjY4NC0tLVJlZnJp/Z2VyYW50ZS1BTlRB/UkNUSUNBLUd1YXJh/bmEtWmVyby1HYXJy/YWZhLTYwME1MLS0t/MS5qcGc_dj02Mzg0/MDA3Nzc3NzU2MDAw/MDA', 250, true, '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('123456789', 'Cachaça Paratudo 965ml', 15.50, 'https://adegabroficial.com.br/wp-content/uploads/2021/03/PARATUDO.jpg', 80, true, '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO TB_PRODUCT (bar_code, name, price, img_url, stock, active, supplier_id) VALUES ('845116286','Energético Monster Energy 473ml', 11.00, 'https://drogariasp.vteximg.com.br/arquivos/ids/435164-1000-1000/641693---energetico-monster-energy-473ml-spal.jpg?v=637496168469870000', 120, true, '550e8400-e29b-41d4-a716-446655440001');

INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (2, 2, CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (1, 3, CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (2, 4, CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (1, 5, CURRENT_TIMESTAMP);
INSERT INTO tb_sale (sale_status, employee_id, sale_moment) VALUES (2, 6, CURRENT_TIMESTAMP);

INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (2, 2, 2, CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (1, 1, 3, CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (2, 2, 4, CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (1, 1, 5, CURRENT_TIMESTAMP);
INSERT INTO tb_payment (payment_status, payment_method, sale_id, moment) VALUES (2, 2, 6, CURRENT_TIMESTAMP);

INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (11.00, 6, 7, 1); -- 6x Monster Energy
INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (10.00, 12, 4, 2); -- 12x Heineken
INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (3.50, 24, 1, 3); -- 24x Coca-Cola
INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (15.50, 5, 6, 4); -- 5x Cachaça Paratudo
INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (5.00, 10, 2, 5); -- 10x Sprite
INSERT INTO tb_sale_item (price, quantity, product_id, sale_id) VALUES (6.00, 8, 5, 6); -- 8x Guaraná Antarctica

INSERT INTO tb_delivery (id, delivery_date, supplier_id) VALUES (1, '2025-09-01 10:00:00', '550e8400-e29b-41d4-a716-446655440001'); -- Entrega da Coca-Cola
INSERT INTO tb_delivery (id, delivery_date, supplier_id) VALUES (2, '2025-09-02 11:30:00', '550e8400-e29b-41d4-a716-446655440002'); -- Entrega da Ambev
INSERT INTO tb_delivery (id, delivery_date, supplier_id) VALUES (3, '2025-09-03 09:00:00', '550e8400-e29b-41d4-a716-446655440003'); -- Entrega da Paratudo

INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (1, 1, 100, 2.50); -- 100x Coca-Cola para a entrega 1
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (1, 2, 80, 3.80);  -- 80x Sprite para a entrega 1
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (1, 3, 80, 2.50);  -- 80x Fanta para a entrega 1
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (1, 7, 50, 8.00);  -- 50x Monster para a entrega 1
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (2, 4, 150, 7.50); -- 150x Heineken para a entrega 2
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (2, 5, 120, 4.50); -- 120x Guaraná para a entrega 2
INSERT INTO tb_delivery_item (delivery_id, product_id, quantity, unit_price) VALUES (3, 6, 40, 11.00); -- 40x Cachaça Paratudo para a entrega 3