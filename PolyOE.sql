Use PolyOE
Create table Users(
username varchar(30) not null primary key,
password varchar (30) not null,
fullname nvarchar(50) not null,
email varchar(50) not null,
admin bit
)
Create table Videos(
	videoId varchar(30) not null primary key,
	title nvarchar(100) not null,
	poster nvarchar(100) ,
	views int not null,
	description nvarchar(100),
	active bit not null
)

Create table Favorites(
	favoriteId int identity(1,1) not null primary key,
	username varchar(30) not null foreign key references Users(username),
	videoId varchar(30) not null foreign key references Videos(videoId),
	likeDate date,
)
Create table Shares(
	shareId int identity(1,1) not null primary key,
	username varchar(30) not null foreign key references Users(username),
	videoId varchar(30) not null foreign key references Videos(videoId),
	email varchar(50) not null,
	shareDate date
)
Insert into Users
values('huy','123',N'Hoàng Quốc Huy','huyhoike@gmail.com',1),
	('nd1','123',N'Nguyễn Văn Nam','nam@gmail.com',0),
	('nd2','123',N'Mai Thị Vân','van@gmail.com',0),
	('nd3','123',N'Lê Văn Duy','duy@gmail.com',0),
	('nd4','123',N'Nguyễn Văn Thành','thanh@gmail.com',0)
Insert into Videos values
('fhe6kptrPqo','Venom','a',0,N'Phim siêu anh hùng DC',1),
('_dn1KI4mHA8',N'Shangchi và huyền thoại thập luân','a',0,N'Phim siêu anh hùng Marvel',1),
('QK5c5fI5NSY',N'Đấu trường âm nhạc','a',0,N'Phim hoạt hình ca nhạc',1),
('z3pWQFP2sZs',N'Biệt đội cảm tử','a',0,N'Phim siêu anh hùng DC',1),
('Eu9G8nO5-Ug',N'Mortal Kombat-Cuộc chiến sinh tử','a',0,N'Phim hành động viễn tưởng',1),
('SwwlFvOwkhA','FAST & FURIOUS 9','a',0,N'Phim hành động',1),
('1VIZ89FEjYI','Raya and the Last Dragon','a',0,N'Phim hoạt hình Disney',1),
('YKSNBIlM_bY','Naruto: The Movie','a',0,N'Phim live action Naruto',1),
('qwOWJ8pPgk8','The Walking Dead Season 11','a',0,N'Phim kinh dị viễn tưởng',1),
('nW948Va-l10','Loki','a',0,N'Phim siêu anh hùng Marvel',1)

