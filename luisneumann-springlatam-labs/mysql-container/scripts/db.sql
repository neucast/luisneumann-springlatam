USE springlatam_labs;
GO

DROP TABLE IF EXISTS libro;
GO

CREATE TABLE libro
(
    id                int auto_increment not null,
    titulo            varchar(70) not null,
    isbn              varchar(17) not null,
    edicion           int         not null,
    fecha_publicacion date        not null,
    capitulos         int         not null,
    paginas           int         not null,
    PRIMARY KEY (id)
)ENGINE=Innodb;
GO

INSERT INTO libro(titulo, isbn, edicion, fecha_publicacion, capitulos, paginas)
VALUES ('Spring Recipes', '978-1-4302-0623-1', 1, '2008-08-29', 19, 700),
       ('Spring Recipes', '978-1-4302-2499-0', 2, '2010-09-01', 24, 1104),
       ('Spring Recipes', '978-1-4302-5909-1', 3, '2014-11-14', 18, 828),
       ('Spring 5 Recipes', '978-1-4842-2789-3', 4, '2017-10-17', 17, 831),
       ('Pro Spring', '978-1-59059-461-2', 1, '2005-02-01', 19, 832),
       ('Pro Spring 2.5', '978-1-59059-921-1', 2, '2008-08-21', 22, 920),
       ('Pro Spring 3', '978-1-4302-4107-2', 3, '2012-04-18', 23, 944),
       ('Pro Spring', '978-1-4302-6152-0', 4, '2014-09-16', 18, 728),
       ('Pro Spring 5', '978-1-4842-2807-4', 5, '2017-10-17', 18, 849),
       ('Java for Absolute Beginners', '978-1-4842-3778-6', 1, '2018-12-05', 13, 612),
       ('Java 17 for Absolute Beginners', '978-1-4842-7079-0', 2, '2021-12-14', 13, 801),
       ('Spring Boot 2 Recipes', '978-1-4842-3962-9', 1, '2018-11-29', 11, 332),
       ('Pro Spring MVC: With Web Flow', '978-1-4302-4156-0', 1, '2012-10-06', 13, 596),
       ('Spring Enterprise Recipes', '978-1-4302-2497-6', 1, '2009-11-25', 12, 400),
       ('Pro Spring Integration', '978-1-4302-3345-9', 1, '2011-04-06', 18, 664),
       ('Pro SpringSource dm Server', '978-1-4302-1640-7', 1, '2009-09-15', 08, 288),
       ('Pro Spring Batch', '978-1-4302-3452-4', 1, '2011-07-15', 12, 504),
       ('The Definitive Guide to Spring Batch', '978-1-4842-3723-6', 2, '2019-07-09', 13, 465),
       ('Pro Spring Security', '978-1-4302-4819-4', 1, '2013-06-17', 09, 340),
       ('Pro Spring Security', '978-1-4842-5051-8', 2, '2019-11-22', 09, 410),
       ('Spring Boot Messaging', '978-1-4842-1225-7', 1, '2017-05-04', 11, 196),
       ('Pro Spring Boot', '978-1-4842-1431-2', 1, '2016-05-20', 14, 365),
       ('Pro Spring Boot 2', '978-1-4842-3675-8', 2, '2018-12-13', 13, 511),
       ('Introducing Spring Framework', '978-1-4302-6533-7', 1, '2014-07-04', 21, 352),
       ('Introducing Spring Framework 6', '978-1-4842-8636-4', 2, '2022-12-16', 13, 214),
       ('Spring Cloud Data Flow', '978-1-4842-1240-0', 1, '2020-12-25', 12, 402),
       ('Beginning Spring Data', '978-1-4842-8763-7', 1, '2022-12-29', 14, 417),
       ('Pivotal Certified Professional Spring Developer Exam', '978-1-4842-0811-3', 1, '2016-12-22', 08, 468),
       ('Pivotal Certified Professional Core Spring 5 Developer Exam', '978-1-4842-5135-5', 2, '2019-12-11', 12, 1007),
       ('Pivotal Certified Spring Web Application Developer Exam', '978-1-4842-0809-0', 1, '2015-12-09', 09, 422),
       ('Pivotal Certified Spring Enterprise Integration Specialist Exam', '978-1-4842-0794-9', 1, '2015-11-05', 09,
        523);
GO