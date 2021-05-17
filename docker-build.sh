#!/usr/bin/env bash

source my-functions.sh

check_script_input_parameter $1

if [ "$1" = "string-producer-service" ] ||
   [ "$1" = "string-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-PRODUCER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects string-serialization/string-producer-service
  else
    ./mvnw clean package jib:dockerBuild --projects string-serialization/string-producer-service
  fi
fi

if [ "$1" = "string-consumer-service" ] ||
   [ "$1" = "string-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-CONSUMER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects string-serialization/string-consumer-service
  else
    ./mvnw clean package jib:dockerBuild --projects string-serialization/string-consumer-service
  fi
fi

if [ "$1" = "json-producer-service" ] ||
   [ "$1" = "json-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-PRODUCER-SERVICE"
  echo "---------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects json-serialization/json-producer-service
  else
    ./mvnw clean package jib:dockerBuild --projects json-serialization/json-producer-service
  fi
fi

if [ "$1" = "json-consumer-service" ] ||
   [ "$1" = "json-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-CONSUMER-SERVICE"
  echo "---------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects json-serialization/json-consumer-service
  else
    ./mvnw clean package jib:dockerBuild --projects json-serialization/json-consumer-service
  fi
fi

if [ "$1" = "avro-producer-service" ] ||
   [ "$1" = "avro-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-PRODUCER-SERVICE"
  echo "---------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-serialization/avro-producer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-serialization/avro-producer-service
  fi
fi

if [ "$1" = "avro-consumer-service" ] ||
   [ "$1" = "avro-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-CONSUMER-SERVICE"
  echo "---------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-serialization/avro-consumer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-serialization/avro-consumer-service
  fi
fi

if [ "$1" = "avro-2-producer-service" ] ||
   [ "$1" = "avro-2-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-PRODUCER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-2-serialization/avro-2-producer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-2-serialization/avro-2-producer-service
  fi
fi

if [ "$1" = "avro-2-consumer-service" ] ||
   [ "$1" = "avro-2-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-CONSUMER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-2-serialization/avro-2-consumer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-2-serialization/avro-2-consumer-service
  fi
fi

if [ "$1" = "avro-3-producer-service" ] ||
   [ "$1" = "avro-3-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-PRODUCER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-3-serialization/avro-3-producer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-3-serialization/avro-3-producer-service
  fi
fi

if [ "$1" = "avro-3-consumer-service" ] ||
   [ "$1" = "avro-3-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-CONSUMER-SERVICE"
  echo "-----------------------"

  if [ "$2" = "native" ];
  then
    ./mvnw clean spring-boot:build-image --projects avro-3-serialization/avro-3-consumer-service
  else
    ./mvnw clean package jib:dockerBuild --projects avro-3-serialization/avro-3-consumer-service
  fi
fi