# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table panelist (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  password_hash             varchar(255),
  provider_id               bigint,
  birth_date                timestamp,
  gender                    integer,
  country                   varchar(255),
  district                  varchar(255),
  city                      varchar(255),
  project                   varchar(255),
  source_log                varchar(255),
  activation_key            varchar(255),
  activated                 boolean,
  disabled                  boolean,
  disabled_reason           varchar(255),
  last_ip                   varchar(255),
  created_at                timestamp,
  modified_at               timestamp,
  activated_at              timestamp,
  constraint ck_panelist_gender check (gender in (0,1)),
  constraint uq_panelist_email unique (email),
  constraint pk_panelist primary key (id))
;

create table provider (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_provider primary key (id))
;

create sequence panelist_seq;

create sequence provider_seq;

alter table panelist add constraint fk_panelist_provider_1 foreign key (provider_id) references provider (id) on delete restrict on update restrict;
create index ix_panelist_provider_1 on panelist (provider_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists panelist;

drop table if exists provider;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists panelist_seq;

drop sequence if exists provider_seq;

