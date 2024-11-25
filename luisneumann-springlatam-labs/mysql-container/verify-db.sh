#! /bin/bash

CONTAINER_NAME=springlatamLabsDb
MYSQL_ROOT_PASSWORD=rootPswd-1
MYSQL_DATABASE_NAME=springlatam_labs

#sudo docker exec -it $CONTAINER_NAME bash

sudo docker exec -ti $CONTAINER_NAME sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD" $MYSQL_DATABASE_NAME -e "USE springlatam_labs; SELECT * FROM libro;"'

