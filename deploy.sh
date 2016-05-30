#!/bin/bash

# Exit on any error
set -e

sudo /opt/google-cloud-sdk/bin/gcloud docker push gcr.io/${PROJECT_NAME}/springboottest:$CIRCLE_SHA1
sudo chown -R ubuntu:ubuntu /home/ubuntu/.kube
kubectl patch deployment springboot-node -p '{"spec":{"template":{"spec":{"containers":[{"name":"springboot-node","image":"gcr.io/'"${PROJECT_NAME}"'/springboottest:'"$CIRCLE_SHA1"'"}]}}}}'