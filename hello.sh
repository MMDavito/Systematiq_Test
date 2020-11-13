#!/bin/bash

createDB()
{
sudo su postgres <<EOF
psql -c 'CREATE DATABASE demo;'
EOF
exit
}
createSchema(){
sudo su postgres <<EOF
psql -c 'CREATE SCHEMA IF NOT EXISTS demo_schema AUTHORIZATION postgres;'
EOF
exit
}

echo "Hello World"


if [[ $(createDB 2>&1) =~ "ERROR:  database \"demo\" already exists" ]]
then
    echo "ERROR:  database \"demo\" already exists"
fi

#createDB || true
echo "HELLO SECOND WORLD"
createSchema
echo "Hello third world"

#Will here launch the server and run the commands:
curl --location --request GET 'http://127.0.0.1:8080/api/v1/phones'

