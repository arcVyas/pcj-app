pipeline {
    agent {none}
    stages {
        stage('build') {
            steps {
                sh 'gradle clean build -x test'
            }
        }
    }
}