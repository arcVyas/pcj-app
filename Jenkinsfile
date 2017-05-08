pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'gradle clean build -x test'
            }
        }
    }
}