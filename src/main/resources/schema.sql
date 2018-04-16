--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.8

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car (
    cr_id bigint NOT NULL,
    cr_name character varying(255) NOT NULL,
    cc_id bigint
);


ALTER TABLE public.car OWNER TO postgres;

--
-- Name: car_class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car_class (
    cc_id bigint NOT NULL,
    cc_name character varying(255) NOT NULL
);


ALTER TABLE public.car_class OWNER TO postgres;

--
-- Name: car_class_cc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.car_class_cc_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_class_cc_id_seq OWNER TO postgres;

--
-- Name: car_class_cc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_class_cc_id_seq OWNED BY public.car_class.cc_id;


--
-- Name: car_cr_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.car_cr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_cr_id_seq OWNER TO postgres;

--
-- Name: car_cr_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_cr_id_seq OWNED BY public.car.cr_id;


--
-- Name: driver; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.driver (
    dr_id bigint NOT NULL,
    dr_country character varying(255) NOT NULL,
    dr_name character varying(255) NOT NULL
);


ALTER TABLE public.driver OWNER TO postgres;

--
-- Name: fastest_lap; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fastest_lap (
    fl_id bigint NOT NULL,
    fl_time time without time zone NOT NULL,
    dr_id bigint
);


ALTER TABLE public.fastest_lap OWNER TO postgres;

--
-- Name: fastest_lap_fl_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fastest_lap_fl_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fastest_lap_fl_id_seq OWNER TO postgres;

--
-- Name: fastest_lap_fl_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fastest_lap_fl_id_seq OWNED BY public.fastest_lap.fl_id;


--
-- Name: qualifying_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.qualifying_result (
    qr_id bigint NOT NULL,
    qr_time time without time zone NOT NULL,
    cr_id bigint,
    dr_id bigint,
    rd_id bigint
);


ALTER TABLE public.qualifying_result OWNER TO postgres;

--
-- Name: qualifying_result_qr_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.qualifying_result_qr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qualifying_result_qr_id_seq OWNER TO postgres;

--
-- Name: qualifying_result_qr_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.qualifying_result_qr_id_seq OWNED BY public.qualifying_result.qr_id;


--
-- Name: race; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.race (
    ra_id bigint NOT NULL,
    rs_number_of_laps integer,
    fl_id bigint NOT NULL,
    rd_id bigint,
    tr_id bigint
);


ALTER TABLE public.race OWNER TO postgres;

--
-- Name: race_day; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.race_day (
    rd_id bigint NOT NULL,
    rd_date timestamp without time zone NOT NULL,
    rd_event_format character varying(255) NOT NULL,
    rd_host character varying(255) NOT NULL,
    se_id bigint
);


ALTER TABLE public.race_day OWNER TO postgres;

--
-- Name: race_day_rd_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.race_day_rd_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.race_day_rd_id_seq OWNER TO postgres;

--
-- Name: race_day_rd_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.race_day_rd_id_seq OWNED BY public.race_day.rd_id;


--
-- Name: race_ra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.race_ra_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.race_ra_id_seq OWNER TO postgres;

--
-- Name: race_ra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.race_ra_id_seq OWNED BY public.race.ra_id;


--
-- Name: race_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.race_result (
    rr_id bigint NOT NULL,
    rr_finish_position integer NOT NULL,
    rr_race_time time without time zone NOT NULL,
    rr_start_position integer NOT NULL,
    cr_id bigint,
    dr_id bigint,
    ra_id bigint
);


ALTER TABLE public.race_result OWNER TO postgres;

--
-- Name: race_result_rr_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.race_result_rr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.race_result_rr_id_seq OWNER TO postgres;

--
-- Name: race_result_rr_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.race_result_rr_id_seq OWNED BY public.race_result.rr_id;


--
-- Name: race_settings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.race_settings (
    rs_id bigint NOT NULL,
    rs_boost character varying(255) NOT NULL,
    rs_bop boolean NOT NULL,
    rs_fuel_consumption character varying(255) NOT NULL,
    rs_mechanical_damage character varying(255) NOT NULL,
    rs_slipstream character varying(255) NOT NULL,
    rs_start character varying(255) NOT NULL,
    rs_tire_wear character varying(255) NOT NULL,
    rs_tuning boolean NOT NULL,
    rd_id bigint
);


ALTER TABLE public.race_settings OWNER TO postgres;

--
-- Name: race_settings_rs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.race_settings_rs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.race_settings_rs_id_seq OWNER TO postgres;

