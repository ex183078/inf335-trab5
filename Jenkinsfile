pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/ex183078/inf335-trab5'

                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    junit '**target/surefire-reports/TEST - *.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
