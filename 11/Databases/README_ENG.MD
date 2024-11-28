Installation:

Docker https://www.docker.com/products/docker-desktop/ (and Linux subsystem for Windows)

DataGrip https://www.jetbrains.com/datagrip/download/#section=windows


Once the tools above are installed, in the Databases directory (zip that is attached to this post and extracted to a separate folder) run: 


docker-compose up -d



This will create a local MySQL Server docker container.

You can connect to this using DataGrip (to view the data and send SQL commands).

In DataGrip, select MySQL server, use the credentials below, and install the connectors that DataGrip suggests.


User: root

Password: progtech


Next, in the DataGrip console, execute SQL commands found in the highscores-db.sql file to create the database and the table - these are required by the Databases Java project. Once done, you should see the Highscores DB in DataGrip, with the Highscores table.



Next, open the Databases Java project in IntelliJ. Set up the classpath in the run configuration to include the 9.1 mysql connector that is included in the lib directory. In the project I linked, it should be there, with my path - make sure that it points to the right file on your machine!



Finally, run the project. It should create and handle top 3 high scores, using basic SQL queries to create and delete data.


You should use this implementation as an example for your own assignments!