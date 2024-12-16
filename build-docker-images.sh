#!/usr/bin/env bash

source my-functions.sh

check_script_input_parameter $1

DOCKER_IMAGE_PREFIX="ivanfranchin"
APP_VERSION="1.0.0"

STRING_PRODUCER_SERVICE_APP_NAME="string-producer-service"
STRING_CONSUMER_SERVICE_APP_NAME="string-consumer-service"
JSON_PRODUCER_SERVICE_APP_NAME="json-producer-service"
JSON_CONSUMER_SERVICE_APP_NAME="json-consumer-service"
AVRO_PRODUCER_SERVICE_APP_NAME="avro-producer-service"
AVRO_CONSUMER_SERVICE_APP_NAME="avro-consumer-service"
AVRO_2_PRODUCER_SERVICE_APP_NAME="avro-2-producer-service"
AVRO_2_CONSUMER_SERVICE_APP_NAME="avro-2-consumer-service"
AVRO_3_PRODUCER_SERVICE_APP_NAME="avro-3-producer-service"
AVRO_3_CONSUMER_SERVICE_APP_NAME="avro-3-consumer-service"

STRING_PRODUCER_SERVICE_PROJECT_NAME="string-de-serialization/${STRING_PRODUCER_SERVICE_APP_NAME}"
STRING_CONSUMER_SERVICE_PROJECT_NAME="string-de-serialization/${STRING_CONSUMER_SERVICE_APP_NAME}"
JSON_PRODUCER_SERVICE_PROJECT_NAME="json-de-serialization/${JSON_PRODUCER_SERVICE_APP_NAME}"
JSON_CONSUMER_SERVICE_PROJECT_NAME="json-de-serialization/${JSON_CONSUMER_SERVICE_APP_NAME}"
AVRO_PRODUCER_SERVICE_PROJECT_NAME="avro-de-serialization/${AVRO_PRODUCER_SERVICE_APP_NAME}"
AVRO_CONSUMER_SERVICE_PROJECT_NAME="avro-de-serialization/${AVRO_CONSUMER_SERVICE_APP_NAME}"
AVRO_2_PRODUCER_SERVICE_PROJECT_NAME="avro-2-de-serialization/${AVRO_2_PRODUCER_SERVICE_APP_NAME}"
AVRO_2_CONSUMER_SERVICE_PROJECT_NAME="avro-2-de-serialization/${AVRO_2_CONSUMER_SERVICE_APP_NAME}"
AVRO_3_PRODUCER_SERVICE_PROJECT_NAME="avro-3-de-serialization/${AVRO_3_PRODUCER_SERVICE_APP_NAME}"
AVRO_3_CONSUMER_SERVICE_PROJECT_NAME="avro-3-de-serialization/${AVRO_3_CONSUMER_SERVICE_APP_NAME}"

STRING_PRODUCER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${STRING_PRODUCER_SERVICE_APP_NAME}:${APP_VERSION}"
STRING_CONSUMER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${STRING_CONSUMER_SERVICE_APP_NAME}:${APP_VERSION}"
JSON_PRODUCER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${JSON_PRODUCER_SERVICE_APP_NAME}:${APP_VERSION}"
JSON_CONSUMER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${JSON_CONSUMER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_PRODUCER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_PRODUCER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_CONSUMER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_CONSUMER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_2_PRODUCER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_2_PRODUCER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_2_CONSUMER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_2_CONSUMER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_3_PRODUCER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_3_PRODUCER_SERVICE_APP_NAME}:${APP_VERSION}"
AVRO_3_CONSUMER_SERVICE_DOCKER_IMAGE_NAME="${DOCKER_IMAGE_PREFIX}/${AVRO_3_CONSUMER_SERVICE_APP_NAME}:${APP_VERSION}"

SKIP_TESTS="true"

if [ "$1" = "string-producer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$STRING_PRODUCER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$STRING_PRODUCER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "string-consumer-service" ] ||
   [ "$1" = "string-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "STRING-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$STRING_CONSUMER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$STRING_CONSUMER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "json-producer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-PRODUCER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$JSON_PRODUCER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$JSON_PRODUCER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "json-consumer-service" ] ||
   [ "$1" = "json-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "JSON-CONSUMER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$JSON_CONSUMER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$JSON_CONSUMER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-producer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-PRODUCER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_PRODUCER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_PRODUCER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-consumer-service" ] ||
   [ "$1" = "avro-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "---------------------"
  echo "AVRO-CONSUMER-SERVICE"
  echo "---------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_CONSUMER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_CONSUMER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-2-producer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_2_PRODUCER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_2_PRODUCER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-2-consumer-service" ] ||
   [ "$1" = "avro-2-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-2-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_2_CONSUMER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_2_CONSUMER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-3-producer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-PRODUCER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_3_PRODUCER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_3_PRODUCER_SERVICE_DOCKER_IMAGE_NAME"

fi

if [ "$1" = "avro-3-consumer-service" ] ||
   [ "$1" = "avro-3-de-serialization" ] ||
   [ "$1" = "all" ];
then

  echo
  echo "-----------------------"
  echo "AVRO-3-CONSUMER-SERVICE"
  echo "-----------------------"

  ./mvnw clean compile jib:dockerBuild \
    --projects "$AVRO_3_CONSUMER_SERVICE_PROJECT_NAME" \
    -DskipTests="$SKIP_TESTS" \
    -Dimage="$AVRO_3_CONSUMER_SERVICE_DOCKER_IMAGE_NAME"

fi