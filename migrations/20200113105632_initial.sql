-- +goose Up
-- +goose StatementBegin
create table coffees
(
    cof_name varchar(255)  not null
        primary key,
    sup_id   int           null,
    price    double        null,
    sales    int default 0 null,
    total    int default 0 null
);
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
SELECT 'down SQL query';
-- +goose StatementEnd
