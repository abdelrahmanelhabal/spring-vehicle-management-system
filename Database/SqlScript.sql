DROP DATABASE IF EXISTS vehicle_system;

create DATABASE vehicle_system ;

use vehicle_system ;

CREATE TABLE Vehicles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    type varchar(30) NOT NULL ,
    price DECIMAL(10,2) NOT NULL ,
    brand varchar(30) NOT NULL ,
    color varchar(30) NOT NULL
);
