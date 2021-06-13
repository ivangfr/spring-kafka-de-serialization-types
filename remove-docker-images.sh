#!/usr/bin/env bash

source my-functions.sh

check_script_input_parameter $1

if [ "$1" = "string-producer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/string-producer-service:1.0.0

fi

if [ "$1" = "string-consumer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/string-consumer-service:1.0.0

fi

if [ "$1" = "json-producer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/json-producer-service:1.0.0

fi

if [ "$1" = "json-consumer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/json-consumer-service:1.0.0

fi

if [ "$1" = "avro-producer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-producer-service:1.0.0

fi

if [ "$1" = "avro-consumer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-consumer-service:1.0.0

fi

if [ "$1" = "avro-2-producer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-2-producer-service:1.0.0

fi

if [ "$1" = "avro-2-consumer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-2-consumer-service:1.0.0

fi

if [ "$1" = "avro-3-producer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-3-producer-service:1.0.0

fi

if [ "$1" = "avro-3-consumer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  docker rmi ivanfranchin/avro-3-consumer-service:1.0.0

fi
