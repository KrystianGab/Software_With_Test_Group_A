pipeline{
	agent any
	
	stages { 
		stage("Build") {
			steps {
				timeout(time: 5, unit: 'MINUTES') {
			  		bat "mvn -v"
			  		bat "mvn clean"
			  		bat "mvn compile"
					echo 'Building'
				}
			}
		}
		stage("Test") {
			steps{
				timeout(time: 10, unit: 'MINUTES') {
					bat "mvn test"
					echo 'Testing'
				}
			}
		}
	}
	
	post {
		always {
			cleanWs()
		}
	}
}
