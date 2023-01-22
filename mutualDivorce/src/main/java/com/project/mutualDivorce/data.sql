CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    surname  VARCHAR(255),
    afm      INT                   NOT NULL,
    amka     INT                   NOT NULL,
    password VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);
CREATE TABLE divorces
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    epimeleia_paidiwn    VARCHAR(255),
    akiniti_periousia    VARCHAR(255),
    logariasmoi_trapezwn VARCHAR(255),
    idiotiki_xrisi       VARCHAR(255),
    reason               VARCHAR(255),
    user_id              BIGINT,
    CONSTRAINT pk_divorces PRIMARY KEY (id)
);

ALTER TABLE divorces
    ADD CONSTRAINT FK_DIVORCES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);