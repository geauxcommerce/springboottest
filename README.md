# springboottest

## Status
[![Circle CI](https://circleci.com/gh/geauxcommerce/springboottest.svg?style=svg)](https://circleci.com/gh/geauxcommerce/springboottest)

# Docker Commands

## To build the docker image

	$ docker build -t geauxcommerce/springbootservice .

## To see the docker images available

	$ docker images
## To see the running docker processes

	$ docker ps
## To create and delete the container

	$ docker run -d -p 8080:8080 --name springbootservice geauxcommerce/springbootservice
	$ docker rm springbootservice

## To start and stop the service once the container is created
	$ docker start springbootservice
	$ docker stop springbootservice
