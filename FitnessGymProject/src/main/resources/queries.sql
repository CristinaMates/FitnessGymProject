--create sequence seq_numer;
/*create table gym_member (
	first_name varchar (50),
	last_name varchar (50),
	gender varchar (50),
	birth_date date,
	telephone varchar (50),
	email varchar (50),
	student boolean,
	corporate boolean,
	id numeric NOT NULL default nextval ('seq_numer'),
	gym_trainer_id numeric,
	program_id numeric,
	gym_subscription_id numeric,
	CONSTRAINT idprimarykey PRIMARY KEY (id)
);

*/
--select * from gym_member;
/*create table gym_trainer (
	id numeric NOT NULL default nextval ('seq_numer'),
	first_name varchar (50),
	last_name varchar (50),
	CONSTRAINT memberprimarykey PRIMARY KEY (id)
);
*/
--select * from gym_trainer;
/*create table program (
	id numeric NOT NULL default nextval('seq_numer'),
	number_gym_member numeric (50),
	CONSTRAINT programprimarykey PRIMARY KEY (id)
);
*/
/*create table subscription_card (
	id numeric NOT NULL default nextval ('seq_numer'),
	start_date date,
	end_date date,
	gym_member_id numeric (50),
	CONSTRAINT subscriptionprimarykey PRIMARY KEY (id)
	);
	*/
	--select * from subscription_card;
	/*create table gym_subscription (
		id numeric NOT NULL default nextval ('seq_numer'),
		type varchar (50),
		price float (50),
		discount float (50),
		start_date date,
		end_date date,
		CONSTRAINT subprimarykey PRIMARY KEY (id)
	);
*/
--select * from gym_subscription;
--alter table program add program varchar (50);
--select * from program;
/*create table reservation (
	id numeric NOT NULL default nextval ('seq_numer'),
	period Date,
	gym_member_id numeric (50),
	gym_trainer_id numeric (50),
	program_id numeric (50),
	CONSTRAINT reservationprimary PRIMARY KEY (id)
);
*/
--select * from reservation;