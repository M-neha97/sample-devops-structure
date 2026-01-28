pipeline {
        agent any
        tools{
            maven "maven3"
        }
  
       //create a folder for our project
       //cd to this folder
       // pull your code from github 
       //mvn (compilation and package)
       //create docker image
       //running docker image
    


    stages {

   
        stage('Create folder for our project ') {
            steps {
                echo ' Place your git pull code here'
                sh 'mkdir -p check-balance'
            }
            
        }
        
        stage('Pull from github ') {
            steps {
                dir('check-balance') {
                    sh 'echo "Now in a new directory:"'
                    sh 'pwd' 
                    sh 'git init '
                    sh 'git pull https://github.com/iamakashk/trycatch-check-balance.git'
                    sh 'mvn --version '
                    //sh 'mvn clean package'
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
               
            }
            
        }
        
        stage('Create Docker Image') {
            steps {
                dir('check-balance') {
                    sh 'echo "build docker image"'
                    sh 'docker build -t my-app:latest .'
  
                }
                    
            }
            
        }
        
        stage('Running Docker Image') {
            steps {
                echo 'run docker image'
                sh 'docker rm -f jenkinscontainer || true'
                sh 'docker run -d -p 23000:8080 --name jenkinscontainer my-java-app:latest'
            }
        }

      

               
    }
}
