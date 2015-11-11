CREATE TABLE dbo.Selo
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL UNIQUE
)

GO

INSERT INTO SELO(Id, Descricao) VALUES (1, 'Bronze');
INSERT INTO SELO(Id, Descricao) VALUES (2, 'Prata');
INSERT INTO SELO(Id, Descricao) VALUES (3, 'Ouro');

GO


