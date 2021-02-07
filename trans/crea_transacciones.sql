CREATE TABLE IGUAMA.TRANSACCIONES (
  ID_ORDEN 			INT 			NOT NULL,
  FECHA_CREACION 	DATETIME 		NOT NULL,
  ID_CLIENTE 		INT 			NOT NULL,
  NOMBRE_PRODUCTO 	VARCHAR(50) 	NOT NULL,
  MONTO_TOTAL 		DECIMAL(16,2) 	NOT NULL,
  MILLAS_GASTADAS 	DECIMAL(16,2)  	NOT NULL,
  TIPO_CAMBIO 		DECIMAL(7,4) L 	NOT NULL,
  PRIMARY KEY (ID_ORDEN));