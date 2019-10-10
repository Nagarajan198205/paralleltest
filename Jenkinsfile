pipeline {
    agent any
    stages {  
    	stage('Checkout code') {
        steps {
            checkout scm
        	}
    	}
      
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:1.3.5'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                      
                      app = docker.build("07551552868/containerparalleltest")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://cloud.docker.com', 'dockerhub') {
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }        
    }
}