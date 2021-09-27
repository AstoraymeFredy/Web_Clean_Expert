INSERT INTO tipousuario (nombre) VALUES ('Cliente');
INSERT INTO tipousuario (nombre) VALUES ('Personal de limpieza');

INSERT INTO usuario (password,username,idtipousuario) VALUES ('us1','AnaT',1);
INSERT INTO usuario (password,username,idtipousuario) VALUES ('us2','JuanC',1);
INSERT INTO usuario (password,username,idtipousuario) VALUES ('us3','PedroM',2);
INSERT INTO usuario (password,username,idtipousuario) VALUES ('us4','MartaP',2);


INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Torres Arias',978563412,'torresA@gmail.com','Ana',1);
INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Castillo Flores',975372412,'Juan1234@gmail.com','Juan',2);

INSERT INTO personallimpieza (apellidos,celular,descripcion,edad,email,nombre,id_usuario) VALUES ('Paz Jara',918173446,'especialista en limpieza de suelo laminado',34,'12345MP@gmail.com','Marta',4);
INSERT INTO personallimpieza (apellidos,celular,descripcion,edad,email,nombre,id_usuario) VALUES ('Muñoz Acosta',912433412,'10 años de experiencia en limpieza',39,'pedro123@gmail.com','Pedro',3);

INSERT INTO ambiente (nombre) VALUES ('Dormitorio');
INSERT INTO ambiente (nombre) VALUES ('Comedor');
INSERT INTO ambiente (nombre) VALUES ('Cocina');
INSERT INTO ambiente (nombre) VALUES ('Biblioteca');
INSERT INTO ambiente (nombre) VALUES ('Baño');
INSERT INTO ambiente (nombre) VALUES ('Sala');



INSERT INTO distrito (nombre) VALUES ('Ancon');
INSERT INTO distrito (nombre) VALUES ('Ate');
INSERT INTO distrito (nombre) VALUES ('Barranco');
INSERT INTO distrito (nombre) VALUES ('Breña');
INSERT INTO distrito (nombre) VALUES ('Carabayllo');
INSERT INTO distrito (nombre) VALUES ('Chaclacayo');
INSERT INTO distrito (nombre) VALUES ('Chorrillos');
INSERT INTO distrito (nombre) VALUES ('Cieneguilla');
INSERT INTO distrito (nombre) VALUES ('Comas');
INSERT INTO distrito (nombre) VALUES ('El Agustino');
INSERT INTO distrito (nombre) VALUES ('Independencia');
INSERT INTO distrito (nombre) VALUES ('Jesús María');
INSERT INTO distrito (nombre) VALUES ('La Molina');
INSERT INTO distrito (nombre) VALUES ('La Victoria');
INSERT INTO distrito (nombre) VALUES ('Lima');
INSERT INTO distrito (nombre) VALUES ('Lince');
INSERT INTO distrito (nombre) VALUES ('Los Olivos');
INSERT INTO distrito (nombre) VALUES ('Lurigancho');
INSERT INTO distrito (nombre) VALUES ('Lurín');
INSERT INTO distrito (nombre) VALUES ('Magdalena del Mar');
INSERT INTO distrito (nombre) VALUES ('Miraflores');
INSERT INTO distrito (nombre) VALUES ('Pachacamac');
INSERT INTO distrito (nombre) VALUES ('Pucusana');
INSERT INTO distrito (nombre) VALUES ('Pueblo Libre');
INSERT INTO distrito (nombre) VALUES ('Puente Piedra');
INSERT INTO distrito (nombre) VALUES ('Punta Hermosa');
INSERT INTO distrito (nombre) VALUES ('Punta Negra');
INSERT INTO distrito (nombre) VALUES ('Rimac');
INSERT INTO distrito (nombre) VALUES ('San Bartolo');
INSERT INTO distrito (nombre) VALUES ('San Borja');
INSERT INTO distrito (nombre) VALUES ('San Isidro');
INSERT INTO distrito (nombre) VALUES ('San Juan de Lurigancho');
INSERT INTO distrito (nombre) VALUES ('San Juan de Miraflores');
INSERT INTO distrito (nombre) VALUES ('San Luis');
INSERT INTO distrito (nombre) VALUES ('San Martín de Porres');
INSERT INTO distrito (nombre) VALUES ('San Miguel');
INSERT INTO distrito (nombre) VALUES ('Santa Anita');
INSERT INTO distrito (nombre) VALUES ('Santa María del Mar');
INSERT INTO distrito (nombre) VALUES ('Santa Rosa');
INSERT INTO distrito (nombre) VALUES ('Santiago de Surco');
INSERT INTO distrito (nombre) VALUES ('Surquillo');
INSERT INTO distrito (nombre) VALUES ('Villa El Salvador');
INSERT INTO distrito (nombre) VALUES ('Villa María del Triunfo');


