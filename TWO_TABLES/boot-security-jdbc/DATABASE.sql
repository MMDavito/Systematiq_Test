-- users table structure
CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(120) NOT NULL,
  enabled BOOLEAN NOT NULL,
  PRIMARY KEY (username)
);
-- authorities table structure
CREATE TABLE IF NOT EXISTS authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
 PRIMARY KEY (username),
 CONSTRAINT fk_customer
      FOREIGN KEY(username) 
  REFERENCES users(username)
);
