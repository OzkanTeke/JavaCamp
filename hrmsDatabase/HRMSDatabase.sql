--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-15 12:05:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16792)
-- Name: employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer (
    id integer NOT NULL,
    "companyName" character varying(50) NOT NULL,
    website character varying(50) NOT NULL,
    "phoneNumber" character varying(50) NOT NULL
);


ALTER TABLE public.employer OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16802)
-- Name: jobDescription; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."jobDescription" (
    "jobId" integer NOT NULL,
    "position" "char" NOT NULL
);


ALTER TABLE public."jobDescription" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16797)
-- Name: jobSeeker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."jobSeeker" (
    id integer NOT NULL,
    "nationalityId" character varying(15) NOT NULL,
    "birthYear" integer NOT NULL,
    "firstName" character varying(50) NOT NULL,
    "lastName" character varying(50) NOT NULL
);


ALTER TABLE public."jobSeeker" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16787)
-- Name: systemPersonel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."systemPersonel" (
    id integer NOT NULL,
    "firstName" character varying(50) NOT NULL,
    "lastName" character varying(50) NOT NULL
);


ALTER TABLE public."systemPersonel" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16782)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    "userEmail" character varying(50) NOT NULL,
    password character varying(50) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2871 (class 2606 OID 16796)
-- Name: employer employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 16806)
-- Name: jobDescription jobDescription_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobDescription"
    ADD CONSTRAINT "jobDescription_pkey" PRIMARY KEY ("jobId");


--
-- TOC entry 2873 (class 2606 OID 16801)
-- Name: jobSeeker jobSeeker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobSeeker"
    ADD CONSTRAINT "jobSeeker_pkey" PRIMARY KEY (id);


--
-- TOC entry 2875 (class 2606 OID 16825)
-- Name: jobSeeker nationalityId_ukey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobSeeker"
    ADD CONSTRAINT "nationalityId_ukey" UNIQUE ("nationalityId");


--
-- TOC entry 2879 (class 2606 OID 16827)
-- Name: jobDescription position_ukey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobDescription"
    ADD CONSTRAINT position_ukey UNIQUE ("position");


--
-- TOC entry 2869 (class 2606 OID 16791)
-- Name: systemPersonel systemPersonel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."systemPersonel"
    ADD CONSTRAINT "systemPersonel_pkey" PRIMARY KEY (id);


--
-- TOC entry 2865 (class 2606 OID 16823)
-- Name: users userEmail_ukey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT "userEmail_ukey" UNIQUE ("userEmail");


--
-- TOC entry 2867 (class 2606 OID 16786)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 16817)
-- Name: employer employer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_id_fkey FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2882 (class 2606 OID 16812)
-- Name: jobSeeker jobSeeker_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."jobSeeker"
    ADD CONSTRAINT "jobSeeker_id_fkey" FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2880 (class 2606 OID 16807)
-- Name: systemPersonel systemPersonel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."systemPersonel"
    ADD CONSTRAINT "systemPersonel_id_fkey" FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-05-15 12:05:30

--
-- PostgreSQL database dump complete
--

