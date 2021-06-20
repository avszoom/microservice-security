# microservice-security

We are setting up simple form based authentication, and validating user based on credential he provided against in memorty H2 data store. 
We have also implemented basic authorization , so certain urls are access by some user while some are not.

URLs available - 

/ - avaiable for any user
/user - access only for USER,ADMIN ROLE
/admin - access only for ADMIN
/logout

install -

Simply build this project using maven. Run jar vi java -jar command.
