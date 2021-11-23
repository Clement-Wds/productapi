DROP TABLE IF EXISTS products;
 
CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost INT(250) NOT NULL
);
 
INSERT INTO products (name, description, cost) VALUES
  ('iphone', 'smartphone apple', 1000),
  ('ipad', 'tablette apple', 500),
  ('imac', 'ordinateur apple', 2000);