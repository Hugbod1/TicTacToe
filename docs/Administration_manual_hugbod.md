Computer Department								
Hugb�na�arf��i -
Late-term Assignment 

#### Hugbo�

----

![RU logo](http://www.ru.is/skin/basic9k/i/sitelogo.png)



## Administration Manual

#### About
In the administration manual you will find how to build and deploy the project. To do that you should first set git up on your computer. 

##### Versioning the releases
The development releases will follow the method x.y.z, which correspond to major.minor.patch.

- Major version numbers change whenever there is some significant changes to the software.
- Minor version numbers change when new and minor feature is introduced.
- Patch numbers change when a new build of the software is released to customers, like bug fixes.

Example: 	
- Major version - 1.0.0
- Minor version - 0.1.0
- Patch version - 1.0.1

#### Build before deploy

The first thing you need to is to clone the git repository for the project into your computer, use the following command:
```
git clone https://github.com/Hugbod1/TicTacToe.git
```

Before you deploy the project always make sure that you have the latest update of the code. 
To do that type in following command:
```
git pull
```
And of course build it as well to make sure everything works as it should be:
```
bin/build
```

#### Deploy

The only thing to do now is to deploy the project. 
When you deploy the project it will automatically go to a open source in Dopbox.

Lets start!

Make sure that you are in the root of the Tic Tac Toe repository. 
Then type the following: 
```
bin/deploy
```
You will have to enter the version number of the game. Make sure that to follow the above rules of versioning the releases. 
```
Enter version >
```
(To find out what releases are available right now click on this [link](https://www.dropbox.com/sh/8rknsxvnt42uys9/AADE8jwp3OeIsrqxbmH44PB7a?dl=0).)


You have deployed the game and it is now available [here](https://www.dropbox.com/sh/8rknsxvnt42uys9/AADE8jwp3OeIsrqxbmH44PB7a?dl=0)!



---
*Copyright � 2015 - Hugbo� Development*
