pipeline {

  agent {
    //node { label 'web'}
    label 'JAVA'
  }

  stages{
        
    stage('MASTER'){
      agent{
        node {label 'Built-In Node'}
      }
      steps{
        sh 'echo Hello'
        
      }
    }

    stage('Agent NODE') {
      agent {
        node {label 'web'}
      }
      steps{
        sh 'echo HELLO'
      }
    }
  }

}
