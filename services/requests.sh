#! /bin/bash

# variables
url=http://localhost:8080/services/api/students

# functions
get_all() {
  echo "#################### get_all ####################"
  echo "hitting url : $url"
  echo "#################### ####### ###################"
  curl --request GET $url | json_pp
}

get_by_id() {
  echo "#################### get_by_id ####################"
  echo "hitting url : $url/$1"
  echo "#################### ####### ####################"
  curl --request GET $url/$1 | json_pp
}

DeleteById() {
  echo "#################### DeleteById #################"
  echo "hitting url : $url/$1"
  echo "#################### ####### ####################"
  #curl --request GET $url/$1
}

generate_put_data()
{
  cat <<EOF
{
  "name": "$newName",
  "address": "$newAddress"
}
EOF
}

update_by_id() {
  echo "#################### update_by_id #################"
  echo "hitting url : $url/$1"
  echo "Suffix of new values : $2"
  echo "#################### ####### ####################"
  local data="{\"name\": \"Updated $2\", \"address\": \"Updated $2\"}"
  local newName="Name Updated $2"
  local newAddress="Address Updated $2"
  echo "data : $data"
  command curl --request PUT \
  --header "Content-type: application/json" \
  --data  "$(generate_put_data)" $url/$1
}

generate_post_data()
{
  cat <<EOF
{
  "name": "$name",
  "address": "$address"
}
EOF
}

create_new() {
  echo "#################### create_new ##################"
  echo "hitting url : $url"
  local data="'{\"name\": \"Name $1\", \"address\": \"Address $1\"}'"
  echo "data : $data"
  local name="Name $1"
  local address="Address $1"
  echo $(generate_post_data)
  echo "#################### ####### ####################"
  command curl --request POST \
  --header "Content-type: application/json" \
  --data "$(generate_post_data)" $url | json_pp
}


case  $1  in
       getall)
         echo "Getting all records"
         get_all
         ;;
       getbyid)
         echo "Getting by Id: $2"
         get_by_id $2
         ;;
       post)
         echo "Posting data $2"
         create_new $2
         ;;
       deletebyid)
         echo "Deleting data : id = $2"
         ;;
       putbyid)
         echo "Updating data : id = $2"
         update_by_id $2 $3
         ;;
       *)
esac



#
