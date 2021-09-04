CREATE TABLE IF NOT EXISTS movies (
  id SERIAL,
  name_russian VARCHAR(100) NOT NULL,
  name_native VARCHAR(100) NOT NULL,
  released_date DATE NOT NULL,
  description VARCHAR(1000) NOT NULL,
  rating DOUBLE PRECISION NOT NULL,
  price DOUBLE PRECISION NOT NULL,
  picture_path VARCHAR(500) NOT NULL,
  votes INT NOT NULL,
  genre VARCHAR(100),
  PRIMARY KEY (id));