#!/bin/sh

sh ./scripts/postgres.sh

sh ./scripts/kafka.sh

exec "$@"
