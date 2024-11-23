#! /bin/bash

CONTAINER_NAME=springlatamLabsDb
MYSQL_ROOT_PASSWORD=rootPswd-1
MYSQL_DATABASE_NAME=springlatam_labs

sudo docker stop $CONTAINER_NAME

sudo docker rm $CONTAINER_NAME

sudo docker run --name $CONTAINER_NAME -p3306:3306 -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD -e MYSQL_DATABASE=$MYSQL_DATABASE_NAME -d springlatam-labs-db:1.0

sudo docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $CONTAINER_NAME

#sudo docker exec -it $CONTAINER_NAME bash

# See: https://dev.to/sumana2001/build-a-custom-mysql-docker-container-404f