DROP TABLE TODOITEM IF EXISTS;
CREATE TABLE TODOITEM(ID IDENTITY PRIMARY KEY NOT NULL, NAME VARCHAR(225), COMPLETED BOOLEAN);