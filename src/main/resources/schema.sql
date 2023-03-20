DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      created_at INT,
                      updated_at INT
);