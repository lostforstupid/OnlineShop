INSERT INTO customer (id, role, username, password, is_blocked, address) VALUES
    (1, 'ADMIN', 'admin', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address'),
    (2, 'USER', 'user', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address'),
    (3, 'USER', 'blocked_user', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'true', 'Address');

INSERT INTO product (id, name, price, image_url) VALUES
    (1, 'Noses (20 per pack)', 7500, 'girl1.jpg'),
    (2, 'Browser', 400,'girl2.jpg'),
    (3, 'Fun tea', 38,'girl3.jpg'),
    (4,'Door', 1400, 'gallery1.jpg'),
    (5, 'Browser2', 400,'girl2.jpg'),
    (6, 'Fun tea2', 38,'girl3.jpg'),
    (7,'Door2', 1400, 'gallery1.jpg'),
    (8, 'Browser3', 400,'girl2.jpg'),
    (9, 'Fun tea3', 38,'girl3.jpg'),
    (10,'Door3', 1400, 'gallery1.jpg'),
    (11, 'Browser4', 400,'girl2.jpg'),
    (12, 'Fun tea4', 38,'girl3.jpg'),
    (13,'Door4', 1400, 'gallery1.jpg'),
    (14, 'Browser5', 400,'girl2.jpg'),
    (15, 'Fun tea5', 38,'girl3.jpg'),
    (16,'Door5', 1400, 'gallery1.jpg');

INSERT INTO order_table (id, status, user_id) VALUES
    (1, 'NEW', 1),
    (2, 'NEW', 2);

INSERT INTO product_in_order (id, quantity, order_id, product_id) VALUES
    (default , 9, 1, 2),
    (default , 6, 1, 3),
    (default , 3, 1, 1),
    (default , 1, 2, 4);