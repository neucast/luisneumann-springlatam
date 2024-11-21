#! /bin/bash

sudo docker stop mysql-server

sudo docker rm mysql-server

sudo docker run --name mysql-server -p3306:3306 -e MYSQL_ROOT_PASSWORD=rootPswd$1 -e MYSQL_DATABASE=springlatam_labs -d mysql

sudo docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysql-server

sudo docker exec -i mysql-server sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < ./schema.sql
sudo docker exec -i mysql-server sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < ./data.sql

