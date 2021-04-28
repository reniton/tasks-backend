pipeline {
    agent any
    stages {
        stage('Build Projeto API'){
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Testes Unitários'){
            steps {
                bat 'mvn test'
            }
        }
    }
}