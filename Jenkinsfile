pipeline {
    agent any
    stages {
        stage('Build Projeto API'){
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}