
First, we need "Node JS", "CloudBees Docker Build and publish" and "Job DSL" plugins installed in Jenkins 




At Jenkins create a new Item >> Freestyle project

At Source Code Management, insert Git Repository URL

At Build >> Add Build Step >> Process Job DSLs

DSL Scripts: job-dsl/nodejs.groovy

Build. There will be a failure (ERROR: script not yet approved for use), so go to Jenkins >> Manage Jenkins >> In-process Script Approval >> Approve

Build again
