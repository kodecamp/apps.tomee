#! /bin/bash

curl --request GET http://localhost:8080/api/students/1 | json_pp
