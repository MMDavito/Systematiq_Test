#!/bin/bash
printf "Hello World, will try regestering an user: 'testanvändare' with password 'test'\n\n"
curl --location --request POST 'localhost:8080/register-user' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=2616A2C7BEDC255F755AD69F0D7F4393' \
--data-raw '{
	"userName":"testanvändare",
	"password":"test"
}'
printf "\n\n"


curl -i -X POST -c cookies.txt -u "testanvändare:test" localhost:8080/login
#cat cookies.txt
echo "Will now check if i am authenticated, should return 204 'NO CONTENT'"
curl -i -b cookies.txt --location --request GET 'localhost:8080/is_authenticated' \

echo "Will now try to logout, should return 204 'NO CONTENT"
curl -i -X PUT -c cookies.txt -u "super3:super" localhost:8080/logout
#cat cookies.txt

echo "Will now check if I'm still authenticated, should return a 401 UNAUTHORIZED:"
curl -b cookies.txt --location --request GET 'localhost:8080/is_authenticated' \


#curl --location --request GET 'localhost:8080/is_authenticated' \
#--header 'Cookie: JSESSIONID=2616A2C7BEDC255F755AD69F0D7F4393'