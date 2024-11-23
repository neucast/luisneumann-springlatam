#! /bin/bash

CONTAINER_NAME=mysql-container
MYSQL_ROOT_PASSWORD=rootPswd-1
MYSQL_DATABASE_NAME=springlatam_labs

sudo docker stop $CONTAINER_NAME

sudo docker rm $CONTAINER_NAME

sudo docker run --name $CONTAINER_NAME -p3306:3306 -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD -e MYSQL_DATABASE=$MYSQL_DATABASE_NAME -d mysql

sudo docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $CONTAINER_NAME

sudo docker exec -ti $CONTAINER_NAME sh -c 'mkdir app'

sudo docker cp /home/lneumann/Documents/spring/luisneumann-springlatam-labs/fundamentos-aplicacion/src/main/resources/com/luis/neumann/mysql/v1/schema.sql $CONTAINER_NAME:/app
sudo docker cp /home/lneumann/Documents/spring/luisneumann-springlatam-labs/fundamentos-aplicacion/src/main/resources/com/luis/neumann/mysql/v1/data.sql $CONTAINER_NAME:/app

#sudo docker exec -ti $CONTAINER_NAME sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD" $MYSQL_DATABASE_NAME -e "source ./app/schema.sql"'
#sudo docker exec -ti $CONTAINER_NAME sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD" $MYSQL_DATABASE_NAME -e "source ./app/data.sql"'
#sudo docker exec -ti $CONTAINER_NAME sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD" $MYSQL_DATABASE_NAME -e "SELECT * FROM libro"'


#sudo docker exec -i mysql-container sh -c 'mysql -uroot -p"rootPswd-1" springlatam_labs -e "source ./app/schema.sql"'
#sudo docker exec -i mysql-container sh -c 'exec mysql -uroot -p"rootPswd-1" springlatam_labs -e "source ./app/data.sql"'
#sudo docker exec -i mysql-container sh -c 'exec mysql -uroot -p"rootPswd-1" springlatam_labs -e "SELECT * FROM libro"'

#sudo docker exec mysql-container sh -c 'exec mysqldump --all-databases -uroot -p"rootPswd-1"' > /home/lneumann/Documents/all-databases.sql
#sudo docker exec -i mysql-container sh -c 'exec mysql -uroot -p"rootPswd-1"' < /home/lneumann/Documents/all-databases.sql