pipeline {
    agent any // Or a specific agent label for your Windows node

    stages {
        stage('Check Directory Existence') {
            steps {
                script {
                    // Use a forward slash (/) separator for the path, which works on Windows agents
                    if (fileExists('check-balance')) {
                        echo "Directory 'check-balance' found in the workspace!"
                    } else {
                        echo "Directory 'check-balance' not found."
                        // Optional: Create the directory if it doesn't exist
                        bat 'mkdir check-balance'
                    }
                }
            }
        }

         stage('Pull from github ') {
            steps {
                dir('check-balance') {
                    bat 'echo "Now in a new directory:"'
                    bat 'cd' 
                    bat 'git init '
                    bat 'git pull https://github.com/iamakashk/trycatch-check-balance.git'
                    bat 'mvn --version '
                    bat 'mvn clean package'
                    //bat "mvn -Dmaven.test.failure.ignore=true clean package"
                }
               
            }
            
        }

        stage('Create Docker Image') {
            steps {
                dir('check-balance') {
                    bat 'echo "build docker image"'
                    bat 'docker build -t my-app:latest .'
  
                }
                    
            }
            
        }

         stage('Running Docker Image') {
            steps {
                echo 'run docker image'
                dir('check-balance') {
                    bat 'echo "build docker image"'
		    bat 'docker rm -f jenkinscontainer || ver > nul'
                    bat 'docker run -d -p 22000:8080 --name jenkinscontainer my-app:latest'
  
                }
            }
        }




    }
}
