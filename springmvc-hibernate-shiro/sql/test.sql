--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: resource_types; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE resource_types (
    id integer NOT NULL,
    code character varying
);


ALTER TABLE resource_types OWNER TO test;

--
-- Name: resource_types_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE resource_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE resource_types_id_seq OWNER TO test;

--
-- Name: resource_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE resource_types_id_seq OWNED BY resource_types.id;


--
-- Name: resources; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE resources (
    id integer NOT NULL,
    code character varying,
    type_id integer
);


ALTER TABLE resources OWNER TO test;

--
-- Name: resources_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE resources_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE resources_id_seq OWNER TO test;

--
-- Name: resources_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE resources_id_seq OWNED BY resources.id;


--
-- Name: role_resources; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE role_resources (
    id integer NOT NULL,
    role_id integer,
    resource_id integer
);


ALTER TABLE role_resources OWNER TO test;

--
-- Name: role_resources_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE role_resources_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE role_resources_id_seq OWNER TO test;

--
-- Name: role_resources_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE role_resources_id_seq OWNED BY role_resources.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE roles (
    id integer NOT NULL,
    code character varying
);


ALTER TABLE roles OWNER TO test;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE roles_id_seq OWNER TO test;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE user_roles (
    id integer NOT NULL,
    user_id integer,
    role_id integer
);


ALTER TABLE user_roles OWNER TO test;

--
-- Name: user_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE user_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_roles_id_seq OWNER TO test;

--
-- Name: user_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE user_roles_id_seq OWNED BY user_roles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: test; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    username character varying,
    password character varying
);


ALTER TABLE users OWNER TO test;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO test;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY resource_types ALTER COLUMN id SET DEFAULT nextval('resource_types_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY resources ALTER COLUMN id SET DEFAULT nextval('resources_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY role_resources ALTER COLUMN id SET DEFAULT nextval('role_resources_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY user_roles ALTER COLUMN id SET DEFAULT nextval('user_roles_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: resource_types; Type: TABLE DATA; Schema: public; Owner: test
--

COPY resource_types (id, code) FROM stdin;
1	type1
2	type2
\.


--
-- Name: resource_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('resource_types_id_seq', 2, true);


--
-- Data for Name: resources; Type: TABLE DATA; Schema: public; Owner: test
--

COPY resources (id, code, type_id) FROM stdin;
1	res1	1
2	res2	2
3	res3	1
4	res4	2
\.


--
-- Name: resources_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('resources_id_seq', 4, true);


--
-- Data for Name: role_resources; Type: TABLE DATA; Schema: public; Owner: test
--

COPY role_resources (id, role_id, resource_id) FROM stdin;
1	1	1
2	1	2
3	2	3
4	2	4
5	1	3
\.


--
-- Name: role_resources_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('role_resources_id_seq', 5, true);


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: test
--

COPY roles (id, code) FROM stdin;
1	role1
2	role2
\.


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('roles_id_seq', 2, true);


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: test
--

COPY user_roles (id, user_id, role_id) FROM stdin;
1	1	1
2	1	2
3	2	2
\.


--
-- Name: user_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('user_roles_id_seq', 3, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: test
--

COPY users (id, username, password) FROM stdin;
1	user1	202cb962ac59075b964b07152d234b70
2	user2	202cb962ac59075b964b07152d234b70
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('users_id_seq', 2, true);


--
-- Name: resource_types_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY resource_types
    ADD CONSTRAINT resource_types_pkey PRIMARY KEY (id);


--
-- Name: resources_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY resources
    ADD CONSTRAINT resources_pkey PRIMARY KEY (id);


--
-- Name: role_resources_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY role_resources
    ADD CONSTRAINT role_resources_pkey PRIMARY KEY (id);


--
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: test; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

