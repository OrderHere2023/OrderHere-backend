pipeline {
    agent any
    environment {
        ECR_URL = '411512143549.dkr.ecr.ap-southeast-2.amazonaws.com/orderhere-app'
        IMAGE = 'orderhere-backend'
        TAG = 'test-lawbb '
    }

    stages {
        stage('build docker image') {
            steps {
                
                sh 'docker -v'
                
                sh "docker build -t ${env.IMAGE}:${env.TAG} ."
            }
        }

        stage('push Docker Image') {
            steps {
                withAWS(region: 'ap-southeast-2', credentials: 'AWS login'){
                    sh 'ls -a'
                    sh 'aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 411512143549.dkr.ecr.ap-southeast-2.amazonaws.com/orderhere-app'
                    sh "docker tag ${env.IMAGE}:latest ${env.ECR_URL}:${env.TAG}"
                    sh "docker push ${env.ECR_URL}:${env.TAG}"
                }
                
            }
        }

    }
}
