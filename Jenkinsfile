pipeline {
    agent any
    environment {
        MAVEN_HOME = tool 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn compile"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn package"
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the Project'
                // Add deployment steps here to AWS
            }
        }
    }
}