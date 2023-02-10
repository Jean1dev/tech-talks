	
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:9.6.1-community



docker tag nodejs-docker registry.heroku.com/nodejs-docker/web

heroku container:login
docker push registry.heroku.com/nodejs-docker/web

heroku container:release web -a produtosapi-heroku