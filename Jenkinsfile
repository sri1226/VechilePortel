pipeline { 
    agent any 
    
    stages {
        stage('Build') { 
            steps { 
                echo 'build' 
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
