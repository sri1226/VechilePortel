pipeline { 
    agent any 
    
    stages {
        stage('clone') { 
            steps { 
                 echo 'we will come back'
            }
        }
        stage('Build') { 
            steps { 
                sh "mvn clean install"
            }
        }
        stage('test'){
            steps {
                echo 'make check'
               
            }
        }
        stage('Deploy') {
            steps {
                echo 'make publish'
            }
        }
    }
}
