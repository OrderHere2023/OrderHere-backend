pipeline {
    agent any
    environment {
        ecr-repoURL = '411512143549.dkr.ecr.ap-southeast-2.amazonaws.com/orderhere-app'
        image = 'orderhere-backend'
    }

    stages {
        stage('build docker image') {
            steps {
                sh 'docker -v'
                sh 'docker build -t ${env.image}:latest .'
            }
        }

        stage('push Docker Image') {
            steps {
                withAWS(region: 'ap-southeast-2', credentials: 'AWS login')
                sh 'ls -a'
                sh 'aws ecr orderhere-app'
                // sh 'docker tag ${env.image}:latest ${env.ecr-repoURL}:latest'
                // sh 'docker push ${env.ecr-repoURL}:latest'
            }
        }

    }
}
