# Find price API

This is an API with only one feature. It offers the price based on following input parameters:

* Application date
* Product id
* Brand id

The endpoint returns the price providing the following fields:

* product id
* brand id
* application date
* currency
* price

It is worth to mention that the endpoint always return the price to use.
If there are more that one price matching the conditions the one with highest priority is used.



## Dataset
The dataset is uploaded to the DB during service start up. 
The used is composed by the following data:

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST  | PRODUCT_ID  | PRIORITY   | PRICE      | CURRENCY   |
| -------- | ------------------- |-------------------- | ----------- | ----------- |----------- |----------- |----------- |
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1           | 35455       | 0          | 35.50      |EUR         |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2           | 35455       | 1          | 25.45      |EUR         |
| 1        | 2020-06-15-00.00.00 | 2020-06-14-18.30.00 | 3           | 35455       | 1          | 30.50      |EUR         |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4           | 35455       | 1          | 38.95      |EUR         |


### Query of example

#### Successfully query
##### Curl command

        curl --location --request GET 'http://localhost:8080/backend-challenge/price/' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "productId": "35455",
            "applicationDate": "2020-06-14T16:00:00",
            "brandId": "1"
        }'

#### Failed query: price not found
##### Curl command

        curl --location --request GET 'http://localhost:8080/backend-challenge/price/' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "productId": "35455",
            "applicationDate": "2020-06-14T16:00:00",
            "brandId": "2"
        }'