-- Create the roles table
CREATE TABLE roles (
   id INT PRIMARY KEY,
   name VARCHAR(255) NOT NULL
);

-- Create the users table
CREATE TABLE users (
   id INT PRIMARY KEY,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   role_id INT,
   provider VARCHAR(50), -- Add the 'provider' column
   FOREIGN KEY (role_id) REFERENCES roles(id)
);
