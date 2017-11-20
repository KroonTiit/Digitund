create table answer_group
(
	id bigint auto_increment
		primary key,
	question_id bigint null,
	text varchar(255) null,
	constraint answer_group_question_id_fk
		foreign key (question_id) references question (id)
			on update cascade
)
;

create index answer_group_answer_group_id_fk
	on answer_group (question_id)
;

create table answer_group_answer
(
	id bigint auto_increment
		primary key,
	answer_group_id bigint null,
	text varchar(255) null,
	constraint answer_group_answer_answer_group_id_fk
		foreign key (answer_group_id) references answer_group (id)
			on update cascade
)
;

create index answer_group_answer_answer_group_id_fk
	on answer_group_answer (answer_group_id)
;

create table answer_option
(
	id bigint auto_increment
		primary key,
	question_id bigint null,
	text varchar(255) null,
	correct tinyint(1) null
)
;

create index answer_option_question_id_fk
	on answer_option (question_id)
;

create table comp_material
(
	id bigint auto_increment
		primary key,
	lesson_id bigint null,
	order_nr bigint not null,
	name varchar(200) null
)
;

create index comp_material_lesson_id_fk
	on comp_material (lesson_id)
;

create table lesson
(
	id bigint auto_increment
		primary key,
	start_time timestamp default CURRENT_TIMESTAMP not null,
	end_time timestamp null,
	created timestamp null,
	user_id varchar(255) not null,
	name varchar(255) null,
	description varchar(2000) null
)
;

alter table comp_material
	add constraint comp_material_lesson_id_fk
		foreign key (lesson_id) references lesson (id)
			on update cascade
;

create table material
(
	id bigint auto_increment
		primary key,
	comp_material_id bigint null,
	order_nr bigint null,
	type varchar(255) not null,
	text_content varchar(255) null,
	video_start decimal(10,2) null,
	video_end decimal(10,2) null,
	youtube_id varchar(255) null,
	image_url varchar(255) null,
	description varchar(255) null,
	name varchar(2000) null,
	constraint material_comp_material_id_fk
		foreign key (comp_material_id) references comp_material (id)
			on update cascade
)
;

create index material_comp_material_id_fk
	on material (comp_material_id)
;

create table ordered_answer
(
	id bigint auto_increment
		primary key,
	question_id bigint null,
	order_nr bigint not null,
	text varchar(255) null
)
;

create index ordered_answer_question_id_fk
	on ordered_answer (question_id)
;

create table performance
(
	id bigint auto_increment
		primary key,
	performer_id varchar(255) not null,
	lesson_id bigint not null,
	start_date timestamp default CURRENT_TIMESTAMP not null,
	constraint performance_lesson_id_fk
		foreign key (lesson_id) references lesson (id)
			on update cascade
)
;

create index performance_lesson_id_fk
	on performance (lesson_id)
;

create table question
(
	id bigint auto_increment
		primary key,
	comp_material_id bigint null,
	text varchar(255) null,
	type varchar(50) not null,
	constraint question_comp_material_id_fk
		foreign key (comp_material_id) references comp_material (id)
			on update cascade
)
;

create index question_comp_material_id_fk
	on question (comp_material_id)
;

alter table answer_option
	add constraint answer_option_question_id_fk
		foreign key (question_id) references question (id)
			on update cascade
;

alter table ordered_answer
	add constraint ordered_answer_question_id_fk
		foreign key (question_id) references question (id)
			on update cascade
;

create table user
(
	id bigint auto_increment
		primary key,
	start_date timestamp null,
	end_date timestamp null
)
;

create table user_group
(
	id bigint auto_increment
		primary key,
	user_id bigint null,
	group_name varchar(255) null
)
;

create table user_group_user
(
	id bigint auto_increment
		primary key,
	user_group_id bigint null,
	lesson_id bigint null,
	email varchar(255) null,
	first_name varchar(255) null,
	last_name varchar(255) null
)
;

