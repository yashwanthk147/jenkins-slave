folder('CI-Pipelines-1') {
  displayName('CI-Pipelines-1')
  description('CI-Pipelines-1')
}

/*pipelineJob('CI-Pipelines/Jenkins') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/yashwanthk147/jenkins-slave.git')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('main')
          }
        }
      }
      'scriptPath'('CI-Pipelines/Jenkinsfile')
      'lightweight'(true)
    }
  }
}*/


def component = ["web1", "web2","web3"];

def count=(component.size()-1)
for (i in 0..count) {
  def j=component[i]
  pipelineJob("CI-Pipelines-1/${j}") {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'('https://github.com/yashwanthk147/jenkins-slave.git'+j)
              //'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
            }
          }
          //'branches' {
            //'hudson.plugins.git.BranchSpec' {
              //'name'('*/tags/*')
            //}
            'hudson.plugins.git.BranchSpec' {
              'name'('*/main')
            }
          }
        }
        'scriptPath'('Jenkinsfile')
        'lightweight'(true)
      }
    }
  }
}