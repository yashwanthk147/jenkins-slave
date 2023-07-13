folder('CI-Pipelines') {
  displayName('CI-Pipelines')
  description('CI-Pipelines')
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


def component = ["cart", "catalogue","user","payment","shipping","frontend"];

def count=(component.size()-1)
for (i in 0..count) {
  def j=component[i]
  pipelineJob("CI-Pipelines/${j}") {
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