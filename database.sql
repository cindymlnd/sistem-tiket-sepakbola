SQL> create tablespace BOLA07047_
 2 datafile ‘D:\BDmod1\BOLA_07047.dbf’
 3 size 30M;

Tablespace created.

SQL> create user cindymelinda07047
 2 identified by 07047
 3 default tablespace BOLA07047
 4 quota 30M on BOLA07047;

User created.

SQL> grant all privileges to cindymelinda07047
Grant succeeded.

SQL> conn cindymelinda07047/07047
Connected.

SQL> create table pembeli_07047
  (
  ID_pembeli	INTEGER		not null,
  nama_pembeli	VARCHAR2(30),
  gender	VARCHAR2(10),
  alamat	VARCHAR2(100),
  constraint PK_pembeli primary key (ID_pembeli)
  );

Table created.

SQL> create table jenis_tiket
  (
  ID_Jenistiket INTEGER		not null,
  varian_tiket	VARCHAR2(7)     
  harga		NUMBER(9),
  total_seat	NUMBER(5),
  constraint pk_ID_Jenistiket primary key (ID_Jenistiket)
  );

Table created.

SQL> create table pembayaran
  (
  ID_pembayaran	INTEGER   not null,
  ID_pembeli	INTEGER,
  ID_Jenistiket  INTEGER,
  jumlah_tiket	NUMBER(9),
  harga_total	NUMBER(10)
  );

Table created.

SQL> alter table pembayaran
  add constraint fk_id_pemebeli foreign key (id_pembeli)
  references pembeli_07047 (id_pembeli)
  add constraint fk_id_jenistiket foreign key(id_jenistiket)
  references jenis_tiket (id_jenistiket);

Table altered.

SQL> create sequence id_pembayaran
  minvalue 1
  maxvalue 9999
  start with 1
  increment by 1
   nocache;

Sequence created.

insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (4,’jaeyoon’,’pria’,’jeju’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (5,’hongman’,’pria’,’incheon’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (6,’minhyuk’,’pria’,’gwangju’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (7,’sungkyung’,’wanita’,’ansan’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (8,’sangyeol’,’pria’,’daegu’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (9,’jeongin’,’pria’,’seosan’);
insert into pembeli_07047 (ID_pembeli,Nama_pembeli,Gender,Alamat_07047) values (10,’suzy’,’wanita’,’gangnam’);


insert into jenis_tiket (ID_Jenistiket,Varian_tiket,Harga_,Total_seat) values (1,’vip’,’2000’,’1’);
insert into jenis_tiket (ID_Jenistiket,Varian_tiket,Harga_,Total_seat) values (2,’vvip’,’4000’,’2’);
into jenis_tiket (ID_Jenistiket,Varian_tiket,Harga_,Total_seat) values (3,’ekonomi’,’1000’,’3’);

insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (1,1,1,1,2000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (2,2,2,2,8000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (3,3,3,3,3000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (4,4,4,4,8000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (5,5,5,5,20000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (6,6,6,6,12000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (7,7,7,7,7000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (8,8,8,8,16000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (9,9,9,9,18000);
insert into pembayaran (ID_pembayaran,ID_Jenistiket,ID_pembeli,Jumlah_tiket,Harga_total) values (10,10,10,10,10000);

SELECT pembayaran.id_pembayaran as kode_bayar, pembayaran.jumlah_tiket as tiket_dibeli, pembayaran.harga_total as total_harga, pembeli_07047.*, jenis_tiket.* FROM PEMBAYARAN JOIN PEMBELI_07047 ON PEMBAYARAN.ID_PEMBELI=PEMBELI_07047.ID_PEMBELI JOIN JENIS_TIKET ON PEMBAYARAN.ID_JENISTIKET = JENIS_TIKET.ID_JENISTIKET ORDER BY ID_PEMBAYARAN ASC;




