#!/bin/bash

chmod +x ./docker_deploy.sh
./docker_deploy.sh
chmod +x ./maven_deploy.sh
./maven_deploy.sh
chmod +x ./gcloud_deploy.sh
./gcloud_deploy.sh