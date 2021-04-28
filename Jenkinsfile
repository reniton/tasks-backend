pipeline {
    agent any
    stages {
        stage('Build Projeto API'){
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests'){
            steps {
                bat 'mvn test'
            }
        }
        stage('Sonar Analysis'){
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL') {
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=9caed507afeecb76d43e5d0d5c7e555e36e653c7 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java "
                }
            }
        }
        stage('Quality Gate'){
            steps{
                sleep(20)
                timeout(time:1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Deploy API') {
            steps{
                deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPah: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage('Testes de API') {
            steps{
                dir('teste-api'){
                    git credentialsId: 'github', url: 'https://github.com/reniton/TaskService.git'
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy Sistema Web') {
            steps{
                dir('sistema-web'){
                    git credentialsId: 'github', url: 'https://github.com/wcaquino/tasks-frontend'
                    bat 'mvn clean package'
                    deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPah: 'tasks', war: 'target/tasks.war'
                }
            }
        }
        stage('Testes Funcionais') {
            steps{
                dir('teste-api'){
                    git credentialsId: 'github', url: 'https://github.com/reniton/TaskFuncional.git'
                    bat 'mvn test'
                }
            }
        }
    }
}

