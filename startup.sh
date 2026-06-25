#!/bin/sh
# Transform postgres:// to jdbc:postgresql://
if echo "$SPRING_DATASOURCE_URL" | grep -q "^postgres://"; then
  URL=$(echo "$SPRING_DATASOURCE_URL" | sed 's|^postgres://|jdbc:postgresql://|')
  export SPRING_DATASOURCE_URL="$URL"
fi
exec java -jar target/MiniInventario-0.0.1-SNAPSHOT.jar