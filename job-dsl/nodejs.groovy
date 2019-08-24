job('NodeJS example') {
    scm {
        git('git://github.com/carmargut/jenkins') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('carmargut')
            node / gitConfigEmail('carmargut@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        // I got these methods from https://jenkinsci.github.io/job-dsl-plugin/#method/javaposse.jobdsl.dsl.helpers.step.StepContext.dockerBuildAndPublish
        dockerBuildAndPublish {
            repositoryName('carmargut/nodejs-docker-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false) 
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
