INSERT INTO CIDADE(IDCIDADE, NOME, UF) VALUES (1, 'Sapucaia do Sul', 'RS');

INSERT INTO MATERIAL(IDMATERIAL, DESCRICAO) VALUES (SEQ_material.nextval, 'Madeira de Pinho');

INSERT INTO SERVICO(IDSERVICO, DESCRICAO) VALUES (SEQ_servico.nextval, 'Carpintaria');

INSERT INTO CLIENTE
              (IDCLIENTE, NOME, CPF, EMAIL, ENDERECO, BAIRRO, IDCIDADE, CEP, SITUACAO) 
      VALUES (SEQ_cliente.nextval, 'Angelo', '00000000000', 'angelo.junior@cwi.com', 'Av. Luis Paster', 'Walderez', 1, 00000000, 'A');
      
INSERT INTO PEDIDO(IDPEDIDO, IDCLIENTE, DATAINCLUSAO, VALOR, SITUACAO)
      VALUES(SEQ_pedido.nextval, 1, '21/11/15', 10, 'A');
      
INSERT INTO PRODUTO(IDPRODUTO, IDSERVICO, IDMATERIAL, VALOR) VALUES (SEQ_produto.nextval, 1, 1, 10);
      
INSERT INTO ITEM(IDITEM, IDPEDIDO, IDPRODUTO, PESO, VALORUNITARIO, VALORDESCONTO, VALORTOTAL, SITUACAO)
       VALUES (SEQ_item.nextval, 1, 1, 10, 10, 10, 10, 'A');
       



