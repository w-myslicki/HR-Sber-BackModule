#!/bin/sh

echo "Waiting for Kafka..."

while ! nc -z kafka 9092; do
    sleep 0.1
done

echo "Kafka started."
