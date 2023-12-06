pipeline {
    agent any
    environment {
        ECR_URL = '411512143549.dkr.ecr.ap-southeast-2.amazonaws.com/orderhere-app'
        IMAGE = 'orderhere-backend'
    }

    stages {
        stage('build docker image') {
            steps {
                sh 'docker -v'
                //sh 'docker login'
                sh "docker build -t ${env.IMAGE}:latest ."
            }
        }

        stage('push Docker Image') {
            steps {
                withAWS(region: 'ap-southeast-2', credentials: 'AWS login')
                sh 'ls -a'
                sh 'aws ecr orderhere-app'
                // sh 'docker tag ${env.IMAGE}:latest ${env.ECR_URL}:latest'
                // sh 'docker push ${env.ECR_URL}:latest'
            }
        }

    }
}
