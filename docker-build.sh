#!/usr/bin/env bash

source my-functions.sh

check_script_input_parameter $1

if [ "$1" = "string-producer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects string-de-serialization/string-producer-service

fi

if [ "$1" = "string-consumer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects string-de-serialization/string-consumer-service

fi

if [ "$1" = "json-producer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-PRODUCER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild --projects json-de-serialization/json-producer-service

fi

if [ "$1" = "json-consumer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-CONSUMER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild --projects json-de-serialization/json-consumer-service

fi

if [ "$1" = "avro-producer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-PRODUCER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-de-serialization/avro-producer-service

fi

if [ "$1" = "avro-consumer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-CONSUMER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-de-serialization/avro-consumer-service

fi

if [ "$1" = "avro-2-producer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-2-de-serialization/avro-2-producer-service

fi

if [ "$1" = "avro-2-consumer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-2-de-serialization/avro-2-consumer-service

fi

if [ "$1" = "avro-3-producer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-3-de-serialization/avro-3-producer-service

fi

if [ "$1" = "avro-3-consumer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild --projects avro-3-de-serialization/avro-3-consumer-service

fi