# Final Capstone
​
This directory contains all of the starter projects for the final capstone. 
​ 
Each project contains instructions that provides information about the starting code and explains how to get started with the final capstone project. 

# Instructions for Running Project
Instructions Written by Samantha Vanderburgh /b
Project created by Anna Castano, Alex Ellington, Henry Fossett and Samantha Vanderburgh at Tech Elevator Coding Bootcamp under the instruction of Michael Levy in Cincinnati, Ohio /b
Special Thanks To: Academic Fellow Alumni Evan Amezcua and Robyn Florentz, our Instructor Michael Levy, our Pathway Director Carly Trimboli, and our Campus Director Monica Royal-Fischer

## Introduction
Several programs need to be installed to host this website locally from your computer, including a database management system, an integrated development environment, and a server environment.

## Part 1: Install Required Programs
Required programs: Node.js and Node Package Manager (npm), PostgreSQL (Postgres), IntelliJ IDEA (IntelliJ), Visual Studio Code

### Functionality 
Node.js: used with Node Package Manager (npm) to manage JavaScript packages and their dependencies
Postgres: the database management system that runs the database script containing saved account information
IntelliJ: runs the Java application
VSC: the VSC Server runs on our remote development machine, which is the desktop PC or virtual machine (VM) being used

### Links to Downloads
Node.js: https://nodejs.org/en/download/
Postgres: https://www.postgresql.org/download/
IntelliJ: https://www.jetbrains.com/help/idea/installation-guide.html, https://www.jetbrains.com/idea/download/?fromIDE=#section=mac
VSC: https://code.visualstudio.com/download

### Installation Procedures
Installation procedures will vary depending on your machine; make sure to install a version of each software that is compatible with your operating system. 
Troubleshooting with Node.js and npm on a Mac: ensure the Postgres tools folder is located in the PATH variable so the database script can run by creating a bash profile and modifying the path variable in it.

## Part 2: Run data and server to view the webpage

### Outline of Project Instructions
NPM:
  i. install npm
Postgres:
	a. Start Postgres
IntelliJ:
	b. Run database script		
		cd database/
		sh create.sh
	c. Run Application
Visual Studio Code:
	d. Start server
		cd vue/
		npm run serve
Browser:
	e. Visit website
		localhost:8080

### Detailed Project Instructions
#### 1. Download the project from Github
  Tools: File Explorer/Finder and Terminal

a. Visit https://github.com/vandsama/tech.elevator.final.capstone.pet.pals
b. Click the <>Code button and copy the HTTPS link
c. Open your Terminal and go to your Users folder, e.g., /Users/Samantha
-Navigating the terminal: "cd .." to go back, "ls" to list contents of the present directory, "pwd" to show the present directory you're in, "cd 'folder name'" to enter a folder
d. Create a folder for your projects, e.g., IdeaProjects. This can also be done from File Explorer
e. Navigate to your Projects folder from your terminal and type "git clone https://github.com/vandsama/tech.elevator.final.capstone.pet.pals.git" and hit enter
f. Verify the project is now installed locally on your computer in your Projects folder by visiting your File Explorer or Finder

#### 2. Install npm for this project 
*Note* This needs to be done the first time a project is run locally.
    Tools: IntelliJ and Node.js
    
a. Open IntelliJ
b. Open the Pet Pals project java file from IntelliJ, e.g., Users/Samantha/IdeaProjects/tech.elevator.final.capstone.pet.pals/java
c. Open the terminal from IntelliJ and verify you're in the java file location, e.g. Users/Samantha/IdeaProjects/tech.elevator.final.capstone.pet.pals/java by typing "pwd" enter
d. Type "npm install" and read the terminal to ensure it installs correctly

#### 3. Start Postgres
*Note* Postgres can slow down your computer, so ensure it doesn't open on Startup and only run this program when in use
    Tools: Postgres
    
a. Open Postgres 
    
#### 4. Run database script
*Note* Ensure once the script is ran that it ends in lines with words like "INSERT", "COMMIT", "CREATE ROLE" and "GRANT". If these words do not show, run the script again
    Tools: terminal or IntelliJ
    
a. Right-click the create.sh file (java [final-capstone-starter] > database > create.sh) and select "Run 'create.sh'"
b. Alternatively navigate to the database folder from the terminal and type "sh create.sh"
-To ensure you're in the correct folder, type "pwd" to show the present working directory

#### 5. Run the application
    Tools: IntelliJ

a. From IntelliJ, scroll down in the navigation pane and right-click the Application and select "Run 'Application.main()'" (java [final-capstone-starter] > src > main > java > com.techelevator > security > Application)
b. The terminal in IntelliJ should display about 20 or so lines of code and end in, e.g., ": Started Application in 7.396 seconds (JVM running for 9.586)"

#### 6. Start the server
*Note* A port needs to be available on your computer - you can visit your Activity Monitor and close open ports if necessary
    Tools: terminal
    
a. Navigate to the vue folder in the project from the terminal and type "npm run serve" then hit enter
b. The terminal should respond with a message to view the open server at a local port if it compiled successfully, e.g.: "  App running at:
  - Local:   http://localhost:8080/ 

#### 7. Visit the website
*Note* Ensure you visit "http://..." and **not** "http**s**://..."
    Tools: browser
    
a. Paste the local port into the browser to view the webpage


##### If you have any suggestions to improve these instructions for followability or have any questions or need help setting up your machine, please do not hesitate to contact me at vandsama@gmail.com
##### Thank you for reading these instructions and viewing our project!


