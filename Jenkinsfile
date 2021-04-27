pipeline {
    agent any
    stages {
        stage('Build Projeto API'){
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
    }
}