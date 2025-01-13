USE shopping;

CREATE TABLE goods (
	goodsid varchar(10) primary key,
	goodsname varchar(30),
	price float
);

INSERT INTO goods values(
	"001",
	"牙膏",
	10.3
);


INSERT INTO goods values(
	"002",
	"笔记本",
	3.5
);

INSERT INTO goods values(
	"003",
	"签字笔",
	3
);

INSERT INTO goods values(
	"004",
	"矿泉水",
	1
);
