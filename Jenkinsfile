pipeline { 
    agent any 
    
    stages {
        stage('Build') { 
            steps { 
                sh 'build' 
            }
        }
        stage('test'){
            steps {
                sh 'make check'
               
            }
        }
        stage('Deploy') {
            steps {
                sh 'make publish'
            }
        }
    }
}
