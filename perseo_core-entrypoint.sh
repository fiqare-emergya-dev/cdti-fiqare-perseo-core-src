#!/bin/bash

DERAULT_PERSEO_FE_URL=PERSEO_FE_ENDPOINT

PERSEO_FE_URL_ARG=${1}
PERSEO_FE_URL_VALUE=${2}
if [ "$PERSEO_FE_URL_ARG" == "-perseo_fe_url" ]; then
    sed -i 's/'$DEFAULT_PERSEO_FE_URL'/'$PERSEO_FE_URL_VALUE'/g' /etc/perseo-core.properties
fi

service tomcat start && tail -f /var/log/tomcat/catalina.out
