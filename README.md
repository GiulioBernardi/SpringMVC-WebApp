# SpringMVC-WebApp
CRUD de ingrediente com Spring mvc para fazer deploy na Azure Webapp

## Como rodar o projeto

Abra o Eclipse e selecione 'importar projeto' > selecione Git e copie a Url desse repositório.

1 - Abra o arquivo ```application.properties``` e altere as linhas 2 e 3 (username e password)
<p align="center">
  <img width="50%" src="https://user-images.githubusercontent.com/54187661/188524539-7005ca1c-2eaa-4cdc-bcec-4fbbde9dbbc4.png" />
</p>

 2 - Abra o arquivo ```pom.xml``` <br>Altere a versão do java ```<java.version>17</java.version>``` <br>
para: ```<java.version>11</java.version>```
<p align="center">
  <img width="50%" src="https://user-images.githubusercontent.com/54187661/188727843-b55d72fe-aeb8-4954-b2f0-c270ca0b4ee2.png" />
</p>


Faça o deploy da aplicação usando Azure Web App utilizando o plugin da Azure no Eclipse

```
-- ATENÇÃO:
-- Se você estiver aqui, é porque você vai rodar no seu próprio banco de dados
-- Rode os comandos SQL em ordem numérica especificada com um comentário

-- 1
CREATE SEQUENCE sq_tb_ingrediente
    start with 1 --começa com 1
    increment by 1 --incrementa 1
    nocache -- para não manter o valor anterior da sequencia em cache
    nocycle; --para não aumentar o tamanho máximo da sequencia
 
--2
CREATE TABLE tb_ingrediente_bright(	
    cd_ingrediente NUMBER(5) primary key, 
    nm_ingrediente VARCHAR2(255 CHAR) NOT NULL, 
    qtd_ingrediente number(5,2),
    tp_ingrediente VARCHAR2(255 CHAR),
    ds_marca_ingrediente VARCHAR2(55 CHAR)
);

--Opcional
select * from tb_ingrediente_bright;
desc tb_ingrediente_bright;
insert into tb_ingrediente_bright values (sq_tb_ingrediente.nextval, 'arroz', 1, 'grão', 'carrefour');
drop table tb_ingrediente_bright cascade constraints;
```
