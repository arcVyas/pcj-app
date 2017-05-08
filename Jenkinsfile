pipeline {
    agent {}
    stages {
        stage('build') {
            steps {
                sh 'gradle clean build -x test'
            }
        }
    }
}