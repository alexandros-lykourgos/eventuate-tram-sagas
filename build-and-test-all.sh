#! /bin/bash

set -e

. ./set-env.sh

docker-compose down -v

docker-compose up -d --build zookeeper mysql kafka

./wait-for-mysql.sh

docker-compose up -d --build

./gradlew :orders-and-customers:cleanTest build

docker-compose down -v
