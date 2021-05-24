create table tb_delivery(

	id bigint not null auto_increment,
	client_id  bigint not null,
	rate  decimal(10,2) not null,
	status varchar(20) not null,
	order_date datetime not null,
	end_date datetime,
	
	destiny_name varchar(60) not null,	
	destiny_street varchar(255) not null,
	destiny_number varchar(30) not null,
	destiny_complement varchar(60) not null,
	destiny_neighborhood varchar(30) not null,

	primary key(id)

);

alter table tb_delivery add constraint fk_delivery_client foreign key (client_id) references tb_client (id)