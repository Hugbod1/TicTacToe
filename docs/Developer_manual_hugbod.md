Computer Department								
Hugbúnaðarfæði -
Late-term Assignment 

#### Hugboð

----

![RU logo](http://www.ru.is/skin/basic9k/i/sitelogo.png)



## Development Manual

##### About

In the development manual you will find the following: 
- Where you can access the source code
- What tools were used in this project
- What environment this project is build on
- What kind of testing were made
- How to build the project

##### Source Control Client
[Github](https://github.com) is used to support the tools, libraries, documentation and everything else related to this project.
##### Source code
The source code, on Github, can be found here [Hugboð - TicTacToe](https://github.com/Hugbod1/TicTacToe.git)
##### Build environment:

To build the project on your favourite Linux bash you will need to:
- install Java 1.8
- have a Github account
- install git on the computer 

To install java, type the following into your terminal window:
```
sudo apt-get install oracle-java8-installer
```
Next, install git on your computer:

```
sudo apt-get install git
```

When installation is complete, you have to configure your settings using the two following command:
```
git config --global user.name "name here"
```
Then type:
```
git config --global user.email "yourEmail@example.is"
```

After those steps you will have to generate the SSH key by typing:
```
ssh-keygen -t rsa -C "yourEmail@example.is"
```

You can find your SSH key with the following two commands:
```
cd ~/.ssh
```
```
vim id_rsa.pub
```
The next thing that is needed to be done is to paste the SSH key on Github. To do that, go to your Github account in your browser, go to settings and find SSH keys, in there you will see a button that says ,,Add SSH key".

When your are done with that, clone the git repository for the project into your computer, use the following command:
```
git clone https://github.com/Hugbod1/TicTacToe.git
```

Now you can start working on that project.

You should try to test- and build the project with the command:
```
bin/package
```
Then can run it by typing:
```
bin/run
```

It as simple as that. 

##### Tools

[Gradle](https://docs.gradle.org/current/userguide/build_environment.html) is used to execute the builds in this project. Gradle is consistent environment that can optimize the speed. 

For continuous integration, [Travis](https://travis-ci.org/) was is to build and test the project that is hosted at GitHub.
To access Travis, request access to become collaborator.


###### Unit test
TDD (Test Driven Development) where made through the whole process using unit tests. Unit testing is a part of the build process and it is important that they run fast, they are short code fragments that are created by the programmers.

---
*Copyright © 2015 - Hugboð Development*