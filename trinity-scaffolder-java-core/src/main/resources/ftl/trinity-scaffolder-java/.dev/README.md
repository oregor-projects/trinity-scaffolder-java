# DOCKER COMPOSE


## 
Start:

```bash
docker-compose up -d
```

Stop:

```bash
docker-compose stop
docker rm $(docker ps -a -q)
docker volume prune -f
```

## DOCKER EXEC

```bash
docker-compose stop
docker rm $(docker ps -a -q)
docker volume prune -f
```



## ACTIVEMQ

ActiveMQ expects that some configuration files already exists, so they won't be created 
automatically, instead you have to create them on your own before starting the container. 
If you want to start with the default configuration you can initialize your directories using some 
intermediate container:

```bash

docker run --user root --rm -ti \
  -v /Users/tsakostas/work/repo/interview/toptal/christos-tsakostas/.dev/activemq/conf:/mnt/conf \
  -v /Users/tsakostas/work/repo/interview/toptal/christos-tsakostas/.dev/activemq/data:/mnt/data \
  rmohr/activemq:5.15.9 /bin/sh

```

This will bring up a shell, so you can just execute the following commands inside this intermediate 
container to copy the default configuration to your host directory:

```bash
chown activemq:activemq /mnt/conf
chown activemq:activemq /mnt/data
cp -a /opt/activemq/conf/* /mnt/conf/
cp -a /opt/activemq/data/* /mnt/data/
exit
```

The last command will stop and remove the intermediate container. Your directories are now 
initialized and you can run ActiveMQ as described above.