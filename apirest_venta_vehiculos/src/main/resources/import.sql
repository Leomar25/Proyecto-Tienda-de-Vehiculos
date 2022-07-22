INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","M4 Competition Coupe",6.0,510.0,250.0,171.403,"2022-07-21",100);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","Serie 2 Active Tourer",6.0,170.0,625.0,37.350,"2022-07-21",25);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","X5",6.0,625.0,250.0,74.700,"2022-07-21",10);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","Serie 7",6.0,400.0,245.0,138.500,"2022-07-21",50);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","i3",2.0,170.0,150.0,40.700,"2022-07-21",10);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","X7",6.0,530.0,250.0,109.900,"2022-07-21",200);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","Aerie 1",3.0,306.0,250.0,31.550,"2022-07-21",10);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","X5",6.0,625.0,250.0,74.700,"2022-07-21",56);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","X6",8.0,625.0,250.0,86.600,"2022-07-21",13);
INSERT INTO vehiculos(marca,modelo,cilindrada,potencia,velocidad,pvp,fecharegistro,cantidad) VALUES ("BMW","iX",6.0,306.0,250.0,87.150,"2022-07-21",230);


INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Pedro","Pablo","pp@gmail.com","J29746401",658600868);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Maria","Hernandez","mh@gmail.com","L85246464",983921876);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("David","Nieto","dn@gmail.com","N95783476",981967941);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Rolando","Lopez","rl@gmail.com","D53889201",751971984);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Carlos","Iglesias","ci@gmail.com","G37197487",973600868);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Angela","Betancourt","ab@gmail.com","J13876549",944098987);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Luis","Angel","la@gmail.com","H95432765",978867097);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Grecia","Patiño","gp@gmail.com","Y29746401",971986123);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Begoña","Vargas","bv@gmail.com","Z5468721599",998971876);
INSERT INTO clientes(nombre,apellido,email,nif,telefono) VALUES ("Ana","Maria","am@gmail.com","N29746401",811799986);


INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (50,171.403);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (10,37.350);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (7,74.700);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (25,138.500);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (2,40.700);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (130,109.900);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (2,31.550);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (50,74.700);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (3,86.600);
INSERT INTO detalles_ventas(cantidad,precioventa) VALUES (100,87.150);

INSERT INTO pagos(monto,tipodepago) VALUES (171.403,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (37.350,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (74.700,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (138.500,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (40.700,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (109.900,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (31.550,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (74.700,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (86.600,"tarjeta de credito");
INSERT INTO pagos(monto,tipodepago) VALUES (87.150,"tarjeta de credito");

INSERT INTO ventas(total,fecha_venta) VALUES (50,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (10,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (7,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (25,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (2,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (130,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (2,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (50,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (3,"2022-09-13");
INSERT INTO ventas(total,fecha_venta) VALUES (100,"2022-09-13");



