Computer Department								
Hugbúnaðarfæði -
Late-term Assignment 

#### Hugboð

----

![RU logo](http://www.ru.is/skin/basic9k/i/sitelogo.png)



## Administration Manual

##### About
In the administration manual you will find how to build and deploy the project. To do that you should first set git up on your computer. 

##### Versioning the releases
The development releases will follow the method x.y.z., which correspond to major.minor.patch.

- Major version numbers change whenever there is something significant changes to the software.
- Minor version numbers change when new and minor feature is introduced.
- Patch numbers change when a new build of the software is released to customers, like bug fixes.

Example: 	
			- Major version, available for users - 1.0.0.
			- Minor version, only for beta testing - 0.1.0.
			- Patch version, available for users - 1.0.1.
			

##### Build before deploy
Create [Github](https://github.com) account if you don't already have one. 

You then need to clone the git repository into your computer by typing the following command in your terminal: 
```
git clone https://github.com/Hugbod1/TicTacToe.git
```

Make sure that you can compile the project before deploy it. Install java 1.8 on your computer to build and run it.

To install java, type the following into your terminal window:
```
sudo apt-get install oracle-java8-installer
```
You can verify the verstion with the following command:
```
java -version
```

Make also sure that you have the updated version of Java Development Kit (JDK) on your computer. You can install it [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Choose the desired kit according to the software you are working on.

##### Deploy
The only thing to do now is to deploy the project. When you deploy the project it will automatically go to a open source in Dopbox.

Lets start!
Make sure you are in the root of the Tic Tac Toe repository. 
Then type the following: 
```
bin/deploy
```
You will have to enter the version number of the game. Make sure that to follow the above rules of versioning the releases. (To find out what releases are available right now click on this link.)

You have now deployed the game and it is now available [here](link to dropbox)!







---
*Copyright © 2015 - Hugboð Development*