--
-- Name: race_settings_rs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.race_settings_rs_id_seq OWNED BY public.race_settings.rs_id;


--
-- Name: racesettings_carclass; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.racesettings_carclass (
    se_id bigint NOT NULL,
    cc_id bigint NOT NULL
);


ALTER TABLE public.racesettings_carclass OWNER TO postgres;

--
-- Name: season; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.season (
    se_id bigint NOT NULL
);


ALTER TABLE public.season OWNER TO postgres;

--
-- Name: season_se_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.season_se_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.season_se_id_seq OWNER TO postgres;

--
-- Name: season_se_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.season_se_id_seq OWNED BY public.season.se_id;


--
-- Name: track; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.track (
    tr_id bigint NOT NULL,
    tr_name character varying(255) NOT NULL
);


ALTER TABLE public.track OWNER TO postgres;

--
-- Name: track_tr_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.track_tr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.track_tr_id_seq OWNER TO postgres;

--
-- Name: track_tr_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.track_tr_id_seq OWNED BY public.track.tr_id;


--
-- Name: car cr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car ALTER COLUMN cr_id SET DEFAULT nextval('public.car_cr_id_seq'::regclass);


--
-- Name: car_class cc_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_class ALTER COLUMN cc_id SET DEFAULT nextval('public.car_class_cc_id_seq'::regclass);


--
-- Name: fastest_lap fl_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fastest_lap ALTER COLUMN fl_id SET DEFAULT nextval('public.fastest_lap_fl_id_seq'::regclass);


--
-- Name: qualifying_result qr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualifying_result ALTER COLUMN qr_id SET DEFAULT nextval('public.qualifying_result_qr_id_seq'::regclass);


--
-- Name: race ra_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race ALTER COLUMN ra_id SET DEFAULT nextval('public.race_ra_id_seq'::regclass);


--
-- Name: race_day rd_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_day ALTER COLUMN rd_id SET DEFAULT nextval('public.race_day_rd_id_seq'::regclass);


--
-- Name: race_result rr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_result ALTER COLUMN rr_id SET DEFAULT nextval('public.race_result_rr_id_seq'::regclass);


--
-- Name: race_settings rs_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_settings ALTER COLUMN rs_id SET DEFAULT nextval('public.race_settings_rs_id_seq'::regclass);


--
-- Name: season se_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season ALTER COLUMN se_id SET DEFAULT nextval('public.season_se_id_seq'::regclass);


--
-- Name: track tr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.track ALTER COLUMN tr_id SET DEFAULT nextval('public.track_tr_id_seq'::regclass);


--
-- Name: car_class_cc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_class_cc_id_seq', 1, false);


--
-- Name: car_cr_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_cr_id_seq', 1, false);


--
-- Name: fastest_lap_fl_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fastest_lap_fl_id_seq', 1, false);


--
-- Name: qualifying_result_qr_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.qualifying_result_qr_id_seq', 1, false);


--
-- Name: race_day_rd_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.race_day_rd_id_seq', 1, false);


--
-- Name: race_ra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.race_ra_id_seq', 1, false);


--
-- Name: race_result_rr_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.race_result_rr_id_seq', 1, false);


--
-- Name: race_settings_rs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.race_settings_rs_id_seq', 1, false);


--
-- Name: season_se_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.season_se_id_seq', 1, false);


--
-- Name: track_tr_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.track_tr_id_seq', 1, false);


--
-- Name: car_class car_class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_class
    ADD CONSTRAINT car_class_pkey PRIMARY KEY (cc_id);


--
-- Name: car car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_pkey PRIMARY KEY (cr_id);


--
-- Name: driver driver_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.driver
    ADD CONSTRAINT driver_pkey PRIMARY KEY (dr_id);


--
-- Name: fastest_lap fastest_lap_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fastest_lap
    ADD CONSTRAINT fastest_lap_pkey PRIMARY KEY (fl_id);


--
-- Name: qualifying_result qualifying_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualifying_result
    ADD CONSTRAINT qualifying_result_pkey PRIMARY KEY (qr_id);


--
-- Name: race_day race_day_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_day
    ADD CONSTRAINT race_day_pkey PRIMARY KEY (rd_id);


--
-- Name: race race_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race
    ADD CONSTRAINT race_pkey PRIMARY KEY (ra_id);


