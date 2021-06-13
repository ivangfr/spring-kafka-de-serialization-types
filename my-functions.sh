#!/usr/bin/env bash

# -- check_script_input_parameter --
# $1: input parameter
function check_script_input_parameter() {
  if [ "$1" != "all" ] &&
     [ "$1" != "string-de-serialization" ] &&
     [ "$1" != "string-producer-service" ] &&
     [ "$1" != "string-consumer-service" ] &&
     [ "$1" != "json-de-serialization" ] &&
     [ "$1" != "json-producer-service" ] &&
     [ "$1" != "json-consumer-service" ] &&
     [ "$1" != "avro-de-serialization" ] &&
     [ "$1" != "avro-producer-service" ] &&
     [ "$1" != "avro-consumer-service" ] &&
     [ "$1" != "avro-2-de-serialization" ] &&
     [ "$1" != "avro-2-producer-service" ] &&
     [ "$1" != "avro-2-consumer-service" ] &&
     [ "$1" != "avro-3-de-serialization" ] &&
     [ "$1" != "avro-3-producer-service" ] &&
     [ "$1" != "avro-3-consumer-service" ];
  then
    printf "Invalid application name or sample provided!"
    printf "\nValid Parameters:"

    printf "\n\tall"

    printf "\n\tstring-de-serialization"
    printf "\n\t\tstring-producer-service"
    printf "\n\t\tstring-consumer-service"

    printf "\n\tjson-de-serialization"
    printf "\n\t\tjson-producer-service"
    printf "\n\t\tjson-consumer-service"

    printf "\n\tavro-de-serialization"
    printf "\n\t\tavro-producer-service"
    printf "\n\t\tavro-consumer-service"

    printf "\n\tavro-2-de-serialization"
    printf "\n\t\tavro-2-producer-service"
    printf "\n\t\tavro-2-consumer-service"

    printf "\n\tavro-3-de-serialization"
    printf "\n\t\tavro-3-producer-service"
    printf "\n\t\tavro-3-consumer-service"

    printf "\n"
    exit 1
  fi
}