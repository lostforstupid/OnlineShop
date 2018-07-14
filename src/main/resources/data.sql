INSERT INTO customer (id, role, username, password, is_blocked, address) VALUES
    (1, 'ADMIN', 'admin', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address');
INSERT INTO role VALUES(default, 'ADMIN');
INSERT INTO role VALUES(default, 'USER');
INSERT INTO role VALUES(default, 'ANONYMOUS');

INSERT INTO user VALUES (default, 'Address', false, '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'USER', 'user12345');

INSERT INTO product (id, name, price, image_url) VALUES
    (0, 'Noses (20 per pack)', 7500, 'girl1.jpg'),
    (1, 'Browser', 400,'girl2.jpg'),
    (2, 'Fun tea', 38,'girl3.jpg'),
    (3,'Door', 1400, 'gallery1.jpg');
