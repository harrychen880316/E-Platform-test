use 0605test;
CREATE TABLE `products` (
	ProductID varchar(50) NOT NULL ,
	ProductName varchar(50) NOT NULL,  
	Price INT NOT NULL,
	Quantity INT NOT NULL,
	PRIMARY KEY(ProductID)      
);
CREATE TABLE `Order` (
	OrderID varchar(50) NOT NULL ,
	MemberID varchar(50) NOT NULL,  
	Price INT NOT NULL,
	PayStasus boolean NOT NULL,
	PRIMARY KEY(OrderID)      
);
CREATE TABLE `OrderDetail` (
	OrderItemSN int NOT NULL ,
	OrderID varchar(50) NOT NULL ,
    ProductID varchar(50) NOT NULL ,
    Quantity INT NOT NULL,
	StandPrice INT NOT NULL,
	ItemPrice INT NOT NULL,
	PRIMARY KEY(OrderItemSN),
    FOREIGN KEY(ProductID) REFERENCES `products`(ProductID) ON DELETE CASCADE,
    FOREIGN KEY(OrderID) REFERENCES `order`(OrderID) ON DELETE CASCADE
);