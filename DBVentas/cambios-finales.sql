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



