CREATE TABLE price (
                       id bigint AUTO_INCREMENT PRIMARY KEY,
                       color_component varchar(255) NULL,
                       color_name varchar(255) NOT NULL,
                       component_quantity varchar(255) NULL,
                       price decimal(8, 6) NULL,
                       color_id int NOT NULL,
                       CONSTRAINT FK_price_color FOREIGN KEY (color_id) REFERENCES color (id)
);

INSERT INTO colors.price (id, color_component, color_name, component_quantity, price, color_id)
VALUES
    (1, 'PP600.00.18,PP600.00.17,PP600.00.14,CP558.10.0000', 'RAL 1000 Green Beige', '100.00,50.00,100.00,750.00', 19.500000, 1),
    (2, 'PP600.00.18,PP600.00.17,PP600.00.16,CP558.10.0000', 'RAL 1001 Beige', '100.00,50.00,100.00,750.00', 19.500000, 2),
    (3, 'PP600.00.08,PP600.00.06,PP600.00.07,CP558.10.0000', 'RAL 1002 Sand Yellow', '80.00,100.00,70.00,750.00', 21.500000, 3),
    (4, 'PP600.00.03,PP600.00.08,PP600.00.09,PP600.00.0013,CP558.10.0000', 'RAL 1003 Signal Yellow', '85.00,85.00,70.00,10.00,750.00', 28.500000, 4),
    (5, 'PP600.00.08,PP600.00.09,PP600.00.0014,CP558.10.1000', 'RAL 1004 Golden Yellow', '80.00,100.00,70.00,750.00', 24.500000, 5),
    (6, 'PP600.00.02,PP600.00.08,PP600.00.0017,CP558.10.0000', 'RAL 1005 Honey Yellow', '70.00,100.00,80.00,750.00', 27.000000, 6),
    (7, 'PP600.00.09,PP600.00.04,PP600.00.005,CP558.10.1000', 'RAL 1006 Maize Yellow', '0.50,0.50,1.00,998.00', 27.000000, 7),
    (8, 'PP600.00.09,PP600.00.04,PP600.00.005,CP558.10.0000', 'RAL 1007 Daffodil Yellow', '50.00,50.00,150.00,750.00', 32.000000, 8),
    (9, 'PP600.00.11,PP600.00.12,PP600.00.007,CP558.10.0000', 'RAL 1011 Brown Beige', '55.00,60.00,135.00,750.00', 35.500000, 9),
    (10, 'PP600.00.11,PP600.00.16,PP600.00.004,CP558.10.0000', 'RAL 1012 Lemon Yellow', '65.00,70.00,115.00,750.00', 33.500000, 10);
