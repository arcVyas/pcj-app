pipeline {
  agent any
  stages {
    stage('Initiallize') {
      steps {
        echo 'Jenkins Pipeline'
        sh '''export PATH=$PATH:$GRADLE_HOME
echo $PATH'''
      }
    }
    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage('Test') {
      steps {
        junit 'build/test-results/test/*.xml'
      }
    }
    stage('Quality Check') {
      steps {
        withSonarQubeEnv('Sonar') {
          sh './gradlew sonarqube -x test'
        }
      }
    }
    stage('Quality Gate') {
      steps {
        waitForQualityGate()
      }
    }
  }
}