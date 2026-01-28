pipeline {
    agent any // Or a specific agent label for your Windows node

    stages {
        stage('Check Directory Existence') {
            steps {
                script {
                    // Use a forward slash (/) separator for the path, which works on Windows agents
                    if (fileExists('nginx-folder')) {
                        echo "Directory 'nginx-folder' found in the workspace!"
                    } else {
                        echo "Directory 'nginx-folder' not found."
                        // Optional: Create the directory if it doesn't exist
                        bat 'mkdir nginx-folder'
                    }
                }
            }
        }


        stage('Pull Docker Image') {
            steps {
                dir('nginx-folder') {
                    bat 'echo "Pull docker image"'
                    bat 'docker pull nginx'
  
                }
                    
            }
            
        }

         stage('Running Docker Image') {
            steps {
                echo 'run docker image'
                dir('nginx-folder') {
                    bat 'echo "run docker image"'
                    bat 'docker run -d -p 10000:80 --name nginxcontainer nginx'
  
                }
            }
        }




    }
}
