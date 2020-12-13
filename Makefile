HELL := /bin/bash

MAKEFLAGS := --no-print-directory

.PHONY: help

.DEFAULT_GOAL := help

help:
	@echo "Please use 'make <target>' where <target> is one of"
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z\._-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

p: package
package: ## Package the project
	cd src && mvn package

r: run
run: ## Run a spigot server in the ./test-server directory
	mkdir -p ./test-server/plugins
	cp src/target/*.jar ./test-server/plugins
	docker run \
		-e SPIGOT_VER=1.16.4 \
		--name minecraft-spigot \
		-p 25565:25565 \
		-e SPIGOT_UID=1000 \
		--restart=always \
		-v $(CURDIR)/test-server:/minecraft \
		-e EULA=true \
		-d \
		nimmis/spigot

l: logs
logs: ## Show the logs of the test server
	docker exec minecraft-spigot mc_log

d: destroy
destroy: ## Destroy the spigot test server
	docker stop minecraft-spigot
	docker rm minecraft-spigot

cr: copyrestart
copyrestart: ## Copy the plugin to the server's plugin directory and restart the server
	cp src/target/*.jar ./test-server/plugins
	docker exec minecraft-spigot mc_restart

fmt: format
format: ## Run maven prettier over the code to fix codestyle
	cd src && mvn prettier:write

lint: ## Run maven prettier lint
	cd src && mvn prettier:check

t: test
test: ## Run unit tests
	cd src && mvn test
