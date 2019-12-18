/**
 * CREATE Script for init of DB
 */

insert into customer (id, created_date, updated_date, dob, last_name, first_name) values (1, now(), now() , now(), 'Lalani','Rehman');
insert into policy (id, created_date, updated_date, policy_type, premium, cover,customer_id ) values (1, now(), now() ,1, 1000.00,
2000.0,1);