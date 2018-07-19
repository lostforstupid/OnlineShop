INSERT INTO customer (id, role, username, password, is_blocked, address) VALUES
    (1, 'ADMIN', 'admin', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address'),
    (2, 'USER', 'user', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'false', 'Address'),
    (3, 'USER', 'blocked_user', '$2a$10$OUwX3BY0RWAA71PjsLHvwu6CwnqKsqQMVBV/FNywy1a0xMvkg0NAS', 'true', 'Address');

INSERT INTO product (id, name, category, price, image_url) VALUES
    (1, 'Noses (20 per pack)', 'WARHAMMER_40000', 7500, 'girl1.jpg'),
    (2, 'Browser', 'WARHAMMER_40000', 400,'girl2.jpg'),
    (3, 'Fun tea', 'WARHAMMER_40000', 38,'girl3.jpg'),
    (4,'Door', 'WARHAMMER_40000', 1400, 'gallery1.jpg'),
    (5, 'Browser2', 'WARHAMMER_40000', 400,'girl2.jpg'),
    (6, 'Fun tea2', 'WARHAMMER_40000', 38,'girl3.jpg'),
    (7,'Door2', 'WARHAMMER_40000', 1400, 'gallery1.jpg'),
    (8, 'Browser3', 'STAR_CITIZEN', 400,'girl2.jpg'),
    (9, 'Fun tea3', 'STAR_CITIZEN', 38,'girl3.jpg'),
    (10,'Door3', 'STAR_CITIZEN', 1400, 'gallery1.jpg'),
    (11, 'Browser4', 'STAR_CITIZEN', 400,'girl2.jpg'),
    (12, 'Fun tea4', 'STAR_CITIZEN', 38,'girl3.jpg'),
    (13,'Door4', 'EVE_ONLINE', 1400, 'gallery1.jpg'),
    (14, 'Browser5', 'EVE_ONLINE', 400,'girl2.jpg'),
    (15, 'Fun tea5', 'EVE_ONLINE', 38,'girl3.jpg'),
    (16,'Door5', 'EVE_ONLINE', 1400, 'gallery1.jpg');

INSERT INTO order_table (id, status, user_id) VALUES
    (1, 'NEW', 1),
    (2, 'NEW', 2);

INSERT INTO product_in_order (id, quantity, order_id, product_id) VALUES
    (default , 9, 1, 2),
    (default , 6, 1, 3),
    (default , 3, 1, 1),
    (default , 1, 2, 4);