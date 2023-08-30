pipeline{
//master executor set to 0
    agent any
    stages{
        stage('Build Jar'){
            agent{
                docker{
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps{
            //for windows put bat for mac use sh
                    sh 'mvn clean package -pSkipTests'
                }
        }
        stage('Build Image'){
            steps{
                script{
                    app = docker.build('vishalbhatt8807/seleniumDocker')
                }
            }
        }
        stage('Push image'){
        //sh
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com','Dockerhub'){
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }
}