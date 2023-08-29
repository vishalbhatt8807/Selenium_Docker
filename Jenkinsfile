pipeline{
//master executor set to 0
    agent any
    stages{
        stage('Build Jar'){
            agent{
                docker{
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps{
            //for windows put bat for mac use sh
                    bat 'mvn clean package -pSkipTests'
                }
        }
        stage('Build Image'){
            steps{
                script{
                    bat "docker build -t='vishalbhatt8807/seleniumDocker' . "
                }
            }
        }
        stage('Push image'){
            steps{
            withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]
                //sh
                 bat "docker login --username=${user} --password=${pass}"
                 bat "docker push vishalbhatt8807/seleniumdocker:latest"
                }
            }
        }
    }
}