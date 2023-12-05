pipeline {
    agent any

    stages {
        stage('Download Dependencies') {
            steps {
                sh 'gradle -v'
                sh './gradlew '
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'ls -a'
                //sh 'docker build -t <YourDockerImageName> .'
            }
        }

        stage('Push to AWS ECR') {
            steps {
                sh 'ls -a'
                // withAWS(region: '<YourAWSRegion>') {
                //     sh 'eval $(aws ecr get-login --no-include-email)'
                //     sh 'docker tag <YourDockerImageName>:latest <YourECRRepository>:latest'
                //     sh 'docker push <YourECRRepository>:latest'
                // }
            }
        }
    }
}
