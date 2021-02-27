#!/bin/sh

./scripts/postgres.sh

./scripts/kafka.sh

exec "$@"
