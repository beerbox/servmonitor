# Servmonitor


[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Simple system that allows to monitor utilisation of linux vms.

  - Live chart monitoring (CPU, RAM, STORAGE)
  - Easy to set up

# Overview!
    Project contains two maven modules:
  - Master - This module generates jar file that should be deployed on one machine.
    End user connect to this jar via http/https to see list of monitored vms and their live utilisation.
  - Seed - This module generate jar file that should be deployed on every linux vm in our network that should be   monitored by master.


# Master seed configuration

After deploying seeds jars on your vms you can now edit (master's)application.configuration file to provide list of seeds to the master.

example:
>#syntax is addres|friendly name|how often client can ask for refresh in seconds
>observe.servers[0]=127.0.0.1|local-machine|5
>observe.servers[1]=other-machine|radekvm|5

# How to build jar files?

```mvn install package```
