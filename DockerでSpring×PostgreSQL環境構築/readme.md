# DockerでSpring×PostgreSQL環境構築

## 資材取得

- 実行コマンド
```
git clone https://github.com/ryomeblog/docker-spring-psql
cd docker-spring-psql
```

- 実行例
```
$ git clone https://github.com/ryomeblog/docker-spring-psql
Cloning into 'docker-spring-psql'...
remote: Enumerating objects: 120, done.
remote: Counting objects: 100% (120/120), done.
remote: Compressing objects: 100% (71/71), done.
remote: Total 120 (delta 33), reused 120 (delta 33), pack-reused 0
Receiving objects: 100% (120/120), 61.34 KiB | 2.27 MiB/s, done.
Resolving deltas: 100% (33/33), done.
$ cd docker-spring-psql
~/docker-spring-psql$
```

## サービス実行

- 実行コマンド
```
docker-compose up -d
```

- 実行例
```
$ docker-compose up -d
Creating network "docker-spring_default" with the default driver
Pulling db (postgres:14)...
14: Pulling from library/postgres
31b3f1ad4ce1: Pull complete
dc97844d0cd5: Pull complete
9ad9b1166fde: Pull complete
286c4682b24d: Pull complete
1d3679a4a1a1: Pull complete
5f2e6cdc8503: Pull complete
0f7dc70f54e8: Pull complete
a090c7442692: Pull complete
81bfe40fd0f6: Pull complete
8ac8c22bbb38: Pull complete
96e51d1d3c6e: Pull complete
667bd4154fa2: Pull complete
87267fb600a9: Pull complete
...省略
Creating swagger-api     ... done
Creating test-postgres  ... done
Creating swagger-ui      ... done
Creating swagger-editor  ... done
Creating tmp-spring-boot ... done
```
