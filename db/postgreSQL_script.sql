create SCHEMA cleverusermanagement;

CREATE ROLE connect_cleverusermanagement WITH
	LOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'dsshshd83hwhhhshsq';
