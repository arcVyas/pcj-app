pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh '/opt/gradle/gradle-3.4.1/bin/gradle clean build -x test'
            }
        }
    }
}