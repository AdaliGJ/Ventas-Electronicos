CREATE OR REPLACE VIEW INFOCLIENTE
AS select cs."NIT" idcliente ,cs."TIPO_CLIENTE" tipocliente,cs."NOMBRE_TIPO_CLIENTE" nombretipocliente, fc.patente_de_comercio patente,fc.fecha_de_vencimiento vencimiento, fc.nombre nombrecliente, fc.nit from (select c.nit, c.tipo_cliente, tc.nombre nombre_tipo_cliente from clientes c inner join tipo_clientes tc on c.tipo_cliente=tc.id) cs inner join fichas_clientes fc on fc.nit = cs.nit;


create or replace procedure clientesuscrito 
(
  nid in number 
, naccion in number
, nfecha in VARCHAR2
) as 
begin

  declare idv int;
  begin
  
      IF naccion = 2 then
        delete from fichas_clientes where nit = nid;
        delete from clientes where nit = nid;
      Else
        update fichas_clientes set fecha_de_vencimiento = nfecha where nit = nid;
      end if;
  end;
  
  commit;
end clientesuscrito;

create or replace function deuda 
(
  nnit in number 
) return number as 
begin
    declare idv number;
  begin
    select sum(TO_NUMBER(Replace(precio, '.', ','))) into idv from ordenes_compra where id_cliente = nnit and credito = 1;
  return idv;
  
  end;
end deuda;


create or replace NONEDITIONABLE procedure insertarinv 
(
  ncategoria in int 
, nmarca in int
, nexistencias in int 
, npreciolista in varchar2
, ncolor in VARCHAR2
, ndescripcion in varchar2 
, nmodelo in VARCHAR2
, ngarantia in int
, nresolucion in varchar2
, nbits in int
, npantalla in int
, nhdmi in int
, nso in varchar2
, nram in int
, nmemoria in int
, njugadores in int
, ngraficos in varchar2
, nconsola in varchar2
, naccion in varchar2
, nimg1 in varchar2
, nimg2 in varchar2
, nimg3 in VARCHAR2
) as
begin

    declare idv int;
            idv2 int;
            contar1 int;
            contar2 int;
    begin
        IF naccion = 'ins' THEN
         select count(*) into contar1 from inventario;
         select count(*) into contar2 from imagenes_dispositivos;
         
         IF contar1 = 0 THEN
              select count(*) into idv from inventario;
         ELSE
             select id_inventario into idv FROM inventario ORDER BY id_inventario desc FETCH NEXT 1 ROWS ONLY;
           
         END IF;
         
         IF contar2 = 0 THEN
              select count(*) into idv2 from imagenes_dispositivos;
         ELSE
             select id_imagen into idv2 FROM imagenes_dispositivos ORDER BY id_imagen desc FETCH NEXT 1 ROWS ONLY;
         END IF;
         
         
         insert into inventario(id_inventario, categoria_dispositivo, marca, existencias, precio_lista, color, descripcion, modelo, meses_garantia)
                values(idv+1, ncategoria, nmarca, nexistencias, TO_NUMBER(Replace(npreciolista, '.',',')), ncolor, ndescripcion, nmodelo, ngarantia);         
         
         insert into imagenes_dispositivos(id_imagen, id_inventario, imagen)
                values(idv2+1,idv+1, nimg1); 
          insert into imagenes_dispositivos(id_imagen,id_inventario, imagen)
                values(idv2+2,idv+1, nimg2); 
          insert into imagenes_dispositivos(id_imagen,id_inventario, imagen)
                values(idv2+3,idv+1, nimg3); 
                
             IF ncategoria = 1 THEN
                insert into televisores(id_inventario, resolucion, bits_profundidad, pulgadas_pantalla, entradas_hdmi)
                values(idv+1, nresolucion, nbits, npantalla, nhdmi);
            ELSIF ncategoria = 2 THEN
                insert into videojuegos(id_inventario, max_jugadores, graficos, consola)
                values(idv+1, njugadores, ngraficos, nconsola);
            ELSIF ncategoria = 3 THEN
                insert into smartwatch(id_inventario, pulgadas_pantalla, sistema_operativo, ram_mb, memoria_gb)
                values(idv+1, npantalla, nso, nram, nmemoria);
            END IF;
            
        ELSIF naccion = 'del' THEN
            null;
        ELSIF naccion = 'up' THEN
            null;
        END IF;
    end;
    
    commit;
  
end insertarinv;

CREATE TABLE MAPEOTABLA 
(
  IDINVENTARIO INT NOT NULL 
, IDFABRICA VARCHAR2(30) NOT NULL 
, MARCA INT NOT NULL 
, CONSTRAINT MAPEOTABLA_PK PRIMARY KEY 
  (
    IDINVENTARIO 
  )
  ENABLE 
);


ALTER TABLE MAPEOTABLA 
DROP CONSTRAINT MAPEOTABLA_FK1;

ALTER TABLE MAPEOTABLA 
DROP CONSTRAINT MAPEOTABLA_FK2;

ALTER TABLE MAPEOTABLA
ADD CONSTRAINT MAPEOTABLA_FK3 FOREIGN KEY
(
  IDINVENTARIO 
)
REFERENCES INVENTARIO
(
  ID_INVENTARIO 
)
ENABLE;

ALTER TABLE MAPEOTABLA
ADD CONSTRAINT MAPEOTABLA_FK4 FOREIGN KEY
(
  MARCA 
)
REFERENCES MARCAS
(
  ID_MARCA 
)
ENABLE;



