DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS comments;
 
CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost INT(250) NOT NULL
);
 
CREATE TABLE comments (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  id_product INT(250)
);
 
INSERT INTO products (name, description, cost) VALUES
  ('iphone', 'smartphone apple', 1000),
  ('ipad', 'tablette apple', 500),
  ('imac', 'ordinateur apple', 2000);
  
INSERT INTO comments (content, id_product) VALUES
  ('Trop cher', 1),
  ('Trop cool', 1),
  ('Incroyable', 3);
  
CREATE TABLE categories (
	category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO categories (name) VALUES
  ('smartphone'),
  ('tablette'),
  ('ordinateur'),
  ('apple');
  
CREATE TABLE category_product (
	category_id INT NOT NULL,
    product_id INT NOT NULL
);


INSERT INTO category_product (category_id, product_id) VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,1),
  (4,2),
  (4,3);
  
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

INSERT INTO user (username, password) VALUES
    ('admin', '$2a$12$y7XaERQc44k6XimlkpWEieVL0xHAk1AUESFxqIODWvOX.hvD74w6y'),
    ('azerty', '$2a$12$WgLPDH/wz0JxbtcwbuqHXO5Miu1Cv/QoMI6EjuwSin.Ql4iTnQqce'),
    ('clement','$2a$12$EVjT0SyTXBIS1VAHr0FcaufDZDPklV01XBBI6s6Ce5agZ93p8NgVS');