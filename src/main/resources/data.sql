INSERT INTO customer (id, role, username, password, is_blocked, address) VALUES
    (1, 'ADMIN', 'admin', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address1'),
    (2, 'USER', 'user', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address2');

INSERT INTO product (id, name, price, image_url) VALUES
    (1, 'Noses (20 per pack)', 7500, 'girl1.jpg'),
    (2, 'Browser', 400,'girl2.jpg'),
    (3, 'Fun tea', 38,'girl3.jpg'),
    (4,'Door', 1400, 'gallery1.jpg');

INSERT INTO order_table (id, date_and_time, status, user_id) VALUES
    (1, '2017-11-15 15:30:14.332', 'NEW', 2);

INSERT INTO product_in_order (id, quantity, order_id, product_id) VALUES
    (1, 3, 1, 1),
    (2, 1, 1, 3);
