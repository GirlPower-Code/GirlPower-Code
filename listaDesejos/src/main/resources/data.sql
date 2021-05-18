INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Caroline Ribeiro', '12883424462', '17/07/1999','94449195', 'carol@gmail.com', 'senha123');
INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Alice Pizetta', '14785236987', '25/05/2000','91952328', 'alice@gmail.com', 'senha123');
INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Jacqueline Sales', '21458963774', '01/08/1990','93072327', 'jack@gmail.com', 'senha123');
INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Raissa Vieira', '74185296354', '14/07/2001','91107299', 'raissa@gmail.com', 'senha123');
INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Juliany Moraisa', '54800956099', '10/04/2001','91103890', 'juliany@gmail.com', 'senha123');
INSERT INTO client (name, cpf, birthday, number, email, password) VALUES ('Sthephani Monteiro', '80442716001', '28/03/1995','91259301', 'sthe@gmail.com', 'senha123');

INSERT INTO product (name, price, description) VALUES ('Sofá', '2050.00', 'Design moderno e cor que combina facilmente com estilos variados de decorações.');
INSERT INTO product (name, price, description) VALUES ('Iphone XR', '3700.00', 'O iPhone XR tem tela Liquid Retina de 6,1 polegadas** e seis lindas cores.');
INSERT INTO product (name, price, description) VALUES ('Armário', '3500.00', 'Design moderno e cor que combina facilmente com estilos variados de decorações.');
INSERT INTO product (name, price, description) VALUES ('Panela Inox', '130.00', 'Facilita o cozimento dos seus alimentos.');
INSERT INTO product (name, price, description) VALUES ('Churrasqueira', '300.00', 'Portátil e fácil de manusear.');
INSERT INTO product (name, price, description) VALUES ('Sanduicheira', '50.00', 'Prepara o seu café da manhã com mais facilidade.');

INSERT INTO wishlist (id_client) VALUES (1);
INSERT INTO wishlist (id_client) VALUES (2);
INSERT INTO wishlist (id_client) VALUES (3);
INSERT INTO wishlist (id_client) VALUES (4);
INSERT INTO wishlist (id_client) VALUES (5);
INSERT INTO wishlist (id_client) VALUES (6);

INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (1, 2);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (1, 5);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (2, 1);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (2, 4);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (3, 5);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (3, 3);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (4, 5);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (4, 6);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (5, 1);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (5, 2);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (6, 2);
INSERT INTO wishlist_product (wish_list_id, product_id) VALUES (6, 6);



