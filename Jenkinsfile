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
        sh '/opt/gradle/gradle-3.4.1/bin/gradle clean build -x test'
      }
    }
  }
}