pipeline {
   
    stages {  
    	stage('Checkout code') {
    	agent any
        steps {
            checkout scm
        	}
    	}
      
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
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