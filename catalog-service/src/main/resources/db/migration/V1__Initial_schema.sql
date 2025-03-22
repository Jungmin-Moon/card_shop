CREATE TABLE card (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	name varchar(255) NOT NULL,
	card_type varchar(255) NOT NULL,
	attribute varchar(255) NOT NULL,
	level integer NOT NULL,
	rank integer NOT NULL,
	pend_scale integer NOT NULL,
	link_arrows integer NOT NULL,
	monster_type varchar(255) NOT NULL,
	text_box_text text NOT NULL,
	atk integer NOT NULL,
	def integer NOT NULL,
	link integer NOT NULL,
	price float8 NOT NULL,
	created_date timestamp NOT NULL,
	last_modified_date timestamp NOT NULL,
	version integer NOT NULL
);