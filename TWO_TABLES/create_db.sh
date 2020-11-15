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


psql postgres -h 127.0.0.1 -d demo -f ./boot-security-jdbc/DATABASE.sql
