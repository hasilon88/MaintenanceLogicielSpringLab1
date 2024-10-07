pipeline {
    agent {
        label 'AgentJava'
    }
    environment {
        ARTIFACTID = readMavenPom().getArtifact()
        VERSION = readMavenPom().getVersion()
    }
    stages {
        stage('Clean') {
            steps {
                script {
                    echo "Cleaning the project..."
                    sh 'mvn clean'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo "Running tests..."
                    sh 'mvn test'
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    echo "Compiling the project..."
                    sh 'mvn compile'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    echo "Packaging the application..."
                    sh 'mvn package'
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    echo "Building Docker image..."
                    sh "docker build . -t 172.16.189.130:8082/edu.mv/maintenance:${VERSION}"
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    echo "Logging in to Docker registry..."
                    sh "docker login -u deploy-user --password todopass 172.16.189.128:8081"
                    echo "Pushing Docker image..."
                    sh "docker push 172.16.189.130:8082/edu.mv/maintenance:${VERSION}"
                }
            }
        }
    }
    post {
        success {
            script {
                echo "Pipeline completed successfully!"
            }
        }
        failure {
            script {
                echo "Pipeline failed. Please check the logs."
            }
        }
    }
}