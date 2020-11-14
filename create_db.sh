#!/bin/bash

psql postgres -h 127.0.0.1 -d demo -f ./boot-security-jdbc/DATABASE.sql
