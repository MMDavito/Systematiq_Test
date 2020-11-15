#!/bin/bash

createDB()
{
sudo su postgres <<EOF
psql -c 'CREATE DATABASE demo_single;'
EOF
exit
}

echo "Hello World"

#createDB
if [[ $(createDB 2>&1) =~ "ERROR:  database \"demo_single\" already exists" ]]
then
    echo "ERROR:  database \"demo_single\" already exists"
fi
