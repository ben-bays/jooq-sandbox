
# What's This?

I'm playing with Jooq.  Nothing too fancy, just want to see what it can and can't do.

# How do I start that app?

You need an empty instance of postgres running.  By default, I connect to postgres on localhost:5432 using a
username of "sa" and a password of "testpwd!123".  You can override any of these properties, taking a look
at the application.yml and gradle.properties to see which tokens you can send in.

## Hey, I'm too lazy to install postgres

Me too!  Run this command if you have docker.

```
docker run --name jsx-db -p 5432:5432 -e POSTGRES_PASSWORD='testpwd!123' -e POSTGRES_USER=sa -e POSTGRES_DB=jsx -d postgres:10.1-alpine
```

## How do I clean up Postgres when I'm done with it?

Run this command:

```
docker stop jsx-db ; docker rm -v jsx-db
```


## What can I do if I don't have docker?

_Smoke bomb_


# Jooq code generation

Yeah, that's a thing.  I was going to hand write my own stuff, but oh man there's a lot of stuff you have
to typity tap.  So instead of hand rolling, I decided to fight with the code generation tool for a few hours.

What this means for you is that you need to start the database and then run this command to generate some entities. It
will run flyway migrate for you and then generate code based off of those tables.


```
./gradlew generateJooq
```