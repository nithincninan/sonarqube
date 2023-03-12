# Sonarqube

* Install sonarqube via docker (recommend using Docker Engine version 20.10 and above.)

  - Run docker-compose up -d
  - Once your instance is up and running, Log in to http://localhost:9000
  - login: admin / password: admin
  
    ![sonar-local-docker](https://user-images.githubusercontent.com/2525741/224569720-eede1a99-b7d0-41d1-9b5e-c55f6d974441.jpg)
    
    Refer: 
  - https://docs.sonarqube.org/latest/setup-and-upgrade/install-the-server/
  - https://docs.sonarqube.org/9.6/requirements/prerequisites-and-overview/#platform-notes

    Note: If any issues with max_map_count increase this value to "524288"  
    ```- /var/www/sonarqube$ sysctl vm.max_map_count
            vm.max_map_count = 65530 
    
       - /var/www/sonarqube$ sudo sysctl -w vm.max_map_count=524288
           [sudo] password for user:
           vm.max_map_count = 524288
    
       - /var/www/sonarqube$ sysctl vm.max_map_count
            vm.max_map_count = 524288

       - /var/www/sonarqube$ sysctl -p
          (reload sonarqube)```
    
*  Add Custom Rule/Plugin for sonar-php:

   - Install Intellij 
   - Add JDK latest version/ Use in-built Oracle JDK
   - Use the current Custom code with Java/Maven build system in Intellij.
   - Write custom rules and create plugin (https://docs.sonarqube.org/9.6/analyzing-source-code/languages/php/#custom-rules) 
   - Once done, Use maven clean/install command or run from Intellij. So that jar/target file will generate.
   - Put the downloaded jar in <SONARQUBE_HOME>/extensions/plugins, and remove any previous versions of the same plugins.
   - Restart your SonarQube server.
   - Test the custom rule(php) in http://localhost:9000


  - Add EmptyCatchCheck rule for sonar php plugin ("Empty CATCH statement must have a comment to explain why the exception is not handled")          
     - src/main
     - src/test	

  
