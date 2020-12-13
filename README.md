# Test Spigot Plugin

This is an example plugin I wrote for Spigot servers.

## Prerequisites

- Java 1.8 SDK
- Docker (for running test server)
- Make (for using the Makefile)

## Getting started

To get started with the development of this plugin, follow these steps:

1. `git clone` the repository
1. Run `make p` to create a plugin package
1. Run `make r` to spin up a server using docker in `./test-server` and copy the jar files into the plugin directory
1. Open Minecraft and connect to `localhost`
1. Run `make l` to see the server logs

If you want to restart/reload the server plugins and copy the latest codebase
into the test server, run `make cr`.

## Makefile

Use `make help` to get a list of commands that are useful during development.