--
-- Name: race_result race_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_result
    ADD CONSTRAINT race_result_pkey PRIMARY KEY (rr_id);


--
-- Name: race_settings race_settings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_settings
    ADD CONSTRAINT race_settings_pkey PRIMARY KEY (rs_id);


--
-- Name: season season_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (se_id);


--
-- Name: track track_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.track
    ADD CONSTRAINT track_pkey PRIMARY KEY (tr_id);


--
-- Name: car fk17ch8ktgcg4fs9g55i0nqk8y1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT fk17ch8ktgcg4fs9g55i0nqk8y1 FOREIGN KEY (cc_id) REFERENCES public.car_class(cc_id);


--
-- Name: race_day fk28ymvj7qjp7toxnyivs7hxs1p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_day
    ADD CONSTRAINT fk28ymvj7qjp7toxnyivs7hxs1p FOREIGN KEY (se_id) REFERENCES public.season(se_id);


--
-- Name: racesettings_carclass fk70anaj3vschp4px415osfm3fo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.racesettings_carclass
    ADD CONSTRAINT fk70anaj3vschp4px415osfm3fo FOREIGN KEY (cc_id) REFERENCES public.car_class(cc_id);


--
-- Name: qualifying_result fk89pkpf7iu83xq1p67xaymbvy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualifying_result
    ADD CONSTRAINT fk89pkpf7iu83xq1p67xaymbvy FOREIGN KEY (rd_id) REFERENCES public.race_day(rd_id);


--
-- Name: qualifying_result fk8ictbdp7rydehl6jbhs9ihtvm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualifying_result
    ADD CONSTRAINT fk8ictbdp7rydehl6jbhs9ihtvm FOREIGN KEY (dr_id) REFERENCES public.driver(dr_id);


--
-- Name: race_result fkc5qhuub99ayxss763lmxhbwee; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_result
    ADD CONSTRAINT fkc5qhuub99ayxss763lmxhbwee FOREIGN KEY (cr_id) REFERENCES public.car(cr_id);


--
-- Name: racesettings_carclass fke7jrm9mwfx5r7o74ft3k4tdug; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.racesettings_carclass
    ADD CONSTRAINT fke7jrm9mwfx5r7o74ft3k4tdug FOREIGN KEY (se_id) REFERENCES public.race_settings(rs_id);


--
-- Name: race_result fkf47rkvi9inoyesev0fo5f6tyd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_result
    ADD CONSTRAINT fkf47rkvi9inoyesev0fo5f6tyd FOREIGN KEY (dr_id) REFERENCES public.driver(dr_id);


--
-- Name: race fkgad3u85cy4gm1b0xnx3dx0xo9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race
    ADD CONSTRAINT fkgad3u85cy4gm1b0xnx3dx0xo9 FOREIGN KEY (tr_id) REFERENCES public.track(tr_id);


--
-- Name: fastest_lap fkiqqjni4rdqe632f1o4w6qrl9g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fastest_lap
    ADD CONSTRAINT fkiqqjni4rdqe632f1o4w6qrl9g FOREIGN KEY (dr_id) REFERENCES public.driver(dr_id);


--
-- Name: race_result fkkfgwd48wl54frkrxg9vly8b5u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_result
    ADD CONSTRAINT fkkfgwd48wl54frkrxg9vly8b5u FOREIGN KEY (ra_id) REFERENCES public.race(ra_id);


--
-- Name: race fklmpfdqeeqftrfroxwti62w4tn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race
    ADD CONSTRAINT fklmpfdqeeqftrfroxwti62w4tn FOREIGN KEY (fl_id) REFERENCES public.fastest_lap(fl_id);


--
-- Name: qualifying_result fkqjar0fgljd48ir7grtxvggqb3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualifying_result
    ADD CONSTRAINT fkqjar0fgljd48ir7grtxvggqb3 FOREIGN KEY (cr_id) REFERENCES public.car(cr_id);


--
-- Name: race_settings fkrr2uk1gwx849kehy68o6qnl1v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race_settings
    ADD CONSTRAINT fkrr2uk1gwx849kehy68o6qnl1v FOREIGN KEY (rd_id) REFERENCES public.race_day(rd_id);


--
-- Name: race fksks0o4p2oj42htyh5qru65vqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.race
    ADD CONSTRAINT fksks0o4p2oj42htyh5qru65vqo FOREIGN KEY (rd_id) REFERENCES public.race_day(rd_id);


--
-- PostgreSQL database dump complete
--

