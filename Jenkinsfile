pipeline {
  agent any
  stages {
    stage('Initiallize') {
      steps {
        echo 'Jenkins Pipeline'
      }
    }
    stage('Build') {
      steps {
        sh '/opt/gradle/gradle-3.4.1/bin/gradle clean build'
      }
    }
    stage('Test') {
      steps {
        junit 'build/test-results/test/'
      }
    }
    stage('Quality Check') {
      steps {
        sh '/opt/gradle/gradle-3.4.1/bin/gradle sonarqube -x test'
      }
    }
  }
}