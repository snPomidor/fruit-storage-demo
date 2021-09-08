CREATE TABLE contractors
(
    id          NUMBER PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    inn         VARCHAR(10)  NOT NULL,
    address     VARCHAR(250),
    email       VARCHAR(50),
    phone       VARCHAR(12),
    description VARCHAR(250)
);

CREATE TABLE product_category
(
    id        NUMBER PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    parent_id NUMBER,
    CONSTRAINT fk_pc_parent
        FOREIGN KEY (parent_id)
            REFERENCES product_category (id)
);

CREATE TABLE products
(
    id          NUMBER PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    category_id INT          NOT NULL,
    CONSTRAINT fk_pr_category
        FOREIGN KEY (category_id)
            REFERENCES product_category (id)
);

CREATE TABLE prices
(
    id            NUMBER PRIMARY KEY,
    contractor_id NUMBER    NOT NULL,
    product_id    NUMBER    NOT NULL,
    value         NUMBER(5,2) NOT NULL,
    date_from     DATE NOT NULL,
    date_to       DATE NOT NULL,
    CONSTRAINT fk_prc_contractor
        FOREIGN KEY (contractor_id)
            REFERENCES contractors (id),
    CONSTRAINT fk_prc_product
        FOREIGN KEY (product_id)
            REFERENCES products (id)
);

CREATE TABLE deliveries
(
    id                 NUMBER PRIMARY KEY,
    contractor_id      NUMBER NOT NULL,
    delivery_date_plan DATE,
    delivery_date_fact DATE,
    total_weight       NUMBER(6,3),
    total_cost         NUMBER(15,2),
    accepted           NUMBER(1) DEFAULT 0,
    accepted_date      DATE,
    comment            VARCHAR(250),
    CONSTRAINT fk_dlr_contractor
        FOREIGN KEY (contractor_id)
            REFERENCES contractors (id)
);

CREATE TABLE consignments
(
    id NUMBER PRIMARY KEY,
    delivery_id NUMBER NOT NULL,
    product_id NUMBER NOT NULL,
    weight NUMBER (15, 3) NOT NULL,
    CONSTRAINT fk_cons_delivery
        FOREIGN KEY (delivery_id)
            REFERENCES deliveries (id),
    CONSTRAINT fk_cons_product
        FOREIGN KEY (product_id)
            REFERENCES products (id)
);
