# 177-180: MySQL Database

puth the php files to `/Library/WebServer/Documents`

## MySql

http://dev.mysql.com/downloads/mysql/

Begin Your Download - mysql-5.7.16-osx10.11-x86_64.dmg
2016-10-19T03:13:16.829768Z 1 [Note] A temporary password is generated for root@localhost: 5g5W26f)iiPF

If you lose this password, please consult the section How to Reset the Root Password in the MySQL reference manual.

```bash
➜  ~ vi ~/.bashrc
➜  ~ vi .zshrc

#mysql
alias mysql='/usr/local/mysql/bin/mysql'
alias mysqladmin='/usr/local/mysql/bin/mysqladmin'
```

## REBOOT computer

## mysql script

http://www.sampleprogramz.com/android/

## change root password and create table

```bash
➜  ~ mysqladmin -u root -p password root
Enter password:
mysqladmin: [Warning] Using a password on the command line interface can be insecure.
Warning: Since password will be sent to server in plain text, use ssl connection to ensure password safety.
➜  ~ mysql -uroot -p
Enter password:
mysql> create database android;
Query OK, 1 row affected (0.02 sec)
mysql> use android
Database changed
mysql> create table sample (id int primary key, name varchar(25));
Query OK, 0 rows affected (0.12 sec)

mysql> select * from sample;
+----+---------------+
| id | name          |
+----+---------------+
|  5 | AndroidDevLog |
|  6 | iOSDevLog     |
+----+---------------+
2 rows in set (0.00 sec)
```
