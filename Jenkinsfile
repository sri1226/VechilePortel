pipeline { 
    agent any 
    
    stages {
        stage('clone') { 
            steps { 
                sh 'checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sri1226/VechilePortel.git']]])' 
            }
        }
        stage('Build') { 
            steps { 
                sh 'mvn clean install' 
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
