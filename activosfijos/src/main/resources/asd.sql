-- User: asd
-- DROP USER asd;

CREATE USER asd WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION;

CREATE DATABASE activos_fijos
    WITH 
    OWNER = asd
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.tipologia

-- DROP TABLE public.tipologia;

CREATE TABLE public.tipologia
(
    id integer NOT NULL DEFAULT nextval('tipologia_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    padre smallint,
    CONSTRAINT tipologia_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tipologia
    OWNER to asd;

	
CREATE TABLE public.activo_fijo
(
    serial character varying(25) COLLATE pg_catalog."default" NOT NULL,
    alto integer,
    ancho integer,
    color character varying(10) COLLATE pg_catalog."default",
    fecha_baja date,
    fecha_compra date,
    largo integer,
    nombre character varying(50) COLLATE pg_catalog."default",
    numero_interno character varying(25) COLLATE pg_catalog."default",
    peso numeric(19, 2),
    valor_compra numeric(19, 2),
    estado_actual integer,
    tipo integer,
    CONSTRAINT activo_fijo_pkey PRIMARY KEY (serial),
    CONSTRAINT fk8emaul9b7vr18yhxgn1v5855k FOREIGN KEY (estado_actual)
        REFERENCES public.tipologia (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkbc4pmha2cd8ux06x9si2c4y1e FOREIGN KEY (tipo)
        REFERENCES public.tipologia (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.activo_fijo
    OWNER to asd;
	
	-- Table: public.asignacion

-- DROP TABLE public.asignacion;

CREATE TABLE public.asignacion
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    serial character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT asignacion_pkey PRIMARY KEY (id, serial),
    CONSTRAINT fk_activo FOREIGN KEY (serial)
        REFERENCES public.activo_fijo (serial) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_entidad FOREIGN KEY (id)
        REFERENCES public.entidad (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.asignacion
    OWNER to asd;
	
	
	-- Table: public.entidad

-- DROP TABLE public.entidad;

CREATE TABLE public.entidad
(
    id character varying(16) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    tipo integer NOT NULL,
    CONSTRAINT entidad_pkey PRIMARY KEY (id),
    CONSTRAINT fklwrs5cw9dbadh528kdx0uyjj2 FOREIGN KEY (tipo)
        REFERENCES public.tipologia (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.entidad
    OWNER to asd;
	
	
	