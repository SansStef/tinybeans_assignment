=================================================================================================================
Steps to build and run tinybeans_assignment project

0. Download code from repo https://github.com/SansStef/tinybeans_assignment

1. install java8 jdk https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2. install play 1.4.5 https://www.playframework.com/releases

3. add java and play to the PATH environment variable

4. install latest mysql/workbench - I used the combo installer at https://dev.mysql.com/downloads/workbench/

5. run commands in mysql workbench found in documentation/files/mysql_seed_file.sql to seed the mysql database

6. update conf/application.conf to have the url/credentials for your mysql server
eg. db.default=mysql://stefano:sansone@localhost:3306/tinybeans

7. run project on command line with: play run

8. access project at localhost:9000


=================================================================================================================
Credit Card Testing

Use test card number:
4242 4242 4242 4242
with any expiration date in the future, and any 3-digit CVC and any zip code

Test Credit Cards: https://stripe.com/docs/testing#cards
