curl requests for Shop Endpoints;

curl -X 'POST' \
  'http://localhost:8201/api/v1/shop/register' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "shopName": "ECONET SHOP",
  "location": "First Street"
}'


curl -X 'GET' \
  'http://localhost:8201/api/v1/shop/name/get?shop-name=MY%20SHOP' \
  -H 'accept: application/json'
  
  
  
curl -X 'GET' \
  'http://localhost:8201/api/v1/shop/all/get' \
  -H 'accept: application/json'
  
  curl -X 'GET' \
    'http://localhost:8201/api/v1/shop/location/get?area=First%20Street' \
    -H 'accept: application/json'

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  
  curl requests for Area Endpoints;
  
  
 curl -X 'POST' \
  'http://localhost:8201/api/v1/location/register' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "location": "Fourth Street"
}'


curl -X 'GET' \
  'http://localhost:8201/api/v1/location/name/get?area-name=First%20Street' \
  -H 'accept: application/json'
  
  
  curl -X 'GET' \
  'http://localhost:8201/api/v1/location/all/get' \
  -H 'accept: application/json'
  
  
  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  
 To test application;

 -Clone project from github and download all the dependencies needed.
 - Run application in your IDE
 - go to "http://localhost:8201/swagger-ui.html" for swagger API documentation.
 - if you choose docker, run the docker file and once it's running, do step 4.

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

