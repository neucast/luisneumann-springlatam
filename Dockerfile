# Use the official MySQL image as a base
FROM mysql:latest

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Set the default user for the MySQL image
USER mysql

# Set environment variables for the new user
ENV MYSQL_USER=dbo_user
ENV MYSQL_PASSWORD=dboPswd$2024
ENV MYSQL_DATABASE=springlatam_labs
ENV MYSQL_ROOT_PASSWORD=rootPswd$2024

# Run the following commands to create the new user and grant them the necessary permissions
RUN mysql -u root -p -e "CREATE USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';"
RUN mysql -u root -p -e "GRANT ALL PRIVILEGES ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'%';"
RUN mysql -u root -p -e "FLUSH PRIVILEGES;"

RUN mysql -u root -p -e "SOURCE ./app/schema.sql;"
RUN mysql -u root -p -e "SOURCE ./app/data.sql;"


# Expose port 3306 to allow connections to the database
EXPOSE 3306

# Start the MySQL server when the container is run
CMD ["mysqld"]