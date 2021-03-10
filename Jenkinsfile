pipeline{
	agent{
		docker{
			image "maven:3.6.3-jdk-11"
		}
	}
	
	stages { 
		stage("Build") {
			steps {
				sh "mvn - version"
				sh "mvn clean install"
				echo 'Building'
			}
		}
		stage("Test") {
			steps{
			
				echo 'Testing'
			}
		}
	}
	
	post {
		always {
			cleanWs()
		}
	}
}