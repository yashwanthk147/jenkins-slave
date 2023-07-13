pipeline {

  agent {
    //node { label 'web'}
    //label 'JAVA'
    none
  }

  stages{
        
    stage('MASTER'){
      agent{
        //node {label 'Built-In Node'}
        label 'MASTER'
      }
      steps{
        sh 'echo Hello'
        
      }
    }

    stage('Agent NODE') {
      agent {
        //node {label 'web'}
        label 'JAVA'
      }
      steps{
        sh 'echo HELLO'
      }
    }
  }

}
