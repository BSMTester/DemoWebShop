pipeline{
	agent any

	environment {
	//MAVEN_HOME = "/user/share/maven"
	JIRA_SITE = 'bsmmobile18.atlassian.net'
	}
	stages{
		stage('Checkout'){
			steps{
				echo 'Checking out code from GitHub...'
				//git branch: 'master', url: 'https://github.com/Madhu-smb/DemoWebShop.git'
				checkout scm
			}
		}
		stage('Build'){
			steps{
				echo 'Building DemoWebShop Project...'
				//sh 'mvn clean install -DskipTests'
				bat 'mvn clean compile'
			}
		}
		stage('Test'){
			steps{
				echo 'Running tests...'
				sh 'mvn test'
			}
			//post{
			//	always{
			//		junit '**/target/surefire-reports/*.xml'
			//	}
			//}
		}
		stage('Archive Artifacts'){
			steps{
				echo 'Archive Artifacts...'
				archiveArtifacts artifacts: '**/target/*.jar', fingerprint:true
			}
		}
		stage('Deploy'){
			steps{
				echo 'Deploy stage -customize as needed'
			}
		}
	}
	post{
		//always{
		//	JiraSendBuildInfo()
		//}
		success{
			echo 'Pipeline completed succesfully!'
			jiraSendBuildInfo site: 'bsmmobile18.atlassian.net'	
		}
		failure{
			echo 'Pipeline failed. Check logs.'
			jiraSendBuildInfo site: 'bsmmobile18.atlassian.net'
		}
	}
 }
